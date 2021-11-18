package Tests;

import DB.GestionBDD;

import static org.junit.jupiter.api.Assertions.*;

class GestionBDDTest {

    @org.junit.jupiter.api.Test
    void inserer() {
    }

    @org.junit.jupiter.api.Test
    void selectionner() {

        GestionBDD gestion = new GestionBDD();

        //assertEquals("[{\"IDPoste\":\"POS-000702\",\"IDImage\":\"IMG-000996\",\"IDCommu\":\"COM-000915\",\"IDProfil\":\"PRO-001998\",\"Url\":\"C:\\\\Users\\\\simme\\\\IdeaProjects\\\\PicturesAPI\\\\src\\\\Pictures\\\\The_binding_of_isaac.jpg\"},{\"IDPoste\":\"POS-000702\",\"IDImage\":\"IMG-008125\",\"IDCommu\":\"COM-000915\",\"IDProfil\":\"PRO-000198\",\"Url\":\"C:\\\\Users\\\\simme\\\\IdeaProjects\\\\PicturesAPI\\\\src\\\\Pictures\\\\The_binding_of_isaac.jpg\"},{\"IDPoste\":\"POS-002702\",\"IDImage\":\"IMG-015125\",\"IDCommu\":\"COM-010915\",\"IDProfil\":\"PRO-002568\",\"Url\":\"C:\\\\Users\\\\simme\\\\IdeaProjects\\\\PicturesAPI\\\\src\\\\Pictures\\\\The_binding_of_isaac.jpg\"}]", gestion.Selectionner());

    }

    @org.junit.jupiter.api.Test
    void supprimer() {

    }

    @org.junit.jupiter.api.Test
    void actualiser() {
    }
}