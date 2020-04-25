package packLol;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jokalaria {
    
    private int objKop=0;
    private static String nan;
    
    public Jokalaria(String pNan){
    	
    	nan= pNan;
        
    }
    
    public void partidaJokatu() throws SQLException, ClassNotFoundException{
    	
    	
    	Connection konexioa = Lol.konexioa();
        this.partidaHasiera(konexioa);
        
        int aukera = -1;
        String objektua = "";
        while (aukera != 0) {
            System.out.println("");
            System.out.println("+-------------------------------+");
            System.out.println("|        Jokalari Menua         |");
            System.out.println("+-------------------------------+");
            System.out.println("Aukeratu:");
            System.out.println("1.-  Objektu baten indarra ikusi");
            System.out.println("2.-  Objektu baten defentsa ikusi"); 
            System.out.println("3.-  Objektu baten kostua ikusi");
            System.out.println("4.-  Aukeratutako pertsonaiaren indarra ikusi");
            System.out.println("5.-  Aukeratutako pertsonaiaren defentsa ikusi");
            System.out.println("6.-  Aukeratutako pertsonaiaren informazioa ikusi");
            System.out.println("7.-  Pertsonaia aldatu");
            System.out.println("8.-  Objektu bat sartu");
            System.out.println("9.-  Objektu bat kendu");
            System.out.println("0.-  Partida hasi");
            aukera=Teklatua.getTeklatua().irakurriOsoa("Sartu aukera");
            //konexioa = Jokoa.konexioa();
            if(aukera==1){
                Menu.getNireMenu().displayObjektuMenu();
                objektua=Teklatua.getTeklatua().hitzaIrakurri("Sartu Objektua");//exception ez dago objektua
                Jokalaria.objIndarraBistaratu(objektua, konexioa);
            }
            else if(aukera==2){
                Menu.getNireMenu().displayObjektuMenu();
                objektua=Teklatua.getTeklatua().hitzaIrakurri("Sartu Objektua");//exception ez dago objektua
                Jokalaria.objDefentsaBistaratu(objektua, konexioa);
            }
            else if (aukera==3){
                Menu.getNireMenu().displayObjektuMenu();
                objektua=Teklatua.getTeklatua().hitzaIrakurri("Sartu Objektua");//exception ez dago objektua
                Jokalaria.objKostuaBistaratu(objektua, konexioa);
            }
            else if(aukera==4){
                Jokalaria.perIndarraBistaratu(konexioa);
            }
            else if(aukera==5){
                Jokalaria.perDefentsaBistaratu(konexioa);
            }
            else if(aukera==6){
                Jokalaria.perInfoBistaratu(konexioa);
            }
            else if(aukera==7){
                Jokalaria.pertsonaiaAukeratu(konexioa);
            }
        
            else if(aukera==8){
                Menu.getNireMenu().displayJokalariarenObjektuak(Jokalaria.nan);
                if (this.objKop>5){
                    System.out.println("Ezin dituzu objektu gehiagorik sartu, 6 da maximoa");
                }
                else{
                    this.objKop++;
                    Menu.getNireMenu().displayObjektuMenu();
                    Jokalaria.objektuaSartu(konexioa); 
                }
            }
            else if(aukera==9){
                Menu.getNireMenu().displayJokalariarenObjektuak(Jokalaria.nan);
                this.objKop--;
                objektua=Teklatua.getTeklatua().hitzaIrakurri("Sartu Objektua");//exception ez dago objektua
                Jokalaria.objektuaKendu(objektua, konexioa);
            }
            else{
                System.out.println("Partida hasi da!");
            }
        }
    }
     
    private void partidaHasiera(Connection konexioa) throws SQLException, ClassNotFoundException{//BERRIKUSITA 1 ALDIZ
    	
    	int emaitza = -1;     	 
    	emaitza = Jokalaria.jokalariaIdentifikatu(konexioa);        
        if (emaitza != -1) {
        	
        	Jokalaria.pertsonaiaAukeratu(konexioa);        	
        }
        
        else {
        	
        	Menu.getNireMenu().menuPrintzipalaBistaratu();
        	
        }   	
        
        //Connection konexioa=null;
        
    }
    private static void pertsonaiaAukeratu(Connection konexioa) throws ClassNotFoundException {//BERRIKUSITA 1 ALDIZ
    	
    	try{
    		
    	
	    	Menu.getNireMenu().displayJokalariarenPertsonaia(Jokalaria.nan);    	
	        Menu.getNireMenu().displayPertsonaiaMenu();
	    	String izena  = Teklatua.getTeklatua().hitzaIrakurri("Sartu pertsonaiaren izena: ");
	        izena = izena.trim(); ////Espazioak kenduko dira hasieran eta amaieran, MySQL-ko emaitzarekin konparatu ahal izateko.

	        String query = "SELECT izena FROM PERTSONAIA WHERE izena='"+izena+"';" ;
	        Statement st = konexioa.createStatement();
	        ResultSet rs = st.executeQuery(query);
	        rs.next();
	        
	        if(rs.getString("izena").equals(izena)){
	        	
	        	query = "UPDATE JOKALARIA SET perizena='"+izena+"' WHERE NAN='"+Jokalaria.nan+"';";
	        	st.executeUpdate(query);
	        }
    	}
    	
    	catch(SQLException e){
    		
    		System.out.println("\nSartu duzun pertsonaia ez da existitzen. Mesedez saia zaitez berriro (7. Aukera hartu)\n");	
    	}
    }
    

    private static int jokalariaIdentifikatu(Connection konexioa) throws ClassNotFoundException {//BERRIKUSITA 1 ALDIZ
    	
    	
    	int emaitza = -1; //honek jokalaririk ez dela identifikatu adieraziko du.
    	
    	try {
    	
			String nanZenb  = Jokalaria.nan; //Jokalariaren nan zenbakia jadanik sortuta dago.
		    nanZenb = nanZenb.trim(); //Espazioak kenduko dira hasieran eta amaieran, MySQL-ko emaitzarekin konparatu ahal izateko.

		    String query = "SELECT nan FROM JOKALARIA WHERE nan='"+nanZenb+"';";
		    Statement st = konexioa.createStatement();
		    ResultSet rs = st.executeQuery(query);
		    rs.next();
		    System.out.println("\n"+nanZenb);
	    	if(rs.getString("nan").equals(nanZenb)){
	    	
	    		Jokalaria.nan = nanZenb; //NOTA: Hemen ere jokalariaren nan-a ipini behar da????? menuan ipintzen da ere, 
	    									//    'Menu' klaseko 47. lerroan!
	    		emaitza = 0;   //Jokalaria ondo identifikatu egin da!
	    	
	    	}
	    
	    	
	    }
	    
	    catch (SQLException e){
    		
	    	System.out.println("\nSartu duzun NAN zenbakia ez da existitzen. Mesedez saia zaitez berriro.\n");		    	
    		
    	}
    	
    	return emaitza;
    }
    
    
    private static void objektuaSartu(Connection konexioa) throws ClassNotFoundException{//BERRIKUSITA 1 ALDIZ
    	
    	
    	try{
    		
	    	String objIzena  = Teklatua.getTeklatua().hitzaIrakurri("Sartu objektuaren izena: ");
	        objIzena = objIzena.trim(); //Espazioak kenduko dira hasieran eta amaieran, MySQL-ko emaitzarekin konparatu ahal izateko.

	        String query = "SELECT izena FROM OBJEKTUA WHERE izena='"+objIzena+"';" ;
	        Statement st = konexioa.createStatement();
	        ResultSet rs = st.executeQuery(query);
	        rs.next();
	        
	        if(rs.getString("izena").equals(objIzena)){
	        	
	        	
	        	query = "INSERT INTO HARTU VALUES('"+Jokalaria.nan+"', '"+objIzena+"');";
	            st.executeUpdate(query);
	        }
    	}
    	
    	catch(SQLException e){
    		
    		System.out.println("\nSartu duzun objektua ez da existitzen. Mesedez saia zaitez berriro.\n");
    	}
    }
 
    private static void objektuaKendu(String pObjektua, Connection konexioa) throws  ClassNotFoundException {//BERRIKUSITA 1 ALDIZ
    	
    	try{
    		
    		pObjektua = pObjektua.trim();
	        String query = "SELECT objizena FROM HARTU WHERE objizena='"+pObjektua+"';" ;
	        Statement st = konexioa.createStatement();
	        ResultSet rs = st.executeQuery(query);
	        rs.next();
	        
	        if(rs.getString("objizena").equals(pObjektua)){
	        	
	        	query = "DELETE FROM HARTU WHERE OBJIZENA='"+pObjektua+"';";
	        	st.executeUpdate(query);
	        }
    	}
    	
    	catch(SQLException e){
    		
    		System.out.println("\nSartu duzun objektua ez da existitzen. Mesedez saia zaitez berriro.\n");
    	}
    }
    
    
    
    



    private static void perInfoBistaratu(Connection konexioa) throws ClassNotFoundException {//BERRIKUSITA 1 ALDIZ

    	
    	try{
	        Menu.getNireMenu().displayPertsonaiaMenu();
	    	String izena  = Teklatua.getTeklatua().hitzaIrakurri("Sartu pertsonaiaren izena: ");
	    	izena = izena.trim();//Espazioak kenduko dira hasieran eta amaieran, MySQL-ko emaitzarekin konparatu ahal izateko.
	    	
	        String query = "SELECT * FROM PERTSONAIA WHERE izena='"+izena+"';" ;
	        Statement st = konexioa.createStatement();
	        ResultSet rs = st.executeQuery(query);
	        rs.next();
	        
	        
	        if(rs.getString("izena").equals(izena)){
	        	
	        	System.out.print("INFO: ");
	            System.out.println(rs.getString("INFO"));
	            System.out.println("\n\n");
	            
	            /* 
	            System.out.print("IZENA: ");
	            System.out.println(rs.getString("IZENA"));
	            
	            System.out.print("KATEGORIA: ");
	            System.out.println(rs.getString("KATEGORIA"));
	            
	            System.out.print("INDARRA: ");
	            System.out.println(rs.getString("INDARRA"));
	            
	            System.out.print("DEFENTSA: ");
	            System.out.println(rs.getString("DEFENTSA"));*/
	        }
    	}
        
    	catch( SQLException e){
    		
    		System.out.println("\nSartu duzun pertsonaia ez da existitzen. Mesedez saia zaitez berriro.\n");
    	}     
    }

    
    
    private static void objKostuaBistaratu(String pObjektua, Connection konexioa) throws ClassNotFoundException {//BERRIKUSITA 1 ALDIZ
   
    	
    	try{
    		
	    	pObjektua = pObjektua.trim();//Espazioak kenduko dira hasieran eta amaieran, MySQL-ko emaitzarekin konparatu ahal izateko.
	        String query = "SELECT * FROM OBJEKTUA WHERE izena='"+pObjektua+"';" ;
	        Statement st = konexioa.createStatement();
	        ResultSet rs = st.executeQuery(query);
	        rs.next();
	        
	        if(rs.getString("izena").equals(pObjektua)){
	        	
	        	System.out.print("Objektuaren kostua: ");
	            System.out.println(rs.getString("KOSTUA"));
	            System.out.println("\n\n");
	        }
    	}
    	
    	catch(SQLException e){
    		
    		System.out.println("\nSartu duzun objektua ez da existitzen. Mesedez saia zaitez berriro.\n");
    	}
    }

    private static void perDefentsaBistaratu(Connection konexioa) throws ClassNotFoundException {//BERRIKUSITA 1 ALDIZ
    	
    	try{
    		
	        Menu.getNireMenu().displayPertsonaiaMenu();
	    	String izena  = Teklatua.getTeklatua().hitzaIrakurri("Sartu pertsonaiaren izena: ");
	    	izena = izena.trim();//Espazioak kenduko dira hasieran eta amaieran, MySQL-ko emaitzarekin konparatu ahal izateko.
	
	
	        String query = "SELECT * FROM PERTSONAIA WHERE izena='"+izena+"';" ;
	        Statement st = konexioa.createStatement();
	        ResultSet rs = st.executeQuery(query);
	        rs.next();
	        
	        if(rs.getString("izena").equals(izena)){
		        
	        	System.out.print("DEFENTSA: ");
		        System.out.println(rs.getString("DEFENTSA"));
		        System.out.println("\n\n");
	        }
    	}
    	
    	catch(SQLException e){
    		
    		System.out.println("\nSartu duzun pertsonaia ez da existitzen. Mesedez saia zaitez berriro.\n");
    	}
    }

    private static void perIndarraBistaratu(Connection konexioa) throws ClassNotFoundException {//BERRIKUSITA 1 ALDIZ
    	
    	try{
    		
	        Menu.getNireMenu().displayPertsonaiaMenu();
	    	String izena  = Teklatua.getTeklatua().hitzaIrakurri("Sartu pertsonaiaren izena: ");
	    	izena = izena.trim();
	
	        String query = "SELECT * FROM PERTSONAIA WHERE izena='"+izena+"';" ;
	        Statement st = konexioa.createStatement();
	        ResultSet rs = st.executeQuery(query);
	        rs.next();
	        
	        if(rs.getString("izena").equals(izena)){
	        	
		        System.out.print("INDARRA: ");
		        System.out.println(rs.getString("INDARRA"));
		        System.out.println("\n\n");
	        }
    	}
    	
    	catch( SQLException e){
    		
    		System.out.println("\nSartu duzun pertsonaia ez da existitzen. Mesedez saia zaitez berriro.\n");

    	}
    }

    private static void objDefentsaBistaratu(String pObjektua, Connection konexioa) throws ClassNotFoundException {//BERRIKUSITA 1 ALDIZ
    	
    	
    	try{
    	
	    	pObjektua = pObjektua.trim();
	        String query = "SELECT * FROM OBJEKTUA WHERE izena='"+pObjektua+"';" ;
	        Statement st = konexioa.createStatement();
	        ResultSet rs = st.executeQuery(query);
	        rs.next();
	        
	        if(rs.getString("izena").equals(pObjektua)){
	        	
	            System.out.print("Objektuaren defentsa: ");
	            System.out.println(rs.getString("DENFENTSA"));
	            System.out.println("\n\n");
	        }
    	}
    	
    	catch(SQLException e){
    		
    		System.out.println("\nSartu duzun objektua ez da existitzen. Mesedez saia zaitez berriro.\n");
    	}
    }

    private static void objIndarraBistaratu(String pObjektua, Connection konexioa) throws ClassNotFoundException {//BERRIKUSITA 1 ALDIZ
    	
    	
    	try{
    		
	    	pObjektua = pObjektua.trim();
	    	String query = "SELECT * FROM OBJEKTUA WHERE izena='"+pObjektua+"';" ;
	        Statement st = konexioa.createStatement();
	        ResultSet rs = st.executeQuery(query);
	        rs.next();
	        
	        if(rs.getString("izena").equals(pObjektua)){
	        	
	            System.out.println(pObjektua);
	            System.out.print("Objektuaren indarra: ");
	            System.out.println(rs.getString("INDARRA"));
	            System.out.println("\n\n");
	        }
    	}
    	
    	catch(SQLException e){
    		
    		System.out.println("\nSartu duzun objektua ez da existitzen. Mesedez saia zaitez berriro.\n");
    	}
    }
    
    

}
