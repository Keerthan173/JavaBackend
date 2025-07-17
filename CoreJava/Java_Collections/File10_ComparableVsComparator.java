package Java_Collections;

/*
 *  Comparable vs Comparator in Java
 * -------------------------------------
 * ✅ Comparable (java.lang)
 *    - Used for natural/default sorting (only one logic)
 *    - Must be implemented by the class being sorted
 *    - Override compareTo() method
 *
 * ✅ Comparator (java.util)
 *    - Used for custom/multiple sorting logic
 *    - Write separate class or lambda
 *    - Override compare() method
 */

import java.util.*;

// 🔹 Class implementing Comparable (natural order: by marks)
class Student implements Comparable<Student1> {
    int id;
    String name;
    int marks;

    Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    @Override
    public int compareTo(Student1 other) {
        return this.marks - other.marks;  // ascending
    }

    @Override
    public String toString() {
        return id + " " + name + " " + marks;
    }
}

// 🔸 Comparator for sorting by name
class SortByName implements Comparator<Student1> {
    public int compare(Student1 a, Student1 b) {
        return a.name.compareTo(b.name);
    }
}

public class File10_ComparableVsComparator {
    public static void main(String[] args) {
        List<Student1> list = new ArrayList<>();
        list.add(new Student1(103, "Zara", 75));
        list.add(new Student1(101, "Amit", 90));
        list.add(new Student1(102, "John", 85));

        System.out.println("Original List:");
        for (Student1 s : list)
            System.out.println(s);

        // ✅ Sort by natural order (Comparable - marks)
        Collections.sort(list);
        System.out.println("\nSorted by Marks (Comparable):");
        for (Student1 s : list)
            System.out.println(s);


        // ✅ Sort by name (Comparator)
        Collections.sort(list, new SortByName2());
        System.out.println("\nSorted by Name (Comparator):");
        for (Student1 s : list)
            System.out.println(s);

    }
}

// Ouput:
// Original List:
// 103 Zara 75
// 101 Amit 90
// 102 John 85

// Sorted by Marks (Comparable):
// 103 Zara 75
// 102 John 85
// 101 Amit 90

// Sorted by Name (Comparator):
// 101 Amit 90
// 102 John 85
// 103 Zara 75
