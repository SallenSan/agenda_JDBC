package org.example;

import org.example.dao.ContatoDAO;
import org.example.model.Contato;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Contato contato = new Contato();
        ContatoDAO dao = new ContatoDAO();

        // cadastrando contato
        // contato.setNome("Ana");
        // contato.setIdade(30);
        // contato.setDataDeCadastro(new Date());
        //dao.salvarContato(contato);


        // atualizando contato
        // contato.setNome("Ana Luiza");
        // contato.setDataDeCadastro(new Date());
        //contato.setId(7);
        //dao.atualizarContato(contato);

        // deletando contato
        dao.deletarUsuario(7);

        dao.listarContatos();


    }
}