# Story 0: Minimum Lovable Product (MLP) of obwh

An MLP of obwh is to be designed and implemented.
Requirements and simplifications are defined, and corresponding initial documents for Product Design and System Design are created based on these.

Using this information, an initial runnable implementation will be generated.

## Requirements
- Define a Quiz API for the quiz using OpenAPI
- Generate code from the Quiz API (for frontend and backend)
- Build an Angular frontend for the quiz UI, which:
    - calls the Quiz API
    - uses the code generated from the Quiz API
- Build a Spring Boot backend, which:
    - provides the Quiz API
    - uses the code generated from the Quiz API
- Design a directory structure that is sustainable for future developments (see Vision)
- Dockerfile(s) for a deployment via Sliplane.io

## Simplifications
- No database; quiz questions come from a mock service
- No real affiliate links
- No measures to protect affiliate links
- No measures to make cheating more difficult
- No Admin component
