package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.UserRepository;
import com.luv2code.springboot.cruddemo.entity.Users;
import com.luv2code.springboot.cruddemo.error.DaplicateRecoredException;
import com.luv2code.springboot.cruddemo.error.RecoredNotFoundExecption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MessageSource messageSource ;

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository theUserRepository) {
        userRepository = theUserRepository;
    }


    @Override
    public List<Users> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Users findById(int theId) {

        Optional<Users> result = userRepository.findById(theId);

        Users theUser ;

        if (result.isPresent()) {
            theUser = result.get();
        } else {
//            String [] msgParam = {String.valueOf(theId)} ;
//            String msg =  messageSource.getMessage("validation.recoredNotFound.message", msgParam , LocaleContextHolder.getLocale());
            throw new RecoredNotFoundExecption("This Record with id:-  " + theId +" not found");
        }

        return theUser;
    }

    @Override
    public ResponseEntity<?> insert(Users entity) {

        if (!entity.getEmail().isEmpty() && entity.getEmail() != null) {

            Users theUser = findByEmail(entity.getEmail());

            if(theUser != null) {
//                String [] msgParam = {entity.getEmail()} ;
//                String msg =  messageSource.getMessage("validation.DaplicateRecoredExeption.message", msgParam , LocaleContextHolder.getLocale());
                throw new DaplicateRecoredException("This email is already exist :-"+theUser.getEmail());
            }
        }

        String EncoderPass = new BCryptPasswordEncoder().encode(entity.getPassword());

        entity.setPassword(EncoderPass);

        return ResponseEntity.ok( userRepository.save(entity));
    }

    @Override
    public Users update(Users theUser) {
        userRepository.save(theUser);
        return theUser;
    }

    @Override
    public void deleteById(int theId) {
        Optional<Users> result = userRepository.findById(theId);

        Users theUser ;

        if (result.isPresent()) {
            theUser = result.get();
        } else {
//            String [] msgParam = {String.valueOf(theId)} ;
//            String msg =  messageSource.getMessage("validation.recoredNotFound.message", msgParam , LocaleContextHolder.getLocale());
            throw new RecoredNotFoundExecption("This Record with id:-  " + theId +" not found");
        }
        userRepository.deleteById(theId);
    }

    @Override
    public Users findByEmail(String theEmail) {
        return userRepository.findByEmail(theEmail);
    }

    @Override
    public ResponseEntity<?> Login(String email, String password) {

        try {
            Users user1 = findByEmail(email);

            String DbPassword = user1.getPassword();

            if(passwordEncoder.matches(password ,DbPassword)){
                return ResponseEntity.ok(user1 );
            }else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password.");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Invalid email or password.");
        }



    }
}
