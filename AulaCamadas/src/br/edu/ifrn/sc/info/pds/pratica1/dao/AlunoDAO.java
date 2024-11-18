
package br.edu.ifrn.sc.info.pds.pratica1.dao;

import br.edu.ifrn.sc.info.pds.pratica1.domain.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AlunoDAO {
    
    public boolean inserir(Aluno aluno) {
        
        boolean resultado = false;
        
        String sql = "INSERT INTO aluno(matricula,nome,ira) values(?,?,?);";
        
        Connection conexao = Conexao.conectar();
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, aluno.getMatricula());
            comando.setString(2, aluno.getNome());
            comando.setDouble(3, aluno.getIra());
            
            int linhasAfetadas = comando.executeUpdate();
            
            if (linhasAfetadas > 0) {
                resultado = true;
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            Conexao.desconectar();
        }
        return resultado;
    }
    
    public boolean deletar(String matricula) {
        
        boolean resultado = false;
        
        String sql = "DELETE FROM aluno WHERE matricula = ?;";
        
        Connection conexao = Conexao.conectar();
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, matricula);
            
            int linhasAfetadas = comando.executeUpdate();
            
            if (linhasAfetadas > 0) {
                resultado = true;
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            Conexao.desconectar();
        }
        return resultado;
    }
    
    public boolean atualizar(Aluno aluno) {
        
        boolean resultado = false;
        
        String sql = "UPDATE aluno set nome = ?, ira = ? where matricula = ?;";
        
        Connection conexao = Conexao.conectar();
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            comando.setString(1, aluno.getNome());
            comando.setDouble(2, aluno.getIra());
            comando.setString(3, aluno.getMatricula());
            
            int linhasAfetadas = comando.executeUpdate();
            
            if (linhasAfetadas > 0) {
                resultado = true;
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            Conexao.desconectar();
        }
        return resultado;
    }
    
    public List<Aluno> buscarTodos() {
        
        List<Aluno> alunos = new ArrayList<Aluno>();
        String sql = "SELECT matricula, nome, ira FROM aluno;";
        
        Connection conexao = Conexao.conectar();
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            ResultSet rs = comando.executeQuery();
            
            while (rs.next()) {
                
                Aluno a = new Aluno();
                a.setMatricula(rs.getString("matricula"));
                a.setNome(rs.getString("nome"));
                a.setIra(rs.getDouble("ira"));
                
                alunos.add(a);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        finally{
            Conexao.desconectar();
        }
        
        return alunos;
    }
    
    public Aluno buscar(String matricula) {
        
        Aluno aluno = null;
        String sql = "SELECT matricula, nome, ira FROM aluno WHERE matricula = ?;";
        
        Connection conexao = Conexao.conectar();
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, matricula);
            ResultSet rs = comando.executeQuery();
            
            if (rs.next()) {
                
                aluno = new Aluno();
                aluno.setMatricula(rs.getString("matricula"));
                aluno.setNome(rs.getString("nome"));
                aluno.setIra(rs.getDouble("ira"));
                
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        finally{
            Conexao.desconectar();
        }
        
        return aluno;
    }
}
