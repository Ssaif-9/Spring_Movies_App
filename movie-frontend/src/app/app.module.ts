import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './component/login/login.component';
import { HomeComponent } from './component/home/home.component';
import { DashboardComponent } from './component/dashboard/dashboard.component';
import { MovieComponent } from './component/movie/movie.component';
import { PageNotFoundComponent } from './component/page-not-found/page-not-found.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { PaginationModule } from 'ngx-bootstrap/pagination';
import { SearchComponent } from './component/search/search.component';
import { OperationAddByImdbidComponent } from './component/operation-add-by-imdbid/operation-add-by-imdbid.component';
import { OperationAddByTitleComponent } from './component/operation-add-by-title/operation-add-by-title.component';
import { OperationDeleteByImdbidComponent } from './component/operation-delete-by-imdbid/operation-delete-by-imdbid.component';


@NgModule({
  declarations: [
    AppComponent,
    PageNotFoundComponent,
  
  ],
  imports: [
    MovieComponent,
    BrowserModule,
    LoginComponent,
    DashboardComponent,
    
    HomeComponent,
    AppRoutingModule,
    HttpClientModule,
    SearchComponent,
    FormsModule,
    ReactiveFormsModule,
    PaginationModule,
    PaginationModule.forRoot(),
    CommonModule,
    OperationAddByImdbidComponent,
    OperationAddByTitleComponent,
    OperationDeleteByImdbidComponent,
  
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
