import { Component } from '@angular/core';
import { MatButtonModule } from '@angular/material/button'
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    MatButtonModule,
    MatSnackBarModule,
    RouterModule
  ],
  providers: [MatSnackBar],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  public routerLinkOrderVariable = "/order";
  constructor(private snack:MatSnackBar) {}

  buttonClick() {
    console.log("Button clicked!");
    this.snack.open("Hello, order something awesome for you..", "Cancel")
  }

}
