package com.test.tests;


public class ClassVariables {
	
	static ConfigurationSetUp config = new ConfigurationSetUp();

	//Accessing URLs
	public static String authorURL = "https://www-5cd14be667bc26233896bff0.recruit.eb7.io/";
	
	//Search
	public static String searchSelector = "//input[@id='searchBar']";
	public static String searchKeyword = "test1";
	
	//Adding a new quote
	public static String quoteAddSelector = "//button[@id='show-modal']";
	
	public static String newAuthor = "//div[@class='form-group']//input[@id='autorInput']";
	public static String newAuthorInput = "authorNew";
	public static String newQuote = "//div[@class='form-group']//input[@id='quoteInput']";
	public static String newQuoteInput = "quoteNew";
	
	public static String quoteSuccess = "//button[@class='btn btn-success modal-default-button']";
}
