package net.sourceforge.opencamera;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.File;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by WG on 2015-10-22.
 */
public class GalleryActivity extends Activity {
    private ImageView imageView;
    private PhotoViewAttacher mAttacher;
    private MyApplicationInterface applicationInterface = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_layout);


        imageView = (ImageView) findViewById(R.id.iv_simple);
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES + "/" + "pastel"), "suji.jpg");
        SimpleImage(this, file, imageView);
    }

    public void SimpleImage(Context context, File file, ImageView imageView){
        mAttacher = new PhotoViewAttacher(imageView);

        //File file = new File(image_list);
        Picasso.with(context)
                .load(file)    //.load(uri)
                .into(imageView);
    }
}