package com.rzfsc.okhttpdemo;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.rzfsc.okhttpdemo.constants.Constants;
import com.rzfsc.okhttpdemo.entity.APIResult;
import com.rzfsc.okhttpdemo.okhttp.OkHttpConstants;
import com.rzfsc.okhttpdemo.okhttp.OkHttpProxy;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private static final String GITHUB_API = "https://api.github.com";

    private static final String GITHUB_API_TITLE = "Github API";

    private ListView mAPIList;

    private APIAdapter mAPIAdapter;

    private List<String[]> mAPIs = new ArrayList<>();


    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mainFragment = inflater.inflate(R.layout.fragment_main, container, false);
        mAPIList = (ListView) mainFragment.findViewById(R.id.api_list);
        mAPIAdapter = new APIAdapter();
        mAPIList.setAdapter(mAPIAdapter);
        mAPIList.addHeaderView(createHeaderView());
        mAPIList.setEmptyView(mainFragment.findViewById(R.id.empty_view));
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        doOkHttpRequest();
                    }
                }
        ).start();
        return mainFragment;
    }

    private View createHeaderView() {
        TextView title = new TextView(getContext());
        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
        int padding = getResources().getDimensionPixelSize(R.dimen.normal_padding);
        title.setPadding(padding, padding, padding, padding);
        title.setText(GITHUB_API_TITLE);
        title.setGravity(Gravity.CENTER);
        title.setLayoutParams(params);
        return title;
    }

    private Drawable createItemBackground() {
        GradientDrawable itemBg = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xFFFFFFFF, 0xFFAAAAAA});
        itemBg.setGradientType(GradientDrawable.LINEAR_GRADIENT);
        itemBg.setShape(GradientDrawable.RECTANGLE);
        return itemBg;
    }


    private void doOkHttpRequest() {
        APIResult result = OkHttpProxy.doGet(Constants.API_GITHUB);
        if (result.getReturnCode() != OkHttpConstants.HTTP_REQUEST_RETURN_CODE_SUCCESS) {
            Log.d(TAG, "doOkHttpRequest: " + result.getStackTrace());
            return;
        }
        String responseText = result.getBody().toString();
        responseText = responseText.replace("{", "[").replace("}", "]");
        responseText = "{" + responseText.substring(1, responseText.length() - 1) + "}";
        Log.d(TAG, "doOkHttpRequest: response = " + responseText);
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(responseText);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Iterator keys = jsonObject.keys();
        String[] keyValues;
        while (keys.hasNext()) {
            String key = (String) keys.next();
            if (jsonObject.has(key)) {
                String value = jsonObject.optString(key);
                value = value.replace("[", "{").replace("]", "}");
                keyValues = new String[]{key, value};
                mAPIs.add(keyValues);
            }
        }
        updateListView();
    }

    private void updateListView() {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                mAPIAdapter.notifyDataSetChanged();
            }
        });
    }

    class APIAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mAPIs.size();
        }

        @Override
        public Object getItem(int position) {
            return mAPIs.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.api_item, parent, false);
                viewHolder = new ViewHolder();
                viewHolder.mURLKey = (TextView) convertView.findViewById(R.id.api_url_key);
                viewHolder.mURLValue = (TextView) convertView.findViewById(R.id.api_url_value);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            convertView.setBackground(createItemBackground());
            String[] keyVlaue = mAPIs.get(position);
            viewHolder.mURLKey.setText(keyVlaue[0]);
            viewHolder.mURLValue.setText(keyVlaue[1]);
            return convertView;
        }
    }

    class ViewHolder {
        TextView mURLKey;
        TextView mURLValue;
    }

}
