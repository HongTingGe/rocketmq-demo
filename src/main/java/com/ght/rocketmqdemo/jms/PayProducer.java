package com.ght.rocketmqdemo.jms;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.stereotype.Component;

@Component
public class PayProducer {

    private String producerGroup = "pay_group";

    private String nameServerAddr = "47.107.153.235:9876";

    private DefaultMQProducer producer;

    public PayProducer(){

        producer = new DefaultMQProducer(producerGroup);

        //指定NameServerAddr地址,多个地址以;隔开
        //eg. producer.setNamesrvAddr("xx.xxx.xxx.xxx:xxxx;xx.xxx.xxx.xxx:xxxx");
        producer.setNamesrvAddr(nameServerAddr);
        start();
    }

    public DefaultMQProducer getProducer(){
        return this.producer;
    }

    /**
     * 对象使用之前必须调用一次，只能初始化一次
     */
    public void start(){
        try {
            this.producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }

    public void shutdown(){
        this.producer.shutdown();
    }
}
