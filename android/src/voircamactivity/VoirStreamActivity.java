package voircamactivity;

import com.example.ppd_alarme5.R;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class VoirStreamActivity extends Activity {
	
//	private View fragment1;
	private WebView streamvideoview;
	
	protected void onCreate (Bundle savedInstanceState) {
		
		
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.streamvideo);
		
		streamvideoview = (WebView) findViewById(R.id.streamvideoview);
		//streamvideoview.loadUrl("http://172.19.36.69/ppd/index.php/admin/streaming");
		streamvideoview.loadUrl("http://172.19.36.69/ppd/index.php/admin/streaming");
		
//		FragmentManager fragmentManager = getFragmentManager();
//		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//		MyFragment fragment = new MyFragment();
//		fragmentTransaction.add(R.id.fragment1, fragment);
//		fragmentTransaction.commit();
//		
////		fragment1 = findViewById(R.id.fragment1);
////		fragment1.setOnCreateContextMenuListener(getParent()); {
////			
////			String url = "http://172.19.36.69/ppd/index.php/admin/streaming";
////			Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse( url ) );
////			startActivity(intent);
////	
////		}
//		
////		streamvideoview = findViewById(R.id.streamvideoview);
////		streamvideoview.setOnCreateContextMenuListener(getParent()); {
////			
////			
////		}
//		
//		
//		
	}


}
