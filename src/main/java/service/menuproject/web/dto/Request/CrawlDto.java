package service.menuproject.web.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


public class CrawlDto {
    @Getter
    @AllArgsConstructor
    public static class DateInfo{
        //날짜
        private  String date;

        //요일
        private  String dayOfWeek;

        public void setDate(String date) {
            this.date = date;
        }

        public void setDayOfWeek(String dayOfWeek) {
            this.dayOfWeek = dayOfWeek;
        }
    }

    @Getter
    @AllArgsConstructor
    public static class MenuInfo{
        // 시간대 ex. 아침, 점심, 저녁
        private  String timeSlot;

        //메뉴
        private  String menu;
    }
}
