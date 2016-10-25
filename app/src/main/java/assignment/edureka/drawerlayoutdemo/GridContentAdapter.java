package assignment.edureka.drawerlayoutdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.List;

/**
 * Created by suhit_000 on 7/20/2016.
 */
public class GridContentAdapter extends BaseAdapter {

    Context context;
    List<ContentMain> imageList;

    public GridContentAdapter(Context context, List<ContentMain> objects) {
        this.context = context;
        this.imageList = objects;
    }

    @Override
    public int getCount() {
        return imageList.size();
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
    public View getView(int i, View convertView, ViewGroup viewGroup) {
       /* ImageView imageView;

        if(view == null){
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(5,5,5,5);
        } else {
            imageView = (ImageView) view;
        }

        imageView.setImageResource(imageList.get(i).getImageID());
        return imageView;
    }*/
        View view = LayoutInflater.from(context).inflate(R.layout.image_items, viewGroup, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.displayImageView);
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(300, 300));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setPadding(8,8,8,8);

        imageView.setBackgroundResource(imageList.get(i).getImageID());

        return view;
    }
}
