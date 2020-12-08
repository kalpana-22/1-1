import { Injectable } from '@angular/core';
import {Publisher} from '../shared/publishers';
import {PUBLISHERS} from '../shared/publications';
import { of } from 'rxjs';
import { delay } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PublisherService {

  constructor() { }

  getPublishers(): Publisher[] {
    return PUBLISHERS;
  }

  getPublisher(id: string) : Publisher {
    return PUBLISHERS.filter((publisher) => (publisher.id === id))[0];
  }
}
