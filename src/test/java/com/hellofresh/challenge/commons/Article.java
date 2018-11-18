package com.hellofresh.challenge.commons;

public class Article {
	public int productId;

	public Article(int i) {
		this.productId = i;
	}

	public static Article getDefaultArticle() {
		return new Article(7);
	}
}
