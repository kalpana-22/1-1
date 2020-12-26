import { Component, OnInit, ViewChild, Inject } from '@angular/core';
import { Params , ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { Publisher } from '../shared/publishers';
import { PublisherService } from '../service/publisher.service';
import { switchMap } from 'rxjs/operators';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Comment } from '../shared/comment';



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
  @ViewChild('cform') commentFormDirective;
  comment: Comment;
  commentForm: FormGroup;

  formErrors = {
    'author': '',
    'comment': ''
  };

  validationMessages = {
    'author': {
      'required': 'Author Name is required.',
      'minlength': 'Author Name must be at least 2 charactors'
    },
    'comment': {
      'required': 'Comment is required.'
    }
  };

  constructor(private publisherService: PublisherService, 
    private route: ActivatedRoute , 
    private location: Location ,
    private fb: FormBuilder
    ) { }
  
  ngOnInit() {
    this.createForm();

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

  createForm() {
    this.commentForm = this.fb.group({
      author: ['', [Validators.required, Validators.minLength(2), Validators.maxLength(25)] ],
      rating: 5,
      comment: ['',Validators.required]
    });

    this.commentForm.valueChanges
      .subscribe(data => this.onValueChanged(data));

    this.onValueChanged();
  }

  onValueChanged(dat?: any) {
    if (!this.commentForm) {return;}
    const form = this.commentForm;
    for (const field in this.formErrors) {
      if (this.formErrors.hasOwnProperty(field)) {
        // clear previous error message (if any)
        this.formErrors[field] = '';
        const control = form.get(field);
        if (control && control.dirty && !control.valid) {
          const messages = this.validationMessages[field];
          for (const key in control.errors) {
            if (control.errors.hasOwnProperty(key)) {
              this.formErrors[field] += messages[key] + ' ';
            }
          }
        }
      }
    }
  }
    
  onSubmit() {
    this.comment = this.commentForm.value;
    this.comment.date = new Date().toISOString();
    console.log(this.comment);
    this.publishers.comments.push(this.comment);
    this.commentFormDirective.resetForm();
    this.commentForm.reset({
      author: '',
      rating: 5,
      comment: ''
    });
    
  }

  

}
