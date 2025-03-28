  export class ShippingAddress {

    sfirstName: String;
    slastName: String;
    semail: String;
    saddress: String;
    scity: String;
    sstate: String;
    scountry: String;
    szipCode: String;
    scontact: String;

    constructor(
        sfirstName: String,
        slastName: String,
        semail: String,
        saddress: String,
        scity: String,
        sstate: String,
        scountry: String,
        szipCode: String,
        scontact: String
    ){
        this.sfirstName = sfirstName;
        this.slastName = slastName;
        this.semail = semail;
        this.saddress = saddress;
        this.scity = scity;
        this.sstate = sstate;
        this.scountry = scountry
        this.szipCode = szipCode;
        this.scontact = scontact;
    }
  }

  