package com.ubs.opsit.interviews;

import org.apache.commons.lang.StringUtils;

import java.time.LocalTime;

import static java.lang.System.lineSeparator;

class TimeConverterImpl implements TimeConverter {
    @Override
    public String convertTime(String aTime) {
        LocalTime time = parseTime(aTime);
        return makeSecondsRow(time) + lineSeparator()
                + makeFiveHourRow(time) + lineSeparator()
                + makeOneHourRow(time) + lineSeparator()
                + makeFiveMinutesRow(time) + lineSeparator()
                + makeOneMinuteRow(time);
    }

    private LocalTime parseTime(String aTime) {
        return LocalTime.parse(aTime);
    }

    String makeFiveHourRow(LocalTime localTime) {
        return fillRow("R", localTime.getHour() / 5, 4);
    }

    String makeOneHourRow(LocalTime localTime) {
        return fillRow("R", localTime.getHour() % 5, 4);
    }

    String makeFiveMinutesRow(LocalTime localTime) {
        return fillRow("Y", localTime.getMinute() / 5, 11).replace("YYY", "YYR");
    }

    String makeOneMinuteRow(LocalTime localTime) {
        return fillRow("Y", localTime.getMinute() % 5, 4);
    }

     String makeSecondsRow(LocalTime localTime) {
        return localTime.getSecond() % 2 == 0 ? "Y" : "O";
    }

    String fillRow(String lampColor, int lightningLamps, int allLamps) {
        return StringUtils.repeat(lampColor, lightningLamps) + StringUtils.repeat("O", allLamps - lightningLamps);
    }
}
