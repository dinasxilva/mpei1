package MPEI;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgenciadeViagens {
	static Scanner sc = new Scanner(System.in);
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
			 b[i]= new BloomFilter(100,5, aux[i]);
		 }
		 
		 // Criaçao de uma lista com todas as localidades e seus respetivos atributos
		 
		 ListLocalidade local = new ListLocalidade();	
		 for(int i=3; i<lines.size(); i++){
			 local.add(lines.get(i));
		 }
		 
		 //Adiçao das localidades ao bloomfilter
		 for(int i=0; i<local.size();i++){
			 String [] x=local.get(i).getAtributos();
			 for(int j=0;j<aux.length;j++){
				 for(int k=0; k<x.length; k++){
					 if(b[j].getAtributo().equals(x[k])){
						 b[j].add(local.get(i).getNome());
					 }
				 }
			 }
		 }
		 
		//Menu
		 
		
		 int x =0;
		 do{
			 menus.principal();
			 x = sc.nextInt();
			 sc.nextLine();
			 switch(x){
				 case 1:
					 menus.filtros(aux);
					 String filt = sc.nextLine();
					 String [] aa = verificarFiltro(b, filt, local);
					 
						 System.out.println(aa[0]);
					 
					 break;
				 case 2:
					 menus.pesquisa();
					 String nome = sc.nextLine();
					 break;
				default:
					System.out.println("Opção não existe!");
			 }
		 }while(x!=0); 
		 
		 
		 
		 

	}
	public static String [] verificarFiltro( BloomFilter [] b, String s,  ListLocalidade local){
		char x;
		int y;
		ArrayList<String> ss = new ArrayList<>();
		int i=0;
		do{
			ss.add(local.get(i).getNome());
			i++;
		}while(i<local.size());
		
		for(i=0; i<s.length();i++){
			
			// converter cada carater para um numero do bloom filter
			x = s.charAt(i);
			if(x=='A'|| x=='B' || x=='C' || x=='D' || x=='E'){
				y = (int)x - 55;
			}else{
				y = (int)x - 48;
			}
			int j=0;
			do{
				if(!b[y].verificar(ss.get(j))){
					ss.remove(ss.get(j));
					j--;
				}
				j++;
			}while( j<ss.size());
			
		}
		
		
		return  toArray(ss);
	}
	
	public static String [] toArray(ArrayList<String> s){
		String [] ss = new String [s.size()];
		for(int i=0; i<ss.length;i++){
			ss[i]=s.get(i);
		}
		return ss;
	}

}
