import { Injectable } from '@angular/core';
import {Publisher} from '../shared/publishers';
//import {PUBLISHERS} from '../shared/publications';
import { Observable, of, pipe } from 'rxjs';
import { delay, map, catchError } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { baseURL } from '../shared/baseurl';

import { ProcessHTTPMsgService } from './process-httpmsg.service';
import { Feedback } from '../shared/feedback';
import { Register } from '../shared/register';

@Injectable({
  providedIn: 'root'
})
export class PublisherService {

  constructor(private http: HttpClient,
    private processHTTPMsgService: ProcessHTTPMsgService) { }

  getPublishers(): Observable<Publisher[]> {
    return this.http.get<Publisher[]>('http://localhost:8080/api/publisher')
    .pipe(catchError(this.processHTTPMsgService.handleError));
  }

  getPublisher(id: number) : Observable<Publisher> {
    return this.http.get<Publisher>('http://localhost:8080/api/publisher/' + id)
    .pipe(catchError(this.processHTTPMsgService.handleError));
  }

  getPublishersId(): Observable<number[] | any> {
    return this.getPublishers().pipe(map(publishers => publishers.map(publisher => publisher.id)))
    .pipe(catchError(error => error));
  }

  //2021/7/21/ me kalla // kalama 
  putPublisher(publisher: Publisher): Observable<Publisher>{ 
    const httpOption = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    };

    return this.http.put<Publisher>('http://localhost:8080/api/publisher/'  + publisher.id, publisher, httpOption)
    .pipe(catchError(this.processHTTPMsgService.handleError));
  }


 ///////////////////2021/7/26 sign up

  postAuthor(author: Register): Observable<Register> {
    const httpOption = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    };

    return this.http.post<Register>('http://localhost:8080/api/author/' + author, httpOption)
    .pipe(catchError(this.processHTTPMsgService.handleError));
  }

///////

  submitFeedback(feedback: Feedback): Observable<Feedback> {
    const httpOption = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    };

    return this.http.post<Feedback>(baseURL + 'feedback/' +  feedback, httpOption)
    .pipe(catchError(this.processHTTPMsgService.handleError));

    //return this.http.post<Feedback>(baseURL + 'feedback/' +  feedback, httpOption)
    //.pipe(catchError(this.processHTTPMsgService.handleError));
  }


}




//getPublisher(id: string) : Observable<Publisher> {
//  return of(PUBLISHERS.filter((publisher) => (publisher.id === id))[0]).pipe();
//}

//getPublishersId(): Observable<string[] | any> {
//  return of(PUBLISHERS.map(publisher => publisher.id));
//}