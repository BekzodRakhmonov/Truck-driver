package com.example.truckdriver.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.truckdriver.R;
import com.example.truckdriver.database.MyDB;

public class SplashActivity extends AppCompatActivity {

    Handler h = new Handler();
    private MyDB myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
        myDB = new MyDB(this);
        myDB.deleteAllTableData();
        myDB.addNewDrivers("Мясников", "Матвей", "Германнович", "9215", "895687", "89175248724", "Man", "А345ВО716", 30, 1, 1);
        myDB.addNewDrivers("Буров", "Мирон", "Максович", "9216", "765654", "89176436412", "Daf", "В546АО716", 20, 2, 1);
        myDB.addNewDrivers("Капустин", "Аввакум", "Альбертович", "9214", "1346", "89197647425", "Maz", "Н421ВА716", 20, 3, 1);
        myDB.addNewDrivers("Петров", "Мечеслав", "Витальевич", "9213", "6453", "89187465485", "Daf", "Е355СА716", 20, 4, 1);
        myDB.addNewDrivers("Щукин", "Евдоким", "Геласьевич", "9216", "7656", "89176434521", "Man", "А786ВО716", 30, 5, 1);
        myDB.addNewDrivers("Мясников", "Матвей", "Германнович", "9215", "895687", "89175248724", "Man", "А345ВО716", 30, 6, 1);
        myDB.addNewDrivers("Буров", "Мирон", "Максович", "9216", "765654", "89176436412", "Daf", "В546АО716", 20, 7, 1);
        myDB.addNewDrivers("Капустин", "Аввакум", "Альбертович", "9214", "1346", "89197647425", "Maz", "Н421ВА716", 20, 8, 1);
        myDB.addNewDrivers("Петров", "Мечеслав", "Витальевич", "9213", "6453", "89187465485", "Daf", "Е355СА716", 20, 9, 1);
        myDB.addNewDrivers("Щукин", "Евдоким", "Геласьевич", "9216", "7656", "89176434521", "Man", "А786ВО716", 30, 10, 1);

        myDB.addNewLicense("11-01-2022", "11-01-2032", 74857);
        myDB.addNewLicense("12-01-2022", "12-01-2032", 77945);
        myDB.addNewLicense("13-01-2022", "13-01-2032", 46641);
        myDB.addNewLicense("14-01-2022", "14-01-2032", 47913);
        myDB.addNewLicense("15-01-2022", "15-01-2032", 91727);
        myDB.addNewLicense("16-01-2022", "16-01-2032", 44621);
        myDB.addNewLicense("17-01-2022", "17-01-2032", 84721);
        myDB.addNewLicense("18-01-2022", "18-01-2032", 15701);
        myDB.addNewLicense("19-01-2022", "19-01-2032", 14219);
        myDB.addNewLicense("20-01-2022", "20-01-2032", 17213);


        myDB.addNewDrivers("Мясников", "Матвей", "Германнович", "9215", "895687", "89175248724", "Man", "А345ВО716", 30, 1, 1);
        myDB.addNewDrivers("Буров", "Мирон", "Максович", "9216", "765654", "89176436412", "Daf", "В546АО716", 20, 2, 1);
        myDB.addNewDrivers("Капустин", "Аввакум", "Альбертович", "9214", "1346", "89197647425", "Maz", "Н421ВА716", 20, 3, 1);
        myDB.addNewDrivers("Петров", "Мечеслав", "Витальевич", "9213", "6453", "89187465485", "Daf", "Е355СА716", 20, 4, 1);
        myDB.addNewDrivers("Щукин", "Евдоким", "Геласьевич", "9216", "7656", "89176434521", "Man", "А786ВО716", 30, 5, 1);
        myDB.addNewDrivers("Мясников", "Матвей", "Германнович", "9215", "895687", "89175248724", "Man", "А345ВО716", 30, 6, 1);
        myDB.addNewDrivers("Буров", "Мирон", "Максович", "9216", "765654", "89176436412", "Daf", "В546АО716", 20, 7, 1);
        myDB.addNewDrivers("Капустин", "Аввакум", "Альбертович", "9214", "1346", "89197647425", "Maz", "Н421ВА716", 20, 8, 1);
        myDB.addNewDrivers("Петров", "Мечеслав", "Витальевич", "9213", "6453", "89187465485", "Daf", "Е355СА716", 20, 9, 1);
        myDB.addNewDrivers("Щукин", "Евдоким", "Геласьевич", "9216", "7656", "89176434521", "Man", "А786ВО716", 30, 10, 1);
    }
}