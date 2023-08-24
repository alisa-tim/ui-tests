package helpers

import com.codeborne.selenide.WebDriverProvider
import org.openqa.selenium.Capabilities
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

class DriverProvider : WebDriverProvider {
    override fun createDriver(capabilities: Capabilities): WebDriver {

        val chromeOptions = ChromeOptions()

        if (System.getProperty("platform") == "mobile") {
            val deviceMetrics: HashMap<String, Any> = HashMap()
            deviceMetrics["width"] = 1170
            deviceMetrics["height"] = 2532
            deviceMetrics["pixelRatio"] = 3.0
            val mobileEmulation = HashMap<String, Any>()
            mobileEmulation["deviceMetrics"] = deviceMetrics
            mobileEmulation["userAgent"] =
                "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19"
            chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation)
        }

        return ChromeDriver(chromeOptions)

    }
}