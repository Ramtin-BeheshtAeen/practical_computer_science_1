import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/** Vierter Implementierungsversuch der speisenden Philosophen. */
class Philosopher4 extends Thread
{
    private final String name;
    private final Lock left;
    private final Lock right;

    Philosopher4(final String name, final Lock left, final Lock right)
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
                if (left.tryLock()) {
                    System.out.println(name + " hat linke Gabel!");
                    if (right.tryLock()) {
                        System.out.println(name + " hat rechte Gabel und kann essen!");
                        sleep((int) (Math.random() * 100));
                        System.out.println(name + " isst nicht mehr!");
                        right.unlock();
                    }
                    left.unlock();
                }
                sleep((int) (Math.random() * 100));
            }
        }
        catch (final InterruptedException e) {
        }
    }

    static void dinner()
    {
        final Lock[] forks = {new ReentrantLock(), new ReentrantLock(), new ReentrantLock(), new ReentrantLock(), new ReentrantLock()};

        for (int i = 0; i < forks.length; ++i) {
            new Philosopher4("Philosoph " + (i + 1), forks[i], forks[(i + 1) % forks.length]);
        }
    }
}
