package com.felipe.escalabt.services;

import com.felipe.escalabt.persistence.entities.User;
import com.felipe.escalabt.persistence.repositories.IUserRepository;
import com.felipe.escalabt.utils.customexceptions.MyResourceNotFoundException;
import com.felipe.escalabt.utils.customexceptions.MyUserAlreadyExistException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor

@Service
public class UserServiceImpl implements IUserService{
    private IUserRepository repository;

    @Override
    public List<User> getUsers(){
        return repository.findAll();
    }

    @Override
    public User getUserByEmail(String email){
        return repository.findByEmail(email)
                .orElseThrow(() -> new MyResourceNotFoundException("Usuario " + email + " no encontrado"));
    }
    @Override
    public User createUser(User user){

        String email = user.getEmail();

        if( repository.findByEmail(email).isPresent() ){
            throw new MyUserAlreadyExistException("Ya existe un usuario con esta direccion de correo.");
        }

        user.setId(UUID.randomUUID().toString());
        user.setActive(true);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        return repository.save(user);
    }

    @Override
    public void deleteUser(String email) {
        User user = this.getUserByEmail(email);
        user.setActive(false);
        repository.save(user);

        /*
        Optional <User>user = repository.findByEmail(email);
        if (user.isPresent()){
            repository.delete(user.get());
        }else{
            throw new MyResourceNotFoundException("Este usuario no existe");
        }
        */
    }

    @Override
    public User updateUser(String email, User user) {

        User userFound = this.getUserByEmail(email);

        if(!userFound.isActive()){
            throw new IllegalArgumentException("No se puede editar un usuario eliminado");
        }

        userFound.setName(user.getName());
        userFound.setPassword(user.getPassword());
        userFound.getTelephones().clear();
        userFound.getTelephones().addAll(user.getTelephones());
//        userFound.setTelephones(user.getTelephones());

        return repository.save(userFound);
    }

}
