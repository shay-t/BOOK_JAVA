package Transform;

import java.util.ArrayList;

import DA0.LIVRE;

public class Transformer {
	public static LIVRE transformer(ArrayList<String> a) {
		//trim enlever les espaces : parse float ca va servir pour enlever les espaces
		//split ->enlever
		String titre=a.get(0).replace('\'',' ');
		String auteur= a.get(1).split(":")[1].replace('\'', ' ');
		String ISBN= a.get(2).split(":")[1];
		int dispo= Integer.parseInt(a.get(3).split(":")[1].trim());
		double prix=Double.parseDouble(a.get(4).split(" ")[0].trim());
		// ou bien tronquer une partie dun string
		//pos=price.indexOf("Dhs");
		//price=price.substring(0,pos);
		//----------------
		LIVRE l1=new LIVRE(titre,auteur,ISBN,dispo,prix);
		return l1;
	}

}
