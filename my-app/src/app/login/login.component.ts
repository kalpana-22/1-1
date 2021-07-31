import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { catchError } from 'rxjs/operators';//dan
import { ProcessHTTPMsgService } from '../service/process-httpmsg.service';//dan



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  ///dav
  errMess: any;
  publishers: any;
  errorMessage: string = '';

  loginform = this.formBuilder.group({
    username:'',
    password: '',
  });
  //d
  user = {username: '', password: '', remember: false};

  constructor( public dialogRef: MatDialogRef<LoginComponent>,
    private formBuilder: FormBuilder,//dan
    private http: HttpClient,//dan
    private processHTTPMsgService: ProcessHTTPMsgService//dan
    ) { }

  ngOnInit() {
  }

  // onSubmit() {
  //   console.log('User: ', this.user);  //kalin ek
  //   this.dialogRef.close();
  // }
  
  onSubmit(): void {

    this.http.post<void>('http://localhost:8080/api/account/login',this.user)
    .pipe(catchError(this.processHTTPMsgService.handleError))
    .subscribe(publisher => {
      this.publishers = publisher;
      this.errorMessage = '';
      this.dialogRef.close();
    },
      errmess => {
        this.errMess = <any>errmess;
        this.errorMessage = 'invalid username or password';
      });
    // Process checkout data here
    console.warn('log in', this.loginform.value);
    this.loginform.reset();
    
  } 
}
