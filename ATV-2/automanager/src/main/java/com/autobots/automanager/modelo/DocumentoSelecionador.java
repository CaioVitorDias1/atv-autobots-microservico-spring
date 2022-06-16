package com.autobots.automanager.modelo;

import java.util.List;

import com.autobots.automanager.entidades.Documento;

public class DocumentoSelecionador {
    public Documento documentoSelecionador(List<Documento> documentos, long id) {
		Documento selecionado = null;
		for (Documento documento : documentos) {
			if (documento.getId() == id) {
				selecionado = documento;
			}
		}
		return selecionado;
	}
}
