public class DateTime extends Date{
    protected int hour;//hour of the date time
    protected int minute;//minute of the date time
    public final int MAX_HOUR = 23;//the maximum hour value
    public final int MIN_HOUR = 0;//the minimum hour value
    public final int MAX_MINUTE = 59;//the maximum minute value
    public final int MIN_MINUTE = 0;//the minimum minute value


    /**
     * constructor that gets all parameters
     * @param year year of the date
     * @param month month of the date
     * @param day day of the date
     * @param hour hour of the date time
     * @param minute minute of the date time
     */
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

    /**
     * checks if the parameter object equals this object
     * @param obj the object we want to compare this object with
     * @return true if the two objects are equal, false otherwise
     */
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

    /**
     * @return the hash value of this object
     */
    @Override
    public int hashCode() {
        return super.hashCode()*10000 + this.hour*100 + this.minute;
    }

    /**
     * @return a string that describes the function
     */
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

    /**
     * set the hour
     * @param hour new hour of the date time
     */
    public void setHour(int hour) {
        if(hour < MIN_HOUR || hour > MAX_HOUR){
            this.hour = 0;
        }
        else{
            this.hour = hour;
        }
    }

    /**
     * set the minute
     * @param minute new minute of the date time
     */
    public void setMinute(int minute) {
        if(minute < MIN_MINUTE || minute > MAX_MINUTE){
            this.minute = 0;
        }
        else{
            this.minute = minute;
        }
    }
}


