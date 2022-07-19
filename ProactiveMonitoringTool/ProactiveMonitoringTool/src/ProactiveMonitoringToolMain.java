/* Decompiler 82ms, total 670ms, lines 321 */
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class ProactiveMonitoringToolMain {
   public static int maxReached = 0;
   public static int maxReachedWfx = 0;
   public static Vector commandStatusVec = new Vector();
   public static Vector commandStatusWfxVec = new Vector();
   public static int performanceWfxMaxReached = 0;
   public static int monitortablespaceMaxReached = 10;
   public static int monitortablespaceMaxReachedWfx = 10;
   public static Set<String> otaJobsStartMonitored = new HashSet();
   public static Set<String> otaJobsCompletedMonitored = new HashSet();
   public static Set<String> archievedJobs = new HashSet();
   public static Set<String> assignedSrs = new HashSet();
   public static ProActiveConfModel proModel;

   public static ProActiveConfModel getConfiguration() {
      ProActiveConfModel proModel = new ProActiveConfModel();

      try {
         FileInputStream fstream = new FileInputStream("D:\\ProTool\\proToolconfig.txt");
         DataInputStream in = new DataInputStream(fstream);
         BufferedReader br = new BufferedReader(new InputStreamReader(in));
         Vector allData = new Vector();

         String strLine;
         while((strLine = br.readLine()) != null) {
            allData.add(strLine);
         }

         String[] dataModified = allData.get(0).toString().split("#");
         String[] monStatus = dataModified[0].split("-");
         String interval = dataModified[1];
         String mails = dataModified[2];
         proModel.setMonStartUp(monStatus[0]);
         proModel.setMonPerformance(monStatus[1]);
         proModel.setMonTabelSpace(monStatus[2]);
         proModel.setMonPayment(monStatus[3]);
         proModel.setMonTraffic(monStatus[4]);
         proModel.setMonDailyCMSReport(monStatus[5]);
         proModel.setMonDailyPAYReport(monStatus[6]);
         proModel.setInterval(interval);
         proModel.setMails(mails);
      } catch (Exception var10) {
         System.out.println("Exception : " + var10.toString());
      }

      return proModel;
   }

   public static void main(String[] str) {
      String userName = "CMS_MONITOR";
      String password = "CMS_MONITOR";
      CMSAdapterListener cmsListen = new CMSAdapterListener();
      proModel = getConfiguration();
      System.out.println("Main started");
      Vector MSISDNs = new Vector();
      MSISDNs.add("201093738425");
      MSISDNs.add("201068293023");
      MSISDNs.add("201069062615");
      MSISDNs.add("201020400028");
      MSISDNs.add("201030024022");
      MSISDNs.add("201060020010");
      String message = "Proactive up and running";
      new SendMailUtil();
      SendMailUtil.sendRSMS(MSISDNs, message);
      int sendStatusCounter = 0;
      Calendar calendar = Calendar.getInstance();
      int counter = calendar.get(11);
      boolean check = false;
      boolean healthSent = false;
      Connection con;
      Connection conhq;
      //Date now_pre = new Date();
      int rep_hour = -1;
      int flagSyn = 0; 
      int day = 0;
      int month = 0;
      int year = 0;
      while(true) {
         con = CMSAdapterListener.intConnectionMailSender(userName, password, proModel);
         conhq = CMSAdapterListener.intConnectionMailSenderDR(userName, password, proModel);
         CMSAdapterListener.prepareSQLAction(con);
         CMSAdapterListener.prepareSQLActionDR(conhq);
         if (sendStatusCounter >= 240) {
            SendMailUtil.sendNewSMS(MSISDNs, message);
            sendStatusCounter = 0;
         } else {
            sendStatusCounter += 5;
         }

         try {
            Date now = new Date();
            int hoursNow = now.getHours();
            int minutesNow = now.getMinutes();
            System.out.println("time now is :" + now.toString());
            cmsListen.checkCrontab();
            cmsListen.checkRVTraffic(proModel);
//            cmsListen.FinancialTransactionFail(con,0,proModel);
            LocalDate localDate = LocalDate.now();
            DayOfWeek dayOfWeek = DayOfWeek.from(localDate);
            System.out.println(localDate.getYear()+localDate.getDayOfMonth()+localDate.getMonthValue());
            System.out.println(dayOfWeek.name());
            if (dayOfWeek.name().equals("SATURDAY") && hoursNow == 23 && minutesNow >= 53) {
               cmsListen.provisioning_Failed_Requests(proModel);
            }

            if (hoursNow >= 21 && minutesNow >= 50) {
               cmsListen.DB_ACT_Checks_CORP();
            }
            
            if(rep_hour == -1){
            	cmsListen.replicationStatusGmd(conhq,0,proModel);
//            	cmsListen.FinancialTransactionFail(con,0,proModel);
            	rep_hour = now.getHours();
            } else if(!(rep_hour == now.getHours())){
            	cmsListen.replicationStatusGmd(conhq,0,proModel);
//            	cmsListen.FinancialTransactionFail(con,0,proModel);
            	rep_hour = now.getHours();
            }

            if (hoursNow == 0) {
               maxReached = 0;
               maxReachedWfx = 0;
               commandStatusVec = new Vector();
               commandStatusWfxVec = new Vector();
               monitortablespaceMaxReached = 0;
               otaJobsStartMonitored.clear();
               otaJobsCompletedMonitored.clear();
               archievedJobs.clear();
               assignedSrs.clear();
               CMSAdapterListener.isCDFilesHandled = false;
               CMSAdapterListener.isCDFilesPopulated = false;
               CMSAdapterListener.isCDFilesSuceeded = false;
            }

            System.out.println("1");
            con = cmsListen.checkDbConnection(con, 0, proModel);
            monitortablespaceMaxReached = CMSAdapterListener.checkCMSAdapter_MonitorTabelspace(con, monitortablespaceMaxReached, proModel);
            cmsListen.checkFileSystem(proModel);
            cmsListen.checkVMsHQ();
            cmsListen.DBReplicationCheck();
            if (hoursNow == 10) {
               if (!healthSent) {
                  cmsListen.healthChecks();
                  healthSent = true;
               }
            } else {
               healthSent = false;
            }

            if (hoursNow >= 1 && hoursNow <= 10) {
               if (hoursNow == counter) {
                  cmsListen.changeMsisdnPendingRequest(proModel);
                  System.out.println(" changeMsisdn Pending " + minutesNow + " & date : " + new Date());
                  ++counter;
                  System.out.println("counter is updated & now is " + counter + "now hour is " + hoursNow);
               }
            } else {
               counter = 1;
               System.out.println("out of time boundaries");
            }

            if (hoursNow == 8) {
               if (!check) {
                  cmsListen.PortOUtDirectoryNumberCheck(proModel);
                  check = true;
               }
            } else {
               check = false;
            }
            
            if (hoursNow == 22 && flagSyn == 0) {
               flagSyn = 1;
               cmsListen.syniversTapIO(con,0,proModel);
             } else if(hoursNow != 22){
            	 flagSyn = 0;
             }

            if (minutesNow >= 15 && minutesNow <= 25) {
               cmsListen.MonitorReporting(con, 0, proModel);
               cmsListen.monitorActualBch(con, 0, proModel);
               cmsListen.monitorActualBchAmount(con, 0, proModel);
               System.out.println(" BCHHHHHHHHHHHHHHH " + minutesNow + " & date : " + new Date());
               System.out.println("BCHHHHHHHHHHHHHHH");
            }

            cmsListen.checkOnlineModules();
            cmsListen.checkAdapter();
            cmsListen.checkRatingModules91(proModel);
            cmsListen.checkRatingModules163(proModel);
            cmsListen.checkLicenseServers();
            cmsListen.checkopends();
            cmsListen.checkHaproxy();
            if (minutesNow >= 0 && minutesNow <= 15) {
               cmsListen.checkHaproxy();
            }

            if (minutesNow >= 26 && minutesNow <= 33 || minutesNow >= 56 && minutesNow <= 3) {
               cmsListen.checkFileSystem(proModel);
            }

            archievedJobs = cmsListen.checkBatchArchivedJobs(con, archievedJobs, proModel);
            cmsListen.checkBatchFinishedJobs(con, 0, proModel);
            cmsListen.checkCMSAdapter_MonitorGMD_Mike(con, 0, proModel);
            if (hoursNow >= 2 && hoursNow < 3 && minutesNow >= 10 && minutesNow <= 20) {
               cmsListen.checkOpenDSFiles();
            }

            cmsListen.checkGMD_Prov(con, 0, proModel);
            if (minutesNow >= 26 && minutesNow <= 33 || minutesNow >= 56 && minutesNow <= 3) {
               assignedSrs = cmsListen.checkAssignedSrs(proModel, assignedSrs);
            }

            cmsListen.checkMonitorGMD_Mike();
            Connection con2;
            if (hoursNow == 12 && minutesNow <= 5) {
               try {
                  con2 = CMSAdapterListener.intRtxConnection("CMS_MONITOR", "PRO_MONITOR_12345");
                  CMSAdapterListener.prepareSQLAction2(con2);
                  cmsListen.checkRLH_Freeunits(con2, 60.0F, proModel);
                  con2.close();
               } catch (Exception var21) {
                  System.out.println("Exception while listening " + var21.toString());
               }
            }

            if (hoursNow == 22 && minutesNow <= 5) {
               try {
                  con2 = CMSAdapterListener.intRtxConnection("CMS_MONITOR", "PRO_MONITOR_12345");
                  CMSAdapterListener.prepareSQLAction2(con2);
                  cmsListen.checkRLH_Freeunits(con2, 70.0F, proModel);
                  con2.close();
               } catch (Exception var20) {
                  System.out.println("Exception while listening " + var20.toString());
               }
            }

            cmsListen.monitor_BOTA_SMSs(con, 0);
            CMSAdapterListener.checkCMSAdapter_MonitorProceduresStatus(con, monitortablespaceMaxReached, proModel);
            CMSAdapterListener.checkDB_Locking(con, monitortablespaceMaxReached, proModel);
            otaJobsStartMonitored = CMSAdapterListener.MonitorOTA_ScheduleJob_Start(con, monitortablespaceMaxReached, otaJobsStartMonitored);
            cmsListen.monitorOnlinePthBackLogFunc(con, proModel);
            cmsListen.monitorOnlinePthMemoryProbFunc(con, proModel);
            cmsListen.monitorFIHBackLogFunc(con, proModel);
            cmsListen.monitorMaxCursorsFunc(con, proModel);
            cmsListen.monitorFIHRejectionFunc(con, proModel);
            System.out.println("after calling listeners");
            if (hoursNow == 8 && minutesNow <= 7) {
               CMSAdapterListener.duplicatePaymentsCheck(con, maxReached, proModel);
               CMSAdapterListener.duplicatePaymentOfflineCheck(con, maxReached, proModel);
            }

            if (hoursNow >= 11 && !CMSAdapterListener.isCDFilesHandled) {
            }

            Date nextDay = new Date();
            nextDay.setDate(nextDay.getDate() + 1);
            if (nextDay.getMonth() > now.getMonth() && (now.getHours() == 11 || now.getHours() == 18) && now.getMinutes() <= 7) {
               cmsListen.notifyToRunFOH(proModel);
            }

            cmsListen.monitorBillProcessFlow_wfx(con, 0, proModel);
            maxReachedWfx = CMSAdapterListener.checkCMSAdapter_StartupStatus_wfx(con, maxReachedWfx, proModel);
            CMSAdapterListener.checkBillingFailure_wfx(con, monitortablespaceMaxReachedWfx, proModel);
            cmsListen.FinancialTransactionFail(con,0,proModel);
            CMSAdapterListener.checkBillingConnectionFailure_wfx(con, monitortablespaceMaxReachedWfx, proModel);
            commandStatusWfxVec = CMSAdapterListener.checkCMSAdapter_MonitorPerformance_wfx(con, performanceWfxMaxReached, commandStatusWfxVec, proModel);
            CMSAdapterListener.checkCMSAdapter_MonitorTrafficClosely_wfx(con, 0, proModel);
            CMSAdapterListener.checkPaymentFailures_wfx(con, monitortablespaceMaxReachedWfx, proModel);
            if (minutesNow <= 5) {
               CMSAdapterListener.checkCMSAdapter_MonitorAdapterHourly_wfx(con, proModel);
            }

            CMSAdapterListener.monitorOfflineEngineErrorsFunc_wfx(con, monitortablespaceMaxReachedWfx, proModel);
            if (hoursNow == 8 && minutesNow <= 7) {
               CMSAdapterListener.monitorCmsToCi_wfx(con, proModel);
            }

            cmsListen.monitorAdapter_wfx(con, 0, proModel);
            cmsListen.monitorRunningBatches_wfx(con, 0, proModel);
            if (hoursNow == 12 && minutesNow <= 5 || hoursNow == 22 && minutesNow <= 5) {
               cmsListen.monitorFinancialTransaction_wfx(con, 0, proModel);
            }

            if (minutesNow >= 10 && minutesNow <= 20) {
               cmsListen.CheckQueues(proModel);
            }

            cmsListen.monitorOtaPendingJobs(con, 0, proModel);
            cmsListen.monitorOfflineHTTPRequests_wfx(con, 0, proModel);
            cmsListen.monitorNotificationTable_OTA(con, 0, proModel);
            CMSAdapterListener.sendPingRequest(con, 0, proModel);
            CMSAdapterListener.sendPingRequest(con, 0, proModel);
            if (minutesNow >= 10 && minutesNow <= 16) {
               System.out.println("calling ChangeRatePlanCountMonitor value of minutesNow : " + minutesNow + " & date : " + new Date());
               cmsListen.ChangeRatePlanCountMonitor(con, 0, proModel);
            }

            if (hoursNow >= 3 && hoursNow < 4 && minutesNow >= 10 && minutesNow <= 15) {
               cmsListen.CheckFailedProvRequests(proModel);
               cmsListen.CheckRTXTrends(proModel);
               cmsListen.CheckBC03Customers(proModel);
               System.out.println(" CheckBC03Customers " + minutesNow + " & date : " + new Date());
            }

            if (hoursNow >= 10 && hoursNow < 11 && minutesNow >= 20 && minutesNow <= 30) {
               cmsListen.CheckFailedProvRequests(proModel);
               cmsListen.CheckRTXTrends(proModel);
               cmsListen.Roaming_Rejection(con, 0, proModel);
               cmsListen.Visitors_Rejection(con, 0, proModel);
               cmsListen.Rating_Rejection(con, 0, proModel);
               cmsListen.CheckRatingQueues(proModel);
            }

            con.close();
            int timeToSleep = Integer.parseInt(proModel.getInterval()) * '\uea60';
            System.out.println("time interval is : " + timeToSleep);
            Thread.sleep((long)timeToSleep);
         } catch (Exception var22) {
            String msg = "";
            StackTraceElement[] var15 = var22.getStackTrace();
            int var16 = var15.length;

            for(int var17 = 0; var17 < var16; ++var17) {
               StackTraceElement stackTraceElement = var15[var17];
               msg = msg + stackTraceElement.toString() + "\n";
            }

            System.err.println("Exception while listeneing " + msg);
            MSISDNs = new Vector();
            MSISDNs.add("201093738425");
            MSISDNs.add("201068293023");
            MSISDNs.add("201069062615");
            MSISDNs.add("201020400028");
            MSISDNs.add("201030024022");
            message = "Code Expection occured, check logs at " + new Date();
            SendMailUtil.sendNewSMS(MSISDNs, message);
            sendStatusCounter = 0;
         }
      }
   }
}
