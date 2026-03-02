package com.orangehrm.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class WaitForSeconds implements Interaction {
    private final int seconds;

    public WaitForSeconds(int seconds) {
        this.seconds = seconds;
    }

    public static WaitForSeconds of(int seconds) {
        return instrumented(WaitForSeconds.class, seconds);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
