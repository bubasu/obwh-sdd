import { ApplicationConfig, provideZonelessChangeDetection } from '@angular/core'; // Updated import
import { provideRouter } from '@angular/router';
import { provideHttpClient } from '@angular/common/http';
import { BASE_PATH } from './api/variables';
import { routes } from './app.routes';

export const appConfig: ApplicationConfig = {
  providers: [
    // Switch to zoneless change detection
    provideZonelessChangeDetection(),
    provideRouter(routes),
    provideHttpClient(),
    { provide: BASE_PATH, useValue: 'http://localhost:8080' }
  ]
};
