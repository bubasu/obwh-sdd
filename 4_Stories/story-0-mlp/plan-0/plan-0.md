### Implementation Suggestions for Story 0: Minimum Lovable Product (MLP)

Based on the specifications in `story-0-mlp.md`, `obwh-product-design.md`, and `obwh-system-design.md`, I have structured the following technical recommendations for implementation.

### 1. Project Structure (Gradle Multi-Module)
To create a sustainable and scalable structure, a Gradle multi-module project in the `3_Implementation` directory is recommended. This allows for a clean separation of API definition, backend, and frontend.

```text
3_Implementation/
├── obwh-api/            # Contains the OpenAPI specification and generated code
├── obwh-backend/         # Spring Boot application
├── obwh-frontend/        # Angular application
├── build.gradle          # Root build configuration
└── settings.gradle       # Definition of the modules
```

### 2. API-First & Code Generation
Since the API serves as the link, it should function as an independent module (`obwh-api`).

- **Tool**: Use the `org.openapi.generator` Gradle plugin.
- **Backend Generation**: Generate Java interfaces (`Library: spring-boot`) with `@RestController` annotations. The backend then simply implements these interfaces.
- **Frontend Generation**: Generate an Angular service (`Library: angular`) including all TypeScript models. This saves time and prevents type errors between the frontend and backend.

### 3. Backend (Spring Boot)
Since no database is planned for the MLP, the focus is on the business logic of the quiz.

- **Mock Service**: Create a `QuizService` class that holds a static list of `QuoteQuestion` objects in German, English, and Latin (as required in the Product Design).
- **Statelessness**: The backend does not store game states. The `correctBookId` is still sent to the frontend in plaintext in the MLP (as suggested in the System Design).
- **Randomization Logic**: Implement an algorithm that selects a random quote and two "distractors" (wrong answers) for each `/quiz/start` or `nextChallenge` response.

### 4. Frontend (Angular)
The frontend controls the "game loop" and the user experience design.

- **Game State Management**: Use a simple service (or a local state object) to manage the current round, time, and collected results.
- **Timer Component**: Implement a timer using `rxjs` (`interval(1000)`) that counts down from 60 seconds.
- **Responsiveness**: Use CSS Grid or Flexbox for the display of the quote question and the three buttons, so the game is also easily playable on mobile devices.
- **Animations**: Use `@angular/animations` for simple success or failure messages (e.g., fading in the correct solution upon error).

### 5. Deployment & Docker (Sliplane.io)
For deployment on Sliplane.io, you need efficient Docker images.

- **Multi-Stage Builds**:
  - **Backend**: One stage for building with Gradle, a second stage with a slim JRE (e.g., `eclipse-temurin:21-jre-alpine`).
  - **Frontend**: One stage for building (Node.js), a second stage with Nginx that serves the static Angular files.
- **Sliplane Integration**: Since Sliplane often relies on Docker Compose or directly on Dockerfiles, ensure that the frontend can configure the backend URL via an environment variable (e.g., via Nginx proxy or directly in the Angular environment).

### 6. Next Steps
1.  **Create Repository Structure**: Create the directories mentioned above in `3_Implementation`.
2.  **Finalize OpenAPI YAML**: Save the YAML content from the System Design in `obwh-api/src/main/resources/api.yaml`.
3.  **Generate Scaffold**: Run the first Gradle build to generate the API classes.
4.  **Mock Data**: Fill the backend service with the first 5-10 quotes in the three languages.

This approach ensures that you very quickly have a runnable system (MLP) that exactly matches the specification, while remaining flexible enough for later extensions (such as the admin component or a real database).
