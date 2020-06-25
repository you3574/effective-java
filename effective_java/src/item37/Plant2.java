package item37;
import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

// EnumMap을 사용해 열거 타입에 데이터를 연관시키기 (226-228쪽)

// 식물을 아주 단순하게 표현한 클래스 (226쪽)
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
                new Plant2("바질", LifeCycle.ANNUAL),
                new Plant2("캐러웨이", LifeCycle.BIENNIAL),
                new Plant2("딜", LifeCycle.ANNUAL),
                new Plant2("라벤더", LifeCycle.PERENNIAL),
                new Plant2("파슬리", LifeCycle.BIENNIAL),
                new Plant2("로즈마리", LifeCycle.PERENNIAL)
        };

        // 코드 37-2 EnumMap을 사용해 데이터와 열거 타입을 매핑한다. (227쪽)
        // 더 간단명료하게 로직 변환
        // 맵의 키인 열거 타입이 그 자체로 출력용 문자열을 제공하니 출력결과에 별도의 formatting이 필요없다.
        // EnumMap의 성능이 ordinal을 쓴 배열과 같은 이유는 EnumMap 내부에서 ordinal을 사용한 배열을 사용하기 때문이다.
        // 개발자가 직접 제어하지 않고 Map을 사용하여, 타입안정성을 얻을 뿐더러 성능상의 이점까지 그대로 가져간다.
        Map<Plant2.LifeCycle, Set<Plant2>> plantsByLifeCycle =
                new EnumMap<>(Plant2.LifeCycle.class);
        for (Plant2.LifeCycle lc : Plant2.LifeCycle.values())
            plantsByLifeCycle.put(lc, new HashSet<>());
        for (Plant2 p : garden)
            plantsByLifeCycle.get(p.lifeCycle).add(p);
        System.out.println(plantsByLifeCycle);

    }
}