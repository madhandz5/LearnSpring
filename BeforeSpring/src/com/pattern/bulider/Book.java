package com.pattern.bulider;

// 점층적 생성자 패턴
// 단점 : 뭐가 뭔지 모르겠다.

// 자바 빈 규약에 따른 방식
// 기본생성자가 있어야 한다.
// 필드 변수는 private이어야 한다.
// getter/setter 를 지원
// 직렬화가 되어 있어야 한다.

// 단점 : 객체 일관성이 깨진다.
// 처음 객체를 생성할 때의 상태가 바뀔 수 있다.
// setter의 존재 때문에 변경 불가능 (immutable) 클래스를 만들 수 없다.

public class Book {

	// 선택적 인자
	private String title;
	private String author;
	private String publisher;
	private int page;

	public static class BookBuilder {
		private String title;
		private String author;
		private String publisher;
		private int page;

		public BookBuilder title(String val) {
			title = val;
			return this;
		}

		public BookBuilder author(String val) {
			author = val;
			return this;
		}

		public BookBuilder publisher(String val) {
			publisher = val;
			return this;
		}

		public BookBuilder page(int val) {
			page = val;
			return this;
		}

		public Book build() {
			return new Book(this);
		}

	}

	private Book(BookBuilder builder) {
		title = builder.title;
		author = builder.author;
		publisher = builder.publisher;
		page = builder.page;
	}

	@Override
	public String toString() {
		return "BookBuilder [title=" + title + ", author=" + author + ", publisher=" + publisher + ", page=" + page
				+ "]";
	}

}
