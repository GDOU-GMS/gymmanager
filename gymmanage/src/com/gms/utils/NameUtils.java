package com.gms.utils;

import java.util.UUID;

public class NameUtils {

	public static String getName(){
		return UUID.randomUUID().toString();
	}
}
