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

  //disabled = false;
  //ShowFilter = false;
  //limitSelection = false;
  //cities: any = [];
  //selectedItems: any =[];
  //dropdownSettings: any ={};

  Publishers = [
    {id: 0, name: 'Ariya Publishers'},
    {id: 1, name: 'A'},
    {id: 2, name: 'B'},
    {id: 3, name: 'D'}
];

  //dropdownList = [];
  //selectedItems = [];
  //dropdownSettings:IDropdownSettings;
  
  constructor() { }

  ngOnInit() {

  //  this.cities = [
    //   { item_id: 0, item_text: 'Ariya Publisher' },
       //{ item_id: 1, item_text: 'A' },
      // { item_id: 2, item_text: 'B' },
      // { item_id: 3, item_text: 'C' }
     //];

    // this.selectedItems= [{item_id: 0,item_text: 'Ariya Publisher'}];

   //  this.dropdownSettings = {
    //    singleSelection: false,
     //   idField: 'item_id',
     //   textField: 'item_text',
     //   selectAllText: 'Select All',
     //   unSelectAllText: 'UnSelect All',
     //   itemsShowLimit: 2,
     //   allowSearchFilter: this.ShowFilter
      };
    
     

   // this.dropdownList = [
     // { item_id: 0, item_text: 'Ariya Publisher' },
     // { item_id: 1, item_text: 'A' },
     // { item_id: 2, item_text: 'B' },
     // { item_id: 3, item_text: 'C' }
    //];
  
    //this.selectedItems = [
      //{
        //item_id: 0, item_text: 'Ariya Publisher'
      //}
    //];

    //this.dropdownSettings = {
    //  singleSelection: false,
    //  idField: 'item_id',
    //  textField: 'item_text',
    //  selectAllText: 'Select All',
    //  unSelectAllText: 'UnSelect All',
    //  itemsShowLimit: 2,
    //  allowSearchFilter: true
    //};
 // }
 selectedPublishersIds: string[];


  onItemSelect(item: any) {
    console.log(item);
  }
  onSelectAll(items: any) {
    console.log(items);
  }
 // onItemSelect (item:any){
    //console.log.apply('onItemSelect',item);
  //}

//  onSelectAll (items: any){
   // console.log('onSelectAll',items);
 // }

}
