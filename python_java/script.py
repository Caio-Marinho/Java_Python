import sys
import json

# Lendo a entrada enviada pelo Java
entrada = sys.stdin.read().strip()

# Convertendo a string para uma lista de números
numeros = json.loads(entrada)  # Interpreta a string como um array JSON

# Calculando a soma dos números
resultado = sum(numeros)

# Enviando o resultado de volta para o Java
print(resultado)
