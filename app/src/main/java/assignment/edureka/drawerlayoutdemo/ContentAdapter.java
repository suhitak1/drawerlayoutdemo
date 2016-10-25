package assignment.edureka.drawerlayoutdemo;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.List;

/**
 * Created by suhit_000 on 7/20/2016.
 */
public class ContentAdapter extends ArrayAdapter<ContentMain> {

    Context context;
    List<ContentMain> imageList;

    public ContentAdapter(Context context, int resource, List<ContentMain> objects) {
        super(context, resource, objects);
        this.context = context;
        this.imageList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.image_items,parent,false);

        ImageView imageView = (ImageView) view.findViewById(R.id.displayImageView);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setPadding(10, 10, 10, 10);

        imageView.setBackgroundResource(imageList.get(position).getImageID());

        return view;
    }
}
