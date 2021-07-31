import { HttpClient } from '@angular/common/http';
import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { catchError } from 'rxjs/operators';
import { ProcessHTTPMsgService } from '../service/process-httpmsg.service';
import { Register } from '../shared/register';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  errMess: any;
  publishers: any;
  //errMessa: any;//dan

  signupform = this.formBuilder.group({
    username:'',
    email: '',
    phonenumber: '',
    password: '',
  });

  constructor(
    private formBuilder: FormBuilder,
    private http: HttpClient,
    private processHTTPMsgService: ProcessHTTPMsgService
    ) {}

  ngOnInit() {
    
  }

  onSubmit(): void {

    this.http.post<void>('http://localhost:8080/api/author',this.signupform.value)
    .pipe(catchError(this.processHTTPMsgService.handleError)).subscribe(publisher => this.publishers = publisher,
      errmess => this.errMess = <any>errmess);
    // Process checkout data here
    console.warn('Your order has been submitted', this.signupform.value);
    this.signupform.reset();
  } 

  // onSubmit(): void {

  //   this.http.post<void>('http://localhost:8080/api/author',this.signupform.value)
  //   .pipe(catchError(this.processHTTPMsgService.handleError)).subscribe(publisher => {
  //     this.publishers = publisher;
  //     this.errMessa ='';},
  //     errmess =>{
  //       this.errMess = <any>errmess;
  //       this.errMessa = 'already exist';
  //     });
  //   // Process checkout data here
  //   console.warn('Your order has been submitted', this.signupform.value);
  //   this.signupform.reset();
  // } dan

  
}
