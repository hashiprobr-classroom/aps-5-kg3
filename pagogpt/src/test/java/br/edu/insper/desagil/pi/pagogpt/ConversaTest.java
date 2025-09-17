package br.edu.insper.desagil.pi.pagogpt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConversaTest {

    @Test
    void subTotalVazio() {
        Conversa c = new Conversa(new Usuario("ana@email.com"));
        assertEquals(0.0, c.somaPrecos(), 0.01);
    }

    @Test
    void subTotal() {
        Conversa c = new Conversa(new Usuario("ana@email.com"));
        c.adicionarPrompt(new Prompt(10));
        c.adicionarPrompt(new Prompt(20.5));
        c.adicionarPrompt(new Prompt(5.25));

        double esperado = 35.75;
        assertEquals(esperado, c.somaPrecos(), 0.01);
    }

    @Test
    void porPostVazio() {
        Conversa c = new Conversa(new Usuario("ana@email.com"));
        IllegalStateException ex = assertThrows(
                IllegalStateException.class,
                c::mediaPrecos
        );
        assertEquals("Nenhum prompt!", ex.getMessage());
    }

    @Test
    void porPost() {
        Conversa c = new Conversa(new Usuario("ana@email.com"));
        c.adicionarPrompt(new Prompt(10));
        c.adicionarPrompt(new Prompt(20.5));
        c.adicionarPrompt(new Prompt(5.25));

        double esperado = 35.75 / 3.0; 
        assertEquals(esperado, c.mediaPrecos(), 0.01);
    }
}
