import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './component/login/login.component';
import { DashboardComponent } from './component/dashboard/dashboard.component';
import { HomeComponent } from './component/home/home.component';
import { MovieComponent } from './component/movie/movie.component';
import { PageNotFoundComponent } from './component/page-not-found/page-not-found.component';
import { MovieOperationComponent } from './component/movie-operation/movie-operation.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'operation', component: MovieOperationComponent },
  { path: 'home' , component : HomeComponent },
  { path: 'movie', component: MovieComponent },
  { path: '', component: LoginComponent },
  { path: '**' , component : PageNotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
