package in.waghtech.motivationalquotes;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ProgressBar;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.ChasingDots;

public class splash extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Handler handler=new Handler();
        ProgressBar progressBar = findViewById(R.id.progress);
        Sprite doubleBounce = new ChasingDots();
        progressBar.setIndeterminateDrawable(doubleBounce);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(splash.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 4500);
    }
}
