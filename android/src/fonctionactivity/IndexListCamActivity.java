package fonctionactivity;

import java.util.ArrayList;

import mainactivity.IndexActivity;

import com.example.ppd_alarme5.MainActivity;
import com.example.ppd_alarme5.R;

//import outils.CameraAdapter.CameraAdapterListener;
import voircamactivity.VoirAppActivity;
import voircamactivity.VoirInfraActivity;
//import outils.CameraAdapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;

public class IndexListCamActivity extends ListActivity 
//implements CameraAdapterListener 
{
	private String[] mApp = {
			"1/Toshiba/Camera", "2/Samsung/Infrarouge"
	}; 
	private Button btnvoir;
	private RadioButton radbtnapp1;
	private RadioButton radbtnapp2;
	private RadioButton radbtnapp3;
	
//	@Override
//	public void onClickNom(Camera camera, int position) {
//		
//		Builder builder = new AlertDialog.Builder(this); 
//		 builder.setTitle("Description Camera"); 
//		 builder.setMessage("Sa marche"); 
//		 builder.setPositiveButton("OK", null); 
//		 builder.show(); 
//		
//	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listapp);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>
		(this, android.R.layout.simple_list_item_1, mApp); 
				 
		setListAdapter(adapter); 
		
		btnvoir = (Button) findViewById(R.id.btnvoir);
		
		btnvoir.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				radbtnapp1 = (RadioButton) findViewById(R.id.radbtnapp1);
				radbtnapp2 = (RadioButton) findViewById(R.id.radbtnapp2);
				radbtnapp3 = (RadioButton) findViewById(R.id.radbtnapp3);
				
				Bundle objetbunble = new Bundle();
				 
				if (radbtnapp1.isChecked()) {
					 objetbunble .putString("Appareil",mApp[0]);
					 Intent i = new Intent(IndexListCamActivity.this, VoirAppActivity.class);
					 i.putExtras(objetbunble);
					 startActivity(i);
				}
				
				if (radbtnapp2.isChecked()) {
					objetbunble .putString("Appareil",mApp[1]);
					Intent i = new Intent(IndexListCamActivity.this, VoirInfraActivity.class);
					 i.putExtras(objetbunble);
					 startActivity(i);
				}
				
				if (radbtnapp3.isChecked()) {
					
				}
				
				
			}
		});
		
		
//		//Récupération de la liste des personnes 
//		 ArrayList<Camera> listP = Camera.Initialiser(); 
//		 
//		 //Création et initialisation de l'Adapter pour les contact 
//		 CameraAdapter adapter = new CameraAdapter(this, listP); 
//		 adapter.addListener(this); 
//		 
//
//		 
//		 //Récupération du composant ListView 
//		 ListView list = (ListView)findViewById(R.id.ListView01); 
//		 
//		 //Initialisation de la liste avec les données 
//		 list.setAdapter(adapter);
		 

	}

	
}
