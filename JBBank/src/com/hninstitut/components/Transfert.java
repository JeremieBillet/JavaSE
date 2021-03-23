package com.hninstitut.components;

public class Transfert extends Flow{
	
	private int accountIssuingNumber;

	public Transfert(String comment, double amount, int accountNumber, boolean effect, int accountIssuingNumber) {
		super(comment, amount, accountNumber, effect);
		this.accountIssuingNumber = accountIssuingNumber;
	}

}
