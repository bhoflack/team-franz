import java.util.Properties
import kafka.producer.{Producer, ProducerConfig, KeyedMessage}

object ProducerTest extends App {
  val brokers = args(0)
  val topic = args(1)
  val msg = args(2)
  val props = new Properties()
  props.put("metadata.broker.list", brokers)
  props.put("serializer.class", "kafka.serializer.StringEncoder")
  props.put("producer.type", "sync")

  val config = new ProducerConfig(props)
  val producer = new Producer[String, String](config)

  for (i <- 0 to 1000000000) {
    val data = new KeyedMessage[String, String](topic, msg + i.toString)
    producer.send(data)
  }
  producer.close()
}
