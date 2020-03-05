package DataStructuresAndAlgorithmBasic.Exercise.ArrayList;

public class MyList <E>{
    private int size = 0;
    static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyList() {
        size = DEFAULT_CAPACITY;
    }

    public MyList(int capacity) {
        size = capacity;
    }

    public void add(int index, E element) {
        if (index>size || index<0) {
            throw new IndexOutOfBoundsException("no value added");
        }
        else {
            for (int i = 0; i < size; i++) {
                if (index == i) {
                    size++;
                    for (int j = i+1; j < size; j++) {
                        elements[j] = elements[i];
                    }
                    elements[index] = element;
                    break;
                }
            }
        }

    }

    public E remove(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("No value remove");
        }
        else {
            for (int i = 0; i < size; i++) {
                if (index == i) {
                    for (int j=i+1; j < size; j++) {
                        elements[i] = elements[j];
                    }
                }
            }
        }
        E temp = (E)elements[index];
        return temp;
    }

    public int size() {
        return 0;
    }

//    public E clone() {
//
//    }
//
//    public boolean contains(E o) {
//
//    }

//    public int indexOf(E o) {
//
//    }
//
//    public boolean add(E o) {
//
//    }

    public void ensureCapacity(int minCapacity) {

    }

//    public E get(int i) {
//
//    }

    public void clear() {

    }
}
