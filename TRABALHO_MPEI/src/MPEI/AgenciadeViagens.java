package MPEI;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AgenciadeViagens {

	public static void main(String[] args) {
		
		//Leitura do ficheiro	
		Path p = Paths.get("viagens.txt");					
		List<String> lines = new ArrayList<String>();			
		try {
			lines = Files.readAllLines(p,Charset.defaultCharset());
		}catch (IOException e) {
			e.printStackTrace();
		}																	
		String [] aux=lines.get(1).split(",");
		 
		//Criaçao dos BloomFilters
		 BloomFilter [] b = new BloomFilter[aux.length];
		 for(int i=0; i<aux.length;i++){
			 b[i]= new BloomFilter(100,3, aux[i]);
		 }
		 
		 // Criaçao de uma lista com todas as localidades e seus respetivos atributos
		 
		 ListLocalidade local = new ListLocalidade();	
		 for(int i=2; i<lines.size(); i++){
			 local.add(lines.get(i));
		 }
		 
		 //Adiçao das localidades ao bloomfilter
		 
		 for(int i=0; i<local.size();i++){
			 String [] x=local.get(i).getAtributos();
			 for(int j=0;j<aux.length;j++){
				 for(int k=0; k<x.length; k++){
					 if(b[i].getAtributo().equals(x[k])){
						 b[i].add(local.get(i).getNome());
					 }
				 }
			 }
		 }
		 
		 
		 
		 
		 
		 
		 

	}

}
