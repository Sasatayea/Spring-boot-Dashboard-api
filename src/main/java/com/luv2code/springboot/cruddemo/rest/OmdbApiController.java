package com.luv2code.springboot.cruddemo.rest;


import com.luv2code.springboot.cruddemo.entity.Users;
import com.luv2code.springboot.cruddemo.entity.move;
import com.luv2code.springboot.cruddemo.service.OmdbApiService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/moves")
public class OmdbApiController {

    private OmdbApiService omdbApiService;

    @Autowired
    public OmdbApiController(OmdbApiService omdbApiService) {
        this.omdbApiService = omdbApiService;
    }

    @Operation(summary = "Get All Movies")
    @GetMapping("All")
    public List<move> getMoves() {
        return omdbApiService.findAll();
    }

    @Operation(summary = "Get All Movies Pageable")
    @GetMapping("/pageable")
    public Page<move> getPageableMovies(@RequestParam int pageNum, @RequestParam int pageSize) {
        return omdbApiService.GatAllMoviePageable(pageNum, pageSize);
    }

    @Operation(summary = "Get Movie By ID")
    @GetMapping("/id")
    public ResponseEntity<?> getUserById(@RequestParam String id) {
//        move moves = omdbApiService.findById(id);
//
//        if(moves == null) {
//            throw new RuntimeException("move not found for id: " + id);
//        }
        return ResponseEntity.ok(omdbApiService.findById(id));
    }
    @Operation(summary = "Get Movie By Title")
    @GetMapping("/title")
    public ResponseEntity<?>  getMovieByTitle(@RequestParam String Title) {
        return ResponseEntity.ok(omdbApiService.findByTitleApi(Title));
    }

    @Operation(summary = "Get Movie By Title")
    @GetMapping("/title/db")
    public ResponseEntity<?>  getMovieByTitleDB(@RequestParam String Title) {
        return ResponseEntity.ok(omdbApiService.getMovieByTitle(Title));
    }

    @Operation(summary = "Add a Movie Using Title")
    @PostMapping("/{Title}")
    public ResponseEntity<move> addMovie(@PathVariable String Title) {
        return ResponseEntity.ok(omdbApiService.insert(Title));
    }
    @Operation(summary = "Delete a movie By moveId")
    @DeleteMapping("/{id}")
    public String deleteMovie(@PathVariable String id) {
        omdbApiService.deleteById(id);
        return "Deleted Movie with Title: " + id;
    }
}
