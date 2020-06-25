package item37;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

// EnumMap�� ����� ���� Ÿ�Կ� �����͸� ������Ű�� (226-228��)

// �Ĺ��� ���� �ܼ��ϰ� ǥ���� Ŭ���� (226��)
class Plant3 {
    enum LifeCycle {ANNUAL, PERENNIAL, BIENNIAL}

    final String name;
    final LifeCycle lifeCycle;

    Plant3(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        Plant3[] garden = {
                new Plant3("����", LifeCycle.ANNUAL),
                new Plant3("ĳ������", LifeCycle.BIENNIAL),
                new Plant3("��", LifeCycle.ANNUAL),
                new Plant3("�󺥴�", LifeCycle.PERENNIAL),
                new Plant3("�Ľ���", LifeCycle.BIENNIAL),
                new Plant3("�����", LifeCycle.PERENNIAL)
        };


        // �ڵ� 37-3 ��Ʈ���� ����� �ڵ� 1 - EnumMap�� ������� �ʴ´�! (228��)
        System.out.println(Arrays.stream(garden)
                .collect(groupingBy(p -> p.lifeCycle)));

        // �ڵ� 37-4 ��Ʈ���� ����� �ڵ� 2 - EnumMap�� �̿��� �����Ϳ� ���� Ÿ���� �����ߴ�. (228��)
        System.out.println(Arrays.stream(garden)
                .collect(groupingBy(p -> p.lifeCycle,
                        () -> new EnumMap<>(LifeCycle.class), toSet())));
    }
}