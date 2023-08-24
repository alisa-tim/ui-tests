package pageObject.mobile.containers

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selectors
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.sleep
import interfaces.AbstractSearchBar
import io.qameta.allure.Step
import java.time.Duration
import java.time.LocalDate

class SearchBar : AbstractSearchBar {

    @Step
    override fun search(destination: String, checkInDate: LocalDate, checkOutDate: LocalDate) {
        element(Selectors.by("placeholder", "Around current location")).value = destination
        sleep(1000)
        element(Selectors.by("data-testid", "autocomplete-results-options")).shouldBe(Condition.visible, Duration.ofSeconds(5))
        element(Selectors.by("data-testid", "autocomplete-result")).click()
        Calendar().pickDateInterval(checkInDate, checkOutDate)
        element(Selectors.byText("Search")).click()
    }

    @Step
    override fun clearDestination() : SearchBar {
        element(Selectors.by("data-testid", "sb-minified-destination")).click()
        element(Selectors.by("data-testid", "input-clear")).click()
        element(Selectors.by("aria-label", "Close")).click()
        return this
    }
}