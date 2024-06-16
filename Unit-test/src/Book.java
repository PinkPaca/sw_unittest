public class Book {
	public int id;
	public String title;
	public String author;
	public int issuedYear;
	
	public Book(int newId, String newTitle, String newAuthor, int newIssuedYear) {
		this.id=newId;
		this.title=newTitle;
		this.author=newAuthor;
		this.issuedYear=newIssuedYear;
	}
	

	public void printBook(String extraStr) {
		System.out.println("Book{id: '"+id+"', 제목: '"+title+"', 저자: '"+author+"', 출판년도: "+issuedYear+"}" + extraStr);
		
	}
}
