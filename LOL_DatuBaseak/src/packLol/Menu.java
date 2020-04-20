package packLol;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Menu {
    private static Menu nMenu;
    
    private Menu(){
        
    }
    
    public static synchronized Menu getNireMenu(){
        if(nMenu==null){
            nMenu=new Menu();
        }
        return nMenu;
    }
    
    public void menuPrintzipalaBistaratu() throws ClassNotFoundException, SQLException {
    	
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
        while (aukera != 1 && aukera!=2 && aukera!=0) {
            aukera=Teklatua.getTeklatua().irakurriOsoa("Sartu aukera: ");
            
            if(aukera==1){
                System.out.println("Administraile moduan sartu zara");
                Administratzailea adm=new Administratzailea();
                adm.menuaBistaratu();
            }
            else if(aukera==2){
                System.out.println("Jokalari moduan sartu zara");
                Menu.getNireMenu().displayJokalariMenu();
                Jokalaria jok=new Jokalaria(Teklatua.getTeklatua().hitzaIrakurri("Mesedez, sartu jokalariaren nan-a: "));
                jok.partidaJokatu();
            }
            else if(aukera==0){
                System.out.println("Sistematik irtetzen .... agur!");
                System.exit(0);
            }
            else{
                System.out.println("Aukera desegokia sartu duzu");
            }
        }
        //konexioa.close();  
      
    	
    	
    	
    }
    
    public void displayJokalariMenu() throws ClassNotFoundException, SQLException{
        
        Lol.getNireLol();
        Connection konexioa=Lol.konexioa();
        
        String query = "SELECT izena,nan FROM JOKALARIA;";
        Statement st = konexioa.createStatement();
        ResultSet rs = st.executeQuery(query);
        System.out.println("***JOKALARI ESKURAGARRIAK***\n");
        while (rs.next()) {
            System.out.println(" - "+rs.getString("izena"));
        }
        System.out.println();
    }
    
    public void displayPertsonaiaMenu() throws ClassNotFoundException, SQLException{
        
        Lol.getNireLol();
        Connection konexioa=Lol.konexioa();
        
        String query = "SELECT izena FROM PERTSONAIA;";
        Statement st = konexioa.createStatement();
        ResultSet rs = st.executeQuery(query);
        System.out.println("***PERTSONAIA ESKURAGARRIAK***\n");
        while (rs.next()) {
            System.out.println(" - "+rs.getString("izena"));
        }
        System.out.println();
    }
    
    public void displayObjektuMenu() throws ClassNotFoundException, SQLException{
        
        Lol.getNireLol();
        Connection konexioa=Lol.konexioa();
        
        String query = "SELECT izena FROM OBJEKTUA;";
        Statement st = konexioa.createStatement();
        ResultSet rs = st.executeQuery(query);
        System.out.println("***OBJEKTU ESKURAGARRIAK***\n");
        while (rs.next()) {
            System.out.println(" - "+rs.getString("izena"));
        }
        System.out.println();
    }
    
    public void displayJokalariarenObjektuak(String pNan) throws ClassNotFoundException, SQLException{
        
        Lol.getNireLol();
        Connection konexioa=Lol.konexioa();
        
        String query = "SELECT objizena FROM HARTU WHERE nanjok='"+pNan+"';";
        Statement st = konexioa.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        System.out.println("***ZURE OBJEKTUAK***\n");
        
        while (rs.next()) {

            System.out.println(" - "+rs.getString("objizena"));
        }
        
        System.out.println();
    }
    
    public void displayJokalariarenPertsonaia(String pNan) throws ClassNotFoundException, SQLException{
        
        Lol.getNireLol();
        Connection konexioa=Lol.konexioa();
        
        String query = "SELECT perizena FROM jokalaria WHERE nan='"+pNan+"';";
        Statement st = konexioa.createStatement();
        ResultSet rs = st.executeQuery(query);
        System.out.println("***ZURE PERTSONAIA***\n");
        while (rs.next()) {
            System.out.println(" - "+rs.getString("perizena"));
        }
        
        
        System.out.println();
        
    }
}
