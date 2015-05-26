package br.com.energia.si.poo2.swing.controller;

import br.com.energia.si.poo2.swing.model.Modalidade;
import br.com.energia.si.poo2.swing.service.ModalidadeService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juliano Torquato
 */
public class ModalidadeController {
    
    private Modalidade modalidade;
    private ModalidadeService modalidadeService;
    private List<Modalidade> listModalidade;

    public ModalidadeController() {
        modalidade = new Modalidade();
        modalidadeService = new ModalidadeService();
        listModalidade = new ArrayList<Modalidade>();
        carregarModalidade();
    }
    
    public void salvarModalidade(Modalidade m){
        try {
            modalidadeService.salvar(m);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void carregarModalidade(){
        listModalidade = modalidadeService.getAll();
    }
    
    public void excluirModalidade(Modalidade m){        
        try {
            modalidadeService.deletar(m);    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void editarModalidade(Modalidade m){
        try {
            modalidadeService.editar(m);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Modalidade> getListModalidade() {
        return listModalidade;
    }

    public Modalidade getModalidade() {
        return modalidade;
    }

    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }
    
    
}
