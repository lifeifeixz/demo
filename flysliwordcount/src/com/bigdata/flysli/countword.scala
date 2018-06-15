package com.bigdata.flysli

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by flysLi on 2018/3/1.
  */
class countword {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("Wordcount")
    val sc = new SparkContext(conf)
    val data = sc.textFile("D:\\L临时数据\\zoo.cfg") // 文本存放的位置
    data.flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_).collect().foreach(println)
  }
}
