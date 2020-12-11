import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  

signupform: FormGroup;
errorList:string[];
username:FormControl;
email:FormControl;
phonenumber:FormControl;
password:FormControl;
rpassword:FormControl;

  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {
    
    this.signupform = this.fb.group({});
    this.username = new FormControl('', Validators.required );
    this.phonenumber = new FormControl('', [Validators.required, Validators.pattern("[0-9 ]{11}")] );
    this.email = new FormControl('', [Validators.required, Validators.email]);
    this.password = new FormControl('',[Validators.required, Validators.maxLength(15),Validators.minLength(5)]);
    this.rpassword = new FormControl('',Validators.required);
  }

  
    
}
