package com.KoreaIT.java.BasicAM.dao;

import java.util.ArrayList;
import java.util.List;

import com.KoreaIT.java.BasicAM.dto.Article;

public class ArticleDao {
	private List<Article> articles;

	public ArticleDao() {
		articles = new ArrayList<>();
	}

	public void add(Article article) {
		articles.add(article);
	}

	public void remove(Article foundArticle) {
		articles.remove(foundArticle);
	}

	public int getArticleIndexById(int id) {
		int i = 0;
		for (Article article : articles) {
			if (article.id == id) {
				return i;
			}
			i++;
		}
		return -1;
	}

	public Article getArticleById(int id) {

		int index = getArticleIndexById(id);

		if (index != -1) {
			return articles.get(index);
		}

		return null;
	}

	public List<Article> getArticles() {
		return articles;
	}

}
