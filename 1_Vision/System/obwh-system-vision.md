# System Vision of "Old Book Wisenheimer"

## Quiz and Admin Components

There are two components:
- **Quiz** component, which realizes the quiz
    - Workflow and User Interface / User Experience
- **Admin** component, which is responsible for:
    - generating and curating high-quality quiz questions using AI
    - managing affiliate links from books to bookstores

### Quiz Component

The Quiz component consists of a web frontend that communicates with a backend via an API.
The backend is stateless.

Protecting the affiliate links through various measures is crucial.
A suspension by an affiliate partner must not happen.

Furthermore, measures are in place to make cheating more difficult.

The Quiz component is publicly accessible without credentials and is permanently available online.

### Admin Component

The Admin component also consists of a web frontend and a backend.
The frontend communicates with the backend via an API.
The backend does not have to be stateless.

The Admin component is only accessible to an admin user protected by credentials.

The Admin component is not necessarily permanently available online, but can be switched on for admin activities and switched off again afterwards.

## Database

There is a database for quiz questions, books, affiliate links, etc.
This database is used by both the Quiz component and the Admin component.
