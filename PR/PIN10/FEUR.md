# Partie 1
## Initialisation
#### Compilation et execution du code
- $-cp$ : sert a identifier dans quel fichier sont les classes
```bash
java –cp classes fr.esisar.helloworld.HelloWorld
```
Si l'on écrit pas ce $cp$, la commande ne trouve pas la classe Hello World. 
Puis si l'on écrit : 
```bash
java –cp classes HelloWorld
```
Avec ou sans cp, la commande ne trouve pas le chemin. 

#### Analyse de votre travail et éléments à retenir
###### 1.
Vérifier si le chemin renseigné pour exécuter le fichier .class est bon.

###### 2.
```java
public static void main(String[] args){
```

###### 3.
C'est le byte code


# Partie 2
## Point
#### Question
###### 1.
Ce chiffre correspond à l'adresse en mémoire de l'objet (elle ne change pas)

###### 2.
Il n'initialise pas les attributs
super est ici si jamais il existe une class parente

#### Questions
###### 1.
On accède avec abscisse et ordonnee car les arguments des méthodes ne sont pas égaux aux attributs. 

###### 2.
Le mot clé est utile dans les cas ou il existe une variable qui puisse interférer avec un attribut.


## Cercle
#### Question
Les deux fonctionnent mais le premier assure un accès facile au point.

