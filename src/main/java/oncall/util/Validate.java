package oncall.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validate {

    public static void worker(String[] names){
        workerNameLength(List.of(names));
        workerDuplication(List.of(names));
        workersNumber(List.of(names));
    }

    public static void workerNameLength(List<String> names){
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
            }
        }
    }

    // TODO : 중복 검증 공부
    // 중복 이름 검증 (Set 활용)
    // Set은 중복을 허용하지 않으므로, 크기가 줄어들면 중복이 있었다는 뜻
    public static void workerDuplication(List<String> names){
        Set<String> uniqueNames = new HashSet<>(names);
        if (uniqueNames.size() != names.size()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }

    public static void workersNumber(List<String> names){
        if (names.size() < 5 || names.size() > 35) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }


    public static void month(String string) {
        if (!string.matches("^[1-9]$")) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public static void day(String string) {
        if (!string.matches("^[월화수목금토일]$")){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }
}
