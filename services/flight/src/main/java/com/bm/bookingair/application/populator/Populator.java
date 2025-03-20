package com.bm.bookingair.application.populator;

public interface Populator<S, T> {
    void populate(S source, T target);
}
