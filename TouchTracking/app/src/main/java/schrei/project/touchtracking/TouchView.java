package schrei.project.touchtracking;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by simonschrei on 23.04.17.
 */

public class TouchView extends View {

    // Variables
    private static ArrayList<Touch> myTouches;
    private static int countTouches;
    private static long avgTouches;
    private static String lastTouch;
    private long startMillis;

    // Constructor
    public TouchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        myTouches = new ArrayList<>();
        countTouches = 1;
    }

    // Methods
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        final int action = event.getAction();
        switch (action & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_UP: {

                // first touch time to calculate the avg
                if (countTouches == 1) {
                    startMillis = System.currentTimeMillis();
                }

                // time of touch
                long milliseconds = System.currentTimeMillis();
                SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
                Date resultDate = new Date(milliseconds);
                lastTouch = sdf.format(resultDate);

                // Add touch to ArrayList
                myTouches.add(new Touch(countTouches, (int) event.getX(), (int) event.getY(), lastTouch));

                countTouches++;

                // Calculate the avg of touches per min
                if(((milliseconds - startMillis) / 60000) <= 0) {
                    avgTouches = countTouches - 1;
                }else{
                    avgTouches = (countTouches - 1) / ((milliseconds - startMillis) / 60000);
                }
                break;
            }
        }
        return true;
    }

    // Getter
    public static ArrayList<Touch> getMyTouches() {
        return myTouches;
    }
    public static int getCountTouches() {
        return countTouches-1;
    }
    public static long getAvgTouches() {
        return avgTouches;
    }
    public static String getLastTouch() {
        return lastTouch;
    }

    // Clear Methods
    public static void clearTouches() {
        myTouches.clear();
    }
    public static void clearCountTouches() { TouchView.countTouches = 0; }
    public static void clearAvgTouches() {
        TouchView.avgTouches = 0;
    }
    public static void clearLastTouch() {
        TouchView.lastTouch = "";
    }
}
