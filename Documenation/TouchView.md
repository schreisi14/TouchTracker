# Class TouchView

## Description
```
In this class the "magic" happens.
With the method which is declared below the app track the touches.
```

## Variables
```
- ArrayList<Touch> myTouches;
- int countTouches;
- long avgTouches;
- String lastTouch;
- long startmillis;
```

## Link
```
- https://developer.android.com/reference/android/view/MotionEvent.html
```

## Method
To create my a Application which track the touches you can implement everything by yourself but if you are a bit lazy and think maybe someone already implemented something like this you are right.

A touch is a event and you can catch this event and let your Application do what you want.
In my case I count them and save the position from the touch.

This is the method I wrote:

```
@Override
    public boolean onTouchEvent(MotionEvent event) {
        final int action = event.getAction();

        switch (action & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_UP: {

                // first touch to calculate the avg touches later
                if (countTouches == 0) {
                    startmillis = System.currentTimeMillis();
                }

                // time of touch
                long milliseconds = System.currentTimeMillis();
                SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
                Date resultDate = new Date(milliseconds);
                lastTouch = sdf.format(resultDate);

                // add touch to ArrayList
                myTouches.add(new Touch(countTouches, (int) event.getX(), (int) event.getY(), lastTouch));

                // increase touches
                countTouches++;

                // calculate the avg touch
                if(((milliseconds - startmillis) / 60000) <= 0) {
                    avgTouches = countTouches;
                }else{
                    avgTouches = countTouches / ((milliseconds - startmillis) / 60000);
                }

                break;
            }
        }
        return true;
    }
```
