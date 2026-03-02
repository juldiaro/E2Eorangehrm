package com.orangehrm.questions;

import com.orangehrm.ui.PIMPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EmployeeInformation implements Question<Boolean> {
    private final String expectedName;

    public EmployeeInformation(String expectedName) {
        this.expectedName = expectedName;
    }

    public static EmployeeInformation isDisplayedFor(String employeeName) {
        return new EmployeeInformation(employeeName);
    }
    
    public static EmployeeInformation isSuccessfullySaved() {
        return new EmployeeInformation("");
    }
    
    public static EmployeeInformation isFoundInList() {
        return new EmployeeInformation("");
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            actor.attemptsTo(
                    WaitUntil.the(PIMPage.EMPLOYEE_RESULT_ROW, isVisible()).forNoMoreThan(10).seconds()
            );
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
