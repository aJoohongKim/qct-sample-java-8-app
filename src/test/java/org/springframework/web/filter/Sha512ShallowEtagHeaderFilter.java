package org.springframework.web.filter;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import jakarta.servlet.http.HttpServletRequest;

public class Sha512ShallowEtagHeaderFilter extends ShallowEtagHeaderFilter {

	protected String generateETagHeaderValue(byte[] bytes, HttpServletRequest request) {
		final HashCode hash = Hashing.sha512().hashBytes(bytes);
		return "\"" + hash + "\"";
	}
}
