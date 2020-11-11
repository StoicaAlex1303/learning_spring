package com.example.demo1.repositories;

import com.example.demo1.models.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByName(@Param("name") String bookName);
    Book findByAuthor(@Param("author")String bookAuthor);

//    @Modifying
//    @Query("delete from Book b where b.title=:title")
//    void deleteBooks(@Param("title") String title);

}




