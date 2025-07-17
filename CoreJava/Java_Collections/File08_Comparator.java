package Java_Collections;
/*
 * ✅ Comparator in Java (java.util.Comparator)
 * ---------------------------------------------
 * 🔹 Used to define **custom sorting logic** for objects.
 * 🔹 Can be passed to Collections.sort() or TreeSet, etc.
 * 🔹 Used when:
 *     - You can't modify the class (external sorting)
 *     - You need **multiple ways** to sort
 * 🔹 compare(T o1, T o2) → returns:
 *     - negative → o1 < o2
 *     - zero     → o1 == o2
 *     - positive → o1 > o2
 */

import java.util.*;

// 🔹 Custom class
class Student2 {
    int id;
    String name;
    int marks;

    Student2(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String toString() {
        return id + " " + name + " " + marks;
    }
}

// 🔹 Comparator to sort by marks
class SortByMarks implements Comparator<Student1> {
    public int compare(Student1 s1, Student1 s2) {
        // if(s1.marks > s2.marks) return 1;
        // if(s1.marks < s2.marks) return -1;
        // return 0;
        return s1.marks - s2.marks; // Ascending
    }
}

// 🔹 Comparator to sort by name
class SortByName2 implements Comparator<Student1> {
    public int compare(Student1 s1, Student1 s2) {
        return s1.name.compareTo(s2.name); // Lexicographical order
    }
}

public class File08_Comparator {
    public static void main(String[] args) {
        List<Student1> list = new ArrayList<>();
        list.add(new Student1(101, "Keerthan K", 78));
        list.add(new Student1(105, "Dhoni", 90));
        list.add(new Student1(102, "Mahesh", 85));

        System.out.println("Original List:");
        for (Student1 s : list)
            System.out.println(s);

        SortByMarks sort1 = new SortByMarks();
        SortByName2 sort2 = new SortByName2();

        // 🔹 Sort by marks
        Collections.sort(list, sort1);
        System.out.println("\nSorted by Marks:");
        for (Student1 s : list)
            System.out.println(s);

        // 🔹 Sort by name
        Collections.sort(list, sort2);
        System.out.println("\nSorted by Name:");
        for (Student1 s : list)
            System.out.println(s);
    }
}

// Output:
// Original List:
// 101 Keerthan K 78
// 105 Dhoni 90
// 102 Mahesh 85

// Sorted by Marks:
// 101 Keerthan K 78
// 102 Mahesh 85
// 105 Dhoni 90

// Sorted by Name:
// 105 Dhoni 90
// 101 Keerthan K 78
// 102 Mahesh 85
