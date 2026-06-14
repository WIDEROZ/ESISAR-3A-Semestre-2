package fr.esisar.geometrie;

import java.util.ArrayList;


import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.control.*;
import javafx.scene.input.*;

import javafx.scene.layout.*;

import javafx.geometry.Pos;

import javafx.stage.Stage;

import javafx.event.*;






public class AfficheCercle extends Application {

    ArrayList<Cercle> liste_cercle = new ArrayList<Cercle>();
    ArrayList<Circle> liste_circle = new ArrayList<Circle>();

    Cercle cercle_selected = null;
    Circle circle_selected = null;

    /* Gestion des objets geometriques */

    private void create_forme(String forme) throws Exception{
        if (forme.equalsIgnoreCase("cercle")) {
            Cercle cercle = new Cercle(50, new Point("M", 250, 250), "black");
            liste_cercle.add(cercle);
            liste_circle.add(cercle_to_circle(cercle));
        }
        else{
            throw new Exception("La forme n'est pas une figure connue");
        }
    }

    private Circle cercle_to_circle(Cercle cercle){
        Point centre = cercle.getCentre();
        Circle circle = new Circle(centre.getAbscisse(), centre.getOrdonnee(), cercle.getRayon(), Color.web("transparent"));
        circle.setStroke(Color.web(cercle.getCouleur()));
        circle.setStrokeWidth(10);
        return circle;
    }

    private void modify_cercle_to_circle(Cercle cercle, Circle circle){
        Point centre = cercle.getCentre();
        circle.setStroke(Color.web(cercle.getCouleur()));
        circle.setStrokeWidth(10);  
    }

    private Cercle find_by_center(double x, double y){
        for (Cercle cercle : liste_cercle) {
            if(cercle.getCentre().getAbscisse() == x && cercle.getCentre().getOrdonnee() == y){
                return cercle;
            }
        }
        return null;
    }


    /* Relatif a la fenêtre */

    private Pane Pane_creation(){
        Pane canvas = new Pane();
        canvas.setStyle("-fx-background-color: white;");
        canvas.setPrefSize(500,500);
        return canvas;
    }

    private VBox VBox_Button_creation(Button button_élargir, Button button_rétrécir, Button button_color, Button button_creation, TextField color){
        VBox vbox_buttons = new VBox(10);
        vbox_buttons.setStyle("-fx-background-color: purple;");
        vbox_buttons.setAlignment(Pos.TOP_CENTER);

        VBox vbox_buttons_creration = new VBox(10);
        vbox_buttons_creration.setAlignment(Pos.TOP_CENTER);
        vbox_buttons_creration.getChildren().addAll(button_creation);

        VBox vbox_buttons_resize = new VBox(10);
        vbox_buttons_resize.setAlignment(Pos.CENTER);
        vbox_buttons_resize.getChildren().addAll(button_élargir, button_rétrécir);
        
        VBox vbox_buttons_color = new VBox(10);
        vbox_buttons_color.setAlignment(Pos.BOTTOM_CENTER);
        vbox_buttons_color.getChildren().addAll(color, button_color);

        vbox_buttons.getChildren().addAll(vbox_buttons_creration, vbox_buttons_resize, vbox_buttons_color);

        return vbox_buttons;
    }

    private VBox VBox_circle_pane_creation(Pane canvas){
        VBox vbox_circle = new VBox(10);
        vbox_circle.setStyle("-fx-background-color: white;");

        vbox_circle.getChildren().addAll(canvas);

        return vbox_circle;
    }

    private HBox HBox_creation(){
        HBox root = new HBox(20); 
        root.setStyle("-fx-background-color: white;");
        root.setPrefSize(1000, 540);
        root.setAlignment(Pos.TOP_LEFT);


        return root;
    }

    private void display_forme(Pane canvas){
        canvas.getChildren().addAll(liste_circle.get(liste_circle.size()-1));
    }


    /* Gestion des interractions avec l'utilisateur */

    private void circle_selection(Pane canvas){

        EventHandler<MouseEvent> mouse_click_handler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (isClickOnACircle(event.getX(), event.getY()) != null) {
                    cercle_selected = isClickOnACircle(event.getX(), event.getY());
                    circle_selected = liste_circle.get(liste_cercle.indexOf(cercle_selected));
                }
            }
        };

        canvas.setOnMouseClicked(mouse_click_handler);
    }

    private void set_color(Button button_color, TextField color){
        button_color.setOnAction(actionEvent ->  {
            System.out.println("Changer de couleur");
            cercle_selected.setCouleur(color.getText());
            System.out.println(color.getText());
            modify_cercle_to_circle(cercle_selected, circle_selected);
        });
    }

    private void Button_gestion(Pane canvas, Button button_élargir, Button button_rétrécir, Button button_creation){
        button_élargir.setOnAction(actionEvent ->  {
            System.out.println("Elargir le cercle");
            cercle_selected.setRayon(cercle_selected.getRayon() + 5);
            circle_selected.setRadius(cercle_selected.getRayon());
        });
        button_rétrécir.setOnAction(actionEvent ->  {
            System.out.println("Rétrécir le cercle");
            cercle_selected.setRayon(cercle_selected.getRayon() - 5);
            circle_selected.setRadius(cercle_selected.getRayon());
        });

        button_creation.setOnAction(actionEvent ->  {
            try {
                create_forme("cercle");
                display_forme(canvas);
                System.out.println("Créer un cercle");
            }
            catch (Exception e) {
                System.err.println("La forme que l'on veut créer n'existe pas");
            }
            
        });

        

    }

    private void drag(Pane canvas, Button button_élargir, Button button_rétrécir){

        final boolean[] isClickOnCircle = {false};
        final double[] lastScene = {0, 0};


        EventHandler<MouseEvent> mouse_handler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                
                if(isClickOnCircle[0]){
                    double currentSceneX = event.getSceneX();
                    double currentSceneY = event.getSceneY();

                    double deltaX = currentSceneX - lastScene[0];
                    double deltaY = currentSceneY - lastScene[1];

                    lastScene[0] = currentSceneX;
                    lastScene[1] = currentSceneY;
                    
                    cercle_selected.deplacer(deltaX, deltaY);

                    circle_selected.setCenterX(cercle_selected.getCentre().getAbscisse());
                    circle_selected.setCenterY(cercle_selected.getCentre().getOrdonnee());



                    System.out.println(
                    "(x: "       + event.getX()      + ", y: "       + event.getY()       + ") -- " +
                    "(sceneX: "  + event.getSceneX() + ", sceneY: "  + event.getSceneY()  + ") -- " +
                    "(screenX: " + event.getScreenX()+ ", screenY: " + event.getScreenY() + ")");
                }
        
            
            }
        };

        EventHandler<MouseEvent> mouse_click_handler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double currentSceneX = event.getSceneX();
                double currentSceneY = event.getSceneY();

                isClickOnCircle[0] = isClickOnSelectedCircle(event.getX(), event.getY());
                lastScene[0] = currentSceneX;
                lastScene[1] = currentSceneY;

                System.out.println(isClickOnCircle[0]);
                
            }
        };


        canvas.setOnMouseDragged(mouse_handler);
        canvas.setOnMousePressed(mouse_click_handler);

    }

    private Cercle isClickOnACircle(double X, double Y){
        double rayon;
        double x;
        double y;
        for (Cercle cercle : liste_cercle) {
            rayon = cercle.getRayon();
            x = cercle.getCentre().getAbscisse();
            y = cercle.getCentre().getOrdonnee();
            

            if ((x-rayon) <= X && X <= (x+rayon)) {
                if ((y-rayon) <= Y && Y <= (y+rayon)) {
                    return cercle;
                }
            }
            
        }
        return null;
    }

    private boolean isClickOnSelectedCircle(double X, double Y){
        double rayon;
        double x;
        double y;
        
        rayon = cercle_selected.getRayon();
        x = cercle_selected.getCentre().getAbscisse();
        y = cercle_selected.getCentre().getOrdonnee();
        

        if ((x-rayon) <= X && X <= (x+rayon)) {
            if ((y-rayon) <= Y && Y <= (y+rayon)) {
                return true;
            }
        }
            
        return false;
    }

    @Override // Réécrit la méthode start de la calsse Application
    public void start(Stage primaryStage) {

        /* ---------- Création de l'interface graphique ---------- */
        // Création d'un "pane" contenant les cercles
        Pane canvas = Pane_creation();



        // Création du premier cercle
        try {
            create_forme("cercle");
            display_forme(canvas);
            cercle_selected = liste_cercle.get(0);
            circle_selected = liste_circle.get(0);
        }
        catch (Exception e) {
            System.err.println("La forme que l'on veut créer n'existe pas");
        }



        // Création des boutons
        Button button_élargir = new Button("Elargir le cercle");
        Button button_rétrécir = new Button("Rétrécir le cercle");
        Button button_color = new Button("Valider");
        Button button_creation = new Button("Créer un cercle");


        // Création de l'entrée de la couleur
        TextField color = new TextField();
        color.setId("textField");
        color.setPromptText("Insérer votre couleur");


        // Création d'une HBox pour avoir une délimitation entre les boutons et le dessin
        HBox root = HBox_creation();


        // Création d'un VBox pour organiser les boutons verticalement
        VBox vbox_buttons = VBox_Button_creation(button_creation, button_élargir, button_rétrécir, button_color, color);
 

        // Création d'une VBox pour le canvas du cercle
        VBox vbox_circle = VBox_circle_pane_creation(canvas);


        // Ajout des VBOX à la HBOX
        root.getChildren().addAll(vbox_buttons, vbox_circle);



        /* ---------- Gestion des évènements ---------- */


        // Partie 1 sans Handler
        Button_gestion(canvas, button_élargir, button_rétrécir, button_creation);


        // Partie 2 avec handler
        drag(canvas, button_élargir, button_rétrécir);

        circle_selection(canvas);

        set_color(button_color, color);







        // Création d'une "scene" et placement sur la "stage"
        Scene scene = new Scene(root);

        primaryStage.setTitle("AZERTYUIOP");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}