package br.edu.insper.desagil.pi.pagogpt;

public abstract class Prompt {
    private String pergunta;
    private String resposta;

    public Prompt(String pergunta){
        this.pergunta = pergunta;
        this.resposta = null; // deve ser inicializada como null (enunciado)
    }

    public String getPergunta(){
        return pergunta;
    }
    public String getResposta(){
        return resposta;
    }
    public void setResposta(String resposta){
        this.resposta = resposta;
    }
    // a implementação do método deve ser definida em subclasses, então usamos abstract
    public abstract double calculaPreco();
}

