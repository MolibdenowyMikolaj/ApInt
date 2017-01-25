package pl.edu.wat.service;

import pl.edu.wat.connection.MySQLConnection;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import pl.edu.wat.model.Zolnierz;

@Service("userService")
public class UserServiceImpl implements UserService{
	
        private static MySQLConnection connect;
	
	private static List<Zolnierz> users;
	
	static{
		users= populateDummyUsers();
	}

        @Override
	public List<Zolnierz> findAllUsers() {
		return users;
	}
	
        @Override
	public Zolnierz findById(long id) {
		for(Zolnierz user : users){
			if(user.getId_zolnierza()== id){
				return user;
			}
		}
		return null;
	}
	
        @Override
	public Zolnierz findByName(String name) {
		for(Zolnierz user : users){
			if(user.getImie().equalsIgnoreCase(name)){
				return user;
			}
		}
		return null;
	}
	
        @Override
	public void saveUser(Zolnierz user) {
		int max=0;
                for(Zolnierz z:users){
                    if(max<z.getId_zolnierza()) max=z.getId_zolnierza();
                }
                user.setId_zolnierza(max+1);
		users.add(user);
	}

        @Override
	public void updateUser(Zolnierz user) {
		int index = users.indexOf(user);
                System.out.println(user.toString());
		users.set(index, user);
                connect.update(user);
        }

        @Override
	public void deleteUserById(long id) {
		
		for (Iterator<Zolnierz> iterator = users.iterator(); iterator.hasNext(); ) {
		    Zolnierz user = iterator.next();
		    if (user.getId_zolnierza()== id) {
		        iterator.remove();
		    }
		}
	}

        @Override
	public boolean isUserExist(Zolnierz user) {
		return findByName(user.getImie())!=null;
	}
	
        @Override
	public void deleteAllUsers(){
		users.clear();
	}

	private static List<Zolnierz> populateDummyUsers(){
                connect = new MySQLConnection();
                
		return connect.getAllData();
	}

}
