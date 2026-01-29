import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;

class my_stream 
{
    //What does stream.read() output?
    //It returns an int, with these meanings:
    //0–255 → one byte of data
    //This is the numeric value of the byte that was read
    //-1 → end of stream (no more data)
    //So it does NOT return a character or a String directly.
    static int length(final String filename) 
                    throws FileNotFoundException, IOException
    {
        final FileInputStream stream = new FileInputStream(filename);
        int bytes = 0;
        while(stream.read()!= -1){
            //System.out.println(stream.read());  0-255 represent bytes
            bytes++;    
        }
        return bytes;
    }
    
    static void more(final String filename) 
                    throws FileNotFoundException, IOException
    {
        final FileInputStream stream = new FileInputStream(filename);
        final Reader          reader = new InputStreamReader(stream, "UTF-8");
        final BufferedReader  buffer = new BufferedReader(reader);
            
        String line;
        int    count = 1;
        
        while((line = buffer.readLine()) != null) {
            System.out.println(count + ":\t" + line);
            if(++count % 20 == 1){
                System.in.read(); // STOP HERE
                System.out.print("\f"); //Historically meant “clear page”
            }
        }
    
    }   
    
    static int length_with_error_handeling(final String filename) 
    {
        FileInputStream stream2 = null;
        try{
            stream2    = new FileInputStream(filename);
            int bytes = 0;
            while(stream2.read() != -1){
                ++bytes;
            }
            return bytes;
        }
        catch(final IOException e){
            return -1;
        }
        finally{
            if(stream2 != null) {
                try {
                    stream2.close();
                }
                catch (final IOException e) {
                }
            }
        }
    }
    
    // try with resourses:
    static int lenth_with_modern_try(final String Filename){
        try(final FileStreamInput = new FileInputStream(filename){
            
    }
}