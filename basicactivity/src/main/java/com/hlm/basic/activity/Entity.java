package com.hlm.basic.activity;

import android.Manifest;

import java.util.HashMap;
import java.util.Map;

public class Entity {
    public static String mGroupNames[];
    private static String mNameToGroups[][];
    private static String[] mNames;
    private static Map<String, String> mPermissionName = null;

    static {
        mGroupNames = new String[]
                    {   Manifest.permission_group.CALENDAR,
                        Manifest.permission_group.CAMERA,
                        Manifest.permission_group.CONTACTS,
                        Manifest.permission_group.LOCATION,
                        Manifest.permission_group.MICROPHONE,
                        Manifest.permission_group.PHONE,
                        Manifest.permission_group.SENSORS,
                        Manifest.permission_group.SMS,
                        Manifest.permission_group.STORAGE
                    };
        mNameToGroups = new String[][]{
                {Manifest.permission.READ_CALENDAR, Manifest.permission.WRITE_CALENDAR},

                {Manifest.permission.CAMERA},

                {Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS, Manifest.permission.GET_ACCOUNTS},

                {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},

                {Manifest.permission.RECORD_AUDIO},

                {Manifest.permission.READ_PHONE_STATE, Manifest.permission.CALL_PHONE, Manifest.permission.READ_CALL_LOG,
                 Manifest.permission.WRITE_CALL_LOG, Manifest.permission.ADD_VOICEMAIL, Manifest.permission.USE_SIP,
                 Manifest.permission.PROCESS_OUTGOING_CALLS},

                {Manifest.permission.BODY_SENSORS},

                {Manifest.permission.SEND_SMS, Manifest.permission.RECEIVE_SMS, Manifest.permission.READ_SMS,
                 Manifest.permission.RECEIVE_WAP_PUSH, Manifest.permission.RECEIVE_MMS},

                {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}
        };
        mNames = new String[]{"日历", "相机", "通讯录", "位置", "麦克风", "电话", "截屏", "SMS", "存取"};
        mPermissionName = new HashMap<>();
        String names[];
        for (int i = 0; i < 9; i++) {
            names = mNameToGroups[i];
            for (String name : names) {
                mPermissionName.put(name, mNames[i]);
            }
        }
    }

    public Entity() {
    }

    public static String getName(String permission) {
        return mPermissionName.get(permission);
    }
}
