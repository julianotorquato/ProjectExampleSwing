package br.com.energia.si.poo2.swing.interfaces;

import br.com.energia.si.poo2.swing.model.Modalidade;
import java.util.List;

public interface IModalidadeRepository extends GenericRepository<Modalidade, Integer>{

	public void salvar(Modalidade m);
	public void deletar(Modalidade m);
	public Modalidade getById(int id);
	public List<Modalidade> getAll();
}
