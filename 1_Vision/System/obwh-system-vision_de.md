# System Vision von "Old Book Wisenheimer"

## Komponenten Quiz und Admin

Es gibt zwei Komponenten:
- **Quiz** Komponente, die das Quiz realisiert
  - Ablauf und User Interface bzw. User Experience
- **Admin** Komponente, die zuständig ist für:
    - die Generierung und Kuration von guten Quizfragen mithilfe von KI
    - die Verwaltung von Affiliate-Links von Büchern zu Buchhandlungen

### Quiz Komponente

Die Quiz Komponente besteht aus einem Web Frontend, 
das mit einem Backend über ein API kommuniziert.
Das Backend ist stateless.

Wichtig ist der Schutz der Affiliate-Links durch verschiedene Maßnahmen.
Eine Sperrung durch einen Affiliate Partner darf nicht passieren.

Weiters sind Maßnahmen im Einsatz, die das Schummeln erschweren.

Die Quiz Komponente ist öffentlich ohne Credentials zugänglich und ist permanent online erreichbar.

### Admin Komponente

Die Admin Komponente besteht ebenfalls aus einem Web Frontend und einem Backend.
Das Frontend kommuniziert mit dem Backend über ein API.
Das Backend muss nicht stateless sein.

Die Admin Komponente ist nur für einen mit Credentials geschützten Admin User zugänglich.

Die Admin Komponente ist permanent online erreichbar, sondern
kann für Admin Tätigkeiten eingeschalten- und danach wieder abgeschalten werden.

## Datenbank

Es gibt eine Datenbank für Quizfragen, Bücher, Affilate-Links, usw.
Diese Datenbank wird sowohl von der Quiz Komponente als auch von der Admin Komponente verwendet.