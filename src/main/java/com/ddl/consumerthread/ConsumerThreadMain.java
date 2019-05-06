package com.ddl.consumerthread;

import com.ddl.ProducerThread;

/**
 * Author  : RandySun (sunfeng152157@sina.com)
 * Date    : 2017-08-20  16:49
 * Comment :
 */
public class ConsumerThreadMain {

    public static void main(String[] args){
        String brokers = "127.0.0.1:9092";
        String groupId = "group01";
        String topic = "HelloWorld";
        int consumerNumber = 3;


        Thread producerThread = new Thread(new ProducerThread(brokers,topic));
        producerThread.start();

        ConsumerThread consumerThread = new ConsumerThread(brokers,groupId,topic);
        consumerThread.start(3);


    }
}
