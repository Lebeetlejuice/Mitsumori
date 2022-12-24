import { Component, OnInit } from '@angular/core';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-board-moderator',
  templateUrl: './board-moderator.component.html',
  styleUrls: ['./board-moderator.component.css']
})
export class BoardModeratorComponent implements OnInit {
  content?: string;
  data: any;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.userService.getDataUsers().subscribe(data=>{
      console.warn(data);
      this.data=JSON.parse(data)
    })
    
    this.userService.getModeratorBoard().subscribe({
      next: data => {
        this.content = data;
      },
    
      error: err => {console.log(err)
        if (err.error) {
          this.content = JSON.parse(err.error).message;
        } else {
          this.content = "Error with status: " + err.status;
        }
      }
    });
    this.userService.getAdminBoard().subscribe({
      next: data => {
        this.content = data;
      },
    
      error: err => {console.log(err)
        if (err.error) {
          this.content = JSON.parse(err.error).message;
        } else {
          this.content = "Error with status: " + err.status;
        }
      }
    });
  }
}
