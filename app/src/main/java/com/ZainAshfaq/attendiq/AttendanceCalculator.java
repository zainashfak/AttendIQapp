package com.ZainAshfaq.attendiq;

public class AttendanceCalculator {

    // Max classes you can still miss and stay at or above the threshold %
    public static int safeSkips(int attended, int held, int remaining, int threshold) {
        int value = Math.floorDiv(100 * (attended + remaining) - threshold * (held + remaining), 100);
        return Math.max(0, value);
    }
}