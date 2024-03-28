package com.heem.aopdemo;

import com.heem.aopdemo.dao.AccountDAO;
import com.heem.aopdemo.dao.MembershipDAO;
import com.heem.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(TrafficFortuneService theTrafficFortuneService, AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

		return runner -> {

			//demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
			//demoTheAfterAdvice(theAccountDAO);

			//demoTheAroundService(theTrafficFortuneService);
			//demoTheAroundAdviceHandleExecption(theTrafficFortuneService);

			demoTheAroundAdviceRethrowExecption(theTrafficFortuneService);
		};
	}

	private void demoTheAroundAdviceRethrowExecption(TrafficFortuneService theTrafficFortuneService) {
		System.out.println("\nMain progrma: demoTheAroundService");

		String data = null;
		boolean tripWire = true;
		try {
			data = theTrafficFortuneService.getFortune(tripWire);
		} catch (Exception exc) {
			data = "Error";
		}
		System.out.println("\n" + data);
		System.out.println("Finished");
	}

	private void demoTheAroundAdviceHandleExecption(TrafficFortuneService theTrafficFortuneService) {

		System.out.println("\nMain progrma: demoTheAroundService");

		boolean tripWire = true;
		String data = theTrafficFortuneService.getFortune(tripWire);

		System.out.println("\n" + data);
		System.out.println("Finished");
	}

	private void demoTheAroundService(TrafficFortuneService theTrafficFortuneService) throws InterruptedException {

		System.out.println("\nMain progrma: demoTheAroundService");

		String data = theTrafficFortuneService.getFortune();

		System.out.println("\n" + data);
		System.out.println("Finidhsed");
	}


	private void demoTheAfterAdvice(AccountDAO theAccountDemo) {
		List<Account> theAccounts = null;
		try {
			boolean tripWire = false;
			theAccounts = theAccountDemo.findAccounts(tripWire);
		} catch (Exception exc) {
			System.out.println("\n\nMain Program: caught Exception: " + exc);
		}
		System.out.println("\n\nMain Program: demoTheAfterReturningAdvice");
		System.out.println("----");

		System.out.println(theAccounts);

		System.out.println("\n");
	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDemo) {
		List<Account> theAccounts = null;
		try {
			boolean tripWire = true;
			theAccounts = theAccountDemo.findAccounts(tripWire);
		} catch (Exception exc) {
			System.out.println("\n\nMain Program: caught Exception: " + exc);
		}
		System.out.println("\n\nMain Program: demoTheAfterReturningAdvice");
		System.out.println("----");

		System.out.println(theAccounts);

		System.out.println("\n");
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

		// call the business method
		Account myAccount = new Account();
		myAccount.setName("SS");
		myAccount.setLevel("VVIP");
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();

		// call the accountdao getter/setter methods
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

		// call the membership business method
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();

	}

}








