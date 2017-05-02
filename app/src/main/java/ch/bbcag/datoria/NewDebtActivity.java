package ch.bbcag.datoria;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class NewDebtActivity extends AppCompatActivity {

    private String amount;
    private String lastname;
    private String firstname;
    private String tel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_debt);

        Button button = (Button) findViewById(R.id.new_debt_create_button);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                EditText amountEditText = (EditText) findViewById(R.id.new_debt_amount_edit_text);
                EditText lastnameEditText = (EditText) findViewById(R.id.new_debt_lastname_edit_text);
                EditText firstnameEditText = (EditText) findViewById(R.id.new_debt_firstname_edit_text);
                EditText telEditText = (EditText) findViewById(R.id.new_debt_tel_edit_text);

                amount = amountEditText.getText().toString();
                lastname = lastnameEditText.getText().toString();
                firstname = firstnameEditText.getText().toString();
                tel = telEditText.getText().toString();

                if(!amount.equals("") && !lastname.equals("") && !firstname.equals("") && !tel.equals("")){

                    DatabaseContract.DatabaseHelper dbHelper = new DatabaseContract.DatabaseHelper(getApplicationContext());

                    SQLiteDatabase db = dbHelper.getWritableDatabase();

                    ContentValues values = new ContentValues();

                    values.put(DatabaseContract.DebtEntry.COLUMN_NAME_AMOUNT, amount);
                    values.put(DatabaseContract.DebtEntry.COLUMN_NAME_LASTNAME, lastname);
                    values.put(DatabaseContract.DebtEntry.COLUMN_NAME_FIRSTNAME, firstname);
                    values.put(DatabaseContract.DebtEntry.COLUMN_NAME_TEL, tel);

                    long newRowId = db.insert(DatabaseContract.DebtEntry.TABLE_NAME, null, values);





                    /*db = dbHelper.getReadableDatabase();

                    String[] projection = {
                            DatabaseContract.DebtEntry._ID,
                            DatabaseContract.DebtEntry.COLUMN_NAME_AMOUNT,
                            DatabaseContract.DebtEntry.COLUMN_NAME_LASTNAME,
                            DatabaseContract.DebtEntry.COLUMN_NAME_FIRSTNAME,
                            DatabaseContract.DebtEntry.COLUMN_NAME_TEL
                    };

                    String selection = DatabaseContract.DebtEntry.COLUMN_NAME_LASTNAME + " = ?";

                    String[] selectionArgs = {"Hänni"};

                    String sortOder = DatabaseContract.DebtEntry.COLUMN_NAME_LASTNAME + " ASC";

                    Cursor cursor = db.query(
                            DatabaseContract.DebtEntry.TABLE_NAME,
                            projection,
                            selection,
                            selectionArgs,
                            null,
                            null,
                            sortOder
                    );

                    // TESTING START
                    // TODO: REMOVE CODE, FINISH DEBT CREATION
                    EditText editText = (EditText) findViewById(R.id.new_debt_temp_edit_text);

                    while (cursor.moveToNext()){
                        editText.setText(cursor.getString(cursor.getColumnIndexOrThrow((DatabaseContract.DebtEntry.COLUMN_NAME_AMOUNT))));
                    }
                    cursor.close();
                    //TESTING END*/
                }
            }
        });
    }
}
