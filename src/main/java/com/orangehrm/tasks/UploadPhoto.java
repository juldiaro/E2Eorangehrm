package com.orangehrm.tasks;

import com.orangehrm.ui.PIMPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Upload;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.nio.file.Paths;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class UploadPhoto implements Task {
    private final String photoPath;

    public UploadPhoto(String photoPath) {
        this.photoPath = photoPath;
    }

    public static UploadPhoto fromPath(String photoPath) {
        return instrumented(UploadPhoto.class, photoPath);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(PIMPage.PHOTO_UPLOAD_INPUT, isPresent()).forNoMoreThan(20).seconds(),
                Upload.theFile(Paths.get(photoPath)).to(PIMPage.PHOTO_UPLOAD_INPUT),
                WaitUntil.the(PIMPage.SAVE_BUTTON, isPresent()).forNoMoreThan(10).seconds(),
                Click.on(PIMPage.SAVE_BUTTON)
        );
    }
}
