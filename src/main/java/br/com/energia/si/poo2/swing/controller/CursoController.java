package br.com.energia.si.poo2.swing.controller;

import br.com.energia.si.poo2.swing.model.Curso;
import br.com.energia.si.poo2.swing.model.Modalidade;
import br.com.energia.si.poo2.swing.service.CursoService;
import br.com.energia.si.poo2.swing.service.ModalidadeService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juliano Torquato
 */
public class CursoController {
    
    private Curso curso;
    private CursoService cursoService;
    private List<Curso> listCurso;
    private List<Modalidade> listModalidade;
    
    public CursoController() {
        curso = new Curso();
        cursoService = new CursoService();
        listCurso = new ArrayList<Curso>();
        listModalidade = new ArrayList<Modalidade>();
        carregarModalidade();
        carregarCurso();
    }
    
    public void salvarCurso(Curso c){
        try {
            cursoService.salvar(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void carregarModalidade(){
        listModalidade = new ModalidadeService().getAll();
    }
    
    public void carregarCurso(){
        listCurso = new CursoService().getAll();
    }
    
    public void excluirCurso(Curso c){        
        try {
            cursoService.deletar(c);    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void editarCurso(Curso c){
        try {
            cursoService.editar(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Curso getCurso() {
        return curso;
    }
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public CursoService getCursoService() {
        return cursoService;
    }
    public void setCursoService(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    public List<Curso> getListCurso() {
        return listCurso;
    }
    public void setListCurso(List<Curso> listCurso) {
        this.listCurso = listCurso;
    }

    public List<Modalidade> getListModalidade() {
        return listModalidade;
    }
    public void setListModalidade(List<Modalidade> listModalidade) {
        this.listModalidade = listModalidade;
    }
}
