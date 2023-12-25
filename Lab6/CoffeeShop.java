import java.util.LinkedList;
import java.util.Queue;

/**
 * Simulates the operation of a coffee shop.
 */
public class CoffeeShop {
    private Queue<Person> customerQueue;
    private LinkedList<String> results;
    private int currentTime;
    private int nextDepartureTime;
    private int totalServed;
    private int totalWaitTime;
    private static final int SERVICE_TIME = 5;
    private static final int MAX_QUEUE_SIZE = 5;

    /**
     * Initializes a new CoffeeShop instance with an empty queue and no customers served.
     */
    public CoffeeShop() {
        customerQueue = new LinkedList<>();
        results = new LinkedList<>();
        currentTime = 0;
        nextDepartureTime = 0; // No one is being served at the start
        totalServed = 0;
        totalWaitTime = 0;
    }

    /**
     * Processes the arrival of a customer at the coffee shop.
     *
     * @param arrivalTime The time when the customer arrives.
     * @param name        The name of the customer.
     */
    public void processArrival(int arrivalTime, String name) {
        currentTime = arrivalTime;
        Person person = new Person(arrivalTime, name);
        if (customerQueue.size() < MAX_QUEUE_SIZE) {
            customerQueue.add(person);
            results.add(String.format("Time %d: Customer %s arrives", currentTime, name));
            if (customerQueue.size() == 1) {
                nextDepartureTime = currentTime + SERVICE_TIME; // Next departure time is set when the first customer in line arrives
            }
        } else {
            results.add(String.format("Time %d: Customer %s turned away", currentTime, name));
        }
    }

    /**
     * Processes the departure of a customer from the coffee shop.
     */
    public void processDeparture() {
        if (!customerQueue.isEmpty() && currentTime >= nextDepartureTime) {
            Person person = customerQueue.poll();
            totalWaitTime += currentTime - person.getArrivalTime() - SERVICE_TIME;
            results.add(String.format("Time %d: Customer %s served (Waited %d minutes)", currentTime, person.getName(), currentTime - person.getArrivalTime() - SERVICE_TIME));
            totalServed++;
            nextDepartureTime = currentTime + SERVICE_TIME; // Set the next departure time
        }
    }

    /**
     * Completes the processing of all remaining customers in the queue.
     */
    public void finishUp() {
        while (!customerQueue.isEmpty()) {
            currentTime = nextDepartureTime; // Fast forward time to the next departure
            processDeparture();
        }
    }

    /**
     * Retrieves the results of the simulation.
     *
     * @return A list of strings representing the events of the simulation.
     */
    public LinkedList<String> getResults() {
        return results;
    }

    /**
     * Retrieves the total number of customers served.
     *
     * @return The total number of customers served.
     */
    public int getTotalServed() {
        return totalServed;
    }

    /**
     * Retrieves the total wait time of all customers.
     *
     * @return The total wait time.
     */
    public int getTotalWaitTime() {
        return totalWaitTime;
    }

    /**
     * Retrieves the next departure time in the simulation.
     *
     * @return The next departure time.
     */
    public int getNextDepartureTime() {
        return nextDepartureTime;
    }

    /**
     * Sets the current time of the simulation.
     *
     * @param currentTime The current time to set.
     */
    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }

     /**
     * Retrieves the current time of the simulation.
     *
     * @return The current time.
     */
     public int getCurrentTime() {
        return currentTime;
    }

}
