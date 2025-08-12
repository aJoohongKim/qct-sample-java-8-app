package org.springframework.web.filter;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;

/**
 * Custom implementation of ShallowEtagHeaderFilter that uses SHA-512 for ETag generation.
 */
public class Sha512ShallowEtagHeaderFilter extends ShallowEtagHeaderFilter {

    /**
     * Generate an ETag value using SHA-512 for the given byte array.
     */
    protected String generateSha512ETag(byte[] body) {
        final HashCode hash = Hashing.sha512().hashBytes(body);
		return "\"" + hash + "\"";
	}
}
