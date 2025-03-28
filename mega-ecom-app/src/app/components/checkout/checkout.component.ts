import {Component, OnInit} from '@angular/core';
import {CartService} from "../../services/cart.service";
import {CartModelServer} from "../../models/cart.model";
import {Router} from "@angular/router";
import {OrderService} from "../../services/order.service";
import {NgxSpinnerService} from "ngx-spinner";
import {FormBuilder, NgForm, Validators, FormGroup} from "@angular/forms";
import {ShippingAddress} from '../../models/placeorder.model';
import {BillingAddress} from '../../models/customerdetails.model';
import { AuthenticationService } from '../../services/authentication.service';

@Component({
  selector: 'mg-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.scss']
})
export class CheckoutComponent implements OnInit {
  cartData: CartModelServer;
  cartTotal: Number;
  showSpinner: Boolean;
  userProfile: FormGroup;
  shippingAddress: ShippingAddress;

  constructor(private cartService: CartService,
              private orderService: OrderService,
              private router: Router,
              private  spinner: NgxSpinnerService,
              private fb: FormBuilder,
              private authenticationService: AuthenticationService) {

    this.userProfile = this.fb.group({
      firstName: ['', [Validators.required]],
      lastName: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      contact: ['', [Validators.required]],
      city: ['', [Validators.required]],
      state: ['', [Validators.required]],
      country: ['', [Validators.required]],
      address: ['', [Validators.required]],
      zipCode: ['', [Validators.required]],

      sfirstName: ['', [Validators.required]],
      slastName: ['', [Validators.required]],
      semail: ['', [Validators.required, Validators.email]],
      scontact: ['', [Validators.required]],
      scity: ['', [Validators.required]],
      sstate: ['', [Validators.required]],
      scountry: ['', [Validators.required]],
      saddress: ['', [Validators.required]],
      szipCode: ['', [Validators.required]]
    });


  }

  ngOnInit() {
    this.cartService.cartDataObs$.subscribe(data => this.cartData = data);
    this.cartService.cartTotal$.subscribe(total => this.cartTotal = total);
    this.authenticationService.getLocationDetails().subscribe(loc => {
      //this.address = loc['items'][0]['address']['label'];
      //localStorage.setItem('customerAddress', this.address.toUpperCase());
      this.userProfile.get("city").patchValue(loc['items'][0]['address']['city']);
      this.userProfile.get("state").patchValue(loc['items'][0]['address']['state']);
      this.userProfile.get("country").patchValue(loc['items'][0]['address']['countryName']);
      this.userProfile.get("address").patchValue(loc['items'][0]['address']['houseNumber']+','+
      loc['items'][0]['address']['district']+','
      +loc['items'][0]['address']['subdistrict']+','
      +loc['items'][0]['address']['street']);
      this.userProfile.get("zipCode").patchValue(loc['items'][0]['address']['postalCode']);

      this.userProfile.get("scity").patchValue(loc['items'][0]['address']['city']);
      this.userProfile.get("sstate").patchValue(loc['items'][0]['address']['state']);
      this.userProfile.get("scountry").patchValue(loc['items'][0]['address']['countryName']);
      this.userProfile.get("saddress").patchValue(loc['items'][0]['address']['houseNumber']+','+
      loc['items'][0]['address']['district']+','
      +loc['items'][0]['address']['subdistrict']+','
      +loc['items'][0]['address']['street']);
      this.userProfile.get("szipCode").patchValue(loc['items'][0]['address']['postalCode']);

    })

  }

  onCheckout() {
   this.spinner.show().then(p => {
      this.cartService.CheckoutFromCart(1, new ShippingAddress(
        this.userProfile.get('firstName').value,
        this.userProfile.get('lastName').value,
        this.userProfile.get('email').value,
        this.userProfile.get('address').value,
        this.userProfile.get('city').value,
        this.userProfile.get('state').value,
        this.userProfile.get('country').value,
        this.userProfile.get('zipCode').value,
        this.userProfile.get('contact').value
      ), new BillingAddress(
        this.userProfile.get('sfirstName').value,
        this.userProfile.get('slastName').value,
        this.userProfile.get('semail').value,
        this.userProfile.get('saddress').value,
        this.userProfile.get('scity').value,
        this.userProfile.get('sstate').value,
        this.userProfile.get('scountry').value,
        this.userProfile.get('szipCode').value,
        this.userProfile.get('scontact').value
      ), false);
    });


  }
}
