package com.unbxd.objects;

import java.io.Serializable;

/**
 */
public class ProductAttribute implements Serializable {
	
	private static final long serialVersionUID = -1468101431074106674L;
	
	private String productName;
	private String genre;
	private String artist;
	
	
	/**
	 * Method getProductName.
	 * @return String
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * Method setProductName.
	 * @param productName String
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * Method getGenre.
	 * @return String
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * Method setGenre.
	 * @param genre String
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * Method getArtist.
	 * @return String
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * Method setArtist.
	 * @param artist String
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}

}
