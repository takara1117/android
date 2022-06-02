package local.hal.ma42.android.calcbmi90762;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btCalc = findViewById(R.id.btCalc);
        btCalc.setOnClickListener(new ButtonClickListener());
        Button btClear = findViewById(R.id.btClear);
        btClear.setOnClickListener(new ButtonClickListener());
    }

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            EditText etHeight = findViewById(R.id.etHeight);
            EditText etWeight = findViewById(R.id.etWeight);
            TextView tvAnswer = findViewById(R.id.tvAnswer);
            TextView tvMsg    = findViewById(R.id.tvMsg);

            int id = view.getId();
            switch(id) {
                case R.id.btCalc:
                    String strHeight = etHeight.getText().toString();
                    String strWeight = etWeight.getText().toString();
                    
                    //バリデーション
                    if(strHeight.equals("") && strWeight.equals("")) {
                        String msg = "身長/体重を入力してください。";
                        Toast.makeText(MainActivity.this, msg,
                                Toast.LENGTH_SHORT).show();
                    }
                    else {
                        if(strHeight.equals("")) {
                            String msg = "身長を入力してください";
                            Toast.makeText(MainActivity.this, msg,
                            Toast.LENGTH_SHORT).show();
                        }
                        else if (strWeight.equals("")) {
                            String msg = "体重を入力してください";
                            Toast.makeText(MainActivity.this, msg,
                            Toast.LENGTH_SHORT).show();
                        }
                        else {
                            double height = Double.valueOf(strHeight);
                            double weight = Double.valueOf(strWeight);
                            if(height == 0) {
                                String msg = "身長に0はダメですよ！";
                                Toast.makeText(MainActivity.this, msg,
                                Toast.LENGTH_SHORT).show();
                            }
                            else if (weight == 0) {
                                String msg = "体重に0はダメですよ！";
                                Toast.makeText(MainActivity.this, msg,
                                Toast.LENGTH_SHORT).show();
                            }
                            else {
                                //BMI計算
                                BigDecimal bigAns = new BigDecimal(weight / ((height / 100) * (height / 100)));
                                bigAns = bigAns.setScale(1, RoundingMode.HALF_UP);
                                String strAns = bigAns.toString();
                                tvAnswer.setText("BMI数値 : " + strAns);
                                
                                //アドバイスメッセージ
                                double resultBmi = Double.valueOf(strAns);
                                if (resultBmi >= 18.5 && resultBmi < 25) {
                                    tvMsg.setText("ちょうどいいです。\n 現状を維持しましょう");
                                } 
                                else if (resultBmi < 18.5) {
                                    BigDecimal appropriateWeight = new BigDecimal((height / 100) * (height / 100) * 22);
                                    appropriateWeight = appropriateWeight.setScale(0, RoundingMode.HALF_UP);
                                    tvMsg.setText("痩せています \n 体重" + (appropriateWeight) + "kgを目指しましょう");
                                }
                                else if (resultBmi >= 25) {
                                    BigDecimal appropriateWeight = new BigDecimal((height / 100) * (height / 100) * 22);
                                    appropriateWeight = appropriateWeight.setScale(0, RoundingMode.HALF_UP);
                                    tvMsg.setText("肥満です。 \n 体重" + (appropriateWeight) + "kgを目指しましょう");
                                }   
                            }
                        }
                    }
                    break;

                    //クリアボタン
                    case R.id.btClear:
                    etHeight.setText("");
                    etWeight.setText("");
                    tvAnswer.setText("");
                    tvMsg.setText("");
                    break;
                }
            }
        }
    }
