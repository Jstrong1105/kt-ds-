package com.ktdsuniversity.edu.homework0815.homework3;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.ktdsuniversity.edu.homework0815.homework3.menu.SearchMenu;
import com.ktdsuniversity.edu.homework0815.homework3.util.Reader;

public class Library {
	
	/** 도서 목록 */
	private final List<Book> books;
	
	/** 회원 목록 */
	private final List<User> users;
	
	public Library() {
		this.books = FileIO.loadBook();
		this.users = FileIO.loadUser();
	}
	
	public List<Book> getBooks(){
		return this.books;
	}
	
	public List<User> getUsers(){
		return this.users;
	}
	
	public Book getBook(UUID seed) {
		return this.books.stream()
						 .filter(b -> b.getSeed().equals(seed))
						 .findFirst()
						 .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 시드입니다."));
	}
	
	public void save() {
		FileIO.saveData(this.books, this.users);
	}
	
	// 회원 가입하기
	public void addUser() {
		
		String userName = Reader.readString("회원명을 입력하세요: ");
		
		Optional<String> hasUserName = this.users.stream()
										   .map(User::getUserName)
										   .filter(s -> s.equals(userName))
										   .findFirst();
		
		if (hasUserName.isEmpty()) {
			String phone = Reader.readString("연락처를 입력하세요: ");
			this.users.add(new User(userName, phone));
			System.out.println("가입이 완료되었습니다.");
		} else {
			System.out.println("이미 존재하는 회원명입니다.");
		}
	}
	
	// 책 구매 시 본인 인증
	private Optional<User> login() {
		String userName = Reader.readString("회원명을 입력하세요: ");
		String phone = Reader.readString("연락처를 입력하세요: ");
		
		return
		this.users.stream()
				  .filter(u -> u.getUserName().equals(userName))
				  .filter(u -> u.getPhone().equals(phone))
				  .findFirst();
	}
	
	// 신규 책 입고
	public void addBook() {
		String title = Reader.readString("책 제목을 입력하세요: ");
		String subTitle = Reader.readString("책 부제를 입력하세요: ");
		BookGenre genre = this.getGenre();
		String publisher = Reader.readString("출판사를 입력하세요: ");
		String writer = Reader.readString("작가를 입력하세요: ");
		LocalDate pubDate = this.getPubDate(); 
		int printing = Reader.readInt("인쇄 회차를 입력하세요: ", 0, Integer.MAX_VALUE);
		int price = Reader.readInt("가격을 입력하세요: ", 0, Integer.MAX_VALUE);
		String isbn = Reader.readString("책 고유번호를 입력하세요: ");
		
		this.books.add(new Book(title, subTitle, genre, publisher, writer
								, pubDate, printing, price, isbn));
		
		System.out.println("책 추가가 완료되었습니다.");
	}
	
	public BookGenre getGenre() {
		while(true) {
			for(BookGenre genre : BookGenre.values()) {
				System.out.println(genre.toString());
			}
			String genre = Reader.readString("책 장르를 입력하세요: ");
			
			BookGenre bg = BookGenre.getGenre(genre);
			
			if (bg == null) {
				System.out.println("다시 입력하세요.");
			} else {
				return bg;
			}
		}
	}
	
	private LocalDate getPubDate() {
		int year = Reader.readInt("출판년도를 입력하세요: ", 0, LocalDate.now().getYear());
		int month = Reader.readInt("출판월을 입력하세요: ",1,12);
		int day = Reader.readInt("출판일을 입력하세요: ",0,31);
		
		return LocalDate.of(year, month, day);
	}
	
	public void printBooksFilter(Function<Book, Boolean> fil) {
		
		Map<String, List<Book>> books = 
				this.books.stream()
						  .filter(b -> b.getPubDate().isBefore(LocalDate.now().plusYears(10)))
						  .filter(b -> fil.apply(b))
						  .collect(Collectors.groupingBy(Book::getIsbn))
						  ;
				
				books.forEach( (s,b) -> {
					System.out.println("책 isbn: " + s);
					
					Book book = b.get(0);
					
					int totalRental = b.stream()
									   .mapToInt(a -> a.getCount())
									   .sum()
									   ;
					int bookCount = b.size();
					long rentalBookCount = b.stream()
											.filter(a -> a.isRental())
											.count();
					long hasBookCount = b.stream()
										 .filter(a -> !a.isRental())
										 .count();
					
					System.out.println("책 제목: " + book.getTitle());
					System.out.println("책 부제: " + book.getSubTitle());
					System.out.println("책 장르: " + book.getGenre().toString());
					System.out.println("출판사 : " + book.getPublisher());
					System.out.println("책 작가: " + book.getWriter());
					System.out.println("출판일 : " + book.getPubDate().toString());
					System.out.println("인쇄회차: " + book.getPrinting());
					System.out.println("책 가격: " + book.getPrice());
					System.out.println("대여횟수: " + totalRental);
					System.out.println("책 개수: " + bookCount);
					System.out.println("대여된 책 개수: " + rentalBookCount);
					System.out.println("대여되지 않은 책 개수: " + hasBookCount);
				});
	}
	
	// 도서 조회
	public void printBooks() {
		this.printBooksFilter((b) -> true);
	}
	
	// 회원 조회
	public void printUsers() {
		this.users.forEach(User::printInfo);
	}
	
	// 책 검색
	public void printFindBook() {
		
		SearchMenu[] menus = SearchMenu.values();
		
		for(int i = 0; i < menus.length; i++) {
			System.out.printf("%d. %s%n", (i+1), menus[i].getType());
		}
		int answer = Reader.readInt("검색 선택: ", 1, menus.length);
		
		menus[answer-1].order(this);
	}
	
	// 책 대여
	public void rentalBook() {
		UUID seed = UUID.fromString(Reader.readString("대여할 책 관리번호: "));
		
		Book book = this.getBook(seed);
		
		if (book.isRental()) {
			System.out.println("이미 대여된 책입니다.");
			return;
		}
		
		Optional<User> user = this.login();
		
		if (user.isPresent()) {
			user.get().rental(book);
			System.out.println("대여 완료");
		} else {
			System.out.println("로그인 실패");
		}
	}
	
	// 책 반납
	public void returnBook() {
		
		Optional<User> user = this.login();
		
		if (user.isPresent()) {
			List<UUID> rentalBooks = user.get().getRentalBooks();
			
			for(int i = 0; i < rentalBooks.size(); i++) {
				System.out.println("%d. %s".formatted((i+1), rentalBooks.get(i).toString()));
			}
			
			int number = Reader.readInt("반납할 도서 번호: ", 1, rentalBooks.size());
			
			user.get().hasReturn(number-1, this);
			
		} else {
			System.out.println("인증 실패");
		}
	}
}
