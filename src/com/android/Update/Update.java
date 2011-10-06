package com.android.Update;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.Button;
import android.widget.TextView;
import android.os.RecoverySystem;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

import java.io.IOException;

public class Update extends Activity {
    private static File SD_UPDATE_DIR = new File("/sdcard/update.zip");    
    private static File MEDIA_UPDATE_DIR = new File("/flash/update.zip");    
    private static File SD_PATCH_DIR = new File("/sdcard/patch.zip");    
    private static File MEDIA_PATC_DIR = new File("/flash/patch.zip");  
        
    private static final String TAG = "Update.Update";
	public static final boolean DEBUG = true;
	private FileUtils mFileUtils = null;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.main);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title);
        
        mFileUtils = new FileUtils();
        setContentView(R.layout.update_mothed);
        LinearLayout layout = (LinearLayout)findViewById(R.id.update_mothed);
        Button upgrade = (Button)layout.findViewById(R.id.upgrade);
        Button patch = (Button)layout.findViewById(R.id.patch);
        upgrade.setOnClickListener(new Button.OnClickListener(){
        	public void onClick(View v) {
                if(mFileUtils.sdexist()) {
                	if(mFileUtils.exists(new String(FileUtils.SD_PARH+FileUtils.UPGRADE_NAME))) {
                		setContentView(R.layout.end);
                        LinearLayout layout = (LinearLayout)findViewById(R.id.end);
                        Button yes = (Button)layout.findViewById(R.id.yes);
                        Button no = (Button)layout.findViewById(R.id.no);
                        yes.setOnClickListener(new Button.OnClickListener(){
                        	public void onClick(View v) {
                                try {
                                    RecoverySystem.installPackage(Update.this,SD_UPDATE_DIR);
                                } catch (IOException e) {
                                }                        	    
                        		reboot();
                        		Update.this.finish();
                        	}
                        });
                        no.setOnClickListener(new Button.OnClickListener(){
                        	public void onClick(View v) {
                        		Update.this.finish();
                        	}
                        });
                	}
                	else {
                		setContentView(R.layout.no_file);
                        LinearLayout layout = (LinearLayout)findViewById(R.id.no_file);
                        TextView txt = (TextView)layout.findViewById(R.id.text);
                        txt.setText(R.string.no_upgrade_file);
                        Button exit = (Button)layout.findViewById(R.id.exit);
                        exit.setOnClickListener(new Button.OnClickListener(){
                        	public void onClick(View v) {
                        		Update.this.finish();
                        	}
                        });
                	}
                }
                else {
                	if(mFileUtils.exists(new String(FileUtils.INTERNAL_MEMORY_PATH+FileUtils.UPGRADE_NAME))) {
                		setContentView(R.layout.end);
                        LinearLayout layout = (LinearLayout)findViewById(R.id.end);
                        Button yes = (Button)layout.findViewById(R.id.yes);
                        Button no = (Button)layout.findViewById(R.id.no);
                        yes.setOnClickListener(new Button.OnClickListener(){
                        	public void onClick(View v) {
                                try {                                   
                                    RecoverySystem.installPackage(Update.this,MEDIA_UPDATE_DIR);
                                } catch (IOException e) {
                                }
                        		reboot();
                        		Update.this.finish();
                        	}
                        });
                        no.setOnClickListener(new Button.OnClickListener(){
                        	public void onClick(View v) {
                        		Update.this.finish();
                        	}
                        });
                	}
                	else {
                		setContentView(R.layout.no_file);
                        LinearLayout layout = (LinearLayout)findViewById(R.id.no_file);
                        TextView txt = (TextView)layout.findViewById(R.id.text);
                        txt.setText(R.string.no_upgrade_file);
                        Button exit = (Button)layout.findViewById(R.id.exit);
                        exit.setOnClickListener(new Button.OnClickListener(){
                        	public void onClick(View v) {
                        		Update.this.finish();
                        	}
                        });
                	}
                }
        	}
        });
        patch.setOnClickListener(new Button.OnClickListener(){
        	public void onClick(View v) {
                if(mFileUtils.sdexist()) {
                	if(mFileUtils.exists(new String(FileUtils.SD_PARH+FileUtils.PATCH_NAME))) {
                		setContentView(R.layout.end);
                        LinearLayout layout = (LinearLayout)findViewById(R.id.end);
                        Button yes = (Button)layout.findViewById(R.id.yes);
                        Button no = (Button)layout.findViewById(R.id.no);
                        yes.setOnClickListener(new Button.OnClickListener(){
                        	public void onClick(View v) {
                                try {
                                    RecoverySystem.installPackage(Update.this,SD_PATCH_DIR);
                                } catch (IOException e) {
                                }                        	    
                        		reboot();
                        		Update.this.finish();
                        	}
                        });
                        no.setOnClickListener(new Button.OnClickListener(){
                        	public void onClick(View v) {
                        		Update.this.finish();
                        	}
                        });
                	}
                	else {
                		setContentView(R.layout.no_file);
                        LinearLayout layout = (LinearLayout)findViewById(R.id.no_file);
                        TextView txt = (TextView)layout.findViewById(R.id.text);
                        txt.setText(R.string.no_patch_file);
                        Button exit = (Button)layout.findViewById(R.id.exit);
                        exit.setOnClickListener(new Button.OnClickListener(){
                        	public void onClick(View v) {
                        		Update.this.finish();
                        	}
                        });
                	}
                }
                else {
                	if(mFileUtils.exists(new String(FileUtils.INTERNAL_MEMORY_PATH+FileUtils.PATCH_NAME))) {
                		setContentView(R.layout.end);
                        LinearLayout layout = (LinearLayout)findViewById(R.id.end);
                        Button yes = (Button)layout.findViewById(R.id.yes);
                        Button no = (Button)layout.findViewById(R.id.no);
                        yes.setOnClickListener(new Button.OnClickListener(){
                        	public void onClick(View v) {
                                try {
                                    RecoverySystem.installPackage(Update.this,MEDIA_PATC_DIR);
                                } catch (IOException e) {
                                }                         	    
                        		reboot();
                        		Update.this.finish();
                        	}
                        });
                        no.setOnClickListener(new Button.OnClickListener(){
                        	public void onClick(View v) {
                        		Update.this.finish();
                        	}
                        });
                	}
                	else {
                		setContentView(R.layout.no_file);
                        LinearLayout layout = (LinearLayout)findViewById(R.id.no_file);
                        TextView txt = (TextView)layout.findViewById(R.id.text);
                        txt.setText(R.string.no_patch_file);
                        Button exit = (Button)layout.findViewById(R.id.exit);
                        exit.setOnClickListener(new Button.OnClickListener(){
                        	public void onClick(View v) {
                        		Update.this.finish();
                        	}
                        });
                	}
                }
        	}
        });
    }
    
	@Override
	public void onConfigurationChanged(Configuration newConfig) {	
		super.onConfigurationChanged(newConfig);
	}

    private void reboot() {
    	if(DEBUG) Log.d(TAG, "reboot");
        Intent intent = new Intent();
        intent.setClassName("com.android.RebootReceiver","com.android.RebootReceiver.RebootReceiver");
        startActivity(intent); 
    }
}