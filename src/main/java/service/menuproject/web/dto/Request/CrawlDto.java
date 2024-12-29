package service.menuproject.web.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


public class CrawlDto {
    @Getter
    @AllArgsConstructor
    public static class DateInfo{
        private  String date;
        private  String dayOfWeek;
    }

    @Getter
    @AllArgsConstructor
    public static class MenuInfo{
        private  String timeSlot;
        private  String menu;
    }
}
