import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

public class Student{

    private String name; 

    public Student(String name){
        this.name = name;
    }

    public void setStudentName(String name){
        this.name = name;
    }

    public String getStudentName(){
        return name;

    }

    private List<Book> books = new ArrayList<Book>();        
    
    public void setBook(String name, int publishingDate, int numberOfPages){
        Book book = new Book(name, publishingDate, numberOfPages);
        books.add(book);
    }

    public Student sortBooks(){
        Collections.sort(books, (p1, p2)->Integer.compare(p1.getPages(), p2.getPages()));
        return this;
    }

    public List<Book> getBookList(){
        System.out.println(name + "'s books:");
        return books;
    }

    public Optional<String> isBookPresent(int year){
        Optional<String> optionalWithoutValue = Optional.of("\tBook not found for " + name + "!");

        for(int i = 0; i < books.size(); i++){
            if(books.get(i).publishingDate == year){
                 Optional<String> optionalWithValue = Optional.of(books.get(i).toString() + ", owner: " + name);
                 return optionalWithValue;
            }
        }
        return optionalWithoutValue;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        return sb.toString();
    }
}