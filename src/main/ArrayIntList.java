package main;

public class ArrayIntList {

    /**
     * the internal array for storing the elements
     */
    protected int[] array;

    /**
     * the number of elements in the list
     */
    protected int size = 0;

    /**
     * default constructor, capacity is 10
     */
    public ArrayIntList() {
        this.array = new int[10];
    }

    /**
     * constructor that specify the capacity of internal array
     * @param capacity the capacity of the list
     */
    public ArrayIntList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity must be equal to or greater than 0");
        } else {
            this.array = new int[capacity];
        }
    }

    /**
     * add a value to the end of list
     * @param value the value needed to be added
     */
    public void add(int value) {
        if (this.size == this.array.length) {
            this.resize();
        }
        this.array[this.size] = value;
        this.size++;
    }

    /**
     * add a value to specified index
     * @param index the position for the new element
     * @param value the value needed to be added
     */
    public void add(int index, int value) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        } else {
            if (this.size == this.array.length) {
                this.resize();
            }
            for (int i = this.size - 1; i >= index; i--) {
                this.array[i + 1] = this.array[i];
            }
            this.array[index] = value;
            this.size++;
        }
    }

    /**
     * get the value at specified index
     * @param index the index of intended value
     * @return the value at specified index
     */
    public int get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        } else {
            return this.array[index];
        }
    }

    /**
     * return the index of first occurrence of the value
     * @param value the value needed to be found
     * @return the index that the value first appears
     */
    public int indexOf(int value) {
        for (int i = 0; i < this.size; i++) {
            if (this.array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    /**
     * remove the value at specified index
     * @param index the index that needed to be removed
     */
    public void remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        } else {
            for (int i = index; i < this.size - 1; i++) {
                this.array[i] = this.array[i + 1];
            }
            this.array[this.size - 1] = 0;
            this.size--;
        }
    }

    /**
     * return the size of the list
     * @return the number of elements in the list
     */
    public int size() {
        return this.size;
    }

    /**
     * set size
     * @param size the new size of the list
     */
    protected void setSize(int size) {
        this.size = size;
    }

    /**
     * convert the list to string
     * @return the string form of the list
     */
    public String toString() {
        String result = "[";
        for (int i = 0; i < this.size; i++) {
            result += this.array[i];
            if (i < this.size - 1) {
                result += ", ";
            }
        }
        result += "]";
        return result;
    }

    /**
     * empty the list
     */
    public void clear() {
        this.size = 0;
        this.array = new int[this.array.length];
    }

    /**
     * if the list contain the specified element
     * @param value the value needed to be checked
     * @return if the value exist in the list
     */
    public boolean contains(int value) {
        for (int i = 0; i < this.size; i++) {
            if (this.array[i] == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * ensure there is enough capacity in the list
     * @param capacity the capacity needed to be ensured
     */
    public void ensureCapacity(int capacity) {
        if (this.array.length < capacity) {
            this.resize(capacity);
        }
    }

    /**
     * check if the list is empty
     * @return if the list is empty
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * check if the index is in range
     * @param index the index needed to be checked
     * @param min   the lower bound of the range
     * @param max   the upper bound of the range
     */
    private void checkIndex(int index, int min, int max) {
        if (index < min || index > max) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    /**
     * return the internal array
     * @return return the internal array
     */
    public int[] getArray(){
        return this.array;
    }

    /**
     * set the internal array
     * @param array the array needed to be set
     */
    protected void setArray(int[] array){
        this.array = array;
    }

    /**
     * default resize method, increase the size of internal array by 1
     */
    protected void resize() {
        int[] newArray = new int[this.array.length + 1];
        System.arraycopy(this.array, 0, newArray, 0, this.array.length);
        this.array = newArray;
    }

    /**
     * resize the internal array to the input capacity
     * @param newCapacity the size of internal array after operation
     */
    protected void resize(int newCapacity) {
        if (newCapacity <= this.size) {
            throw new IllegalArgumentException("New capacity must be greater than current size, or you will lose data");
        } else {
            int[] newArray = new int[newCapacity];
            System.arraycopy(this.array, 0, newArray, 0, this.array.length);
            this.array = newArray;
        }
    }

}
