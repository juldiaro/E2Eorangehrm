package com.orangehrm.tasks;

import com.orangehrm.ui.DirectoryPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class NavigateToDirectory implements Task {

    public static NavigateToDirectory module() {
        return instrumented(NavigateToDirectory.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(DirectoryPage.DIRECTORY_MENU, isClickable()).forNoMoreThan(20).seconds(),
                Click.on(DirectoryPage.DIRECTORY_MENU)
        );
    }
}
