package pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selectors
import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.SelenideElement
import containers.Filter
import containers.SearchBar
import containers.Sort
import java.time.Duration

class SearchResultsPage {

    init {
        element(Selectors.by("data-testid", "overlay-spinner")).should(Condition.disappear, Duration.ofSeconds(5))
    }

    val filter = Filter()
    val sort = Sort()
    val searchBar = SearchBar()
    val hotels
        get() = elements(Selectors.by("data-testid", "property-card")).map { Hotel(it) }

    class Hotel(val container: SelenideElement) {
        val location
            get() = container.find(Selectors.by("data-testid", "address")).text()
        val price
            get() = container.find(Selectors.by("data-testid", "price-and-discounted-price")).text().filter { it.isDigit() }.toInt()
        val rating
            get() = container
                .find(Selectors.by("data-testid", "review-score"))
                .find("div:first-child").text().toDouble()
    }
}