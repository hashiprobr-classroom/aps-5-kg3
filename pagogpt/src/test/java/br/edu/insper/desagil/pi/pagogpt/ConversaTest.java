package br.edu.insper.desagil.pi.pagogpt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConversaTest {

    @Test
    void subTotalVazio() {
        Conversa c = new Conversa(new Usuario("ana@email.com", "Ana"));
        assertEquals(0.0, c.somaPrecos(), 0.01);
    }

    @Test
    void subTotal() {
        Conversa c = new Conversa(new Usuario("ana@email.com", "Ana"));
        c.adicionarPrompt(new PromptGratuito("abcd", 2));
        c.adicionarPrompt(new PromptPago("x", 0.5));
        c.adicionarPrompt(new PromptPago("y", 0.12));

        double esperado = 4.0 + 0.5 + 0.12;
        assertEquals(esperado, c.somaPrecos(), 0.01);
    }

    @Test
    void porPostVazio() {
        Conversa c = new Conversa(new Usuario("ana@email.com", "Ana"));
        IllegalStateException ex = assertThrows(
                IllegalStateException.class,
                c::mediaPrecos
        );
        assertEquals("Nenhum prompt!", ex.getMessage());
    }

    @Test
    void porPost() {
        Conversa c = new Conversa(new Usuario("ana@email.com", "Ana"));
        c.adicionarPrompt(new PromptGratuito("abcd", 2));
        c.adicionarPrompt(new PromptPago("y", 1.2));
        c.adicionarPrompt(new PromptPago("z", 0.33));

        double esperado = 5.53 / 3.0;
        assertEquals(esperado, c.mediaPrecos(), 0.01);
    }
}
