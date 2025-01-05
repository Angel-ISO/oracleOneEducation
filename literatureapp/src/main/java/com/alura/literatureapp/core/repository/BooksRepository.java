package com.alura.literatureapp.core.repository;

import com.alura.literatureapp.core.entity.Books;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BooksRepository extends BaseRepository<Books, Long> {


    @Query("SELECT B FROM Books  B  WHERE B.title = :title")
    List<Books> findBooksByTitle(@Param("title") String title);

}