import java.io.*;

public class ChamarPythonFuncao{
    public static void main(String[] args) {
        try {
            // Criando o processo para executar o script Python
            ProcessBuilder pb = new ProcessBuilder("python", "script2.py");
            pb.redirectErrorStream(true);
            Process process = pb.start();

            // Criando o JSON manualmente
            String jsonInput = "{\"funcao\":\"soma\",\"argumentos\":[1,2,3,4,5]}";

            // Enviando JSON para o Python
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            writer.write(jsonInput + "\n");
            writer.flush();
            writer.close();

            // Capturando a resposta do Python
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String resultado = reader.readLine();
            System.out.println("Resultado Soma: " + resultado);

            // Aguardando o término do processo
            int exitCode = process.waitFor();
            System.out.println("Processo finalizado com código: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
