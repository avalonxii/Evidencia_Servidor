package com.example.evidencia.service;

import com.example.evidencia.model.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    RestTemplate restTemplate;
    public List<UsuarioEntity> getUsuarios() {

        ResponseEntity<UsuarioEntity[]> response = restTemplate.getForEntity("http://localhost:8090/api/usuarios", UsuarioEntity[].class);
        UsuarioEntity[] usuarios = response.getBody();

        return List.of(usuarios);
    }

    public UsuarioEntity postUsuarios(UsuarioEntity user) {

        ResponseEntity<UsuarioEntity> response = restTemplate.postForEntity("http://localhost:8090/api/usuarios", user, UsuarioEntity.class);

        return response.getBody();
    }

}
