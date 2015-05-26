
package br.com.energia.si.poo2.swing.service;

import br.com.energia.si.poo2.swing.model.Curso;
import br.com.energia.si.poo2.swing.repository.CursoRepository;
import java.util.List;

/**
 *
 * @author Juliano Torquato
 */
public class CursoService {

    private CursoRepository repository;

    public CursoService() {
        repository = new CursoRepository();
    }
    
    public void salvar(Curso c){
        repository.salvar(c);
    }
    
    public void editar(Curso c){
        repository.editar(c);
    }
    
    public void deletar(Curso c){
        repository.deletar(c);
    }
    public Curso getById(int id){
        return repository.getById(id);
    }
    public List<Curso> getAll(){
        return repository.getAll();
    }       
}
