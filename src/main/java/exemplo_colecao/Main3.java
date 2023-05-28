import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
 * Este programa manipula um dicionario
 */

public class Main3 {

	public static void main(String args[]) {
		// Cria um dicionario que mapeia codigo DDI (inteiro) para nome do pais (String)
		Map<Integer, String> dic = new HashMap<>();
		// HashMap eh uma classe que implementa Map
		
		// Adiciona algumas entradas (chave, valor)
		dic.put(55, "Brasil");
		dic.put(1, "EUA");
		dic.put(44, "UK");		
		System.out.println("Tamanho: " + dic.size());
		
		// Se o dicionario contem a chave 55...
		if(dic.containsKey(55)) {
			// Exibe o valor
			System.out.println("Chave 55 eh: "+dic.get(55));
		}

		// Retorna null, pois a chave 33 nao existe
		System.out.println("Chave 33 eh: "+dic.get(33));
		
		dic.remove(44); // Tenta remover o elemento cuja chave eh 44
		
		// Exibe todas as chaves na tela (keySet retorna um Set<>)
		for(int k : dic.keySet()) {
			System.out.println("Chave: "+k);
		}
		
		// Exibe os elementos do dicionario
		for(Entry<Integer, String> entrada : dic.entrySet()) {
			System.out.println("Chave: " + entrada.getKey() + " - " +
			                   "Valor: " + entrada.getValue());
		}	
	}
}