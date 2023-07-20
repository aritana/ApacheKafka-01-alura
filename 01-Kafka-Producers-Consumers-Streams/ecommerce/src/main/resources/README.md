# Aplicação ecommerce Kakfa

## Baixar o kafka
https://kafka.apache.org/downloads

## Abrir zookeeper
* bin/zookeeper-server-start.sh config/zookeeper.properties 

## Abrir kafka
* bin/kafka-server-start.sh config/server.properties 

## Tópicos
### Enviar mensagens
#### Criar tópico
* bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic LOJA_NOVO_PEDIDO 

#### Listar tópicos
* bin/kafka-topics.sh --list --bootstrap-server localhost:9092 

#### Escrever no tópico
* bin/kafka-console-producer.sh --broker-list localhost:9092 --topic LOJA_NOVO_PEDIDO 

#### Ler no tópico
* Ler mensagens armazenadas desde a criação do tópico:
  * bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic LOJA_NOVO_PEDIDO --from-beginning
* Ler apenas novas mensagens: 
  * bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic LOJA_NOVO_PEDIDO 
 

