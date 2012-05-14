import java.io.File;
import java.util.logging.Logger;

public class PingLimit extends Plugin
{
	  String name = "PingLimit";
	  String version = "1.0";
	  String author = "spenk";
	  static Logger log = Logger.getLogger("Minecraft");
	  
	  
public void initialize(){
File f = new File ("plugins/config"); f.mkdir();
PingLimitListener listener = new PingLimitListener();
log.info(this.name +" version "+ this.version + " by " +this.author+ " is initialized!");
etc.getLoader().addListener(PluginLoader.Hook.COMMAND, listener, this, PluginListener.Priority.MEDIUM);
etc.getLoader().addListener(PluginLoader.Hook.PLAYER_MOVE, listener, this, PluginListener.Priority.MEDIUM);
etc.getInstance().addCommand("/ping", "ping <player> to see player ping or your own ping");
listener.loadConfiguration();
}
public void enable(){
	log.info(this.name + " version " + this.version + " by " + this.author + " is enabled!");
}

public void disable(){
	log.info(this.name + " version " + this.version + " is disabled!");
    etc.getInstance().removeCommand("/ping");
}
}

