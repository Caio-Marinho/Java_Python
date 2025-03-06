import subprocess

def chamar_java(numeros: list[int]) -> int:
    """Executa a classe Java passando números como argumento."""
    comando = ["java", "MinhaClasse"] + list(map(str, numeros))  # Converte números para string
    resultado = subprocess.run(comando, capture_output=True, text=True)

    if resultado.returncode == 0:
        return int(resultado.stdout.strip())  # Retorna o valor processado pelo Java
    else:
        print("Erro ao chamar Java:", resultado.stderr)
        return None

# Testando
numeros = [1, 2, 3, 4, 5]
soma = chamar_java(numeros)
print("Resultado da soma:", soma)
