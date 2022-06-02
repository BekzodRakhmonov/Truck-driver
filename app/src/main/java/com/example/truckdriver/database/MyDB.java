package com.example.truckdriver.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;


public class MyDB extends SQLiteOpenHelper {

    private static final String DB_NAME = "my.db";
    private static final int DB_VR = 1;
    private static final String LICENSE_TABLE = "license";
    private static final String LICENSE_ID = "id";
    private static final String LICENSE_ISSUE_DATE = "date";
    private static final String LICENSE_EXPIRATION_DATE = "exp";
    private static final String LICENSE_NUMBER = "number";

    private static final String DRIVER_TABLE = "driver";
    private static final String DRIVER_ID = "driver_id";
    private static final String SURNAME = "surname";
    private static final String NAME = "name";
    private static final String PATRONYMIC = "patronymic";
    private static final String PASSPORT_SERIES = "passport_series";
    private static final String PASSPORT_NUMBER = "passport_number";
    private static final String PHONE = "phone";
    private static final String BRAND = "brand";
    private static final String REGISTRATION_NUMBER = "registration_number";
    private static final String PERMISSIBLE_MASS = "permissible_mass";
    private static final String STATUSS = "statuss";
    private static final String LICENSE_NUMBER1 = "number";

    private static final String CUSTOMER_TABLE = "customer";
    private static final String CUSTOMER_ID = "customer_id";
    private static final String COSTUMER_NAME = "customer_name";
    private static final String LEGAL_ADDRESS_CUSTOMER = "legal_address_customer";
    private static final String TIN_CUSTOMER = "tin_customer";
    private static final String CUSTOMER_CHECKPOINT = "customer_checkpoint";
    private static final String OGRN_CUSTOMER = "ogrn_customer";
    private static final String CUSTOMER_PHONE = "customer_phone";
    private static final String EMAIL_ADDRESS_CUSTOMER = "email_address_customer";

    private static final String MATERIALS_TABLE = "materials";
    private static final String MATERIALS_ID = "materials_id";
    private static final String MATERIAL_NAME = "material_name ";

    private static final String ORDER_TABLE = "orders";
    private static final String ORDER_ID = "order_id";
    private static final String COSTUMER_TABLE_ID = "customer_table_id";
    private static final String LOADING_LOCATION = "loading_location";
    private static final String PLACE_OF_UNLOADING = "place_of_unloading";
    private static final String DATE_OF_DOWNLOAD = "date_of_download";
    private static final String UNLOADING_DATE = "unloading_date";
    private static final String CARGO_WEIGHT = "cargo_weight";
    private static final String SHIPPING_NAME = "shipping_name";

    private static final String TRIPS_TABLE = "trips";
    private static final String TRIPS_ID = "trips_id";
    private static final String ORDERS_TABLE_ID = "order_table_id";
    private static final String DRIVERS_TABLE_ID = "drivers_table_id";
    private static final String CUSTOMER_TABLE_ID = "customer_table_id";

    private static final String ROLE_TABLE = "role";
    private static final String ROLE_ID = "role_id";
    private static final String ROLE_NAME = "role_name ";

    private static final String EMPLOYEES_TABLE = "employees";
    private static final String EMPLOYEES_ID = "employees_id";
    private static final String EMPLOYEES_SURNAME = "surname";
    private static final String EMPLOYEES_NAME = "name";
    private static final String EMPLOYEES_PATRONYMIC = "patronymic";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String ROLE_TABLE_ID = "role_table_id";

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
                + CUSTOMER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + SURNAME + " varchar(50) NOT NULL,"
                + NAME + " varchar(50) NOT NULL,"
                + PATRONYMIC + " varchar(50) NOT NULL,"
                + PASSPORT_SERIES + " varchar(50) NOT NULL,"
                + PASSPORT_NUMBER + " varchar(6) NOT NULL,"
                + PHONE + " varchar(11) NOT NULL,"
                + BRAND + " varchar(20) NOT NULL,"
                + REGISTRATION_NUMBER + " varchar(10) NOT NULL,"
                + PERMISSIBLE_MASS + " INTEGER NOT NULL,"
                + LICENSE_NUMBER1 + " INTEGER NOT NULL,"
                + STATUSS + " INTEGER NOT NULL)";

        String customer = "CREATE TABLE " + CUSTOMER_TABLE + " ( "
                + DRIVER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COSTUMER_NAME + " varchar(100) NOT NULL,"
                + LEGAL_ADDRESS_CUSTOMER + " varchar(100) NOT NULL,"
                + TIN_CUSTOMER + " varchar(10) NOT NULL,"
                + CUSTOMER_CHECKPOINT + " varchar(10) NOT NULL,"
                + CUSTOMER_PHONE + " varchar(11) NOT NULL,"
                + OGRN_CUSTOMER + " varchar(50) NOT NULL,"
                + EMAIL_ADDRESS_CUSTOMER + " varchar(100) NOT NULL)";

        String materials = "CREATE TABLE " + MATERIALS_TABLE + " ( "
                + MATERIALS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + MATERIAL_NAME + " varchar(50) NOT NULL)";


        String orders = "CREATE TABLE " + ORDER_TABLE + " ( "
                + ORDER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COSTUMER_TABLE_ID + " INTEGER NOT NULL,"
                + LOADING_LOCATION + " varchar(50) NOT NULL,"
                + PLACE_OF_UNLOADING + " varchar(50) NOT NULL,"
                + DATE_OF_DOWNLOAD + " date NOT NULL,"
                + UNLOADING_DATE + " date NOT NULL,"
                + CARGO_WEIGHT + " varchar(50) NOT NULL,"
                + SHIPPING_NAME + " INTEGER NOT NULL)";

        String trips = "CREATE TABLE " + TRIPS_TABLE + " ( "
                + TRIPS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ORDERS_TABLE_ID + " INTEGER NOT NULL,"
                + DRIVERS_TABLE_ID + " INTEGER NOT NULL,"
                + CUSTOMER_TABLE_ID + " INTEGER NOT NULL)";

        String role = "CREATE TABLE " + ROLE_TABLE + " ( "
                + ROLE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ROLE_NAME + " varchar(50) NOT NULL)";

        String employees = "CREATE TABLE " + EMPLOYEES_TABLE + " ( "
                + EMPLOYEES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + EMPLOYEES_SURNAME + " varchar(50) NOT NULL,"
                + EMPLOYEES_NAME + " varchar(50) NOT NULL,"
                + EMPLOYEES_PATRONYMIC + " varchar(50) NOT NULL,"
                + LOGIN + " varchar(50) NOT NULL,"
                + PASSWORD + " varchar(50) NOT NULL,"
                + ROLE_TABLE_ID + " INTEGER NOT NULL)";


        sqLiteDatabase.execSQL(employees);
        sqLiteDatabase.execSQL(role);
        sqLiteDatabase.execSQL(trips);
        sqLiteDatabase.execSQL(orders);
        sqLiteDatabase.execSQL(materials);
        sqLiteDatabase.execSQL(customer);
        sqLiteDatabase.execSQL(license);
        sqLiteDatabase.execSQL(drivers);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DRIVER_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + LICENSE_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CUSTOMER_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + MATERIALS_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ORDER_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TRIPS_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ROLE_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + EMPLOYEES_TABLE);
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

    public void addNewCustomer(String customer_name, String legal_address_customer, String TIN_customer, String Customer_checkpoint, String Customer_phone,
                               String OGRN_customer, String Email_address_customer) {
        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();
        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();
        // on below line we are passing all values
        // along with its key and value pair.
        values.put(COSTUMER_NAME, customer_name);
        values.put(LEGAL_ADDRESS_CUSTOMER, legal_address_customer);
        values.put(TIN_CUSTOMER, TIN_customer);
        values.put(CUSTOMER_CHECKPOINT, Customer_checkpoint);
        values.put(CUSTOMER_PHONE, Customer_phone);
        values.put(OGRN_CUSTOMER, OGRN_customer);
        values.put(EMAIL_ADDRESS_CUSTOMER, Email_address_customer);
        // after adding all values we are passing
        // content values to our table.
        db.insert(CUSTOMER_TABLE, null, values);
        // at last we are closing our
        // database after adding database.
        //db.close();
    }

    public void addNewOrders(int customer_id, String Loading_location, String Place_of_unloading, String Date_of_download, java.sql.Date Unloading_date,
                             String Cargo_weight, int material_id) {
        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();
        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();
        // on below line we are passing all values
        // along with its key and value pair.
        values.put(COSTUMER_TABLE_ID, customer_id);
        values.put(LOADING_LOCATION, Loading_location);
        values.put(PLACE_OF_UNLOADING, Place_of_unloading);
        values.put(DATE_OF_DOWNLOAD, Date_of_download);
        values.put(UNLOADING_DATE, String.valueOf(Unloading_date));
        values.put(SHIPPING_NAME, material_id);
        // after adding all values we are passing
        // content values to our table.
        db.insert(ORDER_TABLE, null, values);
        // at last we are closing our
        // database after adding database.
        //db.close();
    }

    public void addNewTrips(int order_id, int drivers_id, int customer_id) {
        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();
        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();
        // on below line we are passing all values
        // along with its key and value pair.
        values.put(ORDERS_TABLE_ID, order_id);
        values.put(DRIVERS_TABLE_ID, drivers_id);
        values.put(CUSTOMER_TABLE_ID, customer_id);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TRIPS_TABLE, null, values);
        // at last we are closing our
        // database after adding database.
        //db.close();
    }

    public void addNewMaterials(String Material_name) {
        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();
        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();
        // on below line we are passing all values
        // along with its key and value pair.
        values.put(MATERIAL_NAME, Material_name);

        // after adding all values we are passing
        // content values to our table.
        db.insert(MATERIALS_TABLE, null, values);
        // at last we are closing our
        // database after adding database.
        //db.close();
    }

    public void addNewRole(String role_name) {
        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();
        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();
        // on below line we are passing all values
        // along with its key and value pair.
        values.put(ROLE_NAME, role_name);

        // after adding all values we are passing
        // content values to our table.
        db.insert(ROLE_TABLE, null, values);
        // at last we are closing our
        // database after adding database.
        //db.close();
    }

    public void addNewDrivers(String Surname, String Name, String Patronymic,
                              String Passport_series, String Passport_number,
                              String Phone, String Brand, String Registration_number,
                              int Permissible_mass, int License_number, int Statuss) {
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
        //db.close();
    }

    public void addNewEmployees(String Surname, String Name, String Patronymic,
                                String login, String password,
                                int role_id) {
        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();
        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();
        // on below line we are passing all values
        // along with its key and value pair.
        values.put(EMPLOYEES_SURNAME, Surname);
        values.put(EMPLOYEES_NAME, Name);
        values.put(EMPLOYEES_PATRONYMIC, Patronymic);
        values.put(LOGIN, login);
        values.put(PASSWORD, password);
        values.put(ROLE_TABLE_ID, role_id);
        // after adding all values we are passing
        // content values to our table.
        db.insert(EMPLOYEES_TABLE, null, values);
        // at last we are closing our
        //db.close();
    }

    public Cursor getAllDrivers() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + DRIVER_TABLE, null);
        return res;
    }

    public void deleteAllTableData() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DRIVER_TABLE, null, null);
        db.delete(LICENSE_TABLE, null, null);
        db.close();
    }

    public Boolean checkUserNamePassword(String username, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from driver where  surname= ? and name = ?", new String[]{username, password});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }
}
