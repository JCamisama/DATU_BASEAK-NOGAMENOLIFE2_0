package packLol;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import java.sql.Connection;

//import chapapote.Jokoa;

public class Administratzailea {
    public Administratzailea(){
        
    }
    public void menuaBistaratu() throws  ClassNotFoundException{ //Berrikusita 1 aldiz
        
    	try{
	    	int aukera = -1;
	     
	        Connection konexioa = Lol.konexioa();
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
	            System.out.println("12.- Pertsonaiak alfabetikoki ordenatu");
	            System.out.println("13.- Kategoria bakoitzaren pertsonaia kopurua ikusi");//GROUP BY
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
	                Administratzailea.pertsonaiakOrdenatu(konexioa);
	            }
	            else if(aukera==13){
	                Administratzailea.kategoriaPertsKopMax(konexioa);
	            }
	        }
	        System.out.println("Irten zara");
    	}
    	
    	catch(SQLException e){
    		
    		System.out.println("Konexioak huts egin du.");
    	}
    }
    
    public static void jokalariaSartu(Connection konexioa){ //Berrikusita 1 aldiz
       	
    	try{
	        String nan  = Teklatua.getTeklatua().hitzaIrakurri("Sartu jokalariaren NAN zenbakia: ");
	        nan = nan.trim();
	        
	        if( Administratzailea.nanEgokiaDa(nan) ){
	        	
	        	String rola = Teklatua.getTeklatua().hitzaIrakurri("Sartu jokalariaren rola: "); 
	        	rola = rola.trim();
	        	
	        	if( Administratzailea.rolEgokiaDa(rola) ){
	        		
			        int	   adina = Teklatua.getTeklatua().irakurriOsoa("Sartu jokalariaren adina: "); 
			        String izena = Teklatua.getTeklatua().hitzaIrakurri("Sartu jokalariaren izena: "); 
			        String herrialdea = Teklatua.getTeklatua().hitzaIrakurri("Sartu jokalariaren herrialdea: ");
			        
			        izena		= izena.trim();
			        herrialdea	= herrialdea.trim();
	
			        if( izena.length()<=15 && herrialdea.length() <= 15 ){
			        	
				        String query = "INSERT INTO JOKALARIA(nan, rola, adina, izena, herrialdea) VALUES('"+nan+"','"+rola+"',"+adina+",'"+izena+"','"+herrialdea+"');";
				        Statement st = konexioa.createStatement();
				        st.executeUpdate(query); 
			        }
			        
			        else{
			        	
			        	System.out.println("Sartutako izena edo herrialdea 15 karaktere baino gehiago ditu. "
			        			+ "Saiatu berriro mesedez");
			        }
	        	}
	        	
	        	else{
	        		
		        	System.out.println("Rol desegokia da, saia zaitez berriro (Posibilitateak: Support, "
		        			+ "ADC, MID, Jungle, Top)");
	        	}
	        	
	        }
	        
	        else{
	        	
	        	System.out.println("NAN-a desegokia da, saia zaitez berriro (Adibidea: 888888888-A) ");
	        }
	        
    	}
    	catch(SQLException e){
			 
			 System.out.println("Sartu duzun jokalaria jadanik existitzen zen.");
		 } 	
    }
	    
	 
	 
	 public static void pertsonaiaSartu(Connection konexioa){//Berrikusita 1 aldiz
	       
		 try{
		 	String kategoria = Teklatua.getTeklatua().hitzaIrakurri("Sartu pertsonaiaren kategoria (Euskarri, "
		 			+ "Mago, Tanke, Tiratzailea, Borrokalari, Hiltzaile): ");
		 	kategoria = kategoria.trim();
		 	
		 	if( Administratzailea.kategoriaEgokiaDa(kategoria) ){
		 	
		        String izena     = Teklatua.getTeklatua().hitzaIrakurri("Sartu pertsonaiaren izena: ");
		        izena = izena.trim();
		        
		        if( izena.length()<=15){
		        	
			        int    indarra   = Teklatua.getTeklatua().irakurriOsoa("Sartu pertsonaiaren indarra: ");
			        int    defentsa  = Teklatua.getTeklatua().irakurriOsoa("Sartu pertsonaiaren defentsa: ");
			        
			        if( indarra>=0 && defentsa>=0){
			        	
				        String    info    = Teklatua.getTeklatua().hitzaIrakurri("Sartu pertsonaiaren informazioa: ");
				        info = info.trim();
				        
				        if( info.length()<=1000){
				        	
					        String query = "INSERT INTO PERTSONAIA VALUES('"+izena+"','"+kategoria+"',"+indarra+","+defentsa+",'"+info+"');";
					        Statement st = konexioa.createStatement();
					        st.executeUpdate(query);
				        }
				        
				        else{
				        	
				        	System.out.println("Sartutako deskripzioa 1000 karaktere baino gehiago ditu, "
				        			+ "saia zaitez berriro mesedez.");
				        }
		        	}
			        
			        else{
			        	
			        	System.out.println("Indarra eta defentsa negatiboak ez dira onartzen.");
			        }
		        }
		        
		        else{
		        	
		        	System.out.println("Sartu duzun izena 15 karaktere baino handiagoa da, saia zaitez berriro mesedez.");
		        }
		 	}
		 	
		 	else{
		 		
		 		System.out.println("Sartu duzun kategoria ez da egokia, saia zaitez berriro mesedez");
		 	}
		 }
		 catch(SQLException e){
			 
			 System.out.println("Sartu duzun pertsonaia jadanik existitzen zen.");
		 } 	
	 
	 }
	 
	 
	 public static void objektuaSartu (Connection konexioa){ //Berrikusita 1 aldiz
		 try{
		    String izena     = Teklatua.getTeklatua().hitzaIrakurri("Sartu objektuaren izena: ");
		    izena = izena.trim();
		    
		    if( izena.length()<= 15){
		    	
		    	int    indarra   = Teklatua.getTeklatua().irakurriOsoa("Sartu objektuaren indarra: ");
		        int    defentsa  = Teklatua.getTeklatua().irakurriOsoa("Sartu objektuaren defentsa: ");
		        int    kostua    = Teklatua.getTeklatua().irakurriOsoa("Sartu objektuaren kostua: ");
		        
		        if( indarra>=0 && defentsa>=0 && kostua>=0 ){
		        	
		            String query = "INSERT INTO OBJEKTUA VALUES ('"+izena+"',"+indarra+","+defentsa+","+kostua+");";
			        Statement st = konexioa.createStatement();
			        st.executeUpdate(query);
		        }
		        else{
		        	
			 		System.out.println("Sartu duzun zenbakiren bat negatiboa da, saia zaitez berriro.");
		        }
		    }
		    
		    else{
		    	
		 		System.out.println("Sartu duzun kategoria ez da egokia, saia zaitez berriro mesedez");
		    }
		 }
		 catch(SQLException e){
			 
			 System.out.println("Sartu duzun objektua jadanik existitzen zen.");
		 } 	
		 
	          
	 }
	 
	 public static void pertsonaiIndarraAldatu(Connection konexioa){ //Berrikusita 1 aldiz
		 
		 try{
			 
		 	String izena     = Teklatua.getTeklatua().hitzaIrakurri("Sartu pertsonaiaren izena: ");
		 	izena = izena.trim();
	        String query = "SELECT izena FROM PERTSONAIA WHERE izena='"+izena+"';" ;
	        Statement st = konexioa.createStatement();
	        ResultSet rs = st.executeQuery(query);
	        rs.next();
	        
	        if(rs.getString("izena").equalsIgnoreCase(izena)){
	        	
	        	int    indarra   = Teklatua.getTeklatua().irakurriOsoa("Sartu pertsonaiaren indar berria: ");
	        	
	        	if( indarra>=0){
		 	        query = "UPDATE PERTSONAIA SET indarra = "+indarra+"  WHERE IZENA='"+izena+"';";
		 	        st = konexioa.createStatement();
		 	        st.executeUpdate(query); 
	        	}
	        	else{
	        		
	        		System.out.println("Ezin da indar negatiboa sartu.");
	        	}
	        }
		 }
	        
		catch(SQLException e){
			
			System.out.println("Sartu duzun pertsonaia ez da existitzen.");
		} 
	 }
	 
	 
	 public static void pertsonaiDefentsaAldatu(Connection konexioa){//Berrikusita 1 aldiz
		 
		 try{
			 
			 	String izena     = Teklatua.getTeklatua().hitzaIrakurri("Sartu pertsonaiaren izena: ");
			 	izena = izena.trim();
		        String query = "SELECT izena FROM PERTSONAIA WHERE izena='"+izena+"';" ;
		        Statement st = konexioa.createStatement();
		        ResultSet rs = st.executeQuery(query);
		        rs.next();
		        

		        if(rs.getString("izena").equalsIgnoreCase(izena)){
		        	
			        int    defentsa  = Teklatua.getTeklatua().irakurriOsoa("Sartu pertsonaiaren defentsa berria: ");

			        if( defentsa>=0){
			        	
				        query = "UPDATE PERTSONAIA SET defentsa = "+defentsa+"  WHERE IZENA='"+izena+"';";
				        st = konexioa.createStatement();
				        st.executeUpdate(query);
			        }
			        
			        else{
			        	
			        	System.out.println("Ezin da defentsa negatiboa sartu.");
			        }
		        }
		 }
		 
		 catch(SQLException e){
			 
			 System.out.println("Sartu duzun pertsonaia ez da existitzen.");
		 } 	
	 }
	 
	 
	 
	 public static void objektuaIndarraAldatu(Connection konexioa){//Berrikusita 1 aldiz
		 
		 try{
			 
			 	String izena     = Teklatua.getTeklatua().hitzaIrakurri("Sartu objektuaren izena: ");
			 	izena = izena.trim();
		        String query = "SELECT izena FROM OBJEKTUA WHERE izena='"+izena+"';" ;
		        Statement st = konexioa.createStatement();
		        ResultSet rs = st.executeQuery(query);
		        rs.next();
		 
		        if(rs.getString("izena").equalsIgnoreCase(izena)){
		        	
			        int    indarra   = Teklatua.getTeklatua().irakurriOsoa("Sartu objektuaren indar berria: ");
			        
			        if( indarra >= 0){
			      
				        query = "UPDATE OBJEKTUA SET indarra = "+indarra+"  WHERE izena='"+izena+"';";
				        st = konexioa.createStatement();
				        st.executeUpdate(query);
			        }
			        
			        else{
			        	
			        	System.out.println("Ezin da indarra negatiboa sartu.");
			        }
		        }
		 }
		 
		 catch(SQLException e){
			 
			 System.out.println("Sartu duzun objektua ez da existitzen.");
		 } 	
	 }
	 
	 public static void objektuaDefentsaAldatu(Connection konexioa){//Berrikusita 1 aldiz

	        try{
				 
			 	String izena     = Teklatua.getTeklatua().hitzaIrakurri("Sartu objektuaren izena: ");
			 	izena = izena.trim();
		        String query = "SELECT izena FROM OBJEKTUA WHERE izena='"+izena+"';" ;
		        Statement st = konexioa.createStatement();
		        ResultSet rs = st.executeQuery(query);
		        rs.next();
		 
		        if(rs.getString("izena").equalsIgnoreCase(izena)){
		        	
		        	int    defentsa  = Teklatua.getTeklatua().irakurriOsoa("Sartu objektuaren defentsa berria: ");
			        
			        if( defentsa >= 0){
			      
			        	query = "UPDATE OBJEKTUA SET denfentsa = "+defentsa+"  WHERE izena='"+izena+"';";
				        st = konexioa.createStatement();
				        st.executeUpdate(query);
			        }
			        
			        else{
			        	
			        	System.out.println("Ezin da defentsa negatiboa sartu.");
			        }
		        }
		 }
		 
		 catch(SQLException e){
			 
			 System.out.println("Sartu duzun objektua ez da existitzen.");
		 } 	
	 }
	 
	 
	 public static void objektuaKostuaAldatu(Connection konexioa){//Berrikusita 1 aldiz
	        
	        try{
				 
			 	String izena     = Teklatua.getTeklatua().hitzaIrakurri("Sartu objektuaren izena: ");
			 	izena = izena.trim();
		        String query = "SELECT izena FROM OBJEKTUA WHERE izena='"+izena+"';" ;
		        Statement st = konexioa.createStatement();
		        ResultSet rs = st.executeQuery(query);
		        rs.next();
		 
		        if(rs.getString("izena").equalsIgnoreCase(izena)){
		        	
		        	int    kostua    = Teklatua.getTeklatua().irakurriOsoa("Sartu objektuaren kostu berria: ");
			        
			        if( kostua >= 0){
			      
			        	query = "UPDATE OBJEKTUA SET kostua = "+kostua+"  WHERE izena='"+izena+"';";
				        st = konexioa.createStatement();
				        st.executeUpdate(query);  
			        }
			        
			        else{
			        	
			        	System.out.println("Ezin da kostua negatiboa sartu.");
			        }
		        }
		 }
		 
		 catch(SQLException e){
			 
			 System.out.println("Sartu duzun objektua ez da existitzen.");
		 } 	
	 }
	 
	 
	 public static void jokalariaEzabatu(Connection konexioa){//Berrikusita 1 aldiz
		 

	    	try {
	        	
	    		String izena = Teklatua.getTeklatua().hitzaIrakurri("Sartu ezabatu nahi duzun jokalariaren izena: ");
	    		izena = izena.trim(); //Espazioak kenduko dira hasieran eta amaieran, MySQL-ko emaitzarekin konparatu ahal izateko.

			    String query = "SELECT izena FROM JOKALARIA WHERE izena='"+izena+"';";
			    Statement st = konexioa.createStatement();
			    ResultSet rs = st.executeQuery(query);
			    rs.next();
		
		    	if(rs.getString("izena").equalsIgnoreCase(izena)){
		    	
		    		query = "DELETE FROM JOKALARIA WHERE izena='"+izena+"';";
			        st = konexioa.createStatement();
			        st.executeUpdate(query); 
		    	}	
		    }
		    
		    catch (SQLException e){
	    		
		    	System.out.println("\nSartu duzun jokalaria ez da existitzen.\n");		    	
		    }   
	 }
	 
	 
	 
	 
	 public static void pertsonaiEzabatu(Connection konexioa){//Berrikusita 1 aldiz
		    
	    	try {
	    		String izena     = Teklatua.getTeklatua().hitzaIrakurri("Sartu ezabatu nahi duzun pertsonaiaren izena: ");
	    		izena = izena.trim(); //Espazioak kenduko dira hasieran eta amaieran, MySQL-ko emaitzarekin konparatu ahal izateko.

			    String query = "SELECT izena FROM PERTSONAIA WHERE izena='"+izena+"';";
			    Statement st = konexioa.createStatement();
			    ResultSet rs = st.executeQuery(query);
			    rs.next();
		
		    	if(rs.getString("izena").equalsIgnoreCase(izena)){
		    	
		    		query = "DELETE FROM PERTSONAIA WHERE izena='"+izena+"';";
			        st = konexioa.createStatement();
			        st.executeUpdate(query);  
		    	}	
		    }
		    
		    catch (SQLException e){
	    		
		    	System.out.println("\nSartu duzun pertsonaia ez da existitzen.\n");		    	
		    }   
	 }
	 
	 
	 
	 public static void objektuaEzabatu(Connection konexioa){//Berrikusita 1 aldiz
		 
		 
	    	try {
	    		
	    		String izena     = Teklatua.getTeklatua().hitzaIrakurri("Sartu ezabatu nahi duzun objektuaren izena: ");
	    		izena = izena.trim(); //Espazioak kenduko dira hasieran eta amaieran, MySQL-ko emaitzarekin konparatu ahal izateko.

			    String query = "SELECT izena FROM OBJEKTUA WHERE izena='"+izena+"';";
			    Statement st = konexioa.createStatement();
			    ResultSet rs = st.executeQuery(query);
			    rs.next();
		
		    	if(rs.getString("izena").equalsIgnoreCase(izena)){
		    	
		    		query = "DELETE FROM OBJEKTUA WHERE izena='"+izena+"';";
			        st = konexioa.createStatement();
			        st.executeUpdate(query);
		    	}	
		    }
		    
		    catch (SQLException e){
	    		
		    	System.out.println("\nSartu duzun objektua ez da existitzen.\n");		    	
		    }            
	          
	 }
	 
	 private static void kategoriaPertsKopMax(Connection konexioa) throws SQLException {
	    
		 try {
			 
	        int kop=Teklatua.getTeklatua().irakurriOsoa("Sartu pertsonaia maximoa (baldin eta kategoria batek adierazitako kopurua baino pertsonaia gehiago baditu ez da erakutsiko kategoria hori)");
            
	        if( kop >= 0){
		        String query = "SELECT kategoria,COUNT(*) FROM PERTSONAIA GROUP BY kategoria HAVING COUNT(*)<="+kop+";";
	            Statement st = konexioa.createStatement();
	            ResultSet rs = st.executeQuery(query);
	            System.out.println("***KATEGORIAKO PERTSONAIA KOPURUA ("+kop+" baino gutxiago)***\n");
	            while (rs.next()) {
	                System.out.print(" - "+rs.getString("kategoria"));
	                System.out.println(" - "+rs.getString("COUNT(*)"));
	            }
	        }
	        
	        else{
	        	
	        	System.out.println("\nEz dira kopuru negatiboak onartzen.\n");
	        }
		 }
		 
		 catch(SQLException e){
			 
	        	System.out.println("\nEz daude sartutako zenbakia baino kategoria kopuru txikiagorik. \n");
		 }
	 }

	 private static void pertsonaiakOrdenatu(Connection konexioa) throws SQLException {
	     
	     String query = "SELECT izena FROM PERTSONAIA ORDER BY izena;";
         Statement st = konexioa.createStatement();
         ResultSet rs = st.executeQuery(query);
         System.out.println("***PERTSONAIAK ALFABETIKOKI ORDENATUTA***\n");
         while (rs.next()) {
             System.out.println(" - "+rs.getString("izena"));
         }
	 }
	 
	 //Metodo laguntzaileak
	 
	 private static boolean nanEgokiaDa(String pNan){
		 
		 int luzera = pNan.length();
		 String aux = pNan.toUpperCase();
		 boolean egokia = false;
		 
		 egokia = (luzera==11)&&(aux.charAt(9)=='-')&& 
				  ( ((aux.charAt(10) >= 'A' && aux.charAt(10) <= 'Z') || aux.charAt(10) == '?') );

		 return egokia;
	 }
	 
	 private static boolean rolEgokiaDa(String pRol){
		 
		 boolean egokia = false;
		 
		 egokia = ( (pRol.equalsIgnoreCase("Support")) || (pRol.equalsIgnoreCase("ADC")) ||
				     (pRol.equalsIgnoreCase("MID")) || (pRol.equalsIgnoreCase("Jungle")) ||
				     (pRol.equalsIgnoreCase("Top")) );
		 
		 return egokia;
	 }
	 
	 private static boolean kategoriaEgokiaDa(String pKat){
		 
		 boolean emaitza = false;
		 
		 emaitza = ( (pKat.equalsIgnoreCase("Euskarri")) || (pKat.equalsIgnoreCase("Mago")) ||
			     (pKat.equalsIgnoreCase("Tanke")) || (pKat.equalsIgnoreCase("Tiratzailea")) ||
			     (pKat.equalsIgnoreCase("Borrokalari")) || (pKat.equalsIgnoreCase("Hiltzaile")));
		 
		 return emaitza;
	 }
}
