import jpype

jpype.startJVM(jpype.getDefaultJVMPath(), "-Djava.class.path=.")

Calculadora = jpype.JClass("Calculadora")
n1 = int(input("Digite o numero 1: "))
n2 = int(input("Digite o numero 2: "))

calc = Calculadora(n1, n2)
print("Soma: ", calc.soma())

jpype.shutdownJVM()