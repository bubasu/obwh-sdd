# System Design of "Old Book Wisenheimer"

## Product Design

- [obwh-product-design.md](../../2_Design/Product/obwh-product-design.md)

## System Vision

See:
- [obwh-system-vision.md](../../1_Vision/System/obwh-system-vision.md)

## API

Here is a proposal for the API:

Code should be generated from this API, which can be integrated into the Angular frontend and the Spring Boot backend.

```yaml
openapi: 3.0.3
info:
  title: Old Book Wisenheimer (Iterative Base)
  version: 0.1.0
  description: Basic functional API for initial development. Security layers (JWE) and affiliate logic are omitted for simplicity.

paths:
  /quiz/start:
    post:
      summary: Initialize a new quiz round.
      description: Returns a random quote and potential book options including the plaintext solution for development purposes.
      responses:
        '200':
          description: A new quote-question has been created.
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/QuoteQuestionResponse'

  /quiz/solve:
    post:
      summary: Validate the player's answer.
      description: Compares the selected option against the provided correct ID.
      requestBody:
        required: true
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/SolveRequest'
      responses:
        '200':
          description: Validation result.
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/SolveResponse'

components:
  schemas:
    QuoteQuestionResponse:
      type: object
      required: [quote, options, correctBookId]
      properties:
        quote:
          type: string
          description: "The literary quote in its original language."
        options:
          type: array
          minItems: 3
          maxItems: 3
          items:
            $ref: '#/components/schemas/BookOption'
        correctBookId:
          type: string
          description: "Plaintext ID of the correct book (Development only)."

    BookOption:
      type: object
      required: [id, title, author]
      properties:
        id:
          type: string
          description: "Unique identifier for the book option."
        title:
          type: string
          description: "The title of the book."
        author:
          type: string
          description: "Name of the author (or 'Anonym')."

    SolveRequest:
      type: object
      required: [selectedOptionId, correctBookId]
      properties:
        selectedOptionId:
          type: string
          description: "The ID of the book chosen by the player."
        correctBookId:
          type: string
          description: "The solution ID passed back to the server for verification."

    SolveResponse:
      type: object
      required: [isCorrect, correctBookId]
      properties:
        isCorrect:
          type: boolean
          description: "True if the selectedOptionId matches the correctBookId."
        correctBookId:
          type: string
          description: "Returns the correct ID for feedback/UI display."
        nextChallenge:
          $ref: '#/components/schemas/QuoteQuestionResponse'
          description: "Optional next quote-question data if the answer was correct."