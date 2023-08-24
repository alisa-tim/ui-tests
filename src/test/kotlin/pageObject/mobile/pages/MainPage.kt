package pageObject.mobile.pages

import com.codeborne.selenide.Selenide
import interfaces.AbstractMainPage
import io.qameta.allure.Step
import pageObject.mobile.containers.SearchBar

class MainPage : AbstractMainPage {
    override val searchBar = SearchBar()

    @Step("Open main page")
    override fun open(): AbstractMainPage {
        Selenide.open("/")
        return this
    }
}