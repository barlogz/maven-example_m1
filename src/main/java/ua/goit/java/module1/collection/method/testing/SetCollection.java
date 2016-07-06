package ua.goit.java.module1.collection.method.testing;

import java.util.Collection;

public class SetCollection extends CollectionsForTesting {
    @Override
    public long add(Collection collection, int numberOfElements) {
        populateCollection(collection, numberOfElements);
        final long startTime = System.nanoTime();

        for (int i = 0; i < count; i++) {
            collection.add(randomIntGenerator(0, numberOfElements - 1));
        }
        final long finishTime = System.nanoTime();
        return (finishTime - startTime) / count;
    }
}
