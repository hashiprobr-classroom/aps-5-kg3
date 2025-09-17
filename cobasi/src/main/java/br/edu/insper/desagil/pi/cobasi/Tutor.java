package br.edu.insper.desagil.pi.cobasi;

public class Tutor {
    private String nome;
    private String endereco;
    private String telefone;

    public Tutor (String nome){
        this.nome = nome;
    }

    public String getNome() {return nome;}
    public String getEndereco() {return endereco;}
    public String getTelefone(){return telefone;}

    public void setEndereco(String endereco) {this.endereco = endereco;}
    public void setTelefone(String telefone){this.telefone = telefone;}

    public String resumo() {
        String summary = "Tutor: " + nome + "\n";
        if (endereco != null) {
            summary += "Endereço: " + endereco + "\n";
        }
        if (telefone != null) {
            summary += "Telefone: " + telefone + "\n";
        }
        return summary;
    }
}
