package rs.sindikatlfs.sindikatlekaraifarmaceutasrbije;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import com.pushbots.push.Pushbots;

import java.util.List;

public class MainActivity extends Activity {

    private MainActivity local;

    ListView list;
    LazyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        long total = 1500;
        long timestampStart = System.currentTimeMillis();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Pushbots.sharedInstance().init(this);

        local = this;

        GetRssDataTask task = new GetRssDataTask();
        task.execute("http://www.sindikatlfs.rs/feed/");


        long elapsed = System.currentTimeMillis() - timestampStart;
        long remaining = total - elapsed;

        try {
            Thread.sleep(remaining, 0);
        } catch (InterruptedException e) {

        }
    }

    private class GetRssDataTask extends AsyncTask<String, Void, List<VestPodaci>> {

        @Override
        protected List<VestPodaci> doInBackground(String... urls) {


            try {
                RssReader rssReader = new RssReader(urls[0]);
                return rssReader.getItems();
            } catch (Exception e) {

            }
            return null;
        }

        @Override
        protected void onPostExecute(List<VestPodaci> result) {
            list = (ListView)findViewById(R.id.list);
            adapter = new LazyAdapter(local, R.layout.list_row, result);
            list.setAdapter(adapter);
            list.setOnItemClickListener(new ListListener(result, local));
        }
    }
}
