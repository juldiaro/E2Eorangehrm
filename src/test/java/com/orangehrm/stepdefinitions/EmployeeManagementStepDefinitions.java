package com.orangehrm.stepdefinitions;

import com.orangehrm.models.Employee;
import com.orangehrm.questions.EmployeeInformation;
import com.orangehrm.tasks.*;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.is;

public class EmployeeManagementStepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que el administrador ingresa al sistema OrangeHRM")
    public void queElAdministradorIngresaAlSistemaOrangeHRM() {
        theActorCalled("Admin").attemptsTo(
                Login.withCredentials("Admin", "admin123")
        );
    }

    @Cuando("agrega un nuevo empleado con la siguiente informacion:")
    public void agregaUnNuevoEmpleadoConLaSiguienteInformacion(List<Map<String, String>> employeeData) {
        Map<String, String> data = employeeData.get(0);
        Employee employee = new Employee(data.get("firstName"), data.get("lastName"));
        
        theActorInTheSpotlight().attemptsTo(
                NavigateToPIM.module(),
                AddEmployee.withInformation(employee)
        );
    }

    @Cuando("sube una foto de perfil para el empleado")
    public void subeUnaFotoDePerfilParaElEmpleado() {
        String photoPath = System.getProperty("user.dir") + "/src/test/resources/test-photo.jpg";
        theActorInTheSpotlight().attemptsTo(
                UploadPhoto.fromPath(photoPath)
        );
    }

    @Cuando("navega al modulo de Directory")
    public void navegaAlModuloDeDirectory() {
        theActorInTheSpotlight().attemptsTo(
                NavigateToDirectory.module()
        );
    }

    @Cuando("busca al empleado por nombre")
    public void buscaAlEmpleadoPorNombre() {
        Employee employee = theActorInTheSpotlight().recall("currentEmployee");
        theActorInTheSpotlight().attemptsTo(
                SearchEmployee.byName(employee.getFirstName())
        );
    }

    @Cuando("busca al empleado por ID en la lista")
    public void buscaAlEmpleadoPorIDEnLaLista() {
        Employee employee = theActorInTheSpotlight().recall("currentEmployee");
        theActorInTheSpotlight().attemptsTo(
                SearchEmployeeById.withId(employee.getEmployeeId())
        );
    }

    @Entonces("deberia ver la informacion del empleado correctamente almacenada")
    public void deberiaVerLaInformacionDelEmpleadoCorrectamenteAlmacenada() {
        theActorInTheSpotlight().should(
                seeThat(EmployeeInformation.isFoundInList(), is(true))
        );
    }
}
