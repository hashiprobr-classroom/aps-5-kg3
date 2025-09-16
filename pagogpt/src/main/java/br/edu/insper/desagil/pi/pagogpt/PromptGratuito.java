package br.edu.insper.desagil.pi.pagogpt;

public class PromptGratuito extends Prompt{
    private int limite;

    public PromptGratuito(String pergunta, int limite){
        super(pergunta);
        this.limite = limite;
    }

    @Override // sobrescreve o método criado em Prompt
    public double calculaPreco(){
        if (getPergunta().length() < limite){
            return 0.0; // se o prompt for curto, é gratuito
        } else {
            return getPergunta().length(); // se for longo, R$1,00 por caractere
        }
    }
}
