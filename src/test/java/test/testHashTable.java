package test;

import java.util.Hashtable;

public class testHashTable {

	
	public static void main(String[] args) {
		
		
		Hashtable<String,String> table = new Hashtable<String,String>();
		table.put("username", "raman@gmail.com");
		table.put("password", "sdfdf");
		
		System.out.println(table.get("username"));
		
		
		
	}

}
