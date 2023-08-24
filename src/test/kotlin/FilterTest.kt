import BaseTest.Companion.pages
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.time.LocalDate

class FilterTest : BaseTest {

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

    @ParameterizedTest(name = "filter hotels by score: {arguments}")
    @ValueSource(strings = ["Wonderful: 9+", "Very Good: 8+", "Good: 7+", "Pleasant: 6+"])
    fun `filter hotels with score`(score: String) {
        pages.searchResultsPage
            .filter
            .byReviewsScore(score)
            .hotels
            .forEach {
                assertThat(it.rating).isGreaterThanOrEqualTo(score.filter { it.isDigit() }.toDouble())
            }
    }
}