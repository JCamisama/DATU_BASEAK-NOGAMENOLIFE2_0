package packLol;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Lol {
	
	private static Lol nireLol;
	
	
	public static synchronized Lol getNireLol(){
		
		if(Lol.nireLol==null){
			
			Lol.nireLol= new Lol();
		}
		
		return Lol.nireLol;
	}
	
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
       
    	Menu.getNireMenu().menuPrintzipalaBistaratu();
    	
    }   
    
    
	public static Connection konexioa() throws ClassNotFoundException, SQLException{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        String zerbitzaria = "jdbc:mysql://localhost:3306/lol";
	        String erabiltzailea = "root";
	        String pasahitza = "";
	        return DriverManager.getConnection(zerbitzaria, erabiltzailea, pasahitza);// salvado por la bombilla

	}
}
