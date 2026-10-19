# Práctica de Programación Modular en Java: Métodos Iterativos

Este repositorio contiene la solución a la **Tarea 2** de la asignatura, donde se implementan y comparan los métodos iterativos de **Jacobi** y **Gauss-Seidel** para la resolución de sistemas de ecuaciones lineales.

## 📋 Información Académica
* **Materia:** Métodos Numéricos
* **Alumno:** David Domínguez López
* **Docente:** Víctor Hugo Vásquez Herrera
* **Institución:** Instituto Tecnológico Superior de Xalapa

---

## 🎯 Sistema de Ecuaciones a Resolver
El programa está configurado para resolver el siguiente sistema de ecuaciones lineales de 3 × 3:

\[\begin{cases} 5x + y + z = 7 \\  x + 4y + z = 6 \\  x + 2y + 5z = 8 \end{cases}\]

* **Vector de aproximación inicial:** \(X^{(0)} = [0, 0, 0]^T\)
* **Tolerancia establecida:** ε = 0.0001

---

## 🏗️ Arquitectura Modular (Estructura del Proyecto)
El código se desarrolló bajo una arquitectura modular de tres componentes principales para garantizar la separación de responsabilidades:

1. **`Sistema.java` (Módulo 1 - Definición del Sistema):** Clase encargada exclusivamente de almacenar de manera estructurada la matriz de coeficientes A, el vector independiente b, el vector inicial \(X^{(0)}\) y el criterio de parada (tolerancia).
2. **`MetodosIterativos.java` (Módulo 2 - Métodos Iterativos):** Clase que contiene la lógica matemática de cálculo. Implementa el método de **Jacobi** (mediante un vector auxiliar para almacenar los nuevos estados de forma aislada) y el método de **Gauss-Seidel** (empleando la actualización inmediata de variables).
3. **`Main.java` (Módulo 3 - Ejecución):** Clase principal encargada de orquestar y ejecutar ambos métodos de forma secuencial con los parámetros definidos en el Módulo 1.

---

## 🛠️ Instrucciones de Compilación y Ejecución

Para compilar y ejecutar este proyecto desde la terminal utilizando el JDK de Java, sigue estos pasos:

### 1. Clonar el repositorio
```bash
git clone https://github.com
cd TU_REPOSITORIO
```

### 2. Compilar los archivos fuente
Compila todos los módulos juntos para que resuelvan las dependencias entre clases de manera automática:
```bash
javac Sistema.java MetodosIterativos.java Main.java
```

### 3. Ejecutar la aplicación
Ejecuta la clase principal (`Main`):
```bash
java Main
```

---

## 📊 Formato de Salida del Programa
Al ejecutarse, el programa mostrará en consola una tabla detallada iteración por iteración para cada método, facilitando el análisis y la comparación de la velocidad de convergencia:

```text
=======================================================
                 MÉTODO DE JACOBI                      
=======================================================
Iteración  x            y            z            Error Máximo   
0          0.000000     0.000000     0.000000     ---            
1          1.400000     1.500000     1.600000     1.600000e+00   
...
-> Jacobi finalizado en X iteraciones.

=======================================================
               MÉTODO DE GAUSS-SEIDEL                  
=======================================================
Iteración  x            y            z            Error Máximo   
0          0.000000     0.000000     0.000000     ---            
1          1.400000     1.150000     0.860000     1.400000e+00   
...
-> Gauss-Seidel finalizado en Y iteraciones.
```
