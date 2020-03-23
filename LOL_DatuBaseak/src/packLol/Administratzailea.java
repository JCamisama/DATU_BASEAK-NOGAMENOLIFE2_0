package packLol;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

//import java.sql.Connection;

//import chapapote.Jokoa;

public class Administratzailea {
    public Administratzailea(){
        
    }
    public void menuaBistaratu() throws SQLException{ //Este menú queda más bonico en Interfaze grafikoa
        int aukera = -1;
        
        //
        Connection konexioa=null;
        while (aukera != 0) {
            System.out.println("");
            System.out.println("+-------------------------------+");
            System.out.println("|    Administratzaile Menua     |");
            System.out.println("+-------------------------------+");
            System.out.println("Aukeratu:");
            System.out.println("1.-  Jokalari berria sartu");
            System.out.println("2.-  Pertsonaia berria sartu");
            System.out.println("3.-  Objektu berria sartu");
            System.out.println("4.-  Pertsonaiaren indarra aldatu");
            System.out.println("5.-  Pertsonaiaren defentsa aldatu");
            System.out.println("6.-  Objektuaren indarra aldatu");
            System.out.println("7.-  Objektuaren defentsa aldatu");
            System.out.println("8.-  Objektuaren kostua aldatu");
            System.out.println("9.-  Jokalaria ezabatu");
            System.out.println("10.-  Objektua ezabatu");
            System.out.println("11.- Pertsonaia ezabatu");
            System.out.println("12.- Kategoria bakoitzaren pertsonaia kopurua ikusi");//GROUP BY
            System.out.println("0.-  Irten");
            aukera=Teklatua.getTeklatua().irakurriOsoa("Sartu aukera");
            //konexioa = Jokoa.konexioa();
            if(aukera==1){
            	
            	//Jokalaria sartu
            	Administratzailea.jokalariaSartu(konexioa);
                
            }
            else if(aukera==2){
            	
            	//Pertsonaia
            	Administratzailea.pertsonaiaSartu(konexioa);
                
            }
            else if(aukera==3){
            	
            	Administratzailea.objektuaSartu(konexioa);
                
            }
            else if(aukera==4){
                
            	Administratzailea.pertsonaiIndarraAldatu(konexioa);
            }
            else if(aukera==5){
            	
            	Administratzailea.pertsonaiDefentsaAldatu(konexioa);
            }
            else if(aukera==6){
            	
            	Administratzailea.objektuaIndarraAldatu(konexioa);
            }
            else if(aukera==7){
            	
            	Administratzailea.objektuaDefentsaAldatu(konexioa);
            }
            
            else if(aukera==8){
            	
            	Administratzailea.objektuaKostuaAldatu(konexioa);
            }
            
            else if(aukera==9){
            	
            	Administratzailea.jokalariaEzabatu(konexioa);
            }
            else if(aukera==10){
                
            	Administratzailea.objektuaEzabatu(konexioa);
            }
            else if(aukera==11){
                
            	Administratzailea.pertsonaiEzabatu(konexioa);
            }
            else if(aukera==12){
                Administratzailea.kategoriaPertsKop(konexioa);
            }
        }
        System.out.println("Irten zara");
    }
    
	 private static void kategoriaPertsKop(Connection konexioa) {
        // TODO Auto-generated method stub
        
    }
    public static void jokalariaSartu(Connection konexioa) throws SQLException {
	       
	        String nan  = Teklatua.getTeklatua().hitzaIrakurri("Sartu jokalariaren NAN zenbakia: ");
	        String rola = Teklatua.getTeklatua().hitzaIrakurri("Sartu jokalariaren rola: ");
	        int	   adina = Teklatua.getTeklatua().irakurriOsoa("Sartu jokalariaren rola: ");
	        String izena = Teklatua.getTeklatua().hitzaIrakurri("Sartu jokalariaren izena: ");
	        String herrialdea = Teklatua.getTeklatua().hitzaIrakurri("Sartu jokalariaren herrialdea: ");

	        String query = "INSERT INTO JOKALARI(nan, rola, adina, izena, herrialdea) VALUES('"+nan+"','"+rola+"',"+adina+",'"+izena+"','"+herrialdea+"' )";
	        Statement st = konexioa.createStatement();
	        st.executeUpdate(query); 
	}
	 
	 
	 public static void pertsonaiaSartu(Connection konexioa) throws SQLException {
	       
	        String izena     = Teklatua.getTeklatua().hitzaIrakurri("Sartu pertsonaiaren izena: ");
	        String kategoria = Teklatua.getTeklatua().hitzaIrakurri("Sartu pertsonaiaren kategoria: ");
	        int    indarra   = Teklatua.getTeklatua().irakurriOsoa("Sartu pertsonaiaren indarra: ");
	        int    defentsa  = Teklatua.getTeklatua().irakurriOsoa("Sartu pertsonaiaren defentsa: ");
	        int    kostua    = Teklatua.getTeklatua().irakurriOsoa("Sartu pertsonaiaren kostua: ");

	        String query = "INSERT INTO PERTSONAIA VALUES('"+izena+"','"+kategoria+"',"+indarra+","+defentsa+","+kostua+" )";
	        Statement st = konexioa.createStatement();
	        st.executeUpdate(query); 
	 }
	 
	 
	 public static void objektuaSartu (Connection konexioa) throws SQLException {
		 
		    String izena     = Teklatua.getTeklatua().hitzaIrakurri("Sartu objektuaren izena: ");
	        int    indarra   = Teklatua.getTeklatua().irakurriOsoa("Sartu pertsonaiaren indarra: ");
	        int    defentsa  = Teklatua.getTeklatua().irakurriOsoa("Sartu pertsonaiaren defentsa: ");
	        int    kostua    = Teklatua.getTeklatua().irakurriOsoa("Sartu pertsonaiaren kostua: ");

	        String query = "INSERT INTO OBJEKTUA VALUES ('"+izena+"',"+indarra+","+defentsa+","+kostua+" )";
	        Statement st = konexioa.createStatement();
	        st.executeUpdate(query);  
	 }
	 
	 public static void pertsonaiIndarraAldatu(Connection konexioa) throws SQLException {
		 
		 	String izena     = Teklatua.getTeklatua().hitzaIrakurri("Sartu pertsonaiaren izena: ");
	        int    indarra   = Teklatua.getTeklatua().irakurriOsoa("Sartu pertsonaiaren indar berria: ");

	        String query = "UPDATE PERTSONAIA SET indarra = "+indarra+"  WHERE SIZENA=’"+izena+"; ";
	        Statement st = konexioa.createStatement();
	        st.executeUpdate(query);  
	 }
	 
	 public static void pertsonaiDefentsaAldatu(Connection konexioa) throws SQLException {
		 
		 	String izena     = Teklatua.getTeklatua().hitzaIrakurri("Sartu pertsonaiaren izena: ");
	        int    defentsa  = Teklatua.getTeklatua().irakurriOsoa("Sartu pertsonaiaren defentsa berria: ");

	        String query = "UPDATE PERTSONAIA SET defentsa = "+defentsa+"  WHERE SIZENA=’"+izena+";";
	        Statement st = konexioa.createStatement();
	        st.executeUpdate(query);  
	 }
	 
	 public static void objektuaIndarraAldatu(Connection konexioa) throws SQLException {
		 
		 	String izena     = Teklatua.getTeklatua().hitzaIrakurri("Sartu objektuaren izena: ");
	        int    indarra   = Teklatua.getTeklatua().irakurriOsoa("Sartu objektuaren indar berria: ");
	      
	        String query = "UPDATE OBJEKTUA SET indarra = "+indarra+"  WHERE izena=’"+izena+"; ";
	        Statement st = konexioa.createStatement();
	        st.executeUpdate(query);  
	 }
	 
	 public static void objektuaDefentsaAldatu(Connection konexioa) throws SQLException {
		 
		 	String izena     = Teklatua.getTeklatua().hitzaIrakurri("Sartu objektuaren izena: ");
	        int    defentsa  = Teklatua.getTeklatua().irakurriOsoa("Sartu objektuaren defentsa berria: ");

	        String query = "UPDATE OBJEKTUA SET defentsa = "+defentsa+"  WHERE izena=’"+izena+";";
	        Statement st = konexioa.createStatement();
	        st.executeUpdate(query);  
	 }
	 
	 public static void objektuaKostuaAldatu(Connection konexioa) throws SQLException {
		 
		 	String izena     = Teklatua.getTeklatua().hitzaIrakurri("Sartu objektuaren izena: ");
	        int    kostua    = Teklatua.getTeklatua().irakurriOsoa("Sartu objektuaren kostu berria: ");

	        String query = "UPDATE OBJEKTUA SET kostua = "+kostua+"  WHERE izena=’"+izena+";";
	        Statement st = konexioa.createStatement();
	        st.executeUpdate(query);  
	 }
	 
	 public static void jokalariaEzabatu(Connection konexioa) throws SQLException {
		 
		 	String izena     = Teklatua.getTeklatua().hitzaIrakurri("Sartu ezabatu nahi duzun jokalariaren izena: ");
	      
	        String query = "DELETE FROM JOKALARI WHERE izena=’"+izena+";";
	        Statement st = konexioa.createStatement();
	        st.executeUpdate(query);  
	 }
	 
	 public static void pertsonaiEzabatu(Connection konexioa) throws SQLException {
		 
		 	String izena     = Teklatua.getTeklatua().hitzaIrakurri("Sartu ezabatu nahi duzun pertsonaiaren izena: ");
	              
	        String query = "DELETE FROM PERTSONAIA WHERE izena=’"+izena+";";
	        Statement st = konexioa.createStatement();
	        st.executeUpdate(query);  
	 }
	 
	 public static void objektuaEzabatu(Connection konexioa) throws SQLException {
		 
		 	String izena     = Teklatua.getTeklatua().hitzaIrakurri("Sartu ezabatu nahi duzun objektuaren izena: ");
	              
	        String query = "DELETE FROM OBJEKTUA WHERE izena=’"+izena+";";
	        Statement st = konexioa.createStatement();
	        st.executeUpdate(query);  
	 }
	 
}
