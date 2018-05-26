package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class AbstractPizzaOrderDecorator implements PizzaOrder {
    private final PizzaOrder pizzaOrder;

    protected AbstractPizzaOrderDecorator(PizzaOrder pizzaOrder) {
        this.pizzaOrder = pizzaOrder;
    }

    @Override
    public BigDecimal getPizzaPrice() {
        return pizzaOrder.getPizzaPrice();
    }

    @Override
    public String getPizzaDescription() {
        return pizzaOrder.getPizzaDescription();
    }
}
