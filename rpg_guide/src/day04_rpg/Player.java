package day04_rpg;

import java.util.ArrayList;

public class Player {
	private static int money;
	private static Guild guild = new Guild();
	private static Inventory inven = new Inventory();

	Player() {
		money = 100000;
		guild.setGuild();
	}

	public void guildMenu() {
		guild.guildMenu();
	}

	public static Guild getGuild() {
		return guild;
	}

	public static void setGuild(Guild guild) {
		Player.guild = guild;
	}

	public static Inventory getInven() {
		return inven;
	}

	public static void setInven(Inventory inven) {
		Player.inven = inven;
	}

	public void inventoryMenu() {
		inven.inventoryMenu();
	}

	static public ArrayList<Unit> getGuildList() {
	    return guild.getGuildList();
	}

	static public Unit getGuildUnit(int num) {
		return guild.getGuildUnit(num);
	}

	static public int getGuildSize() {
		return guild.getGuildList().size();
	}

	static public int getItemSize() {
		return inven.getItemList().size();
	}
	
	public static int getMoney() {
		return money;
	}
	
	public static void setMoney(int tempMoney) {
		money += tempMoney;
	}
}