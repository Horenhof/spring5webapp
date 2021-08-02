package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.models.Author;
import guru.springframework.spring5webapp.models.Book;
import guru.springframework.spring5webapp.models.Publisher;
import guru.springframework.spring5webapp.repos.AuthorRepository;
import guru.springframework.spring5webapp.repos.BookRepository;
import guru.springframework.spring5webapp.repos.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class BootstrapData implements CommandLineRunner {

    @Autowired
    private AuthorRepository authRepo;
    @Autowired
    private BookRepository bookRepo;
    @Autowired
    private PublisherRepository pubRepo;


    @Override
    public void run(String... args) throws Exception {

        Publisher p = new Publisher("Ahmad Alkurdi", "Helsingforserstr 21", "Berlin", "Berlin", "10243");
        pubRepo.save(p);
        Book book1 = new Book("A Brief History Of Mankind", "1244123142");
        Author auth1 = new Author("Mohn", "Harari");
        auth1.getBooks().add(book1);
        book1.getAuthors().add(auth1);
        book1.setPublisher(p);
        p.getBooks().add(book1);

        authRepo.save(auth1);
        bookRepo.save(book1);

        Book book2 = new Book("Der Gottes Wahn", "1223142");
        Author auth2 = new Author("Richard", "Dawkins");
        auth2.getBooks().add(book2);
        book2.getAuthors().add(auth2);
        book2.setPublisher(p);
        p.getBooks().add(book2);


        authRepo.save(auth2);
        bookRepo.save(book2);
        pubRepo.save(p);

        System.out.println("Books Count : " + bookRepo.count());
        System.out.println("Authors Count : " + authRepo.count());
        System.out.println("Publisher Count : " + pubRepo.count());
        Optional<Publisher> p2 = pubRepo.findById(1L);
        System.out.println("Publisher Books Count: " + p2.get().getBooks().size());
 }
}
