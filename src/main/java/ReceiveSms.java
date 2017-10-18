
import static spark.Spark.post;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.MessageFetcher;
import com.twilio.twiml.Body;
import com.twilio.twiml.Message;
import com.twilio.twiml.MessagingResponse;

public class ReceiveSms  extends HttpServlet{
		
	private static final long serialVersionUID = 1L;

	
	public static void main(String[] args) {		
		
		
		
		post("/receive-sms", (req,res) -> {
			
			/*ResourceSet<Message> messages = Message.reader().read();
			for (Message message : messages) {
				System.out.println(message.getBody());
			}*/
			
			String body = req.queryParams("Body");
			String from = req.queryParams("From");
			String toMsg = "";
			System.out.println("\nFrom: "+from+"\nMessage: "+body);
			if(body.toLowerCase().equals("schedule")){
				toMsg = "You asked for Schedule..!!";
			}
			else{
				toMsg = "Wrong question";
			}
			
			//System.out.println("String is: "+ss);
			/*Message sms = new Message.Builder()
					.body(new Body("Hey Nikhil, how are you??"))
					.build();*/
			Message sms = new Message.Builder()
					.body(new Body(toMsg))
					.build();
			MessageFetcher mm = new MessageFetcher("");
			
			MessagingResponse twiml = new MessagingResponse.Builder().message(sms).build();
			//System.out.println("SMS sent to: "+twiml.toXml().toString());
			//System.out.println(sms.getBody());
			return twiml.toXml();
		});
	}
}
