/*
 * This code is pararell but the values are not connected correctly 
 * and the sequnce is randomly
 * 
 * 
 * _bestimmter teil von code muss von einem
 * Thread gleichzeitig ausgeführt werden_
 */

class MyCount extends Thread 
{
    private static MyCounter counter;
    
    static void count()
    {
        counter = new MyCounter();
        for (int i=0; i<10; ++i){
            new MyCount().start();
        }
    }
    
    public void run(){
        for(int i=0; i<100000; ++i){
            counter.increase();
        }
        System.out.println(counter.get());
    }

}