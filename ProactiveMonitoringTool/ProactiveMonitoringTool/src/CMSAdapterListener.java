/* Decompiler 691ms, total 12731ms, lines 4720 */
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CMSAdapterListener {
   public static int batchCounter = 0;
   public static String runningCores = ",";
   public static final int ONLINE_PTH_BKLG_THRESHOLD = 50;
   public static final int ONLINE_PTH_RJCT_THRESHOLD = 50;
   public static boolean isCDFilesHandled = false;
   public static boolean isCDFilesSuceeded = false;
   public static boolean isCDFilesPopulated = false;
   public static PreparedStatement monitorTabelspaceStatus = null;
   public static PreparedStatement GMDIssueInquiry = null;
   public static PreparedStatement GMDIssueUpdate = null;
   public static PreparedStatement monitorBOTASMSActions = null;
   public static PreparedStatement getBOTASettings = null;
   public static PreparedStatement getBOTANumAction = null;
   public static PreparedStatement getBOTAEventVal = null;
   public static PreparedStatement updateBOTAEventVal = null;
   public static PreparedStatement FamilySMSStatus = null;
   public static PreparedStatement SMSQueue = null;
   public static PreparedStatement monitorGMDVal = null;
   public static PreparedStatement monitorGMDBillingVal = null;
   public static PreparedStatement monitorProceduresVal = null;
   public static PreparedStatement monitorKSAtrend = null;
   public static PreparedStatement monitorPreToEasyBatches = null;
   public static PreparedStatement monitorValidatePreToEasyAction = null;
   public static PreparedStatement monitorUpdatePreToEasyAction = null;
   public static PreparedStatement monitorBOTANotificationMails = null;
   public static PreparedStatement monitorBOTAPendingJobs = null;
   public static PreparedStatement monitorDuplicateOnlinePayments = null;
   public static PreparedStatement monitorDuplicateOffOnPayments = null;
   public static PreparedStatement monitorDBLocking = null;
   public static PreparedStatement monitorOTAScheduledJobs = null;
   public static PreparedStatement monitorOTAScheduledJobCompleted = null;
   public static PreparedStatement monitorOTAScheduledJobStatus = null;
   public static PreparedStatement monitorOnlinePthBackLog = null;
   public static PreparedStatement monitorOnlinePthRejection = null;
   public static PreparedStatement monitorOnlinePthMemoryProb = null;
   public static PreparedStatement monitorFIHBackLog = null;
   public static PreparedStatement monitorFIHRejection = null;
   public static PreparedStatement monitorMaxCursors = null;
   public static PreparedStatement getPaymentMoneyAndCustomer = null;
   public static PreparedStatement checkRejectedCdFiles = null;
   public static PreparedStatement updateCDFileStatus = null;
   public static PreparedStatement CheckCDFileStatus = null;
   public static PreparedStatement updateCDFileRecievedDate = null;
   public static PreparedStatement checkservEngLogin = null;
   public static PreparedStatement monitorGMD = null;
   public static PreparedStatement rlhFreeunit = null;
   public static PreparedStatement rlhFreeunitCheck = null;
   public static PreparedStatement checkDbNodes = null;
   public static PreparedStatement monitorRunningBatches = null;
   public static PreparedStatement monitorBatchArchivedJobs = null;
   public static PreparedStatement monitorCorbaIssue = null;
   public static PreparedStatement monitorFinishedJobs = null;
   public static PreparedStatement monitorWfxTrafficCores = null;
   public static PreparedStatement monitorBchActual = null;
   public static PreparedStatement replicationStatus = null;
   public static PreparedStatement monitorBchActualAmount = null;
   public static PreparedStatement montiorLastCycleAmount = null;
   public static PreparedStatement monitorBCReporting = null;
   public static PreparedStatement voicePs = null;
   public static PreparedStatement smsPs = null;
   public static PreparedStatement lastCycleRevenue = null;
   public static PreparedStatement monitorBchProcess_wfx = null;
   public static PreparedStatement startupStatus_wfx = null;
   public static PreparedStatement ChangeRatePlanCount = null;
   public static PreparedStatement ChangeRatePlanSuccess = null;
   public static PreparedStatement TakeOverCount = null;
   public static PreparedStatement TakeOverSuccess = null;
   public static PreparedStatement SIMSwapSuccess = null;
   public static PreparedStatement SIMSwap = null;
   public static PreparedStatement ExecutionTimeSimSwap = null;
   public static PreparedStatement ExecutionTimeChangeRP = null;
   public static PreparedStatement ExecutionTimeTakeOver = null;
   public static PreparedStatement monitorBillingFailure_wfx = null;
   public static PreparedStatement monitorBillingConFailure_wfx = null;
   public static PreparedStatement startupStatusDay_wfx = null;
   public static PreparedStatement monitorPerformance_wfx = null;
   public static PreparedStatement ActiveFamilies = null;
   public static PreparedStatement PendingFamilies = null;
   public static PreparedStatement ActiveMembers = null;
   public static PreparedStatement PendingMembers = null;
   public static PreparedStatement ActiveRedFamilies = null;
   public static PreparedStatement PendingRedFamilies = null;
   public static PreparedStatement ActiveRedMembers = null;
   public static PreparedStatement PendingRedMembers = null;
   public static PreparedStatement Family_HTTP = null;
   public static PreparedStatement MNPFailure = null;
   public static PreparedStatement Family_trans = null;
   public static PreparedStatement monitorTraffic_wfx = null;
   public static PreparedStatement monitorTraffic_M39_wfx = null;
   public static PreparedStatement monitorTraffic_M40_wfx = null;
   public static PreparedStatement monitorTrafficClos_wfx = null;
   public static PreparedStatement monitorBatchTrafficClos_wfx = null;
   public static PreparedStatement monitorNumOfTransactions_wfx = null;
   public static PreparedStatement monitorPaymentFailure_wfx = null;
   public static PreparedStatement checkCores_wfx = null;
   public static PreparedStatement checkRVs_wfx = null;
   public static PreparedStatement dynamicMonitoringWF_wfx = null;
   public static PreparedStatement startupStatus_client_wfx = null;
   public static PreparedStatement monitorAdapterOverallExc_wfx = null;
   public static PreparedStatement monitroOfflineEngError_wfx = null;
   public static PreparedStatement inconsistMon_wfx = null;
   public static PreparedStatement processBusyMon_wfx = null;
   public static PreparedStatement monitorCMSCIWriteFee_wfx = null;
   public static PreparedStatement monitorCMSCIWriteCust_wfx = null;
   public static PreparedStatement monitorAdapter_wfx = null;
   public static PreparedStatement monitorBillSrv_wfx = null;
   public static PreparedStatement monitorSystemUsers_wfx = null;
   public static PreparedStatement monitorNonSystemUsers_wfx = null;
   public static PreparedStatement getRunningBatchesCount30_wfx = null;
   public static PreparedStatement getRunningBatchesCount5_wfx = null;
   public static PreparedStatement monitorFinancialTransaction_wfx = null;
   public static PreparedStatement monitorOfflineRequests_wfx = null;
   public static PreparedStatement monitorOfflineHTTPRequests_wfx = null;
   public static PreparedStatement VisitorsRejection = null;
   public static PreparedStatement RoamingRejection = null;
   public static PreparedStatement TotalRejection = null;
   public static PreparedStatement monitorNotificationTable_OTA = null;
   public static PreparedStatement monitorOtaPendingJobs = null;
   public static PreparedStatement monitorUsers = null;
   public static PreparedStatement monitorRoaming_Rej = null;
   public static PreparedStatement provision_failed = null;
   public static PreparedStatement RV_traffic = null;
   public static PreparedStatement monitorVisitors_Rej = null;
   public static PreparedStatement monitorTotal_Rej = null;
   public static PreparedStatement monitorCorbaProblem = null;
   public static PreparedStatement changeMsisdnPendingRequests = null;
   public static PreparedStatement DBReplication = null;
   public static PreparedStatement PortOutDNCheck = null;
   public static PreparedStatement HealthChecks = null;
   public static PreparedStatement HealthChecksRating = null;
   public static PreparedStatement loadingReportingCheck = null;
   public static PreparedStatement Accumulation = null;
   public static PreparedStatement linuxMachines = null;
   public static PreparedStatement tapOut = null;
   public static PreparedStatement tapIn = null;
   public static PreparedStatement FinancialTransactionFailCount = null;
   public static PreparedStatement FinancialTransactionFailDetails = null;
   public static PreparedStatement FinancialTransactionFailMaxDate = null;
   private static final String USER_AGENT = "Mozilla/5.0";

   public static void prepareSQLAction5(Connection FamCon) {
      String ActiveFamily = "select count(*) as a_f from tx_family where FAMILY_TEMPLATE_ID=47 and FAMILY_STATUS=1 and SUBSCRIPTION_DATE>TO_DATE('04/12/2019 18', 'dd/mm/yyyy HH24')";
      String PendingFamily = "select COUNT(*) as p_f from tx_family where FAMILY_TEMPLATE_ID=47 and FAMILY_STATUS=5 and SUBSCRIPTION_DATE>TO_DATE('04/12/2019 18', 'dd/mm/yyyy HH24')";
      String ActiveMember = "SELECT count(*) as a_m FROM TX_FAMILY_MEMBER where FAMILY_TEMPLATE_ID=47 and member_role_id=2 and member_status=1 and SUBSCRIPTION_DATE>TO_DATE('04/12/2019 18', 'dd/mm/yyyy HH24')";
      String PendingMember = "SELECT count(*) as p_m FROM TX_FAMILY_MEMBER where FAMILY_TEMPLATE_ID=47 and member_role_id=2 and member_status=5 and SUBSCRIPTION_DATE>TO_DATE('04/12/2019 18', 'dd/mm/yyyy HH24')";
      String H_Transactions = "select count(*) as counts,b.DESCRIPTION as des ,c.ERROR_CODE_DESCRIPTION as error from h_transaction a,lk_source_id b ,lk_error_codes c where FAMILY_TEMPLATE_ID=47 and a.MODULE_ID=b.SOURCE_ID and a.STATUS_ID=c.error_code and trunc(a.REQUEST_DATE)=trunc(sysdate) group by b.DESCRIPTION,c.ERROR_CODE_DESCRIPTION order by 2";
      String SMSQ = "SELECT count(*) as c FROM TX_ONLINE_SMS_Q";
      String SMSStatus = "select count(*) as c from H_SMS_INT where SMS_STATUS<>0 and trunc(ENTRY_DATE)=trunc(sysdate)";
      String HTTPRequests = "SELECT  MSISDN MEMBER_MSISDN,Number_Of_HITS, RESPONSE_BODY CI_RESPONSE  , Description  INTERFACE FROM( SELECT msisdn, Count(RESPONSE_BODY) as Number_Of_HITS,RESPONSE_BODY,MODULE_ID FROM h_ext_http_system_call group by msisdn, response_body, MODULE_ID having( response_body LIKE '%STATUS,-100%' AND msisdn NOT IN( '201021897195','201032552456','201092090341','201018011092','201004566915','201020109272','201017886109','201033812020','201026977001','201069175693', '201067833882','201064481970','201011215025','201007695899','201000655619') AND msisdn IN( SELECT msisdn FROM h_ext_http_system_call  WHERE trunc(request_date) >= '05-DEC-19' AND   family_seq_id = 47))) a,LK_SOURCE_ID b where a.MODULE_ID = b.SOURCE_ID";

      try {
         ActiveFamilies = FamCon.prepareStatement(ActiveFamily);
         PendingFamilies = FamCon.prepareStatement(PendingFamily);
         ActiveMembers = FamCon.prepareStatement(ActiveMember);
         PendingMembers = FamCon.prepareStatement(PendingMember);
         Family_HTTP = FamCon.prepareStatement(HTTPRequests);
         Family_trans = FamCon.prepareStatement(H_Transactions);
         FamilySMSStatus = FamCon.prepareStatement(SMSStatus);
         SMSQueue = FamCon.prepareStatement(SMSQ);
         System.out.println("sherif ---------------------> success while initializing activeFamilies within prepSQLActive5");
      } catch (SQLException var11) {
         System.err.println("we have a sql exception " + var11.toString());
         System.err.println("we have a sql exception " + var11.toString());
         String var10 = "CRITICAL-We are facing connectivity problem with billing DB (" + var11.toString() + "), please check";
      } catch (Exception var12) {
         var12.printStackTrace();
         System.out.println("sherif ---------------------> within the static method prepSQLAction5" + var12.toString());
      }

   }

   public static void prepareSQLAction6(Connection FamilyCon) {
      String ActiveRedFamily = "select count(*) as a_ff from tx_family where FAMILY_TEMPLATE_ID=617 and FAMILY_STATUS=1 and SUBSCRIPTION_DATE>TO_DATE('16/08/2020', 'dd/mm/yyyy')";
      String PendingRedFamily = "select COUNT(*) as p_ff from tx_family where FAMILY_TEMPLATE_ID=617 and FAMILY_STATUS=5 and SUBSCRIPTION_DATE>TO_DATE('16/08/2020', 'dd/mm/yyyy')";
      String ActiveRedMember = "SELECT count(*) as a_mm FROM TX_FAMILY_MEMBER where FAMILY_TEMPLATE_ID=617 and member_role_id=2 and member_status=1 and SUBSCRIPTION_DATE>TO_DATE('16/08/2020', 'dd/mm/yyyy')";
      String PendingRedMember = "SELECT count(*) as p_mm FROM TX_FAMILY_MEMBER where FAMILY_TEMPLATE_ID=617 and member_role_id=2 and member_status=5 and SUBSCRIPTION_DATE>TO_DATE('16/08/2020', 'dd/mm/yyyy')";

      try {
         ActiveRedFamilies = FamilyCon.prepareStatement(ActiveRedFamily);
         PendingRedFamilies = FamilyCon.prepareStatement(PendingRedFamily);
         ActiveRedMembers = FamilyCon.prepareStatement(ActiveRedMember);
         PendingRedMembers = FamilyCon.prepareStatement(PendingRedMember);
         System.out.println("sherif ---------------------> success while initializing activeFamilies within prepSQLActive5");
      } catch (SQLException var7) {
         System.err.println("we have a sql exception " + var7.toString());
         System.err.println("we have a sql exception " + var7.toString());
         String var6 = "CRITICAL-We are facing connectivity problem with billing DB (" + var7.toString() + "), please check";
      } catch (Exception var8) {
         var8.printStackTrace();
         System.out.println("sherif ---------------------> within the static method prepSQLAction5" + var8.toString());
      }

   }

   public static void prepareSQLAction(Connection conM) {
      Calendar cal = Calendar.getInstance();
      SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
      String strDate = sdf.format(cal.getTime());
      String[] dateFormat = strDate.split("-");
      String year = dateFormat[2];
      String month = dateFormat[1];
      String day = dateFormat[0];
      int dayInt = Integer.parseInt(dateFormat[0]) - 1;
      System.out.println("Partition value : " + year + month + day);
      System.out.println("embara77777=" + dayInt);
      String monitorBchActualQuery = "SELECT A.BILLSEQNO, B.BILLCYCLE, A.STATUS, COUNT(*) TOTAL, NVL(ROUND((SUM (CASE WHEN D.CUSTOMER_PROCESS_STATUS = 'S' THEN 1 END) / COUNT (*)) * 100,3),0) || '%'  BCH, NVL(ROUND((SUM (CASE WHEN C.DR_ASS_DOC_COPY_COPY_IND > 110 THEN 1 END) / COUNT (*)) * 100,2),0) || '%' LT, NVL(ROUND((SUM (CASE WHEN C.DR_ASS_DOC_COPY_COPY_IND > 210 THEN 1 END) / COUNT (*)) * 100,2),0) || '%' PE, NVL(ROUND((SUM (CASE WHEN C.DR_ASS_DOC_COPY_COPY_IND > 310 THEN 1 END) / COUNT (*)) * 100,2),0) || '%' DOC, NVL(ROUND((SUM (CASE WHEN C.DR_ASS_DOC_COPY_COPY_IND > 410 THEN 1 END) / COUNT (*)) * 100,2),0) || '%' CONV, NVL(ROUND((SUM (CASE WHEN C.DR_ASS_DOC_COPY_COPY_IND > 510 THEN 1 END) / COUNT (*)) * 100,2),0) || '%' ZIP, NVL(ROUND((SUM (CASE WHEN C.DR_ASS_DOC_COPY_COPY_IND > 610 THEN 1 END) / COUNT (*)) * 100,2),0) || '%' LOAD, NVL(ROUND((SUM (CASE WHEN C.DR_ASS_DOC_COPY_COPY_IND > 710 THEN 1 END) / COUNT (*)) * 100,2),0) || '%' REPORT, NVL(SUM (CASE WHEN C.DR_ASS_DOC_COPY_COPY_IND < 0 THEN 1 END), 0) FAIL FROM BCH_PROCESS A, MPULKIXD B, DR_DOCUMENTS C, BCH_PROCESS_CUST D WHERE A.BILLSEQNO = B.BILLSEQNO AND A.BILLSEQNO = D.BILLSEQNO AND B.BILLSEQNO = D.BILLSEQNO AND D.BILLSEQNO = C.DR_REQUEST_ASS_DOC_REQUEST_ID (+) AND A.BILLSEQNO = C.DR_REQUEST_ASS_DOC_REQUEST_ID (+) AND B.BILLSEQNO = C.DR_REQUEST_ASS_DOC_REQUEST_ID (+) AND D.CUSTOMER_ID = C.DR_ADDRESSEE_CUSTOMER_ID (+) AND B.BILL_SIMULATION_IND = 'N' AND B.BILLING_MODE = 'BC' GROUP BY A.BILLSEQNO, B.BILLCYCLE, A.STATUS UNION SELECT A.BILLSEQNO, A.BILLCYCLE, 'S' AS STATUS, COUNT(*) TOTAL, 100 || '%' AS BCH, NVL(ROUND((SUM (CASE WHEN B.DR_ASS_DOC_COPY_COPY_IND > 110 THEN 1 END) / COUNT (*)) * 100,2),0) || '%' LT, NVL(ROUND((SUM (CASE WHEN B.DR_ASS_DOC_COPY_COPY_IND > 210 THEN 1 END) / COUNT (*)) * 100,2),0) || '%' PE, NVL(ROUND((SUM (CASE WHEN B.DR_ASS_DOC_COPY_COPY_IND > 310 THEN 1 END) / COUNT (*)) * 100,2),0) || '%' DOC, NVL(ROUND((SUM (CASE WHEN B.DR_ASS_DOC_COPY_COPY_IND > 410 THEN 1 END) / COUNT (*)) * 100,2),0) || '%' CONV, NVL(ROUND((SUM (CASE WHEN B.DR_ASS_DOC_COPY_COPY_IND > 510 THEN 1 END) / COUNT (*)) * 100,2),0) || '%' ZIP, NVL(ROUND((SUM (CASE WHEN B.DR_ASS_DOC_COPY_COPY_IND > 610 THEN 1 END) / COUNT (*)) * 100,2),0) || '%' LOAD, NVL(ROUND((SUM (CASE WHEN B.DR_ASS_DOC_COPY_COPY_IND > 710 THEN 1 END) / COUNT (*)) * 100,2),0) || '%' REPORT, NVL(SUM (CASE WHEN B.DR_ASS_DOC_COPY_COPY_IND < 0 THEN 1 END), 0) FAIL FROM BCH_HISTORY_TABLE A, DR_DOCUMENTS B WHERE TRUNC(A.LRSTART) >= TRUNC(SYSDATE-3) AND A.BILLSEQNO = B.DR_REQUEST_ASS_DOC_REQUEST_ID (+) GROUP BY A.BILLSEQNO, A.BILLCYCLE HAVING NVL(ROUND((SUM (CASE WHEN B.DR_ASS_DOC_COPY_COPY_IND > 610 THEN 1 END) / COUNT (*)) * 100,2),0) <> 100";
      String ActualBCHMonitorAmount = "select sum(amount) amount from BCH_CONTROL where billseqno in(select billseqno from bch_process) and amount <>0";
      String Repoting_BC = "select BILLSEQNO,BILLCYCLE,LRSTART,extract (month from LRSTART) as Month from BCH_HISTORY_TABLE where BILLSEQNO in (SELECT BILLSEQNO FROM BCH_HISTORY_TABLE  where BILLSEQNO>132525 minus select BILLSEQNO from DWH_FILES_SYNC)";
      String revenueQuery = "SELECT \n  A.BILLED_AMOUNT as last_amount\nFROM BILLING_STATISTIC A,\n  BCH_HISTORY_TABLE B,\n  MPULKIXD C\nWHERE A.BILLSEQNO = B.BILLSEQNO\nAND C.BILLSEQNO   =A.BILLSEQNO\nand C.billcycle in(select BILL_CYCLE_NO from vf_billing_param f where f.SEQ_NO in (select max(f.SEQ_NO) from vf_billing_param))\nand A.BILLSEQNO in (select max(A.billseqno)FROM BILLING_STATISTIC A,\n  BCH_HISTORY_TABLE B,\n  MPULKIXD C\nWHERE A.BILLSEQNO = B.BILLSEQNO\nAND C.BILLSEQNO   =A.BILLSEQNO\nand C.billcycle in(select BILL_CYCLE_NO from vf_billing_param where SEQ_NO in (select max(SEQ_NO) from vf_billing_param)))";
      String monitorTabelspaceQuery = "SELECT df.tablespace_name TabSpace, totalusedspace Used_MB, (df.totalspace - tu.totalusedspace)  Free_MB, df.totalspace Total_MB,ROUND (100 * ((df.totalspace - tu.totalusedspace) / df.totalspace) ) Pct_Free FROM (SELECT tablespace_name, ROUND (SUM (BYTES) / 1048576) totalspace FROM dba_data_files GROUP BY tablespace_name) df,(SELECT   ROUND (SUM (BYTES) / (1024 * 1024)) totalusedspace, tablespace_name FROM dba_segments GROUP BY tablespace_name) tu WHERE df.tablespace_name = tu.tablespace_name   AND tu.tablespace_name = 'DATA_SMALL'";
      String gmdInquiry = "select request from mdsrrtab where status = 22;";
      String gmdUpdate = "update mdsrrtab set status =2 where request = ?";
      String monitorBotaActionsQuery = "select BILL_CYCLE_CODE,BC_LOG_ID,STATUS_ID,CREATION_DATE,TYPE_ID,month from OTA_BC_LOG  where status_id in (58,57,59,62,61) and trunc(creation_date) >= (select max(trunc(creation_date)) from OTA_BC_LOG ) -6";
      String getBotaSettingsQuery = "select setting_id,setting_value from ota_settings where setting_id in( 62,58)";
      String inquireNumberOfAction = "select count(*) sumData from OTA_BC_SMS_LOG where bc_log_id =? and SENDING_STATUS_ID =?";
      String getBOTAEventValQuery = "select * from OTA_ADMIN_EVENT_LOG where EVENT_BODY like ? || '%' and EVENT_TYPE = ?";
      String updateBOTAEventValQuery = "update OTA_ADMIN_EVENT_LOG set EVENT_TYPE=? where event_id = ?";
      String getGMDStatus = "select status , count(*) SUMOFPEND from mdsrrtab where trunc(action_date) <= trunc(sysdate)  group by status";
      String getGMDBillingStatus = "select count(*) SUMPENDBILLING from  mdsrrtab where  action_date <= SYSDATE and STATUS in (1,14,16,11) ";
      String proceduresValidation = "select OBJECT_NAME from dba_objects where OBJECT_NAME in ('ADDSERVICE','ADDSERVICEBYPASS','ADDSERVICE_PARAMETER','ADDSERVICE_RISK','ADDSERVICE_STATUS222','ADD_ASHABPLUS_INTL_MEMBER','ADD_CMS_MODULES','ADD_FAMILY_MEMBER','ASSIGN_POSTPAID_LIFESTYLE','ASSIGN_RAMADAN_PROMO','ASSIGN_SQUARE_PROMO','ASSIGN_VOUCHER','ASSIGN_XFUP','ASSIGN_XFUP_2','CHANGE_SIM_DEALER_CODE','CHECK_BOLT_ON_ELIGIBLITY','CHECK_FAMILY_ELIGIBLITY','CHECK_OMRA_PROMO_ELIGIBLITY','DATA_MATRIX_PROMOTION','DSL_FUNC','GET_DEALER_BY_MSISDN','GET_DN_TYPE','GET_JDK_VERSION','GET_MSISDN_AMOUNT','GET_OCC_DETAILS','GET_TM_SERVICE','GET_USAGE_FROM_PROD','GET_VODAFONE_BSCS_NEXTFREE','GSM_CONTRACT_DEACTIVATION','HOTLINE_CONTRACT','INSERT_TICKLER','INSERT_TICKLER_RISK','LOG_DAWRY_ERROR','MF_APPLY_ADJUSTMENT','MF_APPLY_DEPOSIT','NTS_GET_WAITING_PERIOD','RELEASE_MSISDN','REMBARR_ROAM','REMHOTLINE_CONTRACT','REMOVESERVICE','REMOVESERVICEBYPASS','REMOVESERVICE_STATUS222','REMOVE_ASHABPLUS_INTL_MEMBER','REMOVE_FAMILY_MEMBER','REMSEMIHOTLINE_CONTRACT','REMSERVICE','REMVOICEREMINDER_CONTRACT','REQUEST_RELEASE_MSISDN','REQUEST_RELEASE_SIM','RESET_RANGE','RESET_USER_PASSWORD','SALES_TAX_STORE','SEMIHOTLINE_CONTRACT','UPDATECONTRACTFRAUDINFO','UPDATE_CONTRACT_FRAUD','UPDATE_CONT_FRAUD_NEW_VALS','UPDATE_CREDIT_LIMIT','UPDATE_CUST_REMARKS_TRADE_REF','UPDATE_MNP_DISCONNECT','UPDATE_OVW_ADV_TMP','UPD_CONTRACT_FRAUD_ERR_HANDLE','UPD_HANDSET_FLAGS','VALIDATE_RAMADAN_PROMO','VALIDATE_SQUARE_PROMO','VFE_ADSL_GET_DUMMY_CO','VFE_PROFILE_SP1','VFE_SEG_SP1','VFE_SEG_SP2','VF_BOUQUET_IVR','VF_BUNDLE_USAGE_PROC','VF_BUNDLE_VAS_PROC','VF_CHARGE_CONTRACT','VF_CHECK_ELLIGIBILITY','VF_CHECK_YEARLY_ELIGIBILITY','VF_GET_CONTRACT_RATEPLAN','VF_HAJJPROMO','VF_IVRYEARLYRATEPLAN','VF_PAY_BILL_RC','VF_PAY_PPAS','VF_PROMO_ASSIGN','VF_RAMBIZPROMO_IVR','VF_READ_BILL','VF_READ_BILLED','VF_READ_TOPUP_ELIGIBLITY','VF_ROAMING_STATUS','VF_RP_TYPE','VF_TRANSFER_ROLLBACK','VOICEREMINDER1_CONTRACT','VOICEREMINDER2_CONTRACT','WAIVING_PROCEDURE','PKG_EAI_BSCS_CRIT1','PKG_EAI_BSCS_CRIT2','PKG_EAI_BSCS_CRIT3','PKG_EAI_BSCS_CRIT4','PKG_EAI_BSCS_CRIT5','XFUP_GENERIC') and status <> 'VALID' and owner <> 'SYS' and OBJECT_TYPE <> 'SYNONYM'";
      String monPreToEasyBatches = "select job_id from ota_jobs where  job_type_id = 23 and end_time >=(select sysdate-.009 from dual)";
      String checkNotConvertedPreToEasy = "SELECT distinct  substr (a.dn_num, 3, length(a.dn_num)) MSISDN,d.des RATEPLAN FROM directory_number a, contr_services_cap b, contract_all c, rateplan d, customer_all e, curr_mpulktmb f, ccontact_all ccont WHERE     a.dn_id = b.dn_id AND c.tmcode = d.tmcode AND c.customer_id = e.customer_id AND f.TMCODE = c.tmcode AND f.sncode = 1 AND b.cs_deactiv_date IS NULL AND b.co_id = c.co_id AND ccont.customer_id = e.customer_id AND a.dn_num in ( select 20 || contract_id from ota_job_contracts_arch where job_id = ?) AND lower (d.des) not like '%easy%'";
      String updatePreToEasyFailedStatus = "update ota_job_contracts_arch set status_flag = 14, error_message = 'Failed in takeover' where job_id = ? and contract_id = ?";
      String getNotificationMails = "select * from ota_notification_recipients where job_id =? and event_id =1";
      String MNP_Failed = "SELECT distinct a.co_id ,  d.action_id, d.action_des , insert_date FROM mdsrrtab a, contr_services_cap b, directory_number c, gmd_action d  WHERE ts > SYSDATE - 14 AND TRUNC (insert_date) >= TRUNC (SYSDATE-14) AND status NOT IN (7)  AND action_date < SYSDATE  AND a.co_id IS NOT NULL AND a.co_id = b.co_id AND b.dn_id = c.dn_id AND (c.dn_num NOT LIKE '2010%' OR exists (select 1 from porting_request_history z where c.dn_id = z.dn_id)) AND c.plcode = 1001 AND a.co_id > 226060638 AND a.action_id = d.action_id ORDER BY 2 DESC";
      String getDuplicatOnOff = "select a.customer_id,a.CACHKAMT_GL,a.CACHKDATE, count(PIH_CAREM_VAL) duplicatesExist from ( select customer_id,CACHKAMT_GL ,CACHKDATE,trim(CAREM) PIH_CAREM_VAL from CASHRECEIPTS_ALL where caxact > (select max(caxact) - 1000000 from CASHRECEIPTS_ALL) and CAUSERNAME = 'PIH') a , ( select customer_id,CACHKAMT_GL,CAREM  ETOPUP_CAREM from CASHRECEIPTS_ALL where caxact > (select max(caxact) - 1000000 from CASHRECEIPTS_ALL) and CAUSERNAME = 'ETOPUP') b where PIH_CAREM_VAL  = SUBSTR(ETOPUP_CAREM,6,length(ETOPUP_CAREM)) and a.CACHKAMT_GL = b.CACHKAMT_GL group by  a.customer_id,a.CACHKAMT_GL,a.CACHKDATE ";
      String monitorDBlockingSTRMod = "SELECT s1.username || '@' || s1.machine    || ' ( SID=' || s1.sid || ' ) with serial ' || s1.SERIAL# || ' is blocking '    || s2.username || '@' || s2.machine || \t' ( SID=' || s2.sid || ' )  with serial ' || s2.SERIAL#  AS blocking_status FROM gv$lock l1, gv$session s1, gv$lock l2, gv$session s2 WHERE s1.sid=l1.sid AND s2.sid=l2.sid AND l1.BLOCK=1 AND l2.request > 0 AND l1.id1 = l2.id1 AND l1.id2 = l2.id2  ";
      String scheduledJobFireListner = "SELECT a.START_TIME , b.DAEMON_JOB_NAME FROM OTA_DAEMON_JOB_LOG a, Ota_Daemon_Job b WHERE a.DAEMON_JOB_ID     = b.DAEMON_JOB_ID AND a.DAEMON_JOB_ID      IN (9,11,12,13,16,24,30,31,35) AND ( TRUNC(a.START_TIME) = TRUNC(sysdate) OR ( a.start_time        IS NULL AND a.status_flag        IN (10,11)))";
      String scheduledJobCompletedListner = "SELECT D.DAEMON_JOB_NAME, L.LOOKP_NAME, J.End_TIME FROM OTA_DAEMON_JOB_LOG j, ota_lookups l, ota_daemon_job d WHERE J.STATUS_FLAG     = L.LOOKUP_ID AND D.DAEMON_JOB_ID     = J.DAEMON_JOB_ID AND j.DAEMON_JOB_ID    IN (9,11,12,13,16,24,30,31,35) AND TRUNC(J.End_TIME) = TRUNC(sysdate)";
      String scheduledJobStatus = "SELECT D.DAEMON_JOB_NAME, L.LOOKP_NAME, J.TOTAL_RECORDS, J.PROCESSED_RECORDS, J.SUCCESSFUL_RECORDS, J.FAILED_RECORDS, j.START_TIME, j.END_TIME FROM OTA_DAEMON_JOB_LOG j, ota_lookups l, ota_daemon_job d WHERE J.DAEMON_JOB_ID  IN (9,11,12,13,16,24,30,31,35) AND J.STATUS_FLAG       = L.LOOKUP_ID AND D.DAEMON_JOB_ID     = J.DAEMON_JOB_ID AND J.STATUS_FLAG      IN (12,14)AND TRUNC(j.END_TIME) = TRUNC(sysdate)";
      String monitorNewPaymentDuplicates = "SELECT   /*+ parallel(32)*/ CACHKNUM, CACHKAMT_GL , CUSTOMER_ID, COUNT(1) SUMVAL FROM CASHRECEIPTS_ALL WHERE  CAXACT > (SELECT MAX(CAXACT) - 1000000 FROM  CASHRECEIPTS_ALL) AND CACHKDATE = TRUNC(SYSDATE)-1 AND CAUSERNAME = 'ETOPUP' AND CA_REV_ORIG_XACT IS NULL GROUP BY CACHKAMT_GL ,CACHKNUM ,CUSTOMER_ID HAVING COUNT(1) > 1";
      String monitorOnlinePthBackLogQuery = "select count(1) SUMBKLG from pihtab_all where TRANSX_STATUS=1 ";
      String monitorOnlinePthRejectionQuery = "select count(1) SUMRJCT from pihtab_all where TRANSX_STATUS=3 ";
      String monitorOnlinePthMemoryProbQuery = "select count(1) SUMRJCT from pihtab_all where transx_process_text like 'Allocation of memory failed%' and TRANSX_STATUS=1 ";
      String monitorFIHBackLogQuery = "select count(1) SUMBKLG from thufitab where status = 0 ";
      String monitorFIHRejectQuery = "select count(1) as countRej from thufitab where filename not like 'CD%' and status =1 and trunc(RECEIVED)>=trunc(sysdate)";
      String monitorMaxCursorsQuery = "SELECT   a.VALUE, s.username, s.SID, s.serial# as SERIAL FROM v$sesstat a, v$statname b, v$session s WHERE a.statistic# = b.statistic# AND s.SID = a.SID AND b.NAME = 'opened cursors current' AND VALUE > 850 ORDER BY 1 DESC";
      String getPaymentMoneyAndCustomerQuery = "select b.CUSTcode,a.CACHKAMT_PAY,c.billcycle from cashreceipts_all a,customer_all b, BILLCYCLE_ASSIGNMENT_HISTORY c where a.customer_id = ? and a.CACHKNUM= ? and a.customer_id = b.customer_id and b.customer_id = c.customer_id and a.customer_id = c.customer_id and c.seqno = (select max(seqno) from BILLCYCLE_ASSIGNMENT_HISTORY where customer_id = b.customer_id)";
      String getCDFileId = "SELECT file_id FROM thufitab WHERE received > SYSDATE - 20 AND filename LIKE 'CD%' AND status not in (2,11) ORDER BY received ";
      String checkServEngLoginQuery = "SELECT USERNAME, OSUSER,MACHINE, SID, Serial# as serial,PROCESS, STATUS,LOGON_TIME FROM v$session WHERE USERNAME = 'SERVENGDB' AND LOWER (OSUSER) NOT IN ('dcenter',  'osanad','zahmed','ykhairallah','bscs_adm','billadm','tmauto','ett','tmauto1', 'tech' ,'prnteng','dwh1', 'dsadm', 'orasrv1' ) ";
      String monitorGMDQuery = "select count(*) UNPROC, status from mdsrrtab where action_date <= sysdate and trunc(insert_date) = trunc(sysdate) and status < 30 group by status";
      String monitorRunningBatchesQuery = "select job_id, round(100*(sum(case when status = 'success' then 1 else 0 end)/count(1)), 2) || ' %' as SUCCESS from vfe_batch_activation where job_id in (select job_id from vfe_batch_activation_job where STATUS = 'in-progress') group by job_id";
      String monitorBatchArchivedJobsQuery = "select job_id, simpoh_id, count(1) as SIMS_NUM from vfe_batch_activation_archive where JOB_ID in (select job_id from vfe_batch_activation_job where STATUS = 'archived' and trunc(END_DATE) = trunc(SYSDATE)) group by job_id, simpoh_id order by job_id, simpoh_id";
      String monitorFinishedJobsQuery = "select job_id, end_date from vfe_batch_activation_job where STATUS = 'finished' and END_DATE > SYSDATE - (20/(24*60))";
      String monitorBchProcessQuery_wfx = "select count(*) SUMERROR from WORKFLOWX.VFE_CMS_CLIENTS_LOG_ADP PARTITION (vfe_cms_clients_log_" + year + month + day + ") where flow_name = 'BILL_PROCESS' and reply_code <> 0 AND INPUT NOT LIKE '%BILLING_REQUEST_NUMBER%' and REQUEST_DATE >= (select sysdate-.007 from dual)";
      String CORBAProblemIssue = "select count(*) ChangeRP_Count from WORKFLOWX.VFE_CMS_CLIENTS_LOG_ADP PARTITION (vfe_cms_clients_log_" + year + month + day + ") where (trans_id like 'RV%' or trans_id like 'Offline%' or trans_id like 'WS%' or trans_id like 'HTTP%') and reply_message ='CORBA SECURITY PROBLEM' and trunc(request_date) = to_date('" + year + month + day + "')";
      String CountOfChangeRatePlanActions = "select count(*) ChangeRP_Count from WORKFLOWX.VFE_CMS_CLIENTS_LOG_ADP PARTITION (vfe_cms_clients_log_" + year + month + day + ") where flow_name='CRPConverged' and REQUEST_DATE > SYSDATE - (60/(24*60))";
      String CountOfChangeRatePlanSuccess = "select count(*) ChangeRP_Success from WORKFLOWX.VFE_CMS_CLIENTS_LOG_ADP PARTITION (vfe_cms_clients_log_" + year + month + day + ") where flow_name='CRPConverged' and REQUEST_DATE > SYSDATE - (60/(24*60)) and reply_code=0";
      String CountOfTakeOverActions = "select count(*) TakeOver_Count from WORKFLOWX.VFE_CMS_CLIENTS_LOG_ADP PARTITION (vfe_cms_clients_log_" + year + month + day + ") where flow_name='ContractTakeOverConverged' and REQUEST_DATE > SYSDATE - (60/(24*60))";
      String CountOfTakeOverSuccess = "select count(*) TakeOver_Success from WORKFLOWX.VFE_CMS_CLIENTS_LOG_ADP PARTITION (vfe_cms_clients_log_" + year + month + day + ") where flow_name='ContractTakeOverConverged' and REQUEST_DATE > SYSDATE - (60/(24*60)) and reply_code=0";
      String CountOfSimSwapActions = "select count(*) SimSwap_Count from WORKFLOWX.VFE_CMS_CLIENTS_LOG_ADP PARTITION (vfe_cms_clients_log_" + year + month + day + ") where flow_name='WriteSimSwapNew' and REQUEST_DATE > SYSDATE - (60/(24*60))";
      String CountOfSimSwapSuccess = "select count(*) SimSwap_Success from WORKFLOWX.VFE_CMS_CLIENTS_LOG_ADP PARTITION (vfe_cms_clients_log_" + year + month + day + ") where flow_name='WriteSimSwapNew' and REQUEST_DATE > SYSDATE - (60/(24*60)) and reply_code=0";
      String ChangeRatePlanAvgExecution = "select sum(request_execution_time)/count (*) AVG_PROCESSING_TIME_ChangeRP from WORKFLOWX.VFE_CMS_CLIENTS_LOG_ADP PARTITION (vfe_cms_clients_log_" + year + month + day + ")WHERE REQUEST_DATE > SYSDATE - (60/(24*60)) and Reply_code <> 0 and flow_name='CRPConverged'";
      String SimSwapAvgExecution = "select sum(request_execution_time)/count (*) AVG_PROCESSING_TIME_SimSwap from WORKFLOWX.VFE_CMS_CLIENTS_LOG_ADP PARTITION (vfe_cms_clients_log_" + year + month + day + ")WHERE REQUEST_DATE > SYSDATE - (60/(24*60)) and Reply_code <> 0 and flow_name='WriteSimSwapNew'";
      String TakeOverAvgExecution = "select sum(request_execution_time)/count (*) AVG_PROCESSING_TIME_TakeOver from WORKFLOWX.VFE_CMS_CLIENTS_LOG_ADP PARTITION (vfe_cms_clients_log_" + year + month + day + ")WHERE REQUEST_DATE > SYSDATE - (60/(24*60)) and Reply_code <> 0 and flow_name='ContractTakeOverConverged'";
      String startupStatusQuery_wfx = "select count(*) SUMERROR from WORKFLOWX.VFE_CMS_CLIENTS_LOG_ADP PARTITION (vfe_cms_clients_log_" + year + month + day + ") where reply_code in (304,302) and REQUEST_DATE >= (select sysdate-.007 from dual)";
      String monitorBillingFailureQuery_wfx = "select count(*) SUMERROR from WORKFLOWX.VFE_CMS_CLIENTS_LOG_ADP PARTITION (vfe_cms_clients_log_" + year + month + day + ") where  lower(REPLY_MESSAGE) like '%unknown billing communication error%' and REQUEST_DATE >= (select sysdate-.007 from dual)";
      String monitorBillingConFailureQuery_wfx = "select count(*) SUMERROR from WORKFLOWX.VFE_CMS_CLIENTS_LOG_ADP PARTITION (vfe_cms_clients_log_" + year + month + day + ") where reply_code = 505 and upper(REPLY_MESSAGE) like '%TOPLINK%' and REQUEST_DATE >= (select sysdate-.007 from dual)";
      String startupStatusDayQuery_wfx = "select count(*) SUMERROR from WORKFLOWX.VFE_CMS_CLIENTS_LOG_ADP PARTITION (vfe_cms_clients_log_" + year + month + day + ") where reply_code in (304,302,303) and REQUEST_DATE >= trunc (sysdate)";
      String monitorPerformanceQuery_wfx = "select max (REQUEST_EXECUTION_TIME)  EXECUTION_TIME, flow_name WORKFLOW,reply_code from WORKFLOWX.VFE_CMS_CLIENTS_LOG_ADP PARTITION (vfe_cms_clients_log_" + year + month + day + ") where reply_code in (0,304) and REQUEST_DATE >=(select sysdate-.007 from dual) group by flow_name,reply_code";
      String monitorTrafficQuery_wfx = "select count (*) SUMTRAFC from WORKFLOWX.VFE_CMS_CLIENTS_LOG_ADP PARTITION (vfe_cms_clients_log_" + year + month + day + ") where TRANS_ID like '%RV%' and REQUEST_DATE >= (select (sysdate -.004) from dual)";
      String monitorTrafficQuery_M39_wfx = "select count (*) SUMTRAFC_39 from WORKFLOWX.VFE_CMS_CLIENTS_LOG_ADP PARTITION (vfe_cms_clients_log_" + year + month + day + ") where TRANS_ID like '%RV%' and interface_id in (2,5) and  REQUEST_DATE >= (select (sysdate -.0035) from dual)";
      String monitorTrafficQuery_M40_wfx = "select count (*) SUMTRAFC_40 from WORKFLOWX.VFE_CMS_CLIENTS_LOG_ADP PARTITION (vfe_cms_clients_log_" + year + month + day + ") where TRANS_ID like '%RV%' and interface_id in (6,7) and  REQUEST_DATE >= (select (sysdate -.0035) from dual)";
      String MonitorCORBASECURITYPROBLEM = "select count (*) SUMERR from WORKFLOWX.VFE_CMS_CLIENTS_LOG_ADP PARTITION (vfe_cms_clients_log_" + year + month + day + ") where (REPLY_MESSAGE)='CORBA SECURITY PROBLEM' and OPEN_CONNECTION=1 and  REQUEST_DATE >= (select (sysdate -.04) from dual)";
      String monitorTrafficClosQuery_wfx = "select count (*) NumGreat4Sec , flow_name, max(REQUEST_EXECUTION_TIME) maxTime,AVG(REQUEST_EXECUTION_TIME) AverageExecutionTime from WORKFLOWX.VFE_CMS_CLIENTS_LOG_ADP PARTITION (vfe_cms_clients_log_" + year + month + day + ") where  interface_id not in (6,7) and FLOW_NAME <>'CI_CS_BSCS_SYNC_JOB' and REQUEST_DATE >= (sysdate -.0035) group by flow_name order by NumGreat4Sec desc";
      String monitorBatchTrafficClosQuery_wfx = "select count(*) SUMBATCHTRAFFIC from WORKFLOWX.VFE_CMS_CLIENTS_LOG_ADP partition(vfe_cms_clients_log_" + year + month + day + ") where  CORE_ID in (13,15,16,17) and REQUEST_DATE >=(select sysdate-.007 from dual) ";
      String monitorNumOfTransactionsQuery_wfx = "select count(*)  interfaceCount from WORKFLOWX.VFE_CMS_CLIENTS_LOG_ADP PARTITION (vfe_cms_clients_log_" + year + month + day + ")  where flow_name = ?  and  REQUEST_DATE >=(select sysdate-.007 from dual) and REQUEST_EXECUTION_TIME > 6000 ";
      String monitorPaymentFailureQuery_wfx = "select count(*) SUMERROR  from WORKFLOWX.VFE_CMS_CLIENTS_LOG_ADP PARTITION (vfe_cms_clients_log_" + year + month + day + ") where FLOW_NAME ='EPG_ONLINE_BILL_PAYMENT' and reply_code = 505 and REPLY_MESSAGE like '%SOI%' and  REQUEST_DATE >= (select sysdate-.007 from dual)";
      String checkCoresQuery_wfx = "SELECT core_id, COUNT (1) SUMTraffic FROM WORKFLOWX.VFE_CMS_CLIENTS_LOG_ADP PARTITION (vfe_cms_clients_log_" + year + month + day + ") where request_date > sysdate - (5)/(24*60) GROUP BY core_id";
      String checkRVsQuery_wfx = "SELECT  interface_id,COUNT (1)    FROM WORKFLOWX.VFE_CMS_CLIENTS_LOG_ADP PARTITION (vfe_cms_clients_log_" + year + month + day + ") where request_date > sysdate - (5)/(24*60)  and interface_id in (2,7) GROUP BY interface_id";
      String dynamicMonitoringWFQuery_wfx = "  select count (*) NumGreat4Sec , flow_name, max(REQUEST_EXECUTION_TIME) maxTime,AVG(REQUEST_EXECUTION_TIME) AverageExecutionTime from WORKFLOWX.VFE_CMS_CLIENTS_LOG_ADP where  REQUEST_DATE >=(select sysdate-.007 from dual) and flow_name = ? and reply_code = 0 group by flow_name  order by NumGreat4Sec desc";
      String startupStatus_clientQuery_wfx = "select distinct username,count(*) SUMVAL from WORKFLOWX.VFE_CMS_CLIENTS_LOG_ADP PARTITION (vfe_cms_clients_log_" + year + month + day + ")  where reply_code = 303 group by username having count(*)> 100 ";
      String monitorAdapterOverallExcQuery_wfx = "select   ROUND(AVG(REQUEST_EXECUTION_TIME)) AVG_EXC,count(*) SUMTRAFFIC from WORKFLOWX.VFE_CMS_CLIENTS_LOG_ADP  PARTITION (vfe_cms_clients_log_" + year + month + day + ") where   TRANS_ID like '%RV%' and core_id not in (13,14,15,16,17) and request_date >=   sysdate -(1/24) and request_date <= sysdate";
      String monitroOfflineEngErrorQuery_wfx = "select request_id,Input_Parameters from WORKFLOWX.VFE_DB_REQUESTS_ARCHIVE_ADP where ARCHIVE_DATE >= sysdate - (10/(24*60)) and reply_message = 'Unknown Error!! (key not found in messages resource)'";
      String inconsistMonQuery_wfx = "select count(*) SUMERROR from WORKFLOWX.VFE_CMS_CLIENTS_LOG_ADP PARTITION (vfe_cms_clients_log_" + year + month + day + ") where reply_code = 505 and REPLY_MESSAGE like '%Database inconsistency%' and REQUEST_DATE >= (select sysdate-.007 from dual)";
      String processBusyMonQuery_wfx = "select count(*) SUMERROR from WORKFLOWX.VFE_CMS_CLIENTS_LOG_ADP PARTITION (vfe_cms_clients_log_" + year + month + day + ") where reply_code = 505 and REPLY_MESSAGE like '%This action cannot be performed at the moment. The action is canceled because the data is being modified by another user or process%' and REQUEST_DATE >= (select sysdate-.007 from dual)";
      String monitorCMSCIWriteFeeQuery_wfx = "select trans_id from WORKFLOWX.VFE_CMS_CLIENTS_LOG_ADP partition(vfe_cms_clients_log_" + year + month + String.format("%02d", dayInt) + ") where flow_name ='WriteFeeConverged' and reply_code <> 0 and trans_id in (select trans_id from WORKFLOWX.VFE_HTTP_SYSTEMS_LOG_ADP partition(VFE_HTTP_SYSTEMS_LOG_" + year + month + String.format("%02d", dayInt) + ")  where RESPONSE like 'STATUS,2;')";
      String monitorCMSCIWriteCustQuery_wfx = "select trans_id from WORKFLOWX.VFE_CMS_CLIENTS_LOG_ADP partition(vfe_cms_clients_log_" + year + month + String.format("%02d", dayInt) + ") where flow_name ='WriteCustomerContractServicesConverged' and reply_code <> 0 and trans_id in (select trans_id from WORKFLOWX.VFE_HTTP_SYSTEMS_LOG_ADP partition(VFE_HTTP_SYSTEMS_LOG_" + year + month + String.format("%02d", dayInt) + ")  where RESPONSE like 'STATUS,2;') ";
      String monitorAdapterQuery_wfx = "SELECT INTERFACE_ID, CORE_ID , COUNT (1) TOTAL, NVL(SUM (CASE WHEN reply_code = 0 THEN 1 END),0) SUCCESS, NVL(SUM (CASE WHEN reply_code <> 0 THEN 1 END),0) ERROR, NVL(ROUND((SUM (CASE WHEN reply_code = 0 THEN 1 END)/COUNT (1)) * 100,2),0) SUCCESS_RATE, NVL(ROUND((SUM (CASE WHEN reply_code = 303 THEN 1 END) / COUNT (1)) * 100,2),0) NO_AVAILABLE_CONN, NVL(ROUND((SUM (CASE WHEN REPLY_CODE = 509999 THEN 1 END)/COUNT (1)) * 100 , 2),0) \"509999\", NVL(ROUND((SUM (CASE WHEN REPLY_MESSAGE LIKE '%Unknown billing communication error%' THEN 1 END) / COUNT (1)) * 100 , 2),0) UNKOWN_BILL_COM, NVL(ROUND((SUM (CASE WHEN REPLY_MESSAGE LIKE '%Billing communication failure%' THEN 1 END)/COUNT (1)) * 100 , 2),0) BILL_COM_FAIL, NVL(ROUND((SUM (CASE WHEN REPLY_MESSAGE LIKE '%Message timed out%' THEN 1 END)/COUNT (1)) * 100 , 2),0) TIME_OUT, NVL(ROUND((SUM (CASE WHEN REPLY_MESSAGE LIKE '%No Free Requests For Client%' THEN 1 END)/COUNT (1)) * 100 , 2),0) NO_FREE_REQUESTS, NVL(ROUND((SUM (CASE WHEN REPLY_MESSAGE LIKE '%Error while searching for a core with free threads%' THEN 1 END)/COUNT (1)) * 100 , 2),0) NO_FREE_THREADS FROM WORKFLOWX.VFE_CMS_CLIENTS_LOG_ADP PARTITION (vfe_cms_clients_log_" + year + month + day + ") WHERE trunc(request_date) = trunc(sysdate) AND request_date > SYSDATE - (7/(24*60)) AND reply_code not in (5047, 5048, 5019) AND reply_message not like '%has no access rights%' and flow_name <> 'WriteTickler' and (interface_id not in (select interface_id_ex from  WORKFLOWX.WFX_Excluded_Errors ) or reply_message not in (select reply_message_ex from  WORKFLOWX.WFX_Excluded_Errors)) GROUP BY INTERFACE_ID, CORE_ID HAVING COUNT (1) > 50 ORDER BY SUCCESS_RATE, INTERFACE_ID, CORE_ID";
      String monitorBillSrvQuery_wfx = "select count(*) as SUMERR from WORKFLOWX.VFE_CMS_CLIENTS_LOG_ADP partition(vfe_cms_clients_log_" + year + month + day + ") where flow_name = 'EPG_ONLINE_BILL_PAYMENT' and REQUEST_DATE > sysdate - 0.005 and reply_code <> 0";
      String monitorSystemUsersQuery_wfx = "SELECT INTERFACE_ID, CORE_ID , COUNT(1) TOTAL, NVL(SUM (CASE WHEN REPLY_CODE = 5047 THEN 1 END),0) ACCOUNT_PROBLEM, NVL(SUM (CASE WHEN REPLY_CODE = 5048 THEN 1 END),0) SECURITY_PROBLEM, NVL(SUM (CASE WHEN REPLY_CODE = 5019 THEN 1 END),0) LOGIN_PROBLEM FROM WORKFLOWX.VFE_CMS_CLIENTS_LOG_ADP PARTITION (vfe_cms_clients_log_" + year + month + day + ") WHERE REPLY_CODE IN (5047, 5048, 5019) AND REQUEST_DATE > SYSDATE - (5/(24*60)) AND username IN ('TEBCO', 'REVAMP', 'SBPBT', 'ETOPUP', 'INTERNET', 'CCIVR', 'POS1', 'USSDCAS', 'BATCHS1', 'DCA', 'VARISK', 'OTA_TOOL', 'MEDCMS', 'WTAUSCH', 'NCO', 'CLOUDBILLING', 'PREIVR', 'AG', 'BATCHD', 'BTOOL' ) GROUP BY INTERFACE_ID, CORE_ID HAVING COUNT (1) > 0 ORDER BY COUNT(1) DESC, INTERFACE_ID, CORE_ID";
      String monitorNonSystemUsersQuery_wfx = "SELECT USERNAME, COUNT(1) TOTAL, NVL(SUM (CASE WHEN REPLY_CODE = 5047 THEN 1 END),0) ACCOUNT_PROBLEM, NVL(SUM (CASE WHEN REPLY_CODE = 5048 THEN 1 END),0) SECURITY_PROBLEM, NVL(SUM (CASE WHEN REPLY_CODE = 5019 THEN 1 END),0) LOGIN_PROBLEM FROM WORKFLOWX.VFE_CMS_CLIENTS_LOG_ADP PARTITION (VFE_CMS_CLIENTS_LOG_" + year + month + day + ") WHERE REPLY_CODE not in (0,100) AND REQUEST_DATE  > SYSDATE - (5/(24*60)) GROUP BY USERNAME HAVING COUNT(1) > 300 ORDER BY 2 DESC";
      String getRunningBatchesCount30Query_wfx = "select count(1) as count FROM WORKFLOWX.VFE_CMS_CLIENTS_LOG_ADP PARTITION (vfe_cms_clients_log_" + year + month + day + ") WHERE flow_name = 'WriteBatchContract' and request_date > SYSDATE - (30/(24*60))";
      String getRunningBatchesCount5Query_wfx = "select count(1) AS COUNT, round(100*(sum(case when reply_code = 0 then 1 else 0 end)/count(1)), 2) as SUCCESS_RATE FROM WORKFLOWX.VFE_CMS_CLIENTS_LOG_ADP PARTITION (vfe_cms_clients_log_" + year + month + day + ") WHERE flow_name = 'WriteBatchContract' and request_date > SYSDATE - (5/(24*60))";
      String KSAmonitor = "SELECT  COUNT(*) as count FROM workflowx.vfe_db_requests_archive_adp where trunc(entry_date) =trunc(sysdate) and input_parameters  like '%FU_PACK_ID=1149%'";
      String monitorFinancialTransactionQuery_wfx = "SELECT TO_CHAR(request_date,'HH24')         AS HOUR, ROUND(AVG(REQUEST_EXECUTION_TIME)/1000,2) AS AVG_REQUEST_TIME, COUNT(1)                                  AS NUM_OF_REQUESTS, sum(case when reply_code = 0 then 1 else 0 end) AS SUCCESS, sum(case when reply_code <> 0 then 1 else 0 end) AS FAILED, sum(case when reply_code = 505 then 1 else 0 end) AS \"505\", sum(case when reply_code = 304 then 1 else 0 end) AS \"304\", sum(case when reply_code = 509999 then 1 else 0 end) AS \"509999\", sum(case when reply_code = 5025 then 1 else 0 end) AS \"5025\" FROM WORKFLOWX.VFE_CMS_CLIENTS_LOG_ADP PARTITION (vfe_cms_clients_log_" + year + month + day + ") WHERE flow_name = 'FinancialTransaction' AND  reply_code NOT IN (5047, 5048, 5019) AND  reply_message not like '%has no access rights%' GROUP BY TO_CHAR(request_date,'HH24') ORDER BY 1 desc";
      String monitorOfflineRequestsQuery_wfx = "select STATUS_ID, COUNT(1) AS CNT FROM workflowx.VFE_OFFLINE_REQUESTS_ADP WHERE ENTRY_DATE >= TRUNC(SYSDATE) AND ACTION_DATE <= SYSDATE group by STATUS_ID";
      String monitorHTTPOfflineRequestsQuery_wfx = "select count (*) as CNT from  WORKFLOWX.VFE_DB_REQUESTS_ADP";
      String monitorVisitorsRejectionQuery = "SELECT /*+ parallel(32)*/ count(*),trunc(START_TIME_TIMESTAMP) from perh_statistics  where S_P_PORT_ADDRESS not like '6020%' and trunc(START_TIME_TIMESTAMP) > sysdate-10 group by trunc(START_TIME_TIMESTAMP) order by 2";
      String monitorNotification_OTA = "select count (*) as Count from  ota_notification_recipients";
      String monitorOtaPendingJobsQuery = "select count(*) AS COUNT from ota_jobs where Status_Flag=10";
      String monitorUsersQuery = "SELECT USERNAME, SID, MACHINE, SQL.sql_fulltext FROM GV$SESSION SES, GV$SQL SQL WHERE SES.STATUS = 'ACTIVE' AND SES.USERNAME IN ('RTX_DBLINK','CCHELPDESK','LOGIN_DUMMY','EXPUSER') AND SES.SQL_ADDRESS = SQL.ADDRESS AND SES.SQL_HASH_VALUE = SQL.HASH_VALUE AND Ses.AUDSID <> userenv('SESSIONID')";
      String Visitors_Rej = "SELECT  /*+ parallel(32)*/ count(*) as count,to_char((START_TIME_TIMESTAMP), 'mm-dd') as datee from perh_statistics@BSCS_TO_RTX_LINK  where S_P_PORT_ADDRESS not like '6020%' and trunc(START_TIME_TIMESTAMP) > sysdate-30 group by to_char((START_TIME_TIMESTAMP), 'mm-dd') order by 2";
      String Roaming_Rej = "SELECT /*+ parallel(32)*/  count(*) as count,to_char((START_TIME_TIMESTAMP), 'mm-dd') as datee from perh_statistics@BSCS_TO_RTX_LINK where S_P_location_ADDRESS not like '6020%' and trunc(START_TIME_TIMESTAMP) > sysdate-30 group by to_char((START_TIME_TIMESTAMP), 'mm-dd') order by 2";
      String Total_Rej = "SELECT /*+ parallel(32)*/    count(*) as count,to_char((START_TIME_TIMESTAMP), 'mm-dd') as datee from perh_statistics@BSCS_TO_RTX_LINK  where trunc(START_TIME_TIMESTAMP) > sysdate-30 group by to_char((START_TIME_TIMESTAMP), 'mm-dd') order by 2";
      String tapOutQuery = "select count(*) as TAP_OUT from mpurhtab where fldir='O' and trunc(flcre)=trunc(sysdate-1) and flname like 'CD%'";
      String tapInQuery = "select count(*) as TAP_IN from mpurhtab where fldir='I' and trunc(flcre)=trunc(sysdate-1) and flname like 'CD%'";

      
      try {
         monitorBchActual = conM.prepareStatement(monitorBchActualQuery);
         monitorBchActualAmount = conM.prepareStatement(ActualBCHMonitorAmount);
         monitorBCReporting = conM.prepareStatement(Repoting_BC);
         montiorLastCycleAmount = conM.prepareStatement(revenueQuery);
         monitorFinishedJobs = conM.prepareStatement(monitorFinishedJobsQuery);
         monitorBatchArchivedJobs = conM.prepareStatement(monitorBatchArchivedJobsQuery);
         monitorCorbaIssue = conM.prepareStatement(CORBAProblemIssue);
         monitorRunningBatches = conM.prepareStatement(monitorRunningBatchesQuery);
         monitorGMD = conM.prepareStatement(monitorGMDQuery);
         monitorTabelspaceStatus = conM.prepareStatement(monitorTabelspaceQuery);
         GMDIssueInquiry = conM.prepareStatement(gmdInquiry);
         GMDIssueUpdate = conM.prepareStatement(gmdUpdate);
         monitorBOTASMSActions = conM.prepareStatement(monitorBotaActionsQuery);
         getBOTASettings = conM.prepareStatement(getBotaSettingsQuery);
         getBOTANumAction = conM.prepareStatement(inquireNumberOfAction);
         getBOTAEventVal = conM.prepareStatement(getBOTAEventValQuery);
         updateBOTAEventVal = conM.prepareStatement(updateBOTAEventValQuery);
         monitorGMDVal = conM.prepareStatement(getGMDStatus);
         MNPFailure = conM.prepareStatement(MNP_Failed);
         monitorGMDBillingVal = conM.prepareStatement(getGMDBillingStatus);
         monitorProceduresVal = conM.prepareStatement(proceduresValidation);
         monitorPreToEasyBatches = conM.prepareStatement(monPreToEasyBatches);
         monitorValidatePreToEasyAction = conM.prepareStatement(checkNotConvertedPreToEasy);
         monitorUpdatePreToEasyAction = conM.prepareStatement(updatePreToEasyFailedStatus);
         monitorBOTANotificationMails = conM.prepareStatement(getNotificationMails);
         monitorDuplicateOnlinePayments = conM.prepareStatement(monitorNewPaymentDuplicates);
         monitorDuplicateOffOnPayments = conM.prepareStatement(getDuplicatOnOff);
         monitorDBLocking = conM.prepareStatement(monitorDBlockingSTRMod);
         monitorOTAScheduledJobs = conM.prepareStatement(scheduledJobFireListner);
         monitorOTAScheduledJobCompleted = conM.prepareStatement(scheduledJobCompletedListner);
         monitorOTAScheduledJobStatus = conM.prepareStatement(scheduledJobStatus);
         monitorOnlinePthBackLog = conM.prepareStatement(monitorOnlinePthBackLogQuery);
         monitorOnlinePthRejection = conM.prepareStatement(monitorOnlinePthRejectionQuery);
         monitorOnlinePthMemoryProb = conM.prepareStatement(monitorOnlinePthMemoryProbQuery);
         monitorFIHBackLog = conM.prepareStatement(monitorFIHBackLogQuery);
         monitorFIHRejection = conM.prepareStatement(monitorFIHRejectQuery);
         monitorMaxCursors = conM.prepareStatement(monitorMaxCursorsQuery);
         getPaymentMoneyAndCustomer = conM.prepareStatement(getPaymentMoneyAndCustomerQuery);
         checkRejectedCdFiles = conM.prepareStatement(getCDFileId);
         checkservEngLogin = conM.prepareStatement(checkServEngLoginQuery);
         monitorBchProcess_wfx = conM.prepareStatement(monitorBchProcessQuery_wfx);
         startupStatus_wfx = conM.prepareStatement(startupStatusQuery_wfx);
         ChangeRatePlanCount = conM.prepareStatement(CountOfChangeRatePlanActions);
         ChangeRatePlanSuccess = conM.prepareStatement(CountOfChangeRatePlanSuccess);
         TakeOverCount = conM.prepareStatement(CountOfTakeOverActions);
         TakeOverSuccess = conM.prepareStatement(CountOfTakeOverSuccess);
         SIMSwap = conM.prepareStatement(CountOfSimSwapActions);
         SIMSwapSuccess = conM.prepareStatement(CountOfSimSwapSuccess);
         ExecutionTimeSimSwap = conM.prepareStatement(SimSwapAvgExecution);
         ExecutionTimeChangeRP = conM.prepareStatement(ChangeRatePlanAvgExecution);
         ExecutionTimeTakeOver = conM.prepareStatement(TakeOverAvgExecution);
         monitorBillingFailure_wfx = conM.prepareStatement(monitorBillingFailureQuery_wfx);
         monitorBillingConFailure_wfx = conM.prepareStatement(monitorBillingConFailureQuery_wfx);
         startupStatusDay_wfx = conM.prepareStatement(startupStatusDayQuery_wfx);
         monitorPerformance_wfx = conM.prepareStatement(monitorPerformanceQuery_wfx);
         monitorTraffic_wfx = conM.prepareStatement(monitorTrafficQuery_wfx);
         monitorTraffic_M39_wfx = conM.prepareStatement(monitorTrafficQuery_M39_wfx);
         monitorTraffic_M40_wfx = conM.prepareStatement(monitorTrafficQuery_M40_wfx);
         monitorCorbaProblem = conM.prepareStatement(MonitorCORBASECURITYPROBLEM);
         monitorTrafficClos_wfx = conM.prepareStatement(monitorTrafficClosQuery_wfx);
         monitorBatchTrafficClos_wfx = conM.prepareStatement(monitorBatchTrafficClosQuery_wfx);
         monitorNumOfTransactions_wfx = conM.prepareStatement(monitorNumOfTransactionsQuery_wfx);
         monitorPaymentFailure_wfx = conM.prepareStatement(monitorPaymentFailureQuery_wfx);
         checkCores_wfx = conM.prepareStatement(checkCoresQuery_wfx);
         checkRVs_wfx = conM.prepareStatement(checkRVsQuery_wfx);
         dynamicMonitoringWF_wfx = conM.prepareStatement(dynamicMonitoringWFQuery_wfx);
         startupStatus_client_wfx = conM.prepareStatement(startupStatus_clientQuery_wfx);
         monitorAdapterOverallExc_wfx = conM.prepareStatement(monitorAdapterOverallExcQuery_wfx);
         monitroOfflineEngError_wfx = conM.prepareStatement(monitroOfflineEngErrorQuery_wfx);
         inconsistMon_wfx = conM.prepareStatement(inconsistMonQuery_wfx);
         processBusyMon_wfx = conM.prepareStatement(processBusyMonQuery_wfx);
         monitorCMSCIWriteFee_wfx = conM.prepareStatement(monitorCMSCIWriteFeeQuery_wfx);
         monitorCMSCIWriteCust_wfx = conM.prepareStatement(monitorCMSCIWriteCustQuery_wfx);
         monitorAdapter_wfx = conM.prepareStatement(monitorAdapterQuery_wfx);
         monitorBillSrv_wfx = conM.prepareStatement(monitorBillSrvQuery_wfx);
         monitorSystemUsers_wfx = conM.prepareStatement(monitorSystemUsersQuery_wfx);
         monitorNonSystemUsers_wfx = conM.prepareStatement(monitorNonSystemUsersQuery_wfx);
         getRunningBatchesCount30_wfx = conM.prepareStatement(getRunningBatchesCount30Query_wfx);
         getRunningBatchesCount5_wfx = conM.prepareStatement(getRunningBatchesCount5Query_wfx);
         monitorFinancialTransaction_wfx = conM.prepareStatement(monitorFinancialTransactionQuery_wfx);
         monitorKSAtrend = conM.prepareStatement(KSAmonitor);
         monitorOfflineRequests_wfx = conM.prepareStatement(monitorOfflineRequestsQuery_wfx);
         monitorOfflineHTTPRequests_wfx = conM.prepareStatement(monitorHTTPOfflineRequestsQuery_wfx);
         VisitorsRejection = conM.prepareStatement(monitorVisitorsRejectionQuery);
         monitorNotificationTable_OTA = conM.prepareStatement(monitorNotification_OTA);
         monitorOtaPendingJobs = conM.prepareStatement(monitorOtaPendingJobsQuery);
         monitorUsers = conM.prepareStatement(monitorUsersQuery);
         monitorRoaming_Rej = conM.prepareStatement(Roaming_Rej);
         monitorVisitors_Rej = conM.prepareStatement(Visitors_Rej);
         monitorTotal_Rej = conM.prepareStatement(Total_Rej);
         tapOut = conM.prepareStatement(tapOutQuery);
         tapIn = conM.prepareStatement(tapInQuery);
      } catch (SQLException var101) {
         System.err.println("we have a sql exception " + var101.toString());
         String message = "CRITICAL-We are facing connectivity problem with billing DB (" + var101.toString() + "), please check";
         sendSMSToSupport(message);
         System.out.println("After sending sms");
      } catch (Exception var102) {
      }

   }

   public static void prepareSQLAction2(Connection conM) {
      Calendar cal = Calendar.getInstance();
      SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
      String strDate = sdf.format(cal.getTime());
      String[] dateFormat = strDate.split("-");
      String year = dateFormat[2];
      String month = dateFormat[1];
      String day = dateFormat[0];
      System.out.println("Partition value : " + year + month + day);
      String rlhFreeunitQuery = "SELECT /*+ parallel(a 16) full(a) */ CUST_INFO_BILLCYCLE_GROUP RLH, ROUND( (SUM (NVL (FREE_CHARGE_AMOUNT, 0)) / SUM (NVL (RATED_FLAT_AMOUNT, 0))) * 100) FREE_UNIT_PERCENTAGE, count(1) COUNT FROM RTX_POST_CUR PARTITION (RTX_POST_CUR_" + month + day + ") a GROUP BY CUST_INFO_BILLCYCLE_GROUP ORDER BY 1";
      String rlhFreeunitCheckQuery = "SELECT /*+ parallel(a 16) full(a) */ count(1) COUNT FROM RTX_POST_CUR PARTITION (RTX_POST_CUR_" + month + day + ") a GROUP BY CUST_INFO_BILLCYCLE_GROUP ORDER BY 1";

      try {
         rlhFreeunit = conM.prepareStatement(rlhFreeunitQuery);
         rlhFreeunitCheck = conM.prepareStatement(rlhFreeunitCheckQuery);
      } catch (Exception var11) {
      }

   }

   public static void main(String[] str) {
   }

   public static Vector loadinput() {
      try {
         FileInputStream fstream = new FileInputStream("D:\\input.txt");
         DataInputStream in = new DataInputStream(fstream);
         BufferedReader br = new BufferedReader(new InputStreamReader(in));
         Vector allData = new Vector();

         String strLine;
         while((strLine = br.readLine()) != null) {
            allData.add(strLine);
         }

         return allData;
      } catch (Exception var5) {
         System.err.println("excption " + var5.toString());
         return null;
      }
   }

   public static Connection connCMSMONITOR() {
      String message;
      try {
         String user = "CMS_MONITOR";
         message = "CMS_MONITOR";
         String dbURL = "jdbc:oracle:thin:@bscs-scan:1528/BSCSPRD2";
         Class.forName("oracle.jdbc.driver.OracleDriver");
         Connection conCmsMon = DriverManager.getConnection(dbURL, user, message);
         conCmsMon.setAutoCommit(true);
         return conCmsMon;
      } catch (SQLException var4) {
         System.err.println("we have a sql exception " + var4.toString());
         message = "CRITICAL-We are facing connectivity problem with billing DB (" + var4.toString() + "), please check";
         sendSMSToSupport(message);
         System.err.println("After sending sms");
      } catch (Exception var5) {
         System.err.println("exception in setting connection " + var5.toString());
      }
      return null;
   }

   public static Connection intConnectionMailSender(String userName, String pass, ProActiveConfModel proModel) {
      try {
         String dbURL = "jdbc:oracle:thin:@bscs-scan:1528/BSCSPRD2";
         Class.forName("oracle.jdbc.driver.OracleDriver");
         Connection conn = DriverManager.getConnection(dbURL, userName, pass);
         conn.setAutoCommit(true);
         return conn;
      } catch (SQLException var7) {
         System.err.println("we have a sql exception " + var7.toString());
         DBProblemMailSender(var7, proModel);
         String message = "CRITICAL-We are facing connectivity problem with billing DB (" + var7.toString() + "), please check";
         sendSMSToSupport(message);
         System.err.println("After sending sms");
      } catch (Exception var8) {
         System.err.println("exception in setting connection " + var8.toString());
      }

      return null;
   }
   
   public static Connection intConnectionMailSenderDR(String userName, String pass, ProActiveConfModel proModel) {
	      try {
	    	 String dbURL = "jjdbc:oracle:thin:@10.72.68.44:1528:BSCSDR21";//jdbc:oracle:thin:@10.72.68.44:1528:BSCSDR21
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         Connection conn = DriverManager.getConnection(dbURL, userName, pass);
	         conn.setAutoCommit(true);
	         return conn;
	      } catch (SQLException var7) {
	         System.err.println("we have a sql exception " + var7.toString());
	         DBProblemMailSender(var7, proModel);
	         String message = "CRITICAL-We are facing connectivity problem with billing DB 10.72.68.44 (" + var7.toString() + "), please check";
	         sendSMSToSupport(message);
	         System.err.println("After sending sms");
	      } catch (Exception var8) {
	         System.err.println("exception in setting connection " + var8.toString());
	      }

	      return null;
	   }

   public static Connection connServEngDB() {
      String message;
      try {
         String user = "servengdb";
         message = "bscs2005";
         String dbURL = "jdbc:oracle:thin:@bscs-scan:1528/BSCSPRD2";
         Class.forName("oracle.jdbc.driver.OracleDriver");
         Connection conCmsMon = DriverManager.getConnection(dbURL, user, message);
         conCmsMon.setAutoCommit(true);
         return conCmsMon;
      } catch (SQLException var4) {
         System.err.println("we have a sql exception " + var4.toString());
         message = "CRITICAL-We are facing connectivity problem with billing DB (" + var4.toString() + "), please check";
         sendSMSToSupport(message);
         System.err.println("After sending sms");
      } catch (Exception var5) {
         System.err.println("exception in setting connection " + var5.toString());
      }

      return null;
   }

   public static Connection FamilyDBConnection() {
      try {
         String user = "FAMILYPLATFORM";
         String password = "FAMPLAT_321";
         String dbURL = "jdbc:oracle:thin:@10.230.91.124:1526:FMLYPRD";
         Class.forName("oracle.jdbc.driver.OracleDriver");
         Connection FamCon = DriverManager.getConnection(dbURL, user, password);
         FamCon.setAutoCommit(true);
         return FamCon;
      } catch (SQLException var4) {
         System.err.println("we have a sql exception dddddddddddddddd" + var4.toString());
      } catch (Exception var5) {
         System.err.println("exception in setting connection " + var5.toString());
      }

      return null;
   }

   public static Connection intCustomConnection(String userName, String pass, String dbURL, ProActiveConfModel proModel) {
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         Connection conn = DriverManager.getConnection(dbURL, userName, pass);
         conn.setAutoCommit(true);
         return conn;
      } catch (SQLException var7) {
         System.err.println("we have a sql exception " + var7.toString());
         DBProblemMailSender(var7, proModel);
         String message = "CRITICAL-We are facing connectivity problem with billing DB (" + var7.toString() + "), please check";
         sendSMSToSupport(message);
         System.err.println("After sending sms");
      } catch (Exception var8) {
         System.err.println("exception in setting connection " + var8.toString());
      }

      return null;
   }

   public static Connection intRtxConnection(String userName, String pass) {
      try {
         String dbURL = "jdbc:oracle:thin:@10.230.91.130:1521:RTXPRD21";
         Class.forName("oracle.jdbc.driver.OracleDriver");
         Connection conn = DriverManager.getConnection(dbURL, userName, pass);
         conn.setAutoCommit(true);
         return conn;
      } catch (SQLException var6) {
         System.err.println("we have a sql exception " + var6.toString());
         String message = "CRITICAL-We are facing connectivity problem with billing DB (" + var6.toString() + "), please check";
         sendSMSToSupport(message);
         System.err.println("After sending sms");
      } catch (Exception var7) {
         System.err.println("exception in setting connection " + var7.toString());
      }

      return null;
   }

   public static void DBProblemMailSender(SQLException sqlEXC, ProActiveConfModel proModel) {
      String mailContent = "Dears,\n CRITICAL-We are facing connectivity problem with billing DB (" + sqlEXC.toString() + "), \n\nplease check\n\n\nPlease call DB and Billing persion on-call URGENTLY\n\nServerity = RED !!!";
      System.out.println("DB connection probelm , mail will be sent");
      SendMailUtil sendMaile = new SendMailUtil();
      sendMaile.sendMail(mailContent, (String)null, "DB Connection problem", proModel.getMails());
   }

   public static Connection intConnection(String userName, String pass) {
      try {
         String dbURL = "jdbc:oracle:thin:@bscs-scan:1528/BSCSPRD2";
         Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
         Connection conn = DriverManager.getConnection(dbURL, userName, pass);
         conn.setAutoCommit(true);
         return conn;
      } catch (SQLException var6) {
         System.err.println("we have a sql exception " + var6.toString());
         String message = "CRITICAL-We are facing connectivity problem with billing DB (" + var6.toString() + "), please check";
         sendSMSToSupport(message);
         System.err.println("After sending sms");
      } catch (Exception var7) {
         System.err.println("exception in setting connection " + var7.toString());
      }

      return null;
   }

   public static Connection intCMSADAConnection(String userName, String pass) {
      try {
         String dbURL = "jdbc:oracle:thin:@bscs-scan:1528/BSCSPRD2";
         Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
         Connection conn = DriverManager.getConnection(dbURL, userName, pass);
         conn.setAutoCommit(true);
         return conn;
      } catch (SQLException var6) {
         System.err.println("we have a sql exception " + var6.toString());
         String message = "CRITICAL-We are facing connectivity problem with billing DB (" + var6.toString() + "), please check";
         sendSMSToSupport(message);
         System.err.println("After sending sms");
      } catch (Exception var7) {
         System.err.println("exception in setting connection " + var7.toString());
      }

      return null;
   }

   public static int checkDB_Locking(Connection con, int maxReached, ProActiveConfModel proModel) {
      try {
         System.out.println("max reached today is : " + maxReached);
         ResultSet rs = monitorDBLocking.executeQuery();
         int lockStatus = 0;

         String lockingData;
         for(lockingData = "lock Data\n"; rs.next(); ++lockStatus) {
            lockingData = lockingData + rs.getString("blocking_status") + "\n";
         }

         System.out.println("lock status: " + lockStatus);
         if (lockStatus >= 8) {
            int count_all = getWfxDailyCount(con);
            String mailContent = "Dears,\n please take care We have more than 15 DB locking, please restart ASSET CMS Adapter or contact online team\n\r" + lockingData + " BR,\n\r CMS Adaptor admin";
            System.out.println("locking found , mail will be sent");
            SendMailUtil sendMaile = new SendMailUtil();
            sendMaile.sendMail(mailContent, (String)null, "CMS Adapter Down", proModel.getMails());
            System.out.println("Main started");
            String message = "CRITICAL : We are facing DB locking (+8), please check urgently (Monitoring behavior under testing)";
            sendSMSToSupport(message);
            System.out.println("After sending sms");
         }

         con.commit();
      } catch (SQLException var10) {
         System.err.println("exception in locking : " + var10.toString());
      } catch (Exception var11) {
      }

      return maxReached;
   }

   public static int checkCMSAdapter_MonitorTabelspace(Connection con, int maxReached, ProActiveConfModel proModel) {
      if (proModel.getMonTabelSpace().equals("null")) {
         return maxReached;
      } else {
         try {
            System.out.println("max reached today is : " + maxReached);
            ResultSet rs = monitorTabelspaceStatus.executeQuery();

            while(rs.next()) {
               int countSpace = rs.getInt("PCT_FREE");
               System.out.println("Available space size " + countSpace);
               if (countSpace <= 10 && countSpace < maxReached) {
                  String mailContent = "Dears,\n CRITICAL - please take care Tabelspace is reaching a risky size (" + countSpace + " %) only available, please communicate to DBA's to check\n\r BR,\n\r CMS Adaptor admin";
                  System.out.println("failure found , mail will be sent");
                  maxReached = countSpace;
                  SendMailUtil sendMaile = new SendMailUtil();
                  sendMaile.sendMail(mailContent, (String)null, "CMS Adapter Tabelspace alert", proModel.getMails());
               }
            }

            con.commit();
         } catch (SQLException var7) {
            System.err.println("we have a sql exception " + var7.toString());
            String message = "CRITICAL-We are facing connectivity problem with billing DB (" + var7.toString() + "), please check";
            sendSMSToSupport(message);
            System.err.println("After sending sms");
         } catch (Exception var8) {
            System.out.println("Exception " + var8.toString());
         }

         return maxReached;
      }
   }
   
   public static void prepareSQLActionDR(Connection conM) {
	      Calendar cal = Calendar.getInstance();
	      SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	      String strDate = sdf.format(cal.getTime());
	      String[] dateFormat = strDate.split("-");
	      String year = dateFormat[2];
	      String month = dateFormat[1];
	      String day = dateFormat[0];
	      int dayInt = Integer.parseInt(dateFormat[0]) - 1;
	      System.out.println("Partition value : " + year + month + day);
	      System.out.println("embara77777=" + dayInt);
	      
	      String replicationStatusQuery = "SELECT CASE WHEN COUNT (1) > 10 THEN '0' ELSE '1' END REPLICATION_STATUS FROM GMD_REQUEST_HISTORY WHERE TS > (SYSDATE - (15 / (24 * 60)))";

	      try {
	         replicationStatus = conM.prepareStatement(replicationStatusQuery);
	      } catch (SQLException var101) {
	         System.err.println("we have a sql exception " + var101.toString());
	         String message = "CRITICAL-We are facing connectivity problem with billing DB 10.72.68.44 (" + var101.toString() + "), please check";
	         sendSMSToSupport(message);
	         System.out.println("After sending sms");
	      } catch (Exception var102) {
	      }

	   }
//SELECT CASE WHEN COUNT (1) > 10 THEN '0' ELSE '1' END "DR Replication Status" FROM GMD_REQUEST_HISTORY WHERE TS > (SYSDATE - (15 / (24 * 60)));
   
   public void replicationStatusGmd(Connection con, int i, ProActiveConfModel proModel) {
	      String billseqno;
	      try {
	         String message = "";
	         ResultSet rs = replicationStatus.executeQuery();

	         while(rs.next()) {
	        	String rep = rs.getString("REPLICATION_STATUS");
	        	if (rep == "1"){
	        		message = message + "GMD_REPLICATION_STATUS: "+rep+"\n"+"Please check urgently.";
		        	
		            sendSMSToSupport(message);
		            SendMailUtil sendMaile = new SendMailUtil();
		            sendMaile.sendMail(message, (String)null, "Actual Bch Monitor", proModel.getMails());
	        	}
	         }
	      } catch (SQLException var20) {
	         System.err.println("we have a sql exception " + var20.toString());
	         new SendMailUtil();
	         billseqno = "We are facing connectivity problem with billing DR (GMD_REPLICATION_STATUS) DB (" + var20.toString() + "), please check";
	         sendSMSToSupport(billseqno);
	         System.err.println("After sending sms");
	      } catch (Exception var21) {
	         System.err.println("Exception " + var21.toString());
	      }

	   }
   
   public void syniversTapIO(Connection con, int i, ProActiveConfModel proModel) {
	      
	      try {
	         String message_O = "";
	         ResultSet rs_O = tapOut.executeQuery();

	         while(rs_O.next()) {
	        	String rep = rs_O.getString("TAP_OUT");
	    		message_O = message_O + "TapOut trend today: "+rep+"\n";
	    		System.out.println("Syniverafter!!!");
	            sendSMSToSupport(message_O);
	         }
	         
	         String message_I = "";
	         ResultSet rs_I = tapIn.executeQuery();

	         while(rs_I.next()) {
	        	String rep = rs_I.getString("TAP_IN");
        		message_I = message_I + "TapIn trend today: "+rep+"\n";
	            sendSMSToSupport(message_I);
	         }
	      } catch (SQLException var20) {
	         System.err.println("we have a sql exception " + var20.toString());
	         new SendMailUtil();
	         System.err.println("After sending sms");
	      } catch (Exception var21) {
	         System.err.println("Exception " + var21.toString());
	      }

	   }
   
   public void FinancialTransactionFail(Connection con, int i, ProActiveConfModel proModel) {
	      LocalDate dt = LocalDate.now();
	      DateTimeFormatter formatterY = DateTimeFormatter.ofPattern("YYYY");
	      DateTimeFormatter formatterM = DateTimeFormatter.ofPattern("MM");
	      DateTimeFormatter formatterD = DateTimeFormatter.ofPattern("dd");
          String date = formatterY.format(dt).toString()+formatterM.format(dt).toString()+formatterD.format(dt).toString();
	   	  String FinancialTransactionFailCountQuey = "select count(*) AS COUNT from WORKFLOWX.vfe_cms_clients_log_adp  partition(vfe_cms_clients_log_"+date+") where flow_name='FinancialTransaction' and REPLY_MESSAGE like '%not connected to ORACLE%' and REQUEST_DATE >= (select sysdate-.007 from dual) order by request_date desc";
	      String FinancialTransactionFailMaxDateQuery = "select MAX(REQUEST_DATE) AS MAX_DATE from WORKFLOWX.vfe_cms_clients_log_adp  partition(vfe_cms_clients_log_"+date+") where flow_name='FinancialTransaction' and REPLY_MESSAGE like '%not connected to ORACLE%' and REQUEST_DATE >= (select sysdate-.007 from dual) order by request_date desc";
//	      String FinancialTransactionFailDetailsQuey = "select count(*) as COUNT,reply_code,max(request_date) as MAX_DATE, REPLY_MESSAGE from WORKFLOWX.vfe_cms_clients_log_adp  partition(vfe_cms_clients_log_"+date+") where flow_name='FinancialTransaction' and reply_code <>0 group by REPLY_MESSAGE,reply_code having count(*)>10";
	      try {
	    	 FinancialTransactionFailCount = con.prepareStatement(FinancialTransactionFailCountQuey);
	   	   	 FinancialTransactionFailMaxDate = con.prepareStatement(FinancialTransactionFailMaxDateQuery);
//	   	   	 FinancialTransactionFailDetails = con.prepareStatement(FinancialTransactionFailDetailsQuey);
	   	   	 
	         ResultSet rsCount = FinancialTransactionFailCount.executeQuery();
	         ResultSet rsMaxDate = FinancialTransactionFailMaxDate.executeQuery();
//	         ResultSet rsDetails = FinancialTransactionFailDetails.executeQuery();
	         String message = "";
	         String count = "";
	         int i1 = 0;
	         while(rsCount.next()) {
	        	String val = rsCount.getString("COUNT");
	        	if(i1 == 0){
	        		count = val;
	        	}
	        	
	    		message = message + "CRITICAL - CMS adapter facing problems - Financial Transaction Failed requests ("+val+") can not connect to ORACLE ,";
	         }
	         if (Integer.parseInt(count) > 10){
	        	 while(rsMaxDate.next()) {
			        	String val = rsMaxDate.getString("MAX_DATE");
			    		message = message + "and the last failed request in "+val+",please check\n";
			         }
		         sendSMSToSupport(message);
//		         System.out.println(count);
//		         if (Integer.parseInt(count) > 10){
//		        	 String message2 = "";
//		        	 System.out.println("Inside if!!!");
//		        	 while(rsDetails.next()) {
//		        		 System.out.println("Inside while!!!!!!!");
//		 	        	String count_ = rsDetails.getString("COUNT");
//		 	        	String replay = rsDetails.getString("REPLY_CODE");
//		 	        	String max_date = rsDetails.getString("MAX_DATE");
//		 	        	String reply_msg = rsDetails.getString("REPLY_MESSAGE");
//		 	        	
//		 	        	message2 = message2 +"COUNT:"+count_+"|| REPLY_CODE:"+replay
//		 	        			+"|| REPLY_MESSAGE:'"+reply_msg+"'\n";
//		 	         }
//		        	 System.out.println("Message 2 ###################");
//		        	 System.out.println(message2);
//		        	 sendSMSToSupport(message2);
//		         }
	         }
	        
	      } catch (SQLException var20) {
	         System.err.println("we have a sql exception " + var20.toString());
	         new SendMailUtil();
	         System.err.println("After sending sms");
	      } catch (Exception var21) {
	         System.err.println("Exception " + var21.toString());
	      }

	   }
   
   public void monitorActualBch(Connection con, int i, ProActiveConfModel proModel) {
      String billseqno;
      try {
         String message = "";
         ResultSet rs = monitorBchActual.executeQuery();

         while(rs.next()) {
            billseqno = rs.getString("BILLSEQNO");
            String billcycle = rs.getString("BILLCYCLE");
            String status = rs.getString("STATUS");
            String total = rs.getString("TOTAL");
            String bch = rs.getString("BCH");
            String lt = rs.getString("LT");
            String pe = rs.getString("PE");
            String doc = rs.getString("DOC");
            String conv = rs.getString("CONV");
            String zip = rs.getString("ZIP");
            String load = rs.getString("LOAD");
            String fail = rs.getString("FAIL");
            String v_status = status.equals("S") ? "finished" : (status.equals("I") ? "running" : "failed");
            message = message + "billseqno : " + billseqno + " of billcycle : " + billcycle + " status is " + v_status + "\nno. of customers is " + total + "\nsummary in percentage : \n{[BCH:" + bch + "],[LT:" + lt + "],[PE:" + pe + "],[DOC:" + doc + "],[CONV:" + conv + "],[ZIP:" + zip + "],[LOAD:" + load + "],[FAIL:" + fail + "]}";
            sendSMSToSupport(message);
            SendMailUtil sendMaile = new SendMailUtil();
            sendMaile.sendMail(message, (String)null, "Actual Bch Monitor", proModel.getMails());
         }
      } catch (SQLException var20) {
         System.err.println("we have a sql exception " + var20.toString());
         new SendMailUtil();
         billseqno = "CRITICAL-We are facing connectivity problem with billing DB (" + var20.toString() + "), please check";
         sendSMSToSupport(billseqno);
         System.err.println("After sending sms");
      } catch (Exception var21) {
         System.err.println("Exception " + var21.toString());
      }

   }

   public void monitorActualBchAmount(Connection con, int i, ProActiveConfModel proModel) {
      try {
         String message = "";
         String SumAmount = "";
         String SumAmount2 = "";
         ResultSet rs = monitorBchActualAmount.executeQuery();

         ResultSet rs2;
         for(rs2 = montiorLastCycleAmount.executeQuery(); rs.next(); SumAmount = rs.getString("amount")) {
         }

         while(rs2.next()) {
            SumAmount2 = rs2.getString("last_amount");
         }

         System.out.println("Revenue done @:" + new Date());
         if (SumAmount != null) {
            message = message + "The  revenue till now is " + SumAmount + " and revenune of the previous cycle was " + SumAmount2;
            sendSMSToSupport(message);
         }
      } catch (SQLException var9) {
         Logger.getLogger(CMSAdapterListener.class.getName()).log(Level.SEVERE, (String)null, var9);
      }

   }

   public void MonitorReporting(Connection con, int i, ProActiveConfModel proModel) {
      try {
         String month = "";
         String Seqno = "";
         String BC = "";
         String message = "";

         for(ResultSet rs = monitorBCReporting.executeQuery(); rs.next(); BC = rs.getString("BILLCYCLE")) {
            month = rs.getString("Month");
            Seqno = rs.getString("BILLSEQNO");
         }

         if (month != "") {
            message = "please check the reporting files of BC: " + BC + " ,Month: " + month + " Seqno: " + Seqno + " are still not loaded at DWH";
            sendSMSToSupport(message);
            SendMailUtil sendMaile = new SendMailUtil();
            sendMaile.sendMail(message, (String)null, "Actual BC Reporting", proModel.getMails());
         }
      } catch (SQLException var10) {
         Logger.getLogger(CMSAdapterListener.class.getName()).log(Level.SEVERE, (String)null, var10);
      }

   }

   public void MediationTableMonitoring(Connection con, int i, ProActiveConfModel proModel) {
      try {
         String count = "";
         String message = "";

         for(ResultSet rs = monitorKSAtrend.executeQuery(); rs.next(); count = rs.getString("count")) {
         }

         int result = Integer.parseInt(count);
         if (result < 100) {
            message = message + "KSA Requests till now is " + result + "Please check";
            sendSMSToSupport(message);
         }
      } catch (SQLException var8) {
         Logger.getLogger(CMSAdapterListener.class.getName()).log(Level.SEVERE, (String)null, var8);
      }

   }

   public Set<String> checkBatchArchivedJobs(Connection con, Set<String> archivedJobs, ProActiveConfModel proModel) {
      String message;
      try {
         ResultSet rs = monitorBatchArchivedJobs.executeQuery();
         message = "";
         HashSet toBeAddedJobs = new HashSet();

         while(rs.next()) {
            String job_id = rs.getString("JOB_ID");
            String simpoh_id = rs.getString("SIMPOH_ID");
            String sims_num = rs.getString("SIMS_NUM");
            if (!archivedJobs.contains(job_id)) {
               message = message + job_id + "\t\t" + simpoh_id + "\t\t\t" + sims_num + "\n";
               toBeAddedJobs.add(job_id);
            }
         }

         if (!message.isEmpty()) {
            archivedJobs.addAll(toBeAddedJobs);
            SendMailUtil sendMaile = new SendMailUtil();
            sendMaile.sendMail("JOB_ID\t\tSIMPOH_ID\t\tSIMS_NUM\n" + message, (String)null, "Batch Activiation Tool", proModel.getMails());
         }
      } catch (SQLException var10) {
         System.err.println("we have a sql exception " + var10.toString());
         message = "CRITICAL-We are facing connectivity problem with billing DB, please check";
         sendSMSToSupport(message);
         System.err.println("After sending sms");
         message = "CRITICAL-We are facing connectivity problem with billing DB (" + var10.toString() + "), please check";
         sendSMSToSupport(message);
         System.err.println("After sending sms");
      } catch (Exception var11) {
         System.err.println("Exception " + var11.toString());
      }

      return archivedJobs;
   }

   public void checkBatchFinishedJobs(Connection con, int monitortablespaceMaxReached, ProActiveConfModel proModel) {
      String message;
      try {
         ResultSet rs = monitorFinishedJobs.executeQuery();

         String job_id;
         String date;
         for(message = ""; rs.next(); message = message + "job id : " + job_id + " finished at " + date + " , please check\n") {
            job_id = rs.getString("JOB_ID");
            date = rs.getString("END_DATE");
         }

         if (!message.isEmpty()) {
            SendMailUtil sendMaile = new SendMailUtil();
            sendMaile.sendMail(message, (String)null, "Batch Activiation Tool", proModel.getMails());
         }
      } catch (SQLException var8) {
         System.err.println("we have a sql exception " + var8.toString());
         message = "CRITICAL-We are facing connectivity problem with billing DB, please check";
         sendSMSToSupport(message);
         System.err.println("After sending sms");
         message = "CRITICAL-We are facing connectivity problem with billing DB (" + var8.toString() + "), please check";
         sendSMSToSupport(message);
         System.err.println("After sending sms");
      } catch (Exception var9) {
         System.err.println("Exception " + var9.toString());
      }

   }

   public void checkCMSAdapter_MonitorGMD_Mike(Connection con, int monitortablespaceMaxReached, ProActiveConfModel proModel) {
      String message;
      try {
         ResultSet rs = monitorGMD.executeQuery();
         message = "";

         while(true) {
            int status;
            do {
               int unproc;
               do {
                  if (!rs.next()) {
                     if (!message.isEmpty()) {
                        sendSMSToSupportProvisioning(message + this.checkGmdModules());
                     }

                     return;
                  }

                  unproc = rs.getInt("UNPROC");
                  status = rs.getInt("STATUS");
               } while(unproc < 2000);

               message = message + "(" + unproc + ") requests on status (" + status + ")\n";
            } while(status != 4 && status != 11);

            message = message + "please check with provisioning team\n";
         }
      } catch (SQLException var8) {
         System.err.println("we have a sql exception " + var8.toString());
         message = "CRITICAL-We are facing connectivity problem with billing DB, please check";
         sendSMSToSupport(message);
         System.err.println("After sending sms");
         message = "CRITICAL-We are facing connectivity problem with billing DB (" + var8.toString() + "), please check";
         sendSMSToSupport(message);
         System.err.println("After sending sms");
      } catch (Exception var9) {
         System.err.println("Exception " + var9.toString());
      }

   }

   public void checkGMD_Prov(Connection con, int monitortablespaceMaxReached, ProActiveConfModel proModel) {
      String message;
      try {
         ResultSet rs = monitorGMD.executeQuery();
         message = "";

         while(true) {
            int unproc;
            int status;
            do {
               do {
                  if (!rs.next()) {
                     if (!message.isEmpty()) {
                    	 sendSMSToSupportProvisioning(message);
                     }

                     return;
                  }

                  unproc = rs.getInt("UNPROC");
                  status = rs.getInt("STATUS");
               } while(unproc < 2000);
            } while(status != 4 && status != 11 && status != 10);

            message = message + "(" + unproc + ") requests on status (" + status + ")\n";
            message = message + "please check \n";
         }
      } catch (SQLException var8) {
         System.err.println("we have a sql exception " + var8.toString());
         message = "CRITICAL-We are facing connectivity problem with billing DB, please check";
         sendSMSToSupport(message);
         System.err.println("After sending sms");
         message = "CRITICAL-We are facing connectivity problem with billing DB (" + var8.toString() + "), please check";
         sendSMSToSupport(message);
         System.err.println("After sending sms");
      } catch (Exception var9) {
         System.err.println("Exception " + var9.toString());
      }

   }

   public void checkMonitorGMD_Mike() {
      String message = this.checkGmdModules();
      if (message.contains("(0")) {
         sendSMSToSupport(message);
      }

   }

   public void readGmdMonitorLog() {
      ChannelExec execChannel = (ChannelExec)this.getChannel("bscs_adm", "bscsadm123", "10.230.91.91");
      String message = this.excuteCommand(execChannel, "cat ~/release/shipments/batch_latest/scripts/monitor_gmd_adv.log");
      this.excuteCommand(execChannel, "> ~/release/shipments/batch_latest/scripts/monitor_gmd_adv.log");
      System.out.println("logs of gmd monitor script : " + message + " at " + new Date());
      this.closeChannel(execChannel);
      if (!message.isEmpty()) {
         String[] var3 = message.split("-----------------------------------------------------------------");
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            String msg = var3[var5];
            if (msg.split("\n").length <= 10) {
               sendSMSToSupport(msg.trim());
            } else {
               String smsg = "";
               int count = 0;
               String[] var9 = msg.split("\n");
               int var10 = var9.length;

               for(int var11 = 0; var11 < var10; ++var11) {
                  String omsg = var9[var11];
                  if (!omsg.trim().isEmpty()) {
                     smsg = smsg + omsg.trim() + "\n";
                     ++count;
                     if (count >= 10) {
                        sendSMSToSupport(smsg);
                        smsg = "";
                        count = 0;
                     }
                  }
               }

               if (!smsg.isEmpty()) {
                  sendSMSToSupport(smsg);
               }
            }
         }
      }

   }

   public Connection checkDbConnection(Connection con, int i, ProActiveConfModel proModel) {
	  System.out.println(con.toString());
      String url1 = "jdbc:oracle:thin:@bscs-scan:1528/BSCSPRD2";
      String url2 = "jdbc:oracle:thin:@bscs-scan:1528/BSCSPRD2";
      boolean connected = true;

      try {
         checkDbNodes = con.prepareStatement("select sysdate from dual");
         ResultSet rs = checkDbNodes.executeQuery();

//         while(true) {
//        	 System.out.println("Flag!!");
//        	 
//            if (rs.next()) {
//               continue;
//            }
//         }
      } catch (SQLException var14) {
         connected = false;
         System.err.println("Exception " + var14.getMessage());
         sendSMSToSupport("Database Node disconnected, please check urgently\n" + var14.getMessage());
      } catch (Exception var15) {
         connected = false;
         System.err.println("Exception " + var15.toString());
         sendSMSToSupport("Database Node disconnected, please check urgently\n" + var15.getMessage());
      }

      Connection con1 = intCustomConnection("CMS_MONITOR", "CMS_MONITOR", url1, proModel);

      try {
         checkDbNodes = con1.prepareStatement("select sysdate from dual");
         ResultSet rs1 = checkDbNodes.executeQuery();

         while(true) {
            if (!rs1.next()) {
               if (!connected) {
                  prepareSQLAction(con1);
                  con = con1;
                  sendSMSToSupport("Database Node problem occured, shifting to " + url1);
                  connected = true;
               }
               break;
            }
         }
      } catch (SQLException var12) {
         connected = false;
         System.err.println("Exception " + var12.getMessage());
         sendSMSToSupport("Database Node " + url1.split("@|:")[4] + " disconnected, please check urgently\n" + var12.getMessage());
      } catch (Exception var13) {
         connected = false;
         System.err.println("Exception " + var13.toString());
         sendSMSToSupport("Database Node " + url1.split("@|:")[4] + " disconnected, please check urgently\n" + var13.getMessage());
      }

      Connection con2 = intCustomConnection("CMS_MONITOR", "CMS_MONITOR", url2, proModel);

      try {
         checkDbNodes = con2.prepareStatement("select sysdate from dual");
         ResultSet rs2 = checkDbNodes.executeQuery();

         while(true) {
            if (!rs2.next()) {
               if (!connected) {
                  prepareSQLAction(con2);
                  con = con2;
                  sendSMSToSupport("Database Node problem occured, shifting to " + url2);
                  connected = true;
               }
               break;
            }
         }
      } catch (SQLException var10) {
         connected = false;
         System.err.println("Exception " + var10.getMessage());
         sendSMSToSupport("Database Node " + url2.split("@|:")[4] + " disconnected, please check urgently\n" + var10.getMessage());
      } catch (Exception var11) {
         connected = false;
         System.err.println("Exception " + var11.toString());
         sendSMSToSupport("Database Node " + url2.split("@|:")[4] + " disconnected, please check urgently\n" + var11.getMessage());
      }

      return con;
   }

   public void checkRLH_Freeunits(Connection con, float threshold, ProActiveConfModel proModel) {
      List<String> rlhs = new ArrayList(Arrays.asList("1", "2", "4", "5", "6", "7", "8", "10", "11", "18", "19", "20", "21", "22", "23", "24", "25", "26", "33", "34", "39", "40", "41", "52", "53", "54", "55", "61", "62", "63", "64", "117", "118", "19", "120", "121", "122", "123", "124", "125"));
      ArrayList frlh = new ArrayList();

      String message;
      try {
         ResultSet rs = rlhFreeunit.executeQuery();

         String rlh;
         for(message = ""; rs.next(); frlh.add(rlh)) {
            rlh = rs.getString("RLH");
            float freeunit = rs.getFloat("FREE_UNIT_PERCENTAGE");
            int rCount = rs.getInt("COUNT");
            if (freeunit < threshold) {
               message = message + "RLH : " + rlh + " FUP : " + freeunit + "% (" + rCount + ")\n";
            }
         }

         rlhs.removeAll(frlh);
         if (!rlhs.isEmpty()) {
            message = message + "RLHs : (";
            Iterator var14 = rlhs.iterator();

            while(true) {
               if (!var14.hasNext()) {
                  message = message + ") are down";
                  break;
               }

                rlh = (String)var14.next();
               ResultSet rs2 = rlhFreeunitCheck.executeQuery();

               int count;
               for(count = 0; rs2.next(); count = rs2.getInt("COUNT")) {
               }

               message = message + rlh + ":" + count + ",";
            }
         }

         if (!message.isEmpty()) {
            sendSMSToSupport(message);
            SendMailUtil sendMail = new SendMailUtil();
            sendMail.sendMail(message, (String)null, "RLH Status Report", proModel.getMails());
         }
      } catch (SQLException var12) {
         System.err.println("we have a sql exception " + var12.toString());
         message = "CRITICAL-We are facing connectivity problem with billing DB, please check";
         sendSMSToSupport(message);
         System.err.println("After sending sms");
         message = "CRITICAL-We are facing connectivity problem with billing DB (" + var12.toString() + "), please check";
         sendSMSToSupport(message);
         System.err.println("After sending sms");
      } catch (Exception var13) {
         System.err.println("Exception " + var13.toString());
      }

   }

   public void monitorCallSMSZone(Connection con, float threshold, ProActiveConfModel proModel) {
      try {
         String message = "Voice Calls\nCOUNT\tVOLUME\tAMOUNT\n";

         String total;
         String sumVolume;
         for(ResultSet rs1 = voicePs.executeQuery(); rs1.next(); message = message + total + "\t" + total + "\t" + sumVolume + "\n") {
            total = rs1.getString("TOTAL");
            total = rs1.getString("SUM_VOLUME");
            sumVolume = rs1.getString("SUM_AMOUNT");
         }

         if (!message.isEmpty()) {
            sendSMSToSupport(message);
         }

         message = "Sms Messages\nCOUNT\tVOLUME\tAMOUNT\n";

         String sumAmount;
         for(ResultSet rs2 = smsPs.executeQuery(); rs2.next(); message = message + total + "\t" + sumVolume + "\t" + sumAmount + "\n") {
            total = rs2.getString("TOTAL");
            sumVolume = rs2.getString("SUM_VOLUME");
            sumAmount = rs2.getString("SUM_AMOUNT");
         }

         if (!message.isEmpty()) {
            sendSMSToSupport(message);
         }
      } catch (SQLException var10) {
         System.err.println("we have a sql exception " + var10.toString());
         String message = "CRITICAL-We are facing connectivity problem with billing DB, please check";
         sendSMSToSupport(message);
         System.err.println("After sending sms");
         message = "CRITICAL-We are facing connectivity problem with billing DB (" + var10.toString() + "), please check";
         sendSMSToSupport(message);
         System.err.println("After sending sms");
      } catch (Exception var11) {
         System.err.println("Exception " + var11.toString());
      }

   }

   public static String getCustomerCareDownCores(String AvailableCores) {
      String downCores = "";

      int i;
      for(i = 1; i < 6; ++i) {
         if (AvailableCores.indexOf("," + i + ",") == -1) {
            downCores = downCores + i + ",";
         }
      }

      for(i = 19; i < 21; ++i) {
         if (AvailableCores.indexOf("," + i + ",") == -1) {
            downCores = downCores + i + ",";
         }
      }

      for(i = 22; i < 27; ++i) {
         if (AvailableCores.indexOf("," + i + ",") == -1) {
            downCores = downCores + i + ",";
         }
      }

      return downCores;
   }

   public static String getBatchDownCores(String AvailableCores) {
      String downCores = "";

      for(int i = 14; i < 18; ++i) {
         if (AvailableCores.indexOf("," + i + ",") == -1) {
            downCores = downCores + i + ",";
         }
      }

      return downCores;
   }

   public static int checkCMSAdapter_MonitorProceduresStatus(Connection con, int maxReached, ProActiveConfModel proModel) {
      if (proModel.getMonTraffic().equals("null")) {
         return maxReached;
      } else {
         try {
            System.out.println("Check Procedures status");
            ResultSet rs = monitorProceduresVal.executeQuery();
            Vector availableObjects = new Vector();
            String ObjectsWhichHaveProblem = "";

            while(rs.next()) {
               String objName = rs.getString("OBJECT_NAME");
               System.out.println("Current core is :  " + objName);
               ObjectsWhichHaveProblem = ObjectsWhichHaveProblem + objName + ",";
               availableObjects.add(objName);
            }

            if (availableObjects.size() != 0) {
               System.out.println("some Objects are down");
               Date now = new Date();
               int hoursNow = now.getHours();
               String mailContent = "Dears,\n please take care Some procedures are invalid (" + ObjectsWhichHaveProblem + "), please validate\n\r BR,\n\r CMS Adaptor admin";
               SendMailUtil sendMaile = new SendMailUtil();
               sendMaile.sendMail(mailContent, (String)null, "CMS Adapter Objects Alert", proModel.getMails());
               System.out.println("Main started");
               String message = "CRITICAL:Please check urgenlty some procedures are invalid : " + ObjectsWhichHaveProblem;
               sendSMSToSupport(message);
               System.out.println("After sending sms");
            }

            con.commit();
         } catch (SQLException var11) {
            System.out.println("we have a sql exception " + var11.toString());
            String message = "CRITICAL-We are facing connectivity problem with billing DB, please check urgently";
            sendSMSToSupport(message);
            System.out.println("After sending sms");
         } catch (Exception var12) {
            System.out.println("Exception " + var12.toString());
         }

         return maxReached;
      }
   }

   public static int checkCMSAdapter_MonitorBOTAPreToEasy(Connection con, int maxReached, ProActiveConfModel proModel) {
      String message;
      try {
         Connection conNew = intCMSADAConnection("cmsada", "cmsada9");
         message = "update ota_job_contracts_arch set status_flag = 14, error_message = 'Failed in takeover' where job_id = ? and contract_id = ?";
         monitorUpdatePreToEasyAction = conNew.prepareStatement(message);
         System.out.println("Check B-OTA status");
         ResultSet rs = monitorPreToEasyBatches.executeQuery();
         Vector availableJobs = new Vector();

         int i;
         while(rs.next()) {
            i = rs.getInt("job_id");
            System.out.println("Job id retrieved :  " + i);
            availableJobs.add(i);
         }

         System.out.println("will update job status");

         for(i = 0; i < availableJobs.size(); ++i) {
            int jobID = Integer.parseInt(availableJobs.get(i).toString());
            System.out.println("will start getting contracts rate plans for job : " + jobID + ";");
            String checkNotConvertedPreToEasy = "SELECT DISTINCT SUBSTR (a.dn_num, 3, LENGTH(a.dn_num)) MSISDN, d.des RATEPLAN FROM directory_number a, contr_services_cap b, contract_all c, rateplan d WHERE a.dn_id          = b.dn_id AND c.tmcode           = d.tmcode AND b.cs_deactiv_date IS NULL AND b.co_id            = c.co_id AND a.dn_num          IN  ( SELECT 20 || contract_id FROM ota_job_contracts_arch WHERE job_id = " + jobID + ") AND lower (d.des) not like '%easy%'";
            Statement stmt = con.createStatement();
            ResultSet rs2 = stmt.executeQuery(checkNotConvertedPreToEasy);

            while(rs2.next()) {
               String msisdnVal = rs2.getString("MSISDN");
               System.out.println("current msisdn = " + msisdnVal);
               System.out.println("will start updating");
               monitorUpdatePreToEasyAction.setInt(1, jobID);
               monitorUpdatePreToEasyAction.setString(2, msisdnVal);
               monitorUpdatePreToEasyAction.execute();
               conNew.commit();
               System.out.println("after update");
            }

            monitorBOTANotificationMails.setInt(1, jobID);
            ResultSet rs3 = monitorBOTANotificationMails.executeQuery();

            String notificationMails;
            String mailVal;
            for(notificationMails = "mohamed.elsweesy@localhost.com"; rs3.next(); notificationMails = notificationMails + ";" + mailVal) {
               mailVal = rs3.getString("notification_destination");
               System.out.println("Mail to send job notification is : " + mailVal);
            }

            mailVal = "Dears,\n Please be informed that failure status for job with ID " + jobID + " is now updated please check B-OTA report\n\r BR,\n\r B-OTA admin";
            SendMailUtil sendMaile = new SendMailUtil();
            sendMaile.sendMail(mailVal, (String)null, "B-OTA notification", notificationMails);
         }

         conNew.close();
      } catch (SQLException var16) {
         System.out.println("we have a sql exception " + var16.toString());
         message = "OTA jobs notifications have DB issue, please check";
         sendSMSToSupport(message);
         System.out.println("After sending sms");
      } catch (Exception var17) {
         System.out.println("Exception " + var17.toString());
      }

      return 0;
   }

   public static int checkCMSAdapter_MonitorGMDStatus(Connection con, int maxReached, ProActiveConfModel proModel) {
      if (proModel.getMonTraffic().equals("null")) {
         return maxReached;
      } else {
         try {
            System.out.println("Check RVs status");
            ResultSet rs = monitorGMDVal.executeQuery();
            ResultSet rsBilling = monitorGMDBillingVal.executeQuery();
            new Vector();
            String mailContent = "Dears,\n please take care not all RVs are handling requests, please validate\n\r BR,\n\r CMS Adaptor admin";
            String message = "Take care not all RVs handling requests in last 5 minutes, please check";
            boolean var8 = false;

            int statusValue;
            while(rs.next()) {
               statusValue = rs.getInt("status");
               int sumValue = rs.getInt("SUMOFPEND");
               System.out.println("Current status is :  " + statusValue);
               SendMailUtil sendMaile;
               if (statusValue == 2 && sumValue > 400) {
                  mailContent = "Dears,\n please take care GMD have " + sumValue + " pending requests, please validate\n\r BR,\n\r CMS Adaptor admin";
                  message = "Take care we have " + sumValue + " pending request on MDSRRTAB in last 5 minutes, please check on billing (status 2) ";
                  sendMaile = new SendMailUtil();
                  sendMaile.sendMail(mailContent, (String)null, "CMS Adapter GMD Alert", proModel.getMails());
                  System.out.println("Main started");
                  new SendMailUtil();
                  sendSMSToSupport(message);
                  System.out.println("After sending sms");
               }

               if (statusValue == 4 && sumValue > 200) {
                  mailContent = "Dears,\n please take care GMD have " + sumValue + " failed requests, please validate\n\r BR,\n\r CMS Adaptor admin";
                  message = "Take care we have " + sumValue + " failed/Accumulated  request on MDSRRTAB in last 5 minutes, please check with provisioning team(status 4) ";
                  sendMaile = new SendMailUtil();
                  sendMaile.sendMail(mailContent, (String)null, "CMS Adapter GMD Alert", proModel.getMails());
                  sendSMSToSupportProvisioning(message);
                  System.out.println("After sending sms");
               }

               if (statusValue == 14 && sumValue > 200) {
                  mailContent = "Dears,\n please take care GMD have " + sumValue + " Pending requests (status 14 ), please validate\n\r BR,\n\r CMS Adaptor admin";
                  message = "Take care we have " + sumValue + " Pending requests (status 14) on MDSRRTAB in last 5 minutes, please check on billing";
                  sendMaile = new SendMailUtil();
                  sendMaile.sendMail(mailContent, (String)null, "CMS Adapter GMD Alert", proModel.getMails());
                  sendSMSToSupport(message);
                  System.out.println("After sending sms");
               }
            }

            while(rsBilling.next()) {
               statusValue = rsBilling.getInt("SUMPENDBILLING");
               if (statusValue > 500) {
                  mailContent = "Dears,\n please take care GMD have " + statusValue + " Pending request (status 1,14,16,11 ), please validate\n\r BR,\n\r CMS Adaptor admin";
                  message = "Take care we have " + statusValue + " Pending request (status 1,14,16,11) on MDSRRTAB in last 5 minutes, please check on billing";
                  SendMailUtil sendMaile = new SendMailUtil();
                  sendMaile.sendMail(mailContent, (String)null, "CMS Adapter GMD Alert", proModel.getMails());
                  if (statusValue > 1500) {
                     sendSMSToSupport(message);
                     System.out.println("After sending sms");
                  }
               }
            }

            con.commit();
         } catch (SQLException var13) {
            System.out.println("we have a sql exception " + var13.toString());
            String message = "CRITICAL-We are facing connectivity problem with billing DB, please check";
            sendSMSToSupport(message);
            System.out.println("After sending sms");
         } catch (Exception var14) {
            System.out.println("Exception " + var14.toString());
         }

         return maxReached;
      }
   }

   public static int checkCMSAdapter_runDailyReport(Connection con, int maxReached) {
      try {
         System.out.println("max reached today is : " + maxReached);
         ResultSet rs = monitorTabelspaceStatus.executeQuery();

         while(rs.next()) {
            int countSpace = rs.getInt("PCT_FREE");
            System.out.println("Available space size " + countSpace);
            if (countSpace <= 20 && countSpace < maxReached) {
               String mailContent = "Dears,\n please take care Tabelspace is reaching a risky size (" + countSpace + " %) only available, please communicate to DBA's to check\n\r BR,\n\r CMS Adaptor admin";
               System.out.println("failure found , mail will be sent");
               maxReached = countSpace;
               SendMailUtil sendMaile = new SendMailUtil();
               sendMaile.sendMail(mailContent, (String)null, "CMS Adapter Tabelspace alert", "");
            }
         }

         con.commit();
      } catch (SQLException var6) {
         System.out.println("we have a sql exception " + var6.toString());
         String message = "CRITICAL-We are facing connectivity problem with billing DB, please check";
         sendSMSToSupport(message);
         System.out.println("After sending sms");
      } catch (Exception var7) {
         System.out.println("Exception " + var7.toString());
      }

      return maxReached;
   }

   public static int GMDTempFix(Connection con, int maxReached) {
      String retriedRequests;
      try {
         System.out.println("max reached today is : " + maxReached);
         ResultSet rs = GMDIssueInquiry.executeQuery();
         retriedRequests = "";

         for(byte commitCounter = 0; rs.next(); Thread.sleep(5000L)) {
            int request_id = rs.getInt("request");
            System.out.println("Available space size " + request_id);
            retriedRequests = retriedRequests + request_id + ",";
            GMDIssueUpdate.setInt(1, request_id);
            GMDIssueInquiry.executeUpdate();
            if (commitCounter >= 100) {
               con.commit();
               commitCounter = 0;
            }
         }

         String mailContent = "Dears,\n please find the following updated requests :\n\r " + retriedRequests + "\n\r BR,\n\r CMS Adaptor admin";
         System.out.println("failure found , mail will be sent");
         SendMailUtil sendMaile = new SendMailUtil();
         sendMaile.sendMail(mailContent, (String)null, "CMS Adapter Tabelspace alert", "");
         con.commit();
      } catch (SQLException var7) {
         System.out.println("we have a sql exception " + var7.toString());
         retriedRequests = "CRITICAL-We are facing connectivity problem with billing DB, please check";
         sendSMSToSupport(retriedRequests);
         System.out.println("After sending sms");
         retriedRequests = "CRITICAL-We are facing connectivity problem with billing DB (" + var7.toString() + "), please check";
         sendSMSToSupport(retriedRequests);
         System.out.println("After sending sms");
      } catch (Exception var8) {
         System.out.println("Exception " + var8.toString());
      }

      return maxReached;
   }

   public static int duplicatePaymentsCheck(Connection con, int maxReached, ProActiveConfModel proModel) {
      try {
         System.out.println("Will check for duplicate payments");
         String duplicateONLINE = "";
         String duplicateONOFF = "";
         String mailToCollectionTeam = "Please validate then remove duplicate payment for today : \n\n ";
         int duplicateOnline_flag = 0;
         boolean duplicateOnOFF = false;
         duplicateONLINE = "Customer_id  ,CACHKNUM  ,count \n";
         ResultSet rsOnline = monitorDuplicateOnlinePayments.executeQuery();
         System.out.println("After Duplicate payments query");

         String mailRecepts;
         String custCode;
         while(rsOnline.next()) {
            Long customerId = rsOnline.getLong("customer_id");
            mailRecepts = rsOnline.getString("CACHKNUM");
            duplicateONLINE = duplicateONLINE + "  " + customerId + " ,   " + mailRecepts + " ," + rsOnline.getLong("SUMVAL") + "\n";
            ++duplicateOnline_flag;
            getPaymentMoneyAndCustomer.setLong(1, customerId);
            getPaymentMoneyAndCustomer.setString(2, mailRecepts);

            Float CACHKAMT_PAY;
            String cstType;
            for(ResultSet rs = getPaymentMoneyAndCustomer.executeQuery(); rs.next(); mailToCollectionTeam = mailToCollectionTeam + "Billing account : " + custCode + "  Amount paid:  " + CACHKAMT_PAY + "  customer type:   " + cstType + "  \n") {
               CACHKAMT_PAY = rs.getFloat("CACHKAMT_PAY");
               custCode = rs.getString("CUSTCODE");
               String billCycle = rs.getString("BILLCYCLE");
               cstType = "";
               if (!"01".equals(billCycle) && !"02".equals(billCycle) && !"04".equals(billCycle)) {
                  if ("07".equals(billCycle) || "11".equals(billCycle) || "09".equals(billCycle) || "25".equals(billCycle)) {
                     cstType = "Corporate ";
                  }
               } else {
                  cstType = "Consumer ";
               }
            }
         }

         String mailContent;
         if (duplicateOnline_flag > 0) {
            mailContent = "Dears,\n Please find the following Duplicate payments for yesterday :\n\r " + duplicateONLINE + "\n\r BR,\n\r CMS Adaptor admin";
            System.out.println("Duplicates found , mail will be sent");
            mailRecepts = proModel.getMails().replaceAll("TechIT-DCOperations@voda.com;", "");
            SendMailUtil sendMaile = new SendMailUtil();
            sendMaile.sendMail(mailContent, (String)null, "Proactive - Payment duplicates", mailRecepts);
            con.commit();
            String message = "Payments : We have  duplicate online payments (" + duplicateOnline_flag + ") in yesterday review, Please chcek your mail and make sure email was sent to Collection teams";
            sendSMSToSupport(message);
            System.out.println("After sending sms");
            System.out.println("Duplicates found , mail will be sent to Collection teams");
            custCode = "cccollectionsupportteam@voda.com;Enterprise.CreditControl@vodafone.com;techit-rm-billing-support@voda.com";
            sendMaile.sendMail(mailToCollectionTeam, (String)null, "Payment duplicates ", custCode);
            System.out.println("Mail should be sent to Collection teams...");
         } else {
            mailContent = "Payments (New) :No Duplicates found in yesterday check";
            sendSMSToSupport(mailContent);
            System.out.println("After sending sms");
            System.out.println("SMS sent");
         }
      } catch (SQLException var16) {
         System.out.println("we have a sql exception " + var16.toString());
         sendDevSMS(var16.toString());
      } catch (Exception var17) {
         System.out.println("Exception " + var17.toString());
         sendDevSMS(var17.toString());
      }

      return maxReached;
   }

   public void Family(Connection FamCon, int i, ProActiveConfModel proModel) {
      try {
         String message = "";
         int Countaf = 0;
         int Countpf = 0;
         int Countpm = 0;
         int Countam = 0;
         int countAll = 0;
         int countf = 0;
         Date now = new Date();
         int hoursNow = now.getHours();
         ChannelExec execChannel = (ChannelExec)this.getChannel("family", "family", "10.230.91.150");
         String sizePercent = this.excuteCommand(execChannel, "df -h / | grep / | tr -s ' ' | cut -d ' ' -f5");
         this.closeChannel(execChannel);
         ChannelExec execChannel2 = (ChannelExec)this.getChannel("family", "family", "10.230.91.150");
         String sizePercent2 = this.excuteCommand(execChannel2, "df -h /weblogic | grep /weblogic | tr -s ' ' | cut -d ' ' -f5");
         this.closeChannel(execChannel2);
         ChannelExec execChannel3 = (ChannelExec)this.getChannel("family", "family", "10.230.91.150");
         String sizePercent3 = this.excuteCommand(execChannel3, "df -h /orasrc12c | grep /orasrc12c | tr -s ' ' | cut -d ' ' -f5");
         this.closeChannel(execChannel3);
         ResultSet rs = ActiveFamilies.executeQuery();
         ResultSet rs2 = PendingFamilies.executeQuery();
         ResultSet rs3 = ActiveMembers.executeQuery();
         ResultSet rs4 = PendingMembers.executeQuery();
         ResultSet rs5 = FamilySMSStatus.executeQuery();

         ResultSet rs6;
         for(rs6 = SMSQueue.executeQuery(); rs.next(); Countaf = rs.getInt("a_f")) {
         }

         while(rs2.next()) {
            Countpf = rs2.getInt("p_f");
         }

         while(rs3.next()) {
            Countam = rs3.getInt("a_m");
         }

         while(rs4.next()) {
            Countpm = rs4.getInt("p_m");
         }

         while(rs5.next()) {
            countAll = rs5.getInt("c");
         }

         while(rs6.next()) {
            countf = rs6.getInt("c");
         }

         PendingMembers.close();
         ActiveFamilies.close();
         PendingFamilies.close();
         SMSQueue.close();
         FamilySMSStatus.close();
         ActiveMembers.close();
         message = "Flex Family Report:\n\rcount of active families is: " + Countaf + "\rcount of Pending families is: " + Countpf + "\rcount of active members is: " + Countam + "\r count of Pending members is:" + Countpm + "\n\rthe file system of logs is:" + sizePercent + "\n\rthe file system of Weblogic is:" + sizePercent2 + "\n\rthe file system of DB is:" + sizePercent3 + "\n\rCount of Pending SMSs: " + countf + "\n\rCount of failed SMSs:" + countAll;
         if (hoursNow == 22) {
            message = "Flex Family counts:\n\rActive families : " + Countaf + "\rPending families : " + Countpf + "\rActive members : " + Countam + "\rPending members :" + Countpm;
            sendSMSToSupport(message);
         }

         SendMailUtil sendMaile = new SendMailUtil();
         System.out.println("Family");
         sendMaile.sendWfxMail(message, (String)null, "Family Transactions", "techit-rm-billing-support@voda.com;ahmed.amr-samy@localhost.com;zaher.tarek-zaher@localhost.com");
      } catch (SQLException var26) {
         System.err.println((new StringBuilder()).append("we have a sql exception  "));
         System.err.println("we have a sql exception " + var26.toString());
      } catch (Exception var27) {
         System.out.println("sherif ---------------------> printing exception");
         var27.printStackTrace();
         System.out.println("sherif ---------------------> exception printed" + var27.toString());
      }

   }

   public void RedFamily(Connection FamilyCon, int i, ProActiveConfModel proModel) {
      try {
         String message = "";
         int Countaf = 0;
         int Countpf = 0;
         int Countpm = 0;
         int Countam = 0;
         ResultSet rs = ActiveFamilies.executeQuery();
         ResultSet rs2 = PendingFamilies.executeQuery();
         ResultSet rs3 = ActiveMembers.executeQuery();

         ResultSet rs4;
         for(rs4 = PendingMembers.executeQuery(); rs.next(); Countaf = rs.getInt("a_f")) {
         }

         while(rs2.next()) {
            Countpf = rs2.getInt("p_f");
         }

         while(rs3.next()) {
            Countam = rs3.getInt("a_m");
         }

         while(rs4.next()) {
            Countpm = rs4.getInt("p_m");
         }

         PendingRedMembers.close();
         ActiveRedFamilies.close();
         PendingRedFamilies.close();
         ActiveRedMembers.close();
         message = "Red Family counts:\n\rActive families : " + Countaf + "\rPending families : " + Countpf + "\rActive members : " + Countam + "\rPending members :" + Countpm;
         sendSMSToSupport(message);
      } catch (Exception var13) {
         System.out.println("sherif ---------------------> printing exception");
         var13.printStackTrace();
         System.out.println("sherif ---------------------> exception printed" + var13.toString());
      }

   }

   public void DMH(Connection FamCon, int i, ProActiveConfModel proModel) {
      try {
         String message = "";
         ChannelExec execChannel = (ChannelExec)this.getChannel("bscs_adm", "bscsadm123", "10.230.91.91");
         String sizePercent = this.excuteCommand(execChannel, "dmh -q 7 | awk '{sum+=$5} END {print sum}'");
         this.closeChannel(execChannel);
         message = "DMH" + sizePercent;
         sendSMSToSupport(message);
         System.out.println("Family");
      } catch (Exception var7) {
         System.out.println("sherif ---------------------> printing exception");
         var7.printStackTrace();
         System.out.println("sherif ---------------------> exception printed" + var7.toString());
      }

   }

   public static int duplicatePaymentOfflineCheck(Connection con, int maxReached, ProActiveConfModel proModel) {
      try {
         System.out.println("Will check for duplicate payments");
         String duplicateONLINE = "";
         String duplicateONOFF = "";
         int duplicateOnline = 0;
         int duplicateOnOFF_flag = 0;
         duplicateONLINE = "Customer_id,cachkamt,Date \n";

         for(ResultSet rsOnline = monitorDuplicateOffOnPayments.executeQuery(); rsOnline.next(); ++duplicateOnOFF_flag) {
            duplicateONLINE = duplicateONLINE + rsOnline.getLong("customer_id") + "," + rsOnline.getLong("CACHKAMT_GL") + "," + rsOnline.getDate("CACHKDATE") + "\n";
         }

         if (duplicateOnOFF_flag > 0) {
            String mailContent = "Dears,\n Please find the following Duplicate offline payments for yesterday :\n\r " + duplicateONLINE + "\n\r BR,\n\r CMS Adaptor admin";
            String mailRecepts = proModel.getMails().replaceAll("TechIT-DCOperations@voda.com;", "");
            System.out.println("Duplicates found , mail will be sent");
            SendMailUtil sendMaile = new SendMailUtil();
            sendMaile.sendMail(mailContent, (String)null, "Proactive - Payment Offline duplicates", mailRecepts);
            con.commit();
            String message = "Payments : We have duplicate online/Offline payments (" + duplicateOnOFF_flag + ")  in yesterday review, Please chcek your mail (new)";
            sendSMSToSupport(message);
            System.out.println("After sending sms");
            System.out.println("SMS sent");
         }
      } catch (SQLException var12) {
         System.out.println("we have a sql exception " + var12.toString());
      } catch (Exception var13) {
         System.out.println("Exception " + var13.toString());
      }

      return maxReached;
   }

   public static Set MonitorOTA_ScheduleJob_Start(Connection con, int maxReached, Set<String> OtaJobSet) {
      try {
         System.out.println("Will monitor in B-OTA schedule job start");
         ResultSet monitorSceduleJobs = monitorOTAScheduledJobs.executeQuery();
         boolean SMSToSend = false;

         while(monitorSceduleJobs.next()) {
            String jobName = monitorSceduleJobs.getString("DAEMON_JOB_NAME");
            String startTime = monitorSceduleJobs.getString("START_TIME");
            System.out.println("Job started : " + jobName);
            if (OtaJobSet.contains(jobName)) {
               System.out.println("sent before");
               SMSToSend = true;
            }

            if (!SMSToSend) {
               System.out.println("net sent before,will send");
               String message = "B-OTA : Daemon Job (" + jobName + ")  Started at (" + startTime + ") successfully ";
               System.out.println("send sms of OTA Jobs at " + new Date() + " : " + message);
               sendSMSToSupport(message);
               System.out.println("After sending sms");
               System.out.println("SMS sent");
               OtaJobSet.add(jobName);
            }
         }
      } catch (SQLException var8) {
         System.out.println("we have a sql exception " + var8.toString());
      } catch (Exception var9) {
         System.out.println("Exception " + var9.toString());
      }

      return OtaJobSet;
   }

   public static Set MonitorOTA_ScheduleJob_Completed(Connection con, int maxReached, Set OtaJobSet) {
      try {
         System.out.println("Will monitor in B-OTA schedule job start");
         ResultSet monitorSceduleJobs = monitorOTAScheduledJobCompleted.executeQuery();
         boolean SMSToSend = false;

         while(true) {
            String jobName;
            do {
               String status;
               do {
                  if (!monitorSceduleJobs.next()) {
                     return OtaJobSet;
                  }

                  jobName = monitorSceduleJobs.getString("DAEMON_JOB_NAME");
                  status = monitorSceduleJobs.getString("LOOKP_NAME");
                  String endTime = monitorSceduleJobs.getString("END_TIME");
               } while(!status.equals("Completed") && !status.equals("Completed with errors"));

               System.out.println("Job started : " + jobName);
               if (OtaJobSet.contains(jobName)) {
                  System.out.println("sent before");
                  SMSToSend = true;
               }
            } while(SMSToSend);

            System.out.println("Not sent before,will send");
            OtaJobSet.add(jobName);
            ResultSet rsStatus = monitorOTAScheduledJobStatus.executeQuery();

            while(rsStatus.next()) {
               String jobName_S = rsStatus.getString("DAEMON_JOB_NAME");
               String status_S = rsStatus.getString("LOOKP_NAME");
               int total_records = rsStatus.getInt("TOTAL_RECORDS");
               int processed_records = rsStatus.getInt("PROCESSED_RECORDS");
               int success_records = rsStatus.getInt("SUCCESSFUL_RECORDS");
               int failed_records = rsStatus.getInt("FAILED_RECORDS");
               String startTime = rsStatus.getString("START_TIME");
               String endTime1 = rsStatus.getString("END_TIME");
               String message_completed = "B-OTA : Daemon Job Report for (" + jobName_S + ") \nstart time (" + startTime + ") - end time (" + endTime1 + ") \nstatus:" + status_S + "\nTotal:" + total_records + "\nProcessed:" + processed_records + "\nSuccess:" + success_records + "\nFailed:" + failed_records;
               System.out.println("send sms of OTA Jobs at " + new Date() + " : " + message_completed);
               sendSMSToSupport(message_completed);
               System.out.println("After sending sms");
               System.out.println("SMS sent");
            }
         }
      } catch (SQLException var18) {
         System.out.println("we have a sql exception " + var18.toString());
      } catch (Exception var19) {
         System.out.println("Exception " + var19.toString());
      }

      return OtaJobSet;
   }

   public void pushInfoToGlobalSystem(String infoKey, String infoMessage, String infoCurrentValue) {
      try {
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         String userName = "vfe_user";
         String password = "vfe_user";
         String url = "jdbc:sqlserver://10.230.82.154:1433;databaseName=vfe_kpis;";
         Connection con = DriverManager.getConnection(url, userName, password);
         System.out.println("connected");
         Statement stmt = con.createStatement();
         String insertionQuery = "INSERT INTO [vfe_kpis].[dbo].[metric_reading_table] ([metric_id],[metric_reading],[reading_desc]) VALUES (" + Integer.valueOf(infoKey) + "," + Integer.valueOf(infoCurrentValue) + ",'" + infoMessage + "')";
         System.out.println("Insertion query :  " + insertionQuery);
         stmt.execute(insertionQuery);
         con.commit();
         con.close();
      } catch (Exception var10) {
         var10.printStackTrace();
         System.out.println("Exception in pushing information : " + var10.toString());
      }

   }

   public void pushInfoToGlobalSystem_replica(String infoKey, String infoMessage, String infoCurrentValue) {
      try {
         String userName = "CMS_MONITOR";
         String password = "CMS_MONITOR";
         String dbURL = "jdbc:oracle:thin:@bscs-scan:1528/BSCSPRD2";
         Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
         Connection newCon = DriverManager.getConnection(dbURL, userName, password);
         newCon.setAutoCommit(true);
         System.out.println("connected to replica");
         String insertionQuery = "INSERT INTO MF_BILLING_TEMP_proactive (text1,text2,text3,Date1,NOTES) VALUES ('" + infoKey + "','" + infoCurrentValue + "','" + infoMessage + "', SYSDATE,'SOC_replica')";
         System.out.println("Insertion query :  " + insertionQuery);
         Statement stmt = newCon.createStatement();
         stmt.execute(insertionQuery);
         System.out.println("After Insertion...");
         newCon.commit();
         newCon.close();
      } catch (Exception var10) {
         System.out.println("Exception in pushing information to replica table : " + var10.toString());
      }

   }

   public int monitor_BOTA_SMSs(Connection con, int oldVal) {
      byte returnedValue = 0;

      try {
         String senderName = "";
         String fireWaittingPeriod = "";
         float numberOfHours = 0.0F;
         ResultSet rs1 = getBOTASettings.executeQuery();

         String currBillCycle;
         while(rs1.next()) {
            int settingId = rs1.getInt("setting_id");
            currBillCycle = rs1.getString("setting_value");
            if (settingId == 62) {
               senderName = currBillCycle;
            }

            if (settingId == 58) {
               numberOfHours = Float.parseFloat(currBillCycle) / 60000.0F / 60.0F;
            }
         }

         ResultSet rs = monitorBOTASMSActions.executeQuery();

         while(rs.next()) {
            currBillCycle = rs.getString("BILL_CYCLE_CODE");
            int log_id = rs.getInt("BC_LOG_ID");
            int curr_status = rs.getInt("STATUS_ID");
            int type = rs.getInt("TYPE_ID");
            int month = rs.getInt("month");
            String status;
            String messageToSend;
            if (type == 71) {
               status = this.getJobStatus(71, currBillCycle);
               if (!status.equals(String.valueOf(curr_status))) {
                  if (curr_status == 57) {
                     messageToSend = "Dears,\n Push SMSs for Bill Cycle " + currBillCycle + " for month " + month + " extracted and ready for review\n ";
                     this.sendBotaSMSs(messageToSend);
                  }

                  if (curr_status == 58) {
                     messageToSend = "Dears,\n Push SMSs for Bill Cycle " + currBillCycle + " for month " + month + " Initially fired and will be sent after " + numberOfHours + " hour with sender name " + senderName + "\n ";
                     this.sendBotaSMSs(messageToSend);
                  }

                  if (curr_status == 61) {
                     messageToSend = "Dears,\n Push SMSs for Bill Cycle " + currBillCycle + " for month " + month + " STARTED.\n ";
                     this.sendBotaSMSs(messageToSend);
                  }

                  if (curr_status == 62) {
                     messageToSend = "Dears,\n Push SMSs for Bill Cycle " + currBillCycle + " for month " + month + " COMPLETED.\n ";
                     this.sendBotaSMSs(messageToSend);
                  }

                  this.updateJobStatus(71, String.valueOf(curr_status), currBillCycle, con);
               }
            }

            if (type == 72) {
               status = this.getJobStatus(72, currBillCycle);
               if (!status.equals(String.valueOf(curr_status))) {
                  if (curr_status == 57) {
                     messageToSend = "Dears,\n Easy SMSs for Bill Cycle " + currBillCycle + " for month " + month + " extracted and ready for review\n ";
                     this.sendBotaSMSs(messageToSend);
                  }

                  if (curr_status == 58) {
                     messageToSend = "Dears,\n Easy SMSs for Bill Cycle " + currBillCycle + " for month " + month + " Initially fired and will be sent after " + numberOfHours + " hour with sender name " + senderName + "\n ";
                     this.sendBotaSMSs(messageToSend);
                  }

                  if (curr_status == 61) {
                     messageToSend = "Dears,\n Easy SMSs for Bill Cycle " + currBillCycle + " for month " + month + " STARTED.\n ";
                     this.sendBotaSMSs(messageToSend);
                  }

                  if (curr_status == 62) {
                     messageToSend = "Dears,\n Easy SMSs for Bill Cycle " + currBillCycle + " for month " + month + " COMPLETED.\n ";
                     this.sendBotaSMSs(messageToSend);
                  }

                  this.updateJobStatus(72, String.valueOf(curr_status), currBillCycle, con);
               }
            }

            if (type == 73) {
               status = this.getJobStatus(73, currBillCycle);
               if (!status.equals(String.valueOf(curr_status))) {
                  if (curr_status == 57) {
                     messageToSend = "Dears,\n BCP SMSs for Bill Cycle " + currBillCycle + " for month " + month + " extracted and ready for review\n ";
                     this.sendBotaSMSs(messageToSend);
                  }

                  if (curr_status == 58) {
                     messageToSend = "Dears,\n BCP SMSs for Bill Cycle " + currBillCycle + " for month " + month + " Initially fired and will be sent after " + numberOfHours + " hour with sender name " + senderName + "\n ";
                     this.sendBotaSMSs(messageToSend);
                  }

                  if (curr_status == 61) {
                     messageToSend = "Dears,\n BCP SMSs for Bill Cycle " + currBillCycle + " for month " + month + " STARTED.\n ";
                     this.sendBotaSMSs(messageToSend);
                  }

                  if (curr_status == 62) {
                     messageToSend = "Dears,\n BCP SMSs for Bill Cycle " + currBillCycle + " for month " + month + " COMPLETED.\n ";
                     this.sendBotaSMSs(messageToSend);
                  }

                  this.updateJobStatus(73, String.valueOf(curr_status), currBillCycle, con);
               }
            }
         }
      } catch (Exception var16) {
         System.out.println("Exception in BOTA monitoring : " + var16.toString());
      }

      return returnedValue;
   }

   public void updateJobStatus(int type, String newStatus, String billcycle, Connection con) {
      try {
         try {
            String user = "cmsada";
            String password = "cmsada9";
            String dbURL = "jdbc:oracle:thin:@bscs-scan:1528/BSCSPRD2";
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            Connection connNew = DriverManager.getConnection(dbURL, user, password);
            connNew.setAutoCommit(true);
            Statement stmt = connNew.createStatement();
            String insertionQuery = "update OTA_ADMIN_EVENT_LOG set EVENT_BODY='" + type + ";" + newStatus + "' where EVENT_TYPE = " + billcycle + " and EVENT_BODY like '" + type + "%'";
            stmt.execute(insertionQuery);
            connNew.commit();
            connNew.close();
         } catch (Exception var11) {
            System.out.println("exception in setting connection " + var11.toString());
         }
      } catch (Exception var12) {
         System.out.println("Exception " + var12.toString());
      }

   }

   public String getJobStatus(int type, String billcycleVal) {
      String status = "";

      try {
         getBOTAEventVal.setString(1, String.valueOf(type));
         getBOTAEventVal.setString(2, billcycleVal);
         ResultSet rs = getBOTAEventVal.executeQuery();
         if (rs.next()) {
            String val = rs.getString("EVENT_BODY");
            String[] currStatus = val.split(";");
            return currStatus[1];
         }
      } catch (Exception var7) {
         System.out.println("Exception in getJobStatus" + var7.toString());
      }

      return status;
   }

   public void sendBotaSMSs(String message) {
      System.out.println("Main started");
      sendSMSToSupport(message);
      System.out.println("After sending sms");
   }

   public void monitor_RVs_Traffic_handling(Connection con, int maxReached) {
   }

   private static void sendGet(String urlContent) throws Exception {
      URL obj = new URL(urlContent);
      HttpURLConnection con = (HttpURLConnection)obj.openConnection();
      con.setRequestMethod("GET");
      con.setRequestProperty("User-Agent", "Mozilla/5.0");
      int responseCode = con.getResponseCode();
      String responseMsg = con.getResponseMessage();
      System.out.println("\nSending 'GET' request to URL : " + urlContent);
      System.out.println("Response Code : " + responseCode);
      System.out.println("response message is : " + responseMsg);
      BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
      StringBuffer response = new StringBuffer();

      String inputLine;
      while((inputLine = in.readLine()) != null) {
         response.append(inputLine);
      }

      in.close();
      System.out.println(response.toString());
   }

   public static void sendDevSMS(String messageContents) {
      new SendMailUtil();
      sendSMSToSupport(messageContents);
      System.out.println("After sending sms");
   }

   public static void sendWfxMainSMS(String messageContents) {
      sendSMSToSupport(messageContents);
      System.out.println("After sending sms");
   }

   public static void sendSMSToSupport(String messageContents) {
      Vector MSISDNs = new Vector();
      MSISDNs.add("201030024022");
      MSISDNs.add("201094170727");
      MSISDNs.add("201093738425");
      MSISDNs.add("201069062615");
      MSISDNs.add("201068293023");
      MSISDNs.add("201020400028");
      new SendMailUtil();
      SendMailUtil.sendNewSMS(MSISDNs, messageContents);
      System.out.println("After sending sms");
   }
   
   public static void sendSMSToSupportProvisioning(String messageContents) {
	      Vector MSISDNs = new Vector();
	      MSISDNs.add("201030024022");
	      MSISDNs.add("201094170727");
	      MSISDNs.add("201093738425");
	      MSISDNs.add("201069062615");
	      MSISDNs.add("201068293023");
	      MSISDNs.add("201020400028");
	      
	      MSISDNs.add("201001101000");
	      MSISDNs.add("201006077776");
	      MSISDNs.add("201011601659");
	      MSISDNs.add("201023424426");
	      MSISDNs.add("201069941623");
	      MSISDNs.add("201010087111");
	      new SendMailUtil();
	      SendMailUtil.sendNewSMS(MSISDNs, messageContents);
	      System.out.println("After sending sms");
	   }

   public static void sendSmsPortOut(String messageContents) {
      Vector MSISDNs = new Vector();
      MSISDNs.add("201030024022");
      MSISDNs.add("201094170727");
      MSISDNs.add("201093738425");
      MSISDNs.add("201069062615");
      MSISDNs.add("201006100039");
      MSISDNs.add("201006707080");
      MSISDNs.add("201032229112");
      MSISDNs.add("201067078605");
      MSISDNs.add("201068293023");
      MSISDNs.add("201020400028");
      new SendMailUtil();
      SendMailUtil.sendNewSMS(MSISDNs, messageContents);
      System.out.println("After sending sms");
   }

   public void monitorOnlinePthBackLogFunc(Connection con, ProActiveConfModel proModel) {
      System.out.println("monitorOnlinePthBackLogFunc...\n\n");

      try {
         ResultSet rs = monitorOnlinePthBackLog.executeQuery();
         boolean var4 = false;

         while(rs.next()) {
            int BackLogCount = rs.getInt("SUMBKLG");
            System.out.println("PTH backlog is now : " + BackLogCount);
            if (BackLogCount >= 50) {
               System.out.println("Main started");
               String message = "CRITICAL [New]- We are facing backlog on online payment module PTH, Number of BackLog in last 5 mints ( " + BackLogCount + " ),  please check urgently.";
               sendSMSToSupport(message);
               System.out.println("After sending sms");
            }
         }
      } catch (SQLException var6) {
         System.out.println("Exception in monitorOnlinePthBackLogFunc  \n" + var6.toString());
      }

   }

   public void monitorOnlinePthRejectionFunc(Connection con, ProActiveConfModel proModel) {
      System.out.println("monitorOnlinePthRejectionFunc...\n\n");

      try {
         ResultSet rs = monitorOnlinePthRejection.executeQuery();
         boolean var4 = false;

         while(rs.next()) {
            int RejectCount = rs.getInt("SUMRJCT");
            System.out.println("PTH Rejection is now : " + RejectCount);
            if (RejectCount >= 50) {
               System.out.println("Main started");
               String message = "CRITICAL [New]- We are facing Rejections on online payment module PTH, Number of Rejections in last 5 mints ( " + RejectCount + " ),  please check urgently.";
               sendSMSToSupport(message);
               System.out.println("After sending sms");
            }
         }
      } catch (SQLException var6) {
         System.out.println("Exception in monitorOnlinePthRejectionFunc" + var6.toString());
      }

   }

   public void monitorOnlinePthMemoryProbFunc(Connection con, ProActiveConfModel proModel) {
      System.out.println("monitorOnlinePthMemoryProbFunc...\n\n");

      try {
         ResultSet rs = monitorOnlinePthMemoryProb.executeQuery();
         boolean var4 = false;

         while(rs.next()) {
            int RejectCount = rs.getInt("SUMRJCT");
            System.out.println("PTH Memory error TXN is now : " + RejectCount);
            if (RejectCount >= 1) {
               String message = "CRITICAL [New]- We are facing memory transaction problem on online payment module PTH, Number of transactions in last 5 mints (" + RejectCount + "),  Please check urgently to avoid PTH hang";
               sendSMSToSupport(message);
               System.out.println("After sending sms");
               SendMailUtil sendMaile = new SendMailUtil();
               sendMaile.sendMail(message, (String)null, "Proactive - Payment duplicates", proModel.getMails());
            }
         }
      } catch (SQLException var7) {
         System.out.println("Exception in monitorOnlinePthMemoryProbFunc" + var7.toString());
      }

   }

   public void monitorFIHBackLogFunc(Connection con, ProActiveConfModel proModel) {
      System.out.println("monitorFIHBackLogFunc...\n\n");

      try {
         ResultSet rs = monitorFIHBackLog.executeQuery();
         boolean var4 = false;

         while(rs.next()) {
            int backLogCount = rs.getInt("SUMBKLG");
            System.out.println("FIH Backlog files is now : " + backLogCount);
            if (backLogCount >= 700) {
               String message = "CRITICAL [New]- We are facing facing backlog on rating module FIH, Number of Backlogs in last 5 mints (" + backLogCount + "),  Please check urgently FIH status";
               System.out.println("After sending sms");
               SendMailUtil sendMaile = new SendMailUtil();
               sendMaile.sendMail(message, (String)null, "Proactive - FIH - BackLog", proModel.getMails());
            }
         }
      } catch (SQLException var7) {
         System.out.println("Exception in monitorFIHBackLogFunc" + var7.toString());
      }

   }

   public void monitorFIHRejectionFunc(Connection con, ProActiveConfModel proModel) {
      System.out.println("monitorFIHRejectionFunc...\n\n");

      try {
         ResultSet rs = monitorFIHRejection.executeQuery();
         boolean var4 = false;

         while(rs.next()) {
            int rejectionCount = rs.getInt("COUNTREJ");
            System.out.println("FIH Rejection count is now : " + rejectionCount);
            if (rejectionCount >= 50) {
               String message = "CRITICAL [New]- We are facing facing Rejection on rating module FIH, Number of Rejection in last 5 mints (" + rejectionCount + "),  Please check urgently FIH status";
               System.out.println("After sending sms");
               SendMailUtil sendMaile = new SendMailUtil();
               sendMaile.sendMail(message, (String)null, "Proactive - FIH - Rejection", proModel.getMails());
            }
         }
      } catch (SQLException var7) {
         System.out.println("Exception in monitorFIHBackLogFunc" + var7.toString());
      }

   }

   public void monitorMaxCursorsFunc(Connection con, ProActiveConfModel proModel) {
      System.out.println("monitorMaxCursorsFunc...\n\n");

      try {
         ResultSet rs = monitorMaxCursors.executeQuery();
         if (rs.isBeforeFirst()) {
            String message = "CRITICAL [New]- Some DB sessions exists with more than 850 cursors opened,,  please check email urgently.";
            sendSMSToSupport(message);
            System.out.println("After sending sms");
            String emailMessage = "CRITICAL [New]- Some DB sessions exists with more than 850 cursors opened, here are the sessions details:";

            int count;
            String currValue;
            String currUserName;
            String currSID;
            String currSerial;
            for(count = 0; rs.next(); emailMessage = emailMessage + "\n " + count + " -    UserName:   " + currUserName + "  Opened Cursors:   " + currValue + "  SID:   " + currSID + "  currSerial:   " + currSerial) {
               ++count;
               currValue = rs.getString("VALUE");
               currUserName = rs.getString("USERNAME");
               currSID = rs.getString("SID");
               currSerial = rs.getString("SERIAL");
            }

            SendMailUtil sendMaile = new SendMailUtil();
            sendMaile.sendMail(emailMessage, (String)null, "Proactive - Max Session Cursors Exceeded (" + count + ")", proModel.getMails());
         }
      } catch (SQLException var11) {
         System.out.println("Exception in monitoring MaxCursors function" + var11.toString());
      }

   }

   public static void prepAndUpdateCDFiles(Connection con, ProActiveConfModel proModel) throws SQLException {
      int fileId = 0;
      String mailMessage = "";
      ResultSet rsOnline = checkRejectedCdFiles.executeQuery();
      ArrayList fileIds = new ArrayList();
      if (rsOnline.isBeforeFirst()) {
         for(mailMessage = "Info[New]- Some rejected CD files exists and being handled now,  Please check the file Ids : \n "; rsOnline.next(); mailMessage = mailMessage + fileId + "  \n  ") {
            fileId = rsOnline.getInt("file_id");
            fileIds.add(fileId);
         }

         StringBuilder idList = new StringBuilder();

         for(Iterator localIterator = fileIds.iterator(); localIterator.hasNext(); idList.append("?")) {
            int id = (Integer)localIterator.next();
            if (idList.length() > 0) {
               idList.append(",");
            }
         }

         updateCDFileStatus = con.prepareStatement((new StringBuilder()).append("UPDATE thufitab   SET received = received - 20, status = 0 WHERE file_id IN ( ").append(idList).append(" ) ").toString());

         int i;
         for(i = 0; i < fileIds.size(); ++i) {
            updateCDFileStatus.setInt(i + 1, (Integer)fileIds.get(i));
         }

         CheckCDFileStatus = con.prepareStatement((new StringBuilder()).append("select count(1) as countrows from thufitab where file_id IN ( ").append(idList).append(" ) and status not in ( 2,1 ) ").toString());

         for(i = 0; i < fileIds.size(); ++i) {
            CheckCDFileStatus.setInt(i + 1, (Integer)fileIds.get(i));
         }

         updateCDFileRecievedDate = con.prepareStatement((new StringBuilder()).append("UPDATE thufitab   SET received = received + 20 WHERE  file_id IN ( ").append(idList).append(" ) ").toString());

         for(i = 0; i < fileIds.size(); ++i) {
            updateCDFileRecievedDate.setInt(i + 1, (Integer)fileIds.get(i));
         }

         ResultSet updateRes = updateCDFileStatus.executeQuery();
         con.commit();
         isCDFilesPopulated = true;
         System.out.println("=======================================================");
         System.out.println("CD files found and being handled now.");
         System.out.println("=======================================================");
         SendMailUtil sendMaile = new SendMailUtil();
         sendMaile.sendMail(mailMessage, (String)null, "Proactive - Rejected CD-Files count is :   (" + fileIds.size() + ")", proModel.getMails());
         sendSMSToSupport("Rejected CD-Files count is :   (" + fileIds.size() + ") please check your mail...");
      } else {
         isCDFilesHandled = true;
      }

   }

   private static void checkAndUpdate(Connection con, ProActiveConfModel proModel) throws SQLException {
      ResultSet checkStatus = CheckCDFileStatus.executeQuery();
      con.commit();

      while(checkStatus.next() && checkStatus.getInt("countrows") == 0) {
         ResultSet updateDate = updateCDFileRecievedDate.executeQuery();
         isCDFilesHandled = true;
         con.commit();
         System.out.println("=======================================================");
         System.out.println("CD files found handled now.");
         System.out.println("=======================================================");
         SendMailUtil sendMaile = new SendMailUtil();
         String mailMessage = "Info[New]- Rejected CD files are handled please validate...";
         sendMaile.sendMail(mailMessage, (String)null, "Proactive - Rejected CD-Files handled", proModel.getMails());
         sendSMSToSupport("CD files Handled, please validate..");
      }

   }

   public static void handleRejectedCDFiles(Connection con, ProActiveConfModel proModel) {
      try {
         if (!isCDFilesPopulated) {
            prepAndUpdateCDFiles(con, proModel);
         }

         if (!isCDFilesHandled) {
            checkAndUpdate(con, proModel);
         }
      } catch (SQLException var3) {
         var3.printStackTrace();
      }

   }

   public static void checkServEngLogin(Connection con, ProActiveConfModel proModel) {
      try {
         ResultSet rs = checkservEngLogin.executeQuery();
         String OSUSER = "";
         String LOGON_TIME = "";
         String emailMessage = "Dears, \n Some unauthorized users are logged in with ServEngDB user, please check the following : ";
         int serial = 0;
         if (rs.isBeforeFirst()) {
            while(true) {
               String USERNAME;
               String status;
               if (!rs.next()) {
                  USERNAME = "Some unauthorized users are logged in with ServEngDB user, : " + OSUSER + "  ,  please check email urgently.";
                  Vector MSISDNs = new Vector();
                  new SendMailUtil();
                  SendMailUtil.sendNewSMS(MSISDNs, USERNAME);
                  System.out.println("After sending sms");
                  SendMailUtil sendMaile = new SendMailUtil();
                  status = "techit-rm-billing-support@voda.com";
                  sendMaile.sendMail(emailMessage, (String)null, "Proactive - unauthorized users Login !!  ", status);
                  break;
               }

               USERNAME = rs.getString("USERNAME");
               OSUSER = rs.getString("OSUSER");
               String Machine = rs.getString("MACHINE");
               int sid = rs.getInt("SID");
                serial = rs.getInt("SERIAL");
               String process = rs.getString("PROCESS");
               status = rs.getString("STATUS");
               LOGON_TIME = rs.getString("LOGON_TIME");
               emailMessage = emailMessage + "\n UserName: " + USERNAME + " -    OSUSER:   " + OSUSER + " -   Machine :   " + Machine + " -   SID:   " + sid + " -   SERIAL:   " + serial + " - PROCESS: " + process + " - STATUS: " + status + " - LOGON_TIME: " + LOGON_TIME;
            }
         }
      } catch (SQLException var12) {
         var12.printStackTrace();
      }

   }

   public String checkBillsrvModules() {
      ChannelExec execChannel = (ChannelExec)this.getChannel("cms_adm", "CmsAdm123", "10.230.91.39");
      String summary = this.excuteCommand(execChannel, "sh ~/release/scripts/billsrv_monitor_Mike.sh");
      this.closeChannel(execChannel);
      return summary;
   }

   public String checkGmdModules() {
      ChannelExec execChannel = (ChannelExec)this.getChannel("bscs_adm", "bscsadm123", "10.230.91.91");
      String summary = this.excuteCommand(execChannel, "sh gmd_monitor_Mike.sh");
      this.closeChannel(execChannel);
      return summary;
   }

   public void checkLicenseServers() {
      try {
         ChannelExec execChannel1 = (ChannelExec)this.getChannel("bscs_adm", "bscsadm123", "10.230.91.91");
         String numberOfProcesses1 = this.excuteCommand(execChannel1, "ps -ef | grep CONSOLE | grep -v grep | wc -l");
         this.closeChannel(execChannel1);
         ChannelExec execChannel2 = (ChannelExec)this.getChannel("cms_adm", "CmsAdm123", "10.230.91.39");
         String numberOfProcesses2 = this.excuteCommand(execChannel2, "ps -ef | grep CONSOLE | grep -v grep | wc -l");
         this.closeChannel(execChannel2);
         ChannelExec execChannel3 = (ChannelExec)this.getChannel("billadm", "Bill_Adm123", "10.230.91.196");
         String numberOfProcesses3 = this.excuteCommand(execChannel3, "ps -ef | grep CONSOLE | grep -v grep | wc -l");
         this.closeChannel(execChannel3);
         if (!"1".equals(numberOfProcesses1) || !"1".equals(numberOfProcesses2) || !"1".equals(numberOfProcesses3)) {
            String message = "";
            if (!"1".equals(numberOfProcesses1)) {
               message = message + "License Server on 91 is down.\n";
            }

            if (!"1".equals(numberOfProcesses2)) {
               message = message + "License Server on 39 is down.\n";
            }

            if (!"1".equals(numberOfProcesses3)) {
               message = message + "License Server on 196 is down.";
            }

            sendSMSToSupport(message);
         }
      } catch (Exception var8) {
         System.out.println(var8);
      }

   }

   public void checkopends() {
      try {
         ChannelExec execChannel1 = (ChannelExec)this.getChannel("bscs_adm", "bscsadm123", "10.230.91.163");
         String numberOfProcesses1 = this.excuteCommand(execChannel1, "ps -ef | grep opends | grep -v grep | wc -l");
         this.closeChannel(execChannel1);
         if ("0".equals(numberOfProcesses1)) {
            String message = "";
            if (!"1".equals(numberOfProcesses1)) {
               message = message + "Opends on 163 is down.\n";
            }

            sendSMSToSupport(message);
         }
      } catch (Exception var4) {
         System.out.println(var4);
      }

   }

   public void checkHaproxy() {
      int size = 0;
      String message = "";

      try {
         ChannelExec execChannel1 = (ChannelExec)this.getChannel("cms_adm", "CmsAdm123", "10.230.91.39");
         String numberOfProcesses = this.excuteCommand(execChannel1, "ps -ef | grep haproxy | grep -v grep | wc -l");
         this.closeChannel(execChannel1);
         if (!"1".equals(numberOfProcesses)) {
            message = message + "License Server on 39 is down.\n";
            sendSMSToSupport(message);
         }
      } catch (Exception var5) {
         System.out.println(var5);
      }

   }

   public void checkOpenDSFiles() {
      Date now = new Date();
      if (now.getHours() >= 2) {
         try {
            String message = "";
            ChannelExec execChannel1 = (ChannelExec)this.getChannel("cms_adm", "CmsAdm123", "10.230.91.39");
            String FileDate = this.excuteCommand(execChannel1, "date -r  /usr/home/cms_adm/release/IDM/opends/db/userRoot  +%d%m%Y");
            this.closeChannel(execChannel1);
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
            String strDate = sdf.format(cal.getTime());
            if (FileDate.equals(strDate)) {
               message = "OpenDS Files copied successfully M/C:39";
            } else {
               message = "opnedDS files not copied on M/C:39";
            }

            SendMailUtil sendMaile = new SendMailUtil();
            sendMaile.sendMail(message, (String)null, "OPENDS", "techit-rm-billing-support@voda.com");
            sendSMSToSupport(message);
         } catch (Exception var9) {
            System.out.println(var9);
         }
      }

   }

   public void checkFileSystem(ProActiveConfModel proModel) {
      try {
//         ChannelExec execChannel1 = (ChannelExec)this.getChannel("bat_adm", "BatAdm123", "10.230.91.40");
//         int sizePercent1 = Integer.parseInt(this.excuteCommand(execChannel1, "df -h /usr/home/bat_adm | grep /usr/home/bat_adm | tr -s ' ' | cut -d ' ' -f5 | grep -o \"[0-9|.]*\""));
//         this.closeChannel(execChannel1);
         ChannelExec execChannel4 = (ChannelExec)this.getChannel("cms_adm", "CmsAdm123", "10.72.64.79");
         int sizePercent5 = Integer.parseInt(this.excuteCommand(execChannel4, "df -h /usr/home | grep /usr/home | tr -s ' ' | cut -d ' ' -f5 | grep -o \"[0-9|.]*\""));
         this.closeChannel(execChannel4);
         ChannelExec execChannel6 = (ChannelExec)this.getChannel("cms_adm", "CmsAdm123", "10.230.91.39");
         int sizePercent4 = Integer.parseInt(this.excuteCommand(execChannel6, "df -h /dev/vx/dsk/bscs-cms-adm/weblogic| grep /dev/vx/dsk/bscs-cms-adm/weblogic | tr -s ' ' | cut -d ' ' -f5| grep -o \"[0-9|.]*\""));
         this.closeChannel(execChannel6);
         ChannelExec execChannel2 = (ChannelExec)this.getChannel("cms_adm", "CmsAdm123", "10.230.91.39");
         int sizePercent2 = Integer.parseInt(this.excuteCommand(execChannel2, "df -h /usr/home/cms_adm | grep /usr/home/cms_adm | tr -s ' ' | cut -d ' ' -f5 | grep -o \"[0-9|.]*\""));
         this.closeChannel(execChannel2);
         ChannelExec execChannel3 = (ChannelExec)this.getChannel("bscs_adm", "bscsadm123", "10.230.91.91");
         int sizePercent3 = Integer.parseInt(this.excuteCommand(execChannel3, "df -h /usr/home/bscs_adm | grep /usr/home/bscs_adm | tr -s ' ' | cut -d ' ' -f5 | grep -o \"[0-9|.]*\""));
         this.closeChannel(execChannel3);
         if ( sizePercent2 > 85 || sizePercent3 > 86 || sizePercent4 > 85 || sizePercent5 > 85) {
            String message = "";
            if ( sizePercent2 > 85) {
               message = message + "file system of machine 10.230.91.39 : " + sizePercent2 + "% , check urgently.\n";
            }

//            message = message + "file system of machine 10.230.91.40 : " + sizePercent1 + "% , check urgently.\n";
            if (sizePercent3 > 88) {
               message = message + "file system of machine 10.230.91.91 : " + sizePercent3 + "% , check urgently.\n";
            }

            if (sizePercent5 > 85) {
               message = message + "file system of DR machine  : " + sizePercent5 + "% , check urgently.\n";
            }

            if (sizePercent4 > 50) {
               message = message + "file system of weblogic  : " + sizePercent4 + "% , check urgently.\n";
            }

            SendMailUtil sendMaile = new SendMailUtil();
            sendMaile.sendMail(message, (String)null, "File System Monitoring", proModel.getMails());
            if (sizePercent2 >= 92 || sizePercent3 >= 92 || sizePercent5 >= 50) {
               sendSMSToSupport(message);
            }
         }
      } catch (Exception var14) {
         System.err.println(var14);
      }

   }

   public void checkOnlineModules() {
      try {
         ChannelExec execChannel1 = (ChannelExec)this.getChannel("cms_adm", "CmsAdm123", "10.230.91.39");
         String summary = this.excuteCommand(execChannel1, "sh ~/release/scripts/soi_summary.sh");
         this.closeChannel(execChannel1);
         summary = summary + "\n";
//         ChannelExec execChannel2 = (ChannelExec)this.getChannel("bat_adm", "BatAdm123", "10.230.91.40");
//         summary = summary + this.excuteCommand(execChannel2, "sh ~/release/scripts/soi_summary.sh");
//         this.closeChannel(execChannel2);
         if (summary.contains(":0")) {
            sendSMSToSupport(summary + "\nplease check missing processes");
         }
      } catch (Exception var4) {
         System.err.println(var4);
      }

   }

   public void CheckRatingQueues(ProActiveConfModel proModel) {
      try {
         String summary91 = null;
         String[] summarystring = new String[7];
         ChannelExec execChannel2 = (ChannelExec)this.getChannel("bscs_adm", "bscsadm123", "10.230.91.91");
         summary91 = this.excuteCommand(execChannel2, "cat /usr/home/bscs_adm/Osama/output.txt");
         this.closeChannel(execChannel2);
         System.out.println(summary91);
         summarystring = summary91.split(",");
         String mailContent = "Dears,\n\r" + "Kindly find below the Rating queues summary\n\r" + "backlog on prih= " + summarystring[0] + "\n\rbacklog on rih= " + summarystring[1] + "\n\rbacklog on RLH= " + summarystring[2] + "\n\rbacklog on CCH= " + summarystring[3] + "\n\rrejected from  RIH= " + summarystring[4] + "\n\rrejected from  RLH= " + summarystring[5] + "\n\rrejected from  FOH= " + summarystring[6];
         SendMailUtil sendMaile = new SendMailUtil();
         sendMaile.sendWfxMail(mailContent, (String)null, "Rating Queues Summary", "fady.adel-attallah@localhost.com;techit-rm-billing-support@voda.com");
      } catch (Exception var7) {
         System.err.println(var7);
      }

   }

   public void CheckQueues(ProActiveConfModel proModel) {
      try {
         String summary91 = null;
         String[] summarystring = new String[7];
         ChannelExec execChannel2 = (ChannelExec)this.getChannel("bscs_adm", "bscsadm123", "10.230.91.91");
         String mailContent = "";
         summary91 = this.excuteCommand(execChannel2, "cat /usr/home/bscs_adm/Osama/output.txt");
         this.closeChannel(execChannel2);
         System.out.println(summary91);
         summarystring = summary91.split(",");
         int backlog_prih = Integer.parseInt(summarystring[0]);
         int backlog_rih = Integer.parseInt(summarystring[1]);
         int backlog_rlh = Integer.parseInt(summarystring[2]);
         int backlog_cch = Integer.parseInt(summarystring[3]);
         int rejected_RIH = Integer.parseInt(summarystring[4]);
         int rejected_RLH = Integer.parseInt(summarystring[5]);
         int rejected_FOH = Integer.parseInt(summarystring[6]);
         if (backlog_prih > 1000 || backlog_rih > 500 || backlog_rlh > 10000 || backlog_cch > 10000 || rejected_RIH > 200000 || rejected_RLH > 200 || rejected_FOH > 1000) {
            mailContent = "Dears,\n\r" + "Kindly find below the Rating queues summary\n\r" + "backlog on prih= " + summarystring[0] + "\n\rbacklog on rih= " + summarystring[1] + "\n\rbacklog on RLH= " + summarystring[2] + "\n\rbacklog on CCH= " + summarystring[3] + "\n\rrejected from  RIH= " + summarystring[4] + "\n\rrejected from  RLH= " + summarystring[5] + "\n\rrejected from  FOH= " + summarystring[6];
            SendMailUtil sendMaile = new SendMailUtil();
            System.out.println("Queues Fn.");
            sendMaile.sendWfxMail(mailContent, (String)null, "Rating Queues Summary", "fady.adel-attallah@vodafone.com;techit-rm-billing-support@voda.com");
         }
      } catch (Exception var14) {
         System.err.println(var14);
      }

   }

   public void CheckRating(ProActiveConfModel proModel) {
      try {
         String summary91 = null;
         String summary92 = null;
         Calendar cal = Calendar.getInstance();
         SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
         String strDate = sdf.format(cal.getTime());
         String[] dateFormat = strDate.split("-");
         String year = dateFormat[2];
         String month = dateFormat[1];
         String day = dateFormat[0];
         int dayInt = Integer.parseInt(dateFormat[0]) - 1;
         String[] summarystring = new String[20];
         ChannelExec execChannel1 = (ChannelExec)this.getChannel("billadm", "Bill_Adm123", "10.230.91.196");
         this.excuteCommand(execChannel1, "~/support/fady/thufitab_monitoring.sh");
         this.closeChannel(execChannel1);
         ChannelExec execChannel2 = (ChannelExec)this.getChannel("billadm", "Bill_Adm123", "10.230.91.196");
         this.excuteCommand(execChannel2, "~/support/fady/RTX_Trends.sh " + month + dayInt);
         this.closeChannel(execChannel2);
      } catch (Exception var15) {
         System.err.println(var15);
      }

   }

   public void CheckRTXTrends(ProActiveConfModel proModel) {
      try {
         Calendar cal = Calendar.getInstance();
         SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
         String strDate = sdf.format(cal.getTime());
         String[] dateFormat = strDate.split("-");
         String year = dateFormat[2];
         String month = dateFormat[1];
         String day = dateFormat[0];
         int dayInt = Integer.parseInt(day) - 1;
         String[] summarystring = new String[20];
         String[] summarystring1 = new String[20];
         ChannelExec execChannel1 = (ChannelExec)this.getChannel("billadm", "Bill_Adm123", "10.230.91.196");
         String summary91 = this.excuteCommand(execChannel1, "cat ~/support/fady/RTX_Trend.csv");
         this.closeChannel(execChannel1);
         ChannelExec execChanne22 = (ChannelExec)this.getChannel("billadm", "Bill_Adm123", "10.230.91.196");
         String summary92 = this.excuteCommand(execChanne22, "cat ~/support/fady/RTX_TrendLastWeek.csv");
         this.closeChannel(execChanne22);
         summary92 = summary92.replaceAll("SQL>", "");
         summary91 = summary91.replaceAll("SQL>", "");
         summarystring = summary91.split("//");
         summarystring[2] = summarystring[2].replaceAll(",1", "  :   Voice");
         summarystring[3] = summarystring[3].replaceAll(",4", "  :       SMS");
         summarystring[4] = summarystring[4].replaceAll(",141", "  :   DATA");
         summarystring[5] = summarystring[5].replaceAll(",145", "  :       Content");
         summarystring1 = summary92.split("//");
         summarystring1[2] = summarystring1[2].replaceAll(",1", "  :   Voice");
         summarystring1[3] = summarystring1[3].replaceAll(",4", "  :       SMS");
         summarystring1[4] = summarystring1[4].replaceAll(",141", "  :   DATA");
         summarystring1[5] = summarystring1[5].replaceAll(",145", "  :       Content");
         System.out.println("RTXXXXXXXXXXX");
         String mailContent = "Dears,\r\n Kindly find below the usage trend from PARTITION: " + month + "/" + dayInt + " \n\n";

         int i;
         for(i = 2; i < 6; ++i) {
            mailContent = mailContent + summarystring[i];
         }

         mailContent = mailContent + "\n\n and the below is the Trend of last week \n";

         for(i = 2; i < 6; ++i) {
            mailContent = mailContent + summarystring1[i];
         }

         SendMailUtil sendMaile = new SendMailUtil();
         sendMaile.sendWfxMail(mailContent, (String)null, "RTX Usage Trend: " + month + "/" + dayInt, "fady.adel-attallah@localhost.com;techit-rm-billing-support@voda.com");
         System.out.println("RTXXXXXXXXXXX");
         System.out.println(mailContent);
      } catch (Exception var18) {
         System.err.println(var18);
      }

   }

   public void checkRatingModules91(ProActiveConfModel proModel) {
      try {
         ChannelExec execChannel1 = (ChannelExec)this.getChannel("bscs_adm", "bscsadm123", "10.230.91.91");
         String summary91 = this.excuteCommand(execChannel1, "sh ~/Osama/tolba.sh");
         String[] summarystring = new String[10];
         this.closeChannel(execChannel1);
         summarystring = summary91.split("-");
         String mailContent;
         SendMailUtil sendMaile;
         if (!summarystring[2].substring(7, 8).equals("(") && !summarystring[3].substring(7, 8).equals("(") && !summarystring[7].substring(15, 16).equals("(") && !summarystring[8].substring(22, 23).equals("(") && !summarystring[9].substring(22, 23).equals("(")) {
            if (Integer.parseInt(summarystring[0].substring(4, 5)) < 5 || Integer.parseInt(summarystring[1].substring(7, 8)) < 7 || Integer.parseInt(summarystring[2].substring(6, 8)) < 17 || Integer.parseInt(summarystring[3].substring(6, 8)) < 18 || Integer.parseInt(summarystring[4].substring(6, 7)) < 1 || Integer.parseInt(summarystring[5].substring(16, 17)) < 1 || Integer.parseInt(summarystring[6].substring(15, 16)) < 1 || Integer.parseInt(summarystring[7].substring(14, 16)) < 17 || Integer.parseInt(summarystring[8].substring(21, 23)) < 17 || Integer.parseInt(summarystring[9].substring(21, 23)) < 17) {
               sendSMSToSupport(summarystring[0] + summarystring[1] + summarystring[2] + summarystring[3] + summarystring[4] + summarystring[5] + summarystring[6] + summarystring[7] + summarystring[8] + summarystring[9] + " \n please check missing processes on M/C 91");
               mailContent = summarystring[0] + summarystring[1] + summarystring[2] + summarystring[3] + summarystring[4] + summarystring[5] + summarystring[6] + summarystring[7] + summarystring[8] + summarystring[9] + "please check missing processes on M/C 91";
               sendMaile = new SendMailUtil();
               sendMaile.sendWfxMail(mailContent, (String)null, "Missing Rating Modules", proModel.getMails());
            }
         } else {
            sendSMSToSupport(summarystring[0] + summarystring[1] + summarystring[2] + summarystring[3] + summarystring[4] + summarystring[5] + summarystring[6] + summarystring[7] + summarystring[8] + summarystring[9] + " \n please check missing processes on M/C 91");
            mailContent = summarystring[0] + summarystring[1] + summarystring[2] + summarystring[3] + summarystring[4] + summarystring[5] + summarystring[6] + summarystring[7] + summarystring[8] + summarystring[9] + "please check missing processes on M/C 91";
            sendMaile = new SendMailUtil();
            sendMaile.sendWfxMail(mailContent, (String)null, "Missing Rating Modules", proModel.getMails());
         }
      } catch (Exception var7) {
         System.err.println(var7);
      }

   }

   public void checkRatingModules163(ProActiveConfModel proModel) {
      try {
         ChannelExec execChannel2 = (ChannelExec)this.getChannel("bscs_adm", "bscsadm123", "10.230.91.163");
         String summary163 = this.excuteCommand(execChannel2, "sh ~/Osama/tolba_2.sh");
         String[] summarystring3 = new String[7];
         this.closeChannel(execChannel2);
         summarystring3 = summary163.split("-");
         String mailContent;
         SendMailUtil sendMaile;
         if (!summarystring3[0].substring(5, 6).equals("(") && !summarystring3[1].substring(7, 8).equals("(") && !summarystring3[2].substring(7, 8).equals("(") && !summarystring3[3].substring(12, 13).equals("(") && !summarystring3[4].substring(12, 13).equals("(") && !summarystring3[5].substring(28, 29).equals("(") && !summarystring3[5].substring(28, 29).equals("(")) {
            if (Integer.parseInt(summarystring3[0].substring(4, 6)) < 17 || Integer.parseInt(summarystring3[1].substring(6, 8)) < 17 || Integer.parseInt(summarystring3[2].substring(6, 8)) < 17 || Integer.parseInt(summarystring3[3].substring(11, 13)) < 17 || Integer.parseInt(summarystring3[4].substring(11, 13)) < 41 || Integer.parseInt(summarystring3[5].substring(27, 29)) < 41 || Integer.parseInt(summarystring3[6].substring(27, 29)) < 51) {
               sendSMSToSupport(summarystring3[0] + summarystring3[1] + summarystring3[2] + summarystring3[3] + summarystring3[4] + summarystring3[5] + summarystring3[6] + " \n please check missing processes on M/C 163");
               mailContent = summarystring3[0] + summarystring3[1] + summarystring3[2] + summarystring3[3] + summarystring3[4] + summarystring3[5] + summarystring3[6] + "please check missing processes on M/C 163";
               sendMaile = new SendMailUtil();
               sendMaile.sendWfxMail(mailContent, (String)null, "Missing Rating Modules", proModel.getMails());
            }
         } else {
            sendSMSToSupport(summarystring3[0] + summarystring3[1] + summarystring3[2] + summarystring3[3] + summarystring3[4] + summarystring3[5] + summarystring3[6] + " \n please check missing processes on M/C 163");
            mailContent = summarystring3[0] + summarystring3[1] + summarystring3[2] + summarystring3[3] + summarystring3[4] + summarystring3[5] + summarystring3[6] + " please check missing processes on M/C 163";
            sendMaile = new SendMailUtil();
            sendMaile.sendWfxMail(mailContent, (String)null, "Missing Rating Modules", proModel.getMails());
         }
      } catch (Exception var7) {
         System.err.println(var7);
      }

   }

   public void CheckBC03Customers(ProActiveConfModel proModel) {
      ChannelExec execChannel = (ChannelExec)this.getChannel("billadm", "Bill_Adm123", "10.230.91.196");
      String summary163 = this.excuteCommand(execChannel, "cat /usr/home/billadm/support/fady/bc03.txt");
      String mailRecepts = proModel.getMails().replaceAll("fady.adel-attallah@localhost.com;", "");
      String message = "Dears," + System.lineSeparator() + "Please check the below cutomers have postpaid contracts and on BC03" + System.lineSeparator() + System.lineSeparator() + summary163;
      SendMailUtil sendMaile = new SendMailUtil();
      sendMaile.sendWfxMail(message, (String)null, "Post Paid Customers on BC03", "fady.adel-attallah@localhost.com;Mahmoud.ElHussieny-Salama@localhost.com;CCE2E.Billing@localhost.com;techit-rm-billing-support@voda.com");
   }

   public void CheckFailedProvRequests(ProActiveConfModel proModel) {
      ChannelExec execChannel = (ChannelExec)this.getChannel("billadm", "Bill_Adm123", "10.230.91.196");
      String summary163 = this.excuteCommand(execChannel, "cat /usr/home/billadm/support/fady/failed_requests.txt");
      String message = "Dears," + System.lineSeparator() + "Please check failed requests in status 4 for yesterday:" + System.lineSeparator() + System.lineSeparator() + summary163;
      SendMailUtil sendMaile = new SendMailUtil();
      sendMaile.sendWfxMail(message, (String)null, "Failed Requests", "techit-rm-billing-support@voda.com");
      System.out.println("failed requests report");
   }

   public void checkAdapter() {
      try {
         ChannelExec execChannel1 = (ChannelExec)this.getChannel("cms_adm", "CmsAdm123", "10.230.91.39");
         String summary = this.excuteCommand(execChannel1, "sh ~/release/scripts/adp_summary.sh");
         this.closeChannel(execChannel1);
         summary = summary + "\n";
//         ChannelExec execChannel2 = (ChannelExec)this.getChannel("bat_adm", "BatAdm123", "10.230.91.40");
//         summary = summary + this.excuteCommand(execChannel2, "sh ~/release/scripts/adp_summary.sh");
//         this.closeChannel(execChannel2);
         if (summary.contains(":0")) {
            sendSMSToSupport(summary + "\nplease check missing processes");
         }
      } catch (Exception var4) {
         System.err.println(var4);
      }

   }

   public void TEST(int i, ProActiveConfModel proModel) {
      try {
         String fileName = "d:\\temp\\OPCOS.csv";
         FileWriter fstream = new FileWriter(fileName);
         BufferedWriter out = new BufferedWriter(fstream);
         ChannelExec execChannel1 = (ChannelExec)this.getChannel("billadm", "Bill_Adm123", "10.230.91.196");
         String summary = this.excuteCommand(execChannel1, "cat /usr/home/billadm/support/Bassem/sssssssssssssssssssssssssssssssssss.csv");
         this.closeChannel(execChannel1);
         out.write(summary);
         out.close();
         SendMailUtil sendMaile = new SendMailUtil();
         sendMaile.sendWfxMail("Dears,\n attached the failed HTTP requests to CI", fileName, "Flex Family HTTP Requests", "fady.adel-attallah@localhost.com");
      } catch (Exception var9) {
         System.err.println(var9);
      }

   }

   public void notifyToRunFOH(ProActiveConfModel proModel) {
      String message = "Kindly rememeber to run FOH today twice.";
      SendMailUtil sendMaile = new SendMailUtil();
      sendMaile.sendMail(message, (String)null, "FOH Notification", proModel.getMails());
      sendSMSToSupport(message);
   }

   public Channel getChannel(String user, String pass, String host) {
      Channel channel = null;

      try {
         Properties config = new Properties();
         config.put("StrictHostKeyChecking", "no");
         JSch jsch = new JSch();
         Session session = jsch.getSession(user, host, 22);
         session.setPassword(pass);
         session.setConfig(config);
         session.connect();
         channel = session.openChannel("exec");
      } catch (JSchException var8) {
         System.err.println("sftp exception : " + var8.getMessage());
      }

      return channel;
   }

   public String excuteCommand(ChannelExec execChannel, String command) {
      StringBuilder output = new StringBuilder();

      try {
         InputStream in = null;
         execChannel.setCommand(command);
         System.out.println("excuting command : " + command);
         execChannel.setInputStream((InputStream)null);
         in = execChannel.getInputStream();
         execChannel.connect();
         byte[] tmp = new byte[1024];

         while(true) {
            while(true) {
               if (in.available() > 0) {
                  int i = in.read(tmp, 0, 1024);
                  if (i >= 0) {
                     String out = new String(tmp, 0, i);
                     output.append(out);
                     continue;
                  }
               }

               if (execChannel.isClosed()) {
                  return output.toString().trim();
               }

               try {
                  Thread.sleep(500L);
               } catch (InterruptedException var14) {
                  System.err.println("InterruptedException : " + var14.getMessage());
               }
            }
         }
      } catch (IOException var15) {
         System.err.println("IOExpection : " + var15.getMessage());
      } catch (JSchException var16) {
         System.err.println("JSchException : " + var16.getMessage());
      } catch (Exception var17) {
         System.err.println("Exception : " + var17.getMessage());
      } finally {
         execChannel.disconnect();
      }

      return output.toString().trim();
   }

   public void closeChannel(Channel channel) {
      if (channel != null) {
         channel.disconnect();

         try {
            channel.getSession().disconnect();
         } catch (JSchException var3) {
            System.err.println("session can't be disconnected with exception : " + var3.getMessage());
         }

         System.out.println("session disconnected");
      }

   }

   public Set checkAssignedSrs(ProActiveConfModel proModel, Set checkAssignedSrs) {
      List temp = new ArrayList();
      String message = "";
      String sms = "";
      int count = 0;

      try {
         Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
         Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@10.230.91.206:1525:SIEBPRD2", "CCHelpDesk", "CCHelpDesk_123");
         conn.setAutoCommit(true);
         PreparedStatement ps = conn.prepareStatement("SELECT a.SR_NUM, a.SR_SUB_AREA, b.X_SR_GEN4,b.X_SR_GEN5,b.X_SR_GEN6, a.DESC_TEXT, a.X_VFCC_OWNER_COMMENT, a.ACT_OPEN_DT FROM s_srv_req a, S_SRV_REQ_X b WHERE a.bu_id    = '1-AA7NE' AND a.sr_stat_id = 'Assigned' and a.row_id = b.row_id AND TRUNC(a.created) BETWEEN TRUNC(sysdate-3) AND TRUNC(sysdate) order by a.ACT_OPEN_DT");
         ResultSet rs = ps.executeQuery();
         System.out.println("Contained SRs : " + Arrays.toString(checkAssignedSrs.toArray()));

         while(rs.next()) {
            if (!checkAssignedSrs.contains(rs.getString("SR_NUM"))) {
               ++count;
               message = message + rs.getString("SR_NUM") + "||" + rs.getString("SR_SUB_AREA") + "||" + rs.getString("X_SR_GEN4") + "||" + rs.getString("X_SR_GEN5") + "||" + rs.getString("X_SR_GEN6") + "||" + rs.getString("DESC_TEXT") + "||" + rs.getString("X_VFCC_OWNER_COMMENT") + "||" + rs.getString("ACT_OPEN_DT") + "\r\n";
               sms = sms + rs.getString("SR_NUM") + "," + rs.getString("SR_SUB_AREA") + "," + rs.getString("ACT_OPEN_DT") + "\r\n";
            }

            temp.add(rs.getString("SR_NUM"));
            System.out.println("Fetched SR : " + rs.getString("SR_NUM"));
         }

         checkAssignedSrs.clear();
         checkAssignedSrs.addAll(temp);
         if (!message.isEmpty()) {
            message = "SR Count (" + count + ")\r\n" + message;
            sms = "SR Count (" + count + ")\r\n" + sms;
            sendSMSToSupport(sms);
            String mailContent = "Dears,\r\n Kindly Check New Assigned SRs \r\n" + message;
            String mailRecepts = proModel.getMails().replaceAll("TechIT-DCOperations@voda.com;", "");
            SendMailUtil sendMaile = new SendMailUtil();
            sendMaile.sendMail(mailContent, (String)null, "Proactive - Assign SRs", mailRecepts);
         }

         conn.close();
      } catch (Exception var13) {
         var13.printStackTrace();
      }

      return checkAssignedSrs;
   }

   public void monitorBillProcessFlow_wfx(Connection con, int i, ProActiveConfModel proModel) {
      try {
         String message = "";
         ResultSet rs = monitorBchProcess_wfx.executeQuery();

         while(rs.next()) {
            int count = rs.getInt("SUMERROR");
            if (count > 0) {
               message = message + "Kindly check number of failed requests of bill process flow in last 5 mins is " + count;
               sendWfxMainSMS(message);
               SendMailUtil sendMaile = new SendMailUtil();
               sendMaile.sendWfxMail(message, (String)null, "Bill Process Monitor", proModel.getMails());
            }
         }
      } catch (SQLException var8) {
         System.err.println("we have a sql exception " + var8.toString());
         String message = "CRITICAL-We are facing connectivity problem with billing DB (" + var8.toString() + "), please check";
         sendSMSToSupport(message);
         System.err.println("After sending sms");
      } catch (Exception var9) {
         System.err.println("Exception " + var9.toString());
      }

   }

   public static int checkCMSAdapter_StartupStatus_wfx(Connection con, int maxReached, ProActiveConfModel proModel) {
      if (proModel.getMonStartUp().equals("null")) {
         return maxReached;
      } else {
         try {
            System.out.println("max reached today is : " + maxReached);
            ResultSet rs = startupStatus_wfx.executeQuery();

            while(rs.next()) {
               int countErrors = rs.getInt("SUMERROR");
               System.out.println("check error count is : " + countErrors);
               if (countErrors >= 20) {
                  int count_all = getWfxDailyCount(con);
                  String mailContent = "Dears,\n please take care number of failures are huge (" + countErrors + " failed transaction in last 10 minutes) of " + count_all + " failed transaction today, please restart ASSET CMS Adapter or contact online team\n\r BR,\n\r CMS Adaptor admin";
                  System.out.println("failure found , mail will be sent");
                  maxReached = countErrors;
                  SendMailUtil sendMaile = new SendMailUtil();
                  sendMaile.sendWfxMail(mailContent, (String)null, "CMS Adapter Down", proModel.getMails());
                  System.out.println("Main started");
                  String message = "CRITICAL - CMS adapter facing problems - TIME OUT (" + countErrors + "), please check errors 302,304 urgently";
                  sendWfxMainSMS(message);
                  System.out.println("After sending sms");
                  if (countErrors >= 100) {
                     CMSAdapterListener cmsListener = new CMSAdapterListener();
                     cmsListener.pushInfoToGlobalSystem_replica("2", "CMS Adapter status", String.valueOf(countErrors));
                  }
               } else {
                  CMSAdapterListener cmsListener = new CMSAdapterListener();
                  cmsListener.pushInfoToGlobalSystem_replica("2", "CMS Adapter status", String.valueOf(0));
               }
            }

            con.commit();
         } catch (SQLException var10) {
            System.err.println("we have a sql exception " + var10.toString());
            String message = "CRITICAL-We are facing connectivity problem with billing DB, please check";
            sendWfxMainSMS(message);
            System.err.println("After sending sms");
            DBProblemMailSender(var10, proModel);
         } catch (Exception var11) {
         }

         return maxReached;
      }
   }

   public static int getWfxDailyCount(Connection con) {
      int dailyCount = 0;

      try {
         ResultSet rs = startupStatusDay_wfx.executeQuery();

         while(rs.next()) {
            dailyCount = rs.getInt("SUMERROR");
            System.out.println("Daily count error is : " + dailyCount);
         }

         con.commit();
      } catch (Exception var3) {
      }

      return dailyCount;
   }

   public static int checkBillingFailure_wfx(Connection con, int maxReached, ProActiveConfModel proModel) {
      if (proModel.getMonStartUp().equals("null")) {
         return maxReached;
      } else {
         try {
            System.out.println("max reached today is : " + maxReached);
            ResultSet rs = monitorBillingFailure_wfx.executeQuery();

            while(rs.next()) {
               int countErrors = rs.getInt("SUMERROR");
               System.out.println("check error count is : " + countErrors);
               if (countErrors >= 50) {
                  int count_all = getWfxDailyCount(con);
                  String mailContent = "Dears,\n please take care CMS SERVER is down, count of failures is (" + count_all + "), please restart E/// CMS server urgently or contact online team\n\r BR,\n\r CMS Adaptor admin";
                  System.out.println("failure found , mail will be sent");
                  maxReached = countErrors;
                  SendMailUtil sendMaile = new SendMailUtil();
                  sendMaile.sendWfxMail(mailContent, (String)null, "CMS Server Down", proModel.getMails());
                  System.out.println("Main started");
                  String message = "Number of errors exceeded " + countErrors + " please check";
                  sendSMSToSupport(message);
                  System.out.println("After sending sms");
                  CMSAdapterListener cmsListener = new CMSAdapterListener();
                  cmsListener.pushInfoToGlobalSystem_replica("1", "CMS Server status", "1");
               } else {
                  CMSAdapterListener cmsListener = new CMSAdapterListener();
                  cmsListener.pushInfoToGlobalSystem_replica("1", "CMS Server status", "0");
               }
            }

            con.commit();
         } catch (SQLException var10) {
            System.err.println("we have a sql exception " + var10.toString());
            String message = "CRITICAL-We are facing connectivity problem with billing DB, please check";
            sendSMSToSupport(message);
            System.err.println("After sending sms");
            DBProblemMailSender(var10, proModel);
         } catch (Exception var11) {
         }

         return maxReached;
      }
   }

   public static int checkBillingConnectionFailure_wfx(Connection con, int maxReached, ProActiveConfModel proModel) {
      if (proModel.getMonStartUp().equals("null")) {
         return maxReached;
      } else {
         try {
            System.out.println("max reached today is : " + maxReached);
            ResultSet rs = monitorBillingConFailure_wfx.executeQuery();

            int countErrors;
            String message;
            while(rs.next()) {
                countErrors = rs.getInt("SUMERROR");
               System.out.println("check error count is : " + countErrors);
               if (countErrors >= 20) {
                  countErrors = getWfxDailyCount(con);
                  message = "Dears,\n please take care CMS SERVER have a restart problem, TOPLINK error increasing, count of failures is (" + countErrors + ") in last 5 minutes, please refresh E/// CMS server urgently or contact online team\n\r BR,\n\r CMS Adaptor admin";
                  System.out.println("failure found , mail will be sent");
                  maxReached = countErrors;
                  SendMailUtil sendMaile = new SendMailUtil();
                  sendMaile.sendWfxMail(message, (String)null, "CMS Server Down", proModel.getMails());
                  System.out.println("Main started");
                   message = "CRITICAL - CMS SERVER have a restart problem, TOPLINK error increasing, please check urgently.";
                  sendWfxMainSMS(message);
                  System.out.println("After sending sms");
               }
            }

            ResultSet rs2 = inconsistMon_wfx.executeQuery();

            while(rs2.next()) {
               countErrors = rs2.getInt("SUMERROR");
               System.out.println("check error count is : " + countErrors);
               if (countErrors >= 50) {
                  System.out.println("Main started");
                  message = "CRITICAL [New]- We are facing DB inconsistency errors, Number of errors in last 5 mints (" + countErrors + "),  please check urgently.";
                  sendWfxMainSMS(message);
                  System.out.println("After sending sms");
               }

               ResultSet rs3 = processBusyMon_wfx.executeQuery();

               while(rs3.next()) {
                  countErrors = rs3.getInt("SUMERROR");
                  System.out.println("check error count is : " + countErrors);
                  if (countErrors >= 10) {
                     System.out.println("Main started");
                      message = "CRITICAL [New]- We are facing process busy issue, Number of errors in last 5 mints (" + countErrors + "),  please check urgently.";
                     sendWfxMainSMS(message);
                     System.out.println("After sending sms");
                  }
               }
            }

            con.commit();
         } catch (SQLException var9) {
            System.err.println("we have a sql exception " + var9.toString());
            String message = "CRITICAL-We are facing connectivity problem with billing DB (" + var9.toString() + "), please check";
            sendWfxMainSMS(message);
            System.out.println("After sending sms");
            DBProblemMailSender(var9, proModel);
         } catch (Exception var10) {
         }

         return maxReached;
      }
   }

   public static Vector checkCMSAdapter_MonitorPerformance_wfx(Connection con, int maxReached, Vector commandsStatus, ProActiveConfModel proModel) {
      Vector newCheckVec = new Vector();
      if (proModel.getMonPerformance().equals("null")) {
         return commandsStatus;
      } else {
         try {
            System.out.println("max reached today is : " + maxReached);
            String outputWorkflows = "";
            boolean performance_issue_Found = false;
            boolean caseFound = false;
            ResultSet rs = monitorPerformance_wfx.executeQuery();

            while(true) {
               String flowName;
               while(rs.next()) {
                  int time = rs.getInt("EXECUTION_TIME");
                  flowName = rs.getString("WORKFLOW");
                  int replyCode = rs.getInt("REPLY_CODE");
                  String valToVector;
                  if (commandsStatus.size() > 0) {
                     for(int i = 0; i < commandsStatus.size(); ++i) {
                        if (commandsStatus.get(i).toString().indexOf(flowName) != -1) {
                           String[] vecVal = commandsStatus.get(i).toString().split(";");
                           if (time > Integer.parseInt(vecVal[1])) {
                              caseFound = true;
                              performance_issue_Found = true;
                              outputWorkflows = outputWorkflows + "\n " + vecVal[0] + " - " + vecVal[1];
                              if (replyCode == 304) {
                                 outputWorkflows = outputWorkflows + "- Timed out";
                              }

                               valToVector = flowName + ";" + time;
                              newCheckVec.add(valToVector);
                           } else {
                              caseFound = true;
                           }
                        }
                     }

                     if (!caseFound && time >= 10000) {
                        performance_issue_Found = true;
                        outputWorkflows = outputWorkflows + "\n " + flowName + " - " + time;
                        if (replyCode == 304) {
                           outputWorkflows = outputWorkflows + "- Timed out";
                        }

                        valToVector = flowName + ";" + time;
                        newCheckVec.add(valToVector);
                     }
                  } else if (time >= 10000) {
                     performance_issue_Found = true;
                     outputWorkflows = outputWorkflows + "\n " + flowName + " - " + time;
                     if (replyCode == 304) {
                        outputWorkflows = outputWorkflows + "- Timed out";
                     }

                     valToVector = flowName + ";" + time;
                     newCheckVec.add(valToVector);
                  }
               }

               con.commit();
               if (performance_issue_Found) {
                  String mailContent = "Dears,\n please take care There are some commands taking huge execution time, this may lead to CMS adapter down,please find the following\n" + outputWorkflows + ",\n please check ASSET CMS Adapter or contact online team\n\r BR,\n\r CMS Adaptor admin";
                  System.out.println("failure found , mail will be sent");
                  flowName = proModel.getMails().replaceAll("TechIT-DCOperations@voda.com;", "");
                  System.out.println("mailsRecpts are : " + flowName);
                  SendMailUtil sendMaile = new SendMailUtil();
                  sendMaile.sendWfxMail(mailContent, (String)null, "CMS Adapter commands performance alert", flowName);
               } else {
                  newCheckVec = commandsStatus;
               }
               break;
            }
         } catch (SQLException var15) {
            System.err.println("we have a sql exception " + var15.toString());
            String message = "CRITICAL-We are facing connectivity problem with billing DB (" + var15.toString() + "), please check";
            sendSMSToSupport(message);
            System.err.println("After sending sms");
         } catch (Exception var16) {
         }

         return newCheckVec;
      }
   }

   public static int checkCMSAdapter_MonitorTraffic_wfx(Connection con, int maxReached, ProActiveConfModel proModel) {
      if (proModel.getMonTraffic().equals("null")) {
         return maxReached;
      } else {
         try {
            System.out.println("max reached today is : " + maxReached);
            ResultSet rs = monitorTraffic_wfx.executeQuery();
            ResultSet rs_39 = monitorTraffic_M39_wfx.executeQuery();
            ResultSet rs_40 = monitorTraffic_M40_wfx.executeQuery();

            int count_40;
            String message;
            while(rs.next()) {
               int countSpace = rs.getInt("SUMTRAFC");
               System.out.println("Available traffic is " + countSpace);
               Date now = new Date();
               count_40 = now.getHours();
               int minutesNow = now.getMinutes();
               new CMSAdapterListener();
               if (countSpace <= 2000 && count_40 >= 9) {
                  message = "Dears,\n please take care It is a very low traffic in last 5 minutes (" + countSpace + " transaction) only recieved, please validate\n\r BR,\n\r CMS Adaptor admin";
                  System.out.println("failure found , mail will be sent");
                  maxReached = countSpace;
                  SendMailUtil sendMaile = new SendMailUtil();
                  sendMaile.sendWfxMail(message, (String)null, "CMS Adapter low traffic alert", proModel.getMails());
                  System.out.println("Main started");
                   message = "We are receiving very Low traffic, please check";
                  sendWfxMainSMS(message);
                  System.out.println("After sending sms");
               }
            }

            SendMailUtil sendMaile;
            Date now;
            int hoursNow;
            String mailContent;
            while(rs_39.next()) {
               now = new Date();
               hoursNow = now.getHours();
               count_40 = rs_39.getInt("SUMTRAFC_39");
               if (count_40 < 1000 && hoursNow >= 8) {
                  mailContent = "Dears,\n please take care It is a very low traffic in last 5 minutes (" + count_40 + " transaction) only recieved, please validate\n\r BR,\n\r CMS Adaptor admin";
                  sendMaile = new SendMailUtil();
                  sendMaile.sendWfxMail(mailContent, (String)null, "CMS Adapter low traffic alert", proModel.getMails());
                  System.out.println("Main started");
                  message = "We are receiving  Low traffic on M/C 39 , count=" + count_40 + ", please check";
                  sendWfxMainSMS(message);
                  System.out.println("After sending sms");
               }
            }

            while(rs_40.next()) {
               now = new Date();
               hoursNow = now.getHours();
               count_40 = rs_40.getInt("SUMTRAFC_40");
               if (count_40 < 1000 && hoursNow >= 8) {
                  mailContent = "Dears,\n please take care It is a very low traffic in last 5 minutes (" + count_40 + " transaction) only recieved, please validate\n\r BR,\n\r CMS Adaptor admin";
                  sendMaile = new SendMailUtil();
                  sendMaile.sendWfxMail(mailContent, (String)null, "CMS Adapter low traffic alert", proModel.getMails());
                  System.out.println("Main started");
                  message = "We are receiving  Low traffic on M/C 40 , count=" + count_40 + ", please check";
                  sendWfxMainSMS(message);
                  System.out.println("After sending sms");
               }
            }

            con.commit();
         } catch (SQLException var14) {
            System.err.println("we have a sql exception " + var14.toString());
            String message = "CRITICAL-We are facing connectivity problem with billing DB, please check";
            sendSMSToSupport(message);
            System.err.println("After sending sms");
            message = "CRITICAL-We are facing connectivity problem with billing DB (" + var14.toString() + "), please check";
            sendSMSToSupport(message);
            System.err.println("After sending sms");
         } catch (Exception var15) {
            System.err.println("Exception " + var15.toString());
         }

         return maxReached;
      }
   }

   public static int checkCMSAdapter_MonitorTrafficClosely_wfx(Connection con, int maxReached, ProActiveConfModel proModel) {
      String mailContent = "";
      Vector contentVec = new Vector();
      Vector numTransVec = new Vector();
      int totalTrafficCounter = 0;
      int readCustomerContrAvgExecTime = 0;
      int readCustomerContrLightAvgExecTime = 0;
      int searchContractAvgExecTime = 0;
      int takeoverExecutionTime = 0;

      try {
         System.out.println("Will check 5 minutes traffic status");
         Date startExecutionDate = new Date();
         ResultSet rs = monitorTrafficClos_wfx.executeQuery();
         Date endExecutionDate = new Date();
         long msElapsedTime = endExecutionDate.getTime() - startExecutionDate.getTime();
         System.out.println("Execution time is : " + msElapsedTime);
         String fileName;
         if (msElapsedTime > 10000L) {
            fileName = "We are facing execution time (> 10sec) increase in inquire billing DB, please check";
            sendWfxMainSMS(fileName);
            System.out.println("After sending sms");
         }

         while(rs.next()) {
            int numOfTransactions = rs.getInt("NumGreat4Sec");
            totalTrafficCounter += numOfTransactions;
            String flowName = rs.getString("flow_name");
            int maxExecutionTime = rs.getInt("maxTime");
            double avgExecutionTime = rs.getDouble("AverageExecutionTime");
            if (flowName.equals("ReadCustomerContract")) {
               readCustomerContrAvgExecTime = (int)avgExecutionTime;
            }

            if (flowName.equals("ReadCustomerContractLight")) {
               readCustomerContrLightAvgExecTime = (int)avgExecutionTime;
            }

            if (flowName.equals("SearchContract")) {
               searchContractAvgExecTime = (int)avgExecutionTime;
            }

            System.out.println("Retrieved data are : " + numOfTransactions + "-" + flowName + "-" + maxExecutionTime + ";");
            mailContent = numOfTransactions + "," + flowName + "," + maxExecutionTime + "," + avgExecutionTime;
            contentVec.add(mailContent);
            monitorNumOfTransactions_wfx.setString(1, flowName);
            ResultSet rs2 = monitorNumOfTransactions_wfx.executeQuery();

            while(rs2.next()) {
               int countOfTransactions = rs2.getInt("interfaceCount");
               numTransVec.add(countOfTransactions);
            }
         }

         con.commit();
         fileName = "d:\\temp\\status_wfx.csv";
         FileWriter fstream = new FileWriter(fileName);
         BufferedWriter out = new BufferedWriter(fstream);
         out.write("Total Number Of transactions,Workflow name,Max transaction time,Average Execution Time,Number of transactions greater than 6 seconds\n");

         for(int i = 0; i < contentVec.size(); ++i) {
            String attachmentmailContent = contentVec.get(i).toString() + "," + numTransVec.get(i) + "\n";
            out.write(attachmentmailContent);
         }

         out.close();
         String contents = "Dear, \n\r please find attached status of interfaces execeded 4 seconds in last 5 mintures. \n\r BR,\n\r CMS Adapter Admin";
         SendMailUtil sendMaile = new SendMailUtil();
         sendMaile.sendSpecificMail(contents, fileName, "CMS Adapter status", (String)null);
         System.out.println("total traffic counter is : " + totalTrafficCounter);
         System.out.println("read custoemr contract average time : " + searchContractAvgExecTime);
         CMSAdapterListener cmsListener = new CMSAdapterListener();
         cmsListener.pushInfoToGlobalSystem_replica("4", "Online transactions execution time", String.valueOf(searchContractAvgExecTime));
         cmsListener = new CMSAdapterListener();
         cmsListener.pushInfoToGlobalSystem_replica("5", "Tabel Space Status", String.valueOf(10));
         String message;
         if (searchContractAvgExecTime >= 1200 || readCustomerContrLightAvgExecTime >= 1200) {
            System.out.println("Main started");
            message = "Take care ReadCustomerContract and SearchContract average time exceeded 1.2 Sec -" + readCustomerContrLightAvgExecTime + " - " + searchContractAvgExecTime + " ,please check.";
            sendWfxMainSMS(message);
            System.out.println("After sending sms");

            try {
               mailContent = "Take care ReadCustomerContract and SearchContract average time exceeded 1.2 Sec -" + readCustomerContrLightAvgExecTime + " - " + searchContractAvgExecTime + " ,please check.";
               sendMaile = new SendMailUtil();
               message = proModel.getMails().replaceAll("TechIT-DCOperations@voda.com;", "");
               sendMaile.sendWfxMail(mailContent, (String)null, "[CRITICAL] - ReadCustomerContract interface", message);
               System.out.println("mail sent");
            } catch (Exception var25) {
               System.err.println("Exception in sendin mail of Read customer Contract " + var25.toString());
            }

            if (searchContractAvgExecTime >= 6000 || readCustomerContrLightAvgExecTime >= 6000) {
               mailContent = "Take care ReadCustomerContractLight or SearchContract average time exceeded 6 Sec -" + readCustomerContrAvgExecTime + " ,please check.";
               sendMaile = new SendMailUtil();
               sendMaile.sendWfxMail(mailContent, (String)null, "[CRITICAL] - ReadCustomerContract interface", proModel.getMails());
               System.err.println("mail sent");
            }
         }

         System.out.println("Will execute the new takeover monitor");
         dynamicMonitoringWF_wfx.setString(1, "ContractTakeOverNewFinal");
         ResultSet TO_RS = dynamicMonitoringWF_wfx.executeQuery();

         while(TO_RS.next()) {
            double avgExecutionTime = TO_RS.getDouble("AverageExecutionTime");
            takeoverExecutionTime = (int)avgExecutionTime;
            System.out.println("Takeover average execution time : " + takeoverExecutionTime);
         }

         if (takeoverExecutionTime >= 12000) {
            System.out.println("Main started");
            message = "Take care Takeover interface average execution time exceeded 12 Sec -" + takeoverExecutionTime + " ,please check.";
            sendWfxMainSMS(message);
            System.out.println("After sending sms");
            System.out.println("Duplicates found , mail will be sent");
            String mailRecepts = proModel.getMails().replaceAll("TechIT-DCOperations@voda.com;", "");
            mailContent = "Take care Takeover interface average execution time exceeded 12 Sec -" + takeoverExecutionTime + " ,please check.";
            sendMaile = new SendMailUtil();
            sendMaile.sendWfxMail(mailContent, (String)null, "Proactive - Takeover issue", mailRecepts);
            if (takeoverExecutionTime >= 90000) {
               mailContent = "Take care Takeover interface average execution time exceeded 12 Sec -" + takeoverExecutionTime + " ,please check.";
               sendMaile = new SendMailUtil();
               sendMaile.sendWfxMail(mailContent, (String)null, "[CRITICAL] - Takeover interface interface", proModel.getMails());
               System.out.println("mail sent");
            }
         }
      } catch (SQLException var26) {
         System.err.println("we have a sql exception " + var26.toString());
         String message = "CRITICAL-We are facing connectivity problem with billing DB (" + var26.toString() + "), please check";
         sendWfxMainSMS(message);
         System.err.println("After sending sms");
      } catch (Exception var27) {
         System.err.println("Exception " + var27.toString());
      }

      return maxReached;
   }

   public static int checkPaymentFailures_wfx(Connection con, int maxReached, ProActiveConfModel proModel) {
      if (proModel.getMonStartUp().equals("null")) {
         return maxReached;
      } else {
         try {
            System.out.println("max reached today is : " + maxReached);
            ResultSet rs = monitorPaymentFailure_wfx.executeQuery();

            while(rs.next()) {
               int countErrors = rs.getInt("SUMERROR");
               System.out.println("check error count is : " + countErrors);
               if (countErrors >= 20) {
                  int count_all = getWfxDailyCount(con);
                  String mailContent = "Dears,\n please take care BillSRV is down, count of failures is (" + count_all + "), Please check billsrv instance or contact online team\n\r BR,\n\r CMS Adaptor admin";
                  System.out.println("failure found , mail will be sent");
                  maxReached = countErrors;
                  SendMailUtil sendMaile = new SendMailUtil();
                  sendMaile.sendMail(mailContent, (String)null, "BILLSRV Down", proModel.getMails());
                  System.out.println("Main started");
                  String message = "Payments facing problems, Please check BILLSRV instance urgently";
                  sendSMSToSupport(message);
                  System.out.println("After sending sms");
                  if (countErrors >= 40) {
                     CMSAdapterListener cmsListen = new CMSAdapterListener();
                     cmsListen.pushInfoToGlobalSystem_replica("6", "Online Payments status", String.valueOf(1));
                  }
               } else {
                  CMSAdapterListener cmsListen = new CMSAdapterListener();
                  cmsListen.pushInfoToGlobalSystem_replica("6", "Online Payments status", String.valueOf(0));
               }
            }

            con.commit();
         } catch (SQLException var10) {
            System.err.println("we have a sql exception " + var10.toString());
            String message = "CRITICAL-We are facing connectivity problem with billing DB, please check";
            sendWfxMainSMS(message);
            System.err.println("After sending sms");
         } catch (Exception var11) {
         }

         return maxReached;
      }
   }

   public static int checkCMSAdapter_FreeConnections_wfx(Connection con, int maxReached, ProActiveConfModel proModel) {
      try {
         String impactedUsers = "";

         String message;
         for(ResultSet rs2 = startupStatus_client_wfx.executeQuery(); rs2.next(); impactedUsers = impactedUsers + message + "\n") {
            message = rs2.getString("USERNAME");
            int countErrors = rs2.getInt("SUMVAL");
            System.out.println("check of connection error count is : " + countErrors);
         }

         if (!impactedUsers.equals("")) {
            System.out.println("Main started");
            message = "CMS adapter : Please adjust number of connections for the below users (error-303) before next restart:" + impactedUsers;
            sendWfxMainSMS(message);
            System.out.println("After sending sms");
         }
      } catch (Exception var7) {
         System.err.println("Exception in free connection messsage : " + var7.toString());
      }

      return 0;
   }

   public static int checkCMSAdapter_MonitorAdapterHourly_wfx(Connection con, ProActiveConfModel proModel) {
      try {
         ResultSet rs = monitorAdapterOverallExc_wfx.executeQuery();

         while(rs.next()) {
            int avgExecTime = rs.getInt("AVG_EXC");
            int totalTraffic = rs.getInt("SUMTRAFFIC");
            float numberOfRequestsPerSecond = (float)(totalTraffic / 60 / 60);
            System.out.println("Available traffic is " + totalTraffic);
            String mailRecepts = proModel.getMails().replaceAll("TechIT-DCOperations@voda.com;", "");
            String mailContent = "[Adapter Hourly Report] \nIn last hour we received : " + totalTraffic + " transaction \n Average execution time is " + avgExecTime + " ms \n number of requests per second is :  " + numberOfRequestsPerSecond + " request \n Check your mail for more details";
            SendMailUtil sendMaile = new SendMailUtil();
            sendMaile.sendWfxMail(mailContent, (String)null, "Proactive - Adapter Hourly Report", mailRecepts);
            if (avgExecTime > 800) {
               System.out.println("Main started");
               String message = "[Execution Time Increase] \nIn last hour we received : " + totalTraffic + " transaction \n Average execution time is " + avgExecTime + " ms \n number of requests per second is :  " + numberOfRequestsPerSecond + " request \n Check your mail for more details";
               sendWfxMainSMS(message);
               System.out.println("After sending sms");
            }
         }

         con.commit();
      } catch (SQLException var10) {
      } catch (Exception var11) {
         System.err.println("Exception " + var11.toString());
      }

      return 0;
   }

   public static int monitorOfflineEngineErrorsFunc_wfx(Connection con, int maxReached, ProActiveConfModel proModel) {
      try {
         ResultSet rs = monitroOfflineEngError_wfx.executeQuery();

         String urlInfo;
         String requestDetails;
         for(urlInfo = ""; rs.next(); urlInfo = urlInfo + "http://10.230.91.39:7001/CMS_HTTP_TEST/DoSimpleRequest?&tibcoTrackingId=null&" + requestDetails + "\n") {
            int request_id = rs.getInt("request_id");
            requestDetails = rs.getString("Input_Parameters");
         }

         if (!urlInfo.equals("")) {
            String mailContent = "Dears,\n please take care We have the below failed URL \n" + urlInfo + "BR,\n\r CMS Adaptor admin";
            System.out.println("locking found , mail will be sent");
            SendMailUtil sendMaile = new SendMailUtil();
            sendMaile.sendWfxMail(mailContent, (String)null, "DB Engine Failures", proModel.getMails());
         }

         con.commit();
      } catch (SQLException var7) {
         System.err.println("exception in DB engine listener : " + var7.toString());
         DBProblemMailSender(var7, proModel);
      } catch (Exception var8) {
      }

      return maxReached;
   }

   public static void monitorCmsToCi_wfx(Connection con, ProActiveConfModel proModel) {
      ArrayList ar = new ArrayList();
      int count = 0;

      try {
         ResultSet rs = monitorCMSCIWriteFee_wfx.executeQuery();
         String mailContent;
         if (rs.isBeforeFirst()) {
            while(rs.next()) {
               mailContent = rs.getString("trans_id");
               ar.add(mailContent);
               ++count;
            }
         }

         rs = monitorCMSCIWriteCust_wfx.executeQuery();
         if (rs.isBeforeFirst()) {
            while(rs.next()) {
               mailContent = rs.getString("trans_id");
               ar.add(mailContent);
               ++count;
            }
         }

         mailContent = "Total Number Of CMStoCI failiures is: " + count + "\n";
         String fileName = "d:\\temp\\CMStoCI_wfx.csv";
         FileWriter fstream = new FileWriter(fileName);
         BufferedWriter out = new BufferedWriter(fstream);
         out.write(mailContent);

         for(int i = 0; i < ar.size(); ++i) {
            String attachmentmailContent = (String)ar.get(i) + "\n";
            out.write(attachmentmailContent);
         }

         out.close();
         System.out.println("\nCMSTOCI check is done, sms and mail should be sent.");
         String message = "Please check your mail for CMStoCI Failures for yesterday...";
         if (count > 15) {
            sendWfxMainSMS("CRITICAL: CMStoCI Failures for yesterday exceeded 15 TXNs,count is: " + count + " Please check you mail urgently...");
         } else {
            sendWfxMainSMS(message + "Count is: " + count);
         }

         System.out.println("\nCMSTOCI sms sent , will send mail now..");
         SendMailUtil sendMail = new SendMailUtil();
         sendMail.sendWfxMail(mailContent, fileName, "CMStoCI Failures", proModel.getMails());
         System.out.println("\nCMSTOCI mail sent");
      } catch (SQLException var11) {
         var11.printStackTrace();
      } catch (IOException var12) {
         System.out.println("Failed to Open /Create file.");
      }

   }

   public void monitorAdapter_wfx(Connection con, int i, ProActiveConfModel proModel) {
      try {
         String message = "";
         ResultSet rs = monitorAdapter_wfx.executeQuery();

         while(rs.next()) {
            int interfaceId = rs.getInt("INTERFACE_ID");
            int coreId = rs.getInt("CORE_ID");
            float errorNoAvailableConn = (float)rs.getInt("NO_AVAILABLE_CONN");
            float successRate = rs.getFloat("SUCCESS_RATE");
            float errorRate509999 = rs.getFloat("509999");
            float errorRateUnkownBillComm = rs.getFloat("UNKOWN_BILL_COM");
            float errorRateBillCommFail = rs.getFloat("BILL_COM_FAIL");
            float errorRateTimeOut = rs.getFloat("TIME_OUT");
            float errorRateNoFreeRequests = rs.getFloat("NO_FREE_REQUESTS");
            float errorRateNoFreeThreads = rs.getFloat("NO_FREE_THREADS");
            System.out.println("Success Rate of interfaceId : " + interfaceId + ", coreId : " + coreId + " is " + successRate + "%");
            if (interfaceId != 5 && interfaceId != 7 && interfaceId != 3 && interfaceId != 10 && interfaceId != 6 && successRate < 70.0F || successRate < 50.0F) {
               message = message + "interface : " + interfaceId + ", core : " + coreId + ", success : " + successRate + "%\n";
               if (errorRate509999 != 0.0F || errorRateBillCommFail != 0.0F || errorRateUnkownBillComm != 0.0F || errorRateTimeOut != 0.0F || errorRateNoFreeRequests != 0.0F || errorRateNoFreeThreads != 0.0F || errorNoAvailableConn != 0.0F) {
                  message = message + "{";
                  if (errorRate509999 != 0.0F) {
                     message = message + "[509-:" + errorRate509999 + "]";
                  }

                  if (errorRateBillCommFail != 0.0F) {
                     message = message + "[BCF:" + errorRateBillCommFail + "]";
                  }

                  if (errorRateUnkownBillComm != 0.0F) {
                     message = message + "[UBC:" + errorRateUnkownBillComm + "]";
                  }

                  if (errorRateTimeOut != 0.0F) {
                     message = message + "[TO:" + errorRateTimeOut + "]";
                  }

                  if (errorRateNoFreeRequests != 0.0F) {
                     message = message + "[NFR:" + errorRateNoFreeRequests + "]";
                  }

                  if (errorRateNoFreeThreads != 0.0F) {
                     message = message + "[NFT:" + errorRateNoFreeThreads + "]";
                  }

                  if (errorNoAvailableConn != 0.0F) {
                     message = message + "[NAC:" + errorNoAvailableConn + "]";
                  }

                  message = message + "}\n";
               }
            }

            if (!message.isEmpty() && message.split("\n").length > 10) {
               sendWfxMainSMS(message);
               SendMailUtil sndSMS = new SendMailUtil();
               sndSMS.sendWfxMail(message + ", contact support team", (String)null, "Adapter Status Report", proModel.getMails());
               System.out.println("After sending sms");
               message = "";
            }
         }

         if (!message.isEmpty()) {
            sendWfxMainSMS(message);
         }
      } catch (SQLException var17) {
         System.err.println("we have a sql exception " + var17.toString());
         String message = "CRITICAL-We are facing connectivity problem with billing DB (" + var17.toString() + "), please check";
         sendSMSToSupport(message);
         System.err.println("After sending sms");
      } catch (Exception var18) {
         System.err.println("Exception " + var18.toString());
      }

   }

   public void monitorAdapterSystemUsers_wfx(Connection con, int i, ProActiveConfModel proModel) {
      try {
         String message = "";
         ResultSet rs = monitorSystemUsers_wfx.executeQuery();

         while(rs.next()) {
            int interfaceId = rs.getInt("INTERFACE_ID");
            int coreId = rs.getInt("CORE_ID");
            int total = rs.getInt("TOTAL");
            int accountProblem = rs.getInt("ACCOUNT_PROBLEM");
            int securityProblem = rs.getInt("SECURITY_PROBLEM");
            int loginProblem = rs.getInt("LOGIN_PROBLEM");
            System.out.println("Total Users Problem of interfaceId : " + interfaceId + ", coreId : " + coreId + " is " + total);
            if (total > 0) {
               message = message + "System users problem\n";
               message = message + "interface : " + interfaceId + ", core : " + coreId + ", total : " + total + "\n";
               message = message + "{";
               if (accountProblem != 0) {
                  message = message + "[account:" + accountProblem + "]";
               }

               if (securityProblem != 0) {
                  message = message + "[security:" + securityProblem + "]";
               }

               if (loginProblem != 0) {
                  message = message + "[login:" + loginProblem + "]";
               }

               message = message + "}\n";
            }

            if (!message.isEmpty() && message.split("\n").length > 15) {
               sendWfxMainSMS(message);
               System.out.println("After sending sms");
               message = "";
            }
         }

         if (!message.isEmpty()) {
            sendWfxMainSMS(message);
         }
      } catch (SQLException var12) {
         System.err.println("we have a sql exception " + var12.toString());
         String message = "CRITICAL-We are facing connectivity problem with billing DB (" + var12.toString() + "), please check";
         sendSMSToSupport(message);
         System.err.println("After sending sms");
      } catch (Exception var13) {
         System.err.println("Exception " + var13.toString());
      }

   }

   public void monitorAdapterNonSystemUsers_wfx(Connection con, int i, ProActiveConfModel proModel) {
      try {
         String message = "";
         ResultSet rs = monitorNonSystemUsers_wfx.executeQuery();

         while(rs.next()) {
            String username = rs.getString("USERNAME");
            int total = rs.getInt("TOTAL");
            int accountProblem = rs.getInt("ACCOUNT_PROBLEM");
            int securityProblem = rs.getInt("SECURITY_PROBLEM");
            int loginProblem = rs.getInt("LOGIN_PROBLEM");
            System.out.println("Total Users Problem of user : " + username + " is " + total);
            if (!"TEBCO".equals(username) || "TEBCO".equals(username) && total > 600) {
               message = message + "user : " + username + ", total : " + total + "\n";
               if (accountProblem != 0 || securityProblem != 0 || loginProblem != 0) {
                  message = message + "{";
                  if (accountProblem != 0) {
                     message = message + "[account:" + accountProblem + "]";
                  }

                  if (securityProblem != 0) {
                     message = message + "[security:" + securityProblem + "]";
                  }

                  if (loginProblem != 0) {
                     message = message + "[login:" + loginProblem + "]";
                  }

                  message = message + "}\n";
               }
            }

            if (!message.isEmpty() && message.split("\n").length > 10) {
               SendMailUtil sndSMS = new SendMailUtil();
               sndSMS.sendWfxMail(message, (String)null, "SMS Replacement", proModel.getMails());
               System.out.println("After sending sms");
               message = "";
            }
         }

         if (!message.isEmpty()) {
            SendMailUtil sndSMS = new SendMailUtil();
            sndSMS.sendWfxMail(message, (String)null, "SMS Replacement", proModel.getMails());
         }
      } catch (SQLException var12) {
         System.err.println("we have a sql exception " + var12.toString());
         String message = "CRITICAL-We are facing connectivity problem with billing DB (" + var12.toString() + "), please check";
         sendSMSToSupport(message);
         System.err.println("After sending sms");
      } catch (Exception var13) {
         System.err.println("Exception " + var13.toString());
      }

   }

   public void checkRunningBatches_wfx(Connection con, int i, ProActiveConfModel proModel) {
      try {
         String message = "";

         int jobId;
         String success;
         for(ResultSet rs = monitorRunningBatches.executeQuery(); rs.next(); message = message + "JobId : " + jobId + "\t Success : " + success + "\n") {
            jobId = rs.getInt("JOB_ID");
            success = rs.getString("SUCCESS");
         }

         if (!message.isEmpty()) {
            ResultSet rs2 = getRunningBatchesCount30_wfx.executeQuery();

            int count;
            for(count = 0; rs2.next(); count = rs2.getInt("COUNT")) {
            }

            message = message + "number of requests in last 30 mins is " + count;
            sendSMSToSupport(message);
            SendMailUtil sendMaile = new SendMailUtil();
            sendMaile.sendWfxMail(message, (String)null, "Batch Activiation Tool", proModel.getMails());
         }
      } catch (SQLException var9) {
         System.err.println("we have a sql exception " + var9.toString());
         String message = "CRITICAL-We are facing connectivity problem with billing DB (" + var9.toString() + "), please check";
         sendSMSToSupport(message);
         System.err.println("After sending sms");
      } catch (Exception var10) {
         System.err.println("Exception " + var10.toString());
      }

   }

   public void monitorRunningBatches_wfx(Connection con, int i, ProActiveConfModel proModel) {
      try {
         String message = "";
         boolean found = false;

         for(ResultSet rs0 = monitorRunningBatches.executeQuery(); rs0.next(); found = true) {
         }

         if (found) {
            ResultSet rs = getRunningBatchesCount5_wfx.executeQuery();

            while(true) {
               int count;
               float successRate;
               do {
                  if (!rs.next()) {
                     return;
                  }

                  count = rs.getInt("COUNT");
                  successRate = (float)rs.getInt("SUCCESS_RATE");
               } while(successRate >= 70.0F && count >= 500);

               message = message + "Kindly check number of requests in last 5 mins is " + count + " and success rate is " + successRate + " %";
               sendSMSToSupport(message);
               SendMailUtil sendMaile = new SendMailUtil();
               sendMaile.sendWfxMail(message, (String)null, "Batch Activiation Tool", proModel.getMails());
            }
         }
      } catch (SQLException var11) {
         System.err.println("we have a sql exception " + var11.toString());
         String message = "CRITICAL-We are facing connectivity problem with billing DB (" + var11.toString() + "), please check";
         sendSMSToSupport(message);
         System.err.println("After sending sms");
      } catch (Exception var12) {
         System.err.println("Exception " + var12.toString());
      }

   }

   public void monitorFinancialTransaction_wfx(Connection con, int i, ProActiveConfModel proModel) {
      try {
         String message = "PAYMENTS STATUS\nHR\tAVG\tTOTAL\tSUCCESS\n";

         String hour;
         float avgRequestTime;
         int numOfRequests;
         int success;
         for(ResultSet rs = monitorFinancialTransaction_wfx.executeQuery(); rs.next(); message = message + hour + "\t" + avgRequestTime + "\t" + numOfRequests + "\t" + success + "\n") {
            hour = rs.getString("HOUR");
            avgRequestTime = rs.getFloat("AVG_REQUEST_TIME");
            numOfRequests = rs.getInt("NUM_OF_REQUESTS");
            success = rs.getInt("SUCCESS");
         }

         sendWfxMainSMS(message);
      } catch (SQLException var10) {
         System.err.println("we have a sql exception " + var10.toString());
         String message = "CRITICAL-We are facing connectivity problem with billing DB (" + var10.toString() + "), please check";
         sendSMSToSupport(message);
         System.err.println("After sending sms");
      } catch (Exception var11) {
         System.err.println("Exception " + var11.toString());
      }

   }

   public static void sendPingRequest(Connection con, int i, ProActiveConfModel proModel) throws UnknownHostException, IOException {
      String[] ipAddress = new String[]{"10.230.91.39", "10.230.91.196", "10.230.91.163", "10.230.91.91", "10.230.91.150"};

      for(int f = 0; f < 5; ++f) {
         InetAddress geek = InetAddress.getByName(ipAddress[f]);
         System.out.println("Sending Ping Request to " + ipAddress[f]);
         if (geek.isReachable(5000)) {
            System.out.println("Host is reachable");
         } else {
            sendSMSToSupport("Please check the M/C IP:" + ipAddress[f] + "is down");
            System.out.println("Sorry ! We can't reach:");
         }
      }

   }

   public void monitorOfflineRequests_wfx(Connection con, int i, ProActiveConfModel proModel) {
      try {
         String message = "";
         ResultSet rs = monitorOfflineRequests_wfx.executeQuery();

         while(rs.next()) {
            String status = rs.getString("STATUS_ID");
            long count = rs.getLong("CNT");
            if (count > 20L) {
               message = message + "offline requests with status : " + status + " and count : " + count + "\n";
            }
         }

         if (!message.isEmpty()) {
            sendWfxMainSMS(message);
         }
      } catch (SQLException var9) {
         System.err.println("we have a sql exception " + var9.toString());
         String message = "CRITICAL-We are facing connectivity problem with billing DB (" + var9.toString() + "), please check";
         sendSMSToSupport(message);
         System.err.println("After sending sms");
      } catch (Exception var10) {
         System.err.println("Exception " + var10.toString());
      }

   }

   public void monitorOfflineHTTPRequests_wfx(Connection con, int i, ProActiveConfModel proModel) {
      try {
         String message = "";
         ResultSet rs = monitorOfflineHTTPRequests_wfx.executeQuery();

         while(rs.next()) {
            long count = rs.getLong("CNT");
            if (count > 100L) {
               message = message + "HTTP offline requests pending number is  " + count + "\n";
            }
         }

         if (!message.isEmpty()) {
            sendSMSToSupport(message);
         }
      } catch (SQLException var8) {
         System.err.println("we have a sql exception " + var8.toString());
         String message = "CRITICAL-We are facing connectivity problem with billing DB (" + var8.toString() + "), please check";
         sendSMSToSupport(message);
         System.err.println("After sending sms");
      } catch (Exception var9) {
         System.err.println("Exception " + var9.toString());
      }

   }

   public void MonitorMNPFailures(Connection con, int i, ProActiveConfModel proModel) {
      try {
         String fileName = "d:\\temp\\MNPRequest.csv";
         FileWriter fstream = new FileWriter(fileName);
         BufferedWriter out = new BufferedWriter(fstream);
         int contract = 0;
         int action = 0;
         String ACTION_Description = "";
         ResultSet rs = MNPFailure.executeQuery();
         String Rcode = "";
         out.write("CO_ID,ACTION_ID,ACTION_DES,INSERT_DATE\n\r");

         while(rs.next()) {
            while(rs.next()) {
                contract = rs.getInt("co_id");
                action = rs.getInt("ACTION_ID");
               ACTION_Description = rs.getString("ACTION_DES");
               Date INSERT_DATEE = rs.getDate("INSERT_DATE");
               out.write(contract + "," + action + "," + ACTION_Description + "," + INSERT_DATEE + "\r");
            }
         }

         out.close();
         MNPFailure.close();
         String mailRecepts = proModel.getMails().replaceAll("fady.adel-attallah@localhost.com", "");
         SendMailUtil sendMaile = new SendMailUtil();
         sendMaile.sendWfxMail("Dears,\n Kindly check the attached failed requests for MNP customers ", fileName, "MNP Failures", "techit-rm-billing-support@voda.com;it-frontlinesupport@voda.com;Ahmed.Fahd-AbdELAziz@localhost.com;Walaa.AshrafFarouk@localhost.com");
      } catch (Exception var15) {
         System.err.println("Exception " + var15.toString());
      }

   }

   public void monitorFamilyHTTP(Connection con, int i, ProActiveConfModel proModel) {
      try {
         String fileName = "d:\\temp\\HTTPRequest.csv";
         FileWriter fstream = new FileWriter(fileName);
         BufferedWriter out = new BufferedWriter(fstream);
         int counts = 0;
         String MSISDN = "";
         String INTERFACE = "";
         String message = "";
         ResultSet rs = Family_HTTP.executeQuery();
         String Rcode = "";
         out.write("MEMBER_MSISDN,Number Of HITS,RESPONSE_BODY,CI RESPONSE\n\r");

         while(rs.next()) {
            while(rs.next()) {
               MSISDN = rs.getString("MEMBER_MSISDN");
               counts = rs.getInt("Number_Of_HITS");
               Rcode = rs.getString("CI_RESPONSE");
               INTERFACE = rs.getString("INTERFACE");
               Rcode = Rcode.replaceAll(",", "");
               out.write(MSISDN + "," + counts + "," + Rcode + "," + INTERFACE + "\n\r");
            }
         }

         out.close();
         Family_HTTP.close();
         String mailRecepts = proModel.getMails().replaceAll("fady.adel-attallah@localhost.com", "");
         SendMailUtil sendMaile = new SendMailUtil();
         sendMaile.sendWfxMail("Dears,\n attached the failed HTTP requests to CI", fileName, "Flex Family HTTP Requests", "techit-rm-billing-support@voda.com;ahmed.amr-samy@localhost.com;zaher.tarek-zaher@localhost.com;ahmed.khaled@localhost.com");
      } catch (Exception var15) {
         System.err.println("Exception " + var15.toString());
      }

   }

   public void Roaming_Rejection(Connection con, int i, ProActiveConfModel proModel) {
      try {
         String fileName = "d:\\temp\\RoamingRejection.csv";
         FileWriter fstream = new FileWriter(fileName);
         BufferedWriter out = new BufferedWriter(fstream);
         int counts = 0;
         String Date = "";
         ResultSet rs = monitorRoaming_Rej.executeQuery();
         out.write("Count,Date\n\r");

         while(rs.next()) {
            while(rs.next()) {
               counts = rs.getInt("count");
               Date = rs.getString("datee");
               out.write(counts + "," + Date + "\n\r");
            }
         }

         out.close();
         String mailRecepts = proModel.getMails().replaceAll("fady.adel-attallah@localhost.com", "");
         SendMailUtil sendMaile = new SendMailUtil();
         sendMaile.sendWfxMail("Dears,\n attached the Roaming Rejection counts", fileName, "Roaming Rejection", "techit-rm-billing-support@voda.com");
      } catch (Exception var12) {
         System.err.println("Exception " + var12.toString());
         System.out.println("Roaming throw an error");
      }

   }

   public void Visitors_Rejection(Connection con, int i, ProActiveConfModel proModel) {
      try {
         String fileName = "d:\\temp\\VisitorsRejection.csv";
         FileWriter fstream = new FileWriter(fileName);
         BufferedWriter out = new BufferedWriter(fstream);
         int counts = 0;
         String Date = "";
         ResultSet rs = monitorVisitors_Rej.executeQuery();
         out.write("Count,Date\n\r");

         while(rs.next()) {
            while(rs.next()) {
                counts = rs.getInt("count");
               Date = rs.getString("datee");
               out.write(counts + "," + Date + "\n\r");
            }
         }

         out.close();
         String mailRecepts = proModel.getMails().replaceAll("fady.adel-attallah@localhost.com", "");
         SendMailUtil sendMaile = new SendMailUtil();
         sendMaile.sendWfxMail("Dears,\n attached the Visitors Rejection counts", fileName, "Visitors Rejection", "techit-rm-billing-support@voda.com");
      } catch (Exception var12) {
         System.err.println("Exception " + var12.toString());
      }

   }

   public void Rating_Rejection(Connection con, int i, ProActiveConfModel proModel) {
      try {
         String fileName = "d:\\temp\\TotalRejection.csv";
         FileWriter fstream = new FileWriter(fileName);
         BufferedWriter out = new BufferedWriter(fstream);
         int counts = 0;
         String Date = "";
         ResultSet rs = monitorTotal_Rej.executeQuery();
         out.write("Count,Date\n\r");

         while(rs.next()) {
            while(rs.next()) {
               counts = rs.getInt("count");
               Date = rs.getString("datee");
               out.write(counts + "," + Date + "\n\r");
            }
         }

         out.close();
         String mailRecepts = proModel.getMails().replaceAll("fady.adel-attallah@localhost.com", "");
         SendMailUtil sendMaile = new SendMailUtil();
         sendMaile.sendWfxMail("Dears,\n attached the Rating Rejection counts", fileName, "Rating Rejection", "techit-rm-billing-support@voda.com");
      } catch (Exception var12) {
         System.err.println("Exception " + var12.toString());
      }

   }

   public void monitorFamilyTrans(Connection con, int i, ProActiveConfModel proModel) {
      try {
         String fileName2 = "d:\\temp\\H_transaction.csv";
         FileWriter fstream2 = new FileWriter(fileName2);
         BufferedWriter out2 = new BufferedWriter(fstream2);
         int counts2 = 0;
         String message2 = "";
         ResultSet rs2 = Family_trans.executeQuery();
         String Action = "";
         String Response = "";
         out2.write("count,Action,Response\n\r");

         while(rs2.next()) {
            while(rs2.next()) {
               counts2 = rs2.getInt("counts");
               Action = rs2.getString("des");
               Response = rs2.getString("error");
               out2.write(counts2 + "," + Action + "," + Response + "\n\r");
            }
         }

         out2.close();
         Family_trans.close();
         String mailRecepts = proModel.getMails().replaceAll("fady.adel-attallah@localhost.com", "");
         SendMailUtil sendMaile = new SendMailUtil();
         sendMaile.sendWfxMail("Dears,\n attached the Family Transactions", fileName2, "Family Transactions", "techit-rm-billing-support@voda.com;ahmed.amr-samy@localhost.com;zaher.tarek-zaher@localhost.com;ahmed.khaled@localhost.com");
      } catch (Exception var14) {
         System.err.println("Exception " + var14.toString());
      }

   }

   public void monitorNotificationTable_OTA(Connection con, int i, ProActiveConfModel proModel) {
      try {
         String message = "";
         ResultSet rs = monitorNotificationTable_OTA.executeQuery();

         while(rs.next()) {
            long count = rs.getLong("Count");
            if (count > 50000L) {
               message = message + "Number of rows in OTA Notification Table is  " + count + "\n";
            }
         }

         if (!message.isEmpty()) {
            sendWfxMainSMS(message);
         }
      } catch (SQLException var8) {
         System.err.println("we have a sql exception " + var8.toString());
         Vector MSISDNs = new Vector();
         MSISDNs.add("201030024022");
         MSISDNs.add("201094170727");
         MSISDNs.add("201023615285");
         new SendMailUtil();
         String message = "CRITICAL-We are facing connectivity problem with billing DB (" + var8.toString() + "), please check";
         new SendMailUtil();
         SendMailUtil.sendNewSMS(MSISDNs, message);
         System.err.println("After sending sms");
      } catch (Exception var9) {
         System.err.println("Exception " + var9.toString());
      }

   }

   public void monitorOtaPendingJobs(Connection con, int i, ProActiveConfModel proModel) {
      try {
         String message = "";
         ResultSet rs = monitorOtaPendingJobs.executeQuery();

         while(rs.next()) {
            int count = rs.getInt("COUNT");
            if (count >= 10) {
               message = "kindly check number of pending jobs in ota is : " + count;
               sendSMSToSupport(message);
               SendMailUtil sndSMS = new SendMailUtil();
               sndSMS.sendMail(message + ", contact support team", (String)null, "OTA Status Report", proModel.getMails());
               System.out.println("After sending sms");
            }
         }
      } catch (SQLException var8) {
         System.err.println("we have a sql exception " + var8.toString());
         String message = "CRITICAL-We are facing connectivity problem with billing DB (" + var8.toString() + "), please check";
         sendSMSToSupport(message);
         System.err.println("After sending sms");
      } catch (Exception var9) {
         System.err.println("Exception " + var9.toString());
      }

   }

   public void ChangeRatePlanCountMonitor(Connection con, int i, ProActiveConfModel proModel) {
      try {
         ResultSet RP_COUNT = ChangeRatePlanCount.executeQuery();
         ResultSet Rs2 = ChangeRatePlanSuccess.executeQuery();
         ResultSet Rs3 = TakeOverCount.executeQuery();
         ResultSet Rs4 = TakeOverSuccess.executeQuery();
         ResultSet Rs5 = SIMSwap.executeQuery();
         ResultSet Rs6 = SIMSwapSuccess.executeQuery();
         ResultSet Rs7 = ExecutionTimeSimSwap.executeQuery();
         ResultSet Rs8 = ExecutionTimeChangeRP.executeQuery();
         ResultSet Rs9 = ExecutionTimeTakeOver.executeQuery();
         int countall = 0;
         int countsuceess = 0;
         int countTakeOver = 0;
         int countTakeOverSucccess = 0;
         int countsimswap = 0;
         int simswapsuccess = 0;
         int AvgTimeSimSwap = 0;
         int AvgTimeTakeOver = 0;

         int AvgTimeChangeRP;
         for(AvgTimeChangeRP = 0; RP_COUNT.next(); countall = RP_COUNT.getInt("ChangeRP_Count")) {
         }

         while(Rs2.next()) {
            countsuceess = Rs2.getInt("ChangeRP_Success");
         }

         while(Rs3.next()) {
            countTakeOver = Rs3.getInt("TakeOver_Count");
         }

         while(Rs4.next()) {
            countTakeOverSucccess = Rs4.getInt("TakeOver_Success");
         }

         while(Rs5.next()) {
            countsimswap = Rs5.getInt("SimSwap_Count");
         }

         while(Rs6.next()) {
            simswapsuccess = Rs6.getInt("SimSwap_Success");
         }

         while(Rs7.next()) {
            AvgTimeSimSwap = Rs7.getInt("AVG_PROCESSING_TIME_SimSwap");
         }

         while(Rs8.next()) {
            AvgTimeChangeRP = Rs8.getInt("AVG_PROCESSING_TIME_ChangeRP");
         }

         while(Rs9.next()) {
            AvgTimeTakeOver = Rs9.getInt("AVG_PROCESSING_TIME_TakeOver");
         }

         CMSAdapterListener cmsListen = new CMSAdapterListener();
         cmsListen.pushInfoToGlobalSystem_replica("7", "RP_Change_Count", String.valueOf(countall));
         cmsListen.pushInfoToGlobalSystem_replica("8", "ChangeRP_Success", String.valueOf(countsuceess));
         cmsListen.pushInfoToGlobalSystem_replica("9", "TakeOverCount", String.valueOf(countTakeOver));
         cmsListen.pushInfoToGlobalSystem_replica("10", "TakeOverSuccess", String.valueOf(countTakeOverSucccess));
         cmsListen.pushInfoToGlobalSystem_replica("10", "SimSwapCount", String.valueOf(countsimswap));
         cmsListen.pushInfoToGlobalSystem_replica("10", "SimSwapSuccess", String.valueOf(simswapsuccess));
         cmsListen.pushInfoToGlobalSystem_replica("10", "AvgExecutionTimeSimSwap", String.valueOf(AvgTimeSimSwap));
         cmsListen.pushInfoToGlobalSystem_replica("10", "AvgExecutionTakeOver", String.valueOf(AvgTimeTakeOver));
         cmsListen.pushInfoToGlobalSystem_replica("10", "AvgExecutionChangeRP", String.valueOf(AvgTimeChangeRP));
      } catch (Exception var23) {
         System.out.println("Exception " + var23.toString());
         System.err.println("Exception " + var23.toString());
      }

   }

   public static void change_msisdn(Connection con, ProActiveConfModel proModel) {
      try {
         if (!isCDFilesPopulated) {
            prepAndUpdateCDFiles(con, proModel);
         }

         if (!isCDFilesHandled) {
            checkAndUpdate(con, proModel);
         }
      } catch (SQLException var3) {
         var3.printStackTrace();
      }

   }

   public static void FamilyDuplicationFix(Connection FamCon) throws SQLException {
      String DupFix = "update familyplatform.tx_family_member A set member_status=0 where member_status=1 and family_template_id=617 and member_msisdn in( SELECT  /*+parallel(32)*/ member_msisdn FROM familyplatform.tx_family_member where member_status=1 and family_template_id=617 GROUP BY member_msisdn HAVING COUNT(member_msisdn) > 1) and rowid not in (select min(rowid) from familyplatform.tx_family_member B where A.member_msisdn=B.member_msisdn and member_status=1 and family_template_id=617 and A.family_seq_id=B.family_seq_id group by member_msisdn)";
      FamCon.createStatement().executeQuery(DupFix);
   }

   public static void FamilyPendingActiveFix(Connection FamCon) throws SQLException {
      String PendingFix = "update familyplatform.tx_family_member set member_status=0 where member_status=5 and member_msisdn in( select /*+parallel(32)*/ member_msisdn from familyplatform.tx_family_member A where member_status=1 and family_template_id=617 and exists (select * from familyplatform.tx_family_member B where member_status=5 and A.member_msisdn=B.member_msisdn and family_template_id=617))";
      FamCon.createStatement().executeQuery(PendingFix);
   }

   public void DB_ACT_Checks_CORP() {
      StringBuilder str = new StringBuilder();
      StringBuilder str2 = new StringBuilder();
      StringBuilder Message = new StringBuilder();
      Message.append("Database Checks \n");
      String url = "jdbc:oracle:thin:@bscs-scan:1528/BSCSPRD2";

      try {
         Connection conn = DriverManager.getConnection(url, "servengdb", "bscs2005");
         Statement statement = conn.createStatement();
         ResultSet resultset = statement.executeQuery("select * from ( select count(1) AS RECORDS, 'VF_BILL_MANAGER' AS TABLENAME from VF_BILL_MANAGER union select count(1) As RECORDS, 'vf_recharge_contracts' AS TABLENAME from  vf_recharge_contracts )order by 1 desc");

         while(resultset.next()) {
            str.append(resultset.getString("TABLENAME")).append("\n");
            str2.append(resultset.getString("RECORDS")).append("\n");
         }

         conn.close();
         String[] Table_Name = str.toString().split("\n");
         String[] Records = str2.toString().split("\n");

         for(int i = 0; i < Table_Name.length; ++i) {
            Message.append(" " + Table_Name[i] + " has " + Records[i] + " count \n");
         }

         SendMailUtil sendMaile = new SendMailUtil();
         sendMaile.sendWfxMail(Message.toString(), (String)null, "DB Activities Check", "techit-rm-billing-support@voda.com;");
      } catch (SQLException var11) {
         var11.printStackTrace();
      }

   }

   public void checkCrontab() {
      try {
         Connection newCon = connCMSMONITOR();
         StringBuilder message = new StringBuilder();
         String machineip = "";
         String username = "";
         String key = "";
         String query = "select B.machineip, b.username,  b.crontabs from VF_BILLCYCLE.billing_linux_machines B where id not in (7,8)";
         linuxMachines = newCon.prepareStatement(query);
         ResultSet rs = linuxMachines.executeQuery();

         while(rs.next()) {
            machineip = rs.getString("MACHINEIP");
            System.err.println(machineip);
            username = rs.getString("USERNAME");
            int crontabs = rs.getInt("CRONTABS");
            if (machineip.equals("10.230.91.196") || machineip.equals("10.230.91.231")) {
               key = "Bill_Adm123";
            }

            if (machineip.equals("10.230.91.163") || machineip.equals("10.230.91.91")) {
               key = "bscsadm123";
            }

            if (machineip.equals("10.230.91.39")) {
               key = "CmsAdm123";
            }


            if (machineip.equals("10.72.73.228") || machineip.equals("10.72.73.230")) {
               key = "cms_adm123";
            }

//            if (machineip.equals("10.230.91.122")) {
//               key = "OTA_USER123";
//            }

            if (machineip.equals("10.230.92.161") || machineip.equals("10.230.92.152") || machineip.equals("10.230.92.146") || machineip.equals("10.230.92.162") || machineip.equals("10.230.92.131") || machineip.equals("10.230.92.36")) {
               key = "voda@123";
            }

            ChannelExec execChannel = (ChannelExec)this.getChannel(username, key, machineip);
            String numberOfActualCrontabs = this.excuteCommand(execChannel, "crontab -l | wc -l");
            this.closeChannel(execChannel);
            if (Integer.parseInt(numberOfActualCrontabs) < crontabs) {
               message.append(machineip + " \n").append("\n");
            }
         }

         newCon.close();
         if (!message.toString().equals("")) {
            SendMailUtil sendMaile = new SendMailUtil();
            sendMaile.sendWfxMail("Dears,\n there's a problem in crontab files please check \n" + message.toString(), (String)null, "Crontabs Alarm", "techit-rm-billing-support@voda.com");
            sendSMSToSupport("Dears \n we've missed crontabs on machine: \n" + message.toString());
         }
      } catch (Exception var11) {
         System.out.println(var11);
      }

   }

   public void provisioning_Failed_Requests(ProActiveConfModel proModel) {
      try {
         createFile("d:\\temp\\", "provisioning_failed", ".csv");
         clearFile("d:\\temp\\", "provisioning_failed", ".csv");
         String dn_num = "";
         Connection newCon = connCMSMONITOR();
         appendUsingBufferedWriter("d:\\temp\\provisioning_failed.csv", "Request,Contract,MSISDN\n\r", 1);
         String prov_failed = "SELECT /*+ parallel(32) */ a.REQUEST,a.CO_ID, D.dn_num FROM MDSRRTAB a, contr_services_cap B, directory_number D  WHERE a.co_id=B.co_id and B.cs_deactiv_date is null and B.dn_id=D.dn_id  and TRUNC(a.INSERT_DATE)>=TRUNC (SYSDATE)-7 and userid<>'V19IAUTOMATION1' and a.STATUS in (11,4) and action_id not in (6001,6003)";
         provision_failed = newCon.prepareStatement(prov_failed);
         ResultSet rs = provision_failed.executeQuery();

         while(rs.next()) {
            int request = rs.getInt("REQUEST");
            int co_id = rs.getInt("CO_ID");
            dn_num = rs.getString("DN_NUM");
            appendUsingBufferedWriter("d:\\temp\\provisioning_failed.csv", request + "," + co_id + "," + dn_num + "\n\r", 1);
         }

         newCon.close();
         String fileName = "d:\\temp\\provisioning_failed.csv";
         SendMailUtil sendMaile = new SendMailUtil();
         sendMaile.sendWfxMail("Dears,\n attached the Provisioning failed requests", fileName, "provisioning failure", "techit-rm-billing-support@voda.com;IT-FrontLineSupport@voda.com;TechIT-CRM-Integration-ProvisioningSupport@voda.com");
      } catch (Exception var10) {
         System.err.println("Exception " + var10.toString());
         System.out.println("provisioning check throw an error");
      }

   }

   public void changeMsisdnPendingRequest(ProActiveConfModel proModel) {
      Date date = new Date();
      Calendar calendar = GregorianCalendar.getInstance();
      calendar.setTime(date);
      System.out.println(calendar.get(11));

      try {
         createFile("d:\\temp\\", "changeMsisdn_Pending", ".csv");
         clearFile("d:\\temp\\", "changeMsisdn_Pending", ".csv");
         String insert_date = "";
         String data_1 = "";
         String data_2 = "";
         Connection newCon = connCMSMONITOR();
         appendUsingBufferedWriter("d:\\temp\\changeMsisdn_Pending.csv", "Request,Contract,Insert_Date,Dummy_Line,MNP_Line,Status\n\r", 1);
         String changeMsisdnPending = "select request,M.co_id, insert_date, data_1, data_2, Status from mdsrrtab M, contract_all C where action_id=6001 and M.co_id=C.co_id and C.ch_status<>'d' union all select /*+parallel(16)*/ request,A.co_id, insert_date, data_1, data_2, status from gmd_request_history A, contract_all C where status=9 and action_id=6001 and userid='TEBCO' and trunc(insert_date)>=trunc(sysdate-7) and C.co_id=A.co_id and C.ch_status<>'d' and not exists(select /*+parallel(16)*/ * from gmd_request_history B where status=8 and action_id=6001 and A.co_id=B.co_id and A.data_1=B.data_1 and A.data_2=B.data_2) order by insert_date desc";
         changeMsisdnPendingRequests = newCon.prepareStatement(changeMsisdnPending);
         ResultSet rs = changeMsisdnPendingRequests.executeQuery();

         while(rs.next()) {
            int request = rs.getInt("REQUEST");
            int co_id = rs.getInt("CO_ID");
            insert_date = rs.getString("INSERT_DATE");
            data_1 = rs.getString("DATA_1");
            data_2 = rs.getString("DATA_2");
            int status = rs.getInt("STATUS");
            appendUsingBufferedWriter("d:\\temp\\changeMsisdn_Pending.csv", request + "," + co_id + "," + insert_date + "," + data_1 + "," + data_2 + "," + status + "\n\r", 1);
         }

         newCon.close();
         String fileName;
         SendMailUtil sendMaile;
         if (calendar.get(11) == 9) {
            fileName = "d:\\temp\\changeMsisdn_Pending.csv";
            sendMaile = new SendMailUtil();
            sendMaile.sendWfxMail("Dears,\n attached Pending Requests for changing MSISDN \n Dears ITSOC members, \n Requests on Status 2 : Call Billing Support \n Requests on Status 4 : Call Provisioning Team \n Requests on Status 11 or 12 : Call Provisioning & Network (Core) Teams ", fileName, "Change Msisdn Pending Requests", "techit-rm-billing-support@voda.com;NMC.Core@vodafone.com;ITOperationalExcellence@voda.com;TechIT-CRM-CustomerManagementSupport@voda.com;TechIT-ServiceOperationCenter@voda.com;ITSOC.Notification@vodafone.com;CCMNPTeam@voda.com;IT-FrontLineSupport@vodafone.com.eg;nouran.elzoheiry@vodafone.com.eg;");
         } else {
            fileName = "d:\\temp\\changeMsisdn_Pending.csv";
            sendMaile = new SendMailUtil();
            sendMaile.sendWfxMail("Dears,\n attached Pending Requests for changing MSISDN \n Dears ITSOC members, \n Requests on Status 2 : Call Billing Support \n Requests on Status 4 : Call Provisioning Team \n Requests on Status 11 or 12 : Call Provisioning & Network (Core) Teams ", fileName, "Change Msisdn Pending Requests", "techit-rm-billing-support@voda.com;NMC.Core@vodafone.com;ITOperationalExcellence@voda.com;TechIT-CRM-CustomerManagementSupport@voda.com;TechIT-ServiceOperationCenter@voda.com;ITSOC.Notification@vodafone.com;IT-FrontLineSupport@vodafone.com.eg;nouran.elzoheiry@vodafone.com.eg;");
         }
      } catch (Exception var15) {
         System.err.println("Exception " + var15.toString());
      }

   }

   public void DBReplicationCheck() {
      try {
         String status = "";
         Connection newCon = connCMSMONITOR();
         String dbReplication = "SELECT CASE WHEN COUNT (1) > 10 THEN 'DR Replication OK' ELSE 'DR Replication Problem' END replication FROM GMD_REQUEST_HISTORY WHERE TS > (SYSDATE - (15 / (24 * 60)))";
         DBReplication = newCon.prepareStatement(dbReplication);

         for(ResultSet rs = DBReplication.executeQuery(); rs.next(); status = rs.getString("REPLICATION")) {
         }

         if (status.equals("DR Replication Problem")) {
            sendSMSToSupport(status);
            SendMailUtil sendMaile = new SendMailUtil();
            sendMaile.sendWfxMail("Dears \n we've database replication problem, kindly check urgently ", (String)null, "DB Replication Problem", "techit-rm-billing-support@voda.com;emad.rizk@vodafone.com.eg");
         }

         newCon.close();
      } catch (Exception var6) {
         System.err.println("Exception " + var6.toString());
      }

   }

   public void LoadingReportingCheck() {
      try {
         Connection newCon = connCMSMONITOR();
         int count = 0;
         String simIndicator = "";
         loadingReportingCheck = newCon.prepareStatement(simIndicator);

         for(ResultSet rs = loadingReportingCheck.executeQuery(); rs.next(); count = rs.getInt("COUNTT")) {
         }

         int total = 0;
         int stage = 0;
         boolean test = false;
         if (count <= 0) {
            System.out.println("no actual BC is running");
         } else {
            String accumulation = "select /*+parallel(32)*/count(*) TOTAL, Dr_Ass_Doc_Copy_Copy_Ind STAGE from dr_documents where Dr_Ass_Doc_Copy_Copy_Ind<6100 and Dr_Ass_Doc_Copy_Copy_Ind is not null and Dr_Request_Ass_Doc_Request_Id=(select billseqno from bch_process) group by Dr_Ass_Doc_Copy_Copy_Ind having count(*)>2000";
            Accumulation = newCon.prepareStatement(accumulation);
            ResultSet rsa = Accumulation.executeQuery();

            Object str;
            for(str = null; rsa.next(); test = true) {
               total = rsa.getInt("TOTAL");
               stage = rsa.getInt("STAGE");
               ((StringBuilder)str).append("we have accumulation count " + total + " on stage " + stage + "\n");
            }

            if (total != 0 && test) {
               SendMailUtil sendMaile = new SendMailUtil();
               sendMaile.sendWfxMail("Dears,\n " + str, (String)null, "Loading Reporting check", "techit-rm-billing-support@voda.com");
               sendSMSToSupport(((StringBuilder)str).toString());
            }
         }

         newCon.close();
      } catch (Exception var12) {
         System.err.println("Exception " + var12.toString());
      }

   }

   public static void appendUsingBufferedWriter(String filePath, String text, int noOfLines) {
      Date nowed = new Date();
      File file = new File(filePath);
      FileWriter fr = null;
      BufferedWriter br = null;

      try {
         fr = new FileWriter(file, true);
         br = new BufferedWriter(fr);

         for(int i = 0; i < noOfLines; ++i) {
            br.write(text);
            System.out.println(text + nowed.getTime());
         }
      } catch (IOException var16) {
         var16.printStackTrace();
      } finally {
         try {
            br.close();
         } catch (IOException var15) {
            var15.printStackTrace();
         }

      }

   }

   public static File createFile(String filePath, String fileName, String extension) {
      File createdFile = new File(filePath + fileName + extension);
      return createdFile;
   }

   public static FileWriter clearFile(String filePath, String fileName, String extension) {
      Object cleared = null;

      try {
         (new FileWriter(filePath + fileName + extension, false)).close();
      } catch (IOException var5) {
         var5.printStackTrace();
      }

      return (FileWriter)cleared;
   }

   public void PortOUtDirectoryNumberCheck(ProActiveConfModel proModel) {
      try {
         createFile("d:\\temp\\", "portOutCheck", ".csv");
         clearFile("d:\\temp\\", "portOutCheck", ".csv");
         String Dial = "";
         Connection newCon = connServEngDB();
         appendUsingBufferedWriter("d:\\temp\\changeMsisdn_Pending.csv", "Request,Contract,Insert_Date,Dummy_Line,MNP_Line,Status\n\r", 1);
         String portOutDN = "select c.numberfrom as nf from port_data@mnpprd1 a , PORT_MESSAGE@mnpprd1 b , NUMBERSTOPORT@mnpprd1 c , SUBSCRIBER_DATA@mnpprd1 d, directory_number r where a.LAST_NPC_MESSAGE_ID = b.NPC_MESSAGE_ID and a.LAST_NPC_MESSAGE_ID = c.NPC_MESSAGE_ID and a.npr_NPC_MESSAGE_ID = d.NPC_MESSAGE_ID and trunc(b.CREATE_DATE) = trunc(sysdate) and r.dn_Num=2 || TO_CHAR(c.numberfrom) and b.MESSAGECODE = 'NP Activated' and a.port_status = '20-Activate-S' and r.dn_status not in ('s','o')";
         PortOutDNCheck = newCon.prepareStatement(portOutDN);
         ResultSet rs = PortOutDNCheck.executeQuery();

         while(rs.next()) {
            Dial = rs.getString("nf");
            System.err.println("port out dials of today " + Dial);
            appendUsingBufferedWriter("d:\\temp\\portOutCheck.csv", Dial + "\n\r", 1);
         }

         newCon.close();
         String fileName = "d:\\temp\\portOutCheck.csv";
         SendMailUtil sendMaile = new SendMailUtil();
         sendMaile.sendWfxMail("Dears,\n kindly find the port out check report of today ", fileName, "Mark Port out Dials", "techit-rm-billing-support@voda.com;Radwa.mohamed3@vodafone.com;VIPComplaintsTeam@voda.com;Mina.abdelmessih@vodafone.com");
         if (!Dial.equals("")) {
            sendSmsPortOut("we've dials not marked as port out \nPlease check your mailbox");
         } else {
            sendSmsPortOut("All dials are marked as port out successfully for today");
         }
      } catch (Exception var8) {
         System.err.println("Exception " + var8.toString());
      }

   }

   public void checkVMsHQ() {
      String id = "";
      String machine = "";
      String user = "";
      Object var4 = null;

      try {
         System.out.println("VMs check called after edit");
         Connection newCon = connCMSMONITOR();
         String accumulation = "select id,machineip,username from vf_billcycle.billing_linux_machines where id in (11,14)";
         Accumulation = newCon.prepareStatement(accumulation);
         ResultSet rsa = Accumulation.executeQuery();

         while(rsa.next()) {
            id = rsa.getString("id");
            user = rsa.getString("username");
            machine = rsa.getString("machineip");

            try {
               ChannelExec execChannel1 = (ChannelExec)this.getChannel(user, "voda@123", machine);
               String summary = this.excuteCommand(execChannel1, "sh ~/release/scripts/check.sh");
               this.closeChannel(execChannel1);
               if (!summary.equals("")) {
                  sendSMSToSupport("Dears \nkindly check missing processes on MC: " + machine + "\n" + summary);
               }
            } catch (Exception var10) {
               var10.printStackTrace();
            }
         }

         newCon.close();
      } catch (SQLException var11) {
         var11.printStackTrace();
      }

   }

   public void healthChecks() {
      createFile("d:\\temp\\", "HealthChecks", ".csv");
      clearFile("d:\\temp\\", "HealthChecks", ".csv");
      String Category = "";
      String Item = "";

      try {
         Connection newCon = connServEngDB();
         appendUsingBufferedWriter("d:\\temp\\HealthChecks.csv", "Category,Item,LastWeek,Yesterday\r", 1);
         String healthChecks = "select category, item, lastweek, yesterday from vf_sysadm.healthchecks";
         HealthChecks = newCon.prepareStatement(healthChecks);
         ResultSet rs = HealthChecks.executeQuery();

         int lastWeek;
         int yesterday;
         while(rs.next()) {
            Category = rs.getString("CATEGORY");
            Item = rs.getString("ITEM");
            lastWeek = rs.getInt("LASTWEEK");
            yesterday = rs.getInt("YESTERDAY");
            appendUsingBufferedWriter("d:\\temp\\HealthChecks.csv", Category + "," + Item + "," + lastWeek + "," + yesterday + "\r", 1);
         }

         healthChecks = "select category, item, lastweek, yesterday from vf_sysadm.healthchecks@bscs_to_rtx_link";
         HealthChecks = newCon.prepareStatement(healthChecks);
         ResultSet rs2 = HealthChecks.executeQuery();

         while(rs2.next()) {
            Category = rs2.getString("CATEGORY");
            Item = rs2.getString("ITEM");
            lastWeek = rs2.getInt("LASTWEEK");
            yesterday = rs2.getInt("YESTERDAY");
            appendUsingBufferedWriter("d:\\temp\\HealthChecks.csv", Category + "," + Item + "," + lastWeek + "," + yesterday + "\r", 1);
         }

         newCon.close();
         String fileName = "d:\\temp\\HealthChecks.csv";
         SendMailUtil sendMaile = new SendMailUtil();
         sendMaile.sendWfxMail("Dears,\n kindly find the daily health check report of today ", fileName, "Daily Health Checks", "techit-rm-billing-support@voda.com;emad.rizk@vodafone.com.eg;mostafa.tolba@vodafone.com.eg");
      } catch (Exception var11) {
         System.err.println("Exception " + var11.toString());
      }

   }

   public void checkRVTraffic(ProActiveConfModel proModel) {
      try {
         Connection newCon = connServEngDB();
         int traffic = -1;
         String traffic_rv = "select /*+parallel (32) */ count(*) as TRAFFIC FROM WORKFLOWX.VFE_CMS_CLIENTS_LOG_ADP where trans_id like '%RV%' and REQUEST_DATE > SYSDATE - 1/24/60 order by request_date desc";
         RV_traffic = newCon.prepareStatement(traffic_rv);

         for(ResultSet rs = RV_traffic.executeQuery(); rs.next(); traffic = rs.getInt("TRAFFIC")) {
         }

         if (traffic == 0) {
            String message = "Dears,\n kindly check urgentrly as no RV traffic received in the last minute";
            sendSMSToSupport(message);
            SendMailUtil sendMaile = new SendMailUtil();
            sendMaile.sendWfxMail(message, (String)null, "RV traffic", "techit-rm-billing-support@voda.com;techit-rm-billing-support@voda.com.eg;emad.rizk@vodafone.com.eg;mostafa.tolba@vodafone.com.eg;");
         }

         newCon.close();
      } catch (Exception var8) {
         System.err.println("Exception " + var8.toString());
         System.out.println("provisioning check throw an error");
      }

   }
}