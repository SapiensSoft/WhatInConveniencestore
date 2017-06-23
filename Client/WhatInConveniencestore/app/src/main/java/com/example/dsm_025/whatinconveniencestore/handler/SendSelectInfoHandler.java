package com.example.dsm_025.whatinconveniencestore.handler;

import android.os.Handler;
import android.os.Message;

/**
 * Created by dsm_025 on 2017-06-22.
 */

public class SendSelectInfoHandler extends Handler {
    private static final int SEND_SELECT = 0;
    private static final int SEND_UNSELECT = 1;

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);

        switch (msg.what){
            case SEND_SELECT:
                break;
            case SEND_UNSELECT:
                break;
        }
    }
}
