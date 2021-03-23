package com.hninstitut.apptest;

import java.util.ArrayList;
import java.util.List;

import com.hninstitut.components.Client;

/**
 * class de test 
 * @author Admin
 *
 */
public class ClientTest {

	public static void main(String[] args) {
		List<Client> clientList;
		clientList = genererClients(6);
		displayClients(clientList);

	}

	public static List<Client> genererClients(int nombreClients){
		List<Client> nouveauClients = new ArrayList<Client>();
		for (int i = 0; i < nombreClients; i++) {
			nouveauClients.add(new Client("name"+i, "firstname"+i));
		}
		return nouveauClients;
	}
	
	public static void displayClients(List<Client> clientList) {
		clientList.stream().forEach(c -> System.out.println(c));
	}

	
}
