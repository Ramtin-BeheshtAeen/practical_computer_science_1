/**
 * Die Klasse demonstriert Probleme beim gleichzeitigen Zugriff
 * mehrerer Threads auf dieselben Daten.
 */
class Count extends Thread
{
    private static Counter counter;

    static void count()
    {
        counter = new Counter();
        for (int i = 0; i < 10; ++i) {
            new Count().start();
        }
    }

    public void run()
    {
        for (int i = 0; i < 10000; ++i) {
            counter.inc();
        }
        System.out.println(counter.get());
    }
}
