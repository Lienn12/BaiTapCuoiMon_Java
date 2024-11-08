package Controllers;

import Model.Message_model;
import javax.mail.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lienn
 */
public class Email_controller {
    public Message_model sendEmail(String toEmail,String code) {
        Message_model ms=new Message_model(false,"");
        String fromEmail="liennguyen4221@gmail.com";
        String password="reyghmgqhsnynybq";
        //propertirs
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP HOST
        props.put("mail.smtp.port", "587"); //TLS  
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.starttls.enable","true");
        //Authenticator: pass co san
        Authenticator auth= new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication (fromEmail,password);
            }   
        };
        //
        Session session =Session.getInstance (props,auth);
        //gửi email
        MimeMessage msg= new MimeMessage(session);
        
        try {
            //nội dung
            msg.addHeader("Conten-type","text/HTML; charset=UTF-8");
            //người gửi
            msg.setFrom(fromEmail);
            //người nhận
            msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(toEmail,false));
            //tiêu đề
            msg.setSubject("Verify Code");
            //quy định ngày gửi
            msg.setSentDate(new Date());
            //nội dung
            msg.setText(code);
            //gửi email
            Transport.send(msg);
            ms.setSuccess(true);
            System.out.println("Gui code xac nhan thanh cong!!");
        } catch (MessagingException ex) {
            Logger.getLogger(Email_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ms;
    }
}