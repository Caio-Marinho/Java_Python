import java.io.*;
import java.util.Scanner;

public class ChamarPython {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            // Leitura dos números e operação a ser realizada
            int n1, n2; 
            String operacao;
            System.out.print("Digite o primeiro número: ");
            n1 = sc.nextInt();
            System.out.print("Digite o segundo número: ");
            n2 = sc.nextInt();
            System.out.print("Digite a operação: ");
            operacao = sc.next();
            sc.close();
            // Passando os parâmetros como uma lista separada
            ProcessBuilder pb = new ProcessBuilder("python", "Calculadora.py", Integer.toString(n1), Integer.toString(n2), operacao);
            pb.redirectErrorStream(true);
            Process processo = pb.start();

            // Capturando a saída do script Python
            BufferedReader reader = new BufferedReader(new InputStreamReader(processo.getInputStream()));
            String resultado = reader.readLine();
            System.out.println("Resultado do Python: " + resultado);

            // Aguardando o término do processo
            int exitCode = processo.waitFor();
            System.out.println("Processo finalizado com código: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
