/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.energia.si.poo2.swing.repository;

import br.com.energia.si.poo2.swing.interfaces.IModalidadeRepository;
import br.com.energia.si.poo2.swing.model.Modalidade;
import br.com.energia.si.poo2.swing.util.jdbc.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juliano Torquato
 */
public class ModalidadeRepository implements IModalidadeRepository{

    public void salvar(Modalidade m) {
        		
        Connection con = null;

        PreparedStatement ps = null;
        ResultSet generatedKeys = null;

        try {
                con = ConnectionFactory.getInstance().getConnection();

                ps = (PreparedStatement) con.prepareStatement("INSERT INTO modalidade("
                                + "descricao_modalidade)" + "VALUES (?);" , 
                                PreparedStatement.RETURN_GENERATED_KEYS);

                ps.setString(1, m.getDescricao());

                ps.executeUpdate();

                generatedKeys = ps.getGeneratedKeys();

                if (generatedKeys.next()) {
                        m.setId(generatedKeys.getInt(1));
                } else {
                        throw new SQLException(
                                        "Criacao de Modalidade falhou, nao consegui obter o id.");
                }

                ps.close();

        } catch (SQLException e) {

                e.printStackTrace();

        } finally {
                ConnectionFactory.getInstance().closeConnection(con);
        }
    }

    public void deletar(Modalidade m) {
        Connection con = null;

        try {
                con = ConnectionFactory.getInstance().getConnection();
                PreparedStatement ps = con.prepareStatement("DELETE FROM MODALIDADE WHERE id_modalidade=?;");
                ps.setInt(1, m.getId());

                ps.executeUpdate();

                ps.close();

        } catch (Exception e) {
                e.printStackTrace();
        } finally {
                ConnectionFactory.getInstance().closeConnection(con);
        }		
    }

    public Modalidade getById(int id) {
        Connection con = null;
        Modalidade modalidade = null;

        try {

            con = ConnectionFactory.getInstance().getConnection();

            PreparedStatement ps = con.prepareStatement("SELECT * FROM modalidade WHERE id_modalidade=?;");

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                modalidade = new Modalidade();				
                modalidade.setId(rs.getInt("id_modalidade"));
                modalidade.setDescricao(rs.getString("descricao_modalidade"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.getInstance().closeConnection(con);
        }

        return modalidade;
    }

    public List<Modalidade> getAll() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs;

        List<Modalidade> listaModalidades = new ArrayList<Modalidade>();

        try {
                con = ConnectionFactory.getInstance().getConnection();
                ps = (PreparedStatement) con.prepareStatement("SELECT * FROM MODALIDADE;");
                rs = ps.executeQuery();

                while (rs.next()) {

                        Modalidade modalidade = new Modalidade();
                        modalidade.setId(rs.getInt("id_modalidade"));
                        modalidade.setDescricao(rs.getString("descricao_modalidade"));

                        listaModalidades.add(modalidade);
                }
                ps.close();
                rs.close();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.getInstance().closeConnection(con);
        }
        return listaModalidades;
    }

    @Override
    public void editar(Modalidade m) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            /*
             * "UPDATE AGENDA SET DIA = ?, HORARIO = ?, ID_PROFISSIONAL = ?, "
             + "ID_CLIENTE = ?, ID_SERVICO = ?  WHERE ID_AGENDA = ?";
             */
            con = ConnectionFactory.getInstance().getConnection();
            ps = con.prepareStatement("UPDATE modalidade set descricao_modalidade = ? WHERE id_modalidade = ?;");
            ps.setString(1, m.getDescricao());
            ps.setInt(2, m.getId());
            
            ps.execute();
            ps.close();
            con.close();


        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ModalidadeRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
