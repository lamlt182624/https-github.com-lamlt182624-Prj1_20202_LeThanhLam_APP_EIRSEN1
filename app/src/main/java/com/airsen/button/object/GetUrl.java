package com.airsen.button.object;

import android.content.Context;

import com.airsen.button.fragment.slideshowFragment;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class GetUrl {

//    public static void GetUrlInformation(String url, Context context) {
//        RequestQueue requestQueue = Volley.newRequestQueue(context);
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
//                new Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//                        // Log.d("aaaaa",""+ response.toString());
//                        for (int i = 0; i < response.length(); i++) {
//                            try {
//                                JSONObject object = response.getJSONObject(i);
//                                //Log.d("loafurl", "" + object.toString());
//                                slideshowFragment.arrayListurl.add(new UrlInformation(
//                                        object.getInt("ID"),
//                                        object.getInt("Type"),
//                                        object.getString("Time"),
//                                        object.getString("Tittle"),
//                                        object.getString("Content"),
//                                        object.getString("Url")));
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//                            slideshowFragment.adapter.notifyDataSetChanged();
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//
//                    }
//                }
//        );
//        requestQueue.add(jsonArrayRequest);
//    }
//
//
}
