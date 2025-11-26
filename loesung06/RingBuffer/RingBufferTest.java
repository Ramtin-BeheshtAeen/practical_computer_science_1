// Importiert assertEquals usw. sowie Test-Annotationen
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Diese Klasse definiert die Tests für die Klasse <Klasse ergänzen>.
 *
 * @author Surface
 */
public class RingBufferTest
{
    private RingBuffer ring_buffer_1;
    @BeforeEach
    public void setUp()
    {
        // Hier Anweisungen einfügen, die vor jedem Test ausgeführt werden
        ring_buffer_1 = new RingBuffer(3);
    }
    @Test
    public void testPush(){
        ring_buffer_1.push(10);
        assertEquals(1, ring_buffer_1.size());
        ring_buffer_1.push(-10);
        assertEquals(2, ring_buffer_1.size());
        ring_buffer_1.push(-12);
        assertEquals(3, ring_buffer_1.size());
        //testing when we go over the capicity size(it should overwrite oldest)
        ring_buffer_1.push(0);
        assertEquals(3, ring_buffer_1.size());
        ring_buffer_1.push(4);
        assertEquals(3, ring_buffer_1.size());
    }
    @Test
    public void testInitializer(){
        assertEquals(0, ring_buffer_1.size());
    }
    
    @Test
    //when no element is inside:
    public void testPeek1(){
        //testing when no element is inside:
        assertEquals(0, ring_buffer_1.peek());        
    }
    @Test
    //when 2 or 3 elemnts are inside:
    public void testPeek2(){
        //testing when one elemnt is inside:
        ring_buffer_1.push(16);
        assertEquals(16, ring_buffer_1.peek());
        //testing when two elemnt is inside(16, 10):
        ring_buffer_1.push(-10);
        assertEquals(16, ring_buffer_1.peek());
        //testing when three elemnt is inside(16, 10):
        ring_buffer_1.push(-12);
        assertEquals(16, ring_buffer_1.peek());
        
    }
    @Test
    //when 3 elemnts are inside(more than capicity so last one should get
    // deleted and get replaced):
    public void testPeek3(){
        //testing when one elemnt is inside:
        ring_buffer_1.push(16);
        assertEquals(16, ring_buffer_1.peek());
        //testing when two elemnt is inside(16, 10):
        ring_buffer_1.push(-10);
        assertEquals(16, ring_buffer_1.peek());
        //testing when three elemnt is inside(16, 10):
        ring_buffer_1.push(-12);
        assertEquals(16, ring_buffer_1.peek());
        //testing when three elemnt is inside(16, 10):
        ring_buffer_1.push(98);
        assertEquals(-10, ring_buffer_1.peek());
        
    }
    
}