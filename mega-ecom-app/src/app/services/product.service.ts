import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable, of} from "rxjs";
import {ProductModelServer, serverResponse} from "../models/product.model";
import {Products} from "../services/products";

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  // private url = 'http://springbootdynamodb-env.eba-ct975yhs.us-east-1.elasticbeanstalk.com';
  //private url = 'http://productservice-env.eba-mqthqfk6.us-east-1.elasticbeanstalk.com';
  private url = 'https://xkc2dldxda.execute-api.us-east-1.amazonaws.com/v2/product-service-getallitems-api-gateway';
  private getItem_API_gateway_url = 'https://3653y3501e.execute-api.us-east-1.amazonaws.com/v1/';

  constructor(private http: HttpClient, private product: Products) {
  }

  getAllProducts(limitOfResults=2): Observable<serverResponse> {
    return this.http.get<serverResponse>(this.url, {
      params: {
        limit: limitOfResults.toString()
      }
    });
  }

  getSingleProduct(id: Number): Observable<ProductModelServer> {
    return this.http.get<ProductModelServer>(this.getItem_API_gateway_url+id);
  }

  getProductsFromCategory(catName: String): Observable<ProductModelServer[]> {
    return this.http.get<ProductModelServer[]>(this.url + 'products/category/' + catName);
  }

}
