package br.edu.insper.desagil.pi.pagogpt;

import java.util.List;

public class Cobrador {

    private final List<Conversa> conversas; /

    public Cobrador(List<Conversa> conversas) {
        this.conversas = conversas;
    }

    public double totalDoUsuario(Usuario usuario) {
        String emailAlvo = usuario.getEmail();
        double soma = 0.0;

        for (Conversa c : conversas) {
            if (c.getUsuario().getEmail().equalsIgnoreCase(emailAlvo)) {
                soma += c.somaPrecos();
            }
        }
        return soma;
    }
}
