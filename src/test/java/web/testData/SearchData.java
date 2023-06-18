package web.testData;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchData {
    private String departureCity,
            destinationCity,
            startDay,
            startMonth,
            endDay,
            endMonth;

//    public String getDepartureCity() {
//        return departureCity;
//    }
//
//    public SearchData setDepartureCity(String departureCity) {
//        this.departureCity = departureCity;
//        return this;
//    }
//
//    public String getDestinationCity() {
//        return destinationCity;
//    }
//
//    public SearchData setDestinationCity(String destinationCity) {
//        this.destinationCity = destinationCity;
//        return this;
//    }
//
//    public String getStartDay() {
//        return startDay;
//    }
//
//    public SearchData setStartDay(String startDay) {
//        this.startDay = startDay;
//        return this;
//    }
//
//    public String getStartMonth() {
//        return startMonth;
//    }
//
//    public SearchData setStartMonth(String startMonth) {
//        this.startMonth = startMonth;
//        return this;
//    }
//
//    public String getEndDay() {
//        return endDay;
//    }
//
//    public SearchData setEndDay(String endDay) {
//        this.endDay = endDay;
//        return this;
//    }
//
//    public String getEndMonth() {
//        return endMonth;
//    }
//
//    public SearchData setEndMonth(String endMonth) {
//        this.endMonth = endMonth;
//        return this;
//    }
}
