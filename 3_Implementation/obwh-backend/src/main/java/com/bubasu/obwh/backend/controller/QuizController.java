package com.bubasu.obwh.backend.controller;

import com.bubasu.obwh.api.QuizApi;
import com.bubasu.obwh.model.QuoteQuestionResponse;
import com.bubasu.obwh.model.SolveRequest;
import com.bubasu.obwh.model.SolveResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuizController implements QuizApi {

    @Override
    public ResponseEntity<QuoteQuestionResponse> quizStartPost() {
        // Implementation logic for starting a quiz
        QuoteQuestionResponse response = new QuoteQuestionResponse();
        response.setQuote("To be, or not to be, that is the question.");
        // Add options and correctBookId here...
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<SolveResponse> quizSolvePost(SolveRequest solveRequest) {
        // Implementation logic for solving a quiz
        SolveResponse response = new SolveResponse();
        boolean isCorrect = solveRequest.getSelectedOptionId().equals(solveRequest.getCorrectBookId());
        response.setIsCorrect(isCorrect);
        response.setCorrectBookId(solveRequest.getCorrectBookId());
        return ResponseEntity.ok(response);
    }
}