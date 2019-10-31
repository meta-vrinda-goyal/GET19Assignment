import { Component, OnInit, Input } from '@angular/core';
import { NgForm } from '@angular/forms';
import { task } from '../task.model';
import {Router} from "@angular/router";

@Component({
  selector: 'app-new-task-form',
  templateUrl: './new-task-form.component.html',
  styleUrls: ['./new-task-form.component.css']
})
export class NewTaskFormComponent implements OnInit {

  @Input() taskList: task[];

  constructor(private router: Router) { }

  task: task;

  stringToTask(str: string) {
    var tempStr = str.split(",");

    if (tempStr[5] == "null") {
      this.task = new task(String(tempStr[0]), String(tempStr[1]),
        String(tempStr[2]), new Date(String(tempStr[1])), null, tempStr[5]);
    }
    else {
      this.task = new task(String(tempStr[0]), String(tempStr[1]),
        String(tempStr[2]), new Date(String(tempStr[3])), new Date(tempStr[4]), tempStr[5]);
    }
    return this.task;
  }

  taskToString(task: task) {
    var string = task.title + ','
      + task.description + ',' + task.status
      + ',' + task.creationDate + ',' + task.completionDate
      + ',' + task.priority;

    return string;
  }

  

  onSubmit(taskForm: NgForm) {
    let startDate: Date = new Date();

    if(taskForm.value.status=="")
    {
      taskForm.value.status="new";
    }
    if(taskForm.value.priority=="")
    {
      taskForm.value.priority="low";
    }
    this.task = new task(taskForm.value.title, taskForm.value.description, taskForm.value.status, startDate, null, taskForm.value.priority);
    if(this.task.status=="completed")
    {
      this.task.completionDate = new Date();
    }
    localStorage.setItem((startDate + ""), this.taskToString(this.task));
    this.router.navigate(['/home'])
  }

  ngOnInit() {
  }

}
