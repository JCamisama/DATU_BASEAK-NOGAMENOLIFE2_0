package packLol;

import java.sql.Connection;

import chapapote.Jokoa;

public class Administratzailea {
    public Administratzailea(){
        
    }
    public void menuaBistaratu(){
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
            aukera=Teklatua.getTeklatua().irakurriOsoa("Sartu aukera");
            //konexioa = Jokoa.konexioa();
            if(aukera==1){
                
            }
            else if(aukera==2){
                
            }
            else if(aukera==3){
                
            }
        }
    }
}
