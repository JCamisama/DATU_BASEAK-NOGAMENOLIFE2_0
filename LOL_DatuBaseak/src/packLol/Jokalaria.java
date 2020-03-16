package packLol;

public class Jokalaria {
    public Jokalaria(){
        
    }
    
    public void partidaJokatu(){
        this.partidaHasiera();
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
                Jokalaria.objektuaSartu();
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
    
    private void partidaHasiera(){
        int aukera = -1;
        Jokalaria.jokalariaSartu();
        Jokalaria.pertsonaiaAukeratu();
        while(aukera!=0){
            //Interfaze grafikoa aukerekin
            aukera=Teklatua.getTeklatua().irakurriOsoa("Sartu aukera");
            if (aukera==1){
                Jokalaria.objektuaSartu();
            }
        }
        //Connection konexioa=null;
        
    }
    private static void pertsonaiaAukeratu() {
        // TODO Auto-generated method stub
      //Interfaze grafikoa pertsonaiekin
    }
    private static void jokalariaSartu() {
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
}
