package tw.dora.mylottery;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashSet;

public class MainActivity extends AppCompatActivity {
    private TextView tempNum;
    private Button gotoCup;
    private TextView[] nums = new TextView[6];
    private int now;
    private HashSet<Integer> hist = new HashSet<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tempNum = findViewById(R.id.tempNum);
        gotoCup = findViewById(R.id.gotoCup);

        nums[0] = findViewById(R.id.num1);
        nums[1] = findViewById(R.id.num2);
        nums[2] = findViewById(R.id.num3);
        nums[3] = findViewById(R.id.num4);
        nums[4] = findViewById(R.id.num5);
        nums[5] = findViewById(R.id.num6);

    }

    private void reset(){
        now = 0;
        nums[0].setText("-");
        nums[1].setText("-");
        nums[2].setText("-");
        nums[3].setText("-");
        nums[4].setText("-");
        nums[5].setText("-");
        hist.clear();
    }

    public void createNum(View view) {
        if(now >= 6) reset();

        int rand = -1;
        do{
            rand = (int)(Math.random()*49+1);
        }while(hist.contains(rand));

        //紀錄已出現過數字,避免重複
        hist.add(rand);

        tempNum.setText("" + rand);
        tempNum.setVisibility(View.VISIBLE);
        gotoCup.setVisibility(View.VISIBLE);
    }

    public void gotoCup(View view) {
        Intent intent = new Intent(this,CupActivity.class);
        startActivityForResult(intent , 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode >= 2){
            //God said OK
            nums[now].setText(tempNum.getText());
            now++;
        }
        tempNum.setVisibility(View.GONE);
        gotoCup.setVisibility(View.GONE);
    }

    @Override
    public void onBackPressed() {
           //不能再回去歡迎畫面
    }



}
