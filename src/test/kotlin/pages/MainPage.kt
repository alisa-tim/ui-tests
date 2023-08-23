package pages

import com.codeborne.selenide.Selectors
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.element
import containers.SearchBar
import io.qameta.allure.Step

class MainPage {

    val searchBar = SearchBar()

    @Step("Open main page")
    fun open(): MainPage {
        Selenide.open("/")
        dismissSignIn()
        return this
    }

    private fun dismissSignIn() {
        element(Selectors.by("aria-label", "Dismiss sign-in info.")).click()
    }

}