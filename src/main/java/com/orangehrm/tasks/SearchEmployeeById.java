package com.orangehrm.tasks;

import com.orangehrm.ui.PIMPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SearchEmployeeById implements Task {
    private final String employeeId;

    public SearchEmployeeById(String employeeId) {
        this.employeeId = employeeId;
    }

    public static SearchEmployeeById withId(String employeeId) {
        return instrumented(SearchEmployeeById.class, employeeId);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList"),
                WaitUntil.the(PIMPage.EMPLOYEE_ID_SEARCH_FIELD, isVisible()).forNoMoreThan(20).seconds(),
                Enter.theValue(employeeId).into(PIMPage.EMPLOYEE_ID_SEARCH_FIELD),
                Click.on(PIMPage.SEARCH_BUTTON_LIST)
        );
    }
}
