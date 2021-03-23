package com.hninstitut.components;

import java.util.Date;

public abstract class Flow {

	/*---------- Attributs -------------*/
	private String comment;
	private int identifier;
	private static int operationNumber;
	private double amount;
	private int accountNumber;
	private boolean effect;
	private Date dateOfFlow;

	/*---------- Constructeurs -------------*/
	public Flow(String comment, double amount, int accountNumber, boolean effect) {
		this.comment = comment;
		this.amount = amount;
		this.accountNumber = accountNumber;
		this.effect = effect;
		this.dateOfFlow = new Date();
		this.identifier = ++operationNumber;

	}

	/*---------- Getters/Setters -------------*/
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public boolean isEffect() {
		return effect;
	}

	public void setEffect(boolean effect) {
		this.effect = effect;
	}

	public Date getDateOfFlow() {
		return dateOfFlow;
	}

	public void setDateOfFlow(Date dateOfFlow) {
		this.dateOfFlow = dateOfFlow;
	}

	public int getIdentifier() {
		return identifier;
	}

}
