package MPEI;

public class BloomFilter {
	private int tamanho; // tamanho do BloomFilter
	private int k; // numero de fun�oes de disper�ao
	private int [] bloom;
	private String a;
	
	public BloomFilter(int tamanho, int k, String atributo){
		this.tamanho=tamanho;
		this.k=k;
		bloom = new int[tamanho]; 
		this.a=atributo;
	}
	
	public String getAtributo(){
		return a;
	}
	// Adicionar uma string ao BloomFilter
	
	public void add(String s){
		int hash=Math.abs(s.hashCode()%tamanho);
		bloom[hash]=1;
		for(int i=1;i<k;i++){
			s=s+i;
			hash=Math.abs(s.hashCode()%tamanho);
			bloom[hash]=1;
		}
	}
	
	// Verificar se uma string pertence ao BloomFilter
	
	public boolean verificar(String s){
		int hash;
		for(int i=0;i<k;i++){
			if(i==0){
				hash=Math.abs(s.hashCode()%tamanho);
			}else{
				s=s+i;
				hash=Math.abs(s.hashCode()%tamanho);
			}
			if(bloom[hash]!=1) return false;
		}
		return true;
	}
}
