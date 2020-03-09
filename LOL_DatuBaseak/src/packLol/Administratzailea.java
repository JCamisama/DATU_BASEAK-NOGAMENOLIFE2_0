package packLol;

//import java.sql.Connection;

//import chapapote.Jokoa;

public class Administratzailea {
    public Administratzailea(){
        
    }
    public void menuaBistaratu(){
        int aukera = -1;
        //Connection konexioa=null;
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
            System.out.println("8.-  Jokalaria ezabatu");
            System.out.println("9.-  Objektua ezabatu");
            System.out.println("10.- Jokalaria ezabatu");
            System.out.println("0.-  Irten");
            aukera=Teklatua.getTeklatua().irakurriOsoa("Sartu aukera");
            //konexioa = Jokoa.konexioa();
            if(aukera==1){
                
            }
            else if(aukera==2){
                
            }
            else if(aukera==3){
                
            }
            else if(aukera==4){
                
            }
            else if(aukera==5){
                
            }
            else if(aukera==6){
                
            }
            else if(aukera==7){
                
            }
            else if(aukera==8){
                
            }
            else if(aukera==9){
                
            }
            else if(aukera==10){
                
            }
        }
    }
}
