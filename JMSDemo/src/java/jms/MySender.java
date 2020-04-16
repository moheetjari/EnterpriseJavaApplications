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
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author admin
 */
public class MySender {

    public static void Sender() {
        try {
            InitialContext ctx = new InitialContext();

            QueueConnectionFactory f = (QueueConnectionFactory) ctx.lookup("itqueueFactory");
            QueueConnection con = f.createQueueConnection();
            con.start();

            QueueSession ses = con.createQueueSession(false, 0);
            Queue q = (Queue) ctx.lookup("itqueue");

            QueueSender sender = ses.createSender(q);

            TextMessage message = ses.createTextMessage();
            BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String s = b.readLine();
                if (s.equals("end")) {
                    break;
                }
                message.setText(s);
                sender.send(message);
            }
        } catch (IOException | JMSException | NamingException e) {
            e.printStackTrace();
        }
    }

}
