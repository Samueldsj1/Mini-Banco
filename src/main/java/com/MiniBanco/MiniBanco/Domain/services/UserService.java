package com.MiniBanco.MiniBanco.Domain.services;

import com.MiniBanco.MiniBanco.Domain.controller.UserController;
import com.MiniBanco.MiniBanco.Domain.repository.UserRepository;
import com.MiniBanco.MiniBanco.Domain.user.User;
import com.MiniBanco.MiniBanco.Domain.user.UserDTO;
import com.MiniBanco.MiniBanco.Domain.user.UserType;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public void saveUser(User user){
        this.repository.save(user);

    }
    public User createUser(UserDTO user) {
        User newUser = new User(user);
        this.saveUser(newUser);
        return  newUser;
    }
    public  List<User> getAllUsers(){
        return this.repository.findAll();
    }
    public User findUserById(Long id) throws Exception {
        return this.repository.findById(id).orElseThrow(() -> new Exception("Usuário Não encontrado!"));
    }

    public boolean validateUser(User payer, BigDecimal amount) throws Exception {
        if (payer.getUserType()== UserType.MERCHANT){
            throw new Exception("Um usuário lojista não pode realizar transações.");
        }
        if (payer.getBalance().compareTo(amount) <0){
            throw new Exception("Saldo Insuficiente.");
        }
            return true;
    }
}
