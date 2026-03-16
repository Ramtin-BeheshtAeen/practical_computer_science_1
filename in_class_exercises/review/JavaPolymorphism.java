class JavaPolymorphism 
{
    public static void main()
    {
        Animal myAnimal = new Animal();  // Create a Animal object
        Animal myPig = new Pig();  // Create a Pig object
        Animal myDog = new Dog();  // Create a Dog object
        
        myAnimal.makeSound();
        myPig.makeSound();
        myDog.makeSound();
        
    }
}