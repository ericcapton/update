package com.android.Update;

import java.io.File;

import android.os.Environment;
import android.util.Log;

public class FileUtils {
	private static final String TAG = "Update.FileUtils";
	public final static String SD_PARH = "/mnt/sdcard/";
	public final static String INTERNAL_MEMORY_PATH = "/mnt/flash/";
	public final static String UPGRADE_NAME = "update.zip";
	public final static String PATCH_NAME = "patch.zip";
	
	public boolean exists(String path) {
		File file = new File(path);
		return file.exists();
	}
	
	public boolean sdexist() {
		return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
	}
}
