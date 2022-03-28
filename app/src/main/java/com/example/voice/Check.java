package com.example.voice;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.io.File;
import java.util.ArrayList;

public class Check {
    private static final int MY_PERMISSIONS_REQUEST_READ_STORAGE = 1;

    public void checkPermissionReadStorage(Activity activity) {
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE) !=
                PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
            } else {
                ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_READ_STORAGE);
            }
        }
    }

    public void try_to_navigate_local_dir(){
        Environment e = new Environment();
        ArrayList <String> filesList = new ArrayList<String>();
        String sd_card = Environment.getExternalStorageDirectory().toString() + "/Music/Recordings/Standard Recordings";
        File file = new File(sd_card) ;
        File list[] = file.listFiles();
        for( int i=0; i< list.length; i++) {
            filesList.add( list[i].getName() );
        }

    }

}
