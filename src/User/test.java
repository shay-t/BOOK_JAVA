package User;

import java.util.ArrayList;
import Load.Loader;
import DA0.LIVRE;
import Extract.Scraper;

import java.util.Scanner;

public class test {
	public static void main(String[] args) {

		Scanner Scan=new Scanner(System.in);
		System.out.println("saisir le numero de la page");
		int i = Scan.nextInt();
		ArrayList <LIVRE> livres = Scraper.text(i);
		//insertion
		Loader.connecter();
		Loader.inserer_livres(livres);
		Loader.deconnecter();
		//affichage 

	}
}

