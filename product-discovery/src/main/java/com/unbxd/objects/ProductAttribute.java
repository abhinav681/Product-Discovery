package com.unbxd.objects;

import java.io.Serializable;

public class ProductAttribute implements Serializable {
	
	private static final long serialVersionUID = -1468101431074106674L;
	
	private String productName;
	private String genre;
	private String artist;
	
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

}
