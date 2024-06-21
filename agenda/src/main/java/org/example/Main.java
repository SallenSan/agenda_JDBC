package org.example;

import org.example.dao.ContatoDAO;
import org.example.model.Contato;

import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Contato contato = new Contato();
        ContatoDAO dao = new ContatoDAO();


        contato.setNome("Bernardo Santos de Oliveira");
        contato.setIdade(20);
        contato.setDataDeCadastro(new Date());
        contato.setId(5);


        dao.atualizarContato(contato);
        dao.listarContatos();

    }
}