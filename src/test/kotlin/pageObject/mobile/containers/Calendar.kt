package pageObject.mobile.containers

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selectors
import com.codeborne.selenide.Selenide.element
import io.qameta.allure.Step
import java.time.LocalDate

class Calendar {

    private val calendar = element(Selectors.by("data-testid", "datepicker-tabs"))

    @Step
    fun pickDateInterval(startDate: LocalDate?, endDate: LocalDate?) {
        calendar.find(Selectors.by("data-date", startDate.toString())).click()
        calendar.find(Selectors.by("data-date", endDate.toString())).click()
        element(Selectors.byText("Done")).click()
    }
}