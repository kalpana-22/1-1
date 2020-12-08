import { Component, OnInit } from '@angular/core';
import { Params , ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { Publisher } from '../shared/publishers';
import { PublisherService } from '../service/publisher.service';

@Component({
  selector: 'app-publicationdetail',
  templateUrl: './publicationdetail.component.html',
  styleUrls: ['./publicationdetail.component.css']
})


export class PublicationdetailComponent implements OnInit {

  
  publishers: Publisher;

  constructor(private publisherService: PublisherService, private route: ActivatedRoute , private location: Location) { }
  
  ngOnInit() {

    let id = this.route.snapshot.params['id'];
    this.publishers = this.publisherService.getPublisher(id);

  }

  goBack() {
    this.location.back();
  }


}
