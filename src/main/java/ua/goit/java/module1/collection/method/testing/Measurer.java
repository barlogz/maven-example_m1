package ua.goit.java.module1.collection.method.testing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Measurer {
    private List<String> resultForArrayList = new ArrayList<>();
    private List<String> resultForLinkedList = new ArrayList<>();
    private List<String> resultForHashSet = new ArrayList<>();
    private List<String> resultForTreeSet = new ArrayList<>();
    private StringBuilder stringBuilder = new StringBuilder();
    private StringBuilder stringBuilderForFile = new StringBuilder();
    private ListCollection listCollection = new ListCollection();
    private SetCollection setCollection = new SetCollection();

    private void saveListResults(List<Object> list, List<String> resultList, int numberOfElements) {
        resultList.add(0, list.getClass().getSimpleName());
        resultList.add(1, String.valueOf(listCollection.add(list, numberOfElements)));
        resultList.add(2, String.valueOf(listCollection.get(list, numberOfElements)));
        resultList.add(3, String.valueOf(listCollection.remove(list, numberOfElements)));
        resultList.add(4, String.valueOf(listCollection.contains(list, numberOfElements)));
        resultList.add(5, String.valueOf(listCollection.populate(list, numberOfElements)));
        resultList.add(6, String.valueOf(listCollection.listIteratorAdd(list, numberOfElements)));
        resultList.add(7, String.valueOf(listCollection.listIteratorRemove(list, numberOfElements)));
    }

    private void getListResults(List<Object> list, int numberOfElements) {
        if (list instanceof ArrayList) {
            saveListResults(list, resultForArrayList, numberOfElements);
        } else if (list instanceof LinkedList) {
            saveListResults(list, resultForLinkedList, numberOfElements);
        }
    }

    private void saveSetResults(Set set, List<String> resultSet, int numberOfElements) {
        resultSet.add(0, set.getClass().getSimpleName());
        resultSet.add(1, String.valueOf(setCollection.add(set, numberOfElements)));
        resultSet.add(2, "-");
        resultSet.add(3, String.valueOf(setCollection.remove(set, numberOfElements)));
        resultSet.add(4, String.valueOf(setCollection.contains(set, numberOfElements)));
        resultSet.add(5, String.valueOf(setCollection.populate(set, numberOfElements)));
        resultSet.add(6, "-");
        resultSet.add(7, "-");
    }

    private void getSetResults(Set set, int numberOfElements) {
        if (set instanceof HashSet) {
            saveSetResults(set, resultForHashSet, numberOfElements);
        } else if (set instanceof TreeSet) {
            saveSetResults(set, resultForTreeSet, numberOfElements);
        }
    }

    private void measure(int numberOfElements) {
        getListResults(new ArrayList<>(), numberOfElements);
        getListResults(new LinkedList<>(), numberOfElements);
        getSetResults(new HashSet<>(), numberOfElements);
        getSetResults(new TreeSet<>(), numberOfElements);
    }

    public void printResults(String strSize, int numberOfMeasurements) {
        measure(numberOfMeasurements);
        stringBuilder.append(String.format("%52s%n", "--------------------------------------------------------------------------------------------------------------------------"));
        stringBuilder.append(String.format("%-12s%10s%10s%15s%15s%15s%22s%23s%n", strSize, "add", "get", "remove", "contains", "populate", "listIteratorAdd", "listIteratorRemove"));
        stringBuilder.append(String.format("%52s%n", "--------------------------------------------------------------------------------------------------------------------------"));
        stringBuilder.append(String.format("%-12s%10s%10s%15s%15s%15s%22s%23s%n", resultForArrayList.get(0), resultForArrayList.get(1), resultForArrayList.get(2), resultForArrayList.get(3),
                resultForArrayList.get(4), resultForArrayList.get(5), resultForArrayList.get(6), resultForArrayList.get(7)));
        stringBuilder.append(String.format("%-12s%10s%10s%15s%15s%15s%22s%23s%n", resultForLinkedList.get(0), resultForLinkedList.get(1), resultForLinkedList.get(2), resultForLinkedList.get(3),
                resultForLinkedList.get(4), resultForLinkedList.get(5), resultForLinkedList.get(6), resultForLinkedList.get(7)));
        stringBuilder.append(String.format("%-12s%10s%10s%15s%15s%15s%22s%23s%n", resultForHashSet.get(0), resultForHashSet.get(1), resultForHashSet.get(2), resultForHashSet.get(3),
                resultForHashSet.get(4), resultForHashSet.get(5), resultForHashSet.get(6), resultForHashSet.get(7)));
        stringBuilder.append(String.format("%-12s%10s%10s%15s%15s%15s%22s%23s%n", resultForTreeSet.get(0), resultForTreeSet.get(1), resultForTreeSet.get(2), resultForTreeSet.get(3),
                resultForTreeSet.get(4), resultForTreeSet.get(5), resultForTreeSet.get(6), resultForTreeSet.get(7)));
        stringBuilder.append(String.format("%52s%n", "--------------------------------------------------------------------------------------------------------------------------"));
        stringBuilder.append("\n");
        stringBuilder.append("\n");
        stringBuilder.append("\n");
        System.out.println(stringBuilder.toString());
        stringBuilderForFile.append(stringBuilder);
        stringBuilder.setLength(0);
    }

    public void writeToFile(String fileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(fileName)))) {
            bufferedWriter.write(stringBuilderForFile.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
