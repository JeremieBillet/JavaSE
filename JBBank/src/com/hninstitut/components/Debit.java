package com.hninstitut.components;


public class Debit extends Flow {

	/*---------- Constructeurs -------------*/
	public Debit(String comment, double amount, int accountNumber, String dateOfFlow, boolean effect) {
		super(comment, amount, accountNumber, dateOfFlow, effect);
	}

}
