package br.edu.insper.desagil.pi.pagogpt;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CobradorTest {

    public static final double DELTA = 0.01;

    private Conversa conv(String email, double... precos) {
        Conversa c = new Conversa(new Usuario(email, "Gabi"));
        for (double p : precos) c.adicionarPrompt(new PromptPago("x", p));
        return c;
    }

    @Test
    void nenhumaValida() {
        Cobrador cobrador = new Cobrador(new ArrayList<>());
        double total = cobrador.totalDoUsuario(new Usuario("gabi@mail.com", "Gabi"));
        assertEquals(0.0, total, DELTA);
    }

    @Test
    void umaValida() {
        List<Conversa> conversas = Arrays.asList(
                conv("kai@x.com", 9.0),
                conv("gabi@mail.com", 10.0, 2.5, 0.75),
                conv("helena@.com", 1.2, 3.3)
        );
        Cobrador cobrador = new Cobrador(conversas);
        double esperado = 10.0 + 2.5 + 0.75;
        assertEquals(esperado, cobrador.totalDoUsuario(new Usuario("gabi@mail.com", "Gabi")), DELTA);
    }

    @Test
    void duasValidas() {
        List<Conversa> conversas = Arrays.asList(
                conv("gabi@mail.com", 10.0),
                conv("kai@x.com", 5.0),
                conv("gabi@mail.com", 2.5, 7.25)
        );
        Cobrador cobrador = new Cobrador(conversas);
        double esperado = 10.0 + 2.5 + 7.25;
        assertEquals(esperado, cobrador.totalDoUsuario(new Usuario("gabi@mail.com", "Gabi")), DELTA);
    }

    @Test
    void tresValidas() {
        List<Conversa> conversas = Arrays.asList(
                conv("oi@u.com", 1.0, 2.0),
                conv("oi@U.com", 0.5),
                conv("oi@u.com", 4.25)
        );
        Cobrador cobrador = new Cobrador(conversas);
        double esperado = 1.0 + 2.0 + 0.5 + 4.25;
        assertEquals(esperado, cobrador.totalDoUsuario(new Usuario("oi@u.com", "Oi")), DELTA);
    }
}