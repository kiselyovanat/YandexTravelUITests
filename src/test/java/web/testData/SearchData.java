package web.testData;

public class AviaSearchData {
    private String city,
    startDay,
    startMonth,
    endDay,
    endMonth;

    public String getCity() {
        return city;
    }

    public AviaSearchData setCity(String city) {
        this.city = city;
        return this;
    }

    public String getStartDay() {
        return startDay;
    }

    public AviaSearchData setStartDay(String startDay) {
        this.startDay = startDay;
        return this;
    }

    public String getStartMonth() {
        return startMonth;
    }

    public AviaSearchData setStartMonth(String startMonth) {
        this.startMonth = startMonth;
        return this;
    }

    public String getEndDay() {
        return endDay;
    }

    public AviaSearchData setEndDay(String endDay) {
        this.endDay = endDay;
        return this;
    }

    public String getEndMonth() {
        return endMonth;
    }

    public AviaSearchData setEndMonth(String endMonth) {
        this.endMonth = endMonth;
        return this;
    }
}
