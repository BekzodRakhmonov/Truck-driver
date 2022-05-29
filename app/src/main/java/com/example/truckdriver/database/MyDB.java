package com.example.truckdriver.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.truckdriver.Constants;
import com.google.android.gms.auth.api.identity.Identity;


public class MyDB extends SQLiteOpenHelper {
    private static String DB_NAME = "MyDatabase.db";
    private static int DB_VR = 1;

    public MyDB(Context context) {
        super(context, DB_NAME, null, DB_VR);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String license = "Create Table License(" +
                "Id int  primary key AUTOINCREMENT," +
                "License_Issue_Date datetime NOT NULL," +
                "License_Expiration_Date datetime NOT NULL," +
                "License_number int NOT NULL" +
                ")";
        String drivers = "Create Table Drivers(" +
                "Id int  primary key AUTOINCREMENT," +
                "Surname varchar(50) NOT NULL," +
                "Name varchar(50) NOT NULL," +
                "Patronymic varchar(50) NOT NULL," +
                "Passport_series varchar(4) NOT NULL," +
                "Passport_number varchar(6) NOT NULL," +
                "Phone varchar(11) NOT NULL," +
                "Brand varchar(20) NOT NULL," +
                "Registration_number varchar(10) NOT NULL," +
                "Permissible_mass int NOT NULL," +
                "License_number int NOT NULL FOREIGN key references License(Id)," +
                "Statuss bit NOT NULL" +
                ")";
        String customer = "Create Table Сustomer(\n" +
                "Id int  primary key AUTOINCREMENT," +
                "Сustomer_name varchar(100) NOT NULL," +
                "Legal_address_customer varchar(100) NOT NULL," +
                "TIN_customer varchar(10) NOT NULL," +
                "Customer_checkpoint varchar(10) NOT NULL," +
                "Customer_phone varchar(11) NOT NULL," +
                "OGRN_customer varchar(50) NOT NULL," +
                "Email_address_customer varchar(100) NOT NULL" +
                ")";
        String materials = "Create Table Materials(" +
                "Id int  primary key," +
                "Material_name varchar(50) NOT NULL" +
                ")";
        String orders = "Create Table Orders(" +
                "Id int primary key AUTOINCREMENT," +
                "Сustomer int NOT NULL foreign key references Сustomer(Id)," +
                "Loading_location varchar(50) NOT NULL," +
                "Place_of_unloading varchar(50) NOT NULL," +
                "Date_of_download date NOT NULL," +
                "Unloading_date date NOT NULL," +
                "Cargo_weight varchar(50) NOT NULL," +
                "Shipping_name int NOT NULL foreign key references Materials(Id)" +
                ")";
        String trips = "Create Table Trips(" +
                "Id int  primary key AUTOINCREMENT," +
                "Orders int NOT NULL foreign key references Orders(Id)," +
                "Drivers int NOT NULL foreign key references Drivers(Id)," +
                "Сustomer int NOT NULL foreign key references Сustomer(Id)" +
                ")";
        String role = "Create Table Role(" +
                "Id  primary key AUTOINCREMENT," +
                "Name varchar(50) NOT NULL" +
                ")";
        String employees = "Create Table Employees(" +
                "Id int  primary key AUTOINCREMENT," +
                "Surname varchar(50) NOT NULL," +
                "Name varchar(50) NOT NULL," +
                "Patronymic varchar(50) NOT NULL," +
                "Login varchar(50) NOT NULL," +
                "Password varchar(50) NOT NULL," +
                "RoleId int NOT NULL foreign key references Role(Id)" +
                ")";
        sqLiteDatabase.execSQL(employees);
        sqLiteDatabase.execSQL(role);
        sqLiteDatabase.execSQL(trips);
        sqLiteDatabase.execSQL(orders);
        sqLiteDatabase.execSQL(materials);
        sqLiteDatabase.execSQL(customer);
        sqLiteDatabase.execSQL(drivers);
        sqLiteDatabase.execSQL(license);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
