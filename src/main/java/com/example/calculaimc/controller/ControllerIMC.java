//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.calculaimc.controller;

import java.text.DecimalFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({"/"})
public class ControllerIMC {
    public ControllerIMC() {
    }

    @GetMapping
    public String index() {
        return "index";
    }

    @PostMapping
    public String calculo(@RequestParam double peso, @RequestParam double altura, ModelMap model) {
        double imc = peso / (altura * altura);
        DecimalFormat df = new DecimalFormat("#.##");
        String valIMC = df.format(imc);
        String resultado;
        String mensagem;
        if (imc < (double)18.5F) {
            resultado = "Magreza (-18,5)";
            mensagem = "Cuide-se bem!";
        } else if (imc < (double)25.0F) {
            resultado = "Normal (18,5 a 24,9)";
            mensagem = "Parabéns!!";
        } else if (imc < (double)30.0F) {
            resultado = "sobrepeso (25 a 29,9)";
            mensagem = "Força e determinação!";
        } else if (imc < (double)35.0F) {
            resultado = "Obesidade grau I (30 a 34,9)";
            mensagem = "Você está quase lá! Não desanime!!";
        } else if (imc < (double)40.0F) {
            resultado = "Obesidade grau II (35 a 39,9)";
            mensagem = "Cada escolha saudável é um passo correto!";
        } else {
            resultado = "Obesidade grau III (+40)";
            mensagem = "Com apoio proficional e amor-próprio você vai conseguir!!";
        }

        model.addAttribute("valIMC", valIMC);
        model.addAttribute("peso", peso);
        model.addAttribute("altura", altura);
        model.addAttribute("resultadoIMC", resultado);
        model.addAttribute("mensagem", mensagem);
        return "resultado";
    }
}
