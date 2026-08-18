Exercício 1: Lanchonete do Campus

A lanchonete do campus deseja um programa para registrar os produtos de um pedido e calcular o valor que deverá ser pago pelo cliente.

O programa deverá utilizar classes para representar os produtos, os itens comprados e o pedido.

Considere que a lanchonete possui o seguinte catálogo fixo:

Código	Produto	Preço
1	X-Salada	20.00
2	Suco	7.50
3	Batata Frita	12.00
4	Cafe	5.00
5	Pudim	10.00
O catálogo deverá ser criado pelo próprio programa. O atendente informará somente o código do produto e a quantidade desejada.

O programa deverá possuir, no mínimo, as seguintes classes:

Classe Produto
código;

nome;

preço.

Classe ItemPedido
um objeto da classe Produto;

a quantidade solicitada.

A classe deverá possuir uma operação para calcular o subtotal do item:

subtotal do item = preço do produto × quantidade

Classe Pedido
Coleção de objetos da classe ItemPedido.

A classe deverá possuir operações para:

adicionar um produto ao pedido;

calcular o subtotal do pedido;

calcular o desconto;

calcular o valor total.

Quando um produto que já está no pedido for informado novamente, sua nova quantidade deverá ser somada à quantidade existente. Portanto, o produto deverá aparecer apenas uma vez na saída.

Os produtos deverão ser exibidos na ordem em que foram adicionados pela primeira vez.

Regras de validação
Um item será considerado inválido quando:

o código do produto não estiver entre 1 e 5;

a quantidade for menor ou igual a zero.

Itens inválidos deverão ser ignorados e não deverão aparecer na saída.

Regra de desconto
Pedidos com subtotal maior ou igual a 100.00 receberão desconto de 10%.

desconto = subtotal × 0.10
Pedidos com subtotal menor que 100.00 não receberão desconto.

total = subtotal - desconto

Formato da entrada
A primeira linha contém um número inteiro N, representando a quantidade de registros que serão informados.

As próximas N linhas possuem dois números inteiros, respectivamente: codigo quantidade

 
Exemplo:

3
1 2
2 1
4 3
Formato da saída
Todos os valores monetários deverão ser exibidos com exatamente duas casas decimais, utilizando ponto como separador decimal. Não deverão ser impressas linhas em branco, mensagens de solicitação de entrada ou textos adicionais.

A primeira linha deverá ser:

PEDIDO
Para cada produto válido e diferente presente no pedido, deverá ser apresentada uma linha no seguinte formato:

<nome> <quantidade> x <preco> = <subtotal>
Depois dos itens, deverão ser apresentadas as linhas:

SUBTOTAL: <subtotal do pedido>
DESCONTO: <desconto>
TOTAL: <total>
Pedido sem itens válidos
Caso nenhum item válido seja informado, a saída deverá ser:

PEDIDO
NENHUM ITEM VALIDO
SUBTOTAL: 0.00
DESCONTO: 0.00
TOTAL: 0.00
Exemplo
Entrada
4
2 1
1 2
2 3
4 1
Saída
PEDIDO
Suco 4 x 7.50 = 30.00
X-Salada 2 x 20.00 = 40.00
Cafe 1 x 5.00 = 5.00
SUBTOTAL: 75.00
DESCONTO: 0.00
TOTAL: 75.00