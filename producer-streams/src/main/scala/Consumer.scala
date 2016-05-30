import java.util.Properties
import kafka.consumer.{Consumer, ConsumerConfig}

object ConsumerTest extends App {
  val zookeeper = args(0)
  val group = args(1)
  val topic = args(2)
  val props = new Properties()
  props.put("zookeeper.connect", zookeeper)
  props.put("group.id", group)
  props.put("auto.offset.reset", "largest")
  props.put("zookeeper.session.timeout.ms", "400")
  props.put("zookeeper.sync.time.ms", "200")
  props.put("auto.commit.interval.ms", "1000")
  val config = new ConsumerConfig(props)
  val consumer = Consumer.create(config)
  val consumerMap = consumer.createMessageStreams(Map(topic -> 1))
  val streams = consumerMap.get(topic).get

  val it = streams(0).iterator

  while (it.hasNext) {
    val msg = new String(it.next.message)
    println(msg)
  }
}
