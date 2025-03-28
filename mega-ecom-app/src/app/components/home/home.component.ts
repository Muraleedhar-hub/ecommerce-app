import { Component, OnInit } from '@angular/core';
import { ProductService } from "../../services/product.service";
import { ProductModelServer, serverResponse } from "../../models/product.model";
import { CartService } from "../../services/cart.service";
import { Router } from "@angular/router";
import { ItemMockServices } from '../mock-services/item.mock.services';

@Component({
  selector: 'mg-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})


export class HomeComponent implements OnInit {
  products: ProductModelServer[] = [];

  constructor(private productService: ProductService,
    private cartService: CartService,
    private router: Router, private itemMockServices: ItemMockServices) {
  }

  ngOnInit() {
    this.productService.getAllProducts(2).subscribe((prods: serverResponse ) => {
      this.products = prods.products;
      console.log(this.products);
    });
  }

  AddProduct(id: Number) {
    this.cartService.AddProductToCart(id);
  }

  selectProduct(id: Number) {
    this.router.navigate(['/product', id]).then();
  }
}
