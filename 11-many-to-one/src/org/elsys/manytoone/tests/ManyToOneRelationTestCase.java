package org.elsys.manytoone.tests;

import static org.junit.Assert.*;

import org.elsys.manytoone.ManyToOneRelation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManyToOneRelationTestCase {
	ManyToOneRelation<String, Integer> mtor = new ManyToOneRelation<String, Integer>();

	@Before
	public void setUp() throws Exception {
		mtor.connect("Primes", new Integer(2));
		mtor.connect("Primes", new Integer(3));
		mtor.connect("Primes", new Integer(5));
		mtor.connect("Fibonacci", new Integer(1));
		mtor.connect("Fibonacci", new Integer(1));
		mtor.connect("Fibonacci", new Integer(2));
		mtor.connect("Fibonacci", new Integer(3));
	}
	@After
	public void tearDown() throws Exception {}

	@Test
	public void testConnect() {
		Integer seven = new Integer(7);
		assertTrue(mtor.connect("Primes", seven));
		mtor.getData().get("Primes").contains(seven);
	}

	@Test
	public void testContainsSource() {
		fail("Not yet implemented");
	}

	@Test
	public void testContainsTarget() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTarget() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSources() {
		fail("Not yet implemented");
	}

	@Test
	public void testDisconnectSource() {
		fail("Not yet implemented");
	}

	@Test
	public void testDisconnect() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTargets() {
		fail("Not yet implemented");
	}

}
