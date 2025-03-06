import java.util.Arrays;

public class MinhaClasse {
    public static void main(String[] args) {
        // Convertendo os argumentos para números inteiros
        int[] numeros = Arrays.stream(args)
                              .mapToInt(Integer::parseInt)
                              .toArray();

        // Calculando a soma
        int soma = Arrays.stream(numeros).sum();

        // Imprimindo a soma (Python vai capturar isso)
        System.out.println(soma);
    }
}
