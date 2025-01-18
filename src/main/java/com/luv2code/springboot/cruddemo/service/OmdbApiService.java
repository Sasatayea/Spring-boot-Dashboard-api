package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.move;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OmdbApiService {

    List<move> findAll();

    move findByTitleApi(String title);

    move findByIdDb(String title);

    move getMovieByTitle(String title);

    move findById(String id);

    move insert(String title);

    void deleteById(String theId);

    Page<move> GatAllMoviePageable(int pageNum, int pageSize);
}
