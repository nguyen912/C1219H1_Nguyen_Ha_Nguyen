import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {BlogComponent} from './blog/blog.component';
import {BlogDetailComponent} from './blog-detail/blog-detail.component';


const routes: Routes = [
  {
    path: 'blog',
    component: BlogComponent
  },
  {
    path: 'blog/:id',
    component: BlogDetailComponent
  },
  {
    path: 'blog/:id/edit',
    component: BlogDetailComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
