import sys
import json

# Definição de múltiplas funções
def soma(numeros):
    return sum(numeros)

def multiplica(numeros):
    resultado = 1
    for num in numeros:
        resultado *= num
    return resultado

def media(numeros):
    return sum(numeros) / len(numeros) if numeros else 0

# Lendo a entrada enviada pelo Java
entrada = sys.stdin.read().strip()

# Convertendo a string JSON recebida para um dicionário Python
dados = json.loads(entrada)

# Extraindo o nome da função e os argumentos
nome_funcao = dados.get("funcao")
argumentos = dados.get("argumentos", [])

# Criando um mapeamento de funções disponíveis
funcoes_disponiveis = {
    "soma": soma,
    "multiplica": multiplica,
    "media": media
}

# Executando a função correspondente
if nome_funcao in funcoes_disponiveis:
    resultado = funcoes_disponiveis[nome_funcao](argumentos)
else:
    resultado = f"Erro: Função '{nome_funcao}' não encontrada"

# Retornando o resultado para o Java
print(resultado)
