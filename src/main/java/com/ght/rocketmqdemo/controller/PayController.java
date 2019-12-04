package com.ght.rocketmqdemo.controller;

import com.ght.rocketmqdemo.jms.PayProducer;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PayController {

    @Autowired
    private PayProducer producer;

    private static final String topic = "ght_pay_test_topic";

    @RequestMapping("/pay")
    public Object callback(String text) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {

        Message message = new Message(topic,"taga",("Hello RocketMq,"+text).getBytes());
        SendResult sendResult = producer.getProducer().send(message);
        return sendResult;
    }
}
