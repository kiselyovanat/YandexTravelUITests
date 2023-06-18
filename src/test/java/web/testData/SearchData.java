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
}
