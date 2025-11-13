/**
 * Diese Klasse definiert <Zusammenfassung ergänzen>
 *
 * @author Surface
 */
class Mathe
{
    static int fakultät(int n){
        if (n == 0) return 1;
        else{
            int f = fakultät(n - 1);
            return n * f;
        }
    }
}