import { Injectable } from '@angular/core';
import {Publisher} from '../shared/publishers';
//import {PUBLISHERS} from '../shared/publications';
import { Observable, of, pipe } from 'rxjs';
import { delay, map } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { baseURL } from '../shared/baseurl';

@Injectable({
  providedIn: 'root'
})
export class PublisherService {

  constructor(private http: HttpClient) { }

  getPublishers(): Observable<Publisher[]> {
    return this.http.get<Publisher[]>(baseURL + 'publisher');
  }

  getPublisher(id: number) : Observable<Publisher> {
    return this.http.get<Publisher>(baseURL + 'publisher/' + id);
  }

  getPublishersId(): Observable<number[] | any> {
    return this.getPublishers().pipe(map(publishers => publishers.map(publisher => publisher.id)));
  }
}




//getPublisher(id: string) : Observable<Publisher> {
//  return of(PUBLISHERS.filter((publisher) => (publisher.id === id))[0]).pipe();
//}

//getPublishersId(): Observable<string[] | any> {
//  return of(PUBLISHERS.map(publisher => publisher.id));
//}