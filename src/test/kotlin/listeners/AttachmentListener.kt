package listeners

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.WebDriverRunner.getWebDriver
import io.qameta.allure.Allure
import io.qameta.allure.listener.TestLifecycleListener
import io.qameta.allure.model.Status
import io.qameta.allure.model.TestResult
import org.openqa.selenium.OutputType
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.devtools.v115.page.Page
import org.openqa.selenium.devtools.v115.page.model.Viewport
import java.io.ByteArrayInputStream
import java.util.*

class MyListener : TestLifecycleListener {
    override fun beforeTestStop(result: TestResult) {
        if (result.status == Status.FAILED || result.status == Status.BROKEN) {
            Allure.addAttachment(
                "screenshot",
                ByteArrayInputStream(Selenide.screenshot(OutputType.BYTES))
            )
        }
    }

    fun captureFullSizeScreenshot(): ByteArray {
        val driver: ChromeDriver = getWebDriver() as ChromeDriver
        val devTools = driver.devTools
        devTools.createSession()
        val pageRect = driver.executeCdpCommand("Page.getLayoutMetrics", mapOf())
        val contentSize = pageRect["contentSize"] as Map<String, Int>
        val image: String = devTools.send(
            Page.captureScreenshot(
                Optional.empty(),
                Optional.empty(),
                Optional.of(Viewport(0, 0, contentSize["width"], contentSize["height"], 1)),
                Optional.empty(),
                Optional.of(true),
                Optional.empty()
            )
        )
        return Base64.getDecoder().decode(image)
    }
}


