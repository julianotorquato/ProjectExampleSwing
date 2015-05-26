package br.com.energia.si.poo2.swing.interfaces;

import java.io.Serializable;
import java.util.List;

public interface GenericRepository <T, id extends Serializable> {

	public  void salvar(T object);
        public  void editar(T object);
	public void deletar(T object);
	public Object getById(int id);
	public List<T> getAll();
}
