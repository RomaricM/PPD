package voirnotifactivity;

import com.example.ppd_alarme5.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class VoirNotifActivity extends Activity {
		
	protected void onCreate (Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.voirnotif);
		
		final TextView textchampsaisie = (TextView) findViewById(R.id.libalerte); 
		Bundle objetbunble = this.getIntent().getExtras();
		
		String InfoPasse= objetbunble .getString("Notif");
		textchampsaisie .setText(InfoPasse);
		
	}
}
