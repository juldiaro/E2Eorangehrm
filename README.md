# OrangeHRM Automation - Screenplay Pattern

Automatización E2E con SerenityBDD, Screenplay Pattern y Cucumber.

---

## 🚀 Ejecución Rápida

```bash
.\gradlew clean test aggregate
```

Ver reporte: `target\site\serenity\index.html`

---

## 📋 Requisitos

- Java 11+
- Chrome
- Gradle (incluido)

---

## 🏗️ Arquitectura Screenplay

### Capas del Proyecto

```
src/
├── main/java/com/orangehrm/
│   ├── tasks/          # Acciones de negocio (Login, AddEmployee)
│   ├── questions/      # Validaciones (EmployeeInformation)
│   ├── ui/            # Localizadores (LoginPage, PIMPage)
│   ├── models/        # Objetos de datos (Employee)
│   └── interactions/  # Acciones reutilizables (WaitForSeconds)
│
└── test/
    ├── java/
    │   ├── runners/           # Ejecutor de tests
    │   └── stepdefinitions/   # Pasos Cucumber
    └── resources/
        └── features/          # Escenarios Gherkin
```

---

## 🎯 Patrón Screenplay

### Ejemplo: Login

**Task** (¿Qué hace el usuario?)
```java
Login.withCredentials("Admin", "admin123")
```

**UI** (¿Dónde interactúa?)
```java
Target USERNAME_FIELD = Target.the("usuario")
    .located(By.name("username"));
```

**Step Definition** (Lenguaje natural)
```gherkin
Dado que el administrador ingresa al sistema OrangeHRM
```

---

## 📝 Escenario de Prueba

```gherkin
Escenario: Agregar un nuevo empleado
  Dado que el administrador ingresa al sistema OrangeHRM
  Cuando agrega un nuevo empleado con la siguiente informacion:
    | firstName | lastName |
    | Carlos    | Martinez |
  Cuando sube una foto de perfil para el empleado
  Cuando navega al modulo de Directory
  Cuando busca al empleado por nombre "Carlos Martinez"
  Entonces deberia ver la informacion del empleado correctamente almacenada
```

---

## 🔑 Credenciales

- **URL**: https://opensource-demo.orangehrmlive.com
- **Usuario**: Admin
- **Contraseña**: admin123

---

## 🛠️ Tecnologías

- **Java 11** - Lenguaje
- **Gradle 8.5** - Build tool
- **SerenityBDD 3.9.8** - Framework de testing
- **Cucumber 7.14.0** - BDD
- **Screenplay Pattern** - Arquitectura

---

## 📊 Reportes

SerenityBDD genera reportes HTML interactivos con:
- ✅ Resultados de tests
- 📸 Screenshots automáticos
- 📝 Logs detallados
- 📈 Métricas de ejecución

---

## 💡 Ventajas del Screenplay Pattern

1. **Legible**: Código que se lee como lenguaje natural
2. **Mantenible**: Cambios centralizados en Tasks y UI
3. **Reutilizable**: Tasks compartidas entre tests
4. **Escalable**: Fácil agregar nuevos escenarios
5. **SOLID**: Principios de diseño aplicados

---

## 🎓 Conceptos Clave

### Actor
El usuario que ejecuta acciones
```java
theActorCalled("Admin")
```

### Task
Acción de negocio de alto nivel
```java
Login.withCredentials("Admin", "admin123")
```

### Question
Validación o consulta
```java
EmployeeInformation.isDisplayedFor("Carlos Martinez")
```

### Target
Elemento de la UI
```java
LoginPage.USERNAME_FIELD
```

---

## 📁 Archivos Principales

- `build.gradle` - Dependencias
- `serenity.conf` - Configuración
- `employee_management.feature` - Escenario
- `EmployeeManagementTestRunner.java` - Ejecutor

---

**Proyecto**: OrangeHRM Automation  
**Patrón**: Screenplay  
**Framework**: SerenityBDD + Cucumber
