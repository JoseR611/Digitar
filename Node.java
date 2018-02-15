/**
 * @author Jose Romero
 * @version 5/1/17
 */
public class Node<T>
{
    private T value;
    private Node<T> next;
    private Node<T> previous;
    /**
     * Assigns value to the input value.
     * @param val A generic object to be stored in value.
     * @return None
     */
    public Node (T val){
        value = val;
    }
    /**
     * Gets the value of the Node object.
     * @param None
     * @return T The value of the Node object.
     */
    public T getData(){
        return value;
    }
    /**
     * Gets the next Node object.
     * @param None
     * @return Node The Node object that is assigned to next.
     */
    public Node<T> getNext(){
        return next;
    }
    /**
     * Gets the previous Node object.
     * @param None
     * @return Node The Node object that is assigned to previous.
     */
    public Node<T> getPrevious(){
        return previous;
    }
    /**
     * Assigns the variable next of the Node object to the Node of the parameter.
     * @param in A Node object that is assigned to next.
     * @return Void
     */
    public void setNext(Node<T> in){
        next = in;
    }
    /**
     * Assigns the variable previous of the Node object to the Node of the parameter.
     * @param in A Node object that is assigned to previous.
     * @return Void
     */
    public void setPrevious(Node<T> in){
        previous = in;
    }
    
}
