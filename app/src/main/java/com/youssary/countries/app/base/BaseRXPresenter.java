package com.youssary.countries.app.base;


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public abstract class BaseRXPresenter<V> extends BasePresenter<V>
{


    protected void startAsyncTask()
    {
        getObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getObserver());
    }

    private Observable<Boolean> getObservable()
    {
        return Observable.fromCallable(() -> doInBackground())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private Observer<Boolean> getObserver()
    {
        return new Observer<Boolean>()
        {

            @Override
            public void onSubscribe(Disposable d)
            {
                BaseRXPresenter.this.onSubscribe();
            }

            @Override
            public void onNext(Boolean value)
            {
            }

            @Override
            public void onError(Throwable e)
            {
                onErrorHandler(e);
            }

            @Override
            public void onComplete()
            {
                BaseRXPresenter.this.onComplete();
            }
        };
    }

    public abstract void onSubscribe();

    public abstract void onComplete();

    public abstract boolean doInBackground();

    public abstract void onErrorHandler(Throwable e);


}
