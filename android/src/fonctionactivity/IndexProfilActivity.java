package fonctionactivity;

import java.util.ArrayList;

import com.example.ppd_alarme5.R;

import modifprofilactivity.ProfilModifEmailActivity;
import modifprofilactivity.ProfilModifMdpActivity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class IndexProfilActivity extends Activity {
	
	
	private String logintest = "Test";
	private String mdptest = "test";
	private String emailtest = "test@hotmail.fr";
	private Button B_modif;
	private Button B_modifemail;
	private TextView liblogin;
	private TextView libmdp;
	private TextView libemail;

	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profil);
		
		liblogin = (TextView) findViewById(R.id.liblogin);
		liblogin.setText(logintest);
		
		libmdp = (TextView) findViewById(R.id.libmdp);
		libmdp.setText(mdptest);
		
		libemail = (TextView) findViewById(R.id.libemail);
		libemail.setText(emailtest);
		
		B_modif = (Button) findViewById(R.id.btnmodifmdp);
		B_modif.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent i = new Intent(IndexProfilActivity.this,ProfilModifMdpActivity.class);
				startActivity(i);
				
			}
		});
		
		B_modifemail = (Button) findViewById(R.id.btnmodifemail);
		B_modifemail.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent i = new Intent(IndexProfilActivity.this,ProfilModifEmailActivity.class);
				startActivity(i);
				
			}
		});
	}
}
