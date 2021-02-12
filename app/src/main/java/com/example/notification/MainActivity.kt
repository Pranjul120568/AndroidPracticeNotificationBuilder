package com.example.notification
import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*
@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nm =getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val channel=NotificationChannel("first","default",NotificationManager.IMPORTANCE_HIGH)
            channel.apply {
                enableLights(true)
                enableVibration(true)
            }
            nm.createNotificationChannel(channel)
        }
        button1.setOnClickListener {
               val builder= Notification.Builder(this, "first")
                    val simpleNotification=builder
                    .setContentTitle("Noti")
                    .setContentText("Hello Moto")
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setPriority(Notification.PRIORITY_MAX)
                    .build()
            nm.notify(1,simpleNotification)
        }
    }
}
        /*    val nm =getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            nm.createNotificationChannel(NotificationChannel("first","Default",NotificationManager.IMPORTANCE_DEFAULT))
        }
        button1.setOnClickListener {
            val simpleNotification=NotificationCompat.Builder(this,"first")
                    .setContentTitle("Noti")
                    .setContentText("Hello Moto")
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .build()
            nm.notify(1,simpleNotification)
        }
        button2.setOnClickListener {
            val i =Intent()
            i.action=Intent.ACTION_VIEW
            i.data= Uri.parse("https://www.google.com")
            val pi =PendingIntent.getActivity(this,123,i,PendingIntent.FLAG_UPDATE_CURRENT)

            val clickablenotification=NotificationCompat.Builder(this,"first")
                    .setContentTitle("Noti")
                    .setContentIntent(pi)
                    .setAutoCancel(true)
                    .setContentText("Hello Moto")
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .build()
            nm.notify(2,clickablenotification)
        }
        button3.setOnClickListener {
            val i =Intent()
            i.action=Intent.ACTION_VIEW
            i.data= Uri.parse("https://www.google.com")
            val pi =PendingIntent.getActivity(this,123,i,PendingIntent.FLAG_UPDATE_CURRENT)

            val clickablenotification=NotificationCompat.Builder(this,"first")
                    .setContentTitle("Noti")
                    .addAction(R.drawable.ic_launcher_foreground,"Click Me",pi)
                    .setAutoCancel(true)
                    .setContentText("Hello Moto")
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .build()
            nm.notify(3,clickablenotification)
        }
    }
}*/
