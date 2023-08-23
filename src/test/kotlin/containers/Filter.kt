package containers

import com.codeborne.selenide.Selectors
import com.codeborne.selenide.Selenide.element
import io.qameta.allure.Step
import pages.SearchResultsPage

class Filter {

    private fun filterBy(attribute: String, value: String): SearchResultsPage {
        element(Selectors.by("data-filters-group", attribute))
            .find(Selectors.byText(value))
            .scrollTo()
            .click()
        return SearchResultsPage()
    }

    @Step
    fun byReviewsScore(score: String) = filterBy("review_score", score)
}