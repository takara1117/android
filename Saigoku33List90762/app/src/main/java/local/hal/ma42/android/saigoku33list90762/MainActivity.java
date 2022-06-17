package local.hal.ma42.android.saigoku33list90762;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView templeListView = findViewById(R.id.lvTemple);
        templeListView.setOnItemClickListener(new ListItemClickListener());
    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
            String templeName = (String) parent.getItemAtPosition(position);
            String templeNumber = getResources().getStringArray(R.array.lv_TempleNumber)[position];
            String templeExplanation = getResources().getStringArray(R.array.lv_TempleExplanation)[position];

            Intent intent = new Intent(MainActivity.this, TempleDetailActivity.class);
            intent.putExtra("selectedPictNo", position);
            intent.putExtra("selectedPictName", templeName);
            intent.putExtra("selectedPictNumber", templeNumber);
            intent.putExtra("selectedPicExplanation", templeExplanation);
            startActivity(intent);
        }
    }
}