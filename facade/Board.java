package facade;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import domain.Administration;
import domain.ReadCSV;
import domain.Student;

// API gives the Backend all the Data from the UI
public class Board {
    
    private Administration admin;
    private ReadCSV readCsv;
    private ArrayList<Student> student;
    public Board() throws FileNotFoundException{
    }
    
    public void addStudentToSchool(String name,String forename,String faculty, String course, int year){   
        admin = new Administration();
        admin.addStudent(name,forename,faculty,course,year);
    }

    public ArrayList<Student> getStundents() throws FileNotFoundException{
        readCsv = new ReadCSV();
        return readCsv.getStudents();
    }

    public void editStudent(int index, String editetStudent, String toChangeName) throws FileNotFoundException{
        readCsv = new ReadCSV();
        readCsv.editStudent(index,editetStudent, toChangeName);
    }

    public void deleteStudent(int toDeleteStudent, String name) throws FileNotFoundException {
         readCsv = new ReadCSV();
         readCsv.deleteStudent(toDeleteStudent, name);
    }

}// mit der lsite arbeiten an richtige stelle speichern immer die ganze liste als CSV speichern ist ok 
