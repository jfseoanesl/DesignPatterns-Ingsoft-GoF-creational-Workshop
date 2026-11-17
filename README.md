# Actividad 1 · Casos de estudio con patrones creacionales

[![build](../../actions/workflows/build.yml/badge.svg)](../../actions/workflows/build.yml)

Este repositorio contiene cinco casos de estudio basados en sistemas reales cuyo diseño acumuló deuda técnica en la forma en que **crea** sus objetos. Cada caso incluye el contexto de la aplicación, la problemática, el diagrama de clases inicial y código Java ejecutable. Su grupo debe analizar cada caso, decidir qué patrones incorporar y refactorizar el código.

## Objetivo

Evaluar la capacidad de identificar problemas de creación de objetos en un diseño existente y de resolverlos combinando al menos dos patrones creacionales del catálogo GoF, justificando la decisión y evidenciándola con UML y código.

## Competencias que se evalúan

- Analiza código existente e identifica síntomas de deuda técnica relacionados con la creación de objetos.
- Selecciona y combina patrones creacionales según el contexto y argumenta frente a alternativas.
- Modela la solución con diagramas de clases UML de calidad profesional.
- Refactoriza código Java preservando su comportamiento observable.
- Evalúa las consecuencias (ventajas y costos) de las decisiones de diseño.

## Patrones de referencia

Cada caso se resuelve combinando **al menos dos patrones creacionales**.

| Categoría | Patrones |
|---|---|
| Creacionales | Abstract Factory, Builder, Factory Method, Prototype, Singleton |

> Los casos **no** indican qué patrones aplicar. Decidirlo a partir del contexto es parte de la evaluación.

## Casos de estudio

| Caso | Título | Dominio |
|---|---|---|
| 01 | [Agencia de viajes: paquetes turísticos multipaís](casos/caso-01-paquetes-turisticos/README.md) | Turismo y comercio electrónico |
| 02 | [Notaría digital: generación masiva de contratos](casos/caso-02-notaria-digital/README.md) | Servicios legales (LegalTech) |
| 03 | [Banca móvil: notificaciones transaccionales](casos/caso-03-banca-movil/README.md) | Servicios financieros (FinTech) |
| 04 | [Videojuego educativo: niveles por bioma](casos/caso-04-videojuego-biomas/README.md) | Videojuegos educativos |
| 05 | [ERP para pymes: acceso a datos multimotor](casos/caso-05-erp-multimotor/README.md) | Sistemas empresariales (ERP) |

## Dinámica de la actividad

1. Formen grupos de 3 o 4 estudiantes. El docente asigna los casos (sugerido: dos casos por grupo).
2. Hagan *fork* de este repositorio y creen una rama por caso (`caso-NN`).
3. Lean el enunciado, ejecuten `scripts/ejecutar.sh casoNN` y estudien el código inicial.
4. Identifiquen los síntomas de deuda técnica y registren la evidencia en el informe.
5. Decidan qué patrones aplicar y por qué; diseñen el diagrama de clases de la solución antes de programar.
6. Refactoricen en el paquete `solucion` del caso y verifiquen con `scripts/verificar.sh`.
7. Implementen los nuevos requerimientos y sustenten la solución ante el curso.

## Entregables

- Un informe por caso (`casos/<caso>/INFORME.md`) basado en [`PLANTILLA_INFORME.md`](PLANTILLA_INFORME.md).
- Diagrama de clases de la solución (`diagrama-solucion.puml` y su PNG) en la carpeta del caso.
- Código refactorizado en el subpaquete `solucion` de cada caso y la clase `DemoNuevosRequerimientos`.
- Pull request hacia la rama `main` del repositorio del grupo con la integración continua en verde.
- Sustentación oral de 10 minutos por caso.

## Estructura del repositorio

```text
actividad-patrones-creacionales/
├── README.md                 esta guía
├── PLANTILLA_INFORME.md      plantilla del informe por caso
├── casos/caso-NN-<nombre>/   enunciado, diagrama inicial y salida esperada
├── src/main/java/edu/ingsoft/actividad/creacionales/casoNN/   código inicial
├── scripts/ejecutar.sh       compila y ejecuta demos
└── scripts/verificar.sh      comprueba que la salida de Demo no cambió
```

## Cómo compilar y ejecutar

Requisitos: JDK 17 o superior. Maven es opcional.

```bash
scripts/ejecutar.sh             # compila y ejecuta todas las demos
scripts/ejecutar.sh caso03      # solo el caso 03
scripts/verificar.sh            # compara las salidas de Demo con salida-esperada.txt
mvn -q compile                  # alternativa con Maven
```

## Reglas

- `salida-esperada.txt` es una prueba de caracterización: la refactorización debe conservar el comportamiento correcto (`scripts/verificar.sh`). Si su solución corrige un defecto del código inicial (por ejemplo, un dato inconsistente), la diferencia es válida solo si la documenta en el informe.
- Se puede reorganizar libremente el código dentro del paquete `solucion` del caso; no modifique el código inicial.
- Toda decisión de diseño debe justificarse en el informe; un patrón sin justificación no suma puntos.
- No se permiten bibliotecas externas: solo el JDK.
- Cite cualquier fuente consultada. El uso de asistentes de IA debe declararse en el informe.

## Rúbrica de evaluación (por caso)

| Criterio | Peso | Excelente (4.5–5.0) | Bueno (3.5–4.4) | Aceptable (3.0–3.4) | Insuficiente (< 3.0) |
|---|---|---|---|---|---|
| Análisis del problema | 15 % | Identifica todos los síntomas de deuda técnica, los relaciona con el código y con los principios de diseño que se violan. | Identifica la mayoría de los síntomas, con referencias parciales al código. | Identifica síntomas generales sin evidencia en el código. | No identifica la problemática o la describe de forma incorrecta. |
| Selección y combinación de patrones | 25 % | Elige una combinación adecuada que responde a cada síntoma y justifica por qué cada patrón es la mejor opción frente a alternativas. | Combinación adecuada con justificación incompleta o sin analizar alternativas. | Selecciona un solo patrón pertinente o incluye patrones innecesarios. | Patrones no pertinentes o sin justificación. |
| Diagrama de clases de la solución | 15 % | UML correcto y completo (relaciones, multiplicidades, visibilidad, estereotipos); los roles de los patrones son identificables. | UML correcto con omisiones menores. | Diagrama incompleto o con errores de notación que dificultan la lectura. | No entrega diagrama o no corresponde al código. |
| Implementación y refactorización | 25 % | Compila, conserva el comportamiento correcto (diferencias documentadas), el código es limpio y los patrones están bien implementados. | Compila y conserva el comportamiento, con detalles de implementación mejorables. | Compila pero cambia el comportamiento o implementa los patrones de forma parcial. | No compila o no aplica los patrones. |
| Nuevos requerimientos | 10 % | Implementa todos los requerimientos sin modificar las clases existentes (extensión). | Implementa la mayoría con cambios menores en clases existentes. | Implementa algunos, con modificaciones extensas. | No implementa los requerimientos. |
| Consecuencias y sustentación | 10 % | Analiza ventajas, desventajas y costos de la solución; sustenta con dominio del tema. | Analiza consecuencias de forma general; sustentación adecuada. | Análisis superficial. | No analiza consecuencias ni sustenta. |

## Bibliografía

- Gamma, E., Helm, R., Johnson, R. y Vlissides, J. (1994). *Design Patterns*. Addison-Wesley.
- Kerievsky, J. (2004). *Refactoring to Patterns*. Addison-Wesley.
- Fowler, M. (2018). *Refactoring* (2.ª ed.). Addison-Wesley.
- Bloch, J. (2018). *Effective Java* (3.ª ed.). Addison-Wesley.
