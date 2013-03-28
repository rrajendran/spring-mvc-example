package com.capella.babynames.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import net.sf.ehcache.config.InvalidConfigurationException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.capella.babynames.comparator.BabyNameComparator;

@Service
public class JsoupService {
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(JsoupService.class);
	private static final String N = "n";
	private static final String M = "M";
	private static final String URL = "http://www.socialsecurity.gov/cgi-bin/popularnames.cgi";
	
	/**
	 * Makes a call to the specified url and converts into {@link Document}, which makes easy to cherry pick the elements.
	 * @param year
	 * @param top
	 * @return
	 * @throws IOException
	 */
	@Cacheable(value="cacheStore")
	public Document call(int year, int top) throws IOException{
		LOGGER.debug("Fetching for year " + year);
		if(year >= 1880 && year <= 2010){
			Connection jsoup = Jsoup.connect(URL)
					.data("year", ""+ year)
					.data("top", "" + top)
					.data("number", N)
					.data("sex", M)
					.timeout(120000);
			return jsoup
			  .post();
		}else{
			throw new InvalidConfigurationException("Year should be between 1880 and 2010");
			
		}
	}
	
	/**
	 * Extracts the relevant element like name and count and populates in the map.
	 * @param doc
	 * @return
	 */
	//@Cacheable(value="cacheStore")
	public Map<String, Integer> extractElements(Map<String,Integer> birthNamesMap, Document doc) {
		Element table = doc.select("table").get(2);
		//remove unwanted table rows
		table.select("tr").first().remove();
		table.select("caption").remove();
		table.select("tr").last().remove();
		for (int j = 0; j <  table.select("tr").size(); j++) {
			String name = table.select("tr").eq(j).select("td").get(1).html();
			//LOGGER.debug("name :" + name);
			String count = table.select("tr").eq(j).select("td").get(2).html().replaceAll(",", "");
			//LOGGER.debug("count :" + count);
			if(birthNamesMap.containsKey(name)){
				LOGGER.debug("Name in the map : " + name);
				Integer c = birthNamesMap.get(name);
				birthNamesMap.put(name, c + Integer.parseInt(count));
			}else{
				birthNamesMap.put(name,Integer.parseInt(count));
			}
		}
		return birthNamesMap;
	}
	
	/**
	 * Sorting the Names in descending order with highest total count.
	 * @param birthNamesMap
	 * @return
	 */
	//@Cacheable(value="cacheStore")
	public TreeMap<String, Integer> sort(Map<String, Integer> birthNamesMap) {
		BabyNameComparator bvc =  new BabyNameComparator(birthNamesMap);
		TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>(bvc);
		treeMap.putAll(birthNamesMap);
		return treeMap;
	}
}
