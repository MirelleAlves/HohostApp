# 📊 Diagramas UML do Sistema

## Visão Geral do Sistema

## 🔹 Caso de uso
### Diagrama de Casos de Uso

O diagrama de casos de uso descreve as interações entre os usuários (atores) e o sistema. Para o HohostApp, podemos identificar os seguintes atores e casos de uso:
Atores:
- Cliente
- Anfitrião
- Administrador

Casos de Uso:<br>
Cliente:
- Registrar-se
- Buscar acomodações
- Reservar acomodação
- Efetuar pagamento
- Cancelar reserva
- Avaliar acomodação

Anfitrião:
- Registrar-se
- Cadastrar acomodação
- Gerenciar reservas
- Confirmar ou rejeitar reservas
- Visualizar avaliações

Administrador:
- Gerenciar usuários
- Monitorar atividades do sistema

## 🔹 Diagrama de Atividade
### Diagrama de Atividades

O diagrama de atividades mostra o fluxo de trabalho ou o processo de um caso de uso.
Vamos ilustrar o processo de Reserva de Acomodação:

Cliente inicia o processo de reserva.
Sistema exibe lista de acomodações disponíveis.
Cliente seleciona uma acomodação.
Sistema solicita dados para reserva (data de entrada, data de saída, forma de pagamento).
Cliente fornece informações e confirma.
Sistema verifica disponibilidade.

- Se disponível:
Reserva é criada.
Notificação é enviada ao Anfitrião.
Anfitrião confirma ou rejeita.

- Se confirmado:
Cliente realiza pagamento.
Reserva é finalizada.

- Se rejeitado:
Cliente é notificado.
Processo é encerrado.

## 🔹 Diagrama de Classes
### Diagrama de Classes

O diagrama de classes representa a estrutura do sistema, mostrando as classes, seus atributos, métodos e os relacionamentos entre elas. Com base no código fornecido, temos:

- Classe Reserva:
> Atributos: id, dataEntrada, dataSaida, formaPagamento, status, cliente, acomodacao, anfitriao
> Métodos: getId(), setId(), getDataEntrada(), setDataEntrada(), getDataSaida(), setDataSaida(), getFormaPagamento(), setFormaPagamento(), getStatus(), setStatus(), getCliente(), setCliente(), getAcomodacao(), setAcomodacao(), getAnfitriao(), setAnfitriao()

- Classe Cliente:
> Atributos: id, nome, email, senha
> Métodos: getId(), setId(), getNome(), setNome(), getEmail(), setEmail(), getSenha(), setSenha()

- Classe Acomodacao:
> Atributos: id, descricao, preco, tipo, disponibilidade
> Métodos: getId(), setId(), getDescricao(), setDescricao(), getPreco(), setPreco(), getTipo(), setTipo(), getDisponibilidade(), setDisponibilidade()

- Classe Anfitriao:
> Atributos: id, nome, email, senha
> Métodos: getId(), setId(), getNome(), setNome(), getEmail(), setEmail(), getSenha(), setSenha()

## 🔹 Diagrama de Estados
Diagrama de Estados

O diagrama de estados descreve os estados pelos quais um objeto passa durante seu ciclo de vida.
Para a Reserva, os estados podem ser:

Pendente: Reserva criada, aguardando confirmação.<br>
Confirmada: Reserva confirmada pelo anfitrião ou sistema.<br>
Rejeitada: Anfitrião recusou a reserva.<br>
Cancelada: Cliente ou anfitrião cancelou.<br>
Check-in: Cliente realizou o check-in.<br>
Check-out: Cliente finalizou a estadia.<br>
Não Apareceu: Cliente não compareceu.<br>
Concluída: Reserva finalizada com sucesso.