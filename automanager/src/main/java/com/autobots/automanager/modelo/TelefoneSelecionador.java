package com.autobots.automanager.modelo;

import java.util.List;

import com.autobots.automanager.entidades.Telefone;

import org.springframework.stereotype.Component;

@Component
public class TelefoneSelecionador {
    public Telefone telefoneSelecionador(List<Telefone> telefones, long id) {
		Telefone selecionado = null;
		for (Telefone telefone : telefones) {
			if (telefone.getId() == id) {
				selecionado = telefone;
			}
		}
		return selecionado;
	}

    
}
