package pageObject.mobile.pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selectors
import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.SelenideElement
import interfaces.AbstractHotel
import interfaces.AbstractSearchResultsPage
import pageObject.mobile.containers.Filter
import pageObject.mobile.containers.SearchBar
import pageObject.mobile.containers.Sort
import java.time.Duration

class SearchResultsPage : AbstractSearchResultsPage {

    init {
        element(".js-is-loading").shouldBe(Condition.disappear, Duration.ofSeconds(5))
    }

    override val filter = Filter()
    override val searchBar = SearchBar()
    override val hotels
        get() = elements(Selectors.by("data-testid", "property-card")).map { Hotel(it) }

    class Hotel(val container: SelenideElement) : AbstractHotel {
        override val location
            get() = container.find(Selectors.by("data-testid", "location"))
                .find("span:last-child")
                .text()
        override val price
            get() = container.find(Selectors.by("data-testid", "price-and-discounted-price")).text().filter { it.isDigit() }.toInt()
        override val rating
            get() = container
                .find(Selectors.by("data-testid", "review-score"))
                .find("div > div").text().toDouble()
    }

    override fun sortBy(order: String) = Sort().sortBy(order)
}