package proj3;
import org.junit.*;
import org.junit.rules.Timeout;
import static org.junit.Assert.*;

public class LinkedListTest {
    @Rule // a test will fail if it takes longer than 1/10 of a second to run
    public Timeout timeout = Timeout.millis(100);
    @Test //Test the constructor for LinkedLists
    public void testConstructor(){
        LinkedList myLl = new LinkedList();
        assertEquals("()", myLl.toString());
        assertEquals(0, myLl.getLength());
    }
    @Test //Test insertAtHead method
    public void testInsertAtHead(){
        LinkedList myLl = new LinkedList();
        myLl.insertAtHead("Hi");
        assertEquals("(Hi)", myLl.toString());
        myLl.insertAtHead("my");
        assertEquals("(my, Hi)", myLl.toString());
        myLl.insertAtHead("my3");
        myLl.insertAtHead("my2");
        myLl.insertAtHead("my1");
        assertEquals("(my1, my2, my3, my, Hi)", myLl.toString());
    }
    @Test//Test insertAtTail method
    public void testInsertAtTail(){
        LinkedList myLl = new LinkedList();
        myLl.insertAtTail("Hi");
        assertEquals("(Hi)", myLl.toString());
        myLl.insertAtHead("ehm");
        myLl.insertAtHead("heh");
        myLl.insertAtTail("why");
        assertEquals("(heh, ehm, Hi, why)", myLl.toString());
    }
    @Test//Test removeTail method
    public void testRemoveTail(){
        LinkedList myLl = new LinkedList();
        myLl.insertAtTail("Hi");
        assertEquals("(Hi)", myLl.toString());
        myLl.insertAtHead("ehm");
        myLl.insertAtHead("heh");
        myLl.insertAtTail("why");
        assertEquals("(heh, ehm, Hi, why)", myLl.toString());
        myLl.removeTail();
        assertEquals("(heh, ehm, Hi)", myLl.toString());
        myLl.removeTail();
        assertEquals("(heh, ehm)", myLl.toString());
        myLl.removeTail();
        assertEquals("(heh)", myLl.toString());
        myLl.removeTail();
        assertEquals("()", myLl.toString());
        myLl.removeTail();
        assertEquals("()", myLl.toString());
    }
    @Test //Test contains method
    public void testContains(){
        LinkedList myLl = new LinkedList();
        myLl.insertAtTail("Hi");
        assertEquals("(Hi)", myLl.toString());
        myLl.insertAtHead("ehm");
        myLl.insertAtHead("heh");
        myLl.insertAtTail("why");
        assertTrue(myLl.contains("why"));
        assertTrue(myLl.contains("heh"));
        assertTrue(myLl.contains("ehm"));
        myLl.removeTail();
        assertFalse(myLl.contains("why"));
    }
    @Test //Test isEmpty method
    public void testIsEmpty(){
        LinkedList myLl = new LinkedList();
        myLl.insertAtTail("Hi");
        myLl.insertAtHead("ehm");
        myLl.insertAtHead("heh");
        myLl.insertAtTail("why");
        assertFalse(myLl.isEmpty());
        myLl.removeTail();
        myLl.removeTail();
        myLl.removeTail();
        myLl.removeTail();
        assertTrue(myLl.isEmpty());
    }
    @Test //Test get method
    public void testGet(){
        LinkedList myLl = new LinkedList();
        myLl.insertAtTail("Hi");
        myLl.insertAtHead("ehm");
        myLl.insertAtHead("heh");
        myLl.insertAtTail("why");
        assertEquals("heh", myLl.get(0));
        assertEquals("ehm", myLl.get(1));
        assertEquals("Hi", myLl.get(2));
        assertEquals("why", myLl.get(3));
        assertNull(myLl.get(-1));
        assertNull(myLl.get(-4));
    }
    @Test //Test removeAtIndex method
    public void TestRemoveAtIndex(){
        LinkedList myLl = new LinkedList();
        myLl.insertAtTail("Hi");
        myLl.insertAtHead("ehm");
        myLl.insertAtHead("heh");
        myLl.insertAtTail("why");
        myLl.removeAtIndex(1);
        assertEquals("(heh, Hi, why)", myLl.toString());
        myLl.removeAtIndex(1);
        assertEquals("(heh, why)", myLl.toString());
        myLl.removeAtIndex(0);
        assertEquals("(why)", myLl.toString());
        myLl.removeAtIndex(0);
        assertEquals("()", myLl.toString());
        myLl.removeAtIndex(0);
        assertEquals("()", myLl.toString());
    }
    @Test //Test set method
    public void testSet(){
        LinkedList myLl = new LinkedList();
        myLl.insertAtTail("Hi");
        myLl.insertAtHead("ehm");
        myLl.insertAtHead("heh");
        myLl.insertAtTail("why");
        assertEquals("(heh, ehm, Hi, why)", myLl.toString());
        myLl.set(0, "meme");
        assertEquals("(meme, ehm, Hi, why)", myLl.toString());
        myLl.set(3, "what");
        assertEquals("(meme, ehm, Hi, what)", myLl.toString());
        myLl.set(4, "Zuhair");
        assertEquals("(meme, ehm, Hi, what, Zuhair)", myLl.toString());
        myLl.set(7, "Zuhair2");
        assertEquals("(meme, ehm, Hi, what, Zuhair, Zuhair2)", myLl.toString());
    }
    @Test //Test equals
    public void testEquals(){
        LinkedList myLl = new LinkedList();
        myLl.insertAtTail("Hi");
        myLl.insertAtHead("ehm");
        myLl.insertAtHead("heh");
        myLl.insertAtTail("why");
        LinkedList myLl1 = new LinkedList();
        myLl1.insertAtTail("Hi");
        myLl1.insertAtHead("ehm");
        myLl1.insertAtHead("heh");
        myLl1.insertAtTail("why");
        assertTrue(myLl.equals(myLl1));
        myLl.removeTail();
        assertFalse(myLl.equals(myLl1));
    }
}
