import java.util.Objects;

public class Date {
    protected int day;
    protected int month;
    protected int year;
    public final int MAX_DAY = 31;
    public final int MIN_DAY = 1;
    public final int MAX_MONTH = 12;
    public final int MIN_MONTH = 1;
    public final int MAX_YEAR = 3999;
    public final int MIN_YEAR = -3999;


    public Date(int year, int month, int day) {
        if(day > MAX_DAY || day < MIN_DAY){
            this.day = 1;
        }
        else{
            this.day = day;
        }
        if(month > MAX_MONTH || month < MIN_MONTH){
            this.month = 1;
        }
        else{
            this.month = month;
        }
        if(year < MIN_YEAR || year > MAX_YEAR){
            this.year = 0;
        }
        else{
            this.year = year;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null || !(obj instanceof Date) || obj.toString().length() > 11){
            return false;
        }
        Date otherDate = (Date)obj;
        return this.day == otherDate.day && this.month == otherDate.month && this.year == otherDate.year;
    }

    @Override
    public int hashCode() {
        return this.day*1000000+this.month*10000+this.year;
    }


    @Override
    public String toString() {
        boolean negative = false;
        String dayStr = String.valueOf(this.day);
        String monthStr = String.valueOf(this.month);
        String yearStr = String.valueOf(this.year);

        if(year < 0){
            yearStr = String.valueOf(Math.abs(this.year));
            negative = true;
        }
        if(this.day < 10)
            dayStr = "0"+ dayStr;
        if(this.month < 10)
            monthStr = "0"+ monthStr;
        if(this.year < 1000 && this.year > -1000) {
            int yearStrLen = yearStr.length();
            for (int i = 0; i < 4 - yearStrLen; i++) {
                yearStr = "0" + yearStr;
            }
        }
        if (negative)
            yearStr = "-" + yearStr;
        return dayStr + "/" + monthStr + "/" + yearStr;
    }

    public void setMonth(int month) {
        if(month > MAX_MONTH || month < MIN_MONTH){
            this.month = 1;
        }
        else{
            this.month = month;
        }
    }

    public void setDay(int day) {
        if(day > MAX_DAY || day < MIN_DAY){
            this.day = 1;
        }
        else{
            this.day = day;
        }
    }

    public void setYear(int year) {
        if(year < MIN_YEAR || year > MAX_YEAR){
            this.year = 0;
        }
        else{
            this.year = year;
        }
    }
}
