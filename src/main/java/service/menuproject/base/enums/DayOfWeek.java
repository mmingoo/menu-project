package service.menuproject.base.enums;

public enum DayOfWeek {
    월요일("월"),
    화요일("화"),
    수요일("수"),
    목요일("목"),
    금요일("금"),
    토요일("토"),
    일요일("일");

    private final String shortName;

    DayOfWeek(String shortName) {
        this.shortName = shortName;
    }

    public static DayOfWeek fromShortName(String shortName) {
        for (DayOfWeek day : values()) {
            if (day.shortName.equals(shortName)) {
                return day;
            }
        }
        throw new IllegalArgumentException("Invalid day: " + shortName);
    }
}
