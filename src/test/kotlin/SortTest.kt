import com.codeborne.selenide.Selenide
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import pages.MainPage
import pages.SearchResultsPage
import java.time.LocalDate

class SortTest {

    @BeforeEach
    fun search() {
        MainPage()
            .open()
            .searchBar
            .search(
                destination = "San Francisco",
                checkInDate = LocalDate.now().plusDays(1),
                checkOutDate = LocalDate.now().plusDays(2)
            )
    }
    @AfterEach
    fun clearCookies() {
        Selenide.clearBrowserCookies()
    }

    @Test
    fun `sort hotels by price`() {
        val prices = SearchResultsPage()
            .sort
            .sortBy("Price (lowest first)")
            .hotels
            .map { it.price }
        assertThat(prices).isEqualTo(prices.sorted())
    }

    @Test
    fun `sort hotels by rating ASC`() {
        val scores = SearchResultsPage()
            .sort
            .sortBy("Property rating (low to high)")
            .hotels
            .map { it.rating }
        assertThat(scores).isEqualTo(scores.sorted())
    }
}