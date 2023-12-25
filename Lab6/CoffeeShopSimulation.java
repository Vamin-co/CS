import java.util.LinkedList;
import java.util.Scanner;

/**
 * The main class for the coffee shop simulation, structured similarly to CarWash from the CarWash project.
 */
public class CoffeeShopSimulation {
    /**
     * The main entry point for the simulation program.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        new CoffeeShopSimulation().run();
    }

    /**
     * Runs the coffee shop simulation. Accepts user input for customer names and arrival times,
     * then processes the simulation and prints the results, similar to CarWashUser.
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        CoffeeShop coffeeShop = new CoffeeShop();

        System.out.println("Enter customer names and arrival times (name time). Enter 'CLOSE' to end:");

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("CLOSE")) {
                break;
            }
            String[] parts = input.split(" ");
            String name = parts[0];
            int time = Integer.parseInt(parts[1]);

            if (time < coffeeShop.getCurrentTime()) {
                System.out.println("Invalid time. Time must not be before the current time.");
                continue;
            }

            // Process any departures that should happen before this arrival
            while (coffeeShop.getCurrentTime() < time) {
                if (coffeeShop.getCurrentTime() >= coffeeShop.getNextDepartureTime()) {
                    coffeeShop.processDeparture();
                }
                coffeeShop.setCurrentTime(coffeeShop.getCurrentTime() + 1); // Increment the current time
            }

            coffeeShop.processArrival(time, name);
        }

        // Finish processing all remaining customers
        coffeeShop.finishUp();
        printResults(coffeeShop);
        scanner.close();
    }



    /**
     * Prints the results of the coffee shop simulation in a user-friendly format, akin to CarWashUser.
     *
     * @param coffeeShop The CoffeeShop instance containing the simulation results.
     */
    private void printResults(CoffeeShop coffeeShop) {
        LinkedList<String> results = coffeeShop.getResults();
        System.out.println("\nSimulation Results:");
        for (String result : results) {
            System.out.println(result);
        }
        int totalServed = coffeeShop.getTotalServed();
        int totalWaitTime = coffeeShop.getTotalWaitTime();
        System.out.println("\nTotal served: " + totalServed);
        System.out.printf("Average wait time: %.2f minutes\n", (totalServed == 0) ? 0 : (double) totalWaitTime / totalServed);
    }
}
