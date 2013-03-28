package com.capella.babynames.service;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import net.sf.ehcache.config.InvalidConfigurationException;

import org.jsoup.nodes.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/testApplicationContext.xml")
public class JsoupServiceTest {

	@Autowired
	private JsoupService jsoupService;

	@Test
	public void testCall() throws IOException {
		Document call = jsoupService.call(2010, 10);
		assertNotNull(call);
	}

	@Test(expected=InvalidConfigurationException.class)
	public void testCallInvalidConfigurationMin() throws IOException {
		jsoupService.call(1879, 10);
	}

	@Test(expected=InvalidConfigurationException.class)
	public void testCallInvalidConfigurationMax() throws IOException {
		jsoupService.call(2011, 10);
	}

	@Test
	public void testExtractElements() throws IOException {
		Document call = jsoupService.call(2008, 10);
		assertNotNull(call);
		Map<String, Integer> extractElements = new HashMap<String, Integer>(); 
		extractElements = jsoupService.extractElements(extractElements,call);
		assertEquals(10, extractElements.size());
	}

	@Test
	public void testSort() throws IOException {
		Document call = jsoupService.call(2008, 10);
		assertNotNull(call);
		Map<String, Integer> extractElements = new HashMap<String, Integer>(); 
		extractElements = jsoupService.extractElements(extractElements,call);
		
		assertEquals(10, extractElements.size());

		TreeMap<String, Integer> sort = jsoupService.sort(extractElements);
		assertEquals("Jacob",sort.firstKey());
	}

}
