package item37;
import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

// EnumMap�� ����� ���� Ÿ�Կ� �����͸� ������Ű�� (226-228��)

// �Ĺ��� ���� �ܼ��ϰ� ǥ���� Ŭ���� (226��)
class Plant2 {
    enum LifeCycle {ANNUAL, PERENNIAL, BIENNIAL}

    final String name;
    final LifeCycle lifeCycle;

    Plant2(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        Plant2[] garden = {
                new Plant2("����", LifeCycle.ANNUAL),
                new Plant2("ĳ������", LifeCycle.BIENNIAL),
                new Plant2("��", LifeCycle.ANNUAL),
                new Plant2("�󺥴�", LifeCycle.PERENNIAL),
                new Plant2("�Ľ���", LifeCycle.BIENNIAL),
                new Plant2("�����", LifeCycle.PERENNIAL)
        };

        // �ڵ� 37-2 EnumMap�� ����� �����Ϳ� ���� Ÿ���� �����Ѵ�. (227��)
        // �� ���ܸ���ϰ� ���� ��ȯ
        // ���� Ű�� ���� Ÿ���� �� ��ü�� ��¿� ���ڿ��� �����ϴ� ��°���� ������ formatting�� �ʿ����.
        // EnumMap�� ������ ordinal�� �� �迭�� ���� ������ EnumMap ���ο��� ordinal�� ����� �迭�� ����ϱ� �����̴�.
        // �����ڰ� ���� �������� �ʰ� Map�� ����Ͽ�, Ÿ�Ծ������� ���� �Ӵ��� ���ɻ��� �������� �״�� ��������.
        Map<Plant2.LifeCycle, Set<Plant2>> plantsByLifeCycle =
                new EnumMap<>(Plant2.LifeCycle.class);
        for (Plant2.LifeCycle lc : Plant2.LifeCycle.values())
            plantsByLifeCycle.put(lc, new HashSet<>());
        for (Plant2 p : garden)
            plantsByLifeCycle.get(p.lifeCycle).add(p);
        System.out.println(plantsByLifeCycle);

    }
}