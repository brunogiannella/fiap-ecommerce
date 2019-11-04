package br.com.fiap.ecommerce.produto.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "CLIENTE")
public class Cliente implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5478952030910970309L;

	public static final String CACHE_NAME = "Cliente";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private String cpf;

    @Column(name = "NOME")
    private String nome;
    
    @Column(name = "ENDERECO")
    private String endereco;
    
    @Column(name = "TELEFONE")
    private String telefone;
    
    @Column(name = "CEP")
    private String cep;
    
    @Column(name = "DATA_NASCIMENTO")
    private String dataNascimento;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }



    @Override
    public int hashCode() {
        return Objects.hash(nome,cpf);
    }
}
