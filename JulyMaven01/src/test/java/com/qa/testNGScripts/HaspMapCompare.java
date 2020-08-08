package com.qa.testNGScripts;

import java.util.HashMap;


public class HaspMapCompare {

	
	    public static void main(String[] args) throws CloneNotSupportedException 
	    {
	        HashMap<Integer, String> map1 = new HashMap<Integer, String>();
	 
	        map1.put(1, "A");
	        map1.put(2, "B");
	        map1.put(3, "C");
	         
	        //Same as map1
	        HashMap<Integer, String> map2 = new HashMap<Integer, String>();
	 
	        map2.put(3, "C");
	        map2.put(1, "A");
	        map2.put(2, "B");
	         
	        //Different from map1
	        HashMap<Integer, String> map3 = new HashMap<Integer, String>();
	 
	        map3.put(1, "A");
	        map3.put(2, "B");
	        map3.put(3, "C");
	        map3.put(3, "D");
	         
	        System.out.println(map1.equals(map2));  //true
	        System.out.println(map1.equals(map3));  //false
	    }
	

}
