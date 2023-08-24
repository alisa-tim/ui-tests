package pageObject.mobile

import interfaces.AbstractMainPage
import interfaces.AbstractSearchResultsPage
import interfaces.PageFactory
import pageObject.mobile.pages.MainPage
import pageObject.mobile.pages.SearchResultsPage

object MobilePageFactory : PageFactory {
    override val mainPage get() = MainPage()
    override val searchResultsPage get() = SearchResultsPage()
}