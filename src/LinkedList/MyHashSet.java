package LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

class MyHashSet {
    private static final int MAX_VALUE=1000000;
    private static final int ARRAY_SIZE=100;
    List<List<Integer>> parentList;

    public MyHashSet() {
        parentList = new ArrayList<>(ARRAY_SIZE);
        for(int i=0; i<ARRAY_SIZE; i++){
            parentList.add(null);
        }
    }

    public int hashCode(int key) {
        return key%ARRAY_SIZE;
    }

    public void add(int key) {
        int index = hashCode(key);
        List<Integer> childList = parentList.get(index);
        if(childList == null){
            List<Integer> list = new LinkedList<>();
            list.add(key);
            parentList.set(index, list);
        }
        else{
            if(!childList.contains(key)){
                childList.add(key);
            }
        }
    }

    public void remove(int key) {
        int index = hashCode(key);
        List<Integer> childList = parentList.get(index);
        if(childList!=null){
            childList.remove(Integer.valueOf(key));
        }
    }

    public boolean contains(int key) {
        int index = hashCode(key);
        List<Integer> childList = parentList.get(index);
        return childList!=null && childList.contains(key);
    }

    public void display(){
        System.out.println(parentList);
    }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);
        myHashSet.add(101);
        myHashSet.add(102);
        myHashSet.add(1333);
        myHashSet.add(222);
        myHashSet.add(1);
        myHashSet.add(2);
        myHashSet.add(111);
        myHashSet.add(222);
        myHashSet.display();
        System.out.println(myHashSet.contains(1)); // return True
        System.out.println(myHashSet.contains(3)); // return False, (not found)
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.display();
        System.out.println(myHashSet.contains(2)); // return True
        myHashSet.remove(2);   // set = [1]
        myHashSet.display();
        System.out.println(myHashSet.contains(2)); // return False, (already removed)
    }
}