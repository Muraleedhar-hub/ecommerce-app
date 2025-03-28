import { Component, OnInit } from '@angular/core';
import { CartService } from "../../services/cart.service";
import { CartModelServer } from "../../models/cart.model";
import { AuthenticationService } from '../../services/authentication.service';

@Component({
  selector: 'mg-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  cartData: CartModelServer;
  cartTotal: Number;
  userId: String;
  isUserlogedIn: boolean = false;
  address: String;

  //const geocoder = new google.maps.Geocoder();
  //const infowindow = new google.maps.InfoWindow();

  constructor(public cartService: CartService, public authenticationService: AuthenticationService) {
  }

  ngOnInit() {
    navigator.geolocation.getCurrentPosition(showPosition);

    //new google.maps.Geocoder()

    this.cartService.cartTotal$.subscribe(total => {
      this.cartTotal = total;
    });

    function showPosition(position) {
      localStorage.setItem('latitude', position.coords.latitude);
      localStorage.setItem('longitude', position.coords.longitude);
      console.log('Latitude' + position.coords.latitude + ',' +
        'Longitude:' + position.coords.longitude);

    }

    this.cartService.cartDataObs$.subscribe(data => this.cartData = data);
    if (localStorage.getItem('currentUser')) {
      this.userId = JSON.parse(localStorage.getItem('currentUser')).username;
      if (this.userId) {
        this.isUserlogedIn = true
      }
    }

    this.authenticationService.getLocationDetails().subscribe(loc => {
      this.address = loc['items'][0]['address']['label'];
      sessionStorage.setItem('customerAddress', this.address.toUpperCase());
    })
  }

}
