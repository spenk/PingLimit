public class PingLimitListener extends PluginListener {
	int limit;
	private PropertiesFile properties = new PropertiesFile("plugins/config/pinglimit.properties");
	
	public void loadConfiguration() {
		limit = properties.getInt("ping-limit", 300);
	}
	public void onPlayerMove(Player player,Location from,Location to){
		int ping = player.getPing();
		if (ping > limit){
			if (player.canUseCommand("/ignoreping")){
			}else{
			player.kick("your ping is to high decrease your ping to " + limit +"ms.");
		}
		}
	}
	
	public boolean onCommand(Player player,java.lang.String[] split){
		if ((split[0].equals("/ping"))&& player.canUseCommand("/ping")){
			if (split.length == 1){
				player.sendMessage("§2Your ping is §5" + player.getPing()+"ms.");
				return true;
			}else{
				if (split.length == 2){
					Player player2 = etc.getServer().matchPlayer(split[1]);
					if (player2 == null){
						player.sendMessage("§4This player is currently not online.");
						return true;
					}else{
						player.sendMessage("§3The ping of §2"+player2.getName()+" is §4"+player2.getPing()+"ms.");
						return true;
				}
				}else{
					if (split.length >2){
						player.sendMessage("The correct usage is '/ping <player>'");
						return true;
					}
				}
			}
		}
		return false;
	}
}