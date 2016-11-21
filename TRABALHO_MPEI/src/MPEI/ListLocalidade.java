package MPEI;

import java.util.ArrayList;

public class ListLocalidade {
	private ArrayList<Localidade> arr = new ArrayList<Localidade>();
	public ListLocalidade(){
		
	}
	public void add(String s){
		String[] aux=s.split(";");
		Localidade c = new Localidade(aux[0], aux[1], aux[2], Integer.parseInt(aux[3]),  Integer.parseInt(aux[3]));
		arr.add(c);
	}
	
	public Localidade get(int i){
		return arr.get(i);
	}
	
	
	public int size(){
		return arr.size();
	}
}
