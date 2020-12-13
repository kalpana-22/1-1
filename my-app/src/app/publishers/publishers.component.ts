import { Component, OnInit } from '@angular/core';
import { from } from 'rxjs';
import { Publisher } from '../shared/publishers';
import { PublisherService } from '../service/publisher.service';

@Component({
  selector: 'app-publishers',
  templateUrl: './publishers.component.html',
  styleUrls: ['./publishers.component.css']
})
export class PublishersComponent implements OnInit {

  publishers: Publisher[];

  selectedPublisher: Publisher;
  
  constructor(private publisherService: PublisherService) { }

  ngOnInit() {
    this.publisherService.getPublishers()
      .subscribe(publisher => this.publishers = publisher);
  }

  onSelect(publishers: Publisher) {
    this.selectedPublisher = publishers;
  }
}

