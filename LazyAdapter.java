package rs.sindikatlfs.sindikatlekaraifarmaceutasrbije;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Vladica on 1/28/2016.
 */
public class LazyAdapter extends ArrayAdapter<VestPodaci> {

    private VestPodaci[] datas;
    private Activity activity;

    public LazyAdapter(MainActivity local, int textViewResourceId, List<VestPodaci> result) {
        super(local, textViewResourceId, result);
        activity = local;

        VestPodaci[] array = result.toArray(new VestPodaci[0]);
        datas = array;
    }

    public class ViewHolder {
        TextView postTitleView;
        TextView postDateView;
        ImageView postImageView;
    }

    public View getView (int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            convertView = inflater.inflate(R.layout.list_row, null);

            viewHolder = new ViewHolder();
            viewHolder.postImageView = (ImageView) convertView.findViewById(R.id.list_image);
            viewHolder.postTitleView = (TextView) convertView.findViewById(R.id.title);
            viewHolder.postDateView = (TextView) convertView.findViewById(R.id.date);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (datas[position].imageUrl == null) {
            viewHolder.postImageView.setImageResource(R.drawable.logolp);
        }

        viewHolder.postTitleView.setText(datas[position].title);

        DateFormat formatter = null;
        Date convertedDate = null;
        String datum = datas[position].date;
        formatter = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz");
        String strDatum = null;
        try {
            convertedDate = formatter.parse(datum);
            strDatum = convertedDate.toString();
        } catch (ParseException e) {

        }
        viewHolder.postDateView.setText(strDatum);

        return convertView;
    }
}

