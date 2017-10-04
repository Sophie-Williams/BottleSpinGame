package springrainit.nazmul.bottlespingame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final Random RANDOM = new Random();
    private View main;
    private int lastAngle = -1;
    private ImageView bottle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottle= (ImageView) findViewById(R.id.bottle);
    }

    public void spinTheBottle(View view) {
        int angle = RANDOM.nextInt(3600 - 360) + 360;
        float pivotX = bottle.getWidth() / 2;
        float pivotY = bottle.getHeight() / 2;

        final Animation animRotate = new RotateAnimation(lastAngle == -1 ? 0 : lastAngle, angle, pivotX, pivotY);
        lastAngle = angle;
        animRotate.setDuration(2500);
        animRotate.setFillAfter(true);

        bottle.startAnimation(animRotate);
    }
}
