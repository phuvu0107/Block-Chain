import java.util.NoSuchElementException;

/**
 * Class to test List.java
 * @author Truong Phu Vu
 * @author Tan Dung Dong
 */
public class ListTest {
    public static void main(String[] args) {
        List<Integer> L = new List<>();
        System.out.println("/****TEST TOSTRING()****/");
        System.out.println("Should print nothing (an empty list): " + L);  
        System.out.println("Should print nothing (an empty list): " + L);
        
        System.out.println("/****Testing addFirst****/");       
        L.addFirst(2); //Testing Edge case: length == 0
        System.out.println("Should print 2: " + L);
        L.addFirst(1); //Testing General case: length >= 1
        System.out.println("Should print 1 2: " + "\n"  + L);
        
        System.out.println("/****Testing addLast****/");  
        L.addLast(3);
        System.out.println("Should print 1 2 3: " + "\n" + L);
        L.addLast(4);
        System.out.println("Should print 1 2 3 4: " + "\n" + L);
        
        System.out.println("**Testing removeFirst**");
        L.removeFirst(); //Testing General case: length >1
        System.out.println("Should print 2 3 4: " + "\n" + L);
        L.removeFirst(); //Testing Edge case: length == 1
        L.removeFirst();
        L.removeFirst();
        System.out.println("Should print an empty List: " + L);
        System.out.println("Should print an error message for an empty List: ");
        try { //place in a try-catch so program does not end when exception thrown
            L.removeFirst(); //Testing Precondition: length == 0
        } catch(NoSuchElementException e) {
            e.printStackTrace();
        }  
        L.addFirst(4);
        L.addFirst(3);
        L.addFirst(2);
        L.addFirst(1);
        System.out.println("Should print 1 2 3 4: " + "\n" + L);
        
        System.out.println("**Testing removeLast**");
        L.removeLast();
        System.out.println("Should print 1 2 3: "+ "\n" + L );
        L.removeLast();
        System.out.println("Should print 1 2: " + "\n" + L);
        
        System.out.println("**Testing isEmpty**");
        List<Integer> L2 = new List<>();
        System.out.println("Should print true: " + L2.isEmpty());
        //add another test for isEmpty() here!
        L2.addFirst(1);
        //test when length > 0
        System.out.println("Should print false: " + L2.isEmpty() + "\n");
        
        System.out.println("**Testing getLength**");
        L2.removeFirst();
        System.out.println("Should print 0: " + L2.getLength());
        L2.addFirst(1);
        L2.addLast(2);
        System.out.println("Should print 2: " + L2.getLength() + "\n");
        
        System.out.println("**Testing getFirst**");
        System.out.println("Should print 1: " + L.getFirst()); //testing general case
        List<String>  L3 = new List<>();
        try { //testing precondition
            System.out.println("Should print error: " + L3.getFirst());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        System.out.println("\n");
        System.out.println("**Testing getLast**");
        System.out.println("should print 2: " + L2.getLast());
        try {
        	System.out.println("Should print error: " + L3.getLast());
        } catch (NoSuchElementException e) {
        	System.out.println(e.getMessage());
        }
        
    }
}
