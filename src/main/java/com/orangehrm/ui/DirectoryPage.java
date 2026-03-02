package com.orangehrm.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DirectoryPage {
    public static final Target DIRECTORY_MENU = Target.the("menú Directory")
            .located(By.xpath("//span[text()='Directory']"));
    
    public static final Target EMPLOYEE_NAME_FIELD = Target.the("campo nombre empleado")
            .locatedBy("//label[text()='Employee Name']/parent::div/following-sibling::div//input");
    
    public static final Target SEARCH_BUTTON = Target.the("botón buscar")
            .located(By.cssSelector("button[type='submit']"));
    
    public static final Target EMPLOYEE_CARD = Target.the("tarjeta de empleado")
            .located(By.cssSelector(".oxd-sheet"));
    
    public static final Target EMPLOYEE_NAME_RESULT = Target.the("nombre del empleado en resultado")
            .located(By.cssSelector(".orangehrm-directory-card-header"));
}
