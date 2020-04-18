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
    
    public void displayJokalariMenu() throws ClassNotFoundException, SQLException{
        
        Lol.getNireLol();
        Connection konexioa=Lol.konexioa();
        
        String query = "SELECT izena,nan FROM JOKALARIA;";
        Statement st = konexioa.createStatement();
        ResultSet rs = st.executeQuery(query);
        System.out.println("***JOKALARI ESKURAGARRIAK***\n");
        while (rs.next()) {
            System.out.println(" - "+rs.getString("izena")+" - "+rs.getString("nan"));
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
}
