package item52;

import java.util.*;

//�����ǵ� �޼��� ȣ�� ��Ŀ���� (313��, �ڵ� 52-2�� �Ϻ�)
class Wine {
	String name() {
		return "������";
	}
}

//�����ǵ� �޼��� ȣ�� ��Ŀ���� (313��, �ڵ� 52-2�� �Ϻ�)
class SparklingWine extends Wine {
	@Override
	String name() {
		return "������ ������";
	}
}

//�����ǵ� �޼��� ȣ�� ��Ŀ���� (313��, �ڵ� 52-2�� �Ϻ�)
class Champagne extends SparklingWine {
	@Override
	String name() {
		return "������";
	}
}

//�����ǵ� �޼��� ȣ�� ��Ŀ���� (313��, �ڵ� 52-2�� �Ϻ�)
public class Overriding {
	public static void main(String[] args) {
		List<Wine> wineList = Arrays.asList(new Wine(), new SparklingWine(), new Champagne());
		for (Wine wine : wineList)
			System.out.println(wine.name());
	}
}