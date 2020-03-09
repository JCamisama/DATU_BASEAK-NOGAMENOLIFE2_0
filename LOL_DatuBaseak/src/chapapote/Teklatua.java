package chapapote;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Teklatua {
	private static Teklatua nireTeklatua=null;
	private Scanner sc;
	
	private Teklatua() {
		this.sc=new Scanner(System.in);
	}
	public static Teklatua getTeklatua() {
		if(nireTeklatua==null) {
			nireTeklatua= new Teklatua();
		}
		return nireTeklatua;
	}
	
	public void skipLine(String pMezua){
		System.out.println(pMezua);
		sc.nextLine();
	}
	
	public int irakurriOsoaSalbuespen(String pMezua) {
		System.out.println(pMezua+": ");
		int zenbakia;
		zenbakia=sc.nextInt();
		return zenbakia;
	}
	
	public int irakurriOsoa(String pMezua) {
		int erantzuna=0;
		boolean kontrolpean=false;
		do{
			try{
				erantzuna=this.irakurriOsoaSalbuespen(pMezua);
				kontrolpean=true;
		}
			catch (InputMismatchException e){
				System.out.println("Sartu duzun balioa ez da zenbaki oso bat, saiatu berriz. ");
				sc=new Scanner(System.in);
			}
	}while (!kontrolpean);
		return erantzuna;
	}	
	
	
	//Metodo berriak
	public String noraMugitu(String pMezua){
		
		System.out.print(pMezua+": ");
		String erantzuna	= sc.next();
		
		
		return erantzuna;
	}
	
	public String hitzaIrakurri(String pMezua){
		
		System.out.print(pMezua+": ");
		String erantzuna	= sc.next();
		
		
		return erantzuna;
	}
	
}
