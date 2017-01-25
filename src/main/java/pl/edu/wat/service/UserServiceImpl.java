package pl.edu.wat.service;

import java.util.ArrayList;
import pl.edu.wat.connection.MySQLConnection;
import java.util.List;

import org.springframework.stereotype.Service;

import pl.edu.wat.model.Zolnierz;

@Service("userService")
public class UserServiceImpl implements UserService {

    private static MySQLConnection connect;

    private static List<Zolnierz> users;

    static {
        users = createUsers();
    }

    @Override
    public List<Zolnierz> findAllUsers() {
        return users;
    }

    @Override
    public Zolnierz findById(long id) {
        for (Zolnierz user : users) {
            if (user.getId_zolnierza() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void updateUser(Zolnierz user) {
        int index = users.indexOf(user);
        System.out.println(user.toString());
        users.set(index, user);
        connect.update(user);
    }

    private static List<Zolnierz> createUsers() {
        connect = new MySQLConnection();
        return connect.getAllData();
    }

    @Override
    public List<Integer> getAmmount() {
        List<Integer> list = new ArrayList<>();
        int obecni = 0;
        int l4 = 0;
        int sluzba = 0;
        int szpital = 0;
        int przepustka = 0;

        for (Zolnierz z : users) {
            if (z.isL4()) {
                l4++;
            } else if (z.isSluzba()) {
                sluzba++;
            } else if (z.isSzpital()) {
                szpital++;
            } else if (z.isPrzepustka()) {
                przepustka++;
            } else {
                obecni++;
            }
        }

        list.add(obecni);
        list.add(l4);
        list.add(sluzba);
        list.add(szpital);
        list.add(przepustka);
        return list;
    }

}
