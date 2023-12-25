/**
 * Represents a person in the coffee shop simulation, including the time they arrived and their name.
 */
public class Person {
    private int arrivalTime;
    private String name;

    /**
     * Constructs a new person with a specified arrival time and name.
     *
     * @param arrivalTime The time the person arrives at the coffee shop.
     * @param name        The name of the person.
     */
    public Person(int arrivalTime, String name) {
        this.arrivalTime = arrivalTime;
        this.name = name;
    }

    /**
     * Retrieves the arrival time of the person.
     *
     * @return The arrival time of the person.
     */
    public int getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Retrieves the name of the person.
     *
     * @return The name of the person.
     */
    public String getName() {
        return name;
    }
}
