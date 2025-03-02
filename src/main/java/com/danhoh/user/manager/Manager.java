package com.danhoh.user.manager;

public interface Manager<IN, OUT> {

    OUT process(IN input);
}
