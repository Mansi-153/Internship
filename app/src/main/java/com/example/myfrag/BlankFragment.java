package com.example.myfrag;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.myfrag.Adapter.RecyclerViewAdapter;
import com.example.myfrag.Adapter.example_item;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class BlankFragment extends Fragment{
    Button button,button1;
    View root;
    Fragment frag;
    private RequestQueue mQueue;
    TextView t1,t2,t3,t5,t6;
    ImageView imageView;
    String id;
    Button b1,b2;
    private RecyclerView mrecyclerview;
    private RecyclerViewAdapter mrecycleadapter;
    private RecyclerView.LayoutManager layoutManager;
    private String url= "https://api.github.com/users/akashsarkar188/followers";
    private RequestQueue mRequestQueue,mRequestQueue1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_blank, container, false);
        t1 = root.findViewById(R.id.textView2);
        t5 = root.findViewById(R.id.textView5);
        t2 = root.findViewById(R.id.textView3);
        t3 = root.findViewById(R.id.textView4);
        imageView = root.findViewById(R.id.imageView);
        b1=(Button)root.findViewById(R.id.button6);
        SpannableString content = new SpannableString("Followers");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        t5.setText(content);


        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendAndRequestResponse1();
            }
        });
        mQueue = Volley.newRequestQueue(getActivity());
        jsonParse();
        btn();
        return root;

    }

    public void btn(){
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+id));
                startActivity(browserIntent);
            }
        });
    }
    private void jsonParse() {

        String url = "https://api.github.com/users/akashsarkar188";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            String firstName = response.getString("name");
                            String age = response.getString("location");
                            String mail = response.getString("bio");
                            id = response.getString("blog");
                            String image=response.getString("avatar_url");
                            SpannableString content = new SpannableString(id);
                            content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
                            b1.setText(content);

                            Picasso.get().load(image).into(imageView);
                            t1.setText(firstName);
                            t2.setText(age);
                            t3.setText(mail);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(request);
    }
    private void sendAndRequestResponse1() {

        //RequestQueue initialized
        mRequestQueue = Volley.newRequestQueue(getActivity());

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        if (response != null) {
                            // Process the JSON
                            ArrayList<example_item> exampleList = new ArrayList<>();
                            try {
                                // Loop through the array elements
                                for (int i = 0; i < response.length(); i++) {
                                    JSONObject js = response.getJSONObject(i);
                                    String id = js.getString("id");


                                    String loginname = js.getString("login");

                                    String loginpic = js.getString("avatar_url");
                                    exampleList.add(new example_item(loginpic, loginname));

                                }

                                mrecyclerview = root.findViewById(R.id.recycler_view1);
                                mrecyclerview.setHasFixedSize(true);
                                layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
                                mrecycleadapter = new RecyclerViewAdapter(exampleList);
                                mrecyclerview.setLayoutManager(layoutManager);
                                mrecyclerview.setAdapter(mrecycleadapter);


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });
        mRequestQueue.add(jsonArrayRequest);
    }
}

