package voircamactivity;

import mainactivity.IndexActivity;

import com.example.ppd_alarme5.R;

import fonctionactivity.IndexHistoActivity;
import fonctionactivity.IndexListCamActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class VoirAppActivity extends Activity {
	
	private Button btnstream;
	
	protected void onCreate (Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.voirapp);
		
		final TextView textchampsaisie = (TextView) findViewById(R.id.libapp); 
		Bundle objetbunble = this.getIntent().getExtras();
		
		String InfoPasse= objetbunble .getString("Appareil");
		textchampsaisie .setText(InfoPasse);
		
		btnstream = (Button) findViewById(R.id.btnstream);
		
		btnstream.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
//				String url = "http://172.19.36.69/ppd/index.php/admin/streaming";
//				Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse( url ) );
//				startActivity(intent);
				
				Intent i = new Intent(VoirAppActivity.this,VoirStreamActivity.class);
				startActivity(i);
				
			}
		});
		
	}

}
