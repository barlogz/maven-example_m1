package ua.goit.java.module1.collection.method.testing;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

public class ListCollection extends CollectionsForTesting {

    @Override
    public long add(Collection collection, int numberOfElements) {
        populateCollection(collection, numberOfElements);
        final long startTime = System.nanoTime();

        for (int i = 0; i < count; i++) {
            ((List<Integer>) collection).add(randomIntGenerator(0, numberOfElements), randomIntGenerator(0, numberOfElements));
        }

        final long finishTime = System.nanoTime();
        return (finishTime - startTime) / count;
    }

    @Override
    public long get(List list, int numberOfElements) {
        populateCollection(list, numberOfElements);
        final long startTime = System.nanoTime();

        for (int i = 0; i < count; i++) {
            list.get(randomIntGenerator(0, numberOfElements - 1));
        }

        final long finishTime = System.nanoTime();
        return (finishTime - startTime) / count;
    }

    public long listIteratorAdd(List<Object> list, int numberOfElements) {
        populateCollection(list, numberOfElements);
        ListIterator<Object> listIterator = list.listIterator();
        final long startTime = System.nanoTime();

        for (int i = 0; i < count; i++) {
            listIterator.add(randomIntGenerator(0, numberOfElements));
        }
        final long finishTime = System.nanoTime();
        return (finishTime - startTime) / count;
    }

    public long listIteratorRemove(List list, int numberOfElements) {
        populateCollection(list, numberOfElements);
        ListIterator listIterator = list.listIterator();
        final long startTime = System.nanoTime();

        for (int i = 0; i < count; i++) {
            listIterator.next();
            listIterator.remove();
        }
        final long finishTime = System.nanoTime();
        return (finishTime - startTime) / count;
    }

}
