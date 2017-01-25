package pl.edu.wat.service;

import java.util.List;

import pl.edu.wat.model.Zolnierz;



public interface UserService {
	
	Zolnierz findById(long id);
	
	Zolnierz findByName(String name);
	
	void saveUser(Zolnierz user);
	
	void updateUser(Zolnierz user);
	
	void deleteUserById(long id);

	List<Zolnierz> findAllUsers(); 
	
	void deleteAllUsers();
	
	public boolean isUserExist(Zolnierz user);
	
}
