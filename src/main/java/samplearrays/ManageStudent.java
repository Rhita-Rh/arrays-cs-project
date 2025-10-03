package samplearrays;

import java.util.Arrays;
import java.util.Comparator;

public class ManageStudent {
    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        int maxAge = 0;
        Student oldest = null;
        for(int i =0; i<students.length; i++){
            if(students[i].getAge() > maxAge){
                oldest = students[i];
                maxAge = students[i].getAge();
            }
        }
        return oldest;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        int adultCounter = 0;
        for(int i =0; i<students.length; i++){
            if(students[i].isAdult()){
                adultCounter ++;
            }
        }
        return adultCounter;
    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        int gradeSum = 0;
        for(int i =0; i<students.length; i++){
            gradeSum += students[i].getGrade();
        }

        return gradeSum/(Student.getNumStudent());
    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        for(int i =0; i<students.length; i++){
            if((students[i].getName()).equals(name)){ // case-sensitive
                return students[i];
            }
        }

        // if the student is not found
        return null;
    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {
        Arrays.sort(students, new Comparator<Student>(){    //Array.sort() with a custom comparator
            @Override
                    public int compare(Student s1, Student s2){
                        return Double.compare(s2.getGrade(), s1.getGrade());
            }
        });
    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
        for(int i =0; i<students.length; i++){
            if((students[i].getGrade()) >= 15){
                System.out.println(students[i].getName());
            }
        }
    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        for(int i =0; i<students.length; i++){
            if((students[i].getId()) == id){    //student with the wanted id
                students[i].setGrade(newGrade);
                return true;
            }
        }
        return false; // id not found
    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        for(int i =0; i<students.length; i++) {
            String name = students[i].getName();
            for (int j = 0; j < students.length; j++) {
                if (i == j) {
                    continue; // skip the same index
                } else {
                    if (students[j].getName().equals(name)) {
                        System.out.println("Duplicates found");
                        return true;
                    }
                }
            }
        }
        System.out.println("Duplicates NOT found");
        return false;
    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        Student [] expandedArray = new Student[students.length+1];

        for(int i =0; i<students.length; i++){
            expandedArray[i] = students[i];
        }
        expandedArray[students.length] = newStudent;

        return expandedArray;
    }

    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students
        Student[] arr= new Student[5];

        //initializing students
        Student student1 = new Student(1, "Amal");
        Student student2 = new Student(2, "Ahmed", 19);
        Student student3 = new Student(3, "Nour", 20, 16);
        Student student4 = new Student(4, "Rhita", 19);
        Student student5 = new Student(5, "Kenza", 14, 19);

        // adding students to arr
        arr[0] = student1;
        arr[1] = student2;
        arr[2] = student3;
        arr[3] = student4;
        arr[4] = student5;

        // Print all
        System.out.println("== All Students ==");
        for (Student s : arr) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        // 2) Oldest
        System.out.println("The oldest student is: " + findOldest(arr));

        // 3) Count adults
        System.out.println("The number of adult students is: " + countAdults(arr));

        // 4) Average grade
        System.out.println("The average grade is: " + averageGrade(arr));

        // 5) Find by name
        String name = "Rhita";
        System.out.println("The student whit name " + name + ": " + findStudentByName(arr, name));

        // 6) Sort by grade desc
        sortByGradeDesc(arr);
        // sort function
        System.out.println("\n== Sorted by grade (desc) ==");
        for (Student s : arr) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(arr);

        // 8) Update grade by id
        // function
        Student updated = student2;
        updateGrade(arr, updated.getId(),20);
        System.out.println("\nUpdated " + updated);
        System.out.println(findStudentByName(arr, "Dina"));

        // 9) Duplicate names
        hasDuplicateNames(arr);

        // 10) Append new student
        Student student6 = new Student(6, "Dina", 20, 12);
        Student[] newArray = appendStudent(arr, student6);
        for (Student s : newArray) System.out.println(s);

        // 11) 2D array to represent classes and its students
        Student[][] arr_2D = new Student[2][3];
        //class 1
        arr_2D[0][0] = student1;
        arr_2D[0][1] = student2;
        arr_2D[0][2] = student3;
        //class 2
        arr_2D[1][0] = student4;
        arr_2D[1][1] = student5;
        arr_2D[1][2] = student6;
        int i =1;
        for(Student [] c : arr_2D){
            System.out.println("Students of class " + i + ":");
            for(Student s: c){
                System.out.println(s);
            }
            i++;
        }

        // Finding the top student in each class
        int j =1;
        for(Student [] c : arr_2D){
            System.out.println("Top Student of class " + j + ":");
            int maxGrade = 0;
            Student topS = null;
            for(Student s: c){
                if(s.getGrade() > maxGrade){
                    topS = s;
                    maxGrade = s.getGrade();
                }
            }
            System.out.println(topS);
            j++;
        }

    }
}

