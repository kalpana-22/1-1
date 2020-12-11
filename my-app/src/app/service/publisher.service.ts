import { Injectable } from '@angular/core';
import {Publisher} from '../shared/publishers';
import {PUBLISHERS} from '../shared/publications';
import { Observable, of, pipe } from 'rxjs';
import { delay } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PublisherService {

  constructor() { }

  getPublishers(): Observable<Publisher[]> {
    return of(PUBLISHERS).pipe();
  }

  getPublisher(id: string) : Observable<Publisher> {
    return of(PUBLISHERS.filter((publisher) => (publisher.id === id))[0]).pipe();
  }

  getPublishersId(): Observable<string[] | any> {
    return of(PUBLISHERS.map(publisher => publisher.id));
  }
}
