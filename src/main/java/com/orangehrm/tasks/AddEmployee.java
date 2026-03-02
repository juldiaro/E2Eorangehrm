package com.orangehrm.tasks;

import com.orangehrm.models.Employee;
import com.orangehrm.ui.PIMPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.Random;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class AddEmployee implements Task {
    private final Employee employee;

    public AddEmployee(Employee employee) {
        this.employee = employee;
    }

    public static AddEmployee withInformation(Employee employee) {
        return instrumented(AddEmployee.class, employee);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(PIMPage.ADD_EMPLOYEE_BUTTON, isClickable()).forNoMoreThan(20).seconds(),
                Click.on(PIMPage.ADD_EMPLOYEE_BUTTON),
                WaitUntil.the(PIMPage.FIRST_NAME_FIELD, isVisible()).forNoMoreThan(20).seconds(),
                Enter.theValue(employee.getFirstName()).into(PIMPage.FIRST_NAME_FIELD),
                Enter.theValue(employee.getLastName()).into(PIMPage.LAST_NAME_FIELD)
        );
        
        generateUniqueEmployeeId(actor);
        
        String employeeId = PIMPage.EMPLOYEE_ID_FIELD.resolveFor(actor).getValue();
        employee.setEmployeeId(employeeId);
        actor.remember("currentEmployee", employee);
    }
    
    private void generateUniqueEmployeeId(Actor actor) {
        int attempts = 0;
        while (attempts < 10) {
            try {
                if (PIMPage.EMPLOYEE_ID_ERROR.resolveFor(actor).isVisible()) {
                    String newId = String.valueOf(10000 + new Random().nextInt(90000));
                    actor.attemptsTo(
                            Clear.field(PIMPage.EMPLOYEE_ID_FIELD),
                            Enter.theValue(newId).into(PIMPage.EMPLOYEE_ID_FIELD)
                    );
                    Thread.sleep(500);
                    attempts++;
                } else {
                    break;
                }
            } catch (Exception e) {
                break;
            }
        }
    }
}
