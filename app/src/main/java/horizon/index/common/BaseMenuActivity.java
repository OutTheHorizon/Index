package horizon.index.common;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author horizon
 * @Description 只要设置好 mClasses和mName和mTitle 就好
 */
public abstract class BaseMenuActivity extends AppCompatActivity {
    private Intent mIntent;
    private LinearLayout ll;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ll = new LinearLayout(this);
        ll.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        ll.setOrientation(LinearLayout.VERTICAL);
//        ll.setBackgroundColor(0xdd555555);

        ScrollView scrollView = new ScrollView(this);
        scrollView.addView(ll);
        scrollView.setBackgroundColor(0xdd555555);
        scrollView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        setContentView(scrollView);
        toOtherActivity();
    }
    private void toOtherActivity(){
        TextView demo;
        demo= new TextView(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-1, -2);
        lp.topMargin = 20;
        demo.setLayoutParams(lp);
        demo.setTextColor(Color.WHITE);
        demo.setGravity(Gravity.CENTER_VERTICAL);
        demo.setTextSize(30);
        demo.setPadding(40, 20, 0, 20);
        demo.setBackgroundColor(0xdd950095);
        demo.setText(getSumTitle());
        ll.addView(demo);

        for (int i = 0; i < getCount(); i++) {
            demo= new TextView(this);
            lp = new LinearLayout.LayoutParams(-1, -2);
            lp.topMargin = 20;
            demo.setLayoutParams(lp);
            demo.setTextColor(Color.WHITE);
            demo.setGravity(Gravity.CENTER_VERTICAL);
            demo.setPadding(40, 20, 0, 20);
            demo.setBackgroundColor(0xdd959595);
            demo.setText(getActivitiesName(i));
            ll.addView(demo);
            final int finalI = i;
            demo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mIntent=new Intent(BaseMenuActivity.this, getActivitiesClass(finalI));
                    startActivity(mIntent);
                }
            });
        }
    }

    protected abstract int getCount();
    protected abstract Class getActivitiesClass(int pos);
    protected abstract String getActivitiesName(int pos);
    protected abstract String getSumTitle();
}
