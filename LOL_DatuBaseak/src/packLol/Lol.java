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
        // TODO Auto-generated method stub
        int aukera = -1;
        //Connection konexioa=null;
        
        System.out.println("Ongietorri League Of Legends-era. Nola sartu nahi zara?");
        System.out.println("+--------------+");
        System.out.println("|    Menua     |");
        System.out.println("+--------------+");
        System.out.println("Aukeratu:");
        System.out.println("1.- Administratzaile moduan sartu");
        System.out.println("2.- Jokalari moduan sartu");
        System.out.println("0.- Irten");
        while (aukera != 1 && aukera!=2 && aukera!=9) {
            aukera=Teklatua.getTeklatua().irakurriOsoa("Sartu aukera");
            
            if(aukera==1){
                System.out.println("Administraile moduan sartu zara");
                Administratzailea adm=new Administratzailea();
                adm.menuaBistaratu();
            }
            else if(aukera==2){
                System.out.println("Jokalari moduan sartu zara");
                Jokalaria jok=new Jokalaria(Teklatua.getTeklatua().hitzaIrakurri("Mesedez, sartu jokalariaren nan-a"));
                jok.partidaJokatu();
            }
            else if(aukera==0){
                System.out.println("Sistematik irtetzen .... agur!");
            }
            else{
                System.out.println("Aukera desegokia sartu duzu");
            }
        }
        //konexioa.close();  
      
    }
    
	public static Connection konexioa() throws ClassNotFoundException, SQLException{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        String zerbitzaria = "jdbc:mysql://localhost:3306/lol";
	        String erabiltzailea = "root";
	        String pasahitza = "";
	        return DriverManager.getConnection(zerbitzaria, erabiltzailea, pasahitza);// salvado por la bombilla

	}
}
