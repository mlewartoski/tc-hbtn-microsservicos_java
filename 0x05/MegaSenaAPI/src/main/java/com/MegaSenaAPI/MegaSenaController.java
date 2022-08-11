package com.MegaSenaAPI;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(value="/megasena")
public class MegaSenaController {

    @GetMapping("/simpleMessageWelcome")
    public String mensagemBoasVindas() {
        return "Bem vindo a API REST para geração de números para a loteria Mega Sena.";
    }


    @GetMapping("/getNumbers")
    public List<Integer> numerosMegaSena() {
        List<Integer> numeros = new ArrayList<>();
        Random rand = new Random();
        int limite = 60;
        int int_random;

        while (numeros.size() < 6) {
            int_random = rand.nextInt(limite)+1;
            if (!numeros.contains(int_random)){
                numeros.add(int_random);
            }
        }

        numeros.sort(Collections.reverseOrder());

        return numeros;
    }
}