import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  private apiUrl = 'http://localhost:8080/';

  constructor(private http: HttpClient) {}

  getUFs(): Observable<any> {
    return this.http.get(this.apiUrl + 'estados/siglas');
  }

  login(cpf: String, senha: String): Observable<any> {
    const body = { cpf, senha };
    return this.http.post(this.apiUrl + 'funcionarios/login', body)
      .pipe(
        catchError((error: HttpErrorResponse) => {
          if (error.status === 400) {
            console.error('Erro 400 - Bad Request:', error.error);
          }
          return throwError(() => error);
        })
      );
  }
}