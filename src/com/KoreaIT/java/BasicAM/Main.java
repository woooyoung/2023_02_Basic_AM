package com.KoreaIT.java.BasicAM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("==프로그램 시작==");

		Scanner sc = new Scanner(System.in);

		int lastArticleId = 0;

		List<Article> articles = new ArrayList<>();

		while (true) {

			System.out.printf("명령어 ) ");
			String command = sc.nextLine().trim();

			if (command.length() == 0) {
				System.out.println("명령어를 입력해주세요");
				continue;
			}

			if (command.equals("system exit")) {
				break;
			}

			if (command.equals("article list")) {
				if (articles.size() == 0) {
					System.out.println("게시글이 없습니다");
					continue;
				}
				System.out.println("번호    /     제목    ");
				String tempTitle = null;
				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);
					if (article.title.length() > 4) {
						tempTitle = article.title.substring(0, 4);
						System.out.printf("%d	/	%s\n", article.id, tempTitle + "...");
						continue;
					}

					System.out.printf("%d	/	%s\n", article.id, article.title);
				}
			} else if (command.equals("article write")) {
				int id = lastArticleId + 1;
				System.out.printf("제목 : ");
				String title = sc.nextLine();
				System.out.printf("내용 : ");
				String body = sc.nextLine();

				Article article = new Article(id, title, body);
				articles.add(article);

				System.out.printf("%d번 글이 생성 되었습니다\n", id);
				lastArticleId++;
			} else if (command.startsWith("article detail ")) {
				String[] commandBits = command.split(" "); // article / detail / ~
				// commandBits[0] => article
				// commandBits[1] => detail
				// commandBits[2] => ~

				int id = Integer.parseInt(commandBits[2]);
				// article detail 1 => "1" => 1

//				boolean found = false;
				Article foundArticle = null;

				for (int i = 0; i < articles.size(); i++) {
					// 0 , 1 , 2 -> index
					// 1 , 2 , 3 -> id
					Article article = articles.get(i);
					if (article.id == id) {
//						found = true;
						foundArticle = article;
						break;
					}
				}

				if (foundArticle == null) {
					System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
					continue;
				}
				System.out.println(id + "번 글은 존재합니다");
				System.out.printf("번호 : %d\n", foundArticle.id);
				System.out.printf("날짜 : 2023-12-12 12:12:12\n");
				System.out.printf("제목 : %s\n", foundArticle.title);
				System.out.printf("내용 : %s\n", foundArticle.body);
			}

			else {
				System.out.println("존재하지 않는 명령어입니다");
			}

		}

		System.out.println("==프로그램 끝==");

		sc.close();
	}
}

class Article {
	int id;
	String title;
	String body;

	Article(int id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
	}
}