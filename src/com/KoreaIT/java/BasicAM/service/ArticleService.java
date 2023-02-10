package com.KoreaIT.java.BasicAM.service;

import java.util.List;

import com.KoreaIT.java.BasicAM.container.Container;
import com.KoreaIT.java.BasicAM.dao.ArticleDao;
import com.KoreaIT.java.BasicAM.dto.Article;

public class ArticleService {

	private ArticleDao articleDao;

	public ArticleService() {
		this.articleDao = Container.articleDao;
	}

	public void add(Article article) {
		articleDao.add(article);
	}

	public Article getArticleById(int id) {
		return articleDao.getArticleById(id);
	}

	public void remove(Article foundArticle) {
		articleDao.remove(foundArticle);
	}

	public List<Article> getArticles() {
		return articleDao.getArticles();
	}

}
