package br.com.ricci.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ricci.model.Convidado;
import br.com.ricci.repository.ConvidadoRepository;

@Service
public class ConvidadosService {

	@Autowired
	private ConvidadoRepository repository;

	public Iterable<Convidado> obterTodos() {
		return repository.findAll();
	}

	public void salvar(Convidado convidado) {
		repository.save(convidado);
	}

}
