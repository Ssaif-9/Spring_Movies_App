import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './component/login/login.component';
import { DashboardComponent } from './component/dashboard/dashboard.component';
import { HomeComponent } from './component/home/home.component';
import { MovieComponent } from './component/movie/movie.component';
import { PageNotFoundComponent } from './component/page-not-found/page-not-found.component';
import { SearchComponent } from './component/search/search.component';
import { OperationDeleteByImdbidComponent } from './component/operation-delete-by-imdbid/operation-delete-by-imdbid.component';
import { OperationAddByImdbidComponent } from './component/operation-add-by-imdbid/operation-add-by-imdbid.component';
import { OperationAddByTitleComponent } from './component/operation-add-by-title/operation-add-by-title.component';
import { SigninComponent } from './component/signin/signin.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'signin', component: SigninComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'addByImdbid', component: OperationAddByImdbidComponent },
  { path: 'addBytitle', component: OperationAddByTitleComponent },
  { path: 'daleteImdbId', component: OperationDeleteByImdbidComponent },
  { path: 'home', component: HomeComponent },
  { path: 'preview', component: HomeComponent },
  { path: 'movie', component: MovieComponent },
  { path: 'search/imdbId/:imbdId', component: SearchComponent },
  { path: 'search/title/:title', component: SearchComponent },
  { path: 'search/year/:year', component: SearchComponent },

  { path: 'movie/:username/:imdbId', component: MovieComponent },
  { path: '', component: LoginComponent },
  { path: '**' , component : PageNotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
