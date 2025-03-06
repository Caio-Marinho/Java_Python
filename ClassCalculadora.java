

public class ClassCalculadora {
    private int n1;
    private int n2;

    public ClassCalculadora(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    public int soma() {
        return n1 + n2;
    }

    public int subtracao() {
        return n1 - n2;
    }

    public int multiplicacao() {
        return n1 * n2;
    }

    public double divisao() {
        return (n2 != 0) ? (double) n1 / n2 : Double.NaN;
    }

    public static void main(String[] args){
            
        int n1 = Integer.parseInt(args[0]);
        int n2 = Integer.parseInt(args[1]);
        String operacao = args[2];
        
        if (operacao.equals("+")){
            operacao = "soma";
        } else if(operacao.equals("-")){
            operacao = "subtracao";
        } else if(operacao.equals("*") || operacao.equals("x")){
            operacao = "multiplicacao";
        } else if(operacao.equals("/")){
            operacao = "divisao";
        }
        // Criando instância da classe
        ClassCalculadora calc = new ClassCalculadora(n1, n2);

        // Executando operação baseada na entrada
        double resultado = switch (operacao) {
            case "soma" -> calc.soma();
            case "subtracao" -> calc.subtracao();
            case "multiplicacao" -> calc.multiplicacao();
            case "divisao" -> calc.divisao();
            default -> Double.NaN;
        };

        // Enviando o resultado de volta para o Python
        System.out.println(resultado);
    }
}
