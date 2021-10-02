package com.kodluyoruz.Q3;

public class Test {

    public static void main(String[] args) {

        Student student1 = new Student("Berk", 5005, 2.94, (new PersonalData(1999,1,1,1)));
        Student student2 = new Student("Ahmet", 5001, 2.94, (new PersonalData(1998,1,1,1)));
        Student student3 = new Student("Ayse", 5002, 2.94, (new PersonalData(2000,1,1,1)));
        Student student4 = new Student("Tuncer", 5003, 2.94, (new PersonalData(2002,1,1,1)));
        Student student5 = new Student("Fatma", 5004, 2.94, (new PersonalData(2001,1,1,1)));

        Course course = new Course("K129", 3);
        course.addStudent(student1);
        course.addStudent(student2);
        course.addStudent(student3);
        course.addStudent(student4);

        course.list();

        course.increaseCapacity();
        course.addStudent(student4);
        course.addStudent(student5);

        course.list();

        course.dropStudent(student1);
        course.list();

        System.out.println(course.getNumberOfStudent());
        System.out.println(course.getBestStudent().getPd().getBirthDate().getYear());

        Course course2 = new Course("K130");
        for (int i = 0; i < course.getNumberOfStudent(); i++){
            course2.addStudent(course.getStudents()[i]);
        }

        course.clear();
        course.list();
        course2.list();
        course2.dropStudent(course2.getBestStudent());
        course2.list();

        System.out.println(course2.getYoungestStudent().getGpa());
    }

}

