
/**
 * Dies ist die Hauptklasse eines Spiels. Sie enthält die Hauptmethode, die zum
 * Starten des Spiels aufgerufen werden muss.
 *
 * @author Surface
 */
abstract class AnimalWithSuperClass {
    public void makeSound(){
        System.out.println("Animal is making a sound");
    }

}

class Pig extends AnimalWithSuperClass {
    @Override
    public void makeSound(){
        super.makeSound();
        System.out.println("Pig says wee wee");
    }

}




