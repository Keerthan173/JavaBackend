package Java_Collections;

/*
 * ✅ Comparable in Java (java.lang.Comparable)
 * ---------------------------------------------
 * 🔹 Used to define **default/natural sorting order** for objects
 * 🔹 Should implement Comparable<T> and override compareTo(T o)
 * 🔹 Only one sorting logic per class (for multiple use Comparator)
 *
 * 🔸 compareTo() returns:
 *   - negative → this < o
 *   - zero     → this == o
 *   - positive → this > o
 */

import java.util.*;

class Student1 implements Comparable<Student1> {
    int id;
    String name;
    int marks;

    Student1(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // 🔹 Natural order: by marks (ascending)
    public int compareTo(Student1 other) {
        return this.marks - other.marks;
    }

    public String toString() {
        return id + " " + name + " " + marks;
    }
}

public class File09_Comparable {
    public static void main(String[] args) {
        List<Student1> list = new ArrayList<>();
        list.add(new Student1(103, "Zara", 75));
        list.add(new Student1(101, "Amit", 90));
        list.add(new Student1(102, "John", 85));

        System.out.println("Original List:");
        for (Student1 s : list)
            System.out.println(s);

        // 🔹 Sort using Comparable (natural order by marks)
        Collections.sort(list);

        System.out.println("\nSorted by Marks - Default(using Comparable):");
        for (Student1 s : list)
            System.out.println(s);
    }
}
// Output:
// Original List:
// 103 Zara 75
// 101 Amit 90
// 102 John 85

// Sorted by Marks - Default(using Comparable):
// 103 Zara 75
// 102 John 85
// 101 Amit 90