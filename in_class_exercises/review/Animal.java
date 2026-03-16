
/**
 * Dies ist die Hauptklasse eines Spiels. Sie enthält die Hauptmethode, die zum
 * Starten des Spiels aufgerufen werden muss.
 *
 * @author Surface
 */
abstract class Animal {
    public void makeSound(){
        System.out.println("Animal is making a sound");
    }

}

class Pig extends Animal {
    @Override
    public void makeSound(){
        System.out.println("Pig sats wee wee");
    }

}

class Dog extends Animal{
    @Override
    public void makeSound(){
        System.out.println("The dog says: bow wow");
  }
}



