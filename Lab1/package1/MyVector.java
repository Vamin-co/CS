/*
 * Vandan Amin
 * Oct 11 2023
 */

package Lab1.package1;

import java.util.ArrayList;
import java.util.Arrays;

public class MyVector {
    private ArrayList<Double> values;

    public MyVector(ArrayList<Double> initValues) {
        // Constructor with ArrayList<Double>
        this.values = new ArrayList<>(initValues);
    }
    
    public MyVector(MyVector other) {
        // Copy constructor
        this.values = new ArrayList<>(other.values);
    }

    public double get(int k) {
        // Accessor function

        if (k < 0 || k >= values.size()) {
            throw new IllegalArgumentException("Invalid index");
        }
        return values.get(k);
    }

    public MyVector plus(MyVector other) {
        // Vector addition function

        if (this.values.size() != other.values.size()) {
            throw new IllegalArgumentException("Vector dimensions do not match");
        }
        ArrayList<Double> result = new ArrayList<>(this.values.size());
        for (int i = 0; i < this.values.size(); i++) {
            result.add(this.values.get(i) + other.values.get(i));
        }
        return new MyVector(result);
    }

    public MyVector minus(MyVector other) {
        // Vector subtraction function

        if (this.values.size() != other.values.size()) {
            throw new IllegalArgumentException("Vector dimensions do not match");
        }
        ArrayList<Double> result = new ArrayList<>(this.values.size());
        for (int i = 0; i < this.values.size(); i++) {
            result.add(this.values.get(i) - other.values.get(i));
        }
        return new MyVector(result);
    }

    public MyVector scaledBy(double scalar) {
        // Scalar multiplication function

        ArrayList<Double> result = new ArrayList<>(this.values.size());
        for (double value : this.values) {
            result.add(value * scalar);
        }
        return new MyVector(result);
    }

    public double abs() {
        // Abs Function

        double sumOfSquares = 0.0;

        for (double value : values) {
            sumOfSquares += value * value;
        }

        return Math.sqrt(sumOfSquares);
    }

    public double dot(MyVector other) {
        // Dot product function

        if (this.values.size() != other.values.size()) {
            throw new IllegalArgumentException("Vector dimensions do not match");
        }
        double dotProduct = 0;
        for (int i = 0; i < this.values.size(); i++) {
            dotProduct += this.values.get(i) * other.values.get(i);
        }
        return dotProduct;
    }

    @Override
    public String toString() {
        // Override toString method

        return Arrays.toString(values.toArray());
    }

    @Override
    public boolean equals(Object obj) {
        // Override equals method

        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MyVector)) {
            return false;
        }
        MyVector other = (MyVector) obj;
        return this.values.equals(other.values);
    }
}
