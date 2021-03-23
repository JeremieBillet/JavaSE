package com.hninstitut.components;

import java.time.LocalDate;

public class Debit extends Flow {

	/*---------- Constructeurs -------------*/
	public Debit(String comment, double amount, int accountNumber, LocalDate dateOfFlow, boolean effect) {
		super(comment, amount, accountNumber, dateOfFlow, effect);
	}

}
