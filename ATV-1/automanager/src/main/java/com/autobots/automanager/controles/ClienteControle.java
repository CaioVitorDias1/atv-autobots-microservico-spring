package com.autobots.automanager.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.entidades.Endereco;
import com.autobots.automanager.entidades.Telefone;
import com.autobots.automanager.modelo.ClienteAtualizador;
import com.autobots.automanager.modelo.ClienteSelecionador;
import com.autobots.automanager.modelo.DocumentoAtualizador;
import com.autobots.automanager.modelo.DocumentoSelecionador;
import com.autobots.automanager.modelo.EnderecoAtualizador;
import com.autobots.automanager.modelo.EnderecoSelecionador;
import com.autobots.automanager.modelo.TelefoneAtualizador;
import com.autobots.automanager.modelo.TelefoneSelecionador;
import com.autobots.automanager.repositorios.ClienteRepositorio;
import com.autobots.automanager.repositorios.DocumentoRepositorio;
import com.autobots.automanager.repositorios.EnderecoRepositorio;
import com.autobots.automanager.repositorios.TelefoneRepositorio;

@RestController
@RequestMapping("/clientes")
public class ClienteControle {
	@Autowired
	private ClienteRepositorio repositorio;
	@Autowired
	private ClienteSelecionador selecionador;
	@Autowired 
	private TelefoneRepositorio telefoneRep;
	@Autowired
	private TelefoneSelecionador telefoneSelec;
	@Autowired
	private DocumentoSelecionador documentoSelec;
	@Autowired
	private DocumentoRepositorio documentoRep;
	@Autowired
	private EnderecoSelecionador enderecoSelec;
	@Autowired
	private EnderecoRepositorio enderecoRep;
	
	@GetMapping("/{id}")
	public Cliente obterCliente(@PathVariable long id) {
		List<Cliente> clientes = repositorio.findAll();
		return selecionador.selecionar(clientes, id);
	}

	@GetMapping("/")
	public List<Cliente> obterClientes() {
		List<Cliente> clientes = repositorio.findAll();
		return clientes;
	}

	@PostMapping("/cadastro")
	public void cadastrarCliente(@RequestBody Cliente cliente) {
		repositorio.save(cliente);
	}

	@PutMapping("/atualizar")
	public void atualizarCliente(@RequestBody Cliente atualizacao) {
		Cliente cliente = repositorio.getById(atualizacao.getId());
		ClienteAtualizador atualizador = new ClienteAtualizador();
		atualizador.atualizar(cliente, atualizacao);
		repositorio.save(cliente);
	}

	@DeleteMapping("/excluir")
	public void excluirCliente(@RequestBody Cliente exclusao) {
		Cliente cliente = repositorio.getById(exclusao.getId());
		repositorio.delete(cliente);
	}

	@GetMapping("/telefone/{id}")
	public Telefone obterTelefonePorId(@PathVariable Long id){
		List<Telefone> telefone = telefoneRep.findAll();
		return telefoneSelec.telefoneSelecionador(telefone, id);
	}

	@PostMapping("/telefone/cadastro")
	public void cadastrarTelefone(@RequestBody Telefone telefone){
		telefoneRep.save(telefone);
	}

	@PutMapping("/telefone/atualizar")
	public void atualizarTelefone(@RequestBody Telefone atualizar){
		Telefone telefone = telefoneRep.getById(atualizar.getId());
		TelefoneAtualizador atualizador = new TelefoneAtualizador();
		atualizador.atualizar(telefone, atualizar);
		telefoneRep.save(telefone); 
	}

	@DeleteMapping("/telefone/excluir")
	public void excluirTelefone(@RequestBody Telefone excluir){
	Telefone telefone = telefoneRep.getById(excluir.getId());
	telefoneRep.delete(telefone);
	}

	@GetMapping("/documento/{id}")
	public Documento documentoPorId(@PathVariable Long id){
		List<Documento> documento = documentoRep.findAll();
		return documentoSelec.documentoSelecionador(documento, id);
	}

	@PostMapping("/documento/cadastro")
	public void cadastrarDocumento(@RequestBody Documento documento){
		documentoRep.save(documento);
	}

	@PutMapping("/documento/atualizar")
	public void atualizarDocumento(@RequestBody Documento atualizar){
		Documento documento = documentoRep.getById(atualizar.getId());
		DocumentoAtualizador atualizador = new DocumentoAtualizador();
		atualizador.atualizar(documento, atualizar);
		documentoRep.save(documento); 
	}

	@DeleteMapping("/documento/excluir")
	public void excluirDocumento(@RequestBody Documento excluir){
	Documento documento = documentoRep.getById(excluir.getId());
	documentoRep.delete(documento);
	}

	@GetMapping("/endereco/{id}")
	public Endereco enderecoPorId(@PathVariable Long id){
		List<Endereco> endereco = enderecoRep.findAll();
		return enderecoSelec.enderecoSelecionador(endereco, id);
	}

	@PostMapping("/endereco/cadastro")
	public void cadastrarEndereco(@RequestBody Endereco endereco){
		enderecoRep.save(endereco);
	}

	@PutMapping("/endereco/atualizar")
	public void atualizarEndereco(@RequestBody Endereco atualizar){
		Endereco endereco = enderecoRep.getById(atualizar.getId());
		EnderecoAtualizador atualizador = new EnderecoAtualizador();
		atualizador.atualizar(endereco, atualizar);
		enderecoRep.save(endereco); 
	}

	@DeleteMapping("/endereco/excluir")
	public void excluirEndereco(@RequestBody Endereco excluir){
	Endereco endereco = enderecoRep.getById(excluir.getId());
	enderecoRep.delete(endereco);
	}
}
