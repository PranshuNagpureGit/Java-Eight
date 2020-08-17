package com.interfaces;

public interface InterfaceA {

	public static void myStaticMethod() {
		System.out.println("Inteface A - static method");
	}
	public default void myDefaultMethod() {
		System.out.println("Inteface A - default method");
	}
}
