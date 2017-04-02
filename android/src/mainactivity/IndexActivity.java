package mainactivity;

import com.example.ppd_alarme5.R;

import fonctionactivity.IndexHistoActivity;
import fonctionactivity.IndexListCamActivity;
import fonctionactivity.IndexListeNotifActivity;
import fonctionactivity.IndexProfilActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class IndexActivity extends Activity {
	
	private Button btnindexlistcam;
	private Button btnindexhisto;
	private Button btnnotif;
	private Button btnindexprofil;
	
	protected void onCreate (Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.index);
		
		btnindexlistcam = (Button) findViewById(R.id.btnindexlistcam);
		btnindexhisto = (Button) findViewById(R.id.btnindexhisto);
		btnnotif = (Button) findViewById(R.id.btnnotif);
		btnindexprofil = (Button) findViewById(R.id.btnindexprofil);
		
		
		btnindexlistcam.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i = new Intent(IndexActivity.this, IndexListCamActivity.class);
				startActivity(i);
				
			}
		});
		
		btnindexhisto.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i = new Intent(IndexActivity.this, IndexHistoActivity.class);
				startActivity(i);
			}
		});
		
		btnnotif.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i = new Intent(IndexActivity.this, IndexListeNotifActivity.class);
				startActivity(i);
			}
		});
		
		btnindexprofil.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i = new Intent(IndexActivity.this, IndexProfilActivity.class);
				startActivity(i);
				
			}
		});
		
		
	}

}
