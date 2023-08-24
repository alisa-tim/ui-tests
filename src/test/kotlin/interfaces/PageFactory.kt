package interfaces

import com.codeborne.selenide.Selectors
import pageObject.desktop.containers.Filter
import pageObject.desktop.containers.SearchBar
import pageObject.desktop.containers.Sort
import io.qameta.allure.Step
import java.time.LocalDate

interface PageFactory {
    val mainPage: AbstractMainPage
    val searchResultsPage: AbstractSearchResultsPage
}

interface AbstractMainPage {
    val searchBar: AbstractSearchBar
    fun open() : AbstractMainPage
}

interface AbstractSearchBar {
    fun search(destination: String, checkInDate: LocalDate, checkOutDate: LocalDate)
    fun clearDestination() : AbstractSearchBar
}

interface AbstractSearchResultsPage {
    val filter : AbstractFilter
    val searchBar: AbstractSearchBar
    val hotels: List<AbstractHotel>

    fun sortBy(order: String) : AbstractSearchResultsPage
}

interface AbstractHotel {
    val location: String
    val price: Int
    val rating: Double
}

interface AbstractFilter {
    fun byReviewsScore(score: String) : AbstractSearchResultsPage
}