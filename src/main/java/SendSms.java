import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SendSms {

	public static final String ACCOUNT_SID = "AC0b0ea7eb42a948256da95fcef1571ca1";
	public static final String AUTH_TOKEN = "bddb0ad5fe6f8bd65a8146346b0effbf";

	public static void main(String[] args) {

		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		Message message = Message.creator(new PhoneNumber("+16232826037"), // to
				new PhoneNumber("+17866810244"), // from
				"kya samjha?" // body
		).create();
		
		System.out.println(message.getSid());

	}
}
