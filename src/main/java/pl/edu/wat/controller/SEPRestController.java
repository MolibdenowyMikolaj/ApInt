package pl.edu.wat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.edu.wat.model.Zolnierz;
import pl.edu.wat.service.UserService;

@RestController
public class SEPRestController {

    @Autowired
    UserService userService;  //Service which will do all data retrieval/manipulation work

    //-------------------Retrieve All Users--------------------------------------------------------
    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<List<Zolnierz>> listAllUsers() {
        List<Zolnierz> users = userService.findAllUsers();
        if (users.isEmpty()) {
            return new ResponseEntity<List<Zolnierz>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Zolnierz>>(users, HttpStatus.OK);
    }

    //-------------------Retrieve Single User--------------------------------------------------------
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Zolnierz> getUser(@PathVariable("id_zolnierza") int id) {
        System.out.println("Fetching User with id " + id);
        Zolnierz user = userService.findById(id);
        if (user == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Zolnierz>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Zolnierz>(user, HttpStatus.OK);
    }

    //------------------- Update a User --------------------------------------------------------
    @RequestMapping(value = "/user/{id_zolnierza}", method = RequestMethod.PUT)
    public ResponseEntity<Zolnierz> updateUser(@PathVariable("id_zolnierza") int id, @RequestBody Zolnierz user) {
        System.out.println("Updating User " + id);
        Zolnierz currentUser = userService.findById(id);

        if (currentUser == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Zolnierz>(HttpStatus.NOT_FOUND);
        }

        if (currentUser.isL4() == false && currentUser.isL4() != user.isL4()) {
            user.setL4(true);
            user.setPrzepustka(false);
            user.setSluzba(false);
            user.setSzpital(false);
        } else if (currentUser.isPrzepustka() == false && currentUser.isPrzepustka() != user.isPrzepustka()) {
            user.setL4(false);
            user.setPrzepustka(true);
            user.setSluzba(false);
            user.setSzpital(false);
        } else if (currentUser.isSluzba() == false && currentUser.isSluzba() != user.isSluzba()) {
            user.setL4(false);
            user.setPrzepustka(false);
            user.setSluzba(true);
            user.setSzpital(false);
        } else if (currentUser.isSzpital() == false && currentUser.isSzpital() != user.isSzpital()) {
            user.setL4(false);
            user.setPrzepustka(false);
            user.setSluzba(false);
            user.setSzpital(true);
        }
        userService.updateUser(user);
        return new ResponseEntity<Zolnierz>(user, HttpStatus.OK);
    }

}
