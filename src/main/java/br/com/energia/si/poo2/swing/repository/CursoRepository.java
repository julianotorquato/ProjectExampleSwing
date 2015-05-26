/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.energia.si.poo2.swing.repository;

import br.com.energia.si.poo2.swing.interfaces.ICursoRepository;
import br.com.energia.si.poo2.swing.model.Curso;
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
public class CursoRepository implements ICursoRepository{

    public void salvar(Curso c) {
        		
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet generatedKeys = null;

        try {
                con = ConnectionFactory.getInstance().getConnection();

                ps = (PreparedStatement) con.prepareStatement("INSERT INTO curso("
                                + "descricao_curso, id_modalidade)" + "VALUES (?,?);" , 
                                PreparedStatement.RETURN_GENERATED_KEYS);

                ps.setString(1, c.getDescricao());
                ps.setInt(2, c.getModalidade().getId());

                ps.executeUpdate();

                generatedKeys = ps.getGeneratedKeys();

                if (generatedKeys.next()) {
                        c.setId(generatedKeys.getInt(1));
                } else {
                        throw new SQLException(
                                        "Criacao de Curso falhou, nao consegui obter o id.");
                }

                ps.close();

        } catch (SQLException e) {

                e.printStackTrace();

        } finally {
                ConnectionFactory.getInstance().closeConnection(con);
        }
    }

    public void deletar(Curso c) {
        Connection con = null;

        try {
                con = ConnectionFactory.getInstance().getConnection();
                PreparedStatement ps = con.prepareStatement("DELETE FROM CURSO WHERE id_curso=?;");
                ps.setInt(1, c.getId());

                ps.executeUpdate();

                ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.getInstance().closeConnection(con);
        }		
    }

    public Curso getById(int id) {
        Connection con = null;
        Curso curso = null;

        try {

            con = ConnectionFactory.getInstance().getConnection();
            
            PreparedStatement ps = con.prepareStatement("select * from curso c " +
            "inner join modalidade m \n" +
            "on c.ID_MODALIDADE = m.ID_MODALIDADE WHERE id_curso=?;");

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                curso = new Curso();				
                curso.setId(rs.getInt("id_curso"));
                curso.setDescricao(rs.getString("descricao_curso"));
                
                Modalidade modalidade = new Modalidade();
                modalidade.setId(rs.getInt("id_modalidade"));
                modalidade.setDescricao(rs.getString("descricao_modalidade"));
                curso.setModalidade(modalidade);
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.getInstance().closeConnection(con);
        }

        return curso;
    }

    public List<Curso> getAll() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs;

        List<Curso> listaCursos = new ArrayList<Curso>();

        try {
                con = ConnectionFactory.getInstance().getConnection();
                ps = (PreparedStatement) con.prepareStatement("select * from curso c " +
                "inner join modalidade m \n" +
                "on c.ID_MODALIDADE = m.ID_MODALIDADE;");
                rs = ps.executeQuery();

                while (rs.next()) {

                        Curso curso = new Curso();
                        curso.setId(rs.getInt("id_curso"));
                        curso.setDescricao(rs.getString("descricao_curso"));
                        
                        Modalidade modalidade = new Modalidade();
                        modalidade.setId(rs.getInt("id_modalidade"));
                        modalidade.setDescricao(rs.getString("descricao_modalidade"));
                        curso.setModalidade(modalidade);

                        listaCursos.add(curso);
                }
                ps.close();
                rs.close();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.getInstance().closeConnection(con);
        }
        return listaCursos;
    }

    @Override
    public void editar(Curso c) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
           
            con = ConnectionFactory.getInstance().getConnection();
            ps = con.prepareStatement("UPDATE  curso \n" +
            "set descricao_curso = ?, \n" +
            "id_modalidade = ? \n" +
            "WHERE id_curso = ?");
            ps.setString(1, c.getDescricao());
            ps.setInt(2, c.getModalidade().getId());
            ps.setInt(3, c.getId());
            
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
                Logger.getLogger(CursoRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
