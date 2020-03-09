package packLol;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MetodosCamisama {
	
	 public static void jokalariaSartu(Connection konexioa) throws SQLException {
	       
	        String nan  = Teklatua.getTeklatua().hitzaIrakurri("Sartu jokalariaren NAN zenbakia: ");
	        String rola = Teklatua.getTeklatua().hitzaIrakurri("Sartu jokalariaren rola: ");
	        int	   adina = Teklatua.getTeklatua().irakurriOsoa("Sartu jokalariaren rola: ");
	        String izena = Teklatua.getTeklatua().hitzaIrakurri("Sartu jokalariaren izena: ");
	        String herrialdea = Teklatua.getTeklatua().hitzaIrakurri("Sartu jokalariaren herrialdea: ");
	        //String pertsonaiIzena = Teklatua.getTeklatua().hitzaIrakurri("Sartu jokalariaren pertsonaia: ");
	        
	        
	        //Kontuz, 
	        String query = "INSERT INTO JOKALARI(nan, rola, adina, izena, herrialdea) VALUES ('"+nan+"','"+rola+"',"+adina+",'"+izena+"','"+herrialdea+"' )";
	        Statement st = konexioa.createStatement();
	        st.executeUpdate(query); 
	    }

	
	 public static void pertsonaiaSartu(Connection konexioa) throws SQLException {
	       
	        String izena     = Teklatua.getTeklatua().hitzaIrakurri("Sartu pertsonaiaren izena: ");
	        String kategoria = Teklatua.getTeklatua().hitzaIrakurri("Sartu pertsonaiaren kategoria: ");
	        int    indarra   = Teklatua.getTeklatua().irakurriOsoa("Sartu pertsonaiaren indarra: ");
	        int    defentsa  = Teklatua.getTeklatua().irakurriOsoa("Sartu pertsonaiaren defentsa: ");
	        int    kostua    = Teklatua.getTeklatua().irakurriOsoa("Sartu pertsonaiaren kostua: ");
	        //String pertsonaiIzena = Teklatua.getTeklatua().hitzaIrakurri("Sartu jokalariaren pertsonaia: ");
	        
	        
	        //Kontuz, 
	        String query = "INSERT INTO JOKALARI(nan, rola, adina, izena, herrialdea) VALUES ('"+izena+"','"+kategoria+"',"+indarra+","+defentsa+","+kostua+" )";
	        Statement st = konexioa.createStatement();
	        st.executeUpdate(query); 
	    }

	
	 
	 
	 /*Administratzailea
	  * 
	  *  Jokalariak sartu.
	  *  pertsonaiak sartu.
	  *  objektuak sartu.
	  *  igual un campeón se buggea i lo quitas
	  *  jokalariak ezabatu.
	  *  datu basea eguneratu.
	  *  Pertsonaien, jokalarien, etab. atributuak aldatu.
	  *  
	  *  */
	 
	 
	 /*Jokalaria
	  * 
	  * meter el null que hemos puesto antes
	  * Kontsultak (Order by, group by, having)
	  * 
	  * 
	  * 
	  * 
	  */
}
