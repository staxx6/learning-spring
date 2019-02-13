package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	public void addAccount() {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}
	
	public void addAccount(Account account) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT WITH ACC PARAM");
	}
	
	public Account addAccount(Account account, int a) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT WITH ACC PARAM");
		return account;
	}
	
	public void addStuff() {
		System.out.println(getClass() + ": STUFF");
	}
	
	public void crash() throws Exception {
		throw new Exception("dat fehler hier");
	}
}
