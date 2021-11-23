package main;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class SortedIntList extends ArrayIntList {

    /**
     * the unique status of SortedList
     */
    private boolean unique = false;

    public SortedIntList() {
        super();
    }

    public SortedIntList(boolean unique) {
        super();
        this.unique = unique;
    }

    public SortedIntList(int capacity) {
        super(capacity);
    }

    public SortedIntList(boolean unique, int capacity) {
        super(capacity);
        this.unique = unique;
    }

    public void add(int value) {
        if (super.size() == getArray().length) {
            super.resize();
        }
        if (unique) {
            if (!super.contains(value)) {
                sortedAdd(value);
            }
        } else {
            sortedAdd(value);
        }
    }

    public void add(int index, int value) {
        throw new UnsupportedOperationException("Sorted arrays do not support inserting elements to specified positions");
    }

    public boolean getUnique() {
        return unique;
    }

    public void setUnique(boolean unique) {
        if (!this.unique && unique) {
            int[] temp = new int[super.size()];
            int tempIndex = 0;
            for (int i = 0; i < super.size(); i++) {
                if (!arrayContains(temp, getArray()[i])) {
                    temp[tempIndex] = getArray()[i];
                    tempIndex++;
                }
            }
            setArray(temp);
            super.setSize(tempIndex);
        }
        this.unique = unique;
    }

    public int max() {
        if (super.size() == 0) {
            throw new NoSuchElementException("the list is empty");
        } else {
            return getArray()[super.size() - 1];
        }
    }

    public int min() {
        if (super.size() == 0) {
            throw new NoSuchElementException("the list is empty");
        } else {
            return getArray()[0];
        }
    }

    public String toString() {
        String result = "S:[";
        for (int i = 0; i < super.size(); i++) {
            result += getArray()[i];
            if (i < super.size() - 1) {
                result += ", ";
            }
        }
        result += unique ? "]U" : "]";
        return result;
    }

    public int indexOf(int value) {
        return Arrays.binarySearch(getArray(), 0, super.size(), value);
    }

    private void sortedAdd(int value) {
        int index = Arrays.binarySearch(getArray(), 0, super.size(), value);
        if (index >= 0){
            super.add(index,value);
        }else{
            super.add(-(index+1),value);
        }
    }

    private boolean arrayContains(int[] array, int value) {
        for (int j : array) {
            if (j == value) {
                return true;
            }
        }
        return false;
    }

}
