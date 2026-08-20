import pytest
from politica_emprestimo import PoliticaEmprestimo

@pytest.fixture
def politicaEmprestimo():
    yield PoliticaEmprestimo

def test_perfil_invalido():
    with pytest.raises(ValueError) as excinfo:
        PoliticaEmprestimo._validar_perfil("INVALIDO")
    assert str(excinfo.value) == "Perfil inválido"

def test_prazo_emprestimo_invalido():
    with pytest.raises(ValueError) as excinfo:
        PoliticaEmprestimo.prazo_emprestimo("INVALIDO", "LIVRO")
    assert str(excinfo.value) == "Perfil inválido"
    with pytest.raises(ValueError) as excinfo:
        PoliticaEmprestimo.prazo_emprestimo("ALUNO", "INVALIDO")
    assert str(excinfo.value) == "Material inválido"

def test_pode_renovar_invalido():
    with pytest.raises(ValueError) as excinfo:
        PoliticaEmprestimo.pode_renovar("INVALIDO", "LIVRO", None, None, None) 
    assert str(excinfo.value) == "Perfil inválido"
    with pytest.raises(ValueError) as excinfo:
        PoliticaEmprestimo.pode_renovar("ALUNO", "INVALIDO", None, None, None)
    assert str(excinfo.value) == "Material inválido"

def test_material_invalido():
    with pytest.raises(ValueError) as excinfo:
        PoliticaEmprestimo._validar_material("INVALIDO")
    assert str(excinfo.value) == "Material inválido"

def test_multa_invalida():
    with pytest.raises(ValueError) as excinfo:
        PoliticaEmprestimo.calcular_multa("INVALIDO", 0)
    assert str(excinfo.value) == "Material inválido"

def test_multa_sem_atraso(politicaEmprestimo):
    multa = politicaEmprestimo.calcular_multa("LIVRO", 0)
    assert multa == 0
    multa = politicaEmprestimo.calcular_multa("REVISTA", 0)
    assert multa == 0
    multa = politicaEmprestimo.calcular_multa("MIDIA", 0)
    assert multa == 0

@pytest.mark.parametrize("i", range(10))
def test_multa_simples(politicaEmprestimo, i):
    multa = politicaEmprestimo.calcular_multa("LIVRO", i+1)
    assert multa == (i+1) * 1
    multa = politicaEmprestimo.calcular_multa("REVISTA", i+1)
    assert multa == (i+1) * 1.5
    multa = politicaEmprestimo.calcular_multa("MIDIA", i+1)
    assert multa == (i+1) * 3

def test_multa_extra(politicaEmprestimo):
    multa = politicaEmprestimo.calcular_multa("LIVRO", 11)
    assert multa == 12
    multa = politicaEmprestimo.calcular_multa("REVISTA", 11)
    assert multa == 18
    multa = politicaEmprestimo.calcular_multa("MIDIA", 11)
    assert multa == 36

def test_can_renovar_emprestimo():
    #arrange
    perfil = 'ALUNO'
    material ='LIVRO'
    dia_atraso=0
    possui_reserva=False
    renovacoes_realizadas=0
    #act
    result = PoliticaEmprestimo.pode_renovar(perfil, material, dia_atraso, possui_reserva, renovacoes_realizadas)
    #assert
    assert result == True

def test_cannot_renovar_emprestimo_perfil_invalido():
    #arrange
    perfil = 'invalido'
    material ='LIVRO'
    dia_atraso=0
    possui_reserva=False
    renovacoes_realizadas=0
    #act
    with pytest.raises(ValueError) as excinfo:
        result = PoliticaEmprestimo.pode_renovar(perfil, material, dia_atraso, possui_reserva, renovacoes_realizadas)
    #assert
    assert str(excinfo.value) == "Perfil inválido"

def test_cannot_renovar_emprestimo_renovacao_invalida():
    #arrange
    perfil = 'ALUNO'
    material ='LIVRO'
    dia_atraso=0
    possui_reserva=False
    renovacoes_realizadas=-1
    #act
    with pytest.raises(ValueError) as excinfo:
        result = PoliticaEmprestimo.pode_renovar(perfil, material, dia_atraso, possui_reserva, renovacoes_realizadas)
    #assert
    assert str(excinfo.value) == "Número de renovações inválido"


def test_cannot_renovar_emprestimo_atrasado():
    #arrange
    perfil = 'ALUNO'
    material ='LIVRO'
    dia_atraso=1
    possui_reserva=False
    renovacoes_realizadas=0
    #act
    result = PoliticaEmprestimo.pode_renovar(perfil, material, dia_atraso, possui_reserva, renovacoes_realizadas)
    #assert
    assert result == False

def test_cannot_renovar_emprestimo_reserva():
    '''
    Um material que possui reserva de outro usuário não pode ser renovado
    '''
    #arrange
    perfil = 'ALUNO'
    material ='LIVRO'
    dia_atraso=0
    possui_reserva=True
    renovacoes_realizadas=0
    #act
    result = PoliticaEmprestimo.pode_renovar(perfil, material, dia_atraso, possui_reserva, renovacoes_realizadas)
    #assert
    assert result == False

def test_cannot_renovar_emprestimo_nao_midia():
    '''
    Materiais do tipo MIDIA não podem ser renovados.
    '''
    #arrange
    perfil = 'ALUNO'
    material ='MIDIA'#
    dia_atraso=0
    possui_reserva=True
    renovacoes_realizadas=0
    #act
    result = PoliticaEmprestimo.pode_renovar(perfil, material, dia_atraso, possui_reserva, renovacoes_realizadas)
    #assert
    assert result == False

@pytest.mark.parametrize("perfil",[
    'ALUNO',
    'PROFESSOR'
])
def test_cannot_renovar_emprestimo_nao_revista(perfil):
    '''
    REVISTA pode ser renovada no máximo uma vez, independentemente do perfil.
    '''
    #arrange
    # perfil = 'ALUNO'
    material ='REVISTA' #
    dia_atraso=0
    possui_reserva=False
    renovacoes_realizadas=2 #
    #act
    result = PoliticaEmprestimo.pode_renovar(perfil, material, dia_atraso, possui_reserva, renovacoes_realizadas)
    #assert
    assert result == False

def test_cannot_renovar_emprestimo_aluno_max():
    '''
    Um LIVRO emprestado por ALUNO pode ser renovado no máximo duas vezes.    
    '''
    #arrange
    perfil = 'ALUNO'
    material ='LIVRO' 
    dia_atraso=0
    possui_reserva=False
    renovacoes_realizadas=3
    #act
    result = PoliticaEmprestimo.pode_renovar(perfil, material, dia_atraso, possui_reserva, renovacoes_realizadas)
    #assert
    assert result == False

def test_cannot_renovar_emprestimo_prof_max():
    '''
    Um LIVRO emprestado por PROFESSOR pode ser renovado no máximo três vezes.    
    '''
    #arrange
    perfil = 'PROFESSOR'
    material ='LIVRO' 
    dia_atraso=0
    possui_reserva=False
    renovacoes_realizadas=4
    #act
    result = PoliticaEmprestimo.pode_renovar(perfil, material, dia_atraso, possui_reserva, renovacoes_realizadas)
    #assert
    assert result == False