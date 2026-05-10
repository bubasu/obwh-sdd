import { Component, OnInit, signal, OnDestroy } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DefaultService } from './api/api/default.service';
import { QuoteQuestionResponse, SolveResponse } from './api/model/models';
import { Subscription, interval } from 'rxjs';
import { takeWhile } from 'rxjs/operators';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App implements OnInit, OnDestroy {
  // Signals for reactive state management
  currentQuestion = signal<QuoteQuestionResponse | null>(null);
  lastResult = signal<SolveResponse | null>(null);
  round = signal(0);
  timer = signal(60);
  gameActive = signal(false);

  private timerSubscription?: Subscription;

  constructor(private quizService: DefaultService) {}

  ngOnInit() {
    this.startNewGame();
  }

  ngOnDestroy() {
    this.timerSubscription?.unsubscribe();
  }

  startNewGame() {
    this.round.set(1);
    this.gameActive.set(true);
    this.lastResult.set(null);
    this.fetchNextQuestion();
  }

  private fetchNextQuestion() {
    this.quizService.quizStartPost().subscribe({
      next: (question) => {
        this.currentQuestion.set(question);
        this.startTimer();
      },
      error: (err) => console.error('Failed to load question', err)
    });
  }

  startTimer() {
    this.timer.set(60);
    this.timerSubscription?.unsubscribe();
    this.timerSubscription = interval(1000).pipe(
      takeWhile(() => this.timer() > 0 && this.gameActive())
    ).subscribe(() => {
      this.timer.update(t => t - 1);
      if (this.timer() === 0) this.handleFailure();
    });
  }

  selectOption(optionId: string) {
    if (!this.currentQuestion() || !this.gameActive()) return;

    this.quizService.quizSolvePost({
      selectedOptionId: optionId,
      correctBookId: this.currentQuestion()!.correctBookId
    }).subscribe((res) => {
      this.lastResult.set(res);
      if (res.isCorrect) {
        this.round.update(r => r + 1);
        if (res.nextChallenge) {
          this.currentQuestion.set(res.nextChallenge);
          this.startTimer();
        }
      } else {
        this.handleFailure();
      }
    });
  }

  handleFailure() {
    this.gameActive.set(false);
    this.timerSubscription?.unsubscribe();
  }
}
