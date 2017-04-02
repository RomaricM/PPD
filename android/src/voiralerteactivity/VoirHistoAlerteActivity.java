package voiralerteactivity;

import com.example.ppd_alarme5.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class VoirHistoAlerteActivity extends Activity {
	
	protected void onCreate (Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.voiralerte);
		
		final TextView textchampsaisie = (TextView) findViewById(R.id.result); 
		Bundle objetbunble = this.getIntent().getExtras();
		
		String InfoPasse= objetbunble .getString("Alerte");
		textchampsaisie .setText(InfoPasse);
		
		
		
	}

}
