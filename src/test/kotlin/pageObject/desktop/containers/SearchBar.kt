package pageObject.desktop.containers

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selectors
import com.codeborne.selenide.Selenide.element
import interfaces.AbstractSearchBar
import io.qameta.allure.Step
import java.time.LocalDate

class SearchBar : AbstractSearchBar {

    @Step
    override fun search(destination: String, checkInDate: LocalDate, checkOutDate: LocalDate) {
        element(Selectors.by("placeholder", "Where are you going?")).value = destination
        element(Selectors.by("data-testid", "autocomplete-result")).shouldHave(Condition.text(destination))
        element(Selectors.by("data-testid", "searchbox-dates-container")).click()
        Calendar().pickDate(checkInDate)
        Calendar().pickDate(checkOutDate)
        element(Selectors.byText("Search")).click()
    }

    @Step
    override fun clearDestination() : SearchBar {
        element(Selectors.by("data-testid", "input-clear")).click()
        return this
    }
}