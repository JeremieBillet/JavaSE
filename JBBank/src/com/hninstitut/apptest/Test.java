package com.hninstitut.apptest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;

import com.hninstitut.components.Account;
import com.hninstitut.components.Client;
import com.hninstitut.components.CurrentAccount;
import com.hninstitut.components.SavingsAccount;

/**
 * class de test 
 * @author Admin
 *
 */
public class Test {

	public static void main(String[] args) {
		//Création de client
		List<Client> clientList = genererClients(6);
		displayClients(clientList);
		
		//création de commptes pour chaque client
		List<Account> accountList = genererAccount(clientList);
		displayAccounts(accountList);
		
		//generer hashtable
		Map<Integer, Account> accountHashTable = genererHashTableAccount(accountList);
		accountHashTable.get(2).setBalance(150);
		displayHashTableAccount(accountHashTable);

	}

	/**
	 * permet de générer de nouveaux clients
	 * @param nombreClients
	 * @return
	 */
	public static List<Client> genererClients(int nombreClients){
		List<Client> nouveauClients = new ArrayList<>();
		for (int i = 0; i < nombreClients; i++) {
			nouveauClients.add(new Client("name"+i, "firstname"+i));
		}
		return nouveauClients;
	}
	
	/**
	 * permet d'afficher les clients
	 * @param clientList
	 */
	public static void displayClients(List<Client> clientList) {
		clientList.stream().forEach(c -> System.out.println(c));
	}

	/**
	 * Permet de generer un saving account et un current account par client
	 * @param clientList
	 * @return
	 */
	public static List<Account> genererAccount (List<Client> clientList){
		List<Account> accountList = new ArrayList<>();
		for (Client client : clientList) {
			accountList.add(new CurrentAccount("label current account", client));
			accountList.add(new SavingsAccount("label saving acoount", client));
		}
		return accountList;
	}
	
	/**
	 * permet d'afficher la liste des comptes
	 * @param accountList
	 */
	public static void displayAccounts(List<Account> accountList) {
		accountList.stream().forEach(a -> System.out.println(a));
	}
	
	/**
	 * permet de stocker la list de comptes dans une hashtable
	 * @param accountList
	 * @return
	 */
	public static Map<Integer, Account> genererHashTableAccount (List<Account> accountList){
		Map<Integer, Account> accountHashTable = new HashMap<>();
		for (Account account : accountList) {
			accountHashTable.put(account.getAccountNumber(), account);
		}
		return accountHashTable;
	}
	
	/**
	 * permet d'afficher la hashtable
	 * @param accountHashTable
	 */
	public static void displayHashTableAccount(Map<Integer, Account> accountHashTable) {
		accountHashTable = accountHashTable.entrySet()
								.stream()
								.sorted((e1, e2) -> Double.compare(e1.getValue().getBalance(), e2.getValue().getBalance()))
								.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		
		accountHashTable.forEach((k, v) -> System.out.println("cle : "+k+" \tvalue : "+v));
	}
	
}
