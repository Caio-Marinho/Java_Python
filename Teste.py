import jpype
import jpype.imports

jpype.startJVM(classpath=["./java_python"]) # o path é o diretorio da class e não arquivo
Calculadora = jpype.JClass("Calculadora")
n1 = int(input("Digite o numero 1: "))
n2 = int(input("Digite o numero 2: "))
calculadora = Calculadora(n1, n2)
print("Soma: ", calculadora.soma())