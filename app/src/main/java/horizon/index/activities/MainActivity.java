package horizon.index.activities;

import androidx.appcompat.app.AppCompatActivity;
import horizon.index.R;
import horizon.index.common.DecorUtil;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DecorUtil.setDecorFullBlack(this);
        DecorUtil.setColorTransparent(this);
    }
}