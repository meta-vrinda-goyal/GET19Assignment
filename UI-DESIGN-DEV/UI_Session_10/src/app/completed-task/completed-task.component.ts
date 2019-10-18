import { Component, OnInit, Input } from '@angular/core';
import { task } from '../task.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-completed-task',
  templateUrl: './completed-task.component.html',
  styleUrls: ['./completed-task.component.css']
})
export class CompletedTaskComponent implements OnInit {
  @Input() task: task;
  ngOnInit() {
  }

  constructor(private router: Router) { }

  delete(task: task)
  {
    localStorage.removeItem((task.creationDate + ""));
    location.reload(true);
    this.router.navigate(['/home']);
  }


  

}
