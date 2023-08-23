package containers

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selectors
import com.codeborne.selenide.Selenide.element
import io.qameta.allure.Step
import java.time.LocalDate

class Calendar {

    private val calendar = element(Selectors.by("data-testid", "searchbox-datepicker-calendar"))

    @Step
    fun pickDate(date: LocalDate) {
        calendar.shouldBe(Condition.visible)
        calendar.find(Selectors.by("data-date", date.toString())).click()
    }
}