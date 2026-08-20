Exercício 2: Controle de um Estacionamento
Um estacionamento deseja um programa para registrar veículos e calcular o valor devido por cada um deles. O estacionamento recebe carros e motocicletas. Cada tipo de veículo possui uma forma diferente de calcular o preço da permanência.

O programa deverá utilizar herança e polimorfismo para representar os diferentes tipos de veículos.

Além disso, deverá possuir, no mínimo, as seguintes classes:

Classe Veiculo
A classe deverá armazenar:

placa;

quantidade de horas estacionadas.

A classe deverá definir uma operação chamada calcularValor.

Essa operação deverá ser redefinida pelas classes que representam os tipos específicos de veículo.

Classe Carro
Deverá herdar da classe Veiculo.

O valor de estacionamento de um carro será calculado da seguinte forma:

primeira hora: 8.00;

cada hora adicional: 4.00;

valor máximo cobrado: 30.00.

 
Classe Motocicleta
Deverá herdar da classe Veiculo.

O valor de estacionamento de uma motocicleta será calculado da seguinte forma:

primeira hora: 5.00;

cada hora adicional: 2.00;

valor máximo cobrado: 18.00.

Classe Estacionamento
Deverá armazenar uma coleção de objetos da classe Veiculo.

A classe deverá possuir operações para:

registrar um veículo;

calcular o valor total arrecadado;

informar a quantidade de veículos válidos registrados.

O cálculo do valor de cada veículo deverá ser realizado de forma polimórfica, chamando a operação calcularValor do próprio objeto.

Regras de validação
Os tipos de veículo aceitos são: C para carro, e M para motocicleta.

 
 
Um registro será considerado inválido quando:

o tipo for diferente de C e M;

a quantidade de horas for menor ou igual a zero.

Registros inválidos deverão ser ignorados e não deverão aparecer na saída.

A placa será uma sequência de caracteres sem espaços. Não é necessário validar seu formato.

Formato da entrada
A primeira linha contém um número inteiro N, representando a quantidade de registros que serão informados.

As próximas N linhas possuem o seguinte formato:

<tipo> <placa> <horas>
Exemplo:

3
C ABC1234 2
M XYZ9876 4
C DEF5678 1
A quantidade de horas será sempre representada por um número inteiro.

Formato da saída
A primeira linha deverá ser:

ESTACIONAMENTO
Para cada veículo válido, deverá ser apresentada uma linha no seguinte formato:

<placa> - <tipo por extenso> - <horas> h - R$ <valor>
O tipo por extenso deverá ser exatamente CARRO para carros e MOTO para motocicletas.

 
 
Depois dos veículos, deverão ser apresentadas as linhas:

VEICULOS: <quantidade>
TOTAL: R$ <valor total>
Todos os valores monetários deverão ser exibidos com exatamente duas casas decimais, utilizando ponto como separador decimal.

Os veículos deverão aparecer na mesma ordem em que foram informados na entrada.

Não deverão ser impressas linhas em branco, mensagens de solicitação de entrada ou textos adicionais.

Estacionamento sem veículos válidos
Caso nenhum registro válido seja informado, a saída deverá ser:

ESTACIONAMENTO
NENHUM VEICULO VALIDO
VEICULOS: 0
TOTAL: R$ 0.00
Exemplo
Entrada
2
C ABC1234 3
M XYZ9876 2
Saída
ESTACIONAMENTO
ABC1234 - CARRO - 3 h - R$ 16.00
XYZ9876 - MOTO - 2 h - R$ 7.00
VEICULOS: 2
TOTAL: R$ 23.00