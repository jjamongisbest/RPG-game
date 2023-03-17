package day04_rpg;

import java.util.ArrayList;

public class Inventory {
	private ArrayList<Item> itemList = new ArrayList<>();

	public void inventoryMenu() {
		while (true) {
			System.out.println("============ [인벤메뉴] =============");
			System.out.println("[1.착용] [2.판매] [0.뒤로가기]");
			int sel = MainGame.sc.nextInt();
			if (sel == 0)
				break;
			if (sel == 1) {
				equipMenu();
			}
			if (sel == 2) {
				sellMenu();
			}
		}
	}

	public void equipMenu() {
		Player.getGuild().printAllUnitStaus();
		System.out.println("아이템 착용할 길드원을 선택하세요 ");
		int selUnit = MainGame.sc.nextInt();
		while (true) {
			Player.getGuild().printUnitStaus(selUnit - 1);
			Player.getGuild().printUnitItem(selUnit - 1);
			printItemList();
			System.out.println("착용할 아이템 번호를 입력하세요 [0.뒤로가기]");
			int selEquip = MainGame.sc.nextInt();
			if (selEquip == 0)
				break;
			selEquip -= 1;
			if (itemList.get(selEquip).getKind() == Item.getWeapon()) {
				if (Player.getGuildUnit(selUnit - 1).getWeapon() != null) {
					itemList.add(Player.getGuildUnit(selUnit - 1).getWeapon());
				}
				Player.getGuildUnit(selUnit - 1).setWeapon(itemList.get(selEquip));
			} else if (itemList.get(selEquip).getKind() == Item.getArmor()) {
				if (Player.getGuildUnit(selUnit - 1).getArmor() != null) {
					itemList.add(Player.getGuildUnit(selUnit - 1).getArmor());
				}
				Player.getGuildUnit(selUnit - 1).setArmor(itemList.get(selEquip));
			} else if (itemList.get(selEquip).getKind() == Item.getRing()) {
				if (Player.getGuildUnit(selUnit - 1).getRing() != null) {
					itemList.add(Player.getGuildUnit(selUnit - 1).getRing());
				}
				Player.getGuildUnit(selUnit - 1).setRing(this.itemList.get(selEquip));
			}
			this.itemList.remove(selEquip);
		}
	}

	public void printItemList() {
		System.out.println("============ [아이템리스트] ==============");
		for (int i = 0; i < this.itemList.size(); i++) {
			System.out.print("[" + (i + 1) + "번]");
			System.out.print("[이름 : " + this.itemList.get(i).getName() + "]");
			System.out.print("[능력 : " + this.itemList.get(i).getPower() + "]");
			System.out.print("[가격 : " + this.itemList.get(i).getPrice() + "]");
			System.out.println("");
		}
	}

	public void sellMenu() {
		while (true) {
			printItemList();
			System.out.println("[골드 : " + Player.getMoney() + "]");
			System.out.println("판매할 아이템 번호를 입력하세요. (50 % 세금) [0.뒤로가기]");
			int selSell = MainGame.sc.nextInt();
			System.out.println(this.itemList.get(selSell - 1).getName() + "을 판매합니다.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Player.setMoney(Player.getMoney() + (this.itemList.get(selSell - 1).getPrice() / 2));
			this.itemList.remove(selSell - 1);
		}
	}

	public void addItem(Item item) {
		this.itemList.add(item);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Item> getItemList(){
		return (ArrayList<Item>) itemList.clone();
	}

}