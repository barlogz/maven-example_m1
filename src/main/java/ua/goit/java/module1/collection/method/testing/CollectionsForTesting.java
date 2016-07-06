package ua.goit.java.module1.collection.method.testing;

import java.util.Collection;
import java.util.List;

public abstract class CollectionsForTesting {
    public static final int count = 100;

    public abstract long add(Collection collection, int numberOfElements);

    public long get(List list, int numberOfElements) {
        return 0;
    }

    public long remove(Collection collection, int numberOfElements) {
        populateCollection(collection, numberOfElements);
        final long startTime = System.nanoTime();

        for (int i = 0; i < count; i++) {
            collection.remove(randomIntGenerator(0, collection.size() - 1));
        }

        final long finishTime = System.nanoTime();
        return (finishTime - startTime) / count;
    }

    public long contains(Collection collection, int numberOfElements) {
        populateCollection(collection, numberOfElements);
        final long startTime = System.nanoTime();

        for (int i = 0; i < count; i++) {
            collection.contains(randomIntGenerator(0, numberOfElements));
        }
        return (System.nanoTime() - startTime) / count;
    }

    public long populate(Collection collection, int numberOfElements) {
        long sum = 0;

        for (int i = 0; i < count; i++) {
            collection.clear();
            final long startTime = System.nanoTime();
            for (int j = 0; j < numberOfElements; j++) {
                collection.add(randomIntGenerator(0, numberOfElements));
            }
            final long finishTime = System.nanoTime();
            sum += (finishTime - startTime);

        }
        return sum / count;
    }

    static int randomIntGenerator(int min, int max) {
        return (min + (int) (Math.random() * ((max - min) + 1)));
    }

    void populateCollection(Collection collection, int numberOfElements) {
        collection.clear();
        for (int i = 0; i < numberOfElements; i++) {
            collection.add(i);
        }
    }
}