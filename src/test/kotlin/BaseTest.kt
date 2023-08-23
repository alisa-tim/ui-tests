import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll


interface BaseTest {

    companion object{
        @BeforeAll
        @JvmStatic
        fun configure() {
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