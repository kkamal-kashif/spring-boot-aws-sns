package com.kk.service;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SNSService {

    @Autowired
    private AmazonSNS sns;
    @Value("${topic.arn}")
    private String topicARN; //Amazon Resource Name

    public void pubTopic(String subject, String message) {
        try {
            PublishRequest request = new PublishRequest(topicARN, message);
            request.setSubject(subject);
            sns.publish(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
