package info.adamjsmith.passingdata;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class Main extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void onClick(View view) {
    	Intent i = new Intent("info.adamjsmith.PassingDataSecondActivity");
    	
    	i.putExtra("str1", "This is a string");
    	i.putExtra("age1", 25);
    	
    	Bundle extras = new Bundle();
    	extras.putString("str2", "This is another string");
    	extras.putInt("age2", 35);
    	
    	i.putExtras(extras);
    	
    	startActivityForResult(i, 1);
    }
    
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    	if (requestCode == 1) {
    		if (resultCode == RESULT_OK) {
    			Toast.makeText(this, Integer.toString(data.getIntExtra("age3", 0)), Toast.LENGTH_SHORT).show();
    			Toast.makeText(this, data.getData().toString(), Toast.LENGTH_SHORT).show();
    		}
    	}
    }
}
