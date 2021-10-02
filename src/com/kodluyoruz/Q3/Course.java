package com.kodluyoruz.Q3;

public class Course {

    private String name;
    private Student[] students;
    private int capacity;
    private int numberOfStudent;

    public Course(String name){
        this.name = name;
        this.capacity = 40;
        students = new Student[this.capacity];
    }

    public Course(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        students = new Student[this.capacity];
    }

    public int getNumberOfStudent() {
        return numberOfStudent;
    }

    public String getCourseName() {
        return name;
    }

    public Student[] getStudents() {
        return students;
    }

    public boolean addStudent(Student student){

        if (getNumberOfStudent() >= this.capacity){

            System.out.println("There isn't enough capacity.");
            return false;

        }

        if (getNumberOfStudent()>0){
            for (int i = 0; i < getNumberOfStudent(); i++){
                if (students[i].getId() == student.getId()){
                    System.out.println("The student already took this course.");
                    return false;
                }
            }
        }


        students[getNumberOfStudent()] = student;
        System.out.println("The student successfully took the course.");
        this.numberOfStudent++;
        return true;
    }

    public boolean dropStudent(Student student){

        int index = -1;

        if (students == null)
            return false;

        Student[] temp = new Student[this.capacity];

        for(int i=0;i<getNumberOfStudent();i++) {

            if(students[i].getId()==student.getId()) {
                index=i;
                break;
            }

        }

        if (index < 0){
            System.out.println("Student cant found.");
            return false;
        }
        else if (index == 0){
            for (int i = 1; i < getNumberOfStudent(); i++){
                temp[i-1] = students[i];
            }
        }
        else{
            for(int i=0 ; i < index; i++) {
                temp[i]=students[i];
            }
            for(int i = index+1 ; i < getNumberOfStudent() ; i++) {
                temp[i] = students[i];
            }
        }

        students = temp;
        this.numberOfStudent--;
        return true;

    }

    public void increaseCapacity(){
        this.capacity+=5;

        Student[] temp = new Student[this.capacity];
        for (int i = 0; i < students.length; i++){
            temp[i] = students[i];
        }
        students = temp;
    }

    public Student getBestStudent(){

        Student bestGPA = students[0];

        for (int i = 1; i < getNumberOfStudent(); i++){
            if (students[i].getGpa() > bestGPA.getGpa()){
                bestGPA = students[i];
            }
        }

         return bestGPA;

    }

    public Student getYoungestStudent(){

        Student youngest = students[0];

        for (int i = 1; i < this.getNumberOfStudent(); i++){
            if (students[i].getPd().getBirthDate().compareTo(youngest.getPd().getBirthDate()) < 0){
                youngest = students[i];
            }
        }

        return youngest;

    }

    public void clear(){

        students = null;
        this.numberOfStudent = 0;

    }

    public void list(){

        if (this.getNumberOfStudent() != 0){

            for (int i = 0; i < getNumberOfStudent(); i++){
                System.out.println(students[i].toString());
            }

        }
        else{
            System.out.println("This course have 0 student.");
        }

    }

    @Override
    public String toString(){
        return "Name: " + this.name + " Number of students: " + this.numberOfStudent;
    }
}
