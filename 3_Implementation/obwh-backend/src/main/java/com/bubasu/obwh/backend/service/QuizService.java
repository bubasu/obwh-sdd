package com.bubasu.obwh.backend.service;

import com.bubasu.obwh.model.BookOption;
import com.bubasu.obwh.model.QuoteQuestionResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class QuizService {

    private final List<QuoteQuestion> mockQuotes = new ArrayList<>();
    private final Random random = new Random();

    public QuizService() {
        initMockData();
    }

    private void initMockData() {
        // German Quotes
        mockQuotes.add(new QuoteQuestion(
                "Es irrt der Mensch, solang er strebt.",
                "Faust: Der Tragödie erster Teil", "Johann Wolfgang von Goethe",
                Arrays.asList(
                        new BookOption().id(UUID.randomUUID().toString()).title("Die Leiden des jungen Werther").author("Johann Wolfgang von Goethe"),
                        new BookOption().id(UUID.randomUUID().toString()).title("Wallenstein").author("Friedrich Schiller")
                )
        ));

        mockQuotes.add(new QuoteQuestion(
                "Niemand ist mehr Sklave, als der sich für frei hält, ohne es zu sein.",
                "Die Wahlverwandtschaften", "Johann Wolfgang von Goethe",
                Arrays.asList(
                        new BookOption().id(UUID.randomUUID().toString()).title("Effi Briest").author("Theodor Fontane"),
                        new BookOption().id(UUID.randomUUID().toString()).title("Der Steppenwolf").author("Hermann Hesse")
                )
        ));

        // English Quotes
        mockQuotes.add(new QuoteQuestion(
                "To be, or not to be, that is the question.",
                "Hamlet", "William Shakespeare",
                Arrays.asList(
                        new BookOption().id(UUID.randomUUID().toString()).title("Macbeth").author("William Shakespeare"),
                        new BookOption().id(UUID.randomUUID().toString()).title("King Lear").author("William Shakespeare")
                )
        ));

        mockQuotes.add(new QuoteQuestion(
                "All animals are equal, but some animals are more equal than others.",
                "Animal Farm", "George Orwell",
                Arrays.asList(
                        new BookOption().id(UUID.randomUUID().toString()).title("1984").author("George Orwell"),
                        new BookOption().id(UUID.randomUUID().toString()).title("Brave New World").author("Aldous Huxley")
                )
        ));

        mockQuotes.add(new QuoteQuestion(
                "It is a truth universally acknowledged, that a single man in possession of a good fortune, must be in want of a wife.",
                "Pride and Prejudice", "Jane Austen",
                Arrays.asList(
                        new BookOption().id(UUID.randomUUID().toString()).title("Sense and Sensibility").author("Jane Austen"),
                        new BookOption().id(UUID.randomUUID().toString()).title("Jane Eyre").author("Charlotte Brontë")
                )
        ));

        // Latin Quotes
        mockQuotes.add(new QuoteQuestion(
                "Gallia est omnis divisa in partes tres.",
                "Commentarii de Bello Gallico", "Gaius Iulius Caesar",
                Arrays.asList(
                        new BookOption().id(UUID.randomUUID().toString()).title("Aeneis").author("Publius Vergilius Maro"),
                        new BookOption().id(UUID.randomUUID().toString()).title("Metamorphoses").author("Publius Ovidius Naso")
                )
        ));

        mockQuotes.add(new QuoteQuestion(
                "Quousque tandem abutere, Catilina, patientia nostra?",
                "In Catilinam I", "Marcus Tullius Cicero",
                Arrays.asList(
                        new BookOption().id(UUID.randomUUID().toString()).title("De Officiis").author("Marcus Tullius Cicero"),
                        new BookOption().id(UUID.randomUUID().toString()).title("Odes").author("Quintus Horatius Flaccus")
                )
        ));
    }

    public QuoteQuestionResponse getRandomQuoteQuestion() {
        QuoteQuestion randomQuestion = mockQuotes.get(random.nextInt(mockQuotes.size()));

        BookOption correctOption = new BookOption()
                .id(UUID.randomUUID().toString())
                .title(randomQuestion.title)
                .author(randomQuestion.author);

        List<BookOption> options = new ArrayList<>(randomQuestion.distractors);
        options.add(correctOption);
        Collections.shuffle(options);

        return new QuoteQuestionResponse()
                .quote(randomQuestion.quote)
                .options(options)
                .correctBookId(correctOption.getId());
    }

    private static class QuoteQuestion {
        String quote;
        String title;
        String author;
        List<BookOption> distractors;

        QuoteQuestion(String quote, String title, String author, List<BookOption> distractors) {
            this.quote = quote;
            this.title = title;
            this.author = author;
            this.distractors = distractors;
        }
    }
}
