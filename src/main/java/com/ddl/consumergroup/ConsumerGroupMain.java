package com.ddl.consumergroup;

import com.ddl.ProducerThread;

/**
 * Author  : RandySun (sunfeng152157@sina.com)
 * Date    : 2017-08-20  14:18
 * Comment :
 */
public class ConsumerGroupMain {

    public static void main(String[] args){
        String brokers = "localhost:9092";
        String groupId = "group01";
        String topic = "HelloWorld";
        int consumerNumber = 3;

        Thread producerThread = new Thread(new ProducerThread(brokers,topic));
        producerThread.start();

        ConsumerGroup consumerGroup = new ConsumerGroup(brokers,groupId,topic,consumerNumber);
        consumerGroup.start();// KafkaConsumer is not safe for multi-threaded access ?
    }
}
