package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.move;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface MoveRepository extends JpaRepository <move, Integer> {

    @Transactional
    void deleteByImdbID(@Param("theId") String theId);

    move findByImdbID(String Id);

    @Query(value = "SELECT * FROM moves mov where mov.Title like :titleName", nativeQuery = true )
    move findByTitleDb(@Param("titleName") String Title);

    @Query(value = "select * from moves ", nativeQuery = true )
    Page<move> GatAllMoviePageable(Pageable pageable);
}
