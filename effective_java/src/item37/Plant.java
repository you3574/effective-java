package item37;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

// EnumMap�� ����� ���� Ÿ�Կ� �����͸� ������Ű�� (226-228��)

// �Ĺ��� ���� �ܼ��ϰ� ǥ���� Ŭ���� (226��)
class Plant {
    enum LifeCycle {ANNUAL, PERENNIAL, BIENNIAL}

    final String name;
    final LifeCycle lifeCycle;

    Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        Plant[] garden = {
                new Plant("����", LifeCycle.ANNUAL),
                new Plant("ĳ������", LifeCycle.BIENNIAL),
                new Plant("��", LifeCycle.ANNUAL),
                new Plant("�󺥴�", LifeCycle.PERENNIAL),
                new Plant("�Ľ���", LifeCycle.BIENNIAL),
                new Plant("�����", LifeCycle.PERENNIAL)
        };

        // �ڵ� 37-1 ordinal()�� �迭 �ε����� ��� - ���� ���� �� ��! (226��)
        // �迭�� ���׸��� ȣȯ���� �ʴ´�. (��˻� ����ȯ�� ����, �������� �ȵȴ�.)
        // ordinal()�� ��� ���� ������ ���� ���Ѵ�.
        // �߸��� ���� ����ϸ� �̻��� ������ �����Ѵ�.
        Set<Plant>[] plantsByLifeCycleArr =
                (Set<Plant>[]) new Set[Plant.LifeCycle.values().length];
        for (int i = 0; i < plantsByLifeCycleArr.length; i++)
            plantsByLifeCycleArr[i] = new HashSet<>();
        for (Plant p : garden)
            plantsByLifeCycleArr[p.lifeCycle.ordinal()].add(p);
        // ��� ���
        for (int i = 0; i < plantsByLifeCycleArr.length; i++) {
            System.out.printf("%s: %s%n",
                    Plant.LifeCycle.values()[i], plantsByLifeCycleArr[i]);
        }

    }
}