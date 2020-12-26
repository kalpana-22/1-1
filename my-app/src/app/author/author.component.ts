import { Component, OnInit } from '@angular/core';
//import { IDropdownSettings } from 'ng-multiselect-dropdown';
import { FormsModule } from '@angular/forms'; 
import { NgSelectModule } from '@ng-select/ng-select';
import { Observable, of, pipe } from 'rxjs';
/////
import { PublisherService } from '../service/publisher.service';
import { Publisher } from '../shared/publishers';
import { HttpClient } from '@angular/common/http';
import { FormBuilder,FormGroup, FormControl, Validators} from '@angular/forms';
import { baseURL } from '../shared/baseurl';


@Component({
  selector: 'app-author',
  templateUrl: './author.component.html',
  styleUrls: ['./author.component.css']
})
export class AuthorComponent implements OnInit {
 
  publishers: Publisher[];
  
  myForm = new FormGroup({
    selectedPublishe:new FormControl([]), // ad by
    name: new FormControl('', [Validators.required, Validators.minLength(3)]),
    file: new FormControl('', [Validators.required]),
    fileSource: new FormControl('', [Validators.required])
  });

selectedPublishersIds: string[];

  
  constructor(private http: HttpClient,
    private fb: FormBuilder,
    private publisherService: PublisherService) { }

  get f(){
    return this.myForm.controls;
  }

  onFileChange(event) {
    if (event.target.files.length > 0) {
      const file = event.target.files[0];
      this.myForm.patchValue({
        fileSource: file
      });
    }
  }

  submit(){

    const formData = new FormData();
    formData.append('file', this.myForm.get('fileSource').value);
    console.log(this.myForm);
    this.http.post(baseURL, formData)
      .subscribe(res => {
        console.log(res);
        alert('Uploaded Successfully.');
      })

  }

  ngOnInit() {
    this.publisherService.getPublishers()
    .subscribe(publisher => this.publishers = publisher);
      };
    
   
 selectedPublishersIds: string[];


 // onItemSelect(item: any) {
 //   console.log(item);
 // }
 // onSelectAll(items: any) {
  //  console.log(items);
 // }

}
