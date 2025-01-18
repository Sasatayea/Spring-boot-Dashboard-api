package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.MoveRepository;
import com.luv2code.springboot.cruddemo.entity.move;
import com.luv2code.springboot.cruddemo.error.DaplicateRecoredException;
import com.luv2code.springboot.cruddemo.error.RecoredNotFoundExecption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OmdbApiServiceImpl implements OmdbApiService{

    private MoveRepository moveRepository;

    @Autowired
    public OmdbApiServiceImpl(MoveRepository theMoveRepository) {
        moveRepository = theMoveRepository;
    }

    private static String OMDB_URL ="https://www.omdbapi.com/?apikey=9f220ade&";


    @Override
    public List<move> findAll() {
        return moveRepository.findAll();
    }

    @Override
    public move findByTitleApi(String title) {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity <move> theMove = restTemplate.getForEntity(OMDB_URL+"t="+title, move.class);

        move newMove;

        if(theMove.getBody().getImdbID() != null){
            newMove = theMove.getBody();
        }else {
            throw new RecoredNotFoundExecption("This Record with title:-  " + title +" not found");
        }

        return newMove;
    }

    @Override
    public move findByIdDb(String Id) {
        return moveRepository.findByImdbID(Id);
    }

    @Override
    public move getMovieByTitle(String title) {
        return moveRepository.findByTitleDb(title);
    }

    @Override
    public move findById(String id) {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity <move> theMove = restTemplate.getForEntity(OMDB_URL+"i="+id, move.class);

        move newMove;

        if(theMove.getBody().getImdbID() != null){
            newMove = theMove.getBody();
        }else {
            throw new RecoredNotFoundExecption("This Record with id:-  " + id +" not found");
        }

        return newMove;
    }

    @Override
    public move insert(String title) {

        move theMove = findByTitleApi(title);

        move TheMoveDb = getMovieByTitle(title);

        move newMove;

        if(TheMoveDb != null && !TheMoveDb.getImdbID().isEmpty()) {
            throw new DaplicateRecoredException("This Record with title:-  " + title +" already exists");
        }else {
            System.out.println("the move added to the database");
            newMove = theMove;
        }
//        if(theMove.getImdbID() != null && !theMove.getImdbID().isEmpty()) {
//            System.out.println("the move added to the database");
//            newMove = theMove;
//        }else {
//            throw new DaplicateRecoredException("This Record with title:-  " + title +" already exists");
//        }


        return moveRepository.save(newMove);
    }

    @Override
    public void deleteById(String theId) {

        move theMove  = findById(theId);
        move newMove;

        if(theMove.getImdbID() != null){
            newMove = theMove;
        }else {
            throw new RecoredNotFoundExecption("This Record with id:-  " + theId +" not found");
        }
        moveRepository.deleteByImdbID(theId);
    }

    public Page<move> GatAllMoviePageable(int pageNum, int pageSize) {

        Pageable page = PageRequest.of(pageNum,pageSize);

        return moveRepository.GatAllMoviePageable(page);
    }
}
