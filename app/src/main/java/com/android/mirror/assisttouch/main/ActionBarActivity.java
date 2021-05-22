package com.android.mirror.assisttouch.main;

import android.content.Intent;
import android.os.Bundle;

public abstract class ActionBarActivity {
    protected abstract void onCreate(Bundle savedInstanceState);

    protected abstract void onActivityResult(int requestCode, int resultCode, Intent data);
}
