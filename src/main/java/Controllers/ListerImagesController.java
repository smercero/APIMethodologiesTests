package Controllers;

import DB.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

// Servlet pour la méthode get retournant un Json parsé avec la ligne de la table Image corespondant à l'id souhaité
// Route et Url détaillés dans le web.xml
public class ListerImagesController extends HttpServlet {

    // Création d'une instance de la classe executant les méthodes de requetage
    GestionBDD base = new GestionBDD();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // Récupération du paramètre de l'id souahité dans le header
        String IDimage = req.getHeader("IDimage");

        // Encodage en UTF-8 pour que les accents des messages de succès ou d'erreur issus de Postgre soient respectés
        resp.setCharacterEncoding("UTF-8");
        // Retour du Json ou du message d'erreur Postgre dans le body de la reponse
        resp.getWriter().write(base.Selectionner(IDimage));

    }
}
