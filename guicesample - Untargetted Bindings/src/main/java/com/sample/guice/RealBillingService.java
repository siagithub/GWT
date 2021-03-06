package com.sample.guice;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class RealBillingService implements BillingService {
	private CreditCardProcessor processor;
	private CreditCardProcessor checkoutProcessor;
	private TransactionLog transactionLog;
	private TransactionLog fileTransactionLog;
	private String instance;
	private Report report;
	private MyConcreteAnnotatedClass myConcreteAnnotatedClass;
	private MyConcreteClass myConcreteClass;

	public String toString(){
		return this.getClass().getName();
	}

	public RealBillingService() {
		System.out.println("RealBillingService Constructor");
	}

	@Inject
	RealBillingService(@Named("foo")MyConcreteAnnotatedClass myConcreteAnnotatedClass, MyConcreteClass myConcreteClass, CreditCardProcessor processor, @Named("Checkout") CreditCardProcessor checkoutProcessor, TransactionLog transactionLog, @File TransactionLog fileTransactionLog, @Named("insert") String instance, @Named("report") Report report) {
		System.out.println("RealBillingService Constructor");
		this.myConcreteAnnotatedClass = myConcreteAnnotatedClass;
		this.myConcreteClass = myConcreteClass;
		this.instance = instance;
		this.report = report;
		this.processor = processor;
		this.checkoutProcessor = checkoutProcessor;
		this.transactionLog = transactionLog;
		this.fileTransactionLog = fileTransactionLog;
		System.out.println("CreditCardProcessor : "+processor);
		System.out.println("CheckoutCreditCardProcessor : "+checkoutProcessor);
		System.out.println("TransactionLog : "+transactionLog);
		System.out.println("Service : "+((MySqlDatabaseTransactionLog)transactionLog).getService());
		System.out.println("FileTransactionLog : "+fileTransactionLog);
		System.out.println("MyConcreteAnnotatedClass : "+myConcreteAnnotatedClass);
		System.out.println("MyConcreteClass : "+myConcreteClass);
		System.out.println("Report : "+report);
		System.out.println("String : "+instance);
	}

}
