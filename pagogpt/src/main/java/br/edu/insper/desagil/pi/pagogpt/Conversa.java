package br.edu.insper.desagil.pi.pagogpt;

import java.util.ArrayList;
import java.util.List;

public class Conversa {

    private Usuario usuario;
    private List<Prompt> prompts;

    public Conversa(Usuario usuario) {
        this.usuario = usuario;
        this.prompts = new ArrayList<>();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void adicionarPrompt(Prompt prompt) {
        prompts.add(prompt);
    }

    public double somaPrecos() {
        double soma = 0.0;
        for (Prompt p : prompts) {
            soma += p.calculaPreco();
        }
        return soma;
    }
    public double mediaPrecos() {
        if (prompts.isEmpty()) {
            throw new IllegalStateException("Nenhum prompt!");
        }
        return somaPrecos() / prompts.size();
    }
}

