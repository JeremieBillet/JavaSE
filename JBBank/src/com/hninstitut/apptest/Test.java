package com.hninstitut.apptest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.hninstitut.components.Account;
import com.hninstitut.components.Client;
import com.hninstitut.components.Credit;
import com.hninstitut.components.CurrentAccount;
import com.hninstitut.components.Debit;
import com.hninstitut.components.Flow;
import com.hninstitut.components.SavingsAccount;
import com.hninstitut.components.Transfert;

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
		
		
		//creation de transactions
		List<Flow> flowList = genererTransaction(accountList);
		
		//execution des transactions
		executionTransaction(accountHashTable, flowList);
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
	
	/**
	 * permet de generer des transactions
	 * @param accountList
	 * @return
	 */
	public static List<Flow> genererTransaction(List<Account> accountList){
		List<Flow> flowList = new ArrayList<>();
		
		//a debit of 50€ from account n°1
		flowList.add(new Debit("retrait 50 euros", 50., 1, LocalDate.now().plusDays(2),true));
		
		//A credit of 100.50€ on all current accounts in the array of accounts
		for (Account account : accountList) {
			if (account instanceof CurrentAccount) flowList.add(new Credit("cadeau de bienvenue", 100.5, account.getAccountNumber(), LocalDate.now().plusDays(2), true));
		} 
			
		//A credit of 1500€ on all savings accounts in this same array
		for (Account account : accountList) {
			if (account instanceof SavingsAccount) flowList.add(new Credit("waouh", 1500., account.getAccountNumber(), LocalDate.now().plusDays(2), true));
		}
		
		//A transfer of 50 € from account n ° 1 to account n ° 2
		flowList.add(new Transfert("remboursement", 50., 2, LocalDate.now().plusDays(2), true, 1));
		
		return flowList;
	}
	
	/**
	 * permet d'executer les transactions
	 * @param accountMap
	 * @param flowList
	 */
	public static void executionTransaction(Map<Integer, Account> accountMap, List<Flow> flowList) {
		for (Flow flow : flowList) {
			accountMap.get(flow.getAccountNumber()).setBalance(flow);
			if (flow instanceof Transfert) accountMap.get(((Transfert)flow).getAccountIssuingNumber()).setBalance(flow);
		}
		displayAccountWithNegativeBalance(accountMap, e -> (e.getBalance() <= 0.));
	}
	
	/**
	 * permet de vérifier ne condition grace au predicate
	 * @param accountList
	 * @param predicate
	 */
	public static void displayAccountWithNegativeBalance (Map<Integer, Account> accountList, Predicate<Account> predicate) {
		for (Account account : accountList.values()) {
			if (predicate.test(account)) System.out.println("Attention le compte "+account.getAccountNumber()+" a un solde négatif");
		}
	}
}
