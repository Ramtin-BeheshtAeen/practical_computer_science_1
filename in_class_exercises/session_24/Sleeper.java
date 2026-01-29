class Sleeper extends Thread
{
    Sleeper()
    {
        start();
    }

    public void run()
    {   // With Intrupt:
        int counter = 0;
        try {
            while (!isInterrupted()) {
                System.out.println(++counter);
                sleep(5000);
            }
        }
        catch (final InterruptedException e) {
            System.out.println("Unterbrochen");
        }
        System.out.println("Beendet");
    }
}