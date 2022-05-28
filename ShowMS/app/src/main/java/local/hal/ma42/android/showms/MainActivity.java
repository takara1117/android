package local.hal.ma42.android.showms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lvMS = findViewById(R.id.lvMS);
        lvMS.setOnItemClickListener(new ListItemClickListener());
    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
            String name = (String) parent.getItemAtPosition(position);
            Intent intent = new Intent(MainActivity.this, ShowMsActivity.class);
            intent.putExtra("selectedPictNo", position);
            intent.putExtra("selectedPictName", name);
            startActivity(intent);
        }
    }
}