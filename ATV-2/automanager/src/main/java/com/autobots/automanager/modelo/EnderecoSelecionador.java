package com.autobots.automanager.modelo;

import java.util.List;

import com.autobots.automanager.entidades.Endereco;

public class EnderecoSelecionador {
    public Endereco enderecoSelecionador(List<Endereco> enderecos, long id) {
		Endereco selecionado = null;
		for (Endereco endereco : enderecos) {
			if (endereco.getId() == id) {
				selecionado = endereco;
			}
		}
		return selecionado;
	}
}
