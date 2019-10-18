import { Component, OnInit, Input } from '@angular/core';
import { task } from '../task.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-in-process-task',
  templateUrl: './in-process-task.component.html',
  styleUrls: ['./in-process-task.component.css']
})
export class InProcessTaskComponent implements OnInit {

  @Input() task: task;
  
  constructor(private router: Router) { }

  delete(task: task)
  {
    localStorage.removeItem((task.creationDate + ""));
    location.reload(true);
    this.router.navigate(['/home']);
  }
  
  edit(task: task)
  {
    this.router.navigate(['/edit', task]);
  }
               
  ngOnInit() {
  }

}
