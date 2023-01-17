package Extract;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import DA0.LIVRE;
import Transform.Transformer;

import java.io.IOException;
import java.util.ArrayList;


public class Scraper {
	//avec numero de page
	public static ArrayList<LIVRE> text(int i) {
		ArrayList<LIVRE> livres= new ArrayList<LIVRE>();
		String url ="https://enstock.livremoi.ma/rayon/litterature-francophone?page="+i;
		Document doc;
		try {
			doc = Jsoup.connect(url).get();
			Elements els = doc.select(".item");
			for(Element el : els) {
				ArrayList<String> arr=new ArrayList<String>();
				//1er contenu de h6
					String titre= el.select("h6").get(0).text();
				//2eme contenu de h6
					String auteur= el.select("h6").get(1).text();
					String ISBN= el.select("h6").get(2).text();
					String dispo=el.select("h6").get(3).text();
					String prix=el.select("h6").get(4).select("span").text();
				    arr.add(titre);
					arr.add(auteur);
					arr.add(ISBN);
					arr.add(dispo);
					arr.add(prix);
					/*arr.set(0, titre);
					arr.set(1, auteur);
					arr.set(2, ISBN);
					arr.set(3, dispo);
					arr.set(4, prix);-> ins*/
					LIVRE l1=Transformer.transformer(arr);
					l1.affiche();
					livres.add(l1);
				}
			return livres;
				//recuperer le texte de chaque h6
				//for(Element el : els) {
					//System.out.println(el.text());
				//}
				//tous le texte du doculent
				//System.out.println(doc.text());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}
	
	//Pour interface graphique avec URL
		public static ArrayList<LIVRE> text(String url) {
			ArrayList<LIVRE> livres= new ArrayList<LIVRE>();
			Document doc;
			try {
				doc = Jsoup.connect(url).get();
				Elements els = doc.select(".item");
				for(Element el : els) {
					ArrayList<String> arr=new ArrayList<String>();
					//1er contenu de h6
						String titre= el.select("h6").get(0).text();
					//2eme contenu de h6
						String auteur= el.select("h6").get(1).text();
						String ISBN= el.select("h6").get(2).text();
						String dispo=el.select("h6").get(3).text();
						String prix=el.select("h6").get(4).select("span").text();
						
					    arr.add(titre);
						arr.add(auteur);
						arr.add(ISBN);
						arr.add(dispo);
						arr.add(prix);
						/*arr.set(0, titre);
						arr.set(1, auteur);
						arr.set(2, ISBN);
						arr.set(3, dispo);
						arr.set(4, prix);-> ins*/
						LIVRE l1=Transformer.transformer(arr);
						l1.affiche();
						livres.add(l1);
					}
				return livres;
					//recuperer le texte de chaque h6
					//for(Element el : els) {
						//System.out.println(el.text());
					//}
					//tous le texte du doculent
					//System.out.println(doc.text());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} }
}

