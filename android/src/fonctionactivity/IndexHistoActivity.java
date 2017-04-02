package fonctionactivity;

import voiralerteactivity.VoirHistoAlerteActivity;
import voircamactivity.VoirAppActivity;

import com.example.ppd_alarme5.R;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;

public class IndexHistoActivity extends ListActivity {
	
	private String[] mhistodate = {
			"521: 12/03/2014", "522 : 14/03/2014"
	};
	
	private Button btnvoirhistoalerte;
	private RadioButton radbtnhisto0;
	private RadioButton radbtnhisto1;
	private RadioButton radbtnhisto2;
	private RadioButton radbtnhisto3;
	
	// Utiliser des getters avec la classe camera pour sa !!!!
	
	@Override
	protected void onCreate (Bundle savedInstanceState) {
			
			super.onCreate(savedInstanceState);
			setContentView(R.layout.histoalerte);
			
			ArrayAdapter<String> adapter = new ArrayAdapter<String>
			(this, android.R.layout.simple_list_item_1, mhistodate); 
					 
			setListAdapter(adapter); 
			
			btnvoirhistoalerte = (Button) findViewById(R.id.btnvoirhistoalerte);
			
			btnvoirhistoalerte.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
					radbtnhisto0 = (RadioButton) findViewById(R.id.radbtnhisto0);
					radbtnhisto1 = (RadioButton) findViewById(R.id.radbtnhisto1);
					radbtnhisto2 = (RadioButton) findViewById(R.id.radbtnhisto2);
					
					Bundle objetbunble = new Bundle();
					 
					if (radbtnhisto0.isChecked()) {
						 objetbunble .putString("Alerte",mhistodate[0]);
					}
					
					if (radbtnhisto1.isChecked()) {
						objetbunble .putString("Alerte",mhistodate[1]);
					}
					
					if (radbtnhisto2.isChecked()) {
						
					}
					
					Intent i = new Intent(IndexHistoActivity.this, VoirHistoAlerteActivity.class);
					i.putExtras(objetbunble);
					startActivity(i);
					
				}
			});
			
		
	}
	
}
