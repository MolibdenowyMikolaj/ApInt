package pl.edu.wat.service;

import java.util.List;

import pl.edu.wat.model.Zolnierz;

public interface UserService {

    Zolnierz findById(long id);

    void updateUser(Zolnierz user);

    List<Integer> getAmmount();

    List<Zolnierz> findAllUsers();

}
