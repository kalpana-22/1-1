import { Component, OnInit } from '@angular/core';
import { Params , ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { Publisher } from '../shared/publishers';
import { PublisherService } from '../service/publisher.service';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-publicationdetail',
  templateUrl: './publicationdetail.component.html',
  styleUrls: ['./publicationdetail.component.css']
})


export class PublicationdetailComponent implements OnInit {


  publishers: Publisher;
  publishersIds: string[];
  prev: string;
  next: string;

  constructor(private publisherService: PublisherService, private route: ActivatedRoute , private location: Location) { }
  
  ngOnInit() {
    this.publisherService.getPublishersId()
      .subscribe((publishersIds) => this.publishersIds = publishersIds)
    this.route.params
      .pipe(switchMap((params: Params) => this.publisherService.getPublisher(params['id'])))
      .subscribe(publishers => { this.publishers = publishers; this.setPrevNext(publishers.id) });
  }

  setPrevNext(publishersIds: string) {
    const index = this.publishersIds.indexOf(publishersIds);
    this.prev = this.publishersIds[(this.publishersIds.length + index - 1) %this.publishersIds.length];
    this.next = this.publishersIds[(this.publishersIds.length + index + 1) %this.publishersIds.length];
  }

  goBack() {
    this.location.back();
  }


}
