package net.sourceforge.opencamera;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;


import java.util.ArrayList;


/**
 * Created by WG on 2015-10-22.
 */
public class GalleryActivity extends Activity {
    private static final String TAG = "GalleryActivity";
    private GridView gridView;
    private ArrayList<String> urls;
    private GridViewAdapter gridViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if( MyDebug.LOG ) {
            Log.d(TAG, "onCreate");
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_layout);

        Intent intent = getIntent();
        urls = intent.getExtras().getStringArrayList("imageList");
        gridView = (GridView)findViewById(R.id.iv_grid);
        gridViewAdapter = new GridViewAdapter(GalleryActivity.this, urls);
        gridView.setSelector(new StateListDrawable()); // image 선택시 생기는 여백 제거
        try{
            gridView.setAdapter(gridViewAdapter);
        }catch (OutOfMemoryError E) {
            E.printStackTrace();
        }

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String clickImageUrl = gridViewAdapter.getItem(position).toString();


                Intent intent = new Intent(GalleryActivity.this, GalleryPanoViewer.class);
                intent.putExtra("clickImageUrl", clickImageUrl);
                startActivity(intent);

                /*  그리드 뷰 이미지 클릭시 view pager로 연동
                String clickImageUrl = gridViewAdapter.getItem(position).toString();

                Intent intent = new Intent(GalleryActivity.this, GalleryViewPagerActivity.class);
                intent.putExtra("urls", urls);
                intent.putExtra("clickImageUrl", position);
                startActivity(intent);
                */

            }
        });
    }
}
