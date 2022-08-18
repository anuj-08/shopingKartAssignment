package com.EasyShopping.shoppingcart.enumeration;


public enum AddressType {
	
	    HOME, OFFICE, OTHERS;

		public static boolean contains(String test) {

			for (AddressType c : AddressType.values()) {
				if (c.name().equals(test)) {
					return true;
				}
			}

			return false;
		}
	}
