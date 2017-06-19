/**
 * JVMailStress - Mail Server Stress Test Tool
 * The class illustrates how to write comments used 
 * to generate JavaDoc documentation
 *
 * @author Murat B.
 * @url https://github.com/muratti66/jvmailstress
 * @version 1.00, 28 May 2017
 */
package com.muratti66.jvstress;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import java.util.HashMap;
import javax.mail.MessagingException;
import com.muratti66.jvstress.UI.MainGUI;
import static com.muratti66.jvstress.SystemOps.writeLogger;
import static com.muratti66.jvstress.SystemOps.writeSMTPLogger;
import static com.muratti66.jvstress.SystemOps.runGC;
import java.util.NoSuchElementException;
/**
 * This class does mail operations
 */
public class MailOps {
    private static Boolean opsStatus;
    private final static long MAX_FILE_SIZE = 20480000;
    private final static String thisClass  = String.class.getName();
    private static HashMap<String, Object> mailSendLocalConfig;
    /**
     * Start Mail Sender Operation
     */
    public static void start() {
        opsStatus = true;
        initVars();
        int thread = Integer.valueOf(mailSendLocalConfig.
                get("thread").toString());
        int process = Integer.valueOf(mailSendLocalConfig.
                get("process").toString());
        ExecutorService exec = Executors.newFixedThreadPool(thread * 2);
        for (int i=0; i<thread; i++) {
            final int thisThread = i + 1;
            exec.execute(new Runnable() {
                public void run() {
                    sendNOW(thisThread, process);
                }
            });
        }
    }
    /**
     * First Of All - All config get and initialize from MainGUI
     */
    private static void initVars() {
        Properties props = new Properties();
        ArrayList envSendr = new ArrayList(); 
        ArrayList envRecp = new ArrayList(); 
        ArrayList subjects = new ArrayList(); 
        ArrayList attach = new ArrayList(); 
        ArrayList content = new ArrayList();
        mailSendLocalConfig  = MainGUI.getmailSendConfig();
        String host = mailSendLocalConfig.get("host").toString();
        String port = mailSendLocalConfig.get("port").toString();
        String timeout = mailSendLocalConfig.get("timeout").toString();
        props.setProperty("mail.smtp.host", host);
        props.setProperty("mail.smtp.port", port);
        props.setProperty("mail.smtp.connectiontimeout", timeout);
        props.setProperty("mail.smtp.timeout", timeout);
        props.setProperty("mail.smtp.writetimeout", timeout);
        props.setProperty("mail.smtp.reportsuccess", "true");
        props.setProperty("mail.smtp.localhost", "tester.jvmailstress.com");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        mailSendLocalConfig.put("props", props);
        try {
            String attachPath = mailSendLocalConfig.
                    get("attachPath").toString();
            String contentPath = mailSendLocalConfig.
                    get("contentPath").toString(); 
            String[] envSendrNI = mailSendLocalConfig.
                    get("envSendr").toString().
                    split(System.getProperty("line.separator"));
            envSendr = new ArrayList();
            for (int i = 0; i < envSendrNI.length; i++) {
                if (envSendrNI[i].trim().isEmpty()) {
                    continue;
                }
                envSendr.add(envSendrNI[i].trim().replaceAll("\\s+",""));
            }
            if (envSendr.size() == 0) {
                opsStatus = false;
                writeLogger("Envelope sender should not be empty", true);
            }
            mailSendLocalConfig.put("envSendrList", envSendr);
            mailSendLocalConfig.put("envSendrLength", envSendr.size());
            String[] envRecpNI = mailSendLocalConfig.get("envRecp").toString().
                    split(System.getProperty("line.separator"));
            envRecp = new ArrayList();
            for (int j = 0; j < envRecpNI.length; j++) {
                if (envRecpNI[j].trim().isEmpty()) {
                    continue;
                }
                envRecp.add(envRecpNI[j].trim().replaceAll("\\s+",""));
            }
            if (envRecp.size() == 0) {
                opsStatus = false;
                writeLogger("Envelope recipient should not be empty", true);
            }
            mailSendLocalConfig.put("envRecpList", envRecp);
            mailSendLocalConfig.put("envRecpLength", envRecp.size());
            String[] subjectNI = mailSendLocalConfig.get("subject").toString().
                    split(System.getProperty("line.separator"));
            subjects = new ArrayList();
            for (int k = 0; k < subjectNI.length; k++) {
                if (subjectNI[k].trim().isEmpty()) {
                    continue;
                }
                subjects.add(subjectNI[k].trim());
            }
            if (subjects.size() == 0) {
                opsStatus = false;
                writeLogger("Subject should not be empty", true);
            }
            mailSendLocalConfig.put("subjectList", subjects);
            mailSendLocalConfig.put("subjectLength", subjects.size());
            String addingFile;
            attach = new ArrayList();
            File attachFolder = new File(attachPath);
            File[] listOfAttach = attachFolder.listFiles();
            for (int i = 0; i < listOfAttach.length; i++) {
                if ((listOfAttach[i].isFile()) && 
                        (!listOfAttach[i].isHidden()) && 
                        (listOfAttach[i].length() <= MAX_FILE_SIZE)) {
                    addingFile = listOfAttach[i].getPath();
                    attach.add(addingFile);
                }
            }
            mailSendLocalConfig.put("attachList", attach);
            mailSendLocalConfig.put("attachLength", attach.size());
            content = new ArrayList();
            File contentFolder = new File(contentPath);
            File[] listOfContent = contentFolder.listFiles();
            for (int i = 0; i < listOfContent.length; i++) {
                if ((listOfContent[i].isFile()) && 
                        (!listOfContent[i].isHidden()) && 
                        (listOfContent[i].length() <= MAX_FILE_SIZE)) {
                    addingFile = listOfContent[i].getPath();
                    content.add(addingFile);
                }
            }
            if (content.size() == 0) {
                opsStatus = false;
                writeLogger("Content folder not be empty", true);
            }
            mailSendLocalConfig.put("contentList", content);
            mailSendLocalConfig.put("contentLength", content.size());
        } catch (Exception e) {
            opsStatus = false;
            writeLogger(e.toString(), true);
            e.printStackTrace();
        }
        if(opsStatus.equals(true)) {
            int thread = Integer.valueOf(mailSendLocalConfig.
                get("thread").toString());
            int process = Integer.valueOf(mailSendLocalConfig.
                get("process").toString());
            int totalMail = thread * process;
            writeLogger("Sending process started, " + totalMail 
                    + " emails sent to host " 
                    + host + ".", false);
        }
    }
    /**
     * Mail Sender Proccess
     * @param   thisThreadNum
     * @param   paralelProccess 
     */
    private static void sendNOW(int thisThreadNum, int paralelProccess) {
        SystemOps sys = new SystemOps();
        if(opsStatus.equals(true)) {
            for (int i = 0; i < paralelProccess; i++) {
                int nowParalel = i + 1;
                ArrayList attachList = (ArrayList) mailSendLocalConfig.
                        get("attachList");
                int attachLength = Integer.valueOf(mailSendLocalConfig.
                        get("attachLength").toString());
                String selectedAttach = 
                        attachList.get(sys.genRandom(attachLength) - 1)
                        .toString();
                ArrayList contentList = (ArrayList) mailSendLocalConfig.
                        get("contentList");
                int contentLength = Integer.valueOf(mailSendLocalConfig.
                        get("contentLength").toString());
                String selectedContent = 
                        contentList.get(sys.genRandom(contentLength) - 1)
                        .toString();
                ArrayList envSendrList = (ArrayList) mailSendLocalConfig.
                        get("envSendrList");
                int envSendrLength = Integer.valueOf(mailSendLocalConfig.
                        get("envSendrLength").toString());
                String selectedEnvSendr = 
                        envSendrList.get(sys.genRandom(envSendrLength) - 1)
                        .toString();
                ArrayList envRecpList = (ArrayList) mailSendLocalConfig.
                        get("envRecpList");
                int envRecpLength = Integer.valueOf(mailSendLocalConfig.
                        get("envRecpLength").toString());
                String selectedEnvRecp = 
                        envRecpList.get(sys.genRandom(envRecpLength) - 1)
                        .toString();
                ArrayList subjectList = (ArrayList) mailSendLocalConfig.
                        get("subjectList");
                int subjectLength = Integer.valueOf(mailSendLocalConfig.
                        get("subjectLength").toString());
                String selectedSubject = 
                        subjectList.get(sys.genRandom(subjectLength) - 1)
                        .toString();
                Properties props = (Properties) mailSendLocalConfig.
                        get("props");
                Session mailSession = Session.getInstance(props);
                MimeMessage message = new MimeMessage(mailSession);
                String samplebodyContent = "Content files not found " 
                                + "\n This is Sample Content";
                try {
                    message.setFrom(
                            new InternetAddress(selectedEnvSendr, false));
                    message.addRecipients(Message.RecipientType.TO,
                            InternetAddress.parse(selectedEnvRecp));
                    message.setSubject(selectedSubject);
                    String bodyContent = "";
                    if (!selectedContent.isEmpty()) {
                        try {
                            Scanner scanner = new Scanner(
                                    new File(selectedContent))
                                    .useDelimiter("\\Z");
                            try {
                                bodyContent = scanner.next();
                            } catch (NoSuchElementException y) {
                                writeLogger("Content file has a problem, "
                                + "using example content : " + selectedContent
                                + " " + y.toString(), false);
                                bodyContent = samplebodyContent;
                            }
                        } catch (IOException e) {
                            writeLogger("Content file has a I/O problem : " 
                                    + selectedContent + " " 
                                    + e.toString(), true);
                            continue;
                        }
                    } else {
                        bodyContent = samplebodyContent;
                        writeLogger("Content file not found, "
                                + "using example content : " 
                                + selectedContent, false);
                    }
                    BodyPart messageBodyPart = new MimeBodyPart();
                    if (sys.isHTML(bodyContent)) {
                        messageBodyPart.setContent(bodyContent,
                                "text/html; charset=utf-8");
                    } else {
                        messageBodyPart.setText(bodyContent);
                    }
                    Multipart multipart = new MimeMultipart();
                    multipart.addBodyPart(messageBodyPart);
                    if (!selectedAttach.isEmpty()) {
                        try {
                            Path tempPath = Paths.get(selectedAttach);
                            String fileName = tempPath.getFileName().toString();
                            messageBodyPart = new MimeBodyPart();
                            DataSource source = 
                                    new FileDataSource(selectedAttach);
                            messageBodyPart.setDataHandler(
                                    new DataHandler(source));
                            messageBodyPart.setFileName(fileName);
                            multipart.addBodyPart(messageBodyPart);
                        } catch (Exception f) {
                            writeLogger("Attachment file access problem :" 
                                    + selectedAttach + " " 
                                    + f.toString(), true);
                        }
                    }
                    message.setContent(multipart);
                    String printMessage = "";
                    Boolean failed = false;
                    long startTime = System.currentTimeMillis();
                    try {
                        Transport transport = mailSession.getTransport("smtp");
                        transport.connect();
                        transport.sendMessage(message,
                            message.getRecipients(Message.RecipientType.TO));
                        transport.close();
                    } catch (MessagingException h) {
                        printMessage = h.getNextException()
                                .getMessage().toString();
                    }
                    long endTime = System.currentTimeMillis();
                    long totalTime = endTime - startTime;
                    if (!printMessage.contains("250")) {
                        failed = true;
                    }
                    writeSMTPLogger(printMessage + ", proc.time : " 
                            + totalTime +" ms. ", thisThreadNum, 
                            nowParalel, failed);
                    runGC();
                } catch (Exception j) {
                    writeLogger("Thread "  + thisThreadNum + ", Process " 
                            + nowParalel + " : " + j.toString(), true);
                    j.printStackTrace();
                }
            }
        }
    }
}
