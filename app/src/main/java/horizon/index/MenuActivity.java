package horizon.index;

import horizon.index.activities.MainActivity;
import horizon.index.common.BaseMenuActivity;

public class MenuActivity extends BaseMenuActivity {
    private Class[] classes = {MainActivity.class};
    private String[] name ={"测试"};
    @Override
    protected int getCount() {
        return classes.length;
    }

    @Override
    protected Class getActivitiesClass(int pos) {
        return classes[pos];
    }

    @Override
    protected String getActivitiesName(int pos) {
        return name[pos];
    }

    @Override
    protected String getSumTitle() {
        return "Horizon的私人空间";
    }
}
