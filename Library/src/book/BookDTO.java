package book;
 
 
// dto: data transfer object(������ ���� ��ü)
//vo , to ����� ��
//�ڷ� ���� Ŭ����
public class BookDTO {
 
    private int id;
    private String title;
    private String author;
    private int price;
    private int qty;
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getTitle() {
        return title;
    }
 
    public void setTitle(String title) {
        this.title = title;
    }
 
    public String getAuthor() {
        return author;
    }
 
    public void setAuthor(String author) {
        this.author = author;
    }
 
    public int getPrice() {
        return price;
    }
 
    public void setPrice(int price) {
        this.price = price;
    }
 
    public int getQty() {
        return qty;
    }
 
    public void setQty(int qty) {
        this.qty = qty;
    }
 
    // �⺻������
    public BookDTO() {
        // TODO Auto-generated constructor stub
    }
 
    // �Ű������� �ִ� ������
    public BookDTO(String title, String author, int price, int qty) {
        super();
        this.title = title;
        this.author = author;
        this.price = price;
        this.qty = qty;
    }
 
    @Override
    public String toString() {
        return "bookDTO [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + ", qty=" + qty
                + "]";
    }
 
}