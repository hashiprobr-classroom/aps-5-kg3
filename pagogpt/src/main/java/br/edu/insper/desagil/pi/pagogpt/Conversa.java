package br.edu.insper.desagil.pi.pagogpt;

import java.util.ArrayList;
import java.util.List;

public class Conversa {

    private final String usuario;
    private final List<Prompt> prompts;

    public Conversa(String usuario) {
        this.usuario = usuario;
        this.prompts = new ArrayList<>();
    }

    public String getUsuario() {
        return usuario;
    }

    public void adicionarPrompt(Prompt prompt) {
        prompts.add(prompt);
    }

    public double somaPrecos() {
        double soma = 0.0;
        for (Prompt p : prompts) {
            soma += p.getPreco();
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

