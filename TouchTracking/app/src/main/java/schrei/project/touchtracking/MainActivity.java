package schrei.project.touchtracking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static schrei.project.touchtracking.TouchView.getCountTouches;

public class MainActivity extends AppCompatActivity {

    // Variables
    private Button btn_statistic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_statistic = (Button) findViewById(R.id.btn_MainStatistic);

        btn_statistic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 5 because I load the last five touches
                if (getCountTouches() > 5) {
                    startActivity(new Intent(MainActivity.this, StatisticActivity.class));
                }
            }
        });


    }
}
