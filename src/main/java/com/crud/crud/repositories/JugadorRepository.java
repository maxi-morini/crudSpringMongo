/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crud.crud.repositories;

import com.crud.crud.models.Jugador;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author USER
 */
public interface JugadorRepository extends CrudRepository<Jugador, String>{
    @Override
    public void delete(Jugador j);
        
    }
