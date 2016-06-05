package com.haurylenka.projects.reservation.beans;

public class Payment {

	private String amountPaid;
	private String formOfPaymentTypeCode;
	private String currencyCode;
	
	public String getAmountPaid() {
		return amountPaid;
	}
	
	public void setAmountPaid(String amountPaid) {
		this.amountPaid = amountPaid;
	}
	
	public String getFormOfPaymentTypeCode() {
		return formOfPaymentTypeCode;
	}
	
	public void setFormOfPaymentTypeCode(String formOfPaymentTypeCode) {
		this.formOfPaymentTypeCode = formOfPaymentTypeCode;
	}
	
	public String getCurrencyCode() {
		return currencyCode;
	}
	
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	
}
