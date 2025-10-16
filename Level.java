
/**
 * 
 * It is a custom made doubly linked list class to be
 * used in moving from one level to another, contains
 * mostly private fields and methods just print methods
 * are public
 *
 * @author TheP-Room
 * @version Java 24.0.2
 */
public class Level extends Thread
{
    private class Node {
        private int level;
        private Node next;
        private Node previous;
        
        public Node(int level) {
            this.level = level;
        }
    }
    
    private Node head;
    private Node tail;
    
    public Level(int totalLevels) {
        for (int i = 0; i<totalLevels; i++)
            addLevel(i);
    }
    
    private void addLevel(int level) {
        Node node = new Node(level);
        if (head == null)
            head = tail = node;
        else {
            node.previous = tail;
            tail.next = node;
            tail = node;
        }
    }
    
    public void print() {
        var current = head;
        while (current != null) {
            System.out.print((current.next == null) ? current.level : 
                current.level+", ");
            current = current.next;
        }
    }
    
    @Override
    public void run() {}

    public void printFromTo(int initial, int end, boolean isForward) {
        boolean isInitialSmaller = (initial <= end) ? true : false;
        var current = (isForward) ? head : tail;
        while (current != null) {
            if (isInitialSmaller) {
                if (current.level >= initial && current.level <= end)
                    System.out.print((current.level == end) ? 
                        current.level : current.level+"-->");
            }
            else {
                if (current.level >= end && current.level <= initial)
                    System.out.print((current.level == initial) ? 
                        current.level : "-->"+current.level);
            }
            try {
                this.sleep(500);
            }
            catch (Exception e) {
                return;
            }
            finally {
                current = (isForward) ? current.next : current.previous;
                continue;
            }
        }
        System.out.println();
    }
}