package com.springboot.aws.dynamodb.entities;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBDocument
public class ShippingAddress {

    @DynamoDBAttribute
    private String sfirstName;
    @DynamoDBAttribute
    private String slastName;
    @DynamoDBAttribute
    private String semail;
    @DynamoDBAttribute
    private String saddress;
    @DynamoDBAttribute
    private String scity;
    @DynamoDBAttribute
    private String sstate;
    @DynamoDBAttribute
    private String scountry;
    @DynamoDBAttribute
    private String szipCode;
    @DynamoDBAttribute
    private String scontact;

    public String getSfirstName() {
        return sfirstName;
    }

    public void setSfirstName(String sfirstName) {
        this.sfirstName = sfirstName;
    }

    public String getSlastName() {
        return slastName;
    }

    public void setSlastName(String slastName) {
        this.slastName = slastName;
    }

    public String getSemail() {
        return semail;
    }

    public void setSemail(String semail) {
        this.semail = semail;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }

    public String getScity() {
        return scity;
    }

    public void setScity(String scity) {
        this.scity = scity;
    }

    public String getSstate() {
        return sstate;
    }

    public void setSstate(String sstate) {
        this.sstate = sstate;
    }

    public String getScountry() {
        return scountry;
    }

    public void setScountry(String scountry) {
        this.scountry = scountry;
    }

    public String getSzipCode() {
        return szipCode;
    }

    public void setSzipCode(String szipCode) {
        this.szipCode = szipCode;
    }

    public String getScontact() {
        return scontact;
    }

    public void setScontact(String scontact) {
        this.scontact = scontact;
    }
}
