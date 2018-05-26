package com.kodilla.patterns2.decorator.pizza;

import com.kodilla.patterns2.decorator.taxiportal.ExpressDecorator;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PizzaOrderTestSuite {

    @Test
    public void testBasicPizzaWithExtraMushroomsAndHam() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new MushroomsDecorator(theOrder);
        theOrder = new HamDecorator(theOrder);

        //When

        BigDecimal price = theOrder.getPizzaPrice();
        String pizzaDescription = theOrder.getPizzaDescription();
        System.out.println(pizzaDescription);
        System.out.println("Total price: " + price + " PLN.");

        //Then
        Assert.assertEquals(new BigDecimal(22), price);
        Assert.assertEquals("Pizza with tomato sos and cheese," +
                " extra mushrooms, extra ham", pizzaDescription);
    }

    @Test
    public void testBasicPizzaWithExtramushroomsAndHamandDelivery() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new MushroomsDecorator(theOrder);
        theOrder = new HamDecorator(theOrder);
        theOrder = new DeliveryDecorator(theOrder);

        //When
        BigDecimal price = theOrder.getPizzaPrice();
        String pizzaDescription = theOrder.getPizzaDescription();
        System.out.println(pizzaDescription);
        System.out.println("Total price: " + price + " PLN.");

        //Then
        Assert.assertEquals(new BigDecimal(26), price);
        Assert.assertEquals("Pizza with tomato sos and cheese," +
                " extra mushrooms, extra ham and delivery to your house", pizzaDescription);
    }

}