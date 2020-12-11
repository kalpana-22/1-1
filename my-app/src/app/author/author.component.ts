import { Component, OnInit } from '@angular/core';
//import { IDropdownSettings } from 'ng-multiselect-dropdown';
import { FormsModule } from '@angular/forms'; 
import { NgSelectModule } from '@ng-select/ng-select';

/////////////

@Component({
  selector: 'app-author',
  templateUrl: './author.component.html',
  styleUrls: ['./author.component.css']
})
export class AuthorComponent implements OnInit {

 

  Publishers = [
    {id: 0, name: 'Ariya Publishers'},
    {id: 1, name: 'A'},
    {id: 2, name: 'B'},
    {id: 3, name: 'D'}
];

  
  
  constructor() { }

  ngOnInit() {

      };
    
   
 selectedPublishersIds: string[];


  onItemSelect(item: any) {
    console.log(item);
  }
  onSelectAll(items: any) {
    console.log(items);
  }
 

}
