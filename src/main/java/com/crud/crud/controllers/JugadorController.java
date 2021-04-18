/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crud.crud.controllers;


import com.crud.crud.models.Jugador;
import com.crud.crud.repositories.JugadorRepository;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.itextpdf.html2pdf.HtmlConverter;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author USER
 */
@Controller
public class JugadorController  {

    @Autowired
    JugadorRepository jugadorRepository;

    @RequestMapping("/jugador")
    public String product(Model model) {
        model.addAttribute("jugadores", jugadorRepository.findAll());
        return "jugador";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        return "create";
    }

    @RequestMapping("/save")
    public String save(@RequestParam String nombre, @RequestParam int pase, @RequestParam int tiro, @RequestParam int velocidad,@RequestParam String image) {
        Jugador jugador = new Jugador();
        jugador.setNombre(nombre);
        jugador.setPase(pase);
        jugador.setTiro(tiro);
        jugador.setVelocidad(velocidad);
        jugador.setImage(image);
        jugadorRepository.save(jugador);

        return "redirect:/show/" + jugador.getId();
    }

    @RequestMapping("/show/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("jugador", jugadorRepository.findById(id).get());
        return "show";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam String id) {
        Optional<Jugador> jugador = jugadorRepository.findById(id);
        jugadorRepository.delete(jugador.get());
        return "redirect:/jugador";
    }
    
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("jugador", jugadorRepository.findById(id).get());
        return "edit";
    }
    
    @RequestMapping("/update")
    public String update(@RequestParam String id, @RequestParam String name, @RequestParam int pase, @RequestParam int tiro, @RequestParam int velocidad, @RequestParam String image) {
        Optional<Jugador> jugador = jugadorRepository.findById(id);
        jugador.get().setNombre(name);
        jugador.get().setPase(pase);
        jugador.get().setTiro(tiro);
        jugador.get().setVelocidad(velocidad);
        jugadorRepository.save(jugador.get());
        return "redirect:/show/" + jugador.get().getId();
    }
    @RequestMapping("/")
    public String home(){
        return "default";
    }

}

