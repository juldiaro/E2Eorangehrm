package com.orangehrm.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PIMPage {
    public static final Target PIM_MENU = Target.the("menú PIM")
            .located(By.xpath("//span[text()='PIM']"));
    
    public static final Target ADD_EMPLOYEE_BUTTON = Target.the("botón agregar empleado")
            .located(By.xpath("//a[contains(text(),'Add Employee')]"));
    
    public static final Target FIRST_NAME_FIELD = Target.the("campo nombre")
            .located(By.name("firstName"));
    
    public static final Target LAST_NAME_FIELD = Target.the("campo apellido")
            .located(By.name("lastName"));
    
    public static final Target EMPLOYEE_ID_FIELD = Target.the("campo ID empleado")
            .locatedBy("//label[text()='Employee Id']/parent::div/following-sibling::div/input");
    
    public static final Target EMPLOYEE_ID_SEARCH_FIELD = Target.the("campo buscar por ID")
            .located(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));
    
    public static final Target SEARCH_BUTTON_LIST = Target.the("botón buscar en lista")
            .located(By.cssSelector("button[type='submit']"));
    
    public static final Target EMPLOYEE_RESULT_ROW = Target.the("fila de resultado empleado")
            .located(By.cssSelector(".oxd-table-card"));
    
    public static final Target EMPLOYEE_ID_ERROR = Target.the("error ID duplicado")
            .located(By.xpath("//span[contains(text(),'Employee Id already exists')]"));
    
    public static final Target PHOTO_UPLOAD_INPUT = Target.the("input de foto")
            .located(By.cssSelector("input[type='file']"));
    
    public static final Target SAVE_BUTTON = Target.the("botón guardar")
            .located(By.cssSelector("button[type='submit']"));
    
    public static final Target SUCCESS_MESSAGE = Target.the("mensaje de éxito")
            .located(By.cssSelector(".oxd-toast-content"));
}
