import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import pages.MainPage
import pages.SearchResultsPage
import java.time.LocalDate

class SearchTest : BaseTest{

    @Test
    fun `search by location`() {
        MainPage()
            .open()
            .searchBar
            .search(
                destination = "San Jose",
                checkInDate = LocalDate.now().plusDays(1),
                checkOutDate = LocalDate.now().plusDays(2)
            )
        SearchResultsPage()
            .hotels
            .forEach { assertThat(it.location).contains("San Jose") }
    }

    @Test
    fun `change destination from results page`() {
        MainPage()
            .open()
            .searchBar
            .search(
                destination = "San Jose",
                checkInDate = LocalDate.now().plusDays(1),
                checkOutDate = LocalDate.now().plusDays(2)
            )
        SearchResultsPage()
            .searchBar
            .clearDestination()
            .search(
                destination = "San Francisco"
            )
        SearchResultsPage()
            .hotels
            .forEach { assertThat(it.location).contains("San Francisco") }
    }
}