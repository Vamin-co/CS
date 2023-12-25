/*
 * Vandan Amin
 * Oct 15 2023
 */

package Lab1.package1;

import java.util.ArrayList;
import java.util.Scanner;

public class VectorDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for vector x
        System.out.println("Enter 3 numbers for vector x:");
        ArrayList<Double> initValuesX = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            initValuesX.add(scanner.nextDouble());
        }

        // Input for vector y
        System.out.println("Enter 3 numbers for vector y:");
        ArrayList<Double> initValuesY = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            initValuesY.add(scanner.nextDouble());
        }

        // Create vectors
        MyVector vectorX = new MyVector(initValuesX);
        MyVector vectorY = new MyVector(initValuesY);

        // Print vectors
        System.out.println("Vector x : " + vectorX);
        System.out.println("Vector y: " + vectorY);

        // Create vector z by copying vector x
        MyVector vectorZ = new MyVector(vectorX);
        System.out.println("Vector z is created by copying vector x");
        System.out.println("Vector z: " + vectorZ);

        // Add vectors x and y and store in vector z
        vectorZ = vectorX.plus(vectorY);
        System.out.println("Vectors x and y will be added and stored in vector z");
        System.out.println("z = " + vectorZ);

        // Subtract vectors z and y and store in vector z
        vectorZ = vectorZ.minus(vectorY);
        System.out.println("Vectors z and y will be subtracted and stored in vector z");
        System.out.println("z = " + vectorZ);

        // Dot product of vectors x and y
        System.out.println("Dot-product of x and y");
        System.out.println(vectorX.dot(vectorY));

        // Check if vectors x and y are equal
        System.out.println("Equals function to check if x and y are equal. " + vectorX.equals(vectorY));

        // Input for scaling factor
        System.out.println("Enter a double you would like to scale z by:");
        double scalar = scanner.nextDouble();

        // Scale vector z by the entered scalar
        vectorZ = vectorZ.scaledBy(scalar);
        System.out.println(vectorZ);

        // Absolute value of vector x
        System.out.println("Absolute value of vector x");
        System.out.println(vectorX.abs());

        scanner.close();
    }
}
