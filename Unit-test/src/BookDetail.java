
public class BookDetail {
	public String id;
	public String title;
	public String author;
	public int issuedYear;
	
	public BookDetail(String newId, String newTitle, String newAuthor, int newIssuedYear) {
		this.id=newId;
		this.title=newTitle;
		this.author=newAuthor;
		this.issuedYear=newIssuedYear;
	}
}
