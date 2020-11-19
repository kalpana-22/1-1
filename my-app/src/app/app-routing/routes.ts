import { Routes } from '@angular/router';

import { PublishersComponent } from '../publishers/publishers.component';
import { PublicationdetailComponent } from '../publicationdetail/publicationdetail.component';
import { HomeComponent } from '../home/home.component';
import { AboutComponent } from '../about/about.component';
import { ContactComponent } from '../contact/contact.component';
import { AuthorComponent } from '../author/author.component';

export const routes: Routes = [
  { path: 'home',  component: HomeComponent },
  { path: 'publishers',     component: PublishersComponent },
  { path: 'author',  component: AuthorComponent },
  { path: 'contact',  component: ContactComponent },
  { path: 'about',  component: AboutComponent },
  { path: 'publicationdetail',  component: PublicationdetailComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' }
];