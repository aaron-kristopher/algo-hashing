package datastructures;

import java.util.LinkedList;

import collision.CollisionResolutionStrategy;
import hash.HashFunctionStrategy;

public class BucketTableImpl extends DataTableStrategy {

    @SuppressWarnings({ "unchecked" })
    private LinkedList<String>[] table = new LinkedList[50];
    private int longestWordLength = 0;

    public BucketTableImpl(HashFunctionStrategy hashFunction, CollisionResolutionStrategy collisionResolution) {
        super(hashFunction, collisionResolution);
    }

    @Override
    public void put(String key) {
        String hashedValue = hashFunction.toASCIIValue(key);
        int index = hashFunction.hash(hashedValue);

        if (isCellEmpty(index))
            table[index] = new LinkedList<>();

        table[index].add(key);
    }

    @Override
    public String get(int index) {
        return "";
    }

    @Override
    public boolean isCellEmpty(int index) {
        return table[index] == null;
    }

    @Override
    public String toString() {
        getLongestWordLength();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < table.length / 5; i++) {
            sb.append(formatEntry(i));
            sb.append(formatEntry(i + 10));
            sb.append(formatEntry(i + 20));
            sb.append(formatEntry(i + 30));
            sb.append(formatEntry(i + 40) + "\n");
        }
        return sb.toString();
    }

    private String formatList(LinkedList<String> tableList) {
        StringBuilder sb = new StringBuilder();
        for (String word : tableList) {
            sb.append(word);
            if (word != tableList.getLast())
                sb.append(" -> ");

        }
        return sb.toString();
    }

    private String formatEntry(int index) {
        String width = (table[index] == null ? " ".repeat(longestWordLength + 2) : formatList(table[index]));
        return index + ": " + width + " ".repeat(longestWordLength - width.length() + 2);

    }

    @Override
    public int getLongestWordLength() {

        for (LinkedList<String> list : table) {
            if (list == null)
                continue;
            for (String word : list) {
                StringBuilder sb = new StringBuilder();
                for (int index = 0; index < word.length(); index++)
                    sb.append(table[index] == null ? "" : formatList(table[index]));

                if (sb.length() > longestWordLength)
                    longestWordLength = sb.length();
            }
        }
        return longestWordLength;
    }
}
