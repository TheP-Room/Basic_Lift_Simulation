
/**
 * 
 * Class that performs the function of lift i.e.
 * showing prompt, getting input, and moving, again
 * all fields and methods are private just constructor
 * need to be called to start action
 *
 * @author TheP-Room
 * @version Java 24.0.2
 */

import java.util.Scanner;

public class Lift
{
    private final Scanner sc = new Scanner(System.in);
    private Level levels;
    private int currentLevel;
    private int destination;
    private int maxLevel;
    private boolean isForward;
    private boolean reachedDest;
    
    public Lift(int callFromLevel) {
        currentLevel = callFromLevel;
        levels = new Level(callFromLevel+3);
        maxLevel = callFromLevel+2;
        System.out.println("--- WELCOME ---");
        enter();
    }
    
    private void enter() {
        System.out.println("Current Floor : "+
            parseLevelName(currentLevel));
        askLevel();
        setRoute();
        move();
    }
    
    private void move() {
        if (reachedDest)
            exit();
        else {
            System.out.println("Moving");
            levels.printFromTo(currentLevel, destination, isForward);
            exit();
        }
    }
    
    private void exit() {
        System.out.println("Destination Reached!\n");
        reachedDest = false;
        currentLevel = destination;
        enter();
    }
    
    private void setRoute() {
        if (currentLevel == destination) {
            reachedDest = true;
            return;
        }
        isForward = (currentLevel < destination) ? true : false;
    }
    
    private void askLevel() {
        System.out.print("Your Destination (");
        levels.print();
        System.out.print(") : ");
        destination = sc.nextInt();
        if (destination < 0 || destination > maxLevel)
            throw new IllegalArgumentException();
    }
    
    private String parseLevelName(int level) {
        switch (level) {
            case 0:
                return "Ground Floor";
            case 1:
                return "First Floor";
            case 2:
                return "Second Floor";
            case 3:
                return "Third Floor";
            case 4:
                return "Fourth Floor";
            case 5:
                return "Fifth Floor";
            case 6:
                return "Sixth Floor";
            case 7:
                return "Seventh Floor";
            case 8:
                return "Eighth Floor";
            case 9:
                return "Ninth Floor";
            case 10:
                return "Tenth Floor";
            default:
                return "Unknown Floor";
        }
    }
}