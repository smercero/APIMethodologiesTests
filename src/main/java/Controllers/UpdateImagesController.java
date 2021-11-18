package Controllers;

import DB.GestionBDD;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

// Voir classe ListerImagesController pour code détaillé
public class UpdateImagesController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        String Url = req.getParameter("Url");
        String IDImage = req.getParameter("IDImage");
        String NewIDImage = req.getParameter("NewIDImage");
        String IDProfil = req.getParameter("IDProfil");
        String IDPoste = req.getParameter("IDPoste");
        String IDCommu = req.getParameter("IDCommu");

        GestionBDD base = new GestionBDD();
        response.setCharacterEncoding("UTF-8");

        response.getWriter().write(base.Actualiser(Url, IDImage, NewIDImage, IDProfil, IDPoste, IDCommu));

    }
}
