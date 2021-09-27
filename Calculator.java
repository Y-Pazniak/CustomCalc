package com.example.customcalcv3;

import java.util.HashMap;

public class Calculator {
    //price double M1
    private static final double priceLegkovayaYoung = 544.50;
    private static final double priceLegkovayaMiddle = 816.70;
    private static final double priceLegkovayaOld = 1225.10;
    private static final double priceJurFuelLess1000Young = 1652.2;
    private static final double priceJurFuelLess1000Middle = 5771.7;
    private static final double priceJurFuelLess1000Old = 8657.6;
    private static final double priceJurFuelBetween1000And2000Young = 6115.2;
    private static final double priceJurFuelBetween1000And2000Middle = 8995.1;
    private static final double priceJurFuelBetween1000And2000Old = 13492.7;
    private static final double priceJurFuelBetween2000And3000Young = 9652.7;
    private static final double priceJurFuelBetween2000And3000Middle = 17554.7;
    private static final double priceJurFuelBetween2000And3000Old = 26332.1;
    private static final double priceJurFuelBetween3000And3500Young = 8898.6;
    private static final double priceJurFuelBetween3000And3500Middle = 31036.5;
    private static final double priceJurFuelBetween3000And3500Old = 46554.8;
    private static final double priceJurFuelMore3500Young = 15253.7;
    private static final double priceJurFuelMore3500Middle = 38125.9;
    private static final double priceJurFuelMore3500Old = 57188.9;

    //price double N1
    private static final double priceNeLegkovaya2TYoung = 4083.7;
    private static final double priceNeLegkovaya2TMiddle = 7187.4;
    private static final double priceNeLegkovaya2TOld = 10781.1;
    private static final double priceNeLegkovaya2Between3TYoung = 6534.0;
    private static final double priceNeLegkovaya2Between3TMiddle = 10209.4;
    private static final double priceNeLegkovaya2Between3TOld = 15314.1;
    private static final double priceNeLegkovaya3Between5TYoung = 8167.5;
    private static final double priceNeLegkovaya3Between5TMiddle = 13068.0;
    private static final double priceNeLegkovaya3Between5TOld = 19602.0;
    private static final double priceNeLegkovaya5Between8TYoung = 8984.2;
    private static final double priceNeLegkovaya5Between8TMiddle = 37243.8;
    private static final double priceNeLegkovaya5Between8TOld = 55865.7;
    private static final double priceNeLegkovaya8Between12TYoung = 10944.4;
    private static final double priceNeLegkovaya8Between12TMiddle = 56437.5;
    private static final double priceNeLegkovaya8Between12TOld = 84656.3;
    private static final double priceNeLegkovaya12Between20TYoung = 12006.3;
    private static final double priceNeLegkovaya12Between20TMiddle = 82165.0;
    private static final double priceNeLegkovaya12Between20TOld = 123247.5;
    private static final double priceNeLegkovaya20Between30TYoung = 12600.0;
    private static final double priceNeLegkovaya20Between30TMiddle = 86300.0;
    private static final double priceNeLegkovaya20Between30TOld = 129450.0;
    private static final double priceNeLegkovaya30Between50TYoung = 23685.7;
    private static final double priceNeLegkovaya30Between50TMiddle = 96376.5;
    private static final double priceNeLegkovaya30Between50TOld = 144564.8;
    private static final double priceNeLegkovayaElectroYoung = 4900.5;
    private static final double priceNeLegkovayaElectroMiddleAndOld = 8167.5;
    private static final double priceNeLegkovaya2500Young = 4900.5;
    private static final double priceNeLegkovaya2500Middle = 8167.5;
    private static final double priceNeLegkovaya2500Old = 12251.3;
    private static final double priceNeLegkovaya2500Between5000Young = 9801.0;
    private static final double priceNeLegkovaya2500Between5000Middle = 24502.5;
    private static final double priceNeLegkovaya2500Between5000Old = 36753.8;
    private static final double priceNeLegkovaya5000Between10000Young = 13068.0;
    private static final double priceNeLegkovaya5000Between10000Middle = 35937.0;
    private static final double priceNeLegkovaya5000Between10000Old = 53905.5;
    private static final double priceNeLegkovayaMore10000Young = 16335.0;
    private static final double priceNeLegkovayaMore10000Middle = 42471.0;
    private static final double priceNeLegkovayaMore10000Old = 63706.5;
    private static final double priceDumpTruck50Between80Young = 111078.0;
    private static final double priceDumpTruck50Between80Middle = 253029.1;
    private static final double priceDumpTruck50Between80Old = 379543.7;
    private static final double priceDumpTruck80Between350Young = 204187.5;
    private static final double priceDumpTruck80Between350Middle = 261360.0;
    private static final double priceDumpTruck80Between350Old = 392040.0;
    private static final double priceDumpTruckMore350Young = 302197.5;
    private static final double priceDumpTruckMore350Middle = 326700.0;
    private static final double priceDumpTruckMore350Old = 490050.0;
    private static final double trailerAndHalfTrailerYoung = 0;
    private static final double trailerAndHalfTrailerMiddle = 38640.0;
    private static final double trailerAndHalfTrailerOld = 57960.0;


    //M1 boolean
    private boolean isM1 = false;
    private boolean isJur = false;
    private boolean isAnotherCountry = false;
    private boolean isPetrol = false;
    private boolean isLess1000 = false;
    private boolean isBetween1000And2000 = false;
    private boolean isBetween2000And3000 = false;
    private boolean isBetween3000And3500 = false;
    private boolean isMore3500 = false;

    //N1 common boolean
    private boolean isElectroOffroad = false;
    private boolean isN1Offroad = false;
    private boolean isGasOffroad = false;

    //N1 dump truck weight
    private boolean isDumpTruckWeight50Between80 = false;
    private boolean isDumpTruckWeight80Between350 = false;
    private boolean isDumpTruckWeightMore350 = false;

    //N1 mass boolean
    private boolean n1Less2 = false;
    private boolean n1Between2And3 = false;
    private boolean n1Between3And5 = false;
    private boolean n1Between5And8 = false;
    private boolean n1Between8And12 = false;
    private boolean n1Between12And20 = false;
    private boolean n1Between20And30 = false;
    private boolean n1Between30And50 = false;

    //N1 volume boolean
    private boolean isN1Less2500 = false;
    private boolean isN1Between2500And5000 = false;
    private boolean isN1Between5000And10000 = false;
    private boolean isN1More10000 = false;

    //age boolean
    private boolean isAgeLess3 = false;
    private boolean isAgeBetween3And7 = false;
    private boolean isAgeMore7 = false;

//    private HashMap<String, Boolean> booleanEntries;

//    public Calculator() {
//        booleanEntries = new HashMap<>();
//        booleanEntries.put("isM1", false);
//        booleanEntries.put("isJur", false);
//        booleanEntries.put("isAnotherCountry", false);
//        booleanEntries.put("isPetrol", false);
//        booleanEntries.put("isLess1000", false);
//        booleanEntries.put("isBetween1000And2000", false);
//        booleanEntries.put("isBetween2000And3000", false);
//        booleanEntries.put("isBetween3000And3500", false);
//        booleanEntries.put("isMore3500", false);
//        booleanEntries.put("isAgeLess3", false);
//        booleanEntries.put("isAgeBetween3And7", false);
//        booleanEntries.put("isAgeMore7", false);
//    }

    public void setM1(boolean m1) {
        isM1 = m1;
    }

    public void setJur(boolean jur) {
        isJur = jur;
    }

    public void setAgeLess3(boolean ageLess3) {
        isAgeLess3 = ageLess3;
    }

    public void setAgeBetween3And7(boolean ageBetween3And7) {
        isAgeBetween3And7 = ageBetween3And7;
    }

    public void setAgeMore7(boolean ageMore7) {
        isAgeMore7 = ageMore7;
    }

    public void setAnotherCountry(boolean anotherCountry) {
        isAnotherCountry = anotherCountry;
    }

    public void setPetrol(boolean petrol) {
        isPetrol = petrol;
    }

    public void setLess1000(boolean less1000) {
        isLess1000 = less1000;
    }

    public void setBetween1000And2000(boolean between1000And2000) {
        isBetween1000And2000 = between1000And2000;
    }

    public void setBetween2000And3000(boolean between2000And3000) {
        isBetween2000And3000 = between2000And3000;
    }

    public void setBetween3000And3500(boolean between3000And3500) {
        isBetween3000And3500 = between3000And3500;
    }

    public void setMore3500(boolean more3500) {
        isMore3500 = more3500;
    }

    public void setN1Less2(boolean n1Less2) {
        this.n1Less2 = n1Less2;
    }

    public void setN1Between2And3(boolean n1Between2And3) {
        this.n1Between2And3 = n1Between2And3;
    }

    public void setN1Between3And5(boolean n1Between3And5) {
        this.n1Between3And5 = n1Between3And5;
    }

    public void setN1Between5And8(boolean n1Between5And8) {
        this.n1Between5And8 = n1Between5And8;
    }

    public void setN1Between8And12(boolean n1Between8And12) {
        this.n1Between8And12 = n1Between8And12;
    }

    public void setN1Between12And20(boolean n1Between12And20) {
        this.n1Between12And20 = n1Between12And20;
    }

    public void setN1Between20And30(boolean n1Between20And30) {
        this.n1Between20And30 = n1Between20And30;
    }

    public void setN1Between30And50(boolean n1Between30And50) {
        this.n1Between30And50 = n1Between30And50;
    }

    public void setElectroOffroad(boolean electroOffroad) {
        isElectroOffroad = electroOffroad;
    }

    public void setN1Offroad(boolean n1Offroad) {
        isN1Offroad = n1Offroad;
    }

    public void setN1Less2500(boolean n1Less2500) {
        isN1Less2500 = n1Less2500;
    }

    public void setN1Between2500And5000(boolean n1Between2500And5000) {
        isN1Between2500And5000 = n1Between2500And5000;
    }

    public void setN1Between5000And10000(boolean n1Between5000And10000) {
        isN1Between5000And10000 = n1Between5000And10000;
    }

    public void setGasOffroad(boolean gasOffroad) {
        isGasOffroad = gasOffroad;
    }

    public void setDumpTruckWeight50Between80(boolean dumpTruckWeight50Between80) {
        isDumpTruckWeight50Between80 = dumpTruckWeight50Between80;
    }

    public void setDumpTruckWeight80Between350(boolean dumpTruckWeight80Between350) {
        isDumpTruckWeight80Between350 = dumpTruckWeight80Between350;
    }

    public void setDumpTruckWeightMore350(boolean dumpTruckWeightMore350) {
        isDumpTruckWeightMore350 = dumpTruckWeightMore350;
    }

    public void setN1More10000(boolean n1More10000) {
        isN1More10000 = n1More10000;
    }

    public double getCount(){
        if (isM1){ //calculate car
            if (!isAnotherCountry || !isJur) {
                if (isAgeLess3) return priceLegkovayaYoung;
                if (isAgeBetween3And7) return priceLegkovayaMiddle;
                if (isAgeMore7) return priceLegkovayaOld;
            } else {
                if (!isPetrol){
                    if (isAgeLess3) return priceLegkovayaYoung;
                    if (isAgeBetween3And7) return priceLegkovayaMiddle;
                    if (isAgeMore7) return priceLegkovayaMiddle;
                } else {
                    if (isAgeLess3){
                        if(isLess1000) return priceJurFuelLess1000Young;
                        if(isBetween1000And2000) return priceJurFuelBetween1000And2000Young;
                        if(isBetween2000And3000) return priceJurFuelBetween2000And3000Young;
                        if(isBetween3000And3500) return priceJurFuelBetween3000And3500Young;
                        if(isMore3500) return priceJurFuelMore3500Young;
                    }
                    if (isAgeBetween3And7){
                        if(isLess1000) return priceJurFuelLess1000Middle;
                        if(isBetween1000And2000) return priceJurFuelBetween1000And2000Middle;
                        if(isBetween2000And3000) return priceJurFuelBetween2000And3000Middle;
                        if(isBetween3000And3500) return priceJurFuelBetween3000And3500Middle;
                        if(isMore3500) return priceJurFuelMore3500Middle;
                    }
                    if (isAgeMore7){
                        if(isLess1000) return priceJurFuelLess1000Old;
                        if(isBetween1000And2000) return priceJurFuelBetween1000And2000Old;
                        if(isBetween2000And3000) return priceJurFuelBetween2000And3000Old;
                        if(isBetween3000And3500) return priceJurFuelBetween3000And3500Old;
                        if(isMore3500) return priceJurFuelMore3500Old;
                    }
                }
            }
        }
        else { //heavy vehicles
            if (isN1Offroad){ // offroad N1 vehicles
                if (isAgeLess3) {
                    if (n1Less2) return priceNeLegkovaya2TYoung;
                    if (n1Between2And3) return priceNeLegkovaya2Between3TYoung;
                    if (n1Between3And5) return priceNeLegkovaya3Between5TYoung;
                    if (n1Between5And8) return priceNeLegkovaya5Between8TYoung;
                    if (n1Between8And12) return priceNeLegkovaya8Between12TYoung;
                    if (n1Between12And20) return priceNeLegkovaya12Between20TYoung;
                    if (n1Between20And30) return priceNeLegkovaya20Between30TYoung;
                    if (n1Between30And50) return priceNeLegkovaya30Between50TYoung;
                } else {
                    if (isAgeBetween3And7) {
                        if (n1Less2) return priceNeLegkovaya2TMiddle;
                        if (n1Between2And3) return priceNeLegkovaya2Between3TMiddle;
                        if (n1Between3And5) return priceNeLegkovaya3Between5TMiddle;
                        if (n1Between5And8) return priceNeLegkovaya5Between8TMiddle;
                        if (n1Between8And12) return priceNeLegkovaya8Between12TMiddle;
                        if (n1Between12And20) return priceNeLegkovaya12Between20TMiddle;
                        if (n1Between20And30) return priceNeLegkovaya20Between30TMiddle;
                        if (n1Between30And50) return priceNeLegkovaya30Between50TMiddle;
                    } else {
                        if (isAgeMore7) {
                            if (n1Less2) return priceNeLegkovaya2TOld;
                            if (n1Between2And3) return priceNeLegkovaya2Between3TOld;
                            if (n1Between3And5) return priceNeLegkovaya3Between5TOld;
                            if (n1Between5And8) return priceNeLegkovaya5Between8TOld;
                            if (n1Between8And12) return priceNeLegkovaya8Between12TOld;
                            if (n1Between12And20) return priceNeLegkovaya12Between20TOld;
                            if (n1Between20And30) return priceNeLegkovaya20Between30TOld;
                            if (n1Between30And50) return priceNeLegkovaya30Between50TOld;
                        }
                    }
                }
            } else {
                if(isElectroOffroad){ //electro M2 M3 offroad
                    if (isAgeLess3) return priceNeLegkovayaElectroYoung;
                    if (isAgeBetween3And7) return priceNeLegkovayaElectroMiddleAndOld;
                    if (isAgeMore7) return priceNeLegkovayaElectroMiddleAndOld;
                } else {
                    if (isGasOffroad) { //gas M2 M3 offroad
                    if (isAgeLess3) {
                        if (isN1Less2500) return priceNeLegkovaya2500Young;
                        if (isN1Between2500And5000) return priceNeLegkovaya2500Between5000Young;
                        if (isN1Between5000And10000) return priceNeLegkovaya5000Between10000Young;
                        if (isN1More10000) return priceNeLegkovayaMore10000Young;
                    } else {
                        if (isAgeBetween3And7) {
                            if (isN1Less2500) return priceNeLegkovaya2500Middle;
                            if (isN1Between2500And5000)
                                return priceNeLegkovaya2500Between5000Middle;
                            if (isN1Between5000And10000)
                                return priceNeLegkovaya5000Between10000Middle;
                            if (isN1More10000) return priceNeLegkovayaMore10000Middle;
                        } else {
                            if (isAgeMore7) {
                                if (isN1Less2500) return priceNeLegkovaya2500Old;
                                if (isN1Between2500And5000)
                                    return priceNeLegkovaya2500Between5000Old;
                                if (isN1Between5000And10000)
                                    return priceNeLegkovaya5000Between10000Old;
                                if (isN1More10000) return priceNeLegkovayaMore10000Old;
                            }
                        }
                    }
                } else { //dump trucks
                        if (isDumpTruckWeight50Between80){
                            if (isAgeLess3) return priceDumpTruck50Between80Young;
                            if (isAgeBetween3And7) return priceDumpTruck50Between80Middle;
                            if (isAgeMore7) return priceDumpTruck50Between80Old;
                        } else {
                            if (isDumpTruckWeight80Between350){
                                if (isAgeLess3) return priceDumpTruck80Between350Young;
                                if (isAgeBetween3And7) return priceDumpTruck80Between350Middle;
                                if (isAgeMore7) return priceDumpTruck80Between350Old;
                            } else {
                                if (isDumpTruckWeightMore350){
                                    if (isAgeLess3) return priceDumpTruckMore350Young;
                                    if (isAgeBetween3And7) return priceDumpTruckMore350Middle;
                                    if (isAgeMore7) return priceDumpTruckMore350Old;
                                } else //trailers
                                    if (isAgeLess3) return trailerAndHalfTrailerYoung;
                                    if (isAgeBetween3And7) return trailerAndHalfTrailerMiddle;
                                    if (isAgeMore7) return trailerAndHalfTrailerOld;
                                }
                            }
                        }
                    }
                }
            }
        return 100.0;
    }
}