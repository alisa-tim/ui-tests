package pageObject.desktop

import interfaces.PageFactory
import pageObject.desktop.pages.MainPage
import pageObject.desktop.pages.SearchResultsPage

object DesktopPageFactory : PageFactory {
    override val mainPage get() = MainPage()
    override val searchResultsPage get() = SearchResultsPage()
}