import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Folklore } from '../models/folklore';
import { Observable, catchError, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class FolkloreService {
  private url = environment.baseUrl + 'api/folklore';

  constructor(private http: HttpClient) {}

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

  public create(newFolklore: Folklore): Observable<Folklore> {
    newFolklore.name = '';
    newFolklore.category = '';
    newFolklore.description = '';
    newFolklore.imageUrl = '';
    newFolklore.location;
    newFolklore.lore;
    newFolklore.loreUrl;
    return this.http.post<Folklore>(this.url, newFolklore).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () =>
            new Error('FolkloreService.Create(): error creating lore: ' + err)
        );
      })
    );
  }

  public update(editFolklore: Folklore): Observable<Folklore> {
    if (editFolklore.name === null || '') {
      //FIX ME SO IT WILLL RETURN AN ERROR IF THIS IS ATTEMPTED
    }
    if (editFolklore.description === null || '') {
        //FIX ME SO IT WILLL RETURN AN ERROR IF THIS IS ATTEMPTED
      }
    if (editFolklore.category){
      //FIX ME SO IT WILLL RETURN AN ERROR IF THIS IS ATTEMPTED or returna  message
      //saying it cannot be empty
    }
    return this.http
      .put<Folklore>(this.url + '/' + editFolklore.id, editFolklore)
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError(
            () =>
              new Error(
                'FolkloreService.update(): error updating Folklore: ' + err
              )
          );
        })
      );
  }

  Delete(id: number): Observable<void> {
    return this.http.delete<void>(this.url + '/' + id).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () =>
            new Error(
              'FolkloreService.index(): error deleting folklore: ' + err
            )
        );
      })
    );
  }

  showDetailedFolklore(folkloreId: number): Observable<Folklore> {
    return this.http.get<Folklore>(this.url + '/' + folkloreId).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () =>
            new Error(
              'FolkloreService.showDetailedFolklore(): error retrieving folklore: ' +
                err
            )
        );
      })
    );
  }
}
