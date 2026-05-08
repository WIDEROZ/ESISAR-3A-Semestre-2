package jeu;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


/*
    * JSON_parser :
    * Cette classe sert à retourner les caractéristiques de toutes les pièces dans le fichier Json
    * Ce qui nous intéresse ici sera la méthode qui permet de récupérer un tableau de Pièce_json
    * 
    * Attributs :
    * - private String filePath;
    * - private JsonObject jsonObject;
    * - private Piece_json[] tabPieces_Json; C'est ce tableau qui nous interesse dans cette classe
    * 
    * Getter :
    * - public Piece_json[] getTabPieces_Json();
    * 
    * 
*/
public class JSON_parser {
    // Chemin vers le fichier JSON
    private String filePath;

    // Contenu du fichier Json
    private String jsonString;

    // Objet JSON
    private JsonObject jsonObject;

    // Tableau de pièces provenant du fichier JSON
    private Piece_json[] tabPieces_Json;

    /*
     * Le constructeur servira ici à retourner les caractéristiques de toutes les pièces
     * dans le fichier Json dans le tableau : tabPieces_Json
    */
    public JSON_parser(String filePath){
        this.filePath = filePath; // "./config.json"
        
        
        try {
            jsonString = Files.readString(Paths.get(filePath));
        } catch (IOException e) {
            System.err.println("Erreur lors de la tentative de lecture du fichier: " + e.getMessage());
        }

        // Objet JSON
        jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
        
        // On récupère le tableau de pièces et on en créé un nouveau qui contiendra des pièces définies dans le fichier json
        JsonArray tabPieces = jsonObject.getAsJsonArray("Pieces");
        tabPieces_Json = new Piece_json[tabPieces.size()];
        JsonObject piece_json;


        // Définition des variables qu'on donnera au constructeur de Piece_json
        String nom;
        int UNICODE;
        String couleur;
        String case_depart;

        JsonArray mouvements_json_array;
        int[] mouvements;

        // On récupère les pièces dans le fichier JSON pour les mettres dans le tableau : tabPieces_Json
        for (int i = 0 ; i < tabPieces.size(); i++) {
            // Pour chaque pièce on récupère leurs attributs
            piece_json = tabPieces.get(i).getAsJsonObject();

            nom = piece_json.get("Nom").getAsString();
            UNICODE = piece_json.get("UNICODE").getAsInt();
            couleur = piece_json.get("Couleur").getAsString();
            case_depart = piece_json.get("Départ").getAsString();

            // On récupère le tableau : Mouvements
            mouvements_json_array = piece_json.getAsJsonArray("Mouvements");
            mouvements = new int[mouvements_json_array.size()];
            for(int j = 0; j < mouvements_json_array.size(); j++){
                mouvements[j] = mouvements_json_array.get(j).getAsInt();
            }


            tabPieces_Json[i] = new Piece_json(nom, UNICODE, couleur, case_depart, mouvements);
        }
        

        
        
    }


    public Piece_json[] getTabPieces_Json() {
        return tabPieces_Json;
    }

}
