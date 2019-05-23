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
    val builder = SparkSession.builder.config(conf)
    if (System.getenv("SPARK_HOME") != null) {
      conf.setSparkHome(System.getenv("SPARK_HOME"))
    }
    //创建spark session
    val spark = builder
      .enableHiveSupport()
      .getOrCreate()
    //使用spark session创建spark content
    var sc=spark.sparkContext
    val x = List(1, 2, 3, 4)
    val sparkx=sc.parallelize(x)
    println(sparkx.count())
    sc.stop()

  }

}
