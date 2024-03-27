package Pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import javax.mail.AuthenticationFailedException;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

import com.asis.Excel;
import com.asis.QuaterData;
import com.asis.util.BaseClass;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

import java.util.Properties;

public class GenratingExcelPage extends BaseClass {

	Double reportingVar;
	Double unknownVar;

	public void getXeroData() {
		ArrayList<QuaterData> xero_data = new ArrayList<>();
		QuaterData xeroObj = new QuaterData("As per the book");
		xeroObj.set_G1(Double.parseDouble(fetchCaptureA1G1B1Data.get(0)),false);
		xeroObj.set_1A(Double.parseDouble(fetchCaptureA1G1B1Data.get(1)),false);
		xeroObj.set_1B(Double.parseDouble(fetchCaptureA1G1B1Data.get(2)),false);
		xeroObj.set_W1(Double.parseDouble(fetchCaptureA1G1B1Data.get(3)),false);
		xeroObj.set_4(Double.parseDouble(fetchCaptureA1G1B1Data.get(4)),false);
		xeroObj.set_GST_Refund(xeroObj.get_1A() - xeroObj.get_1B(),false);
		xeroObj.set_ATO_Total_Refund(xeroObj.get_GST_Refund() + xeroObj.get_4() + xeroObj.get_5A() - xeroObj.get_7D(),false);
		xero_data.add(xeroObj);
		XERO_DATA.add(xero_data);

		ArrayList<QuaterData> variance_data = new ArrayList<>();
		QuaterData variance = new QuaterData("Variance");
		variance.set_G1(QuaterData.getTotal_of_year_G1() - xeroObj.get_G1(),false);
		variance.set_1A(QuaterData.getTotal_of_year_1A() - xeroObj.get_1A(),false);
		variance.set_1B(QuaterData.getTotal_of_year_1B() - xeroObj.get_1B(),false);
		variance.set_W1(QuaterData.getTotal_of_year_W1() - xeroObj.get_W1(),false);
		variance.set_4(QuaterData.getTotal_of_year_4() - xeroObj.get_4(),false);
		variance.set_GST_Refund(variance.get_1A() - variance.get_1B(),false);
		variance.set_ATO_Total_Refund(variance.get_GST_Refund() + variance.get_4() + variance.get_5A() - variance.get_7D(),false);
		variance_data.add(variance);
		XERO_DATA.add(variance_data);	

		HashMap<String, Double> hm7 = new HashMap<>();
		hm7.put("Reason for Variance:", 0.0);
		LAST_TABLE_DATA.add(hm7);

		HashMap<String, Double> hm8 = new HashMap<>();
		hm8.put("Reporting variance", variance.get_GST_Refund());
		LAST_TABLE_DATA.add(hm8);
		reportingVar=LAST_TABLE_DATA.get(7).get("Reporting variance");

		HashMap<String, Double> hm9 = new HashMap<>();
		hm9.put("Unknown variance",	LAST_TABLE_DATA.get(5).get("Total - GST as per balance sheet")+
				LAST_TABLE_DATA.get(6).get("Reason for Variance:")+
				LAST_TABLE_DATA.get(7).get("Reporting variance"));
		LAST_TABLE_DATA.add(hm9);

		unknownVar=LAST_TABLE_DATA.get(8).get("Unknown variance");

		ArrayList<QuaterData> bas_relodged_data = new ArrayList<>();
		QuaterData bas_relodged = new QuaterData("BAS to be relodged for Period ended Jun 23");

		bas_relodged.set_G1(TEMP_JUNE_G1 - variance.get_G1(),false);
		bas_relodged.set_1A(TEMP_JUNE_A1 - variance.get_1A(),false);
		bas_relodged.set_1B(TEMP_JUNE_B1 - variance.get_1B(),false);
		bas_relodged.set_W1(TEMP_JUNE_W1 - variance.get_W1(),false);
		bas_relodged.set_4(TEMP_JUNE_4 - variance.get_4(),false);
		bas_relodged.set_GST_Refund(TEMP_JUNE_GST_Refund - variance.get_GST_Refund(),false);
		bas_relodged.set_ATO_Total_Refund(bas_relodged.get_GST_Refund() + bas_relodged.get_4() + bas_relodged.get_5A() - bas_relodged.get_7D(),false);
		bas_relodged_data.add(bas_relodged);
		XERO_DATA.add(bas_relodged_data);

		/*
		bas_relodged.set_G1(qd_jun.get_G1() - variance.get_G1(),false);
		bas_relodged.set_1A(qd_jun.get_1A() - variance.get_1A(),false);
		bas_relodged.set_1B(qd_jun.get_1B() - variance.get_1B(),false);
		bas_relodged.set_W1(qd_jun.get_W1() - variance.get_W1(),false);
		bas_relodged.set_4(qd_jun.get_4() - variance.get_4(),false);
		bas_relodged.set_GST_Refund(qd_jun.get_GST_Refund() - variance.get_GST_Refund(),false);
		bas_relodged.set_ATO_Total_Refund(bas_relodged.get_GST_Refund() + bas_relodged.get_4() + bas_relodged.get_5A() - bas_relodged.get_7D(),false);
		bas_relodged_data.add(bas_relodged);
		XERO_DATA.add(bas_relodged_data);

		 */
	}
	public void generateExcelAndSendEmail(String recipientEmail) {
		String[] client_data = {ATO_CLIENT_NAME, ATO_TO_DATE};
		Excel obj = new Excel();
		String filePath = "Final_data.xls"; // Assuming this is the file path where the Excel file will be generated
		obj.createFinancialSummaryExcelWithData(filePath, BaseClass.ATO_ROW_DATA, BaseClass.XERO_DATA, BaseClass.ACTIVITY_STATEMENT_DATA, client_data);

		// Then, send the Excel file as an email attachment
		String from = "topgst@theoutsourcepro.com.au";
		String password = "Guf87765";
		String senderMail = from;

		// Outlook SMTP server configuration
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		// Creating a session object
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});

		try {
			// Creating a MimeMessage object
			Message message = new MimeMessage(session);
			// Set From: header field
			message.setFrom(new InternetAddress(from));
			// Set To: header field
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
			// Set Subject: header field
			message.setSubject("Financial Summary Excel Report");

			// Create a multipart message
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			Multipart multipart = new MimeMultipart();

			// Set text message part with HTML formatting
			String emailBody = "<html><body>" +
			                   "<h2 style=\"color: #007bff;\">Financial Summary Report</h2>" +
			                   "<p><b>Client Name:</b> " + ATO_CLIENT_NAME + "</p>" +
			                   "<p><b>Year:</b> " + ATO_TO_DATE + "</p>" +
			                   "<p><b>Reporting Variance:</b> $" + reportingVar + "</p>" +
			                   "<p><b>Unknown Variance:</b> $" + unknownVar + "</p>" +
			                   "<p>Hello " +USERNAME + "</p>" +
			                   "<p>We are pleased to provide you with the Financial Summary Report for your review.</p>" +
			                   "<p>This report contains essential financial data for the specified year, including reporting and unknown variances.</p>" +
			                   "<p>Please find the attached Excel file for detailed information.</p>" +
			                   "<p>If you have any questions or require further assistance, feel free to contact us.</p>" +
			                   "<br>" +
			                   "<p>Best regards,</p>" +
			                   "<p><b> THE OUTSOURCE PRO </b></p>" +
			                   "</body></html>";
			// Set content type to HTML
			messageBodyPart.setContent(emailBody, "text/html");
			multipart.addBodyPart(messageBodyPart);

			// Part two is attachment
			messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(filePath);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName("Final_data.xls");
			multipart.addBodyPart(messageBodyPart);

			// Send the complete message parts
			message.setContent(multipart);

			// Send message
			Transport.send(message);
			System.out.println("Email with attachment sent successfully to " + recipientEmail);
		} catch (AuthenticationFailedException e) {
			System.out.println("Authentication failed. Please check your credentials and try again.");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}


