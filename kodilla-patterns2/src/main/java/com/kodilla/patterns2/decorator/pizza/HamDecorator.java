package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class HamDecorator extends AbstractPizzaOrderDecorator {
    public HamDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getPizzaPrice(){
        return super.getPizzaPrice().add(new BigDecimal(5));
    }

    @Override
    public String getPizzaDescription(){
        return super.getPizzaDescription() + ", extra ham";
    }
}
