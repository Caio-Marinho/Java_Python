import jpype
import jpype.imports

jpype.startJVM(classpath=["."])
Calculadora = jpype.JClass("Calculadora")
n1 = int(input("Digite o numero 1: "))
n2 = int(input("Digite o numero 2: "))
calc = Calculadora(n1, n2)
print("Soma: ", calc.subtracao())

jpype.shutdownJVM()