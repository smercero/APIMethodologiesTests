package DB;

import java.sql.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

// Classe executant les methodes s'appuyant sur la librairie PostgreSql pour le requetage
public class GestionBDD {

    // Paramètres pour la conenxion à la base de données
    static String NomBDD = "BDDPicturesAPI";
    static String Port = "5432";
    static String UrlServeur = "localhost";

    static String Utilisateur = "postgres";
    static String Mdp = "azerty";

    public String Inserer(String Url, String IDImage, String IDProfil, String IDPoste, String IDCommu){

        Connection c = null;
        Statement stmt = null;

        // Retour de la méthode Inserer(...), contiendra le message de succès ou l'erreur remontée par Postgre
        String MessageRetour = "";

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://" + UrlServeur + ":" + Port + "/" + NomBDD + "",
                            Utilisateur, Mdp);
            c.setAutoCommit(false);

            // En cas de succès d'ouverture de la connexion avec la bdd par le driver
            System.out.println("Connexion ouverte avec la base de données : " + NomBDD + "");

            stmt = c.createStatement();
            // Construction de la requête avec syntaxe du langage repsectée ("NomColonne" et 'Valeur')
            String sql = "INSERT INTO \"IMAGES\" (\"Url\",\"IDImage\",\"IDProfil\",\"IDPoste\",\"IDCommu\") "
                    + "VALUES ('" + Url + "', " +
                    "'" + IDImage + "', '" + IDProfil + "', '" + IDPoste + "', '" + IDCommu + "' );";

            // Execution de la mise à jour, commit et fermeture de la connexion avec la BDD
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();

        } catch (Exception e) {
            // Si Excption lors du traitement, exit de la méthode avec détail de l'erreur en paramètre de sortie de Inserer(...)
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            MessageRetour = "" + ( e.getClass().getName()+": "+ e.getMessage() ) + "";
            return MessageRetour;
        }

        if(MessageRetour.equals("")){
            // Message de succès en paramètre de sortie
            MessageRetour = "Ligne(s) insérée(s) avec succès";
        }
        System.out.println("Ligne(s) insérée(s) avec succès");
        return MessageRetour;
    }

    public String Selectionner(String IDimage){

        String IDpicture = IDimage;
        String MessageRetour = "";

        if(IDimage.equals("")){
            IDpicture = "";
        }else{
            IDpicture = " where \"IDImage\" = \'" + IDimage + "\'";
        }

        Connection c = null;
        Statement stmt = null;

        JSONArray JsonImages = new JSONArray();

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://" + UrlServeur + ":" + Port + "/" + NomBDD + "",
                            Utilisateur, Mdp);
            c.setAutoCommit(false);
            System.out.println("Connexion ouverte avec la base de données : " + NomBDD + "");

            stmt = c.createStatement();
            System.out.println("SELECT * FROM \"IMAGES\"" + IDpicture +";");
            ResultSet rs = stmt.executeQuery( "SELECT * FROM \"IMAGES\"" + IDpicture +";");

            while ( rs.next() ) {
                String  Url = rs.getString("Url");
                String  IDImage = rs.getString("IDImage");
                String  IDProfil = rs.getString("IDProfil");
                String  IDPoste = rs.getString("IDPoste");
                String  IDCommu = rs.getString("IDCommu");

                JSONObject JsonImage = new JSONObject();
                JsonImage.put("IDImage", IDImage);
                JsonImage.put("IDProfil", IDProfil);
                JsonImage.put("IDPoste", IDPoste);
                JsonImage.put("IDCommu", IDCommu);
                JsonImage.put("Url", Url);

                JsonImages.add(JsonImage);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            MessageRetour = "" + ( e.getClass().getName()+": "+ e.getMessage() ) + "";
            return MessageRetour;
        }

        System.out.println("Operation de lecture réussie");
        return JsonImages.toString();
    }

    public String Supprimer(String IDImage){

        String MessageRetour = "";

        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://" + UrlServeur + ":" + Port + "/" + NomBDD + "",
                            Utilisateur, Mdp);
            c.setAutoCommit(false);
            System.out.println("Connexion ouverte avec la base de données : " + NomBDD + "");

            stmt = c.createStatement();
            String sql = "DELETE from \"IMAGES\" where \"IDImage\" = \'" + IDImage + "\';";
            stmt.executeUpdate(sql);
            c.commit();

            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            MessageRetour = "" + ( e.getClass().getName()+": "+ e.getMessage() ) + "";
            return MessageRetour;
        }
        if (MessageRetour.equals("")){
            MessageRetour = "Ligne(s) supprimée(s) avec succès";
        }

        System.out.println("Ligne(s) supprimée(s) avec succès");

        return MessageRetour;
    }

    public String Actualiser(String Url, String IDImage, String NewIDImage, String IDProfil, String IDPoste, String IDCommu){

        String MessageRetour = "";
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://" + UrlServeur + ":" + Port + "/" + NomBDD + "",
                            Utilisateur, Mdp);
            c.setAutoCommit(false);
            System.out.println("Connexion ouverte avec la base de données : " + NomBDD + "");

            stmt = c.createStatement();
            String reqq = ("UPDATE \"IMAGES\" set \"Url\"  = \'" + Url + "\', \"IDImage\" = \'"+ NewIDImage + "\', \"IDProfil\" = \'"+ IDProfil + "\', \"IDPoste\" = \'"+ IDPoste + "\', \"IDCommu\" = \'"+ IDCommu + "\' where \"IDImage\" = \'" + IDImage + "\';");
            String sql = reqq;
            stmt.executeUpdate(sql);
            c.commit();

            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            MessageRetour = "" + ( e.getClass().getName()+": "+ e.getMessage() ) + "";
            return MessageRetour;
        }

        MessageRetour = "Mise à jour effectuée avec succès";


        System.out.println("Mise à jour effectuée avec succès");

        return MessageRetour;
    }

}
