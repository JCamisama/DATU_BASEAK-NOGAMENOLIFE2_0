package packLol;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jokalaria {
    
    private int objKop=0;
    private static String nan;//porque la bombilla lo dice
    
    public Jokalaria(String pNan){
    	
    	nan= pNan;
        
    }
    
    public void partidaJokatu() throws SQLException, ClassNotFoundException{
    	
    	
    	Connection konexioa = Jokalaria.konexioa();
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
            System.out.println("8.-  Objektu bat aldatu");
            System.out.println("9.-  Objektu bat sartu");
            System.out.println("10.- Objektu bat kendu");
            System.out.println("0.-  Partida hasi");
            aukera=Teklatua.getTeklatua().irakurriOsoa("Sartu aukera");
            //konexioa = Jokoa.konexioa();
            if(aukera==1){
                objektua=Teklatua.getTeklatua().hitzaIrakurri("Sartu Objektua");//exception ez dago objektua
                Jokalaria.objIndarraBistaratu(objektua);
            }
            else if(aukera==2){
                objektua=Teklatua.getTeklatua().hitzaIrakurri("Sartu Objektua");//exception ez dago objektua
                Jokalaria.objDefentsaBistaratu(objektua);
            }
            else if (aukera==3){
                objektua=Teklatua.getTeklatua().hitzaIrakurri("Sartu Objektua");//exception ez dago objektua
                Jokalaria.objKostuaBistaratu(objektua);
            }
            else if(aukera==4){
                Jokalaria.perIndarraBistaratu();
            }
            else if(aukera==5){
                Jokalaria.perDefentsaBistaratu();
            }
            else if(aukera==6){
                Jokalaria.perInfoBistartu();
            }
            else if(aukera==7){
                Jokalaria.perAldatu();
            }
            else if(aukera==8){
                String objektuBerria="";
                objektuBerria=Teklatua.getTeklatua().hitzaIrakurri("Sartu gehitu nahi duzun objektua Objektua");//exception ez dago objektua
                objektua=Teklatua.getTeklatua().hitzaIrakurri("Sartu kendu nahi duzun Objektua");//exception ez dago objektua
                Jokalaria.objAldatu(objektua,objektuBerria);
            }
            else if(aukera==9){
                if (this.objKop>5){
                    System.out.println("Ezin dituzu objektu gehiagorik sartu, 6 da maximoa");
                }
                else{
                    this.objKop++;
                    Jokalaria.objektuaSartu(); 
                }
            }
            else if(aukera==10){
                objektua=Teklatua.getTeklatua().hitzaIrakurri("Sartu Objektua");//exception ez dago objektua
                Jokalaria.objektuaKendu(objektua);
            }
            else{
                System.out.println("Partida hasi da!");
            }
        }
    }
     
    private void partidaHasiera(Connection konexioa) throws SQLException{//De nuevo, la bombilla
        int aukera = -1;
        Jokalaria.jokalariaSartu(konexioa);
        Jokalaria.pertsonaiaAukeratu(konexioa);
        while(aukera!=0){
            //Interfaze grafikoa aukerekin
            aukera=Teklatua.getTeklatua().irakurriOsoa("Sartu aukera");
            if (aukera==1){
                Jokalaria.objektuaSartu();
            }
        }
        //Connection konexioa=null;
        
    }
    private static void pertsonaiaAukeratu(Connection konexioa) throws SQLException {
    	
    	String izena  = Teklatua.getTeklatua().hitzaIrakurri("Sartu pertsonaiaren izena: ");

        String query = "SELECT izena FROM PERTSONAIA WHERE izena='"+izena+"'" ;
        Statement st = konexioa.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        if(rs.getString("izena").equals(izena)){
        	
        	query = "UPDATE JOKALARIA SET perizena='"+izena+"' WHERE NAN='"+Jokalaria.nan+"' ";
        	
        }
        
        else{
        	
        	//Eso, faltan salbuespenak. Bien hecho, sería un salbuespen, pero no me pagáis lo suficiente.
        	System.out.println("Aprende a escribir, hijo de tu p**a madre, retrasau, y hace falta un salbuespen <3");
        }
        
        
        
        
        /* PERTSONAI AUKERA PROZESUA/ALGORITMOA
         * 
         * 1. sartu pertsonaiaren izena
         * 2. Datu baseuan dagoen bilatu (EXIST bat erabili????)
         * 3. existitzen bada, update egin.
         * 4. Ez bada existitzen, aprende a escribir, p**o
         * 
         * 

         * 
         * 
         * 
         * 
         * 
         * 
         */
    }
    
    
    
    private static void jokalariaSartu(Connection konexioa) throws SQLException {
    	
		String nanZenb  = Teklatua.getTeklatua().hitzaIrakurri("Sartu zure nan zenbakia, letrarekin: ");
	
	    String query = "SELECT nan FROM JOKALARIA WHERE NAN='"+nanZenb+"'" ;
	    Statement st = konexioa.createStatement();
	    ResultSet rs = st.executeQuery(query);
	    
	    if(rs.getString("nan").equals(nanZenb)){
	    	
	    	Jokalaria.nan = nanZenb;
	    	
	    }
	    
	    else{
	    	
	    	//Eso, faltan salbuespenak. Bien hecho, sería un salbuespen, pero no me pagáis lo suficiente.
	    	System.out.println("No existes, llora.");
	    }
    	
    	
    	
        // TODO Auto-generated method stub
      //Interfaze grafikoa pertsonaiekin
    }
    private static void objektuaSartu(){
        //Interfaze grafikoa objektuekin
    	
    	
    }
    
    private static void objektuaKendu(String objektua) {
        // TODO Auto-generated method stub
        
    }

    private static void objAldatu(String objektua, String objektuBerria) {
        // TODO Auto-generated method stub
        
    }

    private static void perAldatu() {
        // TODO Auto-generated method stub
        
    }

    private static void perInfoBistartu() {
        // TODO Auto-generated method stub
        
    }

    private static void objKostuaBistaratu(String objektua) {
        // TODO Auto-generated method stub
        
    }

    private static void perDefentsaBistaratu() {
        // TODO Auto-generated method stub
        
    }

    private static void perIndarraBistaratu() {
        // TODO Auto-generated method stub
        
    }

    private static void objDefentsaBistaratu(String objektua) {
        // TODO Auto-generated method stub
        
    }

    private static void objIndarraBistaratu(String objektua) {
        // TODO Auto-generated method stub
        
    }
    
    
	 public static Connection konexioa() throws ClassNotFoundException, SQLException{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        String zerbitzaria = "jdbc:mysql://localhost:3306/jokoa";
	        String erabiltzailea = "root";
	        String pasahitza = "";
	        return DriverManager.getConnection(zerbitzaria, erabiltzailea, pasahitza);// salvado por la bombilla

	}
}
