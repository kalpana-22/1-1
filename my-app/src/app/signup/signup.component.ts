import { Component, OnInit, ViewChild } from '@angular/core';
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
@ViewChild('fform') signupformDirective;

formErrors = {
  'username': '',
  'email': '',
  'phonenumber': '',
  'password': '',
 // 'rpassword': ''
}

validationMessages = {
  'username': {
    'required': 'User name is required',
    'minlength':     'First Name must be at least 2 characters long.',
      'maxlength':     'FirstName cannot be more than 25 characters long.'
  },
  'email': {
    'required': 'Email is required.',
    'email': 'Email not in valid format.'
  },
  'phonenumber': {
    'required':      'Tel. number is required.',
    'pattern':       'Tel. number must contain only numbers.'
  },
  'password': {
    'required': 'Password is required',
    'minlength':     'Password must be at least 2 characters long.',
      'maxlength':     'Password cannot be more than 16 characters long.'
   },
  // 'rpassword': {
  //   'required': 'Password is required',
  //   'minlength':     'Password must be at least 2 characters long.',
  //     'maxlength':     'Password cannot be more than 16 characters long.'
  // },
};

  constructor(private fb: FormBuilder) { 
    this.createForm();
  }

  ngOnInit() {
    
  }

  createForm() {
    this.signupform = this.fb.group({
      username: ['', [Validators.required, Validators.minLength(2), Validators.maxLength(25)] ],
      email: ['',[Validators.required, Validators.email]],
      phonenumber: [0,[Validators.required, Validators.pattern]],
      password: ['',[Validators.required, Validators.minLength(2), Validators.maxLength(16)]]
      //rpassword: ['',[Validators.required, Validators.minLength(2), Validators.maxLength(16)]]
    });

    this.signupform.valueChanges
      .subscribe(data => this.onValueChanged(data));

    this.onValueChanged();
  }

  onValueChanged(dat?: any) {
    if (!this.signupform) {return;}
    const form = this.signupform;
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
    this.register = this.signupform.value;
    console.log(this.register);
    this.signupform.reset({
      username: '',
      email: '',
      phonenumber: 0,
      password: '',
     // rpassword: ''
    });
    this.signupformDirective.resetForm();
  }    
}
