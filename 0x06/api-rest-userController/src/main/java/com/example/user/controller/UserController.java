package com.example.user.controller;

import com.example.user.exception.CPFException;
import com.example.user.exception.UserIdException;
import com.example.user.exception.UserNameException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

//    GET => /api-user/users/user-id/{id}: Responsável por validar o id do usuário
    @GetMapping("/user-id/{id}")
    public String findUserById(@PathVariable int id) {
        String msg = "";

        if (id > 0 && id < 100) {
            msg = "You have entered valid ID";
        } else {
            throw new UserIdException();
        }
        // TODO
        return msg;
    }

    //    GET => /api-user/users/user-name/{username}: Responsável por validar o username do usuário
    @GetMapping("/user-name/{userName}")
    public String findUserByName(@PathVariable String userName) {
        String msg = "";

        if (userName.length() > 3 && userName.length() < 15) {
            msg = "You have entered valid USERNAME";
        } else {
            throw new UserNameException();
        }

        return msg;
    }

    //    GET => /api-user/users/user-cpf/{cpf}:: Responsável por validar o cpf do usuário
    @GetMapping("/user-cpf/{cpf}")
    public String findUserByCPF(@PathVariable String cpf) {

        String msg = "";
        boolean isCPFValid = isCPF(cpf);

        if (isCPFValid) {
            msg = "You have entered valid CPF";
        } else {
            throw new CPFException();
        }

        return msg;

    }

    public boolean isCPF(String CPF) {
        return (CPF.length() > 3 && CPF.length() < 15);
    }

}
