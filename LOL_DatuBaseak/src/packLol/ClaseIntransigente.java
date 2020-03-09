package packLol;


public class ClaseIntransigente {
    public static void main(String[] args) /*throws ClassNotFoundException, SQLException*/ {
        // TODO Auto-generated method stub
        int aukera = 0;
        //Connection konexioa=null;
        
        System.out.println("Ongietorri League Of Legends-era. Nola sartu nahi zara?");
        System.out.println("+--------------+");
        System.out.println("|    Menua     |");
        System.out.println("+--------------+");
        System.out.println("Aukeratu:");
        System.out.println("1.- Erabiltzaile moduan sartu");
        System.out.println("2.- Jokalari moduan sartu");
        System.out.println("9.- Irten");
        while (aukera != 1 && aukera!=2 && aukera!=9) {
            aukera=Teklatua.getTeklatua().irakurriOsoa("Sartu aukera");
            //konexioa = Jokoa.konexioa();
            if(aukera==1){
                System.out.println("Administraile moduan sartu zara");
                Administratzailea adm=new Administratzailea();
                adm.menuaBistaratu();
            }
            else if(aukera==2){
                System.out.println("Jokalari moduan sartu zara");
                Jokalaria jok=new Jokalaria();
                jok.menuaBistaratu();
            }
            else if(aukera==9){
                System.out.println("Sistematik irtetzen .... agur!");
            }
            else{
                System.out.println("Aukera desegokia sartu duzu");
            }
        }
        //konexioa.close();  
      
    }
}
