package com.example.evidencia;

import com.example.evidencia.model.UsuarioEntity;
import com.example.evidencia.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controlador {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping("/")
    public ModelAndView peticionRaiz() {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("index");

        return mv;
    }

    @RequestMapping("/login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("login");

        return mv;
    }
    @RequestMapping("/denegado")
    public ModelAndView denegado() {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("denegado");

        return mv;
    }

    @RequestMapping("/productos")
    public String peticion2( ModelMap model ) {

        model.addAttribute("usuarios", usuarioService.getUsuarios());

        return "productos";
    }

    @RequestMapping("/editar")
    public String peticion3(ModelMap model) {

        model.addAttribute("register", new UsuarioEntity());

        return "editar";
    }

    @PostMapping("/comprobarRegistro") //Comprobar si el Usuario existe, si no existe, se registra
    public String peticionComprobarRegistro(UsuarioEntity user) {

        user.setActivo(0);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setPermiso("EDITOR");

        usuarioService.postUsuarios(user);

        return "redirect:/productos";
    }
}