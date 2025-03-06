import java.io.*;

public class ChamarPythonArray {
    public static void main(String[] args) {
        try {
            // Criando o processo para executar o script Python
            ProcessBuilder pb = new ProcessBuilder("python", "script.py");
            pb.redirectErrorStream(true);
            Process process = pb.start();

            // Criando o array para enviar ao Python
            int[] numeros = {1, 2, 3, 4, 5};

            // Convertendo o array para uma string no formato JSON manualmente
            StringBuilder jsonArray = new StringBuilder("[");
            for (int i = 0; i < numeros.length; i++) {
                jsonArray.append(numeros[i]);
                if (i < numeros.length - 1) {
                    jsonArray.append(",");
                }
            }
            jsonArray.append("]");

            // Enviando o array via stdin
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            writer.write(jsonArray.toString() + "\n");
            writer.flush();
            writer.close();

            // Capturando a resposta do Python
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String resultado = reader.readLine();
            System.out.println("Soma dos elementos: " + resultado);

            // Aguardando o término do processo
            int exitCode = process.waitFor();
            System.out.println("Processo finalizado com código: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
