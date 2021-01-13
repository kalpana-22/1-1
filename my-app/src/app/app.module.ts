import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatToolbarModule } from '@angular/material/toolbar'; 
import { MatListModule } from '@angular/material/list';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatSelectModule } from '@angular/material/select';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import {MatSliderModule} from '@angular/material/slider';
import { FlexLayoutModule } from '@angular/flex-layout';
//import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';
import { FormsModule } from '@angular/forms'; 
import { ReactiveFormsModule } from '@angular/forms';



/*..My adding..*/
//import { AppBoostrapModule } from './app-boostrap/app-boostrap.module';


import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { TooltipModule } from 'ngx-bootstrap/tooltip';
import { ModalModule } from 'ngx-bootstrap/modal';

/*....*/

import { AppComponent } from './app.component';

import 'hammerjs';

import { HomeComponent } from './home/home.component';
import { PublishersComponent } from './publishers/publishers.component';
import { PublicationdetailComponent } from './publicationdetail/publicationdetail.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';
import { AuthorComponent } from './author/author.component';

import { AppRoutingModule } from './app-routing/app-routing.module';

import { from } from 'rxjs';

import { PublisherService } from './service/publisher.service';
import { ProcessHTTPMsgService } from './service/process-httpmsg.service';

import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { NgSelectModule } from '@ng-select/ng-select';

//import { HttpModule } from '@angular/http';

import { HttpClientModule } from '@angular/common/http';
import { baseURL } from './shared/baseurl';
import { HighlightDirective } from './directives/highlight.directive';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    PublishersComponent,
    PublicationdetailComponent,
    FooterComponent,
    HeaderComponent,
    AboutComponent,
    ContactComponent,
    AuthorComponent,
    LoginComponent,
    SignupComponent,
    HighlightDirective
    ],

  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FlexLayoutModule,
    FormsModule,
    AppRoutingModule,
    //HttpModule,
    HttpClientModule,
    MatToolbarModule,
    MatListModule,
    MatGridListModule,
    MatCardModule,
    MatButtonModule,
    MatDialogModule,
    MatFormFieldModule, 
    MatInputModule,
    MatCheckboxModule,
    MatSelectModule,
    MatSlideToggleModule,
    MatSliderModule,
    ReactiveFormsModule,
    NgSelectModule,

    
    //
    
    //AppBoostrapModule,
    BsDropdownModule.forRoot(),
    TooltipModule.forRoot(),
    ModalModule.forRoot(),
    //NgMultiSelectDropDownModule.forRoot()
  ],
  providers: [
    PublisherService,
    ProcessHTTPMsgService,
    { provide: 'BaseURL', useValue: baseURL }
  ],
  
  bootstrap: [AppComponent]
})
export class AppModule { }
