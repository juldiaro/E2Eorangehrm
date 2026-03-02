# language: es
Característica: Gestión de empleados en OrangeHRM
  Como administrador del sistema OrangeHRM
  Quiero agregar y buscar empleados
  Para gestionar la información del personal de la empresa

  @E2E @EmployeeManagement
  Escenario: Agregar un nuevo empleado y validar su informacion en el directorio
    Dado que el administrador ingresa al sistema OrangeHRM
    Cuando agrega un nuevo empleado con la siguiente informacion:
      | firstName | lastName |
      | Carlos    | Martinez |
    Cuando sube una foto de perfil para el empleado
    Cuando busca al empleado por ID en la lista
    Entonces deberia ver la informacion del empleado correctamente almacenada
