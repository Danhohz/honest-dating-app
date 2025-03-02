package com.danhoh.user.manager;

@FunctionalInterface
public interface Manager<IN, OUT> {

    OUT process(IN input);
}
