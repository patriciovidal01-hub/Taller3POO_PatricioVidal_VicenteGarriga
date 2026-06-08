# Taller 3 - Sistema de Magos y Hechizos

## Descripción
Sistema de magos y hechizos desarrollado en Java. Permite gestionar hechiceros y sus hechizos de distintos tipos (Fuego, Agua, Tierra y Planta), con dos modos de uso: Analista y Administrador.

## Integrantes
- Patricio Vidal
- Vicente Garriga

## ¿Cómo ejecutarlo?
1. Asegurarse de tener Java instalado
2. Compilar todos los archivos `.java`
3. Ejecutar `Main.java`
4. Seleccionar el tipo de menú:
   - **Analista**: consultar rankings y estadísticas
   - **Administrador**: modificar hechizos y magos

> Los archivos `Hechizos.txt` y `Magos.txt` deben estar en el mismo directorio que el ejecutable.

## Conceptos POO aplicados
- **Herencia**: `Fuego`, `Agua`, `Tierra` y `Planta` extienden la clase `Hechizo`
- **Clases abstractas**: `Hechizo` es abstracta, obligando a cada subclase a implementar `calcularPuntaje()` y `almacenarDatos()`
- **Interfaces**: `Puntuacion` define el contrato de puntuación; `Menu` define el contrato de los menús del sistema

## Tecnologías
**Lenguaje:** Java  
**Paradigma:** Orientado a Objetos
