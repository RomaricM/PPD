package voircamactivity;

import com.example.ppd_alarme5.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class VoirInfraActivity extends Activity {
	
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.voirinfra);
		
		final TextView textchampsaisie = (TextView) findViewById(R.id.libapp); 
		Bundle objetbunble = this.getIntent().getExtras();
		
		String InfoPasse= objetbunble .getString("Appareil");
		textchampsaisie .setText(InfoPasse);
		
	}

}
