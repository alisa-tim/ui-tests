package pageObject.mobile.containers

import com.codeborne.selenide.Selectors
import com.codeborne.selenide.Selenide.element
import io.qameta.allure.Step
import pageObject.desktop.pages.SearchResultsPage
import interfaces.AbstractFilter

class Filter : AbstractFilter {

    private fun filterBy(attribute: String, value: String): SearchResultsPage {
        element(Selectors.by("data-testid", "sticky-container"))
            .find(Selectors.byText("Filters"))
            .click()
        element(Selectors.by("data-filters-group", attribute))
            .find(Selectors.byText(value))
            .scrollTo()
            .click()
        element(Selectors.by("data-testid", "filters-modal-action")).click()
        return SearchResultsPage()
    }

    @Step
    override fun byReviewsScore(score: String) = filterBy("review_score", score)
}