package com.unbxd.service;


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.unbxd.objects.Product;
import com.unbxd.objects.ProductAttribute;

public class ProductDiscovery {


	private HashMap<Long, ProductAttribute> productIdToAttributeMap = new HashMap<Long, ProductAttribute>();
	private HashMap<String, Long> artistToProductIdMap = new HashMap<String, Long>();
	private HashMap<Long, List<String> > productIdToQueryList = new HashMap<Long, List<String> >();
	private HashMap<String, List<Product> > queryToProductList = new HashMap<String, List<Product>>();
	
	void init() throws IOException, ParseException
	{
		JSONParser parser = new JSONParser();
		JSONArray jsonArray = (JSONArray)parser.parse(new FileReader("data.json"));
		for (Object object : jsonArray) {
			JSONObject jsonObject = (JSONObject)object;

			Long productId = (Long)jsonObject.get("productId");
			String productName = (String)jsonObject.get("productName");
			String genre = (String)jsonObject.get("genre");
			String artist = (String)jsonObject.get("artist");

			ProductAttribute productAttribute = new ProductAttribute();
			productAttribute.setArtist(artist);
			productAttribute.setGenre(genre);
			productAttribute.setProductName(productName);

			productIdToAttributeMap.put(productId, productAttribute);
			artistToProductIdMap.put(artist, productId);
		}

		jsonArray = (JSONArray)parser.parse(new FileReader("query.json"));
		for (Object object : jsonArray) {
			JSONObject jsonObject = (JSONObject)object;
			Long productId = (Long)jsonObject.get("productId");
			String query = (String)jsonObject.get("query");

			List<Product> productList = queryToProductList.get(query);
			if(null == productList){
				productList = new ArrayList<Product>();
			}
			Product product = new Product();
			ProductAttribute productAttribute = productIdToAttributeMap.get(productId);
			product.setProductId(productId);
			if(productAttribute != null){
				product.setArtist(productAttribute.getArtist());
				product.setGenre(productAttribute.getGenre());
				product.setProductName(productAttribute.getProductName());
			}
			
			productList.add(product);

			queryToProductList.put(query, productList);

			List<String> queryList = productIdToQueryList.get(productId);
			if(null == queryList){
				queryList = new ArrayList<String>();
			}
			queryList.add(query);

			productIdToQueryList.put(productId, queryList);
		}
	}

	public ProductDiscovery() throws IOException, ParseException 
	{
		init();
	}
	
	public List<Product> getProductListByQuery(String query) {
		return queryToProductList.get(query);
	}

	public List<String> getQueryListByArtist(String artist) {
		return productIdToQueryList.get(artistToProductIdMap.get(artist));
	}

}
