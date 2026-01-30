import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.Reader;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.Arrays;
/**
 * Diese Klasse definiert <Zusammenfassung ergänzen>
 *
 * @author Surface
 */
class FileOpenning
{
    //**********************************
    //***** My Way For Openning ********
    //**********************************
    public void fileReader(){
        final List<String> lines;
        String filename = "./levels/1.lvl";
        try{
            final FileInputStream stream = new FileInputStream(filename);
            try{ 
                final Reader reader = new InputStreamReader(stream, "UTF-8");
                final BufferedReader buffer = new BufferedReader(reader);
                //****** Print first line: *********//
                System.out.println("print firstline \n" + buffer.readLine());
                System.out.println("\n print lines \n" + buffer.lines()); 
                //****** Output ********//
                /* 
                print lines 
                java.util.stream.ReferencePipeline$Head@4fe0e4ca
                */
                
                //****** Convert to String list *********//
                lines = buffer.lines().toList();
                System.out.println("\n print list line \n" + lines);
                //****** Output ********//
                /* 
                [    |   |, l-O-O-O W-,     |, O-O-O-z-O,     |, p-O-O W-W-,       |]
                */
            }
            catch (IOException e) {
                System.out.println("Fehler beim Lesen aus dem Stream");
                e.printStackTrace();
            }
        }
        catch(final IOException e){
            System.out.println("Fehler beim lesen");
        }
    }
    
    
    
    //**********************************
    //***** Better Way For Openning ****
    //**********************************
    //Export an String:
    public List<String> opener(){
        String fileName = "./levels/1.lvl";
        final List<String> lines;
        try(final BufferedReader buffer = new BufferedReader(new InputStreamReader ( new FileInputStream(fileName) ,"UTF-8"))){
            return buffer.lines().toList();
        }
        catch(final FileNotFoundException e){
            throw new IllegalArgumentException();
        }
        catch(final IOException e){}
            throw new IllegalArgumentException();
    }
    
    
    
    //**********************************
    //*** Simulate: ********************
    //field = new Field(lines.toArray(new String[lines.size()]));
    // Convert List --to--> array:
    //**********************************
    public void convertListToArray(){
        
        List<String> cars      = List.of("car1", "car2", "car3");
        String[]     carsArray = new String[cars.size()];
        carsArray              = cars.toArray(carsArray);
        
        System.out.println("cars Array: " + Arrays.toString(carsArray));
        System.out.println("cars Array List: " + cars);
        
        //******************* Profs Way: ***************************
        List<String> lines = List.of("    |   |"," l-O-O-O W-");
        System.out.println(Arrays.toString(lines.toArray(new String[lines.size()])));
        
    }
    
    //**********************************
    //*** IntStream ********************
    //**********************************
    public void sIntStream(){
        //Simple Uses
        System.out.println(IntStream.range(0,5));
        System.out.println(IntStream.rangeClosed(0,5));
        
        //Print Even numbers
        IntStream.iterate(0, n-> n < 20, n->n+2)
            .forEach(n -> System.out.println(n));
        
        // Comparison to For Loop:
        for(int n=0; n<20; n+=2){
            System.out.println(n);
        }
    }
    
    
    //**********************************
    //*** IntStream From The Game ******
    //**********************************
    public void sIntStreamGame(){
        final List<String> lines = opener();
        System.out.println(lines);
        
        IntStream.iterate(0, y -> y < lines.size(), y -> y+=2)
                .forEach(y -> IntStream.iterate(0, x -> x < lines.get(y).length(), x -> x+=2)
                .forEach(x -> {
                    final int index = "pPqQlLiIcCdDsSzZGbBWO ".indexOf(lines.get(y).charAt(x));
                    System.out.println(index);
                }));
                
    }
}