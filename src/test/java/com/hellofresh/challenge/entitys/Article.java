package com.hellofresh.challenge.entitys;

/**
 * Class to wrap attributes for articles - quite rudimentary
 * 
 * @author benja
 *
 */
public class Article {
	/**
	 * stores the product id of the related product
	 */
	private int productId;

	/**
	 * default constructor
	 * 
	 * @param productId Id of the article
	 */
	public Article(int productId) {
		this.setProductId(productId);
	}

	/**
	 * Gets an default Article to increase dev time
	 * 
	 * @return
	 */
	public static Article getDefaultArticle() {
		return new Article(7);
	}

	/**
	 * getter
	 * 
	 * @return
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * setter
	 * 
	 * @param productId
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}
}
