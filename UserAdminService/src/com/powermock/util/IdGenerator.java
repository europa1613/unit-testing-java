package com.powermock.util;

public final class IdGenerator {

	static int id;
	
	public static final int generateId() {
		return id++;
	}
}
