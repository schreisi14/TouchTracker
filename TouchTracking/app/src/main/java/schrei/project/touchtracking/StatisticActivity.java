package schrei.project.touchtracking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static schrei.project.touchtracking.TouchView.clearAvgTouches;
import static schrei.project.touchtracking.TouchView.clearCountTouches;
import static schrei.project.touchtracking.TouchView.clearLastTouch;
import static schrei.project.touchtracking.TouchView.clearTouches;
import static schrei.project.touchtracking.TouchView.getAvgTouches;
import static schrei.project.touchtracking.TouchView.getCountTouches;
import static schrei.project.touchtracking.TouchView.getLastTouch;
import static schrei.project.touchtracking.TouchView.getMyTouches;

public class StatisticActivity extends AppCompatActivity {

    // Variables
    private Button btnReset;
    private TextView txtView_touchCount;
    private TextView txtView_avgPerMin;
    private TextView txtView_lastTouch;
    private TextView txtView_last5Touches1;
    private TextView txtView_last5Touches2;
    private TextView txtView_last5Touches3;
    private TextView txtView_last5Touches4;
    private TextView txtView_last5Touches5;
    private TextView txtView_allTouches;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_statistic);

        // Buttons
        btnReset = (Button) findViewById(R.id.btn_reset);

        // TextViews
        txtView_touchCount = (TextView) findViewById(R.id.txtView_touchCount);
        txtView_avgPerMin = (TextView) findViewById(R.id.txtView_avgPerMin);
        txtView_lastTouch = (TextView) findViewById(R.id.txtView_lastTouch);

        txtView_last5Touches1 = (TextView) findViewById(R.id.textView12);
        txtView_last5Touches2 = (TextView) findViewById(R.id.textView14);
        txtView_last5Touches3 = (TextView) findViewById(R.id.textView16);
        txtView_last5Touches4 = (TextView) findViewById(R.id.textView18);
        txtView_last5Touches5 = (TextView) findViewById(R.id.textView20);

        txtView_allTouches = (TextView) findViewById(R.id.txtView_allTouches);

        // Button functions
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Clear up
                clearAvgTouches();
                clearCountTouches();
                clearLastTouch();
                clearTouches();

                // Text to 0
                txtView_touchCount.setText("" + 0);
                txtView_avgPerMin.setText("" + 0);
                txtView_lastTouch.setText("" + 0);

                txtView_last5Touches1.setText("" + 0);
                txtView_last5Touches2.setText("" + 0);
                txtView_last5Touches3.setText("" + 0);
                txtView_last5Touches4.setText("" + 0);
                txtView_last5Touches5.setText("" + 0);

                txtView_allTouches.setText("All Touches");

            }
        });

        // Load Statistic
        load();

    }

    // load all information
    private void load() {

        int sizeTouches = getMyTouches().size()-1;

        txtView_touchCount.setText("" + getCountTouches());
        txtView_lastTouch.setText("" + getLastTouch());
        txtView_avgPerMin.setText("" + getAvgTouches());

        if(getMyTouches().get(sizeTouches-4).getPosistion().isEmpty()){
            txtView_last5Touches1.setText("" + 0);
        }else{
            txtView_last5Touches1.setText("" + getMyTouches().get(sizeTouches-4).getPosistion());
        }
        if(getMyTouches().get(sizeTouches-3).getPosistion().isEmpty()){
            txtView_last5Touches2.setText("" + 0);
        }else{
            txtView_last5Touches2.setText("" + getMyTouches().get(sizeTouches-3).getPosistion());
        }
        if(getMyTouches().get(sizeTouches-2).getPosistion().isEmpty()){
            txtView_last5Touches3.setText("" + 0);
        }else{
            txtView_last5Touches3.setText("" + getMyTouches().get(sizeTouches-2).getPosistion());
        }
        if(getMyTouches().get(sizeTouches-1).getPosistion().isEmpty()){
            txtView_last5Touches4.setText("" + 0);
        }else{
            txtView_last5Touches4.setText("" + getMyTouches().get(sizeTouches-1).getPosistion());
        }
        if(getMyTouches().get(sizeTouches).getPosistion().isEmpty()){
            txtView_last5Touches5.setText("" + 0);
        }else{
            txtView_last5Touches5.setText("" + getMyTouches().get(sizeTouches).getPosistion());
        }

        txtView_allTouches.setText("");
        for (Touch touch : getMyTouches()) {
            txtView_allTouches.append(touch.toString() + "\n");
        }
    }

}
