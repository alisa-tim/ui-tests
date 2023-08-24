package pageObject.mobile.containers

import com.codeborne.selenide.Selectors
import com.codeborne.selenide.Selenide.element
import io.qameta.allure.Step
import pageObject.desktop.pages.SearchResultsPage

class Sort {

    @Step
    fun sortBy(order: String) : SearchResultsPage {
        element(Selectors.by("data-testid", "sticky-container"))
            .find(Selectors.byText("Sort"))
            .click()
        element(Selectors.byText(order)).click()
        return SearchResultsPage()
    }
}