import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatToolbarModule } from '@angular/material/toolbar'; 
import { MatListModule } from '@angular/material/list';
import { MatGridListModule } from '@angular/material/grid-list';
import { FlexLayoutModule } from '@angular/flex-layout';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';

//add from
//import { AppBoostrapModule } from './app-boostrap/app-boostrap.module';


//import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
//import { TooltipModule } from 'ngx-bootstrap/tooltip';
//import { ModalModule } from 'ngx-bootstrap/modal';

import { AppComponent } from './app.component';

import 'hammerjs';

import { HomeComponent } from './home/home.component';
import { PublishersComponent } from './publishers/publishers.component';
import { PublicationdetailComponent } from './publicationdetail/publicationdetail.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    PublishersComponent,
    PublicationdetailComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FlexLayoutModule,
    MatToolbarModule,
    MatListModule,
    MatGridListModule,
    MatCardModule,
    MatButtonModule

    //AppBoostrapModule,
    //BsDropdownModule.forRoot(),
    //TooltipModule.forRoot(),
    //ModalModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
