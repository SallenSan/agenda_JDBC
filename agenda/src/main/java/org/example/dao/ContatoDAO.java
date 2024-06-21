package org.example.dao;

import org.example.factory.DbConnection;
import org.example.model.Contato;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {

    // metodo de criacao e adicao do objeto na base de dados
    public void salvarContato(Contato contato) {
        String sql = "INSERT INTO contatos (nome, idade, dataCadastro) VALUES (?,?,?)";
        Connection con = null;
        PreparedStatement ps = null;

        try {
            // criando conexao com o banco de dados
            con = DbConnection.getConnection();
            // preparando a PreparedStatement para preparar o comando em SQL e executar a query
            ps = con.prepareStatement(sql);

            // inserindo os valores esperados pela query
            ps.setString(1, contato.getNome());
            ps.setInt(2, contato.getIdade());
            ps.setDate(3, new Date(contato.getDataDeCadastro().getTime()));

            // comando que executa a query
            ps.executeUpdate();

            System.out.println("Contato salvo com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();

            }finally {
            // verificando se ha alguma ocnexao aberta
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



    // metodo de leitura dos dados
    public List<Contato> listarContatos() {
        List<Contato> contatos = new ArrayList<Contato>();
        String sql = "SELECT * FROM contatos";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            con = DbConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){
                Contato contato = new Contato();

                // recuperando os dados
                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString("nome"));
                contato.setIdade(rs.getInt("idade"));
                contato.setDataDeCadastro(rs.getDate("dataCadastro"));

                contatos.add(contato);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {

            if(ps != null){
                ps.close();
            }
            if(con != null){
                con.close();
            }
            if(rs != null){
                rs.close();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
            for(Contato contato : contatos){
                System.out.println("Nome: " + contato.getNome());
                System.out.println("Idade: " + contato.getIdade());
                System.out.println("Data de Cadastro: " + contato.getDataDeCadastro());
                System.out.println("-----------------------------");

            }
    }
        return contatos;
    }


    // metodo de atualizacao dos dados
    public void atualizarContato(Contato contato) {
        String sql = "UPDATE contatos SET nome = ?, idade = ?, dataCadastro = ? WHERE id = ?";

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DbConnection.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, contato.getNome());
            ps.setInt(2, contato.getIdade());
            ps.setDate(3, new Date(contato.getDataDeCadastro().getTime()));
            ps.setInt(4, contato.getId());
            ps.executeUpdate();

            System.out.println("Atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // verificando se ha alguma conexao aberta
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    // metodo que ira deletar os dados
    public void deletarUsuario(int id){
        String sql = "DELETE FROM contatos WHERE id = ?";
        Connection con = null;
        PreparedStatement ps = null;

        try{
            con = DbConnection.getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.execute();

            System.out.println("Usuário deletado com êxito!");
        }catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
