package kr.hs.emirim.w2029.project11_2;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GalleryAdapter extends BaseAdapter {
    Context context;
    int[] posterIds = {R.drawable.post1, R.drawable.post2, R.drawable.post3, R.drawable.post4, R.drawable.post5,
                        R.drawable.post6, R.drawable.post7, R.drawable.post8, R.drawable.post9, R.drawable.post10,};
    int[] titleIds = {R.string.title01, R.string.title02, R.string.title03, R.string.title04, R.string.title05,
            R.string.title06, R.string.title07, R.string.title08, R.string.title09, R.string.title010};

    ImageView imgvLarge;

    public GalleryAdapter(Context context, ImageView imgvLarge){
        this.context = context;
        this.imgvLarge = imgvLarge;
    }
    @Override
    public int getCount() {
        return posterIds.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imgv = new ImageView(context);
        imgv.setLayoutParams(new Gallery.LayoutParams(200, 300));
        imgv.setImageResource(posterIds[position]);
        imgv.setScaleType(ImageView.ScaleType.FIT_CENTER);
        final  int pos = position;
        imgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgvLarge.setImageResource(posterIds[pos]);
                Toast toast = new Toast(context);
                View toastView = View.inflate(context, R.layout.toast1, null);
                TextView textTile = toastView.findViewById(R.id.text_title);
                textTile.setText(titleIds[pos]);
                toast.setView(toastView);
                toast.show();
            }
        });
        return imgv;
    }
}
