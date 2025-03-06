public class Argumentos {
    public static void main(String[] args) {
        // Verifica se foram passados argumentos
        if (args.length > 0) {
            System.out.println("Argumentos recebidos:");
            for (String arg : args) {
                System.out.println(arg);
            }
        } else {
            System.out.println("Nenhum argumento foi passado.");
        }
    }
}
