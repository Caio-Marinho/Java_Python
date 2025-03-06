import subprocess

n1 = int(input("Digite o numero 1: "))
n2 = int(input("Digite o numero 2: "))
operacao = input("Digite a operacao: ")

comando = ["java", "ClassCalculadora", str(n1), str(n2), operacao]
resultado = subprocess.run(comando, capture_output=True, text=True)

if resultado.returncode == 0:
    print("Resultado:", resultado.stdout.strip())
else:
    print("Erro ao chamar Java:", resultado.stderr)