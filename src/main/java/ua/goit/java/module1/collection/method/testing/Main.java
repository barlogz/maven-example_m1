package ua.goit.java.module1.collection.method.testing;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Measurer measurer = new Measurer();
        measurer.printResults("10K size", 10_000);
        measurer.printResults("100K size", 100_000);
        measurer.printResults("1000K size", 1_000_000);
        measurer.writeToFile("result.txt");
    }
}
