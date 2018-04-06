package in.cdac.util;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class Address implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String addressCountry;
	private String addressState;
	private String addressCity;
	private String addressLine1;
	private String addressLine2;
	private String pincode;
	
	
	public String toString() {
		return "Address [addressCountry=" + addressCountry + ", addressState=" + addressState + ", addressCity="
				+ addressCity + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", pincode="
				+ pincode + ", getAddressCountry()=" + getAddressCountry() + ", getAddressState()=" + getAddressState()
				+ ", getAddressCity()=" + getAddressCity() + ", getAddressLine1()=" + getAddressLine1()
				+ ", getAddressLine2()=" + getAddressLine2() + ", getPincode()=" + getPincode() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}


	public Address(String addressCountry, String addressState, String addressCity, String addressLine1,
			String addressLine2, String pincode) {
		super();
		this.addressCountry = addressCountry;
		this.addressState = addressState;
		this.addressCity = addressCity;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.pincode = pincode;
	}


	public Address() {
		// TODO Auto-generated constructor stub
	}


	public String getAddressCountry() {
		return addressCountry;
	}


	public void setAddressCountry(String addressCountry) {
		this.addressCountry = addressCountry;
	}


	public String getAddressState() {
		return addressState;
	}


	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}


	public String getAddressCity() {
		return addressCity;
	}


	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}


	public String getAddressLine1() {
		return addressLine1;
	}


	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}


	public String getAddressLine2() {
		return addressLine2;
	}


	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	
	

}
