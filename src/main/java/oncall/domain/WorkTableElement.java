package oncall.domain;

public class WorkTableElement {
    public int month;
    public int date;
    public Character day;
    public String worker;
    public boolean isWeekend;
    public boolean isHoliday;

    public WorkTableElement(int month, int date, Character day) {
        this.day = day;
        this.date = date;
        this.month = month;

        isHoliday = false;
        isWeekend = false;
    }

    public void checkWeekend() {
        if (day.equals('토') || day.equals('일')) {
            isWeekend = true;
        }
    }

    public void checkHoliday() {
        if (month == 1 && date == 1) {
            isHoliday = true;
        }
        if (month == 3 && date == 1) {
            isHoliday = true;
        }
        if (month == 5 && date == 5) {
            isHoliday = true;
        }
        if (month == 6 && date == 6) {
            isHoliday = true;
        }
        if (month == 8 && date == 15) {
            isHoliday = true;
        }
        if (month == 10 && (date == 3 || date == 9)) {
            isHoliday = true;
        }
        if (month == 12 && date == 25) {
            isHoliday = true;
        }
    }

    @Override
    public String toString() {
        String holiday = " ";
        if (isHoliday) {
            holiday = "(휴일) ";
        }
        return month + "월 " + date + "일 " + day + holiday + worker;
    }
}
