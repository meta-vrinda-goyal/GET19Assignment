import { Component, OnInit } from '@angular/core';
import { task } from '../task.model';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  task1: task;

  taskList: task[] = this.getAllTasks();
  
  getAllTasks() {
    this.taskList = [];
    for (let key in localStorage) {
      if (localStorage.getItem(String(key)) != null) {
        console.log(key, localStorage.getItem(String(key)));
        this.task1 = this.stringToTask(localStorage.getItem(String(key)));
        this.taskList.push(this.task1);
      }
    }
    return this.taskList;
  }


  stringToTask(str: string) {
    var tempStr = str.split(",");

    if (tempStr[5] == "null") {
      this.task1 = new task(String(tempStr[0]), String(tempStr[1]),
        String(tempStr[2]), new Date(String(tempStr[1])), null, tempStr[5]);
    }
    else {
      this.task1 = new task(String(tempStr[0]), String(tempStr[1]),
        String(tempStr[2]), new Date(String(tempStr[3])), new Date(tempStr[4]), tempStr[5]);
    }
    return this.task1;
  }

  taskToString(task: task) {
    var string = task.title + ','
      + task.description + ',' + task.status
      + ',' + task.creationDate + ',' + task.completionDate
      + ',' + task.priority;

    return string;
  }
}
