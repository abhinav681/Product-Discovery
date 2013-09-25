package com.unbxd.objects;

import java.io.Serializable;

public class Product implements Serializable {

	private static final long serialVersionUID = 5625891192595749313L;
	
	private Long productId;
	private String productName;
	private String genre;
	private String artist;
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName="
				+ productName + ", genre=" + genre + ", artist=" + artist + "]";
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
