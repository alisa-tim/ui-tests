import BaseTest.Companion.pages
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import pageObject.desktop.pages.SearchResultsPage
import java.time.LocalDate

class SearchTest : BaseTest {

    @Test
    fun `search by location`() {
        pages
            .mainPage
            .open()
            .searchBar
            .search(
                destination = "San Jose",
                checkInDate = LocalDate.now().plusDays(1),
                checkOutDate = LocalDate.now().plusDays(2)
            )
        pages.searchResultsPage
            .hotels
            .forEach { assertThat(it.location).contains("San Jose") }
    }

    @Test
    fun `change destination from results page`() {
        pages
            .mainPage
            .open()
            .searchBar
            .search(
                destination = "San Jose",
                checkInDate = LocalDate.now().plusDays(1),
                checkOutDate = LocalDate.now().plusDays(2)
            )
        pages.searchResultsPage
            .searchBar
            .clearDestination()
            .search(
                destination = "San Francisco",
                checkInDate = LocalDate.now().plusDays(1),
                checkOutDate = LocalDate.now().plusDays(2)
            )
        pages.searchResultsPage
            .hotels
            .forEach { assertThat(it.location).contains("San Francisco") }
    }
}