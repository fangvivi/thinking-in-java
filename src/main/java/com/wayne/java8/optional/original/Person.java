package com.wayne.java8.optional.original;

/**
 * @author wayne
 */
public class Person {
    private Car car;

    public Car getCar() {
        return car;
    }

    public static void main(String[] args) {
        Person p = new Person();
        String result = p.getCarInsuranceName(p);
        System.out.println(result);
    }

    public String getCarInsuranceName(Person person){

        if(person==null){
            return "Unknown";
        }
        Car car = person.getCar();
        if (car == null) {
            return "Unknown";
        }
        Insurance insurance = car.getInsurance();
        if (insurance == null) {
            return "Unknown";
        }
        return insurance.getName();
    }
}

