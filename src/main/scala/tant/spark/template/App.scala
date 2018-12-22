package tant.spark.template

import org.apache.spark.{SparkConf, SparkContext}


/**
 *
 *
 */
object App  {
  def main(args: Array[String]): Unit = {
    println( "Hello World!" )
    val conf = new SparkConf().setMaster("local[2]")
      .setAppName("template-test")
    val sc = new SparkContext(conf)
    val x = List(1, 2, 3, 4)
    val sparkx=sc.parallelize(x)
    println(sparkx.count())
    sc.stop()

  }

}
