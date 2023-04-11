package org.example.services;

import org.example.models.Categories;
import org.example.models.Users;
import org.example.repository.ILibraryRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService implements ILibraryService<Users>{
    private ILibraryRepository<Users> usersRepository;

    public UsersService(ILibraryRepository<Users> usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public Users create(Users users) throws Exception {
        try {
            List<Users> users1 = usersRepository.findAll();
            if(users1.stream().anyMatch(existingCategory -> existingCategory.getFull_name().equalsIgnoreCase(users.getFull_name()))){
                throw new DataIntegrityViolationException("User Already Exist");
            }
            usersRepository.create(users);
            System.out.println("Create User Success");
            return users;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Users> findAll() throws Exception {
        try {
            List<Users> users = usersRepository.findAll();
            if(users.isEmpty()){
                throw new Exception("Data User Not Found!");
            }
            return usersRepository.findAll();
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Users> findById(String id) throws Exception {
        try {
            List<Users> users = usersRepository.findById(id);
            if(users.isEmpty()){
                throw new Exception("ID Not Found");
            }
            return usersRepository.findById(id);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void delete(String id) throws Exception {
        try {
            List<Users> users = usersRepository.findById(id);
            if(users.isEmpty()){
                throw new Exception("ID Not Found");
            }
            usersRepository.delete(id);
            System.out.println("Delete Success");
        } catch (Exception e){
            throw new Exception();
        }
    }

    @Override
    public void update(Users users, String id) throws Exception {
        try {
            List<Users> users1 = usersRepository.findById(id);
            if(users1.isEmpty()){
                throw new Exception("ID Not Found");
            }
            List<Users> usersUpdate = usersRepository.findAll();
            if(usersUpdate.stream().anyMatch(existingUser -> existingUser.getFull_name().equalsIgnoreCase(users.getFull_name()))){
                throw new DataIntegrityViolationException("User Already Exist");
            }
            Users existUser = users1.get(0);
            existUser.setFull_name(users.getFull_name());
            usersRepository.update(users, id);
            System.out.println("Update Success");
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
