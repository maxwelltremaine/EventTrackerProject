import { HttpClient, provideHttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FolkloreService {

  constructor(
    private http: HttpClient
  ) { }
}
