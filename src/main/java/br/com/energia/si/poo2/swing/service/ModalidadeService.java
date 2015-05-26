
package br.com.energia.si.poo2.swing.service;

import br.com.energia.si.poo2.swing.model.Modalidade;
import br.com.energia.si.poo2.swing.repository.ModalidadeRepository;
import java.util.List;

/**
 *
 * @author Juliano Torquato
 */
public class ModalidadeService {

    private ModalidadeRepository repository;

    public ModalidadeService() {
        repository = new ModalidadeRepository();
    }
    
    public void salvar(Modalidade m){
        repository.salvar(m);
    }
    
    public void editar(Modalidade m){
        repository.editar(m);
    }
    
    public void deletar(Modalidade m){
        repository.deletar(m);
    }
    public Modalidade getById(int id){
        return repository.getById(id);
    }
    public List<Modalidade> getAll(){
        return repository.getAll();
    }
    
            
}
