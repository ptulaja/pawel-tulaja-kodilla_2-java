package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class BasicPizzaOrder implements PizzaOrder {
    @Override
    public BigDecimal getPizzaPrice() {
        return new BigDecimal(15);
    }

    @Override
    public String getPizzaDescription() {
        return "Pizza with tomsto sos and cheese";
    }
}
