package com.github.amongus.utility;

import com.github.amongus.throwable.IllegalInstantiation;
import org.apache.commons.lang.Validate;

public final class Utils {

	private Utils() {
		IllegalInstantiation.deploy(Utils.class);
	}

	public static String color(String str) {
		Validate.notNull(str, "Cannot translate null text");
		char[] b = str.toCharArray();

		for (int i = 0; i < b.length - 1; ++i) {
			if (b[i] == '&' && "0123456789AaBbCcDdEeFfKkLlMmNnOoRrXx".indexOf(b[i + 1]) > -1) {
				b[i] = 167;
				b[i + 1] = Character.toLowerCase(b[i + 1]);
			}
		}

		return new String(b);
	}
}
