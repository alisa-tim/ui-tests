package pageObject.desktop.pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selectors
import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.SelenideElement
import pageObject.desktop.containers.Filter
import pageObject.desktop.containers.SearchBar
import pageObject.desktop.containers.Sort
import interfaces.AbstractHotel
import interfaces.AbstractSearchResultsPage
import java.time.Duration

class SearchResultsPage : AbstractSearchResultsPage {

    init {
        element(Selectors.by("data-testid", "overlay-spinner")).should(Condition.disappear, Duration.ofSeconds(5))
    }

    override val filter = Filter()
    override val searchBar = SearchBar()
    override val hotels
        get() = elements(Selectors.by("data-testid", "property-card")).map { Hotel(it) }

    class Hotel(val container: SelenideElement) : AbstractHotel {
        override val location
            get() = container.find(Selectors.by("data-testid", "address")).text()
        override val price
            get() = container.find(Selectors.by("data-testid", "price-and-discounted-price")).text().filter { it.isDigit() }.toInt()
        override val rating
            get() = container
                .find(Selectors.by("data-testid", "review-score"))
                .find("div:first-child").text().toDouble()
    }

    override fun sortBy(order: String) = Sort().sortBy(order)
}