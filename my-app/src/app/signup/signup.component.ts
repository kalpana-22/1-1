import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Register } from '../shared/register';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

signupform: FormGroup;
register: Register;

  constructor(private fb: FormBuilder) { 
    this.createForm();
  }

  ngOnInit() {
    
  }

  createForm() {
    this.signupform = this.fb.group({
      username: '',
      email: '',
      phonenumber: 0,
      password: '',
      rpassword: ''
    });
  }
    
  onSubmit() {
    this.register = this.signupform.value;
    console.log(this.register);
    this.signupform.reset();
  }    
}
