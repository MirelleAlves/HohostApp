# 📊 Diagramas UML do Sistema

## Visão Geral do Sistema

## 🔹 Diagrama de Caso de uso
![Diagrama de Caso de uso](image-3.png)

```puml
@startuml
left to right direction

actor Cliente
actor Anfitriao

rectangle HohostApp {
  (Registrar-se) as UC_Registrar
  (Buscar acomodações) as UC_Buscar
  (Reservar acomodação) as UC_Reservar
  (Efetuar pagamento) as UC_Pagamento
  (Cancelar reserva) as UC_Cancelar
  (Cadastrar acomodação) as UC_Cadastrar
  (Gerenciar reservas) as UC_Gerenciar
  (Confirmar ou rejeitar reservas) as UC_Confirmar
}


Cliente --> UC_Registrar
Cliente --> UC_Buscar
Cliente --> UC_Reservar
Cliente --> UC_Pagamento
Cliente --> UC_Cancelar

Anfitriao --> UC_Cancelar
Anfitriao --> UC_Registrar
Anfitriao --> UC_Cadastrar
Anfitriao --> UC_Gerenciar
Anfitriao --> UC_Confirmar

@enduml
```

## 🔹 Diagramas de Atividades

### Registrar-se (Cliente / Anfitrião):
![Registrar-se (Cliente / Anfitrião)](image-10.png)

```puml
@startuml
start
:Usuário acessa tela de cadastro;
:Sistema solicita dados (nome, email, telefone...);
:Usuário preenche informações;
:Sistema valida dados;
if (Dados válidos?) then (Sim)
  :Sistema cria conta;
  :Usuário é notificado do sucesso;
else (Não)
  :Sistema exibe erro;
endif
stop
@enduml
```
### Buscar acomodações:
![Buscar acomodações](image-9.png)

```puml
@startuml
start
:Cliente acessa tela de busca;
:Sistema exibe filtros (localização, data, preço...);
:Cliente aplica filtros;
:Sistema exibe lista de acomodações disponíveis;
stop
@enduml
```
### Reservar acomodação:
![Reservar Acomodação](image-2.png)

```puml
@startuml
start

:Cliente inicia o processo de reserva;

repeat
  :Sistema exibe lista de acomodações disponíveis;
  :Cliente seleciona uma acomodação;
  :Sistema solicita dados para reserva;
  :Cliente fornece informações e confirma;
  :Sistema verifica disponibilidade;

  if (Acomodação disponível?) then (Sim)
    :Reserva é criada;
    :Notificação enviada ao Anfitrião;

    if (Anfitrião confirma?) then (Sim)
      :Cliente realiza pagamento;
      :Reserva Confirmada;
      stop
    else (Não)
      :Cliente é notificado (Reserva Rejeitada);
      stop
    endif

  else (Não)
    :Cliente é notificado (Acomodação indisponível para reserva);
  endif

repeat while (Deseja escolher outra acomodação?) is (Sim)
:Processo encerrado;
stop
@enduml
```
### Efetuar pagamento:
![Efetuar pagamento](image-8.png)

```puml
@startuml
start
:Cliente acessa tela de pagamento;
:Sistema exibe opções (cartão, pix, etc.);
:Cliente escolhe forma de pagamento;
:Sistema processa transação;

if (Pagamento aprovado?) then (Sim)
  :Sistema confirma pagamento;
  :Cliente é notificado de sucesso;
else (Não)
  :Sistema exibe erro (pagamento recusado);
endif
stop
@enduml
```
### Cancelar reserva:
![Cancelar reserva](image-7.png)

```puml
@startuml
start
:Cliente acessa reservas;
:Seleciona reserva para cancelamento;
:Sistema valida política de cancelamento;

if (Cancelamento permitido?) then (Sim)
  :Reserva é cancelada;
  :Anfitrião é notificado;
  :Cliente recebe confirmação;
else (Não)
  :Sistema informa que não é possível cancelar;
endif
stop
@enduml
```
### Cadastrar acomodação:
![Cadastrar acomodação](image-6.png)

```puml
@startuml
start
:Anfitrião acessa painel;
:Seleciona "Cadastrar acomodação";
:Sistema solicita dados (nome, endereço, titulo...);
:Anfitrião preenche informações;
:Sistema valida dados;
if (Dados válidos?) then (Sim)
  :Acomodação cadastrada;
  :Anfitrião recebe confirmação;
else (Não)
  :Sistema exibe erro;
endif
stop
@enduml
```
### Gerenciar reservas:
![Gerenciar reservas](image-4.png)

```puml
@startuml
start
:Anfitrião acessa painel de reservas;
:Sistema exibe lista de reservas pendentes e finalizadas;

repeat
  if (Deseja pesquisar reserva?) then (Sim)
    :Anfitrião insere critérios de busca;
    :Sistema retorna resultados filtrados;
  endif

  :Anfitrião seleciona uma reserva;

  if (Deseja alterar reserva?) then (Sim)
    :Anfitrião modifica informações permitidas (datas, forma de pagamento...);
    :Sistema valida alterações;
    if (Alterações válidas?) then (Sim)
      :Sistema atualiza a reserva;
      :Anfitrião é notificado do sucesso;
    else (Não)
      :Sistema exibe erro;
      if (Deseja tentar novamente?) then (Sim)
        :Anfitrião corrige informações;
      else (Não)
        :Processo encerrado;
        stop
      endif
    endif
  else (Não)
    :Anfitrião apenas visualiza detalhes da reserva;
  endif

repeat while (Deseja visualizar outra reserva?) is (Sim)

:Processo encerrado;
stop
@enduml

```
### Confirmar ou rejeitar reservas:
![Confirmar ou rejeitar reservas](image-5.png)

```puml
@startuml
start
:Anfitrião acessa lista de reservas pendentes;
:Seleciona uma reserva;
:Escolhe "Confirmar" ou "Rejeitar";

if (Confirmar?) then (Sim)
  :Reserva confirmada;
  :Cliente é notificado;
else (Rejeitar)
  :Reserva rejeitada;
  :Cliente é notificado;
endif
stop
@enduml
```
## 🔹 Diagrama de Classes
![Diagrama de Classes](image.png)

```puml
@startuml
skinparam classAttributeIconSize 0

class Acomodacao {
    - Long id
    - String titulo
    - String descricao
    - String endereco
    - String cidade
    - String estado
    - String tipo
    - Double precoPorNoite
    - Integer quantidadeQuartos
    - Integer quantidadeBanheiros
    - Integer capacidade
    - Boolean wifi
    - Boolean estacionamento
    - Boolean animaisPermitidos
    - Boolean disponivel
    - Anfitriao anfitriao
    - Reserva reserva
    --
    + getId(): Long
    + setId(Long)
    + getTitulo(): String
    + setTitulo(String)
    + getDescricao(): String
    + setDescricao(String)
    + getEndereco(): String
    + setEndereco(String)
    + getCidade(): String
    + setCidade(String)
    + getEstado(): String
    + setEstado(String)
    + getTipo(): String
    + setTipo(String)
    + getPrecoPorNoite(): Double
    + setPrecoPorNoite(Double)
    + getQuantidadeQuartos(): Integer
    + setQuantidadeQuartos(Integer)
    + getQuantidadeBanheiros(): Integer
    + setQuantidadeBanheiros(Integer)
    + getCapacidade(): Integer
    + setCapacidade(Integer)
    + getWifi(): Boolean
    + setWifi(Boolean)
    + getEstacionamento(): Boolean
    + setEstacionamento(Boolean)
    + getAnimaisPermitidos(): Boolean
    + setAnimaisPermitidos(Boolean)
    + getDisponivel(): Boolean
    + setDisponivel(Boolean)
    + equals(Object): Boolean
    + toString(): String
}

class Anfitriao {
    - Long id
    - String nome
    - String telefone
    - String email
    - String estado
    - String cidadeAtuacao
    - List<Acomodacao> acomodacoes
    - List<Reserva> reservas
    --
    + getId(): Long
    + setId(Long)
    + getNome(): String
    + setNome(String)
    + getTelefone(): String
    + setTelefone(String)
    + getEmail(): String
    + setEmail(String)
    + getEstado(): String
    + setEstado(String)
    + getCidadeAtuacao(): String
    + setCidadeAtuacao(String)
    + equals(Object): Boolean
    + toString(): String
}

class Cliente {
    - Long id
    - String nome
    - String telefone
    - String email
    - String cpf
    - List<Reserva> reservas
    --
    + getId(): Long
    + setId(Long)
    + getNome(): String
    + setNome(String)
    + getTelefone(): String
    + setTelefone(String)
    + getEmail(): String
    + setEmail(String)
    + getCpf(): String
    + setCpf(String)
    + equals(Object): Boolean
    + toString(): String
}

class Reserva {
    - Long id
    - String dataEntrada
    - String dataSaida
    - String formaPagamento
    - StatusReserva status
    - Cliente cliente
    - Acomodacao acomodacao
    - Anfitriao anfitriao
    --
    + getId(): Long
    + setId(Long)
    + getDataEntrada(): String
    + setDataEntrada(String)
    + getDataSaida(): String
    + setDataSaida(String)
    + getFormaPagamento(): String
    + setFormaPagamento(String)
    + getStatus(): StatusReserva
    + setStatus(StatusReserva)
    + equals(Object): Boolean
    + toString(): String
}

class ReservaInput {
    - Long idCliente
    - Long idAcomodacao
    - String dataEntrada
    - String dataSaida
    - String formaPagamento
    --
    + getIdCliente(): Long
    + setIdCliente(Long)
    + getIdAcomodacao(): Long
    + setIdAcomodacao(Long)
    + getDataEntrada(): String
    + setDataEntrada(String)
    + getDataSaida(): String
    + setDataSaida(String)
    + getFormaPagamento(): String
    + setFormaPagamento(String)
}
note right: classe auxiliar para realização da reserva

enum StatusReserva {
    PENDENTE
    CONFIRMADA
    REJEITADA
    CANCELADA
    CHECK_IN
    CHECK_OUT
    NAO_APARECEU
    CONCLUIDA
}


Anfitriao "1" -- "many" Acomodacao : > é responsável por
Anfitriao "1" -- "many" Reserva : gerencia >
Cliente "1" -- "many" Reserva : realiza >
Acomodacao "1" -- "many" Reserva : reservada por >
Reserva -- StatusReserva : < pertence
Reserva --> Acomodacao : tem

@enduml
```

- Classe Acomodacao:

> Atributos: id, titulo, descricao, endereco, cidade, estado, tipo, precoPorNoite, quantidadeQuartos, quantidadeBanheiros, capacidade, wifi, estacionamento, animaisPermitidos, disponivel, anfitriao, reserva<br>
> Métodos: getId(), setId(), getTitulo(), setTitulo(), getDescricao(), setDescricao(), getEndereco(), setEndereco(), getCidade(), setCidade(), getEstado(), setEstado(), getTipo(), setTipo(), getPrecoPorNoite(), setPrecoPorNoite(), getQuantidadeQuartos(), setQuantidadeQuartos(), getQuantidadeBanheiros(), setQuantidadeBanheiros(), getCapacidade(), setCapacidade(), getWifi(), setWifi(), getEstacionamento(), setEstacionamento(), getAnimaisPermitidos(), setAnimaisPermitidos(), getDisponivel(), setDisponivel(), getAnfitriao(), setAnfitriao(), getReserva(), setReserva(), equals(), toString()

- Classe Anfitriao:
> Atributos: id, nome, email, estado, cidadeAtuacao, acomodacoes reservas<br>
> Métodos: getId(), setId(), getNome(), setNome(), getEstado(), setEstado(),getCidadeAtuacao(), setCidadeAtuacao(), getAcomodacoes(), getReservas(), equals(), toString()

- Classe Cliente:
> Atributos: id, nome, email, cpf, reservas<br>
> Métodos: getId(), setId(), getNome(), setNome(), getEmail(), setEmail(), getCpf(), setCpf(), getReservas(), equals(), toString()

- Classe Reserva:
> Atributos: id, dataEntrada, dataSaida, formaPagamento, status, cliente, acomodacao, anfitriao<br>
> Métodos: getId(), setId(), getDataEntrada(), setDataEntrada(), getDataSaida(), setDataSaida(), getFormaPagamento(), setFormaPagamento(), getStatus(), setStatus(), getCliente(), setCliente(), getAcomodacao(), setAcomodacao(), getAnfitriao(), setAnfitriao()

- ReservaInput:
> Atributos: idCliente, idAcomodacao, dataEntrada, dataSaida, formaPagamento<br>
> Métodos: getIdCliente(), setIdCliente(), getIdAcomodacao(), setIdAcomodacao(), getDataEntrada(), setDataEntrada(), getDataSaida(), setDataSaida(), getFormaPagamento(), setFormaPagamento()

## 🔹 Diagrama de Estados
![Diagrama de Estados](image-1.png)

```puml
@startuml
[*] --> PENDENTE : Criada

PENDENTE --> CONFIRMADA : Anfitrião confirma
PENDENTE --> REJEITADA : Anfitrião recusa
PENDENTE --> CANCELADA : Cliente/Anfitrião cancela

CONFIRMADA --> CHECK_IN : Cliente realiza check-in
CONFIRMADA --> CANCELADA : Cliente/Anfitrião cancela
CONFIRMADA --> NAO_APARECEU : Cliente não aparece

CHECK_IN --> CHECK_OUT : Cliente realiza check-out

CHECK_OUT --> CONCLUIDA : Reserva finalizada
NAO_APARECEU --> [*]
CANCELADA --> [*]
REJEITADA --> [*]

CONCLUIDA --> [*]
@enduml
```
### Diagrama de Estados

O diagrama de estados descreve os estados pelos quais um objeto passa durante seu ciclo de vida.
Dentro Reserva, os estados podem ser:

Pendente: Reserva criada, aguardando confirmação.<br>
Confirmada: Reserva confirmada pelo anfitrião ou sistema.<br>
Rejeitada: Anfitrião recusou a reserva.<br>
Cancelada: Cliente ou anfitrião cancelou.<br>
Check-in: Cliente realizou o check-in.<br>
Check-out: Cliente finalizou a estadia.<br>
Não Apareceu: Cliente não compareceu.<br>
Concluída: Reserva finalizada com sucesso.