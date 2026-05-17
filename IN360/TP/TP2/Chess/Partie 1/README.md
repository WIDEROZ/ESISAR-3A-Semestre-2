## 1 - Documentation
Le fonctionnement de chaque méthode est décrite avant sa déclaration. 
### Schéma
```mermaid
classDiagram
    %% Classe abstraite Pièces
    class Piece {
        <<Abstract>>
        protected String couleur
        protected int UNICODE
        
        public String getCouleur()
        public int getUNICODE()
        
        public abstract boolean bouger(int positionD, int positionF)
		public boolean prend(int positionD, int positionF)
		public abstract boolean pieces_entre(Plateau plateau, int positionD, int positionF)
    }

    %% Classes héritant de Piece
    class Pion {
    }

    class Cavalier {
    }

    class Fou {
    }

    class Tour {
    }

    class Reine {
    }

    class Roi {
    }

    %% Classe Plateau
    class Plateau {
        private Piece[][] plateau


		public static boolean index_inTab(int index)
		public static void getCase(int index)
		public Piece getPiece(int index)
		public static int stringToIndex(String Case)
		public boolean isTherePiece(int index)
		

		private void add(Piece piece, String position)
		private void bougerPieceSurPlateau(int index_D, int index_A)
		private void initTableau()
		private void afficherPlateau()
		private int getIndex_D(Scanner scanner, boolean tour_des_blancs)
		private int getIndex_A(Scanner scanner, boolean tour_des_blancs, int index_D)
		private void GM()
    }

    %% Relations d'héritage
    Piece <|-- Pion
    Piece <|-- Cavalier
    Piece <|-- Fou
    Piece <|-- Tour
    Piece <|-- Reine
    Piece <|-- Roi

    %% Relation entre Plateau et Piece
    Plateau *-- Piece
```

## 2 - Structure des fichiers
#### Avant compilation
```
.
├── build.xml
├── jeu
│   ├── Cavalier.java
│   ├── Fou.java
│   ├── Piece.java
│   ├── Pion.java
│   ├── Plateau.java
│   ├── Reine.java
│   ├── Roi.java
│   └── Tour.java
└── README.md
```

#### Après compilation
```
.
├── build.xml
├── class
│   └── jeu
│       ├── Cavalier.class
│       ├── Fou.class
│       ├── Piece.class
│       ├── Pion.class
│       ├── Plateau.class
│       ├── Reine.class
│       ├── Roi.class
│       └── Tour.class
├── jeu
│   ├── Cavalier.java
│   ├── Fou.java
│   ├── Piece.java
│   ├── Pion.java
│   ├── Plateau.java
│   ├── Reine.java
│   ├── Roi.java
│   └── Tour.java
└── README.md
```

## 3 - Compilation et lancement
### Lancer directement la partie d’Échecs
Par défaut ant compile et lance la partie d’Échecs
```bash
ant
```

### Compilation
Pour compiler le projet il suffit d'utiliser ant avec la cible : "Compiler"
```bash
ant Compile
```
Pour créer une archive jar, il suffit d'utiliser ant avec la cible : "jar" (Cette archive sera executable)
```bash
ant jar
```

### Lancer le programme
Pour lancer le programme  il suffit d'utiliser ant avec la cible : "Run"
```bash
ant Run
```
Pour le lancer sans l'aide de ant, la classe principale est **jeu.Plateau**


## 4 - Version des différents outils utilisés
#### ANT
Version utilisée : Apache Ant(TM) version 1.10.14

#### Gson
Version utilisée : gson-2.10.1

#### java
Version utilisée : 21.0.10
