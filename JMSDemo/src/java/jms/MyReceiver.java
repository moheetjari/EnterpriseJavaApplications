/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author admin
 */
public class MyReceiver {

    public static void Receiver() {
        try {
            InitialContext ctx = new InitialContext();

            QueueConnectionFactory f = (QueueConnectionFactory) ctx.lookup("itqueueFactory");
            QueueConnection con = f.createQueueConnection();
            con.start();

            QueueSession ses = con.createQueueSession(false, 0);
            Queue q = (Queue) ctx.lookup("itqueue");
            QueueReceiver receiver = ses.createReceiver(q);

            MyListner listner = new MyListner();
            receiver.setMessageListener(listner);

        } catch (JMSException | NamingException e) {
            e.printStackTrace();
        }
    }
}
