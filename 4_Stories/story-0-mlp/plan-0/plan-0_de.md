### Vorschläge für die Implementierung der Story 0: Minimum Lovable Product (MLP)

Basierend auf den Spezifikationen in `story-0-mlp.md`, `obwh-product-design.md` und `obwh-system-design.md` habe ich die folgenden technischen Empfehlungen für die Umsetzung strukturiert.

### 1. Projektstruktur (Gradle Multi-Module)
Um eine tragfähige und skalierbare Struktur zu schaffen, empfiehlt sich ein Gradle Multi-Module Projekt im Verzeichnis `3_Implementation`. Dies ermöglicht eine saubere Trennung von API-Definition, Backend und Frontend.

```text
3_Implementation/
├── obwh-api/            # Enthält die OpenAPI Spezifikation und generierten Code
├── obwh-backend/         # Spring Boot Anwendung
├── obwh-frontend/        # Angular Anwendung
├── build.gradle          # Root Build-Konfiguration
└── settings.gradle       # Definition der Module
```

### 2. API-First & Codegenerierung
Da die API das Bindeglied ist, sollte sie als eigenständiges Modul (`obwh-api`) fungieren.

- **Werkzeug**: Verwenden Sie das `org.openapi.generator` Gradle Plugin.
- **Backend-Generierung**: Generieren Sie Java-Interfaces (`Library: spring-boot`) mit `@RestController` Annotationen. Das Backend implementiert dann einfach diese Interfaces.
- **Frontend-Generierung**: Generieren Sie einen Angular-Service (`Library: angular`) inklusive aller TypeScript-Modelle. Das spart Zeit und verhindert Typfehler zwischen Frontend und Backend.

### 3. Backend (Spring Boot)
Da im MLP keine Datenbank vorgesehen ist, liegt der Fokus auf der Geschäftslogik des Quiz.

- **Mock-Service**: Erstellen Sie eine `QuizService`-Klasse, die eine statische Liste von `QuoteQuestion`-Objekten in Deutsch, Englisch und Latein hält (wie im Product Design gefordert).
- **Statelessness**: Das Backend speichert keine Spielstände. Die `correctBookId` wird (wie im System Design vorgeschlagen) im MLP noch im Klartext an das Frontend gesendet.
- **Zufallslogik**: Implementieren Sie einen Algorithmus, der bei jedem `/quiz/start` oder bei `nextChallenge` in der Antwort ein zufälliges Zitat und zwei "Distraktoren" (falsche Antworten) auswählt.

### 4. Frontend (Angular)
Das Frontend steuert die "Game Loop" und das User Experience Design.

- **Game-State-Management**: Nutzen Sie einen einfachen Service (oder ein lokales State-Objekt), um die aktuelle Runde, die Zeit und die gesammelten Ergebnisse zu verwalten.
- **Timer-Komponente**: Implementieren Sie einen Timer mit `rxjs` (`interval(1000)`), der von 60 Sekunden herunterzählt.
- **Responsivität**: Verwenden Sie CSS Grid oder Flexbox für die Darstellung der Zitat-Frage und der drei Buttons, damit das Spiel auch auf Mobilgeräten gut spielbar ist.
- **Animationen**: Nutzen Sie `@angular/animations` für einfache Erfolgs- oder Misserfolgsmeldungen (z.B. Einblenden der richtigen Lösung bei Fehler).

### 5. Deployment & Docker (Sliplane.io)
Für das Deployment auf Sliplane.io benötigen Sie effiziente Docker-Images.

- **Multi-Stage Builds**:
    - **Backend**: Ein Stage zum Bauen mit Gradle, ein zweites Stage mit einem schlanken JRE (z.B. `eclipse-temurin:21-jre-alpine`).
    - **Frontend**: Ein Stage zum Bauen (Node.js), ein zweites Stage mit Nginx, das die statischen Angular-Dateien ausliefert.
- **Sliplane-Integration**: Da Sliplane oft auf Docker Compose oder direkt auf Dockerfiles setzt, stellen Sie sicher, dass das Frontend die Backend-URL über eine Umgebungsvariable konfigurieren kann (z.B. via Nginx Proxy oder direkt im Angular Environment).

### 6. Nächste Schritte
1.  **Repository-Struktur anlegen**: Erstellen Sie die oben genannten Verzeichnisse in `3_Implementation`.
2.  **OpenAPI YAML finalisieren**: Speichern Sie den YAML-Inhalt aus dem System Design in `obwh-api/src/main/resources/api.yaml`.
3.  **Grundgerüst generieren**: Führen Sie den ersten Gradle-Build aus, um die API-Klassen zu erzeugen.
4.  **Mock-Daten**: Befüllen Sie den Backend-Service mit den ersten 5-10 Zitaten in den drei Sprachen.

Diese Vorgehensweise stellt sicher, dass Sie sehr schnell ein lauffähiges System (MLP) haben, das exakt der Spezifikation entspricht, aber gleichzeitig flexibel genug für spätere Erweiterungen (wie die Admin-Komponente oder eine echte Datenbank) ist.