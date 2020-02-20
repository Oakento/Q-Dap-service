package com.zjuqsc.qscdap.util;

public class SnowFlake {

    private final static long START_TIME_STAMP = 1582128018000L;
    private final static long WORKER_ID_BIT = 5L;
    private final static long DATA_CENTER_BIT = 5L;
    private final static long SEQUENCE_BIT = 12L;
    private final static long MAX_WORKER_ID = ~(-1L << WORKER_ID_BIT);
    private final static long MAX_DATA_CENTER_ID = ~(-1L << DATA_CENTER_BIT);
    private final static long MAX_SEQUENCE_BIT = ~(-1L << SEQUENCE_BIT);

    private final static long WORKER_ID_SHIFT = SEQUENCE_BIT;
    private final static long DATA_CENTER_ID_SHIFT = SEQUENCE_BIT + WORKER_ID_BIT;
    private final static long TIME_STAMP_SHIFT = DATA_CENTER_ID_SHIFT + DATA_CENTER_BIT;

    private long workerId;
    private long dataCenterId;
    private long sequence = 0L;
    private long lastTimeStamp = -1L;

    public SnowFlake(long workerId, long dataCenterId) {
        if (workerId > MAX_WORKER_ID || workerId < 0) {
            throw new IllegalArgumentException("workerId can't be greater than MAX_WORKER_ID or less than 0");
        }
        if (dataCenterId > MAX_DATA_CENTER_ID || dataCenterId < 0) {
            throw new IllegalArgumentException("dataCenterId can't be greater than MAX_DATA_CENTER_ID or less than 0");
        }

        this.workerId = workerId;
        this.dataCenterId = dataCenterId;
    }

    public synchronized long nextId() {
        long currentTimeStamp = getNewTimeStamp();
        if (currentTimeStamp < lastTimeStamp) {
            throw new RuntimeException("Clock moved backwards. Refusing to generate id.");
        }

        if (currentTimeStamp == lastTimeStamp) {
            sequence = (sequence + 1) & MAX_SEQUENCE_BIT;
            // overflow
            if (sequence == 0L) {
                currentTimeStamp = getNextMillis();
            }
        } else {
            sequence = 0L;
        }

        lastTimeStamp = currentTimeStamp;

        return (currentTimeStamp - START_TIME_STAMP) << TIME_STAMP_SHIFT
                | dataCenterId << DATA_CENTER_ID_SHIFT
                | workerId << WORKER_ID_SHIFT
                | sequence;
    }

    private long getNextMillis() {
        long timeStamp = getNewTimeStamp();
        while (timeStamp <= lastTimeStamp) {
            timeStamp = getNewTimeStamp();
        }
        return timeStamp;
    }

    private long getNewTimeStamp() {
        return System.currentTimeMillis();
    }
}

