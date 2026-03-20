public class Book {
    public String name;
    public int publishingDate;
    public int numberOfPages;

    public Book(String name, int publishingDate, int numberOfPages){
        this.name = name;
        this.publishingDate = publishingDate;
        this.numberOfPages = numberOfPages;
    }

    public boolean publishedAfter(int year){
        return publishingDate >= year;
    }

    public int getPages(){
        return this.numberOfPages;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\t");
        sb.append(name + ", published on: ");
        sb.append(publishingDate + ", has number of pages: ");
        sb.append(numberOfPages);
        return sb.toString();
    }
}

//a minor change for the Pull request

