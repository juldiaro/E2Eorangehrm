package com.orangehrm.tasks;

import com.orangehrm.interactions.WaitForSeconds;
import com.orangehrm.ui.DirectoryPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SearchEmployee implements Task {
    private final String employeeName;

    public SearchEmployee(String employeeName) {
        this.employeeName = employeeName;
    }

    public static SearchEmployee byName(String employeeName) {
        return instrumented(SearchEmployee.class, employeeName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(DirectoryPage.EMPLOYEE_NAME_FIELD, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(DirectoryPage.EMPLOYEE_NAME_FIELD),
                Enter.theValue(employeeName).into(DirectoryPage.EMPLOYEE_NAME_FIELD),
                WaitForSeconds.of(3),
                Enter.theValue(Keys.ARROW_DOWN.toString()).into(DirectoryPage.EMPLOYEE_NAME_FIELD),
                Enter.theValue(Keys.ENTER.toString()).into(DirectoryPage.EMPLOYEE_NAME_FIELD),
                Click.on(DirectoryPage.SEARCH_BUTTON),
                WaitForSeconds.of(3)
        );
    }
}
