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
        if (imc < 18.5) {
            resultado = "Magreza (-18,5)";
            mensagem = "Cuidar de sí mesmo(a) é importante!!";
        } else if (imc < 25.0) {
            resultado = "Normal (18,5 a 24,9)";
            mensagem = "Você está no caminho certo, parabéns!!";
        } else if (imc < 30.0) {
            resultado = "sobrepeso (25 a 29,9)";
            mensagem = "Força e determinação!";
        } else if (imc < 35.0) {
            resultado = "Obesidade grau I (30 a 34,9)";
            mensagem = "seu bem-estar é valioso";
        } else if (imc < 40.0) {
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
