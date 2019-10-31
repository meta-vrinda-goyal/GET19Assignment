import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NewTaskFormComponent } from './new-task-form/new-task-form.component';
import { HomeComponent } from './home/home.component';
import { EditComponent } from './edit/edit.component';

const routes: Routes = [
 
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'edit',component: EditComponent},
  { path: 'home', component: HomeComponent },
  { path: 'newTaskForm', component: NewTaskFormComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
