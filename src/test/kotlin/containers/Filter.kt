package containers

import com.codeborne.selenide.Selectors
import com.codeborne.selenide.Selenide.element
import pages.SearchResultsPage

class Filter {

    private fun filterBy(attribute: String, value: String) : SearchResultsPage {
        element(Selectors.by("data-filters-group", attribute))
            .find(Selectors.byText(value))
            .scrollTo()
            .click()
        return SearchResultsPage()
    }

    fun byReviewsScore(score: String) = filterBy("review_score", score)
}