package com.bm.bookingair.populators;

public interface Populator<S, T> {
    void populate(S source, T target);
}
