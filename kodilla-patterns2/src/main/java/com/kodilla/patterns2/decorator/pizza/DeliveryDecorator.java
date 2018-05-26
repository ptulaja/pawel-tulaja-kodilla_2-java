package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class DeliveryDecorator extends AbstractPizzaOrderDecorator {
    public DeliveryDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getPizzaPrice(){
        return super.getPizzaPrice().add(new BigDecimal(4));
    }

    @Override
    public String getPizzaDescription(){
        return super.getPizzaDescription() + " and delivery to your house";
    }

}
