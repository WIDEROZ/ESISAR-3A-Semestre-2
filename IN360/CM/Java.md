```java
import java.util.ArrayList;
```

#### for
```java
for(Type element : collection){
	// Action
}
```

#### while
```java
while (i <= n){
	// Action
}
```

#### Comparateurs
`==` : même endroit en mémoire
`equals` : Compare une chaîne de char

```java
input.equals("Feur");
```

#### Itérateurs
```java
Iterator <Type> it = obj.iterator();
boolean it.hasNext();
Type it.next();
void it.remove();
```

#### static
On peut appeler une variable/méthode statique a partir du nom de la classe (ie on a pas besoin d'instance) : 
```java
Math.pi
```

#### final
```java
final int MAX=100;
```
ne peuvent pas être créés dans les méthodes et sont des variables constantes

# Héritage et Polymorphisme
#### extends
Pour faire hériter une classe utiliser : 
```java
public class Voiture extends Vehicule{
...
}
```

#### super
Permet d'invoquer le constructeur de la superclasse sur une classe enfant. 
