package domain;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;


public class Administration {



    public Administration(){}


    // creates new Students and saves it in a new File or if the file exist in that existing file
    public void addStudent(String name,String forename,String faculty, String course, int year){   
        try {    
            int helper = 0;
            Student stud = new Student(name, forename, faculty, course, year, helper); 
            PrintWriter newStudent = null;
            File studentFile = new File("resources/students.csv");
            if(!studentFile.exists()){
                studentFile.createNewFile();
            }
            newStudent = new PrintWriter(new FileOutputStream(studentFile, true));
            newStudent.printf(stud.getName()+","+ stud.getForename()+","+stud.getFaculty()+","+stud.getCourse()+","+stud.getSemesterYear()+","+stud.getMtkNumber()+"\n");            
            newStudent.close();
            
        } catch (Exception e) {
            System.err.println("Cant create file");
        }
    }

}
