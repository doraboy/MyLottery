package tw.dora.mylottery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createLottery(View view) {

    }


    @Override
    public void onBackPressed() {
        //不能再回去歡迎畫面
    }


}
