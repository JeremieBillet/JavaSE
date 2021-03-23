package com.hninstitut.components;

/**
 * 1.1.1 Creation of the client class.
 * 
 * @author JB
 *
 */
public class Client {

	/*---------- Attributs -------------*/
	private String name;
	private String firstName;
	private int clientNumber;
	private static int numberOfClients;

	/*---------- Constructeurs -------------*/
	public Client(String name, String firstName) {
		this.name = name;
		this.firstName = firstName;
		this.clientNumber = ++numberOfClients;

	}

	/*---------- Méthodes -------------*/
	@Override
	public String toString() {
		return "Client [name=" + name + ", firstName=" + firstName + ", clientNumber=" + clientNumber + "]";
	}

	/*---------- Getters/Setters -------------*/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getClientNumber() {
		return clientNumber;
	}
	
	

}
