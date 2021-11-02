import { Injectable } from '@angular/core';
import { catchError } from 'rxjs/internal/operators';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class RestService {
  endpoint = 'http://localhost:8080/';

  constructor(private http: HttpClient) { }

  getProducts(): Observable<any> {
    return this.http.get(this.endpoint + 'stock?lookingItem=INTC')
  }

  getProductsByItem(item: string): Observable<any> {
    return this.http.get(this.endpoint + 'stock?lookingItem=' + item)
  }

  getProductsByList(items: string): Observable<any> {
    return this.http.get(this.endpoint + 'stocks?lookingItems=' + items)
  }

  getAverage(items: string): Observable<any> {
    return this.http.get(this.endpoint + 'average?lookingItems=' + items)
  }

  private extractData(res: any): any {
    const body = res;
    return body || { };
  }

  private handleError(error: HttpErrorResponse): any {
    if (error.error instanceof ErrorEvent) {
      console.error('An error occurred:', error.error.message);
    } else {
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    return throwError(
      'Something bad happened; please try again later.');
  }
}
