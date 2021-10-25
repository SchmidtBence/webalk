package com.autocompany;

import com.autocompany.impl.BelsoEgesuMotor;

public class Main {

    public static void main(String[] args){
        Motor motor16=new BelsoEgesuMotor(180,1600);

        Auto opelAstra=new Auto(motor16,get4kerek(),"Opel Astra");

        System.out.println(opelAstra);
    }
    private static Kerek[] get4kerek() {
        Kerek[] kereks=new Kerek[4];
        for (int i=0; i<4; i++){
            kereks[i]=new com.autocompany.impl.KerekImpl(205,15,65);
        }
        return kereks;
    }
}

