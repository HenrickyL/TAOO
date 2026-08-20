Política de empréstimos
O sistema considera dois perfis de usuário:

ALUNO
PROFESSOR
E três tipos de material:

LIVRO
REVISTA
MIDIA
Prazo de empréstimo
O método responsável pelo prazo recebe o perfil do usuário e o tipo de material e devolve o número máximo de dias do empréstimo.

Os prazos são:

ALUNO + LIVRO: 14 dias
ALUNO + REVISTA: 7 dias
ALUNO + MIDIA: 3 dias
PROFESSOR + LIVRO: 30 dias
PROFESSOR + REVISTA: 14 dias
PROFESSOR + MIDIA: 7 dias
Em Python:

PoliticaEmprestimo.prazo_emprestimo(perfil, material)
Em Java:

PoliticaEmprestimo.prazoEmprestimo(perfil, material)

Multa por atraso
 
A multa depende do tipo de material:

 
LIVRO: R$ 1,00 por dia
REVISTA: R$ 1,50 por dia
MIDIA: R$ 3,00 por dia
 
Quando não existe atraso (dias_atraso == 0), a multa é zero.

 
Nos primeiros 10 dias de atraso, aplica-se a multa diária normal.

 
A partir do 11º dia, cada dia adicional é cobrado pelo dobro da multa diária.

 
Por exemplo:

 
Um livro com 10 dias de atraso:

 
10 x 1,00 = R$ 10,00
 
Um livro com 11 dias de atraso:

 
10 x 1,00 + 1 x 2,00 = R$ 12,00
 
Em Python:

 
PoliticaEmprestimo.calcular_multa(material, dias_atraso)
 
Em Java:

 
PoliticaEmprestimo.calcularMulta(material, diasAtraso)
 
Renovação
O método de renovação recebe:

perfil do usuário;
tipo do material;
quantidade de dias de atraso;
informação sobre a existência de reserva para o material;
quantidade de renovações já realizadas.
Em Python:

PoliticaEmprestimo.pode_renovar(
    perfil,
    material,
    dias_atraso,
    possui_reserva,
    renovacoes_realizadas
)
Em Java:

PoliticaEmprestimo.podeRenovar(
    perfil,
    material,
    diasAtraso,
    possuiReserva,
    renovacoesRealizadas
)
As seguintes regras são aplicadas:

Um empréstimo atrasado não pode ser renovado.
Um material que possui reserva de outro usuário não pode ser renovado.
Materiais do tipo MIDIA não podem ser renovados.
REVISTA pode ser renovada no máximo uma vez, independentemente do perfil.
Um LIVRO emprestado por ALUNO pode ser renovado no máximo duas vezes.
Um LIVRO emprestado por PROFESSOR pode ser renovado no máximo três vezes.
Observe que mais de uma dessas condições pode ser verdadeira ao mesmo tempo.

Dados inválidos
Quando for informado um perfil inexistente ou um tipo de material inexistente, o sistema deverá indicar erro:

Python: ValueError
Java: IllegalArgumentException