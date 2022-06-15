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
        ListView lvTemple = findViewById(R.id.lvTemple);
        lvTemple.setOnItemClickListener(new ListItemClickListener());

        //number, explanation
        ListView lvTempleNumber = findViewById(R.id.lvTempleNumber);
        lvTempleNumber.setOnItemClickListener(new ListItemClickListener());
        ListView lvTempleExplanation = findViewById(R.id.lvTempleExplanation);
        lvTempleExplanation.setOnItemClickListener(new ListItemClickListener());
    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
            String name = (String) parent.getItemAtPosition(position);
            String number = (String) parent.getItemAtPosition(position);
            String explanation = (String) parent.getItemAtPosition(position);

            Intent intent = new Intent(MainActivity.this, TempleDetailActivity.class);
            intent.putExtra("selectedPictNo", position);
            intent.putExtra("selectedPictName", name);
            intent.putExtra("selectedPictNumber", number);
            intent.putExtra("selectedPicExplanation", explanation);
            startActivity(intent);
        }
    }
}