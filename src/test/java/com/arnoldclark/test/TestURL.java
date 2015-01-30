package com.arnoldclark.test;

import static org.junit.Assert.*;

import java.net.URI;
import java.util.List;

import org.junit.Test;

import com.arnoldclark.objects.URLBuilder;

public class TestURL {
	
	URLBuilder builder = new URLBuilder();
	String stockReference = "ARNAF-U-25606";
	String plate = "WX14YSC";

	@Test
	public void testReversedString() {
		builder.getReversedPlate("WX14YSC");
		String rev = builder.getReversedPlate("WX14YSC");
		assertEquals(rev,"CSY41XW");
		assertNotEquals(rev,"CSY41XW2");
		assertNotEquals(rev,"WX14YSC");
	}
	
	@Test
	public void testLinksSize() {
		List<URI> allLinks = builder.getAllLinks(stockReference, plate);
		List<URI> smallLinks = builder.getSmallLinks(stockReference, plate);
		List<URI> largeLinks = builder.getLargeLinks(stockReference, plate);
		assertEquals(allLinks.size(), 24);
		assertEquals(smallLinks.size(), 12);
		assertEquals(largeLinks.size(), 12);
	}

	@Test
	public void testInterleavedString() {
		String a = "acegikm";
		String b = "bdfhjln";
		assertEquals(builder.interleaveStrings(a, b), "abcdefghijklmn");
		assertNotEquals(builder.interleaveStrings(a, b), "xasdabcdefghijklmn");
	}
	
	@Test
	public void testObfuscatedReference() {
		assertEquals(builder.buildObfuscatedStockReference(stockReference, plate),"ACRSNYA4F1-XUW2");
	}


}
