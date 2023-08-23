package containers

import com.codeborne.selenide.Selectors
import com.codeborne.selenide.Selenide.element
import io.qameta.allure.Step
import pages.SearchResultsPage

class Sort {

    @Step
    fun sortBy(order: String) : SearchResultsPage {
        element(Selectors.by("data-testid", "sorters-dropdown-trigger")).click()
        element(Selectors.by("data-testid", "sorters-dropdown")).find(Selectors.byText(order)).click()
        return SearchResultsPage()
    }
}