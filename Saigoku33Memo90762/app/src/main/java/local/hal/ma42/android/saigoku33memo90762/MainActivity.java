package local.hal.ma42.android.saigoku33memo90762;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvTemple = findViewById(R.id.lvTemple);
        lvTemple.setOnItemClickListener(new ListItemClickListener());
    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
            String templeName = (String) parent.getItemAtPosition(position);

            Intent intent = new Intent(getApplicationContext(), TempleEditActivity.class);
            intent.putExtra("selectedTempleNo", position);
            intent.putExtra("selectedTempleName", templeName);
            startActivity(intent);
        }
    }
}