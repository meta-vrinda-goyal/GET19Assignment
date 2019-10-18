import { Component, OnInit, Input } from '@angular/core';
import { task } from '../task.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-task',
  templateUrl: './new-task.component.html',
  styleUrls: ['./new-task.component.css']
})
export class NewTaskComponent implements OnInit {

  @Input() task: task;
  
  constructor(private router: Router) { }

  delete(task: task)
  {
    localStorage.removeItem((task.creationDate + ""));
    location.reload(true);
    this.router.navigate(['/']);
  }

  edit(task: task)
  {
    this.router.navigate(['/edit', task]);
  }
  
  taskToString(task: task) {
    var string = task.title + ','
      + task.description + ',' + task.status
      + ',' + task.creationDate + ',' + task.completionDate
      + ',' + task.priority;
    return string;
  }

  ngOnInit() {
  }

}
