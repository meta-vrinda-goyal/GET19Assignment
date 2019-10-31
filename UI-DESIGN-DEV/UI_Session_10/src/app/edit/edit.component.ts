import { Component, OnInit, Input } from '@angular/core';
import { task } from '../task.model';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  @Input() task: task;
  
  constructor(private router: Router,private route: ActivatedRoute) { 
    this.route.params.subscribe(params => {
      this.task=params as task;
      console.log(params);
    });
  }

  
  onSubmit(taskForm: NgForm) {
    
    console.log("$$$$$$$$$$", taskForm.value);
    let task: task  = taskForm.value as task;
    task.creationDate = this.task.creationDate;
    if(task.status=="completed")
    {
      task.completionDate = new Date();
    }
    console.log("##########", this.task.creationDate);
    localStorage.setItem((this.task.creationDate + ""), this.taskToString(task));
    this.router.navigate(['/home']);
  }


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

  ngOnInit() {
  }

}
