import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class NewOrderMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
       var producer = new KafkaProducer<String,String> (properties());//chave,valor
       var value = "132123,67523,78945";
       var record = new ProducerRecord<>("ECOMMERCE_NEW_ORDER",value, value);

       producer.send(record, (data, ex)->{
           if(ex != null){
               ex.printStackTrace();
               return;
           }
           System.out.println("sucesso enviando" + data.topic()+":::"+data.partition()+"/ offset "+data.offset()+"/ timestamp "+data.timestamp());
       }).get();//enviar um record
    }

    private static Properties properties() {
        var properties =  new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");//onde se conectar
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());//serializadores de string para bytes
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());//serializadores de string para bytes
        return  properties;
    }
}
