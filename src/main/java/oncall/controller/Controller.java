package oncall.controller;

import oncall.domain.WorkTable;
import oncall.service.Service;
import oncall.view.View;

import java.util.*;

public class Controller {

    private final Service service;
    private final View view;

    public Controller(View view, Service service) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        String[] monthAndStartDay = readAllocatedSchedule();

        List<String[]> workersName = readWorkersName();
        Deque<String> weekdayWorkers = new LinkedList<>(Arrays.asList(workersName.get(0)));
        Deque<String> weekendWorkers = new LinkedList<>(Arrays.asList(workersName.get(1)));

        WorkTable workTable = service.createWorktable(monthAndStartDay, weekdayWorkers, weekendWorkers);

        view.printWorkTable(workTable);
    }

    private String[] readAllocatedSchedule() {
        while (true) {
            try {
                return view.readAllocatedSchedule();
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<String[]> readWorkersName() {
        while (true) {
            try {
                String[] weekdayInput = view.readWeekdayWorkers();
                String[] weekendInput = view.readWeekendWorkers();

                List<String[]> input = new ArrayList<>();
                input.add(weekdayInput);
                input.add(weekendInput);

                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
