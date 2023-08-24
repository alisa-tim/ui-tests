import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import helpers.DriverProvider
import interfaces.PageFactory
import pageObject.mobile.MobilePageFactory
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import pageObject.desktop.DesktopPageFactory


interface BaseTest {

    companion object{

        val pages = when (System.getProperty("platform")) {
            "mobile" -> MobilePageFactory
            "desktop" -> DesktopPageFactory
            else -> throw Error("Platform is not defined")
        }

        @BeforeAll
        @JvmStatic
        fun configure() {
            Configuration.browser = DriverProvider::class.java.name
            Configuration.timeout = 10000
            Configuration.baseUrl = "https://www.booking.com"
            Configuration.screenshots = false
            Configuration.savePageSource = false
        }
    }

    @AfterEach
    fun clearCookies() {
        println("clear cookies")
        Selenide.clearBrowserCookies()
    }
}