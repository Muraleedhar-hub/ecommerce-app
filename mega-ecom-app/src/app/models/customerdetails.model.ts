export class BillingAddress {

    firstName: String;
    lastName: String;
    email: String;
    address: String;
    city: String;
    state: String;
    country: String;
    zipCode: String;
    contact: String;

    constructor(
        firstName: String,
        lastName: String,
        email: String,
        address: String,
        city: String,
        state: String,
        country: String,
        zipCode: String,
        contact: String
    ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country
        this.zipCode = zipCode;
        this.contact = contact;
    }
  }

  