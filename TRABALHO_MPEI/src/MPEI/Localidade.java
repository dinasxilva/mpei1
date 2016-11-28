package MPEI;

public class Localidade {
	private String nome, pais, atributos;
	private int populacao, temperatura;
	
	public Localidade(String nome, String pais, String atributos, int temperatura, int populacao){
		this.nome=nome;
		this.pais=pais;
		this.atributos=atributos;
		this.temperatura=temperatura;
		this.populacao=populacao;
	}
	
	public String getNome(){
		return nome;
	}
	public String getPais(){
		return pais;
	}
	public String[] getAtributos(){
		return atributos.split(",");
	}
	public String getAtributos_simple(){
		return atributos;
	}
	public int getTemperatura(){
		return temperatura;
	}
	public int getPopulacao(){
		return populacao;
	}
}
