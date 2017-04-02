package com.example.ppd_alarme5;

import java.util.ArrayList;

import mainactivity.IndexActivity;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import outils.SimpleHttpClient;

import com.example.ppd_alarme5.R;

import android.support.v4.app.Fragment;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends Activity {

	Button btnlogin;
	Button btntesturl;
	
	EditText un, pw;
    private String errorMsg;
    private String resp;
    TextView liberr;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		un = (EditText) findViewById(R.id.saisielogin);
        pw = (EditText) findViewById(R.id.saisiemdp);
		
		btnlogin = (Button) findViewById(R.id.btnlogin);
		btnlogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
//				Intent i = new Intent(MainActivity.this, mainactivity.IndexActivity.class);
//        		startActivity(i);
				
				new Thread(new Runnable() {
					 
				    @Override
				    public void run() {
				        ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
				        postParameters.add(new BasicNameValuePair("username",un.getText().toString()));
				        postParameters.add(new BasicNameValuePair("password",pw.getText().toString()));
				 
				        String response = null;
				        try {
				        	
				            response = SimpleHttpClient.executeHttpPost("http://172.19.33.241:8080/ppd/login", postParameters);
//				            String res = response.toString();
				            resp = response.replaceAll("\\s+", "");
				            // Ouvre l'activité si login bon
				            if (resp.equals("1")) {
				            	Intent i = new Intent(MainActivity.this, mainactivity.IndexActivity.class);
				        		startActivity(i);
				            }
				            else {
				            	liberr = (TextView) findViewById(R.id.liberr);
					            liberr.setText("Erreur de login ou Mot de Passe");
				            }
				            
				        } catch (Exception e) {
				            e.printStackTrace();
				            				            
				        }
				    }
				 
				    }).start();
				    try {
				        Thread.sleep(1000);
				        }
				    catch (Exception e) {
				    }
				  }	
				
		});

	}


}
