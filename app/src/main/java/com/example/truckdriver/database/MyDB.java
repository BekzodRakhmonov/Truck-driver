package com.example.truckdriver.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MyDB extends SQLiteOpenHelper {
    private static String DB_NAME = "my.db";
    private static int DB_VR = 1;
    private static String LICENSE_TABLE = "license";
    private static String LICENSE_ID = "id";
    private static String LICENSE_ISSUE_DATE = "date";
    private static String LICENSE_EXPIRATION_DATE = "exp";
    private static String LICENSE_NUMBER = "number";

    private static String DRIVER_TABLE = "driver";
    private static String DRIVER_ID = "driver_id";
    private static String SURNAME = "surname";
    private static String NAME = "name";
    private static String PATRONYMIC = "patronymic";
    private static String PASSPORT_SERIES = "passport_series";
    private static String PASSPORT_NUMBER = "passport_number";
    private static String PHONE = "phone";
    private static String BRAND = "brand";
    private static String REGISTRATION_NUMBER = "registration_number";
    private static String PERMISSIBLE_MASS = "permissible_mass";
    private static String STATUSS = "statuss";

    public MyDB(Context context) {
        super(context, DB_NAME, null, DB_VR);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String license = "CREATE TABLE " + LICENSE_TABLE + " ( "
                + LICENSE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + LICENSE_ISSUE_DATE + " datetime NOT NULL,"
                + LICENSE_EXPIRATION_DATE + " datetime NOT NULL,"
                + LICENSE_NUMBER + " INTEGER NOT NULL)";
        //sqLiteDatabase.execSQL(license);

        String drivers = "CREATE TABLE " + DRIVER_TABLE + " ( "
                + DRIVER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + SURNAME + " varchar(50) NOT NULL,"
                + NAME + " varchar(50) NOT NULL,"
                + PATRONYMIC + " varchar(50) NOT NULL,"
                + PASSPORT_SERIES + " varchar(50) NOT NULL,"
                + PASSPORT_NUMBER + " varchar(6) NOT NULL,"
                + PHONE + " varchar(11) NOT NULL,"
                + BRAND + " varchar(20) NOT NULL,"
                + REGISTRATION_NUMBER + " varchar(10) NOT NULL,"
                + PERMISSIBLE_MASS + " INTEGER NOT NULL,"
                + STATUSS + " varchar(11) NOT NULL," +
                " FOREIGN KEY (" + DRIVER_ID + ") REFERENCES " + LICENSE_TABLE + "(" + LICENSE_ID + "))";


//        String customer = "Create Table Сustomer(\n" +
//                "Id int  primary key AUTOINCREMENT," +
//                "Сustomer_name varchar(100) NOT NULL," +
//                "Legal_address_customer varchar(100) NOT NULL," +
//                "TIN_customer varchar(10) NOT NULL," +
//                "Customer_checkpoint varchar(10) NOT NULL," +
//                "Customer_phone varchar(11) NOT NULL," +
//                "OGRN_customer varchar(50) NOT NULL," +
//                "Email_address_customer varchar(100) NOT NULL" +
//                ")";
//        String materials = "Create Table Materials(" +
//                "Id int  primary key," +
//                "Material_name varchar(50) NOT NULL" +
//                ")";
//        String orders = "Create Table Orders(" +
//                "Id int primary key AUTOINCREMENT," +
//                "Сustomer int NOT NULL foreign key references Сustomer(Id)," +
//                "Loading_location varchar(50) NOT NULL," +
//                "Place_of_unloading varchar(50) NOT NULL," +
//                "Date_of_download date NOT NULL," +
//                "Unloading_date date NOT NULL," +
//                "Cargo_weight varchar(50) NOT NULL," +
//                "Shipping_name int NOT NULL foreign key references Materials(Id)" +
//                ")";
//        String trips = "Create Table Trips(" +
//                "Id int  primary key AUTOINCREMENT," +
//                "Orders int NOT NULL foreign key references Orders(Id)," +
//                "Drivers int NOT NULL foreign key references Drivers(Id)," +
//                "Сustomer int NOT NULL foreign key references Сustomer(Id)" +
//                ")";
//        String role = "Create Table Role(" +
//                "Id  primary key AUTOINCREMENT," +
//                "Name varchar(50) NOT NULL" +
//                ")";
//        String employees = "Create Table Employees(" +
//                "Id int  primary key AUTOINCREMENT," +
//                "Surname varchar(50) NOT NULL," +
//                "Name varchar(50) NOT NULL," +
//                "Patronymic varchar(50) NOT NULL," +
//                "Login varchar(50) NOT NULL," +
//                "Password varchar(50) NOT NULL," +
//                "RoleId int NOT NULL foreign key references Role(Id)" +
//                ")";
//        sqLiteDatabase.execSQL(employees);
//        sqLiteDatabase.execSQL(role);
//        sqLiteDatabase.execSQL(trips);
//        sqLiteDatabase.execSQL(orders);
//        sqLiteDatabase.execSQL(materials);
//        sqLiteDatabase.execSQL(customer);
        sqLiteDatabase.execSQL(drivers);
        sqLiteDatabase.execSQL(license);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + LICENSE_TABLE);
        onCreate(sqLiteDatabase);
    }

    public void addNewLicense(String License_Issue_Date, String License_Expiration_Date, int License_number) {
        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();
        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();
        // on below line we are passing all values
        // along with its key and value pair.
        values.put(LICENSE_ISSUE_DATE, License_Issue_Date);
        values.put(LICENSE_EXPIRATION_DATE, License_Expiration_Date);
        values.put(LICENSE_NUMBER, License_number);
        // after adding all values we are passing
        // content values to our table.
        db.insert(LICENSE_TABLE, null, values);
        // at last we are closing our
        // database after adding database.
        //db.close();
    }

    public void addNewDrivers(String Surname, String Name, String Patronymic,
                              String Passport_series, String Passport_number,
                              String Phone, String Brand, String Registration_number,
                              int Permissible_mass, int License_number, Byte Statuss) {
        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();
        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();
        // on below line we are passing all values
        // along with its key and value pair.
        values.put(SURNAME, Surname);
        values.put(NAME, Name);
        values.put(PATRONYMIC, Patronymic);
        values.put(PASSPORT_SERIES, Passport_series);
        values.put(PASSPORT_NUMBER, Passport_number);
        values.put(PHONE, Phone);
        values.put(BRAND, Brand);
        values.put(REGISTRATION_NUMBER, Registration_number);
        values.put(PERMISSIBLE_MASS, Permissible_mass);
        values.put(LICENSE_NUMBER, License_number);
        values.put(STATUSS, Statuss);
        // after adding all values we are passing
        // content values to our table.
        db.insert(DRIVER_TABLE, null, values);
        // at last we are closing our
        // database after adding database.
        //db.close();
    }

    public Cursor getAllDrivers() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + DRIVER_TABLE, null);
        return res;
    }

}
