package book;
 
// jdbc import
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
 
public class BookDAO {
 
    // db����
    public Connection dbConn() {
 
        Connection conn = null; // db���� ��ü
 
        try {
            // mysql jdbc driver �ε�
            Class.forName("com.mysql.jdbc.Driver");
 
            // db���� ���ڿ� but �̹���� ���ȿ� ����ϴ�. ..
            String url = "jdbc:mysql://localhost:3306/java";
            String id = "java"; // mysql ���Ӿ��̵�
            String pwd = "java1234"; // mysql ���� ���
 
            // db ����
 
            conn = DriverManager.getConnection(url, id, pwd);
            System.out.println("db���� ����");
        } catch (Exception e) {
            // db�����۾��� �ݵ�� �ͼ��� ó��
            System.out.println("db���� ����");
            e.printStackTrace();
        }
        return conn;
 
    }
 
    // �ϸ���Ʈ
    public ArrayList<BookDTO> bookList() {
 
        ArrayList<BookDTO> list = new ArrayList<BookDTO>();
        Connection conn = null; // DB���� ��ü
        PreparedStatement pstmt = null; // SQL���ఴü
        ResultSet rs = null; // ����� ó�� ��ü
 
        try {
            conn = dbConn(); // db���� Ű
            String sql = "select * from book_table";
            pstmt = conn.prepareStatement(sql); // sql�� �����Ű�� ��ü �������
            rs = pstmt.executeQuery(); // ���� �� ��� ���� rs�� �Ѿ��
 
            while (rs.next()) {                    //�����.next(); ���� ���ڵ尡 ������ true
 
                BookDTO dto = new BookDTO();
                dto.setId(rs.getInt("id"));
                dto.setTitle(rs.getString("title"));
                dto.setAuthor(rs.getString("author"));
                dto.setPrice(rs.getInt("price"));
                dto.setQty(rs.getInt("qty"));
                
                //ArrayList�� �߰�
                list.add(dto);
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {        //������ �������� �ݱ��۾� ����
            
            //resultset= > statement=> connection
                
            try{
                if(rs!=null){rs.close();}
                
            }catch(Exception e2){
                e2.printStackTrace();
            }
            
            try{
                if(pstmt!=null){pstmt.close();}
                
            }catch(Exception e2){
                e2.printStackTrace();
            }
            
            try{
                if(conn!=null){conn.close();}
                
            }catch(Exception e2){
                e2.printStackTrace();
            }
            
        }
        return list;
    }
 
}
 

