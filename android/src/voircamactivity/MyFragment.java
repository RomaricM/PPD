package voircamactivity;

import com.example.ppd_alarme5.R;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MyFragment extends Fragment{
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.stream, container, false);
    }
	
	public void onCreate (Bundle savedInstanceState) {
		
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.stream);
		
		String url = "http://172.19.36.69/ppd/index.php/admin/streaming";
		Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse( url ) );
		startActivity(intent);
	}

}
