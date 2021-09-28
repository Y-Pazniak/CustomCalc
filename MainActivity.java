package com.example.customcalcv3;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private int firstStepCount = 0;
    private int secondStepCount = 0;
    private int thirdStepCount = 0;
    private int fourthStepCount = 0;
    private int fifthStepCount = 0;
    private boolean isAnotherCountry = false;
    private boolean isJur = false;
    private RadioButton legkButton;
    private RadioButton neLegkButton;
    private RadioButton jurButton;
    private RadioButton fizButton;
    private RadioButton russiaButton;
    private RadioButton anotherButton;
    private RadioButton fuelButton;
    private RadioButton electroButton;
    private RadioButton less3Years;
    private RadioButton between3And7years;
    private RadioButton more7Years;
    private RadioButton less1000Button;
    private RadioButton between1000And2000Button;
    private RadioButton between2000And3000Button;
    private RadioButton between3000And3500Button;
    private RadioButton bigger3500Button;
    private RadioButton tsN1N2N3;
    private RadioButton tsM1M2;
    private RadioButton tsSamosvalyOffroad;
    private RadioButton tsTrailers;
    private RadioButton m2OffroadElectroengine;
    private RadioButton m2OffroadPetrolEngine;
    private RadioButton less2500OffroadVolume;
    private RadioButton between2500and5000OffroadVolume;
    private RadioButton between5000and10000OffroadVolume;
    private RadioButton more10000OffroadVolume;
    private RadioButton n1Less2;
    private RadioButton n1Between2And3;
    private RadioButton n1Between3And5;
    private RadioButton n1Between5And8;
    private RadioButton n1Between8And12;
    private RadioButton n1Between12And20;
    private RadioButton n1Between20And30;
    private RadioButton n1Between30And50;
    private RadioButton dumpTruck50Between80;
    private RadioButton dumpTruck80Between350;
    private RadioButton dumpTruckMore350;
    private RadioButton trailers10;
    private RadioButton halfTrailers10;
    private Calculator calculator;
    private TextView finalText;

    View.OnClickListener radioButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RadioButton rb = (RadioButton) v;
            int buttonId = rb.getId();
            LinearLayout firstStep = findViewById(R.id.first_step);
            LinearLayout secondStep = findViewById(R.id.second_step);
            LinearLayout thirdStep = findViewById(R.id.third_step);
            LinearLayout fourthStep = findViewById(R.id.fourth_step);
            LinearLayout fifthStep = findViewById(R.id.fifth_step);

            View firstStepView;
            View secondStepView;
            View thirdStepView;
            View fourthStepView;
            switch (buttonId) {
                //first level
                case R.id.legkovoi_button:
                    if (firstStepCount < 1) {
                        neLegkButton.setEnabled(false);
                        firstStepView = getLayoutInflater()
                                .inflate(R.layout.activity_where_auto, firstStep, false);
                        firstStep.addView(firstStepView);
                        russiaButton = findViewById(R.id.rossia_button);
                        anotherButton = findViewById(R.id.another_countries_button);
                        russiaButton.setOnClickListener(radioButtonClickListener);
                        anotherButton.setOnClickListener(radioButtonClickListener);
                        calculator.setM1(true);
                        firstStepCount++;
                    }
                    break;

                case R.id.ne_legkovoi_button:
                    if (firstStepCount < 1) {
                        firstStepView = getLayoutInflater()
                                .inflate(R.layout.activity_choose_vehicle, firstStep, false);
                        firstStep.addView(firstStepView);
                        typeVehicleSetListener();
                        legkButton.setEnabled(false);
                        firstStepCount++;
                    }
                    break;

                //second level
                case R.id.rossia_button:
                case R.id.another_countries_button:
                    if (secondStepCount < 1) {
                        secondStepView = getLayoutInflater()
                                .inflate(R.layout.activity_fiz_or_jur, secondStep, false);
                        secondStep.addView(secondStepView);
                        fizButton = findViewById(R.id.phis_button);
                        jurButton = findViewById(R.id.jur_button);
                        fizButton.setOnClickListener(radioButtonClickListener);
                        jurButton.setOnClickListener(radioButtonClickListener);
                        secondStepCount++;
                        if (buttonId == R.id.another_countries_button) {
                            isAnotherCountry = true;
                            russiaButton.setEnabled(false);
                            calculator.setAnotherCountry(true);
                        } else anotherButton.setEnabled(false);
                    }
                    break;

                case R.id.ts_n1_n2_n3:
                    if (secondStepCount < 1) {
                        disableTypeHeavyVehicle(buttonId);
                        secondStepView = getLayoutInflater()
                                .inflate(R.layout.activity_mass_n1_vehicle, secondStep, false);
                        secondStep.addView(secondStepView);
                        setMassVehicleListener();
                        calculator.setN1Offroad(true);
                        secondStepCount++;
                    }
                    break;

                case R.id.ts_m2_m3:
                    if (secondStepCount < 1) {
                        disableTypeHeavyVehicle(buttonId);
                        secondStepView = getLayoutInflater()
                                .inflate(R.layout.activity_choose_type_of_engine_offroad, secondStep, false);
                        secondStep.addView(secondStepView);
                        m2OffroadElectroengine = findViewById(R.id.m2_offroad_electroengine_button);
                        m2OffroadElectroengine.setOnClickListener(radioButtonClickListener);
                        m2OffroadPetrolEngine = findViewById(R.id.m2_offroad_petrolengine_button);
                        m2OffroadPetrolEngine.setOnClickListener(radioButtonClickListener);
                        secondStepCount++;
                    }
                    break;

                case R.id.ts_offroad:
                    if (secondStepCount < 1) {
                        disableTypeHeavyVehicle(buttonId);
                        secondStepView = getLayoutInflater()
                                .inflate(R.layout.activity_dump_truck_weight, secondStep, false);
                        secondStep.addView(secondStepView);
                        setDumpTruckMassListener();
                        secondStepCount++;
                    }
                    break;

                case R.id.trailer_o4:
                    if (secondStepCount < 1) {
                        disableTypeHeavyVehicle(buttonId);
                        secondStepView = getLayoutInflater()
                                .inflate(R.layout.activity_trailers_o4_weight, secondStep, false);
                        secondStep.addView(secondStepView);
                        trailers10 = findViewById(R.id.trailers_10_button);
                        halfTrailers10 = findViewById(R.id.halftrailers_10_button);
                        trailers10.setOnClickListener(radioButtonClickListener);
                        halfTrailers10.setOnClickListener(radioButtonClickListener);
                        secondStepCount++;
                    }
                    break;


                //third level
                case R.id.phis_button:
                case R.id.jur_button:
                    if (thirdStepCount < 1) {
                        if (buttonId == R.id.jur_button) {
                            isJur = true;
                            fizButton.setEnabled(false);
                            calculator.setJur(true);
                        }
                        if (isJur && isAnotherCountry) {
                            thirdStepView = getLayoutInflater()
                                    .inflate(R.layout.activity_fuel_or_electro, thirdStep, false);
                            thirdStep.addView(thirdStepView);

                            fuelButton = findViewById(R.id.fuel_button);
                            electroButton = findViewById(R.id.electro_button);
                            fuelButton.setOnClickListener(radioButtonClickListener);
                            electroButton.setOnClickListener(radioButtonClickListener);

                        } else {
                            thirdStepView = getLayoutInflater()
                                    .inflate(R.layout.activity_age_auto, thirdStep, false);
                            thirdStep.addView(thirdStepView);
                            setAgeListener();
                            if (isJur) fizButton.setEnabled(false);
                            else jurButton.setEnabled(false);
                        }
                        thirdStepCount++;
                    }
                    break;

                case R.id.less_2_mass_button:
                    calculator.setN1Less2(true);
                case R.id.between_2_3_mass_button:
                    calculator.setN1Between2And3(true);
                case R.id.between_3_5_mass_button:
                    calculator.setN1Between3And5(true);
                case R.id.between_5_8_mass_button:
                    calculator.setN1Between5And8(true);
                case R.id.between_8_12_mass_button:
                    calculator.setN1Between8And12(true);
                case R.id.between_12_20_mass_button:
                    calculator.setN1Between12And20(true);
                case R.id.between_20_30_mass_button:
                    calculator.setN1Between20And30(true);
                case R.id.between_30_50_mass_button:
                    calculator.setN1Between30And50(true);
                    if (thirdStepCount < 1) {
                        thirdStepView = getLayoutInflater()
                                .inflate(R.layout.activity_age_auto, thirdStep, false);
                        thirdStep.addView(thirdStepView);
                        setAgeListener();
                        disableMass(buttonId);
                        thirdStepCount++;
                    }
                    break;

                case R.id.m2_offroad_electroengine_button:
                    if (thirdStepCount < 1) {
                        thirdStepView = getLayoutInflater()
                                .inflate(R.layout.activity_age_auto, thirdStep, false);
                        thirdStep.addView(thirdStepView);
                        calculator.setElectroOffroad(true);
                        setAgeListener();
                        m2OffroadPetrolEngine.setEnabled(false);
                        thirdStepCount++;
                    }
                    break;

                case R.id.m2_offroad_petrolengine_button:
                    if (thirdStepCount < 1) {
                        calculator.setGasOffroad(true);
                        thirdStepView = getLayoutInflater()
                                .inflate(R.layout.activity_offroad_engine_volume, thirdStep, false);
                        thirdStep.addView(thirdStepView);
                        m2OffroadElectroengine.setEnabled(false);
                        setOffroadVolumeListener();
                        thirdStepCount++;
                    }
                    break;

                case R.id.dump_truck_50_between_80_button:
                    calculator.setDumpTruckWeight50Between80(true);
                case R.id.dump_truck_80_between_350_button:
                    calculator.setDumpTruckWeight80Between350(true);
                case R.id.dump_truck_more_350_button:
                    calculator.setDumpTruckWeightMore350(true);
                    if (thirdStepCount < 1) {
                        thirdStepView = getLayoutInflater()
                                .inflate(R.layout.activity_age_auto, thirdStep, false);
                        thirdStep.addView(thirdStepView);
                        disableDumpTruckMass(buttonId);
                        setAgeListener();
                        thirdStepCount++;
                    }
                    break;

                case R.id.trailers_10_button:
                case R.id.halftrailers_10_button:
                    if (thirdStepCount < 1) {
                        if (buttonId == R.id.trailers_10_button) {
                            halfTrailers10.setEnabled(false);
                        } else {
                            trailers10.setEnabled(false);
                        }
                        thirdStepView = getLayoutInflater()
                                .inflate(R.layout.activity_age_auto, thirdStep, false);
                        thirdStep.addView(thirdStepView);
                        setAgeListener();
                        thirdStepCount++;
                    }
                    break;

                //fourth level
                case R.id.electro_button:
                    if (fourthStepCount < 1) {
                        fuelButton.setEnabled(false);
                        fourthStepView = getLayoutInflater()
                                .inflate(R.layout.activity_age_auto, fourthStep, false);
                        fourthStep.addView(fourthStepView);
                        setAgeListener();
                        fourthStepCount++;
                    }
                    break;

                case R.id.fuel_button:
                    electroButton.setEnabled(false);
                    if (fourthStepCount < 1) {
                        fourthStepView = getLayoutInflater()
                                .inflate(R.layout.activity_engine_volume, fourthStep, false);
                        fourthStep.addView(fourthStepView);
                        setEngineVolumeListener();
                        calculator.setPetrol(true);
                        fourthStepCount++;
                    }
                    break;

                case R.id.m2_offroad_less_2500_button:
                    calculator.setN1Less2500(true);
                case R.id.m2_offroad_between_2500_5000_button:
                    calculator.setN1Between2500And5000(true);
                case R.id.m2_offroad_between_5000_10000_button:
                    calculator.setN1Between5000And10000(true);
                case R.id.m2_offroad_more_10000_button:
                    if (fourthStepCount < 1) {
                        calculator.setN1More10000(true);
                        fourthStepView = getLayoutInflater()
                                .inflate(R.layout.activity_age_auto, fourthStep, false);
                        fourthStep.addView(fourthStepView);
                        setAgeListener();
                        setOffroadDisable(buttonId);
                        fourthStepCount++;
                    }
                    break;

                //fifth level
                case R.id.volume_less_1000_button:
                    calculator.setLess1000(true);
                case R.id.volume_between_1000_and_2000_button:
                    calculator.setBetween1000And2000(true);
                case R.id.volume_between_2000_and_3000_button:
                    calculator.setBetween2000And3000(true);
                case R.id.volume_between_3000_and_3500_button:
                    calculator.setBetween3000And3500(true);
                case R.id.volume_bigger_3500_button:
                    calculator.setMore3500(true);
                    if (fifthStepCount < 1) {
                        View fifthStepView = getLayoutInflater()
                                .inflate(R.layout.activity_age_auto, fifthStep, false);
                        fifthStep.addView(fifthStepView);
                        setAgeListener();
                        disableEngineVolume(buttonId);
                        fifthStepCount++;
                    }
                    break;

                //count level
                case R.id.age_car_less_3_button:
                    calculator.setAgeLess3(true);
                    finalText.setText("Цена: " + calculator.getCount() + " руб.");
                    between3And7years.setEnabled(false);
                    more7Years.setEnabled(false);
                    break;
                case R.id.age_car_3_7_button:
                    calculator.setAgeBetween3And7(true);
                    finalText.setText("Цена: " + calculator.getCount() + " руб.");
                    less3Years.setEnabled(false);
                    more7Years.setEnabled(false);
                    break;
                case R.id.age_car_more_7_button:
                    calculator.setAgeMore7(true);
                    finalText.setText("Цена: " + calculator.getCount() + " руб.");
                    less3Years.setEnabled(false);
                    between3And7years.setEnabled(false);
                    break;
            }
        }
    };

    private void disableTypeHeavyVehicle(int buttonId) {
        tsN1N2N3.setEnabled(false);
        tsM1M2.setEnabled(false);
        tsTrailers.setEnabled(false);
        tsSamosvalyOffroad.setEnabled(false);
        setEnable(buttonId);
    }

    private void disableDumpTruckMass(int buttonId) {
        dumpTruck50Between80.setEnabled(false);
        dumpTruck80Between350.setEnabled(false);
        dumpTruckMore350.setEnabled(false);
        setEnable(buttonId);
    }


    private void setDumpTruckMassListener() {
        dumpTruck50Between80 = findViewById(R.id.dump_truck_50_between_80_button);
        dumpTruck80Between350 = findViewById(R.id.dump_truck_80_between_350_button);
        dumpTruckMore350 = findViewById(R.id.dump_truck_more_350_button);
        dumpTruck50Between80.setOnClickListener(radioButtonClickListener);
        dumpTruck80Between350.setOnClickListener(radioButtonClickListener);
        dumpTruckMore350.setOnClickListener(radioButtonClickListener);
    }

    private void setOffroadDisable(int buttonId) {
        less2500OffroadVolume.setEnabled(false);
        between2500and5000OffroadVolume.setEnabled(false);
        between5000and10000OffroadVolume.setEnabled(false);
        more10000OffroadVolume.setEnabled(false);
        setEnable(buttonId);
    }

    private void setMassVehicleListener() {
        n1Less2 = findViewById(R.id.less_2_mass_button);
        n1Between2And3 = findViewById(R.id.between_2_3_mass_button);
        n1Between3And5 = findViewById(R.id.between_3_5_mass_button);
        n1Between5And8 = findViewById(R.id.between_5_8_mass_button);
        n1Between8And12 = findViewById(R.id.between_8_12_mass_button);
        n1Between12And20 = findViewById(R.id.between_12_20_mass_button);
        n1Between20And30 = findViewById(R.id.between_20_30_mass_button);
        n1Between30And50 = findViewById(R.id.between_30_50_mass_button);

        n1Less2.setOnClickListener(radioButtonClickListener);
        n1Between2And3.setOnClickListener(radioButtonClickListener);
        n1Between3And5.setOnClickListener(radioButtonClickListener);
        n1Between5And8.setOnClickListener(radioButtonClickListener);
        n1Between8And12.setOnClickListener(radioButtonClickListener);
        n1Between12And20.setOnClickListener(radioButtonClickListener);
        n1Between20And30.setOnClickListener(radioButtonClickListener);
        n1Between30And50.setOnClickListener(radioButtonClickListener);
    }

    private void typeVehicleSetListener() {
        tsN1N2N3 = findViewById(R.id.ts_n1_n2_n3);
        tsM1M2 = findViewById(R.id.ts_m2_m3);
        tsSamosvalyOffroad = findViewById(R.id.ts_offroad);
        tsTrailers = findViewById(R.id.trailer_o4);
        tsN1N2N3.setOnClickListener(radioButtonClickListener);
        tsM1M2.setOnClickListener(radioButtonClickListener);
        tsSamosvalyOffroad.setOnClickListener(radioButtonClickListener);
        tsTrailers.setOnClickListener(radioButtonClickListener);
    }

    private void setEngineVolumeListener() {
        less1000Button = findViewById(R.id.volume_less_1000_button);
        between1000And2000Button = findViewById(R.id.volume_between_1000_and_2000_button);
        between2000And3000Button = findViewById(R.id.volume_between_2000_and_3000_button);
        between3000And3500Button = findViewById(R.id.volume_between_3000_and_3500_button);
        bigger3500Button = findViewById(R.id.volume_bigger_3500_button);
        less1000Button.setOnClickListener(radioButtonClickListener);
        between1000And2000Button.setOnClickListener(radioButtonClickListener);
        between2000And3000Button.setOnClickListener(radioButtonClickListener);
        between3000And3500Button.setOnClickListener(radioButtonClickListener);
        bigger3500Button.setOnClickListener(radioButtonClickListener);
    }

    private void disableEngineVolume(int buttonId) {
        less1000Button.setEnabled(false);
        between1000And2000Button.setEnabled(false);
        between2000And3000Button.setEnabled(false);
        between3000And3500Button.setEnabled(false);
        bigger3500Button.setEnabled(false);
        setEnable(buttonId);
    }

    private void disableMass(int buttonId) {
        n1Less2.setEnabled(false);
        n1Between2And3.setEnabled(false);
        n1Between3And5.setEnabled(false);
        n1Between5And8.setEnabled(false);
        n1Between8And12.setEnabled(false);
        n1Between12And20.setEnabled(false);
        n1Between20And30.setEnabled(false);
        n1Between30And50.setEnabled(false);
        setEnable(buttonId);
    }

    private void setEnable(int buttonId) {
        RadioButton radioButton = findViewById(buttonId);
        radioButton.setEnabled(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        legkButton = findViewById(R.id.legkovoi_button);
        legkButton.setOnClickListener(radioButtonClickListener);
        neLegkButton = findViewById(R.id.ne_legkovoi_button);
        neLegkButton.setOnClickListener(radioButtonClickListener);

        calculator = new Calculator();
        finalText = findViewById(R.id.final_text);
        finalText.setBackgroundColor(Color.parseColor("#FFECBF"));

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        setSupportActionBar(toolbar);
    }

    private void setAgeListener() {
        less3Years = findViewById(R.id.age_car_less_3_button);
        less3Years.setOnClickListener(radioButtonClickListener);
        between3And7years = findViewById(R.id.age_car_3_7_button);
        between3And7years.setOnClickListener(radioButtonClickListener);
        more7Years = findViewById(R.id.age_car_more_7_button);
        more7Years.setOnClickListener(radioButtonClickListener);
    }

    private void setOffroadVolumeListener() {
        less2500OffroadVolume = findViewById(R.id.m2_offroad_less_2500_button);
        between2500and5000OffroadVolume = findViewById(R.id.m2_offroad_between_2500_5000_button);
        between5000and10000OffroadVolume = findViewById(R.id.m2_offroad_between_5000_10000_button);
        more10000OffroadVolume = findViewById(R.id.m2_offroad_more_10000_button);

        less2500OffroadVolume.setOnClickListener(radioButtonClickListener);
        between2500and5000OffroadVolume.setOnClickListener(radioButtonClickListener);
        between5000and10000OffroadVolume.setOnClickListener(radioButtonClickListener);
        more10000OffroadVolume.setOnClickListener(radioButtonClickListener);
    }

    public void restart(View view) {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
//        this.recreate();
    }
}