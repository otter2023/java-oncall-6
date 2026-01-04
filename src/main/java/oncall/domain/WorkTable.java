package oncall.domain;

import java.util.List;

public class WorkTable {
    public List<WorkTableElement> workTableElements;

    public WorkTable(List<WorkTableElement> workTableElements) {
        this.workTableElements = workTableElements;
    }
}
