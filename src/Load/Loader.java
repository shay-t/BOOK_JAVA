package Load;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DA0.LIVRE;

public class Loader {
	//a.	Un constructeur par défaut, 
	//qui contient le code source pour
	//la connexion à la base de données
	public static Connection con;
	//methode static pour instancier directement://
	
	//1-Une méthode de connexion à la base de données
	public static void connecter() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Le Driver est OK");
			String url="jdbc:mysql://localhost:3306/livres";
			String user="root";
			String passwd="";
			con = DriverManager.getConnection(url , user, passwd);
			System.out.println("La connexion est etablie");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//-Une methode pour la deconnexion
	public static void deconnecter() {
		try {
			con.close();
			System.out.println("La connexion est ferme");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//c.	La méthode Select pour consulter
	//les données stockées dans la base de données.
	public static void selection_livres() {
		 ResultSet resultats=null;
		 String requete="SELECT * FROM livre";
		 try {
			Statement stmt = con.createStatement();
			resultats = stmt.executeQuery(requete);
			while(resultats.next()) {
				System.out.println("Le titre:"+resultats.getString("titre")+"\n"+"L'auteur:"+resultats.getString("auteur")+"\n"+"L'ISBN:"+resultats.getString("ISBN")+"\n"
						+"Disponibilité"+resultats.getString("dispo")+"\n"+"Prix:"+resultats.getString("prix"));
			}
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	}
	//Pour interface graphique
	public static ResultSet sel() {
		try {
		   Statement stmt =con.createStatement();
		   String requete="SELECT * FROM livre";
		   ResultSet rsl = stmt.executeQuery(requete);
		   return rsl;
		} catch (SQLException e) {
			return null;
		}
	}
	//b.	La méthode Insert pour insérer 
		//les données récupérer de la page (ligne par ligne)
	//inserer un livre
	public static void inserer_livre(LIVRE l1) {
			try {
				//INSERT INTO `livre`(`titre`, `auteur`, `ISBN`, `dispo`, `prix`) 
				//VALUES ([value-1],[value-2],[value-3],[value-4],[value-5])
				String requete=String.format("INSERT INTO livre (titre,auteur,ISBN,dispo,prix) VALUES ('%s','%s','%d','%f')",l1.getTitre(),l1.getAuteur(),l1.getISBN(),l1.getISBN(),l1.getPrix());
				Statement stmt= con.createStatement();
				int results = stmt.executeUpdate(requete);
				System.out.println("la requete est effectué");
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	//inserer les  livres
		public static void inserer_livres(ArrayList<LIVRE> livres) {
			for(LIVRE l1 : livres) {
				try {
					//pour eviter le probleme de %f
					String requete=String.format("INSERT INTO livre (titre,auteur,ISBN,dispo,prix) VALUES ('%s','%s','%s','%d',",l1.getTitre(),l1.getAuteur(),l1.getISBN(),l1.getDispo())+l1.getPrix()+")";
					//String requete=String.format("INSERT INTO livre (titre,auteur,ISBN,dispo,prix) VALUES ('%s','%s','%s','%d','%f')",l1.getTitre(),l1.getAuteur(),l1.getISBN(),l1.getDispo(),l1.getPrix());
					Statement stmt= con.createStatement();
					int results = stmt.executeUpdate(requete);
					System.out.println("la requete est effectué");
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
   
}
