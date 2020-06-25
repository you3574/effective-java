package item37;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

// �ڵ� 37-6 ��ø EnumMap���� �����Ϳ� ���� Ÿ�� ���� �����ߴ�. (229-231��)
public enum EnumMapPhase {
    SOLID, LIQUID, GAS;

    public enum Transition {

        MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
        SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID);

        private final EnumMapPhase from;
        private final EnumMapPhase to;

        Transition(EnumMapPhase from, EnumMapPhase to) {
            this.from = from;
            this.to = to;
        }

        // ������ ���� �ʱ�ȭ�Ѵ�.
        private static final Map<EnumMapPhase, Map<EnumMapPhase, Transition>>
                m = Stream.of(values()).collect(groupingBy(t -> t.from,
                () -> new EnumMap<>(EnumMapPhase.class),
                toMap(t -> t.to, t -> t,
                        (x, y) -> y, () -> new EnumMap<>(EnumMapPhase.class))));

        public static Transition from(EnumMapPhase from, EnumMapPhase to) {
            return m.get(from).get(to);
        }


    }

    // ������ ���� ���α׷� - ������� ���� ǥ�� ����Ѵ�.
    public static void main(String[] args) {
        for (EnumMapPhase src : EnumMapPhase.values()) {
            for (EnumMapPhase dst : EnumMapPhase.values()) {
                Transition transition = Transition.from(src, dst);
                if (transition != null)
                    System.out.printf("%s���� %s�� : %s %n", src, dst, transition);
            }
        }
    }
}

