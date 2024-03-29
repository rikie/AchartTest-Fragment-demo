package com.example.acharttest;

import com.example.acharttest.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ViewFlipper;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;;

public class MainActivity extends Activity {

	
	int mFlipping = 0 ; // Initially flipping is off
	Button mButton ; // Reference to button available in the layout to start and stop the flipper

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        /** Click event handler for button */
        OnClickListener listener = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ViewFlipper flipper = (ViewFlipper) findViewById(R.id.flipper1);
				
				if(mFlipping==0){
					/** Start Flipping */
					flipper.startFlipping();
					mFlipping=1;
					mButton.setText(R.string.str_btn_stop);
				}
				else{
					/** Stop Flipping */
					flipper.stopFlipping();					
					mFlipping=0;
					mButton.setText(R.string.str_btn_start);
				}
			}
		};
		
		/** Getting a reference to the button available in the resource */
        mButton = (Button) findViewById(R.id.btn);
        
        /** Setting click event listner for the button */
        mButton.setOnClickListener(listener);
        
        
    }
    
	@Override
	protected void onPostCreate(final Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		if (null == savedInstanceState) {
			getFragmentManager().beginTransaction().add(R.id.chart, new ChartFragment()).commit();
		}
	}
	
}
