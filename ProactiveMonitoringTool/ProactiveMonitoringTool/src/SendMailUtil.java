/* Decompiler 170ms, total 666ms, lines 891 */
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Vector;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import oracle.jdbc.OracleCallableStatement;

public class SendMailUtil {
   public void sendMail(String mailContent, String attachmentFile, String mailIdentification, String targetMails) {
      String[] tempMailsAry = targetMails.split(";");
      String to1 = "mohamed.elsweesy@localhost.com";
      String to3 = "fady.adel-attallah@localhost.com";
      String from = "BSCS_ProactiveTool@vodafone.com";
      String host = "10.230.95.91";
      Properties properties = System.getProperties();
      properties.setProperty("mail.smtp.host", host);
      Session session = Session.getDefaultInstance(properties);

      try {
         MimeMessage message = new MimeMessage(session);
         message.setFrom(new InternetAddress(from));

         for(int i = 0; i < tempMailsAry.length; ++i) {
            message.addRecipient(RecipientType.TO, new InternetAddress(tempMailsAry[i]));
         }

         message.setSubject("CMS Adaptor Notification - " + mailIdentification);
         MimeBodyPart messageBodyPart1 = new MimeBodyPart();
         messageBodyPart1.setText(mailContent);
         Multipart multipart = new MimeMultipart("mixed");
         multipart.addBodyPart(messageBodyPart1);
         if (attachmentFile != null) {
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(attachmentFile);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(source.getName());
            multipart.addBodyPart(messageBodyPart);
         }

         message.setContent(multipart);
         Transport.send(message);
         System.out.println(message);
         System.out.println("Sent message successfully....");
      } catch (MessagingException var17) {
         System.out.println("Exception " + var17.toString());
      }

   }

   public void sendWfxMail(String mailContent, String attachmentFile, String mailIdentification, String targetMails) {
      String[] tempMailsAry = targetMails.split(";");
      String to3 = "fady.adel-attallah@localhost.com";
      String to4 = "mostafa.tolba-mohamed@localhost.com";
      String from = "BSCS_ProactiveTool@vodafone.com";
      String host = "10.230.95.91";
      Properties properties = System.getProperties();
      properties.setProperty("mail.smtp.host", host);
      Session session = Session.getDefaultInstance(properties);

      try {
         MimeMessage message = new MimeMessage(session);
         message.setFrom(new InternetAddress(from));

         for(int i = 0; i < tempMailsAry.length; ++i) {
            message.addRecipient(RecipientType.TO, new InternetAddress(tempMailsAry[i]));
         }

         message.setSubject("WFX Adaptor Notification - " + mailIdentification);
         MimeBodyPart messageBodyPart1 = new MimeBodyPart();
         messageBodyPart1.setText(mailContent);
         Multipart multipart = new MimeMultipart("mixed");
         multipart.addBodyPart(messageBodyPart1);
         if (attachmentFile != null) {
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(attachmentFile);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(source.getName());
            multipart.addBodyPart(messageBodyPart);
         }

         message.setContent(multipart);
         Transport.send(message);
         System.out.println(message);
         System.out.println("Sent message successfully....");
      } catch (MessagingException var17) {
         System.out.println("Exception " + var17.toString());
      }

   }

   public void sendSpecificMail(String mailContent, String attachmentFile, String mailIdentification, String targetMails) {
      String to1 = "mostafa.tolba-mohamed@localhost.com";
      String to3 = "fady.adel-attallah@localhost.com";
      String from = "BSCS_ProactiveTool@vodafone.com";
      String host = "10.230.95.91";
      Properties properties = System.getProperties();
      properties.setProperty("mail.smtp.host", host);
      Session session = Session.getDefaultInstance(properties);

      try {
         MimeMessage message = new MimeMessage(session);
         message.setFrom(new InternetAddress(from));
         message.addRecipient(RecipientType.TO, new InternetAddress(to3));
         message.setSubject("CMS Adaptor Notification - " + mailIdentification);
         MimeBodyPart messageBodyPart1 = new MimeBodyPart();
         messageBodyPart1.setText(mailContent);
         Multipart multipart = new MimeMultipart("mixed");
         multipart.addBodyPart(messageBodyPart1);
         if (attachmentFile != null) {
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(attachmentFile);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(source.getName());
            multipart.addBodyPart(messageBodyPart);
         }

         message.setContent(multipart);
         Transport.send(message);
         System.out.println("Sent message successfully....");
      } catch (MessagingException var16) {
         System.out.println("Exception " + var16.toString());
      }

   }

   public void sendEricsonMail(String mailContent, String attachmentFile, String mailIdentification, String targetMails) {
      String to2 = "mostafa.tolba-mohamed@localhost.com";
      String to4 = "fady.adel-attallah@localhost.com";
      String from = "Ericson_Online_Monitoring@vodafone.com";
      String host = "10.230.95.91";
      Properties properties = System.getProperties();
      properties.setProperty("mail.smtp.host", host);
      Session session = Session.getDefaultInstance(properties);

      try {
         MimeMessage message = new MimeMessage(session);
         message.setFrom(new InternetAddress(from));
         message.addRecipient(RecipientType.TO, new InternetAddress(to2));
         message.setSubject("Ericson Adapter Notification- " + mailIdentification);
         MimeBodyPart messageBodyPart1 = new MimeBodyPart();
         messageBodyPart1.setText(mailContent);
         Multipart multipart = new MimeMultipart("mixed");
         multipart.addBodyPart(messageBodyPart1);
         if (attachmentFile != null) {
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(attachmentFile);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(source.getName());
            multipart.addBodyPart(messageBodyPart);
         }

         message.setContent(multipart);
         Transport.send(message);
         System.out.println("Sent message successfully....");
      } catch (MessagingException var16) {
         System.out.println("Exception " + var16.toString());
      }

   }

   public void sendRamadanMail(String mailContent, String attachmentFile) {
      String to1 = "mohamed.elsweesy@localhost.com";
      String to2 = "Yahya.Mowiena@localhost.com";
      String to3 = "Ahmed.Ahmed-ElGhazali@localhost.com";
      String cc1 = "Nada.Abdou@localhost.com";
      String from = "mohamed.elsweesy@localhost.com";
      String host = "10.230.95.91";
      Properties properties = System.getProperties();
      properties.setProperty("mail.smtp.host", host);
      Session session = Session.getDefaultInstance(properties);

      try {
         MimeMessage message = new MimeMessage(session);
         message.setFrom(new InternetAddress(from));
         message.addRecipient(RecipientType.TO, new InternetAddress(to1));
         message.addRecipient(RecipientType.TO, new InternetAddress(to2));
         message.addRecipient(RecipientType.TO, new InternetAddress(to3));
         message.addRecipient(RecipientType.CC, new InternetAddress(cc1));
         message.setSubject("CMS Adaptor down notification");
         MimeBodyPart messageBodyPart1 = new MimeBodyPart();
         messageBodyPart1.setText(mailContent);
         Multipart multipart = new MimeMultipart("mixed");
         multipart.addBodyPart(messageBodyPart1);
         if (attachmentFile != null) {
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(attachmentFile);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(source.getName());
            multipart.addBodyPart(messageBodyPart);
         }

         message.setContent(multipart);
         Transport.send(message);
         System.out.println("Sent message successfully....");
      } catch (MessagingException var16) {
         System.out.println("Exception " + var16.toString());
      }

   }

   public static String[] customStringFormat(String text) {
      int i = 1;
      int j = 0;
      double n = 15.0D;
      String[] lines = text.split("\\r\\n|\\r|\\n");
      String[] formattedString = new String[(int)Math.ceil((double)lines.length / n)];
      formattedString[0] = "";
      String[] var7 = lines;
      int var8 = lines.length;

      for(int var9 = 0; var9 < var8; ++var9) {
         String line = var7[var9];
         if ((double)i > n) {
            i = 1;
            ++j;
            formattedString[j] = "";
         }

         String fLine = line.trim();
         if (!fLine.isEmpty()) {
            formattedString[j] = formattedString[j] + fLine;
            ++i;
            if ((double)i <= n && (double)i + n * (double)j < (double)lines.length) {
               formattedString[j] = formattedString[j] + "\r\n";
            }
         }
      }

      return formattedString;
   }

   public static int sendNewWfxSMS(Vector targetMSISDNs, String text) {
      SendMailUtil sendMail;
      if (targetMSISDNs.size() != 1 || !targetMSISDNs.get(0).equals("201093738425")) {
         sendMail = new SendMailUtil();
         sendMail.sendWfxMail(text, (String)null, "SMS Replacement", ProactiveMonitoringToolMain.proModel.getMails());
      }

      System.out.println("Start New Sending SMS");
      sendMail = null;

      String[] sms;
      try {
         sms = customStringFormat(text);
      } catch (Exception var23) {
         System.err.println(var23.toString());
         sms = new String[]{text};
      }

      OracleCallableStatement stm = null;
      int resultMsgId = 0;
      HashMap<String, String> smsSettings = null;
      String procedureName = "";
      Connection smsConn = null;

      try {
         procedureName = "SENDSMS";
         System.out.println("In sendNewSMS|Procedure Name =" + procedureName);
         smsConn = getSMSGateWayConnection();
         stm = (OracleCallableStatement)smsConn.prepareCall("call " + procedureName + " (?, ?, ?, ?, ?, ?, ?, ?, ?)");

         for(int i = 0; i < targetMSISDNs.size(); ++i) {
            String targetMSISDN = targetMSISDNs.get(i).toString();
            String[] var10 = sms;
            int var11 = sms.length;

            for(int var12 = 0; var12 < var11; ++var12) {
               String msg = var10[var12];
               stm.setString(1, "IT_REG1_1");
               stm.setString(2, "PRO1_WFX");
               stm.setString(3, targetMSISDN);
               stm.setString(4, msg);
               stm.setInt(5, 0);
               stm.setInt(6, 2);
               stm.setInt(7, 1);
               stm.setInt(8, 0);
               stm.setInt(9, 0);
               System.out.println("Will Call procedure for MSISDN" + targetMSISDN);
               stm.executeUpdate();
               System.out.println("After calling procedure");
               System.out.println("sending message (" + text + ") to " + targetMSISDN);
            }
         }

         smsConn.close();
         int var27 = resultMsgId;
         return var27;
      } catch (Exception var24) {
         System.out.println(var24.getMessage());
         var24.printStackTrace();
         System.out.println("failed to update you with a message\n" + text);
      } finally {
         System.out.println("End New Sending SMS");
         stm = null;

         try {
            if (smsConn != null) {
               smsConn.close();
            }
         } catch (Exception var22) {
            var22.printStackTrace();
         }

      }

      return 0;
   }

   public static int sendRSMS(Vector targetMSISDNs, String text) {
      System.out.println("Start New Sending SMS");
      String[] sms = null;

      try {
         sms = customStringFormat(text);
      } catch (Exception var23) {
         System.err.println("failed to format string in sms : " + text + " : " + var23.toString());
         sms = new String[]{text};
      }

      OracleCallableStatement stm = null;
      int resultMsgId = 0;
      HashMap<String, String> smsSettings = null;
      String procedureName = "";
      Connection smsConn = null;

      try {
         procedureName = "SENDSMS";
         System.out.println("In sendNewSMS|Procedure Name =" + procedureName);
         smsConn = getSMSGateWayConnection();
         stm = (OracleCallableStatement)smsConn.prepareCall("call " + procedureName + " (?, ?, ?, ?, ?, ?, ?, ?, ?)");

         for(int i = 0; i < targetMSISDNs.size(); ++i) {
            String targetMSISDN = targetMSISDNs.get(i).toString();
            String[] var10 = sms;
            int var11 = sms.length;

            for(int var12 = 0; var12 < var11; ++var12) {
               String msg = var10[var12];
               stm.setString(1, "IT_REG1_1");
               stm.setString(2, "PRO1_Tool");
               stm.setString(3, targetMSISDN);
               stm.setString(4, msg);
               stm.setInt(5, 0);
               stm.setInt(6, 2);
               stm.setInt(7, 1);
               stm.setInt(8, 0);
               stm.setInt(9, 0);
               System.out.println("Will Call procedure for MSISDN" + targetMSISDN);
               stm.executeUpdate();
               System.out.println("After calling procedure");
               System.out.println("sending message (" + text + ") to " + targetMSISDN);
            }
         }
      } catch (Exception var24) {
         System.out.println(var24.getMessage());
         var24.printStackTrace();
         System.err.println("failed to update you with a message\n" + text + " : " + var24.toString());
      } finally {
         System.out.println("End New Sending SMS");
         stm = null;

         try {
            if (smsConn != null) {
               smsConn.close();
            }
         } catch (Exception var22) {
            var22.printStackTrace();
         }

      }

      return resultMsgId;
   }

   public static int sendNewSMS(Vector targetMSISDNs, String text) {
      System.out.println("Start New Sending Email");
      SendMailUtil sendMail = new SendMailUtil();
      sendMail.sendMail(text, (String)null, "SMS Replacement", ProactiveMonitoringToolMain.proModel.getMails());
      System.out.println("Start New Sending SMS");
      String[] sms = null;

      try {
         sms = customStringFormat(text);
      } catch (Exception var24) {
         System.err.println("failed to format string in sms : " + text + " : " + var24.toString());
         sms = new String[]{text};
      }

      OracleCallableStatement stm = null;
      int resultMsgId = 0;
      HashMap<String, String> smsSettings = null;
      String procedureName = "";
      Connection smsConn = null;

      try {
         procedureName = "SENDSMS";
         System.out.println("In sendNewSMS|Procedure Name =" + procedureName);
         smsConn = getSMSGateWayConnection();
         stm = (OracleCallableStatement)smsConn.prepareCall("call " + procedureName + " (?, ?, ?, ?, ?, ?, ?, ?, ?)");

         for(int i = 0; i < targetMSISDNs.size(); ++i) {
            String targetMSISDN = targetMSISDNs.get(i).toString();
            String[] var11 = sms;
            int var12 = sms.length;

            for(int var13 = 0; var13 < var12; ++var13) {
               String msg = var11[var13];
               stm.setString(1, "IT_REG1_1");
               stm.setString(2, "PRO1_Tool");
               stm.setString(3, targetMSISDN);
               stm.setString(4, msg);
               stm.setInt(5, 0);
               stm.setInt(6, 2);
               stm.setInt(7, 1);
               stm.setInt(8, 0);
               stm.setInt(9, 0);
               System.out.println("Will Call procedure for MSISDN" + targetMSISDN);
               stm.executeUpdate();
               System.out.println("After calling procedure");
               System.out.println("sending message (" + text + ") to " + targetMSISDN);
            }
         }
      } catch (Exception var25) {
         System.out.println(var25.getMessage());
         var25.printStackTrace();
         System.err.println("failed to update you with a message\n" + text + " : " + var25.toString());
      } finally {
         System.out.println("End New Sending SMS");
         stm = null;

         try {
            if (smsConn != null) {
               smsConn.close();
            }
         } catch (Exception var23) {
            var23.printStackTrace();
         }

      }

      return resultMsgId;
   }

   public static int sendHighSMS(Vector targetMSISDNs, String text) {
      System.out.println("Start New Sending Email");
      SendMailUtil sendMail = new SendMailUtil();
      sendMail.sendMail(text, (String)null, "SMS Replacement", ProactiveMonitoringToolMain.proModel.getMails());
      System.out.println("Start New Sending SMS");
      String[] sms = null;

      try {
         sms = customStringFormat(text);
      } catch (Exception var24) {
         System.err.println("failed to format string in sms : " + text + " : " + var24.toString());
         sms = new String[]{text};
      }

      OracleCallableStatement stm = null;
      int resultMsgId = 0;
      HashMap<String, String> smsSettings = null;
      String procedureName = "";
      Connection smsConn = null;

      try {
         procedureName = "SENDSMS";
         System.out.println("In sendNewSMS|Procedure Name =" + procedureName);
         smsConn = getSMSGateWayConnection();
         stm = (OracleCallableStatement)smsConn.prepareCall("call " + procedureName + " (?, ?, ?, ?, ?, ?, ?, ?, ?)");

         for(int i = 0; i < targetMSISDNs.size(); ++i) {
            String targetMSISDN = targetMSISDNs.get(i).toString();
            String[] var11 = sms;
            int var12 = sms.length;

            for(int var13 = 0; var13 < var12; ++var13) {
               String msg = var11[var13];
               stm.setString(1, "IT_REG1_1");
               stm.setString(2, "Online_High");
               stm.setString(3, targetMSISDN);
               stm.setString(4, msg);
               stm.setInt(5, 0);
               stm.setInt(6, 2);
               stm.setInt(7, 1);
               stm.setInt(8, 0);
               stm.setInt(9, 0);
               System.out.println("Will Call procedure for MSISDN" + targetMSISDN);
               stm.executeUpdate();
               System.out.println("After calling procedure");
               System.out.println("sending message (" + text + ") to " + targetMSISDN);
            }
         }
      } catch (Exception var25) {
         System.out.println(var25.getMessage());
         var25.printStackTrace();
         System.err.println("failed to update you with a message\n" + text + " : " + var25.toString());
      } finally {
         System.out.println("End New Sending SMS");
         stm = null;

         try {
            if (smsConn != null) {
               smsConn.close();
            }
         } catch (Exception var23) {
            var23.printStackTrace();
         }

      }

      return resultMsgId;
   }

   public static int sendFlexSMS(Vector targetMSISDNs, String text) {
      System.out.println("Start New Sending Email");
      SendMailUtil sendMail = new SendMailUtil();
      sendMail.sendMail(text, (String)null, "SMS Replacement", ProactiveMonitoringToolMain.proModel.getMails());
      System.out.println("Start New Sending SMS");
      String[] sms = null;

      try {
         sms = customStringFormat(text);
      } catch (Exception var24) {
         System.err.println("failed to format string in sms : " + text + " : " + var24.toString());
         sms = new String[]{text};
      }

      OracleCallableStatement stm = null;
      int resultMsgId = 0;
      HashMap<String, String> smsSettings = null;
      String procedureName = "";
      Connection smsConn = null;

      try {
         procedureName = "SENDSMS";
         System.out.println("In sendNewSMS|Procedure Name =" + procedureName);
         smsConn = getSMSGateWayConnection();
         stm = (OracleCallableStatement)smsConn.prepareCall("call " + procedureName + " (?, ?, ?, ?, ?, ?, ?, ?, ?)");

         for(int i = 0; i < targetMSISDNs.size(); ++i) {
            String targetMSISDN = targetMSISDNs.get(i).toString();
            String[] var11 = sms;
            int var12 = sms.length;

            for(int var13 = 0; var13 < var12; ++var13) {
               String msg = var11[var13];
               stm.setString(1, "IT_REG1_1");
               stm.setString(2, "FlexFamily");
               stm.setString(3, targetMSISDN);
               stm.setString(4, msg);
               stm.setInt(5, 0);
               stm.setInt(6, 2);
               stm.setInt(7, 1);
               stm.setInt(8, 0);
               stm.setInt(9, 0);
               System.out.println("Will Call procedure for MSISDN" + targetMSISDN);
               stm.executeUpdate();
               System.out.println("After calling procedure");
               System.out.println("sending message (" + text + ") to " + targetMSISDN);
            }
         }
      } catch (Exception var25) {
         System.out.println(var25.getMessage());
         var25.printStackTrace();
         System.err.println("failed to update you with a message\n" + text + " : " + var25.toString());
      } finally {
         System.out.println("End New Sending SMS");
         stm = null;

         try {
            if (smsConn != null) {
               smsConn.close();
            }
         } catch (Exception var23) {
            var23.printStackTrace();
         }

      }

      return resultMsgId;
   }

   public static int sendRedSMS(Vector targetMSISDNs, String text) {
      System.out.println("Start New Sending Email");
      SendMailUtil sendMail = new SendMailUtil();
      sendMail.sendMail(text, (String)null, "SMS Replacement", ProactiveMonitoringToolMain.proModel.getMails());
      System.out.println("Start New Sending SMS");
      String[] sms = null;

      try {
         sms = customStringFormat(text);
      } catch (Exception var24) {
         System.err.println("failed to format string in sms : " + text + " : " + var24.toString());
         sms = new String[]{text};
      }

      OracleCallableStatement stm = null;
      int resultMsgId = 0;
      HashMap<String, String> smsSettings = null;
      String procedureName = "";
      Connection smsConn = null;

      try {
         procedureName = "SENDSMS";
         System.out.println("In sendNewSMS|Procedure Name =" + procedureName);
         smsConn = getSMSGateWayConnection();
         stm = (OracleCallableStatement)smsConn.prepareCall("call " + procedureName + " (?, ?, ?, ?, ?, ?, ?, ?, ?)");

         for(int i = 0; i < targetMSISDNs.size(); ++i) {
            String targetMSISDN = targetMSISDNs.get(i).toString();
            String[] var11 = sms;
            int var12 = sms.length;

            for(int var13 = 0; var13 < var12; ++var13) {
               String msg = var11[var13];
               stm.setString(1, "IT_REG1_1");
               stm.setString(2, "RedFamily");
               stm.setString(3, targetMSISDN);
               stm.setString(4, msg);
               stm.setInt(5, 0);
               stm.setInt(6, 2);
               stm.setInt(7, 1);
               stm.setInt(8, 0);
               stm.setInt(9, 0);
               System.out.println("Will Call procedure for MSISDN" + targetMSISDN);
               stm.executeUpdate();
               System.out.println("After calling procedure");
               System.out.println("sending message (" + text + ") to " + targetMSISDN);
            }
         }
      } catch (Exception var25) {
         System.out.println(var25.getMessage());
         var25.printStackTrace();
         System.err.println("failed to update you with a message\n" + text + " : " + var25.toString());
      } finally {
         System.out.println("End New Sending SMS");
         stm = null;

         try {
            if (smsConn != null) {
               smsConn.close();
            }
         } catch (Exception var23) {
            var23.printStackTrace();
         }

      }

      return resultMsgId;
   }

   public static int sendProvSMS(Vector targetMSISDNs, String text) {
      System.out.println("Start New Sending Email");
      SendMailUtil sendMail = new SendMailUtil();
      sendMail.sendMail(text, (String)null, "SMS Replacement", ProactiveMonitoringToolMain.proModel.getMails());
      System.out.println("Start New Sending SMS");
      String[] sms = null;

      try {
         sms = customStringFormat(text);
      } catch (Exception var24) {
         System.err.println("failed to format string in sms : " + text + " : " + var24.toString());
         sms = new String[]{text};
      }

      OracleCallableStatement stm = null;
      int resultMsgId = 0;
      HashMap<String, String> smsSettings = null;
      String procedureName = "";
      Connection smsConn = null;

      try {
         procedureName = "SENDSMS";
         System.out.println("In sendNewSMS|Procedure Name =" + procedureName);
         smsConn = getSMSGateWayConnection();
         stm = (OracleCallableStatement)smsConn.prepareCall("call " + procedureName + " (?, ?, ?, ?, ?, ?, ?, ?, ?)");

         for(int i = 0; i < targetMSISDNs.size(); ++i) {
            String targetMSISDN = targetMSISDNs.get(i).toString();
            String[] var11 = sms;
            int var12 = sms.length;

            for(int var13 = 0; var13 < var12; ++var13) {
               String msg = var11[var13];
               stm.setString(1, "IT_REG1_1");
               stm.setString(2, "Prov.alarm");
               stm.setString(3, targetMSISDN);
               stm.setString(4, msg);
               stm.setInt(5, 0);
               stm.setInt(6, 2);
               stm.setInt(7, 1);
               stm.setInt(8, 0);
               stm.setInt(9, 0);
               System.out.println("Will Call procedure for MSISDN" + targetMSISDN);
               stm.executeUpdate();
               System.out.println("After calling procedure");
               System.out.println("sending message (" + text + ") to " + targetMSISDN);
            }
         }
      } catch (Exception var25) {
         System.out.println(var25.getMessage());
         var25.printStackTrace();
         System.err.println("failed to update you with a message\n" + text + " : " + var25.toString());
      } finally {
         System.out.println("End New Sending SMS");
         stm = null;

         try {
            if (smsConn != null) {
               smsConn.close();
            }
         } catch (Exception var23) {
            var23.printStackTrace();
         }

      }

      return resultMsgId;
   }

   public static int sendBchSMS(Vector targetMSISDNs, String text) {
      System.out.println("Start New Sending SMS");
      String[] sms = null;

      try {
         sms = customStringFormat(text);
      } catch (Exception var23) {
         System.err.println("failed to format string in sms : " + text + " : " + var23.toString());
         sms = new String[]{text};
      }

      OracleCallableStatement stm = null;
      int resultMsgId = 0;
      HashMap<String, String> smsSettings = null;
      String procedureName = "";
      Connection smsConn = null;

      try {
         procedureName = "SENDSMS";
         System.out.println("In sendNewSMS|Procedure Name =" + procedureName);
         smsConn = getSMSGateWayConnection();
         stm = (OracleCallableStatement)smsConn.prepareCall("call " + procedureName + " (?, ?, ?, ?, ?, ?, ?, ?, ?)");

         for(int i = 0; i < targetMSISDNs.size(); ++i) {
            String targetMSISDN = targetMSISDNs.get(i).toString();
            String[] var10 = sms;
            int var11 = sms.length;

            for(int var12 = 0; var12 < var11; ++var12) {
               String msg = var10[var12];
               stm.setString(1, "IT_REG1_1");
               stm.setString(2, "BC_MONITOR");
               stm.setString(3, targetMSISDN);
               stm.setString(4, msg);
               stm.setInt(5, 0);
               stm.setInt(6, 2);
               stm.setInt(7, 1);
               stm.setInt(8, 0);
               stm.setInt(9, 0);
               System.out.println("Will Call procedure for MSISDN" + targetMSISDN);
               stm.executeUpdate();
               System.out.println("After calling procedure");
               System.out.println("sending message (" + text + ") to " + targetMSISDN);
            }
         }
      } catch (Exception var24) {
         System.out.println(var24.getMessage());
         var24.printStackTrace();
         System.err.println("failed to update you with a message\n" + text + " : " + var24.toString());
      } finally {
         System.out.println("End New Sending SMS");
         stm = null;

         try {
            if (smsConn != null) {
               smsConn.close();
            }
         } catch (Exception var22) {
            var22.printStackTrace();
         }

      }

      return resultMsgId;
   }

   public static int sendBOTANotificationSMS(Vector targetMSISDNs, String text) {
      SendMailUtil sendMail = new SendMailUtil();
      sendMail.sendMail(text, (String)null, "SMS Replacement", ProactiveMonitoringToolMain.proModel.getMails());
      System.out.println("Start New Sending SMS");
      OracleCallableStatement stm = null;
      int resultMsgId = 0;
      HashMap<String, String> smsSettings = null;
      String procedureName = "";
      Connection smsConn = null;

      try {
         procedureName = "SENDSMS";
         System.out.println("In sendNewSMS|Procedure Name =" + procedureName);
         smsConn = getSMSGateWayConnection();
         stm = (OracleCallableStatement)smsConn.prepareCall("call " + procedureName + " (?, ?, ?, ?, ?, ?, ?, ?, ?)");

         for(int i = 0; i < targetMSISDNs.size(); ++i) {
            String targetMSISDN = targetMSISDNs.get(i).toString();
            stm.setString(1, "IT_REG1_1");
            stm.setString(2, "Vodafone");
            stm.setString(3, targetMSISDN);
            stm.setString(4, text);
            stm.setInt(5, 0);
            stm.setInt(6, 2);
            stm.setInt(7, 1);
            stm.setInt(8, 0);
            stm.setInt(9, 0);
            System.out.println("Will Call procedure for MSISDN" + targetMSISDN);
            stm.executeUpdate();
            System.out.println("After calling procedure");
         }

         smsConn.close();
         int var20 = resultMsgId;
         return var20;
      } catch (SQLException var18) {
         System.out.println(var18.getMessage());
         var18.printStackTrace();
      } finally {
         System.out.println("End New Sending SMS");
         stm = null;

         try {
            if (smsConn != null) {
               smsConn.close();
            }
         } catch (Exception var17) {
            var17.printStackTrace();
         }

      }

      return 0;
   }

   public static synchronized Connection getSMSGateWayConnection() {
      Connection conn = null;

      try {
         Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
         conn = DriverManager.getConnection("jdbc:oracle:thin:@10.30.145.38:1522:HQSMPP2", "SMPP1", "SMPP1");
         System.out.println("connectionRetrieved");
         conn.setAutoCommit(true);
      } catch (Exception var2) {
         System.out.println("Exception on getting connection" + var2.toString());
      }

      return conn;
   }

   public static void main(String[] str) {
      System.out.println("Main started");
      Vector MSISDNs = new Vector();
      MSISDNs.add("201000596727");
      MSISDNs.add("201008011393");
      String message = "م�\u00adمد";
      String message2 = "م�\u00adمد";
      String message3 = "عربي";

      try {
         new String(message.getBytes("UTF-8"));
         new String(message2.getBytes("Cp1252"));
         message3 = new String(message3.getBytes("Cp1256"));
      } catch (UnsupportedEncodingException var6) {
         var6.printStackTrace();
      }

      sendNewSMS(MSISDNs, message3);
      System.out.println("After sending sms");
   }
}