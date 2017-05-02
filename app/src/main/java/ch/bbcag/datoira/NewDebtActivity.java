package ch.bbcag.datoira;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        EditText amountEditText = (EditText) findViewById(R.id.new_debt_amount_edit_text);
        EditText lastnameEditText = (EditText) findViewById(R.id.new_debt_lastname_edit_text);
        EditText firstnameEditText = (EditText) findViewById(R.id.new_debt_firstname_edit_text);
        EditText telEditText = (EditText) findViewById(R.id.new_debt_tel_edit_text);

        amount = amountEditText.getText().toString();
        lastname = lastnameEditText.getText().toString();
        firstname = firstnameEditText.getText().toString();
        tel = telEditText.getText().toString();

        

    }
}
