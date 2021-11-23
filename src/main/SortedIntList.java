package main;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class SortedIntList extends ArrayIntList {

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
        if (this.size == this.array.length) {
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
            int[] temp = new int[this.size];
            int tempIndex = 0;
            for (int i = 0; i < this.size; i++) {
                if (!arrayContains(temp, this.array[i])) {
                    temp[tempIndex] = this.array[i];
                    tempIndex++;
                }
            }
            this.array = temp;
            this.size = tempIndex;
        }
        this.unique = unique;
    }

    public int max() {
        if (this.size == 0) {
            throw new NoSuchElementException("the list is empty");
        } else {
            return this.array[this.size - 1];
        }
    }

    public int min() {
        if (this.size == 0) {
            throw new NoSuchElementException("the list is empty");
        } else {
            return this.array[0];
        }
    }

    public String toString() {
        String result = "S:[";
        for (int i = 0; i < this.size; i++) {
            result += this.array[i];
            if (i < this.size - 1) {
                result += ", ";
            }
        }
        result += unique ? "]U" : "]";
        return result;
    }

    public int indexOf(int value) {
        return Arrays.binarySearch(this.array, 0, this.size, value);
    }

    private void sortedAdd(int value) {
        for (int i = 0; i < super.size() + 1; i++) {
            if (value <= this.array[0]) {
                super.add(0, value);
                break;
            }
            if (value >= this.array[i]) {
                if (value < this.array[i + 1] || this.size == 0 || i == this.size - 1) {
                    if (this.size == 0) {
                        super.add(value);
                    } else {
                        super.add(i + 1, value);
                    }
                    break;
                }
            }
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
