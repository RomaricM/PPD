package fonctionactivity;
 
import java.util.ArrayList;

import voircamactivity.VoirAppActivity;
import voirnotifactivity.VoirNotifActivity;

import com.example.ppd_alarme5.R;
 
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
 
public class IndexListeNotifActivity extends ListActivity {
     
     
    // Exemple de liste de notification (ici chaîne de caractères)
    private String[] mCam = {
    "Notification 1 : 14/03/2014 — 16:13:22", "Notification 2 : 16.03.2014 - 23:05:36"
    };
    
    private Button btnvoirnotif;
	private RadioButton radbtnnotif0;
	private RadioButton radbtnnotif1;
	private RadioButton radbtnnotif2;
     
    @Override
    protected void onCreate(Bundle savedInstanceState) {
         
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listenotification);
         
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
        (this, android.R.layout.simple_list_item_1, mCam);
         
        setListAdapter(adapter);
        
        btnvoirnotif = (Button) findViewById(R.id.btnvoirnotif);
		
        btnvoirnotif.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				radbtnnotif0 = (RadioButton) findViewById(R.id.radbtnnotif0);
				radbtnnotif1 = (RadioButton) findViewById(R.id.radbtnnotif1);
				radbtnnotif2 = (RadioButton) findViewById(R.id.radbtnnotif2);
				
				Bundle objetbunble = new Bundle();
				 
				if (radbtnnotif0.isChecked()) {
					 objetbunble .putString("Notif",mCam[0]);
				}
				
				if (radbtnnotif1.isChecked()) {
					objetbunble .putString("Notif",mCam[1]);
				}
				
				if (radbtnnotif2.isChecked()) {
					
				}
				
				Intent i = new Intent(IndexListeNotifActivity.this, VoirNotifActivity.class);
				i.putExtras(objetbunble);
				startActivity(i);
				
			}
		});
         
    }
     
}
