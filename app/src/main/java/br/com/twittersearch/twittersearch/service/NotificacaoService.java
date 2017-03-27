package br.com.twittersearch.twittersearch.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by tawan on 3/18/17.
 */

public class NotificacaoService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        ScheduledThreadPoolExecutor pool =
                new ScheduledThreadPoolExecutor(1);
        long delayInicial = 0;
        long periodo = 10;
        TimeUnit unit = TimeUnit.MINUTES;
        pool.scheduleAtFixedRate(new NotificacaoTask(),
                delayInicial, periodo,unit);
        return START_STICKY;
    }
}
