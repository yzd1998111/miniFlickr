package com.example.yuanzhendong.miniflickr;

import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

class recyclerItemClickListner extends RecyclerView.SimpleOnItemTouchListener {
    private static final String TAG = "recyclerItemClickListne";

    interface OnRecylerClickListner {
        void onItemClick(View view, int position);
        void OnItemLongClick(View view, int position);
    }

    private final OnRecylerClickListner mListner;
    private final GestureDetectorCompat mGestureDetector;

    public recyclerItemClickListner(Context context, final RecyclerView recyclerView, final OnRecylerClickListner mListner) {
        this.mListner = mListner;
        mGestureDetector = new GestureDetectorCompat(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                Log.d(TAG, "onSingleTapUp: starts");
                View childView = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
                if (childView != null && mListner != null) {
                    Log.d(TAG, "onSingleTapUp: ");
                    mListner.onItemClick(childView, recyclerView.getChildAdapterPosition(childView));
                }
                return true;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {
                Log.d(TAG, "onLongPress: starts");
                View childView = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
                if (childView != null && mListner != null) {
                    Log.d(TAG, "onLongPress: ");
                    mListner.OnItemLongClick(childView, recyclerView.getChildAdapterPosition(childView));
                }
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        Log.d(TAG, "onInterceptTouchEvent: starts");
        if (mGestureDetector != null) {
            boolean result = mGestureDetector.onTouchEvent(e);
            Log.d(TAG, "onInterceptTouchEvent: result" + result);
            return result;
        } else {
            Log.d(TAG, "onInterceptTouchEvent: return false");
            return false;
        }
    }
}
