class MyCounter{
    private int value  = 0;
    /*   estimmter teil von code muss von einem
      Thread gleichzeitig ausgeführt werden
    */
    synchronized void increase(){
    //void increase(){
        value = value + 1;
    }
    //or:
    /*
    void increase(){
        synchronized(this){
        value = value + 1;
        }
        
    }
    */
    //int get(){
    synchronized int get(){
        return value;
    }
}