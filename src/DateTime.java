public class DateTime extends Date{
    protected int hour;
    protected int minute;
    public final int MAX_HOUR = 23;
    public final int MIN_HOUR = 0;
    public final int MAX_MINUTE = 59;
    public final int MIN_MINUTE = 0;


    public DateTime(int year, int month, int day, int hour, int minute) {
        super(year, month, day);
        if(hour < MIN_HOUR || hour > MAX_HOUR){
            this.hour = 0;
        }
        else{
            this.hour = hour;
        }
        if(minute < MIN_MINUTE || minute > MAX_MINUTE){
            this.minute = 0;
        }
        else{
            this.minute = minute;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null || !(obj instanceof DateTime) || !(super.equals(obj))){
            return false;
        }
        DateTime otherDate = (DateTime)obj;
        return this.hour == otherDate.hour && this.minute == otherDate.minute;
    }

    @Override
    public int hashCode() {
        return super.hashCode()*10000 + this.hour*100 + this.minute;
    }

    @Override
    public String toString() {
        String hourStr = String.valueOf(this.hour);
        String minuteStr = String.valueOf(this.minute);
        if(this.hour < 10)
            hourStr = "0"+hourStr;
        if(this.minute < 10)
            minuteStr = "0" + minuteStr;
        return super.toString() + " " + hourStr+ ":"+ minuteStr;
    }

    public void setHour(int hour) {
        if(hour < MIN_HOUR || hour > MAX_HOUR){
            this.hour = 0;
        }
        else{
            this.hour = hour;
        }
    }

    public void setMinute(int minute) {
        if(minute < MIN_MINUTE || minute > MAX_MINUTE){
            this.minute = 0;
        }
        else{
            this.minute = minute;
        }
    }
}


