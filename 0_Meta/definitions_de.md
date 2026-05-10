# Definitionen

Folgende Angaben sollen beim Specification Driven Development helfen.

## Begriffe

- **Product**: ein Artefact, das von Benutzern erfahren werden kann
- **System**:
    - ein **System** ist der technische Unterbau von einem **Product**
    - ein **Product** wird mithilfe von einem **System** realisiert
- **Vision**: beschreibt eine Zielvorstellung, das Endresultat einer erfolgreichen Entwicklung
- **Product Vision**: beschreibt die **Vision** über ein **Product**
- **System Vision**: beschreibt die **Vision** über ein **System**
- **Design**:
    - beschreibt einen Zwischenstand auf dem Weg der Entwicklung zur **Vision**
    - am Ende der Entwicklung entspricht das **Design** der **Vision**
- **Product Design**: beschreibt das **Design** von einem **Product**
- **System Design**: beschreibt das **Design** von einem **System**
- **Implementation**:
    - die lauffähige Realisierung von einem **System Design**
    - am Ende der Entwicklung ist das die lauffähige Realisierung der **System Vision**
    - und somit auch eine lauffähige Realisierung der **Product Vision**
- **Story**:
    - ein Entwicklungsschritt, ein Increment
    - ein **Product Design** bewegt sich in **Story** Increments auf die **Product Vision** zu
    - ein **System Design** bewegt sich in **Story Increments** auf die **System Vision** zu
    - eine **Implementation** bewegt sich in **Story** Increments auf die **System Vision** zu

## Verzeichnisstruktur und Dokumente

- Verzeichnis 0_Meta
    - enthält Dokument definitions.md:
        - Definitionen zu den verwendeten Begriffen
        - die Beschreibung einer Verzeichnisstruktur und darin enthaltener Dokumente
        - Verzeichnisstruktur und Dokumente orientieren sich an den definierten Begriffen
- Verzeichnis 1_Vision/Product
    - enthält Dokumente zur **Product Vision**
- Verzeichnis 1_Vision/System
    - enthält Dokumente zur **System Vision**
- Verzeichnis 2_Design/Product
    - enthält Dokumente zum **Product Design**
- Verzeichnis 2_Design/System
    - enthält Dokumente zum **System Design**
- Verzeichnis 3_Implementation:
    - enthälte guideline.md Dateien für jede eingesetzte Technologie
    - enthält alle Artefakte der **Implementation**
- Verzeichnis 4_Stories
    - enthält für jede **Story** ein Verzeichnis mit allen zur Story gehörenden Dokumenten