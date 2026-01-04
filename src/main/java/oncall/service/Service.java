package oncall.service;

import oncall.domain.WorkTable;
import oncall.domain.WorkTableElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Deque;
import java.util.Objects;

public class Service {
    public WorkTable createWorktable(String[] monthAndStartDay, Deque<String> weekdayWorkers, Deque<String> weekendWorkers) {

        List<WorkTableElement> workTableElements = new ArrayList<>();
        String day = "월화수목금토일";
        int idx = day.indexOf(monthAndStartDay[1]);

        for (int i = 1, j = idx; i <= 31; i++, j++) {
            workTableElements.add(new WorkTableElement(Integer.parseInt(monthAndStartDay[0]), i, day.charAt(j % 7)));
        }

        checkDay(workTableElements);
        allocateWorkers(workTableElements, weekdayWorkers, weekendWorkers);

        return new WorkTable(workTableElements);
    }

    public void allocateWorkers(List<WorkTableElement> workTableElements, Deque<String> weekdayWorkers, Deque<String> weekendWorkers) {
        String beforeWorker = null;
        for (WorkTableElement workTableElement : workTableElements) {
            Deque<String> workers = chooseWorkers(workTableElement, weekdayWorkers, weekendWorkers);

            String thisWorker = workers.poll(); // 수아

            // TODO : 리팩토링
            if (Objects.equals(beforeWorker, thisWorker)) {
                String nextWorker = workers.poll(); // 루루
                workTableElement.worker = nextWorker; // 루루
                workers.addFirst(thisWorker); // 수아
                workers.add(nextWorker); // 루루
                beforeWorker = nextWorker;
            } else {
                workTableElement.worker = thisWorker;
                workers.add(thisWorker);
                beforeWorker = thisWorker;
            }
        }
    }

    public Deque<String> chooseWorkers(WorkTableElement workTableElement, Deque<String> weekdayWorkers, Deque<String> weekendWorkers) {
        if (workTableElement.isHoliday || workTableElement.isWeekend) {
            return weekendWorkers;
        }
        return weekdayWorkers;
    }

    public void checkDay(List<WorkTableElement> workTableElements) {
        for (WorkTableElement workTableElement : workTableElements) {
            workTableElement.checkHoliday();
            workTableElement.checkWeekend();
        }
    }

}