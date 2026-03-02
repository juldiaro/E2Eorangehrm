package com.orangehrm.tasks;

import com.orangehrm.ui.PIMPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class NavigateToPIM implements Task {

    public static NavigateToPIM module() {
        return instrumented(NavigateToPIM.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(PIMPage.PIM_MENU, isClickable()).forNoMoreThan(20).seconds(),
                Click.on(PIMPage.PIM_MENU)
        );
    }
}
