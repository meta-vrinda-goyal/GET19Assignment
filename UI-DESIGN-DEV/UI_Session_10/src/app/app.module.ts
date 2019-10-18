import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; 
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { NewTaskComponent } from './new-task/new-task.component';
import { InProcessTaskComponent } from './in-process-task/in-process-task.component';
import { CompletedTaskComponent } from './completed-task/completed-task.component';
import { NewTaskFormComponent } from './new-task-form/new-task-form.component';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './home/home.component';
import { EditComponent } from './edit/edit.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    NewTaskComponent,
    InProcessTaskComponent,
    CompletedTaskComponent,
    NewTaskFormComponent,
    HomeComponent,
    EditComponent
  ],
  imports: [
    BrowserModule, 
    FormsModule, AppRoutingModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { 
  
}
