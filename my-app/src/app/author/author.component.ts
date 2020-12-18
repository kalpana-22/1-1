import { Component, OnInit } from '@angular/core';
//import { IDropdownSettings } from 'ng-multiselect-dropdown';
import { FormsModule } from '@angular/forms'; 
import { NgSelectModule } from '@ng-select/ng-select';
import { Observable, of, pipe } from 'rxjs';
/////
import { PublisherService } from '../service/publisher.service';
import { Publisher } from '../shared/publishers';
import { HttpClient } from '@angular/common/http';
import { FormGroup, FormControl, Validators} from '@angular/forms';


/////////////

@Component({
  selector: 'app-author',
  templateUrl: './author.component.html',
  styleUrls: ['./author.component.css']
})
export class AuthorComponent implements OnInit {

  publishers: Publisher; 
  selectedPublishersIds: string[];

  myForm = new FormGroup({
    name: new FormControl('', [Validators.required, Validators.minLength(3)]),

    file: new FormControl('', [Validators.required]),

    fileSource: new FormControl('', [Validators.required])
  });

  Publishers = [
    {id: 0, name: 'Ariya Publishers'},
    {id: 1, name: 'A'},
    {id: 2, name: 'B'},
    {id: 3, name: 'D'}
];

  
  
  constructor(private http: HttpClient) { }

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

   

    this.http.post('http://localhost:8001/upload.php', formData)

      .subscribe(res => {

        console.log(res);

        alert('Uploaded Successfully.');

      })

  }

  ngOnInit() {

      };
    
   
 //selectedPublishersIds: string[];


  //onItemSelect(item: any) {
  //  console.log(item);
 // }
  //onSelectAll(items: any) {
    //console.log(items);
  //}
 

}
