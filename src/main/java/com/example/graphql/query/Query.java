package com.example.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphql.model.Author;
import com.example.graphql.model.Book;
import com.example.graphql.repository.AuthorRepository;
import com.example.graphql.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Query class implements the GraphQLQueryResolver interface
 * @author Dipanjan Paul
 */
@Component
public class Query implements GraphQLQueryResolver {

    private final AuthorRepository authorRepository;

    private final BookRepository bookRepository;

    @Autowired
    public Query(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    /**
     * findAllAuthor calls the findAll method from repository
     * @return iterator of type Author
     */
    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    /**
     * findAllTutorials calls the findAll method from repository
     * @return iterator of type Book
     */
    public Iterable<Book> findAllBook() {
        return bookRepository.findAll();
    }

    /**
     * countAuthors call the count from repository
     * @return long
     */
    public long countAuthors() {
        return authorRepository.count();
    }

    /**
     * countTutorial calls the count from repository
     * @return long
     */
    public long countBook() {
        return bookRepository.count();
    }
}