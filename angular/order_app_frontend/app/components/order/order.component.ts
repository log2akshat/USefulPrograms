import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatIconModule } from '@angular/material/icon';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button'
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { HttpClientModule } from '@angular/common/http';
import { OrderService } from '../../service/order.service';

@Component({
  selector: 'app-order',
  standalone: true,
  imports: [
    CommonModule,
    MatIconModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    MatButtonModule,
    MatProgressSpinnerModule,
    HttpClientModule
  ],
  providers: [MatSnackBar, OrderService],
  templateUrl: './order.component.html',
  styleUrl: './order.component.css'
})
export class OrderComponent {
  constructor(private order:OrderService, private snack:MatSnackBar) {}

  data={
    customerName:"",
    productName:"",
    storeName:"",
    city:""
  }

  flag=false;

  submitForm() {
    //alert("Form submit invoked!");
    console.log("Order Data", this.data);

    if(this.data.customerName=='' || this.data.productName=='' || this.data.storeName=='' || this.data.city=='') {
      this.snack.open("Fields cannot be empty", "OK");
      return;
    }
  
    this.flag=true;
    this.order.addOrder(this.data).subscribe(
      (response:any)=>{
      // Check if the status code is 201 (Created)
      if (response.status === 200 || response.status === 201) {
        this.flag = false;
        this.snack.open('Order placed successfully', 'Done');
      } else {
        // Handle other status codes as needed
        this.flag = false;
        this.snack.open('Unexpected status code: ' + response.status, 'OK');
      }
      },
      error=>{
        console.log(error);
        this.flag=false;
        this.snack.open("Error while placing the order", "OK")
      }
    )
  }
}
