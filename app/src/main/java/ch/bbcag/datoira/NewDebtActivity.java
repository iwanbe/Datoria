package ch.bbcag.datoira;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NewDebtActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_debt);

        DatabaseContract.DatabaseHelper dbHelper = new DatabaseContract.DatabaseHelper(this);

        SQLiteDatabase db  = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();


    }
}
