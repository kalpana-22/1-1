import { Injectable } from '@angular/core';
import {Publisher} from '../shared/publishers';
//import {PUBLISHERS} from '../shared/publications';
import { Observable, of, pipe } from 'rxjs';
import { delay, map, catchError } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { baseURL } from '../shared/baseurl';

import { ProcessHTTPMsgService } from './process-httpmsg.service';

@Injectable({
  providedIn: 'root'
})
export class PublisherService {

  constructor(private http: HttpClient,
    private processHTTPMsgService: ProcessHTTPMsgService) { }

  getPublishers(): Observable<Publisher[]> {
    return this.http.get<Publisher[]>(baseURL + 'publisher')
    .pipe(catchError(this.processHTTPMsgService.handleError));
  }

  getPublisher(id: number) : Observable<Publisher> {
    return this.http.get<Publisher>(baseURL + 'publisher/' + id)
    .pipe(catchError(this.processHTTPMsgService.handleError));
  }

  getPublishersId(): Observable<number[] | any> {
    return this.getPublishers().pipe(map(publishers => publishers.map(publisher => publisher.id)))
    .pipe(catchError(error => error));
  }
}




//getPublisher(id: string) : Observable<Publisher> {
//  return of(PUBLISHERS.filter((publisher) => (publisher.id === id))[0]).pipe();
//}

//getPublishersId(): Observable<string[] | any> {
//  return of(PUBLISHERS.map(publisher => publisher.id));
//}