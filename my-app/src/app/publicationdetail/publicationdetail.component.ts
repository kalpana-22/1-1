import { Component, OnInit, Input} from '@angular/core';
import { Publisher } from '../shared/publishers';


@Component({
  selector: 'app-publicationdetail',
  templateUrl: './publicationdetail.component.html',
  styleUrls: ['./publicationdetail.component.css']
})


export class PublicationdetailComponent implements OnInit {

  @Input()
  publishers: Publisher;

  constructor() { }

  ngOnInit() {
  }

}
