package br.com.energia.si.poo2.swing.util.jtable;

import br.com.energia.si.poo2.swing.model.Modalidade;
import br.com.energia.si.poo2.swing.service.ModalidadeService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

// A AbstractTableModel é uma classe abstrata e implementa parcialmente
// os métodos para fornecer dados para o componente JTable do Swing.
//
// A classe filha de AbstractTableModel deve implementar os métodos
// faltantes.
public class ModalidadeTableModel extends AbstractTableModel {

    private List<Modalidade> listModalidade;
    private String[] cabecalhoColunas = {"Código", "Modalidade"};

    public ModalidadeTableModel() {
        try {
            listModalidade = new ModalidadeService().getAll();
        } catch (Exception ex) {
            Logger.getLogger(ModalidadeTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Este método é chamado pelo JTable para saber quantas linhas 
    // a tabela irá apresentar para o usuário. Com base nesta quantidade
    // de linhas, o JTable irá requisitar o valor de cada linha.
    @Override
    public int getRowCount() {
        return listModalidade.size();
    }

    // Este método é utilizado pelo JTable para saber quantas colunas
    // terá que apresentar para o usuário. A partir deste valor o JTable 
    // irá solicitar o conteúdo de cada coluna.
    @Override
    public int getColumnCount() {
        return cabecalhoColunas.length;
    }

    // Através deste método o JTable obtém o valor a ser impresso em cada célula da tabela.
    // Os parâmetros são linha e coluna.
    @Override
    public Object getValueAt(int numLinha, int numColuna) {

        switch (numColuna) {
            case 0:
                return listModalidade.get(numLinha).getId();
            case 1:
                return listModalidade.get(numLinha).getDescricao();
        }
        return null;
    }

    // Através deste método o JTable irá solicitar a String a ser utilizada no cabeçalho
    // de cada coluna
    @Override
    public String getColumnName(int numColuna) {
        return cabecalhoColunas[numColuna];
    }

    public List<Modalidade> getClientes() {
        return listModalidade;
    }

}
