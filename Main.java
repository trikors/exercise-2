import java.nio.file.*;
import java.util.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String pathString = System.getProperty("user.dir") + "/data.txt";
        Path pathFile = Paths.get(pathString);
        List<String> data = new ArrayList<String>();

        if(Files.exists(pathFile)){
            try{
                data = Files.readAllLines(pathFile);
            } catch(IOException e){
                System.out.println("IO Exception happened!");
                e.printStackTrace();
            }
        }

        List<Student> students = new ArrayList<Student>();

        for(int i = 0; i < data.size(); i++){
            String[] line = data.get(i).toString().split(";");

            if(line.length < 6 )
                continue;

            String studentName = line[1].trim();
            String bookName = line[3].trim();
            int publishingDate = Integer.parseInt(line[4].trim());
            int pageCount = Integer.parseInt(line[5].trim());

            boolean newStudent = true;

            for(int j = 0; j < students.size(); j++){
                if(students.get(j).getStudentName().equals(studentName)){
                    students.get(j).setBook(bookName, publishingDate, pageCount);
                    newStudent = false;
                    break;
                }
            }
            if(newStudent){
                Student student = new Student(studentName);
                student.setBook(bookName, publishingDate, pageCount);
                students.add(student);
            }
        }
  
        //print out names
        students.stream().forEach(System.out::println);
        System.out.println("*".repeat(70));

        //print out books
        students.stream().forEach(i -> i.sortBooks().getBookList().stream().filter(book -> book.publishedAfter(2000)).limit(3).forEach(System.out::println));
        System.out.println("*".repeat(70));

        //get books by year
        int year = 2004;
        students.stream().forEach(student -> student.isBookPresent(year).ifPresent(value->System.out.println(value.toString())));

    }
}

//a minor change for the Pull request
