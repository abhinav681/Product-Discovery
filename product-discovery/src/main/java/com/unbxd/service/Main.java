package com.unbxd.service;

import java.io.IOException;

import org.json.simple.parser.ParseException;


/**
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			try {
				ProductDiscovery productDiscovery = new ProductDiscovery();
				productDiscovery.getProductListByQuery("Popular");
				productDiscovery.getQueryListByArtist("");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
	}

}
