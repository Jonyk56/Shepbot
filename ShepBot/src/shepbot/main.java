
import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

/**
 * A single class JDA bot that adds a reaction to every message in the main
 * channel of the Discord of the Random Insanity Alliance of Cyber Nations.
 *
 * @author brian
 */
public class main extends ListenerAdapter {
	public static void main(String[] args) {
		System.out.println("Initialising ShepBot.");
		try {
			JDA jda = JDABuilder.createDefault(
				//
				"NzgxNTIyNzkxOTQ1ODYzMTY4.X7-30Q.tbl7Pji5vmNP_QF2N00Wtf7RmME"
				).build();
		} catch (LoginException ex) {
			System.out.println(ex + ": Token is incorrect.");
		}
		System.out.println("ShepBot Reporting in.");
	}

	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		JDA jda = event.getJDA();
		Message message = event.getMessage();
		if (message.getChannel().getName().equals("ria")) {
			message.addReaction("shep:359539314507382804").queue();
		}
		System.out.println(message.getContentRaw());
		if (message.getContentRaw().toLowerCase().matches("moth") && !message.getAuthor().isBot()) {
			message.getChannel().sendMessage("Moth!").queue();
		}
	}
}
// NzgxNTIyNzkxOTQ1ODYzMTY4.X7-30Q.NVL_JEJNCsiPbKUisB2V0Xd7iOg