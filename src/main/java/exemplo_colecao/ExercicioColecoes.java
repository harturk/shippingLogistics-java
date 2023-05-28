import java.util.*;
import java.util.Map.Entry;

public class ExercicioColecoes {

    /**
     * Inverte uma String com uso de uma pilha
     * @param original String de entrada
     * @return String invertida
     */
    public String inverteString(String original) {
        String resultado = "";
        Stack<Character> pilha = new Stack<Character>();
        for(int i=0; i< original.length(); i++) {
            char caracter = original.charAt(i);
            pilha.push(caracter);
        }
        while(!pilha.isEmpty()) {
            char caracter = pilha.pop();
            resultado += caracter;
        }
        return resultado;
    }

    /**
     * Gera String apenas com as consoantes, com uso de fila
     * @param original String de entrada
     * @return Lista apenas com as consoantes da String original
     */
    public List<Character> retornaConsoantes(String original) {
        List<Character> resultado = new ArrayList<>();
        Queue<Character> fila = new LinkedList<>();
        for(int i=0; i< original.length(); i++) {
            char caracter = original.charAt(i);
            fila.add(caracter);
        }
        while(!fila.isEmpty()) {
            char caracter = fila.remove();
            if(isConsoante((caracter)))
                resultado.add(caracter);
        }
        return resultado;
    }

    /**
     * Verifica se um caracter e´ uma consoante
     * @param caracter Caracter a ser avaliado
     * @return true se e´ consoante, false em caso contrario
     */
    public boolean isConsoante(char caracter) {
        Set<Character> consoantes = new HashSet<>(Arrays.asList('B','C',
                'D','F','G','H','J','K','L','M','N','P','Q','R','S','T','V',
                'W','X','Y','Z'));
        char car = Character.toUpperCase(caracter);
        if(consoantes.contains(car))
            return true;
        return false;
    }

    /**
     * Gera uma String sem caracteres repetidos da String original
     * @param original String de entrada
     * @return String sem caracters da entrada
     */
    public String semRepeticoes(String original) {
        String resultado = "";
        Set<Character> conjunto = new HashSet<>();
        for(int i=0; i< original.length(); i++) {
            char caracter = original.charAt(i);
            if(!conjunto.contains(caracter)) {
                conjunto.add(caracter);
                resultado += original.charAt(i);
            }
        }
        return resultado;
    }

    /**
     * Gera uma String com pares: caracter;quantidade dos caracteres da String original
     * @param original String de entrada
     * @return String com pares caracter;quantidade
     */
    public String contaOcorrencias(String original) {
        String resultado = "";
        Map<Character,Integer> dicionario = new TreeMap<>();
        for(int i=0; i< original.length(); i++) {
            char caracter = original.charAt(i);
            if(dicionario.containsKey(caracter)) {
                int quantidade = dicionario.get(caracter);
                quantidade++;
                dicionario.put(caracter,quantidade);
            }
            else {
                dicionario.put(caracter,1);
            }
        }
        for(Entry<Character,Integer> entrada : dicionario.entrySet()) {
            char chave = entrada.getKey();
            int valor = entrada.getValue();
            resultado += chave+";"+valor+";";
        }

        // Remove o ultimo ';'
        if(resultado.length() > 0)
            resultado = resultado.substring(0,resultado.length()-1);

        return resultado;
    }

    public static void main(String[] args) {
        ExercicioColecoes exerc = new ExercicioColecoes();
        System.out.println(exerc.inverteString("Teste"));
        System.out.println("=========================");
        System.out.println(exerc.retornaConsoantes("Teste"));
        System.out.println("=========================");
        System.out.println(exerc.semRepeticoes("Teste"));
        System.out.println("=========================");
        System.out.println(exerc.contaOcorrencias("Teste"));
    }

}
