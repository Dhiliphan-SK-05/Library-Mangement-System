import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private int id;
    public String title;
    public String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nTitle: " + title + "\nAuthor: " + author;
    }
}

class Library {
    private ArrayList<Book> books;
    private int bookIdCounter;

    public Library() {
        books = new ArrayList<>();
        bookIdCounter = 1;
    }

    public void addBook(String title, String author) {
        Book book = new Book(bookIdCounter, title, author);
        books.add(book);
        bookIdCounter++;
        System.out.println("Book added successfully!");
    }

    public void updateBook(int id, String newTitle, String newAuthor) {
        for (Book book : books) {
            if (book.getId() == id) {
                book.title = newTitle;
                book.author = newAuthor;
                System.out.println("Book updated successfully!");
                return;
            }
        }
        System.out.println("Book not found with ID: " + id);
    }

    public void searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("\nBook Found:\n" + book);
                return;
            }
        }
        System.out.println("Book not found with title: " + title);
    }

    public void deleteBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                books.remove(book);
                System.out.println("Book deleted successfully!");
                return;
            }
        }
        System.out.println("Book not found with ID: " + id);
    }

    public void listBooks() {
        System.out.println("\nList of Books:");
        for (Book book : books) {
            System.out.println("\n" + book);
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Update Book");
            System.out.println("3. Search Book");
            System.out.println("4. Delete Book");
            System.out.println("5. List Books");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    library.addBook(title, author);
                    break;
                case 2:
                    System.out.print("Enter book ID to update: ");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new author: ");
                    String newAuthor = scanner.nextLine();
                    library.updateBook(idToUpdate, newTitle, newAuthor);
                    break;
                case 3:
                    System.out.print("Enter book title to search: ");
                    String titleToSearch = scanner.nextLine();
                    library.searchBook(titleToSearch);
                    break;
                case 4:
                    System.out.print("Enter book ID to delete: ");
                    int idToDelete = scanner.nextInt();
                    library.deleteBook(idToDelete);
                    break;
                case 5:
                    library.listBooks();
                    break;
                case 6:
                    System.out.println("Thank you for using the Library Management System!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
