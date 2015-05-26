package br.com.energia.si.poo2.swing.interfaces;

import br.com.energia.si.poo2.swing.model.Curso;
import java.util.List;


public interface ICursoRepository extends GenericRepository<Curso, Integer>{

	public void salvar(Curso c);
	public void deletar(Curso c);
	public Curso getById(int id);
	public List<Curso> getAll();
}
