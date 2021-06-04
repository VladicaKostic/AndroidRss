package rs.sindikatlfs.sindikatlekaraifarmaceutasrbije;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;

import java.util.List;

/**
 * Created by Vladica on 1/28/2016.
 */
public class ListListener implements AdapterView.OnItemClickListener {

    List<VestPodaci> listItems;
    Activity activity;

    public ListListener(List<VestPodaci> aListItems, Activity anActivity) {

        listItems = aListItems;
        activity = anActivity;
    }

    @Override
    public void onItemClick(AdapterView parent, View view, int pos, long id) {

        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(listItems.get(pos).getLink()));
        activity.startActivity(i);

    }
}
