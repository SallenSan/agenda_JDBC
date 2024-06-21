package org.example;

import org.example.dao.ContatoDAO;
import org.example.model.Contato;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Contato contato = new Contato();
        ContatoDAO dao = new ContatoDAO();


        // contato.setNome("Bernardo Oliveira");
        // contato.setIdade(20);
        // contato.setDataDeCadastro(new Date());
        //contato.setId(5);

        dao.listarContatos();


    }
}