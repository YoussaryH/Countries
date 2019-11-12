package com.youssary.countries.app.base;

import android.content.Context;
import android.os.Bundle;

import android.view.WindowManager;
import android.widget.Toast;

import com.youssary.countries.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


public abstract class BaseSimpleActivity extends AppCompatActivity
{
    public static String TAG;
    private SwipeRefreshLayout swRefresh;
    private boolean isFirstTime;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        initBaseActivity();
        setupActivityComponent();
    }

    private void initBaseActivity()
    {
        TAG = BaseSimpleActivity.class.getSimpleName();

        if (getWindow() != null) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        }
    }

    protected abstract void setupActivityComponent();

    public void setSwRefresh(SwipeRefreshLayout swRefresh, SwipeRefreshLayout.OnRefreshListener onRefreshListener)
    {
        this.swRefresh = swRefresh;
        initSwipeRefreshLayout(onRefreshListener);

    }

    private void initSwipeRefreshLayout(SwipeRefreshLayout.OnRefreshListener onRefreshListener)
    {
        swRefresh.setOnRefreshListener(onRefreshListener);
        swRefresh.setColorSchemeResources(R.color.colorAccent, R.color.colorAccent, R.color.colorAccent);
    }

    public void setFirstTime(boolean isFirstTime)
    {
        this.isFirstTime = isFirstTime;
    }

    public boolean isFirstTime()
    {
        return isFirstTime;
    }

    public void showAlert(String message, Context context)
    {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

}
