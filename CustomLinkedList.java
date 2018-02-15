/**
 * @author Jose Romero
 * @version 5/1/17
 */
public class CustomLinkedList<T>
{
    private Node<T> head;
    private Node<T> tail;
    /**
     * Assigns head to null and tail to null.
     * @param None
     * @return None
     */
    public CustomLinkedList(){
        head = null;
        tail = null;
    }
    /**
     * Returns the first element in the self-made linked list.
     * @param None
     * @return T The head of the linked list, or if head is null, return null.
     */
    public T peekFirst(){
        if(head != null){
            T result = (T)head.getData();
            return result;
        }else{
            return null;
        }
    }
    /**
     * Returns the last element in the self-made linked list.
     * @param None
     * @return T The tail of the linked list, or if tail is null return null.
     */
    public T peekLast(){
        if(tail != null){
            T result = (T)tail.getData();
            return result;
        }else{
            return null;
        }
    }
    /**
     * Adds a new element to the front of the self-made linked list.
     * @param x Any element to be assigned as the new head of the linked list.
     * @return Void
     */
    public void addFirst(T x){
        Node<T> newHead = new Node<>(x);
        if(head != null){
            newHead.setNext(head);
            head.setPrevious(newHead);
        }else{
            tail = newHead;
        }
        newHead.setPrevious(null);
        head = newHead;
    }
    /**
     * Adds a new element to the back of the self-made linked list.
     * @param y Any element to be assigned as the new tail of the linked list.
     * @return Void
     */
    public void addLast(T y){
        Node<T> newTail = new Node<>(y);
        if(tail != null){
            newTail.setPrevious(tail);
            tail.setNext(newTail);
        }else{
            head = newTail;
        }
        newTail.setNext(null);
        tail = newTail;
    }
   
    
    /**
     * Returns the elements the self-made linked list contains,
     * @param None
     * @return String Each of the elements stored in the self-made linked list, with arrows 
     * seperating each of them from each other,
     */
    public String toString(){
        String addStuff = "";
        Node<T> holder = head;
        String arrows = "<-->";
        boolean containElements = true;
        if(head == null && tail == null){
            containElements = false;
        }
        while(containElements){
           if(holder.getNext() == null){
               arrows = "";
           }
           T result = (T)holder.getData();
           addStuff = addStuff + result + arrows;
           if(holder.getNext() == null){
               break;
           }
           holder = holder.getNext();
        }
        String s = "head-->" + addStuff + "<--tail";
        return s;
    }
    /**
     * Returns and deletes the first element of the self-made linked list.
     * @param None
     * @return The head of the self-made linked list, or null if the head is null
     */
    public T pollFirst(){
        if(head == null){
            return null;
        }
        T result = (T)head.getData();
        if(head == tail){
            head = null;
            tail = null;
        }else{
            head = head.getNext();
            head.setPrevious(null);
        }
        return result;
    }
    /**
     * Returns and deletes the last element of the self-made linked list.
     * @param None
     * @return The tail of the self-made linked list, or null, if the tail is null
     */
    public T pollLast(){
        if(tail == null){
            return null;
        }
        T result = (T)tail.getData();
        if(tail == head){
            head = null;
            tail = null;
        }else{
            tail = tail.getPrevious();
            tail.setNext(null);
        }
        return result;
    }
    /**
     * Tests out all of the methods by creating a CustomLinkedList object and 
     * applying all of the methods to it.
     * @param args A string array containing the command line arguments.
     * @return Void
     */
    public static void main(String[] args){
        CustomLinkedList<Integer> ll = new CustomLinkedList<Integer>();
        ll.addLast(10);
        System.out.println("" + ll.peekLast() + " was added to the tail of the list");
        ll.addLast(11);
        System.out.println("" + ll.peekLast() + " was be added to the tail of the list");
        ll.addFirst(3);
        System.out.println("" + ll.peekFirst() + " was be added to the head of the list");
        ll.addFirst(4);
        System.out.println("" + ll.peekFirst() + " was be added to the head of the list");
        System.out.println(ll);
        System.out.println("The data '" + ll.pollFirst() + "' will be removed from the head");
        System.out.println(ll);
        System.out.println("The data '" + ll.pollLast() + "' will be removed from the tail");
        System.out.println(ll);
        System.out.println("The data '" + ll.pollLast() + "' will be removed from the tail");
        System.out.println(ll);
        System.out.println("The data '" + ll.pollFirst() + "' will be removed from the head");
        System.out.println(ll);
        
    }
}
