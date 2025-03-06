import sys
# Calculadora.py (Classe Python)
class Calculadora:
    def __init__(self, n1, n2):
        self.n1 = n1
        self.n2 = n2

    def soma(self):
        return self.n1 + self.n2

    def subtracao(self):
        return self.n1 - self.n2

    def multiplicacao(self):
        return self.n1 * self.n2

    def divisao(self):
        if self.n2 != 0:
            return self.n1 / self.n2
        else:
            return "Erro: Divisão por zero"

# Código para executar a partir do Python
if __name__ == "__main__":
    n1 = int(sys.argv[1])
    n2 = int(sys.argv[2])
    operacao = sys.argv[3]
    

    calc = Calculadora(n1, n2)

    if operacao == "soma" or operacao == "+":
        print(f"Soma: {calc.soma()}")
    elif operacao == "subtracao" or operacao == "-":
        print(f"Subtração: {calc.subtracao()}")
    elif operacao == "multiplicacao" or operacao == "*" or operacao == "x":
        print(f"Multiplicação: {calc.multiplicacao()}")
    elif operacao == "divisao" or operacao == "/":
        print(f"Divisão: {calc.divisao()}")
    else:
        print("Operação inválida")
