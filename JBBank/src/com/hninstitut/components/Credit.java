package com.hninstitut.components;

import java.time.LocalDate;

public class Credit extends Flow {

	/*---------- Constructeurs -------------*/
	public Credit(String comment, double amount, int accountNumber, LocalDate dateOfFlow, boolean effect) {
		super(comment, amount, accountNumber, dateOfFlow, effect);
	}

}
