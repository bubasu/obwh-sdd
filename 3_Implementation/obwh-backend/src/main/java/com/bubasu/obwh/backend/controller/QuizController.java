package com.bubasu.obwh.backend.controller;

import com.bubasu.obwh.api.QuizApi;
import com.bubasu.obwh.backend.service.QuizService;
import com.bubasu.obwh.model.QuoteQuestionResponse;
import com.bubasu.obwh.model.SolveRequest;
import com.bubasu.obwh.model.SolveResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuizController implements QuizApi {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @Override
    public ResponseEntity<QuoteQuestionResponse> quizStartPost() {
        return ResponseEntity.ok(quizService.getRandomQuoteQuestion());
    }

    @Override
    public ResponseEntity<SolveResponse> quizSolvePost(SolveRequest solveRequest) {
        SolveResponse response = new SolveResponse();
        boolean isCorrect = solveRequest.getSelectedOptionId().equals(solveRequest.getCorrectBookId());
        response.setIsCorrect(isCorrect);
        response.setCorrectBookId(solveRequest.getCorrectBookId());

        if (isCorrect) {
            response.setNextChallenge(quizService.getRandomQuoteQuestion());
        }

        return ResponseEntity.ok(response);
    }
}