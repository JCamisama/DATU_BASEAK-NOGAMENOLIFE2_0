package chapapote;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class Jokoa {
    
    private static Scanner sc=new Scanner(System.in);

    public static void jokalariaSartu(Connection konexioa) throws SQLException {
        System.out.println("Sartu nan-a");
        String nan=sc.next();
        System.out.println("Sartu izena");
        String izena=sc.next();
        System.out.println("Sartu abizena");
        String abizena=sc.next();
        String query = "INSERT INTO JOKALARI VALUES ('"+nan+"','"+izena+"','"+abizena+"')";
        Statement st = konexioa.createStatement();
        st.executeUpdate(query); 
    }
    
    public static void partidaSortu(Connection konexioa) throws SQLException{
        System.out.println("Sartu kodea-a");
        String kodea=sc.next();
        System.out.println("Sartu eguna-a");
        String data=sc.next();
        System.out.println("Sartu iraupena-a");
        Float iraupena=sc.nextFloat();
        System.out.println("Sartu Jokalari puntuak");
        int jokpunt=sc.nextInt();
        System.out.println("Sartu Ordenagailu puntuak");
        int ordpunt=sc.nextInt();
        System.out.println("Sartu nan-a");
        String joknan=sc.next();
        String query = "INSERT INTO PARTIDA VALUES ('"+kodea+"','"+data+"','"+iraupena+"','"+jokpunt+"','"+ordpunt+"','"+joknan+"')";
        Statement st = konexioa.createStatement();
        st.executeUpdate(query); 
    }
    public static void erakutsi(Connection konexioa) throws SQLException{
        String query = "SELECT * FROM jokalari";
        Statement st = konexioa.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            System.out.println(rs.getString("izena"));
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO Auto-generated method stub
        int aukera = 0;
        Connection konexioa=null;
        while (aukera != 9) {
            System.out.println("Ongietorri Splendor jokora. Zer egin nahi duzu?");
            System.out.println("+--------------+");
            System.out.println("|    Menua     |");
            System.out.println("+--------------+");
            System.out.println("Aukeratu:");
            System.out.println("1.- Jokalari berria sartu");
            System.out.println("2.- Partida berria sartu");
            System.out.println("3.- Jokalari guztiak erakutsi");
            System.out.println("9.- Irten");
            System.out.println("Sartu aukera");
            aukera=sc.nextInt();
            konexioa = Jokoa.konexioa();
            if(aukera==1){
                jokalariaSartu(konexioa);
            }
            else if(aukera==2){
                partidaSortu(konexioa);
            }
            else if(aukera==3){
                erakutsi(konexioa);
            }
        }
        konexioa.close();  
      
    }
    public static Connection konexioa() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String zerbitzaria = "jdbc:mysql://localhost:3306/jokoa";
        String erabiltzailea = "root";
        String pasahitza = "";
        return DriverManager.getConnection(zerbitzaria, erabiltzailea, pasahitza);

    }

}
