/**
 * @author Jose Romero
 * @version 5/23/17
 */
import java.util.LinkedList;
public class InstrumentString{
    LinkedList<Double> displacement = new LinkedList<>();
    int lengthOfLinkedList;
    int currentTime;
    /**
     * Creates, using a given frequency, an InstrumentString object, and fills in a LinkedList with
     * the appropriate numbers
     * @param frequency a double that is used to calculate the length of the LinkedList
     * @return None
     */
    public InstrumentString(double frequency){
        double samplingRate = 44100;
        lengthOfLinkedList = (int)Math.ceil(samplingRate / frequency);
        for(int i = 0; i < lengthOfLinkedList; i++){
           displacement.addFirst(0.0);
        }
    }
    /**
     * Takes an array and fills in the LinkedList using the values from the array
     * @param arrayFrequency a double array used to fill in the LinkedList
     * @return None
     */
    public InstrumentString(double[] arrayFrequency){
        for(int i = 0; i < displacement.size(); i++){
            displacement.addLast(arrayFrequency[i]);
        }
    }
    /**
     * Replaces all of the current values in the LinkedList with random values 
     * to simulate the plucking of a string
     * @param None
     * @return Void
     */
    public void pluck(){
        int size = displacement.size();
        for(int i = 0; i < size; i++){
            displacement.pollLast();
        }
        for(int i = 0; i < size; i++){
            displacement.addLast(Math.random() - 0.5);
        }
    }
    /**
     * Applies the Karplus-Strong Update by taking in values from the LinkedList
     * and inserting the result on the end of the LinkedList
     * @param None
     * @return Void
     */
    public void tic(){
        double store1 = displacement.pollFirst();
        double store2 = displacement.peekFirst();
        double average = (store1 + store2) / 2;
        double result = average * 0.996;
        displacement.addLast(result);
        currentTime++;
    }
    /**
     * Returns the first element of the LinkedList
     * @param None
     * @return A double which is the first element of the LinkedList
     */
    public double sample(){
        return displacement.peekFirst();
    }
    /**
     * Returns the current time of the object
     * @param None
     * @return A integer of the attibute currentTime
     */
    public int time(){
        return currentTime;
    }
    /**
     * Displays the LinkedList as a String
     * @param None
     * @return A String representing the contents of the LinkedList
     */
    public String toString(){
        return displacement.toString();
    }
}
