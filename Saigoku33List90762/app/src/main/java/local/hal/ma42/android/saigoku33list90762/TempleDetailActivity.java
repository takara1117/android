package local.hal.ma42.android.saigoku33list90762;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TempleDetailActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temple_detail);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        int selectedPictNo = 0;
        String selectedPictName = "";
        String selectedPictNumber = "";
        String selectedPicExplanation = "";

        if (extras != null)
        {
            selectedPictNo = extras.getInt("selectedPictNo");
            selectedPictName = extras.getString("selectedPictName");
            selectedPictNumber = extras.getString("selectedPictNumber");
            selectedPicExplanation = extras.getString("selectedPicExplanation");
        }

        TextView tvName = findViewById(R.id.tvName);
        TextView tvNumber = findViewById(R.id.tvNumber);
        TextView tvExplanation = findViewById(R.id.tvExplanation);

        tvName.setText(selectedPictName);
        tvNumber.setText(selectedPictNumber);
        tvExplanation.setText(selectedPicExplanation);

        ImageView ivSelected = findViewById(R.id.ivSelected);

        switch (selectedPictNo) {
            case 0:
                ivSelected.setImageResource(R.drawable.top01);
                break;
            case 1:
                ivSelected.setImageResource(R.drawable.top02);
                break;
            case 2:
                ivSelected.setImageResource(R.drawable.top03);
                break;
            case 3:
                ivSelected.setImageResource(R.drawable.top04);
                break;
            case 4:
                ivSelected.setImageResource(R.drawable.top05);
                break;
            case 5:
                ivSelected.setImageResource(R.drawable.top06);
                break;
            case 6:
                ivSelected.setImageResource(R.drawable.top07);
                break;
            case 7:
                ivSelected.setImageResource(R.drawable.top08);
                break;
            case 8:
                ivSelected.setImageResource(R.drawable.top09);
                break;
            case 9:
                ivSelected.setImageResource(R.drawable.top10);
                break;
            case 10:
                ivSelected.setImageResource(R.drawable.top11);
                break;
            case 11:
                ivSelected.setImageResource(R.drawable.top12);
                break;
            case 12:
                ivSelected.setImageResource(R.drawable.top13);
                break;
            case 13:
                ivSelected.setImageResource(R.drawable.top14);
                break;
            case 14:
                ivSelected.setImageResource(R.drawable.top15);
                break;
            case 15:
                ivSelected.setImageResource(R.drawable.top16);
                break;
            case 16:
                ivSelected.setImageResource(R.drawable.top17);
                break;
            case 17:
                ivSelected.setImageResource(R.drawable.top18);
                break;
            case 18:
                ivSelected.setImageResource(R.drawable.top19);
                break;
            case 19:
                ivSelected.setImageResource(R.drawable.top20);
                break;
            case 20:
                ivSelected.setImageResource(R.drawable.top21);
                break;
            case 21:
                ivSelected.setImageResource(R.drawable.top22);
                break;
            case 22:
                ivSelected.setImageResource(R.drawable.top23);
                break;
            case 23:
                ivSelected.setImageResource(R.drawable.top24);
                break;
            case 24:
                ivSelected.setImageResource(R.drawable.top25);
                break;
            case 25:
                ivSelected.setImageResource(R.drawable.top26);
                break;
            case 26:
                ivSelected.setImageResource(R.drawable.top27);
                break;
            case 27:
                ivSelected.setImageResource(R.drawable.top28);
                break;
            case 28:
                ivSelected.setImageResource(R.drawable.top29);
                break;
            case 29:
                ivSelected.setImageResource(R.drawable.top30);
                break;
            case 30:
                ivSelected.setImageResource(R.drawable.top31);
                break;
            case 31:
                ivSelected.setImageResource(R.drawable.top32);
                break;
            case 32:
                ivSelected.setImageResource(R.drawable.top33);
                break;
        }
        Button btBack = findViewById(R.id.btBack);
        btBack.setOnClickListener(new ButtonClickListener());
    }

    private class ButtonClickListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            finish();
        }
    }
}