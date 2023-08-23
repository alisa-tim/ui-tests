package containers

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selectors
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.element
import io.qameta.allure.Step
import java.time.LocalDate

class SearchBar {

    @Step
    fun search(destination: String, checkInDate: LocalDate? = null, checkOutDate: LocalDate? = null) {
        element(Selectors.by("placeholder", "Where are you going?")).value = destination
        element(Selectors.by("data-testid", "autocomplete-result")).shouldHave(Condition.text(destination))
        element(Selectors.by("data-testid", "searchbox-dates-container")).click()
        checkInDate?.let { Calendar().pickDate(checkInDate) }
        checkOutDate?.let { Calendar().pickDate(checkOutDate) }
        element(Selectors.byText("Search")).click()
    }

    @Step
    fun clearDestination() : SearchBar {
        element(Selectors.by("data-testid", "input-clear")).click()
        return this
    }
}