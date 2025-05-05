package org.example.common.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PositiveIntegerCounterTest {

    @Test
    void givenCreate_whenIncrease_thenCountIsOne() {
        //given
        PositiveIntegerCounter counter = new PositiveIntegerCounter();

        //when
        counter.increment();

        //then
        assertEquals(1, counter.getCount());
    }

    @Test
    void givenCreateAndIncrease_whenDecrease_thenCountIsZero() {
        //given
        PositiveIntegerCounter counter = new PositiveIntegerCounter();
        counter.increment();

        //when
        counter.decrement();

        //then
        assertEquals(0, counter.getCount());
    }


}
