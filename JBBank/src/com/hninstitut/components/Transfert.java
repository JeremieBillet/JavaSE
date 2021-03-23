package com.hninstitut.components;


public class Transfert extends Flow{
	
	/*---------- Attributs -------------*/
	private int accountIssuingNumber;

	/*---------- Constructeurs -------------*/
	public Transfert(String comment, double amount, int accountNumber, String dateOfFlow, boolean effect, int accountIssuingNumber) {
		super(comment, amount, accountNumber, dateOfFlow, effect);
		this.setAccountIssuingNumber(accountIssuingNumber);
	}

	/*---------- Getters/Setters -------------*/
	public int getAccountIssuingNumber() {
		return accountIssuingNumber;
	}

	public void setAccountIssuingNumber(int accountIssuingNumber) {
		this.accountIssuingNumber = accountIssuingNumber;
	}

}
