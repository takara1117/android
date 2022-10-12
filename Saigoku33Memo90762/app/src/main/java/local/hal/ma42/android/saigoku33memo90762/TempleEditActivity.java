package local.hal.ma42.android.saigoku33memo90762;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TempleEditActivity extends AppCompatActivity
{

    private int _selectedTempleNo = 0;

    private String _selectedTempleName = "";

    private DatabaseHelper _helper;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temple_edit);

        Intent intent = getIntent();
        _selectedTempleNo = intent.getIntExtra("selectedTempleNo", 0);
        _selectedTempleName = intent.getStringExtra("selectedTempleName");

        _helper = new DatabaseHelper(getApplicationContext());

        TextView tvTemple = findViewById(R.id.tvTemple);
        tvTemple.setText(_selectedTempleName);

        TextView tvTempleNo = findViewById(R.id.tvTempleNo);
        _selectedTempleNo++;
        tvTempleNo.setText("第" + String.valueOf(_selectedTempleNo) + "番");

        SQLiteDatabase db = _helper.getWritableDatabase();
        Temple temple = DataAccess.findByPK(db, _selectedTempleNo);

        if (temple != null)
        {
            String honzon = temple.getHonzon();
            EditText etHonzon = findViewById(R.id.etHonzon);
            etHonzon.setText(honzon);

            String shushi = temple.getShushi();
            EditText etShushi = findViewById(R.id.etShushi);
            etShushi.setText(shushi);

            String address = temple.getAddress();
            EditText etAddress = findViewById(R.id.etAddress);
            etAddress.setText(address);

            String url = temple.getUrl();
            EditText etUrl = findViewById(R.id.etUrl);
            etUrl.setText(url);

            String note = temple.getNote();
            EditText etNote = findViewById(R.id.etNote);
            etNote.setText(note);
        }
    }

    @Override
    protected void onDestroy()
    {
        _helper.close();
        super.onDestroy();
    }

    public void onSaveButtonClick(View view)
    {
        EditText etHonzon = findViewById(R.id.etHonzon);
        String honzon = etHonzon.getText().toString();

        EditText etShushi = findViewById(R.id.etShushi);
        String shushi = etShushi.getText().toString();

        EditText etAddress = findViewById(R.id.etAddress);
        String address = etAddress.getText().toString();

        EditText etUrl = findViewById(R.id.etUrl);
        String url = etUrl.getText().toString();
        
        EditText etNote = findViewById(R.id.etNote);
        String note = etNote.getText().toString();

        SQLiteDatabase db = _helper.getWritableDatabase();
        boolean exist = DataAccess.findRowByPK(db, _selectedTempleNo);

        if (exist)
        {
            DataAccess.update(db, _selectedTempleNo, _selectedTempleName, honzon, shushi, address, url, note);
        } else
        {
            DataAccess.insert(db, _selectedTempleNo, _selectedTempleName, honzon, shushi, address, url, note);
        }
        finish();
    }
}
