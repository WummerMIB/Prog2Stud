package domain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadCSV {

    private static final Object[] String = null;
    private ArrayList<Student> student;

    public ReadCSV() throws FileNotFoundException{
        student = new ArrayList<>();
        
        Scanner sc = new Scanner(new File("resources/students.csv"));

        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] es = line.split(",");
            Student s = new Student(es[0],es[1],es[2],es[3],Integer.parseInt(es[4]),Integer.parseInt(es[5]));
            student.add(s);
        }
        sc.close();
    }

    public ArrayList<Student> getStudents(){
        return student;
    }

    // edit Student is to delete the row of the Student because you cant change a String on a point an replace it with the 
    // changed Data
    public void editStudent(int index, String editetStudent, String toChangeName){
        try {
            String[] es = editetStudent.split(",");
            deleteStudent(index, toChangeName);
            Student s = new Student(es[0],es[1],es[2],es[3],Integer.parseInt(es[4]),Integer.parseInt(es[5]));
            PrintWriter newStudent = null;
            File studentFile = new File("resources/students.csv");
            if(!studentFile.exists()){
                studentFile.createNewFile();
            }
            newStudent = new PrintWriter(new FileOutputStream(studentFile, true));
            newStudent.printf(s.getName()+","+ s.getForename()+","+s.getFaculty()+","+s.getCourse()+","+s.getSemesterYear()+","+s.getMtkNumber()+"\n");            
            newStudent.close();
            
        } catch (Exception e) {
            System.err.println("Cant create file");
        }
        //student.set(index,s);
    }
    // creates new File to delete the student an replaces that line with the one above or not if last student
    // and overrites the old file with the new one
    public void deleteStudent(int toDeleteStudent, String removeLine) {
        int position = toDeleteStudent;
        String tempFile = "resources/temp.csv";
        File oldFile = new File("resources/students.csv");
        File newFile = new File(tempFile);
        String currentLine;
        String data[];

        try {
            FileWriter fw = new FileWriter(tempFile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader("resources/students.csv");
            BufferedReader br = new BufferedReader(fr);
            // problem i delete evithing
            while((currentLine = br.readLine()) != null){
                data = currentLine.split(",");
                if(!(data[position].equalsIgnoreCase(removeLine))){
                    pw.println(currentLine);
                }
            }
            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();

            oldFile.delete();
            File dump = new File("resources/students.csv");
            newFile.renameTo(dump);

        }catch(Exception e){
            System.err.println("Fehler beim löschen");
        }
    }                
}
