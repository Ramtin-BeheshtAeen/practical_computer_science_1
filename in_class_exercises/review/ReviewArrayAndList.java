/**
 * Diese Klasse definiert <Zusammenfassung ergänzen>
 *
 * @author Surface
 */
import java.util.ArrayList;

class ReviewArrayAndList
{
    void javaBasic(){
        //******************Array**********************
        //init:
        int[][] array1 = new int[3][2];
        array1         = new int[][] {{10,20},{30,40},{50,60}};
        
        
        int[][] array2;
        array2 = new int[][] {{1,2},{3,4},{5,6}};
        
        //get:
        System.out.println("Array1");
        for(int i=0; i<array1.length; i++){
            for(int j=0; j<array1[i].length; j++){
                System.out.println(array1[i][j]);
            }
            System.out.println("\n");
        }
        
        //get with for each loop
        System.out.println("Array2");
        for(int row[] : array2){
            for(int number: row)
            {
                System.out.println(number);
            }
        }
        //post//put//delete
        
    }
    
    void javaDataStructure(){
    //******************List**********************
    //init
    System.out.println("Arraylist: \n");
    ArrayList<String> cars = new ArrayList<String>();
    
    //add
    cars.add("BMW");
    cars.add("Volvo");
    cars.add("Ford");
    System.out.println("cars:" + "\n" + cars);
    //add at specific point"
    cars.add(0, "Mazda");
    System.out.println("cars after adding at position 0:" + "\n" + cars);
    
    //get
    System.out.println("car at position2: "+ cars.get(2));
    
    //set
    cars.set(0, "Mercedes");
    System.out.println("car after set Mercedes instead of Mazda: " + cars);
    
    //remove
    cars.remove(3);
    System.out.println("car after removing Ford: " + cars);
    
    //size
    System.out.println("Size of the car list: " + cars.size());

    }
}