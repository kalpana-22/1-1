import { Component, OnInit } from '@angular/core';
import {Publisher} from '../shared/publishers';
import {PUBLISHERS} from '../shared/publications';


@Component({
  selector: 'app-publishers',
  templateUrl: './publishers.component.html',
  styleUrls: ['./publishers.component.css']
})
export class PublishersComponent implements OnInit {

  publishers: Publisher[] = PUBLISHERS;

  selectedPublisher: Publisher;
  
  constructor() { }

  ngOnInit(): void {
  }

  onSelect(publishers: Publisher) {
    this.selectedPublisher = publishers;
  }
}

