package user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/send")
public class Send extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Properties props=System.getProperties();
		props.put("mail.smtp.user", "hi8087470@gmail.com");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port","465" );
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		
		Authenticator auth=new MyAuthentication();
		
		Session session=Session.getDefaultInstance(props,auth);
		MimeMessage msg=new MimeMessage(session) ;
		
		try {
			msg.setSentDate(new Date());
			
			InternetAddress from=new InternetAddress("hi8087470@gmail.com");
			msg.setFrom(from);
			//수신자
			String email=req.getParameter("email");
			InternetAddress to=new InternetAddress(email);
			msg.setRecipient(Message.RecipientType.TO, to);
			
			//이메일 제목
			msg.setSubject("비밀번호 인증번호","UTF-8");
			
			//이메일 내용
			String code=req.getParameter("code_check");
			req.setAttribute("code", code);
			msg.setText("인증번호는: "+code,"UTF-8");
			
			msg.setHeader("content-Type", "text/html");
			
			javax.mail.Transport.send(msg);
			//System.out.println("보냄!");
			
			
		}catch(AddressException addr_e) {
			addr_e.printStackTrace();
		}catch(MessagingException msg_e) {
			msg_e.printStackTrace();
		}
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		out.println("1");//메시지 전송 완료
		out.close();
	}
}


class MyAuthentication extends Authenticator{
	
	PasswordAuthentication pa;
	
	public MyAuthentication() {
		String id="hi8087470@gmail.com";
		String pw="@sooh0401";
		
		pa=new PasswordAuthentication(id, pw);
	}
	
	public PasswordAuthentication getPasswordAuthentication() {
		return pa;
	}
}

