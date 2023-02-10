package com.KoreaIT.java.BasicAM.container;

import com.KoreaIT.java.BasicAM.dao.ArticleDao;
import com.KoreaIT.java.BasicAM.dao.MemberDao;
import com.KoreaIT.java.BasicAM.service.ArticleService;

public class Container {
	public static ArticleDao articleDao;
	public static MemberDao memberDao;
	public static ArticleService articleService;

	static {
		articleDao = new ArticleDao();
		memberDao = new MemberDao();
		articleService = new ArticleService();
	}
}
