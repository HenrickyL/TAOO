Contexto
Uma biblioteca universitária está desenvolvendo um pequeno módulo responsável por aplicar as regras de empréstimo de seus materiais.

A implementação do módulo já foi desenvolvida. Sua responsabilidade nesta atividade não é modificar ou refatorar esse código, mas criar uma bateria de testes automatizados capaz de verificar se sua implementação está correta.

Serão disponibilizadas versões equivalentes do módulo em:

Python, para testes com pytest; ou
Java, para testes com JUnit.
Escolha uma das linguagens.

Seu objetivo é pensar cuidadosamente nos diferentes comportamentos que precisam ser testados. Uma boa bateria de testes não deve verificar apenas exemplos comuns: deve considerar diferentes categorias de entrada, situações especiais e valores localizados nas fronteiras entre regras.

Sua tarefa
Crie uma bateria de testes automatizados que verifique o comportamento do módulo.

Você deve decidir:

quantos testes são necessários;
quais entradas devem ser utilizadas;
quais resultados devem ser verificados;
quais valores-limite são relevantes;
quais combinações de condições merecem testes diferentes.
Não existe uma quantidade mínima de testes que garanta uma boa nota.

Uma bateria com muitos testes repetitivos pode ser menos eficaz que uma bateria menor que selecione cuidadosamente situações distintas.

Não altere a implementação fornecida.

Entrega
Caso escolha Python, entregue o arquivo:

test_politica_emprestimo.py
Caso escolha Java, entregue o arquivo:

PoliticaEmprestimoTest.java


Como seus testes serão avaliados
 
A avaliação não verificará se os testes escritos por você são iguais aos testes elaborados pelo professor.

 
Em vez disso, sua bateria será executada sobre diferentes implementações do módulo.

 
Primeiro, seus testes serão executados sobre uma implementação correta.

 
Todos devem passar.

 
Depois, a mesma bateria será executada sobre diferentes implementações contendo defeitos.

 
Por exemplo, uma implementação poderá conter uma regra incorreta de prazo, um problema em um valor-limite ou deixar de considerar alguma condição necessária para uma renovação.

 
Uma boa bateria de testes deverá:

 
passar quando o sistema estiver correto;
falhar quando o comportamento do sistema estiver incorreto.
 
Dessa forma, a avaliação considera principalmente a capacidade dos seus testes de revelar defeitos.