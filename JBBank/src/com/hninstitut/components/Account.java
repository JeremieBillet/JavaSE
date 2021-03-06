package com.hninstitut.components;

public abstract class Account {

	/*---------- Attributs -------------*/
	protected String label;
	protected double balance;
	protected int accountNumber;
	private static int nombreComptes;
	protected Client client;

	/*---------- Constructeurs -------------*/
	public Account(String label, Client client) {
		this.label = label;
		this.client = client;
		this.accountNumber = ++nombreComptes;
	}

	/*---------- M?thodes -------------*/
	@Override
	public String toString() {
		return "Account [label=" + label + ", balance=" + balance + ", accountNumber=" + accountNumber + ", client="
				+ client + "]";
	}

	/*---------- Getters/Setters -------------*/
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(Flow flow) {
		if (flow instanceof Credit) this.balance += flow.getAmount();
		if (flow instanceof Debit) this.balance -= flow.getAmount();
		if (flow instanceof Transfert) {
			if (this.accountNumber == flow.getAccountNumber()) this.balance += flow.getAmount();
			if (this.accountNumber == ((Transfert)flow).getAccountIssuingNumber()) this.balance -= flow.getAmount();
		}
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	
}
