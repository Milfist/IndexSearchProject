package org.milfist.common;

public enum Constants {
	
	HASH("#"), AT("@"), COLON(":");
	
	private String value;

    private Constants(String s) {
        value = s;
    }

    public String getValue() {
        return value;
    }
	
}
