package collection;
// ===== INPUT =====
import java.util.Scanner;

// ===== LIST =====
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;
import java.util.Stack;

// ===== SET =====
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

// ===== MAP =====
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

// ===== QUEUE =====
import java.util.Queue;
import java.util.PriorityQueue;

// ===== UTILITIES =====
import java.util.Iterator;
import java.util.Collections;

public class Collection {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 1️⃣ LIST INTERFACE

        // ArrayList: Dynamic array, allows duplicates
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(10); // duplicate allowed
        arrayList.remove(2);
        
        // LinkedList: Faster insert/delete
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);

        // Vector: Thread-safe (synchronized)
        Vector<Integer> vector = new Vector<>();
        vector.add(100);
        vector.add(200);

        // Stack: LIFO
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(10);
        stack.pop(); // removes 10

        // 2️⃣ SET INTERFACE (NO DUPLICATES)

        // HashSet: No order
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(5);
        hashSet.add(5); // ignored
        hashSet.add(10);

        // LinkedHashSet: Maintains insertion order
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(1);
        linkedHashSet.add(2);

        // TreeSet: Sorted order
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(30);
        treeSet.add(10);
        treeSet.add(20);

        // ==================================================
        // 3️⃣ QUEUE (FIFO)
        // ==================================================

        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(15);
        queue.add(5);
        queue.add(25);
        queue.poll(); // removes smallest element

        // ==================================================
        // 4️⃣ MAP (KEY - VALUE)
        // ==================================================

        // HashMap: No order
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Bappy");
        hashMap.put(2, "Sami");

        // LinkedHashMap: Maintains insertion order
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, "A");
        linkedHashMap.put(2, "B");

        // TreeMap: Sorted by key
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "X");
        treeMap.put(1, "Y");
        treeMap.put(2, "Z");

        // ==================================================
        // 5️⃣ ITERATOR
        // ==================================================

        Iterator<Integer> it = arrayList.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // ==================================================
        // 6️⃣ COLLECTIONS CLASS
        // ==================================================

        Collections.sort(arrayList);
        Collections.reverse(arrayList);

        // ==================================================
        // OUTPUT
        // ==================================================

        System.out.println("ArrayList: " + arrayList);
        System.out.println("LinkedList: " + linkedList);
        System.out.println("Vector: " + vector);
        System.out.println("Stack: " + stack);

        System.out.println("HashSet: " + hashSet);
        System.out.println("LinkedHashSet: " + linkedHashSet);
        System.out.println("TreeSet: " + treeSet);

        System.out.println("Queue: " + queue);

        System.out.println("HashMap: " + hashMap);
        System.out.println("LinkedHashMap: " + linkedHashMap);
        System.out.println("TreeMap: " + treeMap);

        sc.close();
    }
}


