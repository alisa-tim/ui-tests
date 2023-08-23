package pages

import containers.Calendar
import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.Selectors
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.element
import containers.SearchBar
import java.time.LocalDate

class MainPage {

    val searchBar = SearchBar()

    fun open(): MainPage {
        Selenide.open("https://www.booking.com/")
        dismissSignIn()
        return this
    }

    fun dismissSignIn() {
        element(Selectors.by("aria-label", "Dismiss sign-in info.")).click()
    }

}