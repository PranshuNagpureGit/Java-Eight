package com.classes;

import com.interfaces.InterfaceA;

public class TestingClass {

	public static void main(String[] args) {
		
		/*1. Invoke Static Directly using Interface reference*/
		InterfaceA.myStaticMethod();
		ImplementingClassA ia = new ImplementingClassA();

		/*2. Static method belongs only to Interface class, so you can only invoke static method on Interface, 
		 * not using the implementing class or the object of implementing class
		*
		*ImplementingClassA.myStaticMethod();
		*ia.myStaticMethod();
		*
		*/
		
		/*3.Invoking default using child object*/
				
		ia.myDefaultMethod();
		
		
	}

}
