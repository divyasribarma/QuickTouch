package com.android.mirror.assisttouch.main;

import android.app.ActivityManager;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.mirror.assisttouch.MyAdminReceiver;
import com.android.mirror.assisttouch.R;
import com.android.mirror.assisttouch.service.AssistiveTouchService;
import com.android.mirror.assisttouch.utils.SystemsUtils;

public class MainActivity extends ActionBarActivity {

    private Button startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("Mirror", SystemsUtils.isRooted() + " ");

        ComponentName componentName;
        componentName = new ComponentName(this, MyAdminReceiver.class);
        Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
        intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, componentName);
        startActivityForResult(intent, 0);

        startBtn = startBtn.findViewById();
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(MainActivity.this, AssistiveTouchService.class);
                if(isMyServiceRunning(AssistiveTouchService.class))
                    stopService(intent);
                else
                    startService(intent);
            }
        });
    }

    private void startService(Intent intent) {
    }

    private void stopService(Intent intent) {
    }

    private void startActivityForResult(Intent intent, int i) {
    }

    private void setContentView(int activity_main) {
    }

    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    private Object getSystemService(String activityService) {
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
