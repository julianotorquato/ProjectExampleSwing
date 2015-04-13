/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.energia.si.poo2.swing.util;

import br.energia.si.poo2.swing.util.jdbc.ConnectionFactory;
import java.sql.Connection;

/**
 *
 * @author Juliano Torquato
 */
public class Main {
    
    public static void main(String[] args){
        Connection conn = ConnectionFactory.getInstance().getConnection();
        
        System.out.println(conn);
    }
    
}
