import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  products: ProductResponseModel[] = [];
  //ServerURL = 'http://productservice-env.eba-mqthqfk6.us-east-1.elasticbeanstalk.com';
  //ServerURL = "http://localhost:5000";

  constructor(private http: HttpClient) {
  }


  getSingleOrder(orderId: String) {
    return this.http.get<ProductResponseModel[]>(`https://zvp4hrsg02.execute-api.us-east-1.amazonaws.com/v1/${orderId}`).toPromise();
  }
}

interface ProductResponseModel {
  id: Number;
  title: String;
  description: String;
  price: Number;
  quantityOrdered: Number;
  image: String;
}
