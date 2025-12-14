// ===== Input & Basic Utilities =====
import java.util.Scanner;
import java.util.Random;

// ===== Math =====
import java.lang.Math;          // sqrt, pow, abs, max, min (auto-imported, but written for clarity)

// ===== List Implementations =====
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;
import java.util.Stack;
import java.util.List;

// ===== Queue Implementations =====
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Deque;
import java.util.ArrayDeque;

// ===== Set Implementations =====
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

// ===== Map Implementations =====
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

// ===== Iterator & Utility =====
import java.util.Iterator;
import java.util.Collections;

// ===== Date & Time (Basic) =====
import java.util.Date;

// ===== Main Class =====
public class import_all {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Example usages (to show imports are valid)
        Vector<Integer> vec = new Vector<>();
        ArrayList<Integer> arr = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, String> map = new HashMap<>();

        double x = 25;
        System.out.println("Square root of 25: " + Math.sqrt(x));

        Random rand = new Random();
        System.out.println("Random number: " + rand.nextInt(10));

        Date today = new Date();
        System.out.println("Today: " + today);

        sc.close();
    }
}
