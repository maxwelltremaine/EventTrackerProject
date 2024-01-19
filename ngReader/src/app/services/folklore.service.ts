import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Folklore } from '../models/folklore';
import { Observable, catchError, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FolkloreService {

  private url = environment.baseUrl + 'api/folklore';



  constructor(
    private http: HttpClient
  ) { }

  index(): Observable<Folklore[]> {
    return this.http.get<Folklore[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('Folklore.index(): error retrieving folklore: ' + err)
        );
      })
    );
  }






}
