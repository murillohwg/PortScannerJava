# Port Scanner em Java

### 1. Descrição do Projeto

Este projeto é uma implementação de um Port Scanner TCP em Java. A ferramenta foi desenvolvida para fins educacionais, com o objetivo de aprofundar os conhecimentos sobre programação de Sockets e os fundamentos de redes.

Port scanning é uma técnica essencial na fase de **reconhecimento** de um teste de invasão (pentest) ou de uma auditoria de segurança, permitindo identificar quais portas e serviços estão ativos em um host alvo.

### 2. Funcionalidades Principais

* Varredura de portas TCP em um host específico.
* Identificação de portas **Abertas** (serviço escutando) e **Fechadas**.
* Interface de linha de comando simples e direta.
* Intervalo de portas pré-definido (1-1024), cobrindo as portas de serviços mais conhecidos.

---

### 3. Como Usar

#### Pré-requisitos
* Java Development Kit (JDK) 8 ou superior instalado e configurado no PATH.

#### Compilação
Navegue até o diretório do projeto e compile o arquivo `.java` com o seguinte comando:
```shell
javac PortScanner.java
Execução
Execute o programa a partir da linha de comando, passando o host alvo (IP ou domínio) como argumento:

Shell

java PortScanner <host>
Exemplo:

Shell

java PortScanner localhost
ou

Shell

java PortScanner google.com
4. Exemplo de Saída (Output)
Iniciando varredura no host: localhost...
-----------------------------------------
Porta 22 (ssh) - Aberta
Porta 25 (smtp) - Fechada
Porta 80 (http) - Aberta
Porta 135 (msrpc) - Fechada
Porta 443 (https) - Aberta
...
Porta 1024 - Fechada
-----------------------------------------
Varredura concluída.
5. Como o Código Funciona (Explicação Técnica)
O princípio de funcionamento do scanner é baseado na tentativa de estabelecer uma conexão Socket com o host alvo em cada porta dentro do intervalo definido.

A lógica é a seguinte:

Um loop for itera através das portas de 1 a 1024.

Dentro do loop, o programa tenta criar uma nova instância de Socket, passando o host e a porta atual como parâmetros (new Socket(host, porta)).

Se a conexão for estabelecida com sucesso (sem lançar uma exceção), significa que há um serviço escutando naquela porta, e ela é marcada como "Aberta".

Se a tentativa de conexão falhar e uma exceção do tipo java.net.ConnectException ou java.net.SocketTimeoutException for capturada, significa que a porta está "Fechada" ou bloqueada.

O Socket é sempre fechado dentro de um bloco finally para garantir que os recursos sejam liberados.

Este projeto foi uma ótima oportunidade para aprender sobre o tratamento de exceções em Java e a aplicação prática da classe Socket para comunicação em rede.

6. Possíveis Melhorias e Próximos Passos
[ ] Implementar multithreading para acelerar a varredura, testando múltiplas portas simultaneamente.

[ ] Permitir que o usuário especifique um intervalo de portas customizado via argumentos de linha de comando.

[ ] Adicionar uma funcionalidade de detecção de serviço (service grabbing/banner grabbing) para tentar identificar qual serviço está rodando na porta aberta.

[ ] Salvar os resultados em um arquivo de log (.txt ou .csv).
