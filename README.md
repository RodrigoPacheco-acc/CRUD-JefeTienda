# 🏪 CRUD - Gestión de Jefes de Tienda

Este proyecto implementa un sistema **CRUD (Crear, Leer, Actualizar y Eliminar)** para la **gestión de jefes de tienda**, desarrollado con **JSP, Servlets y JDBC**.  
Permite administrar la información de los jefes de tienda mediante una interfaz web sencilla y funcional.

---

## 🚀 Funcionalidades principales

- ➕ **Agregar** nuevos jefes de tienda.  
- ✏️ **Editar** los datos de jefes existentes.  
- 🔍 **Buscar** jefes de tienda por **apellido paterno o materno**.  
- 🗑️ **Eliminar** registros directamente desde la tabla.  

Cada registro cuenta con botones **Editar** y **Eliminar**, permitiendo un control completo del listado.

---

## 🧩 Tecnologías utilizadas

- **Lenguaje:** Java (JDK 11)  
- **Framework Web:** JSP y Servlets  
- **Servidor:** Apache Tomcat 10  
- **Gestor de dependencias:** Maven  
- **Base de datos:** Microsoft SQL Server  
- **Librerías:**  
  - `com.microsoft.sqlserver:mssql-jdbc`  
  - `jakarta.servlet.jsp.jstl`  
  - `org.glassfish.web:jakarta.servlet.jsp.jstl`

---

## ⚙️ Configuración de la base de datos

El proyecto se conecta a una base de datos **SQL Server** mediante JDBC.  
La conexión está definida en el archivo `JefeTiendaDAO.java`:

java
this.url = "jdbc:sqlserver://localhost:1433;databaseName=miSistemaBD;user=a1710203;password=supertyson123;encrypt=true;trustServerCertificate=true";

---

## 🧠 Estructura del proyecto

CRUD-JefeTienda/
│
├── src/main/java/com/EA2Dae1/
│   ├── controller/JefeTiendaController.java
│   ├── dao/JefeTiendaDAO.java
│   └── model/JefeTienda.java
│
├── src/main/webapp/
│   ├── index.jsp
│   ├── gestionJefeTienda.jsp
│   ├── nuevoJefeTienda.jsp
│   └── editarJefeTienda.jsp
│
├── pom.xml
└── README.md

---

## ▶️ Ejecución

Clonar este repositorio:
- git clone https://github.com/RodrigoPacheco-acc/CRUD-JefeTienda.git
- Importar el proyecto en Eclipse o IntelliJ IDEA como proyecto Maven.
- Configurar la conexión a la base de datos en JefeTiendaDAO.java.
- Ejecutar el servidor Apache Tomcat 10.
- Acceder desde el navegador a:
- http://localhost:8080/CRUD-JefeTienda/gestionJefeTienda.jsp

## 📜 Licencia

Este proyecto está bajo la licencia MIT, lo que permite su uso, modificación y distribución libremente.

## 👨‍💻 Autor

Rodrigo Pacheco

Estudiante de Desarrollo de Software,
ISIL,
📍 Lima, Perú.
