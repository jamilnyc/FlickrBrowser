package org.jamilnyc.flickrbrowser

import android.os.AsyncTask
import android.util.Log
import org.json.JSONObject

private val TAG = "GetFlickrJsonData"

// AsyncTask that accepts a JSON String, returns an ArrayList of Photos
// The progress parameter is not used, so it is void
class GetFlickrJsonData(private val listener: OnDataAvailable) : AsyncTask<String, Void, ArrayList<Photo>>() {

    interface OnDataAvailable {
        fun onDataAvailable(data: List<Photo>)
        fun onError(exception: Exception)
    }

    override fun doInBackground(vararg params: String?): ArrayList<Photo> {
        TODO("Not yet implemented")
        Log.d(TAG, "doInBackground() Starts")
        try {
            // Parse JSON response
            val jsonData = JSONObject(params[0])
            val itemsArray = jsonData.getJSONArray("items")

            // Extract each item in the array and dump the data into instances of Photo
            for (i in 0 until itemsArray.length()) {
                val jsonPhoto = itemsArray.getJSONObject(i)
                val title = jsonPhoto.getString("title")

            }
        } catch (e: Exception) {

        }
    }

    override fun onPostExecute(result: ArrayList<Photo>?) {
        Log.d(TAG, "onPostExecute() starts")
        super.onPostExecute(result)
    }
}