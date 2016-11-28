package MPEI;

public class MinHash {
	
	
	ListLocalidade l;
	int[][] min;
	int hash_amm;
	
	public MinHash(ListLocalidade l, int k){
		this.l = l;
		min = new int[l.size()][k];
		hash_amm = k;
	}
	
	void getMinHash(){
		int indice = 1;
		String[] temp = new String[16]; //Nº máx de atributos + pais + temp + pop
		int[] temp_hash = new int[16];
		for(int i = 0; i <= l.size(); i++){
				temp[0] = l.get(i).getPais();
				temp[1] = ("" + l.get(i).getPopulacao());
				temp[2] = ("" + l.get(i).getTemperatura());
				for(int b = 0; b <= l.get(i).getAtributos().length; b++){
					temp[b+3] = l.get(i).getAtributos()[b];
				}
				for(int c = 0; c < hash_amm; c++){
					for(int t = 0; t < temp.length; t++){
						if(temp[t] != null){temp_hash[t] = temp[t].hashCode();} //Fazer hash a tudo
					}
					min[i][c] = getMinValue(temp_hash); //Obter o minimo
					concatenate(temp, indice++);
				}
				indice = 1;
				temp = new String[16];
				temp_hash = new int[16];
		}
		
	}


	private void concatenate(String[] temp, int ind) {
		for(int i = 0; i < temp.length; i++){
			temp[i] += ind;
		}
	}

	public static int getMinValue(int[] array) {
	    int minValue = array[0];
	    for (int i = 1; i < array.length; i++) {
	    	if(array[i] != 0){
		        if (array[i] < minValue) {
		            minValue = array[i];
		        }
	    	}
	    }
	    return minValue;
	}

}
