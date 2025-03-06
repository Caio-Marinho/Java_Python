import java.io.*;

public class ChamarPythonFuncao2{
    public static void main(String[] args) throws IOException, InterruptedException {
        String[] funcoes = {"soma", "multiplica", "media"};

        for (String funcao : funcoes) {
            chamarPython(funcao);
        }
    }

    private static void chamarPython(String funcao) throws IOException, InterruptedException {
        Process process = new ProcessBuilder("python", "script2.py").start();

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()))) {
            // Criando JSON manualmente
            String jsonInput = "{\"funcao\":\"" + funcao + "\",\"argumentos\":" + formatArray() + "}\n";
            writer.write(jsonInput);
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String resultado = reader.readLine();
            System.out.println(funcao + ": " + resultado);
        }

        process.waitFor();
    }

    private static String formatArray() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 1; i < 6; i++) {
            sb.append(i);
            if (i < 6 - 1) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }
}
