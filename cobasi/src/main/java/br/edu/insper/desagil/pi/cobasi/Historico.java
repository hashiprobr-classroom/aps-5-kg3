package br.edu.insper.desagil.pi.cobasi;

import java.time.LocalDate;

public class Historico {
    private Tutor tutor;
    private String nome;
    private int tipo;
    private LocalDate dataNascimento;
    private double peso;
    private String extra;

    // novo construtor q usa Tutor
    public Historico(Tutor tutor, String nome, int tipo, LocalDate dataNascimento, double peso, String extra) {
        this.tutor = tutor;
        this.nome = nome;
        this.tipo = tipo;
        this.dataNascimento = dataNascimento;
        this.peso = peso;
        this.extra = extra;
    }

    @Deprecated
    public Historico(String nomeTutor, String nome, int tipo, LocalDate dataNascimento, double peso, String extra){
        this(new Tutor(nomeTutor), nome, tipo, dataNascimento, peso, extra);
    }

    // novo
    public Tutor getTutor(){return tutor;}

    @Deprecated
    public void setEnderecoTutor(String enderecoTutor) {
        this.tutor.setEndereco(enderecoTutor);
    }

    @Deprecated
    public void setTelefoneTutor(String telefoneTutor) {
        this.tutor.setTelefone(telefoneTutor);
    }

    @Deprecated
    public String resumoTutor() {
        return tutor.resumo();
    }

    public String resumo() {
        String summary = "Animal:" + nome + "\n";
        if (tipo == 0) {
            summary += "Nascimento: " + dataNascimento.toString() + "\n";
            summary += "Peso: " + peso + "kg\n";
            summary += "Banho: " + extra + "\n";
        } else if (tipo == 1) {
            summary += "Nascimento: " + dataNascimento.toString() + "\n";
            summary += "Peso: " + peso + "kg\n";
            summary += "Doença: " + extra + "\n";
        } else if (tipo == 2) {
            summary += "Nascimento: " + dataNascimento.toString() + "\n";
            summary += "Peso: " + peso + "kg\n";
            summary += "Venenosa: " + Boolean.parseBoolean(extra) + "\n";
        } else if (tipo == 3) {
            summary += "Nascimento: " + dataNascimento.toString() + "\n";
            summary += "Peso: " + peso + "kg\n";
            summary += "Comida: " + Integer.parseInt(extra) + "\n";
        }
        return summary;
    }


}
