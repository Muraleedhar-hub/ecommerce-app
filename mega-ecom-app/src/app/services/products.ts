import {Injectable} from '@angular/core';
import { Subscribable, Observable, of } from 'rxjs';
import { serverResponse } from '../models/product.model';

export class Products {

    getAllProducts(): Observable<any> {
        return of({
            serverResponse: {
                count: 1,
                products: [
                    {
                        id: 1,
                        name: "xyz",
                        category: "abc",
                        description: "asdfsafasd",
                        image: "41l92wzfb3",
                        price: 100,
                        quantity: 1,
                        images: "41l92wzfb3"
                    }
                    ,
                    {
                        id: 2,
                        name: "dgdf",
                        category: "zxcv",
                        description: "rrrrrrrrr",
                        image: "2o7rwtfqhy",
                        price: 100,
                        quantity: 1,
                        images: "2o7rwtfqhy"
                    }
                ]
            }})
            
            
        //}
    }
}