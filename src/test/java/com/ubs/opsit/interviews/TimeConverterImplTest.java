package com.ubs.opsit.interviews;

import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalTime;

import static org.junit.Assert.*;

public class TimeConverterImplTest {

	static TimeConverterImpl timeConverter;

	@BeforeClass
	public static void before(){
		timeConverter = new TimeConverterImpl();
	}

	@Test
	public void makeFiveHourRow() throws Exception {
		assertNotNull(timeConverter.makeFiveHourRow(LocalTime.parse("01:00")));
		assertEquals(timeConverter.makeFiveHourRow(LocalTime.parse("01:00")), "OOOO");
		assertEquals(timeConverter.makeFiveHourRow(LocalTime.parse("05:00")), "ROOO");
		assertEquals(timeConverter.makeFiveHourRow(LocalTime.parse("12:00")), "RROO");
		assertEquals(timeConverter.makeFiveHourRow(LocalTime.parse("15:00")), "RRRO");
		assertEquals(timeConverter.makeFiveHourRow(LocalTime.parse("21:00")), "RRRR");
	}

	@Test
	public void makeOneHourRow() throws Exception {
		assertEquals(timeConverter.makeOneHourRow(LocalTime.parse("00:00")), "OOOO");
		assertEquals(timeConverter.makeOneHourRow(LocalTime.parse("01:00")), "ROOO");
		assertEquals(timeConverter.makeOneHourRow(LocalTime.parse("02:00")), "RROO");
		assertEquals(timeConverter.makeOneHourRow(LocalTime.parse("03:00")), "RRRO");
		assertEquals(timeConverter.makeOneHourRow(LocalTime.parse("04:00")), "RRRR");
	}

	@Test
	public void makeFiveMinutesRow() throws Exception {
		assertEquals(timeConverter.makeFiveMinutesRow(LocalTime.parse("00:00")), "OOOOOOOOOOO");
		assertEquals(timeConverter.makeFiveMinutesRow(LocalTime.parse("00:15")), "YYROOOOOOOO");
		assertEquals(timeConverter.makeFiveMinutesRow(LocalTime.parse("00:30")), "YYRYYROOOOO");
		assertEquals(timeConverter.makeFiveMinutesRow(LocalTime.parse("00:45")), "YYRYYRYYROO");
		assertEquals(timeConverter.makeFiveMinutesRow(LocalTime.parse("00:59")), "YYRYYRYYRYY");
	}

	@Test
	public void makeOneMinuteRow() throws Exception {
		assertEquals(timeConverter.makeOneMinuteRow(LocalTime.parse("00:00")), "OOOO");
		assertEquals(timeConverter.makeOneMinuteRow(LocalTime.parse("00:01")), "YOOO");
		assertEquals(timeConverter.makeOneMinuteRow(LocalTime.parse("00:04")), "YYYY");
	}

}