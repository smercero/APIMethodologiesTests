package Controllers;

import DB.GestionBDD;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// Voir classe ListerImagesController pour code détaillé
public class PutImagesController extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String Url = req.getParameter("Url");
        String IDImage = req.getParameter("IDImage");
        String IDProfil = req.getParameter("IDProfil");
        String IDPoste = req.getParameter("IDPoste");
        String IDCommu = req.getParameter("IDCommu");

        GestionBDD base = new GestionBDD();

        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(base.Inserer(Url, IDImage, IDProfil, IDPoste, IDCommu));
    }
}