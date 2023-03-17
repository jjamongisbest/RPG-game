package day04_rpg;

import java.util.ArrayList;

public class Shop {
	ArrayList<Item> itemList = new ArrayList<>();

	public Shop() {
		Item temp = new Item();
		temp.setKind(Item.getWeapon());
		temp.setName("기본 스태프");
		temp.setPower(3);
		temp.setPrice(1000);
		temp.setInfo("초보자라면 누구나 사용하는 기본중의 기본 스태프");
		itemList.add(temp);

		temp = new Item();
		temp.setKind(Item.getWeapon());
		temp.setName("롱 스태프");
		temp.setPower(5);
		temp.setPrice(2000);
		temp.setInfo("서쪽 성의 대마법사의 제자의 친척의 아들의 딸이 만든 나름 좋은 스태프");
		itemList.add(temp);

		temp = new Item();
		temp.setKind(Item.getWeapon());
		temp.setName("전용 스태프");
		temp.setPower(7);
		temp.setPrice(2500);
		temp.setInfo("사용자에 맞추어 최고의 효율을 자랑하는 마법부 공인 인증 스태프");
		itemList.add(temp);

		temp = new Item();
		temp.setKind(Item.getArmor());
		temp.setName("천 로브");
		temp.setPower(1);
		temp.setPrice(300);
		temp.setInfo("남쪽에 사는 상인 케빈이 가다 주운 로브. 조금 허름하다.");
		itemList.add(temp);

		temp = new Item();
		temp.setKind(Item.getArmor());
		temp.setName("가죽 로브");
		temp.setPower(4);
		temp.setPrice(800);
		temp.setInfo(" !!! 10년에 한번 발견되는 알비노 달팽이의 진액으로 연마된 가죽으로 반짝임이 남다르다.");
		itemList.add(temp);

		temp = new Item();
		temp.setKind(Item.getArmor());
		temp.setName("전용 로브");
		temp.setPower(7);
		temp.setPrice(1500);
		temp.setInfo("100년전 용사가 잡아온 용의 가죽으로 만든 최고급 로브!");
		itemList.add(temp);

		temp = new Item();
		temp.setKind(Item.getRing());
		temp.setName("주워온 반지");
		temp.setPower(7);
		temp.setPrice(3000);
		temp.setInfo("길 가다 주운 반지. 매우 허름하다.");
		itemList.add(temp);

		temp = new Item();
		temp.setKind(Item.getRing());
		temp.setName("타락한 영혼의 반지");
		temp.setPower(17);
		temp.setPrice(6000);
		temp.setInfo("남쪽 마을에 사는 좀 도둑이 훔쳐온 반지. 도둑의 마음을 닮아 타락했다.");
		itemList.add(temp);

		temp = new Item();
		temp.setKind(Item.getRing());
		temp.setName("울부짖는 혼돈의 반지");
		temp.setPower(35);
		temp.setPrice(20000);
		temp.setInfo("100년전 용사가 용의 둥지에서 털어온 용의 반지. 생김새가 조금 무섭다.");
		itemList.add(temp);
	}

	public void shopMng() {
		while (true) {
			System.out.println("=============== [상점] ===============");
			System.out.println("[1.무기] [2.갑옷] [3.반지] [0.뒤로가기]");
			int selKind = MainGame.sc.nextInt();
			if (selKind == 0)
				return;
			while (true) {
				if (selKind == Item.getWeapon())
					System.out.println("=========== [무기] ============");
				else if (selKind == Item.getArmor())
					System.out.println("=========== [방어구] ============");
				else if (selKind == Item.getRing())
					System.out.println("=========== [반지] ============");
				printItems(selKind);
				System.out.println("[골드 : " + Player.getMoney() + "]");
				System.out.println("구입할 아이템 번호를 입력하세요 [0.뒤로가기]");
				int selNum = MainGame.sc.nextInt();
				if (selNum == 0)
					break;
				int count = 0;
				for (int i = 0; i < itemList.size(); i++) {
					if (itemList.get(i).getKind() == selKind) {
						count += 1;
						if (count == selNum) {
							// 수정필요
							Player.getInven().addItem(itemList.get(i));
							Player.setMoney(Player.getMoney() - itemList.get(i).getPrice());
							System.out.println("[" + itemList.get(i).getName() + "] 을 구입했습니다.");
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							break;
						}
					}
				}
			}
		}
	}

	public void printItems(int kind) {
		int count = 0;
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getKind() != kind)
				continue;
			System.out.print("[" + (count + 1) + "번]");
			System.out.print("[이름 : " + itemList.get(i).getName() + "]");
			System.out.print("[능력 : " + itemList.get(i).getPower() + "]");
			System.out.print("[가격 : " + itemList.get(i).getPrice() + "]");
			System.out.println("[" + itemList.get(i).getInfo() + "]");
			count += 1;
		}
	}

}