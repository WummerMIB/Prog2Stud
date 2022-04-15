package ui;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import domain.Student;
import facade.Board;

public class UI {

    private Scanner sc;
    private Board board;
    
    public UI() throws FileNotFoundException{
        this.sc = new Scanner(System.in);
        board = new Board();
        this.startMenu();
    }
    
    // there the programm Starts
    private void startMenu() throws FileNotFoundException{

        do{
        System.out.println("Möschten Sie einen neuen Studenten anlegen, Liste anshen, änder oder löschen");
        System.out.println("1: Neuer Student anlegen");
        System.out.println("2: Liste von Studenten ansehen");
        System.out.println("3: Studentendaten ändern");
        System.out.println("4: Student löschen");
        System.out.println("9: Das Programm beenden");
        int input = Integer.parseInt(sc.nextLine());
        System.out.println();
        if (input == 1) {
            newStudent();
        }
        if (input == 2){
            showListOfStundents();
        }

        if(input == 3){
            editStudent();
        }

        if(input == 4){
            deleteStudent();
        }

        if(input == 5){
            createprufung();
        }

        if(input == 6){
            registerStudentToTest();
        }

        if(input == 9){
            System.out.println("Vielen Dank fürs benutzen der App");
            break;
        }

        }while(true);
    }

    // method to delete a student give two Parameter to the Board API Board rowToDelete number to search an array of students
    // and name to identify this line
    public void deleteStudent() throws FileNotFoundException{
        System.out.println("Bitte geben sie die Zeile ein die sie löschen wollen");
        int rowToDelete = Integer.parseInt(sc.nextLine());
        System.out.println("Bitte geben sie den namen ein der in der Reihe steht");
        String name = sc.nextLine();
        board.deleteStudent(rowToDelete-1,name);       
    }


    // methode to edit student gives three Paramteres to the API Board input is a number where to change it editStudent 
    // is the new Student and i use changeStudent to delete the old one and replace them with the new data 
    private void editStudent() throws FileNotFoundException {
        System.out.println("Geben sie ein in welcher Reihe sie den studenten ändern möschten");
        int input = Integer.parseInt(sc.nextLine());
        System.out.println("Bitte geben sie denn Namen der Person ein denn die ändern wollen");
        String toChangeName = sc.nextLine();
        System.out.println("Schreiben Sie denn neuen Namen");
        String name = sc.nextLine();
        System.out.println("Schreiben Sie denn neuen Nachnamen");
        String forename = sc.nextLine();
        System.out.println("Schreiben Sie denn Namen der neuen Fakultät auf");
        String faculty = sc.nextLine();
        System.out.println("Schreiben Sie denn Namen des neuen Kurs auf");
        String course = sc.nextLine();
        System.out.println("Geben sie ein neues Semesterzahl ein");
        int year = Integer.parseInt(sc.nextLine());
        String editStudent = name+","+forename+","+faculty+","+course+","+year+","+"0";
        board = new Board();
        board.editStudent(input-1, editStudent,toChangeName);
    }

    // method to create a new Student
    private void newStudent() throws FileNotFoundException{
        System.out.println("1: Neuer Student anlegen");
        System.out.println("Gib den Namen des Studendenden ein");
        String name = sc.nextLine();
        System.out.println("Gib den Nachnamen des Studendenden ein");
        String forename = sc.nextLine();
        System.out.println("Gib die Fakultät  des Studendenden ein");
        String faculty = sc.nextLine();
        System.out.println("Gib den Kurs des Studendenden ein");
        String course = sc.nextLine();
        System.out.println("Gib das Semesterjahr des Studendenden ein");
        int year = Integer.parseInt(sc.nextLine());
        board = new Board();
        board.addStudentToSchool(name,forename,faculty,course,year);
    }

    private void showListOfStundents() throws FileNotFoundException{
        board = new Board();
        ArrayList<Student> studArrayList = board.getStundents();
        for(int i = 0; i<studArrayList.size();i++){
        //studArrayList get the Student an add it to theString to show it correct 
        System.out.println(studArrayList.get(i).toString());
        }
    }

    private void createprufung(){

    }

    private void registerStudentToTest(){

    }
}
