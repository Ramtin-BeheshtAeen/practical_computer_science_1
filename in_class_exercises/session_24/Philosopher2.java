/** Zweiter Implementierungsversuch der speisenden Philosophen. */
class Philosopher2 extends Thread
{
    private static final Object table = new Object();

    private final String name;
    private final Object left;
    private final Object right;

    Philosopher2(final String name, final Object left, final Object right)
    {
        this.name = name;
        this.left = left;
        this.right = right;
        start();
    }

    public void run()
    {
        try {
            while (!interrupted()) {
                synchronized (table) {
                    synchronized (left) {
                        System.out.println(name + " hat linke Gabel!");
                        synchronized (right) {
                            System.out.println(name + " hat rechte Gabel und kann essen!");
                            sleep((int) (Math.random() * 100));
                            System.out.println(name + " isst nicht mehr!");
                        }
                    }
                }
                sleep((int) (Math.random() * 100));
            }
        }
        catch (final InterruptedException e) {
        }
    }

    static void dinner()
    {
        final Object[] forks = {new Object(), new Object(), new Object(), new Object(), new Object()};

        for (int i = 0; i < forks.length; ++i) {
            new Philosopher2("Philosoph " + (i + 1), forks[i], forks[(i + 1) % forks.length]);
        }
    }
}
