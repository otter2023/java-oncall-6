package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import oncall.domain.WorkTable;
import oncall.domain.WorkTableElement;
import oncall.util.Parser;
import oncall.util.Validate;

public class View {

    public String[] readAllocatedSchedule() {
        System.out.print("비상 근무를 배정할 월과 시작 요일을 입력하세요>");
        String[] strings = Parser.splitComma(Console.readLine());
        Validate.month(strings[0]);
        Validate.day(strings[1]);
        return strings;
    }

    public String[] readWeekdayWorkers() {
        System.out.print("평일 비상 근무 순번대로 사원 닉네임을 입력하세요>");
        String[] names = Parser.splitComma(Console.readLine());
        Validate.worker(names);
        return names;
    }

    public String[] readWeekendWorkers() {
        System.out.print("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요>");
        String[] names = Parser.splitComma(Console.readLine());
        Validate.worker(names);
        return names;
    }

    public void printWorkTable(WorkTable workTable) {
        for (WorkTableElement workTableElement : workTable.workTableElements) {
            System.out.println(workTableElement);
        }
    }
}
