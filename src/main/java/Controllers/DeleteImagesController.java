package Controllers;

import DB.GestionBDD;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Voir classe ListerImagesController pour code détaillé
public class DeleteImagesController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String IDImage = req.getParameter("IDImage");
        GestionBDD base = new GestionBDD();

        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(base.Supprimer(IDImage));

    }
}