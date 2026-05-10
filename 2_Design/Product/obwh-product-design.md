# Product Design of "Old Book Wisenheimer"

## Product Vision

See [obwh-product-vision.md](../../1_Vision/Product/obwh-product-vision.md)

## Game Workflow

Immediately after opening the interface, the game loop starts with Round 1 and the first quote question:

1. Random quote question, timer counts down, 1 minute to guess
2. Book is guessed before the timer expires
    - Round success (animation, message)
    - Round = Round + 1; go to 1.
3. Timer expires or wrong book is selected
    - Round failure (animation, message), display correct selection
    - Display overall result
    - Show "Try Again" button
4. Click on "Try Again"
    - Round = 1; go to 1.

### Additions to the Game Workflow

The quote questions are selected randomly across all languages.
(A true Wisenheimer is proficient in several languages.)

Representation of a quote question:
- Quote
- Buttons for the three books to choose from, each with:
    - Title and (in parentheses) author(s) or "Anonymous"

Representation of the overall result:
- Number of rounds completed and the total time taken
- Representation of each round:
    - Time per round
    - Representation of the answer to a quote question:
        - Quote
        - The three book options, where:
            - Correct book is specially marked
            - Guessed book is specially marked
            - Affiliate links to each book

## Quote Questions

A quote question consists of:
- a quote
- a selection of three books, of which:
    - one book is correct (contains the given quote)
    - and two books are incorrect (do not contain the given quote)

Further criteria for quote questions:
- The quote is meaningful (allows a conclusion to be drawn about the associated book)
- The incorrect options are good distractors (not too obviously wrong)

Criteria for the books from which the quote questions originate:
- The books are in the public domain
- Only original works are permitted, no translations
- The books come from the following three languages:
    - German
    - English
    - Latin