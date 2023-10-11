package org.example;

public class ArrayList<T> implements ArrayListAbstract<T> {

    public ArrayList() { array = new Object[count];}

    public ArrayList(int count){
        count = count;
        array = new Object[count];
    }
    @Override
    public Object get(int index) {
        if (isIndexTrue(index))
            return array[index];
        else
            return null;
    }

    @Override
    public void set(int index, T data) {
        if(isIndexTrue(index))
            array[index] = data;
    }

    @Override
    public void pushback(T data) {
        if (size == count)
            recreateArray((int) (count *factor));

        array[size] = data;
        size++;
    }

    @Override
    public void add(int index, T data) {
        if(isIndexTrue(index)){
            if (size == count)
                recreateArray((int) (count*factor));

            shiftToRight(index);
            array[index] = data;
            size++;
        }

    }

    @Override
    public boolean remove(T data) {
        int index = getIndex(data);
        if(isIndexTrue(index)){
            shiftToLeft(index+1);
            size--;
            array[size]=null;
            return true;
        }

        return false;
    }

    @Override
    public void removeFromIndex(int index) {
        if(isIndexTrue(index)){
            shiftToLeft(index+1);
            size--;
            array[size]=null;
        }


    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {

        return size == 0;
    }

    @Override
    public int getIndex(T data) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals( data))
                return i;
        }
        return -1;
    }

    @Override
    public void clear() {
        count = 10;
        size = 0;
        array = new Object[count];
    }

    @Override
    public boolean contains(T data) {
        return getIndex(data) != -1;
    }

    @Override
    public Object[] toArray(){
        Object[] newArray = new Object[size];
        System.arraycopy(array, 0, newArray, 0, size);
        return newArray;
    }

    private boolean isIndexTrue(int index){
        return index > 0 && index <=size;
    }

    private void recreateArray(int newCount){
        Object[] newArray = new Object[newCount];
        System.arraycopy(array,0,newArray,0,size);

        array = newArray;
        count = newCount;

    }

    private void shiftToRight(int countShift){
        for (int i = size - 1; i >= countShift; i-- ) {
            array[i + 1] = array[i];
        }
    }

    private void shiftToLeft(int countShift){
        for (int i = countShift; i < size; i++ ) {
            array[i - 1] = array[i];
        }
    }

    private  Object[] array;
    private int size = 0;

    private final double factor = 1.5;
    private int count = 10;

}

