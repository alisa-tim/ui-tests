import BaseTest.Companion.pages
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDate

class SortTest : BaseTest {

    @BeforeEach
    fun search() {
        pages.mainPage
            .open()
            .searchBar
            .search(
                destination = "San Francisco",
                checkInDate = LocalDate.now().plusDays(1),
                checkOutDate = LocalDate.now().plusDays(2)
            )
    }

    @Test
    fun `sort hotels by price`() {
        val prices = pages.searchResultsPage
            .sortBy("Price (lowest first)")
            .hotels
            .map { it.price }
        assertThat(prices).isEqualTo(prices.sorted())
    }

    @Test
    fun `sort hotels by rating ASC`() {
        val scores = pages.searchResultsPage
            .sortBy("Property rating (low to high)")
            .hotels
            .map { it.rating }
        assertThat(scores).isEqualTo(scores.sorted())
    }
}