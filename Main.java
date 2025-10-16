
/**
 * 
 * Creating a lift object and handling all exception as general
 *
 * @author TheP-Room
 * @version Java 24.0.2
 */
public class Main
{
    public static void main(String[] args) {
        try {
            Lift lift = new Lift(3);
        }
        catch (Exception e) {
            System.out.println("\nEmergency Exit!\n");
        }
    }
}