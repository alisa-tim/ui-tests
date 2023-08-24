package pageObject.desktop.pages

import com.codeborne.selenide.Selectors
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.element
import pageObject.desktop.containers.SearchBar
import interfaces.AbstractMainPage
import io.qameta.allure.Step

class MainPage : AbstractMainPage {

    override val searchBar = SearchBar()

    @Step("Open main page")
    override fun open(): MainPage {
        Selenide.open("/")
        dismissSignIn()
        return this
    }

    private fun dismissSignIn() {
        element(Selectors.by("aria-label", "Dismiss sign-in info.")).click()
    }
}