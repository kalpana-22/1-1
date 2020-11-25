import { Injectable } from '@angular/core';
import {Publisher} from '../shared/publishers';
import {PUBLISHERS} from '../shared/publications';

@Injectable({
  providedIn: 'root'
})
export class PublisherService {

  constructor() { }

  getPublishers(): Publisher[] {
    return PUBLISHERS;
  }
}
