package de.uni_bremen.pi2;

import java.util.ArrayList;

public class Array<E>
{

    private  E[] buffer;
    private int enteries = 0 ;

    @SuppressWarnings("unchecked")
    public Array (int capacity){
        if (capacity < 0){throw new IllegalArgumentException("Capacity can not be negative");};
        buffer = (E[]) new Object[capacity];

    }

    public int size(){
        return enteries;
    }

    public int capacity(){
        return buffer.length;
    }

    @SuppressWarnings("unchecked")
    public void set(int index, E value){
       if(index < 0 ){throw new ArrayIndexOutOfBoundsException("Written Index is negative");}
       if(index > size()){
           int newEntries  = index + 1;
           int newCapacity = capacity() ;
           while(index >= newCapacity){
               if (newCapacity == 0){
                   newCapacity = 1;
               }
               else {newCapacity *=2;}
           }
           E[] tempArray  = (E[]) new Object[newCapacity];

           for (int i=0; i < size(); i++){
               tempArray[i] = buffer[i];
           }

           tempArray[index] = value;
           enteries = newEntries;
           this.buffer = tempArray;
       }
       else {buffer[index] = value; enteries++; }
    }

    public E get(final int index){
        return buffer[index];
    }

}