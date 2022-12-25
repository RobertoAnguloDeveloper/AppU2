package com.udc.aau2.ejercicios;

import java.util.Random;

public class Ej2 {
    private Random randomNumber;

    public Ej2(){
        this.randomNumber = new Random();
    }

    public Integer randomId(int [] array){
        int random = 0;

        random = this.randomNumber.nextInt(array.length);

        return random;
    }

    public Integer randomTime(){
        int random = 0;

        random = this.randomNumber.nextInt(100)+200;

        return random;
    }
}
