import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  private baseurl="http://localhost:7777"

  constructor(private httpclient:HttpClient) { }

  addOrder(data:any) {
    return this.httpclient.post(`${this.baseurl}/samsung/order/add`, data)

  }
}
