package sl.pick.wheel;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

import sl.pick.wheel.utils.UtilsLog;
import wheel.pick.sl.picker.view.TimePickerView;

/**
 * 仿iOS滚动时间选择，可选开始和结束时间点
 */
public class MainActivity extends Activity {
    private Context ctx;
    private TimePickerView pvTime;

    private Button btnChooseTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ctx = this;

        btnChooseTime = (Button) findViewById(R.id.btnChooseTime);
        initTimeWheel();
        btnChooseTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pvTime.show();
            }
        });


    }

    private void initTimeWheel(){
        pvTime = new TimePickerView(ctx, TimePickerView.Type.HOURS_MINS);
        // 控制时间范围

        Calendar calendar = Calendar.getInstance();
        pvTime.setTimeRange(7, 30, 19, 30);
        pvTime.setCyclic(false);
        pvTime.setCancelable(true);
        // 时间选择后回调
        pvTime.setOnTimeSelectListener(new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Calendar calendar) {
                UtilsLog.logE(calendar.get(Calendar.HOUR_OF_DAY) + " " + calendar.get(Calendar.MINUTE));
            }
        });
    }
}
