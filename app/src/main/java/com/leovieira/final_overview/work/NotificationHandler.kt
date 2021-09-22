package com.leovieira.final_overview.work

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.leovieira.final_overview.MainActivity
import com.leovieira.final_overview.R
import javax.inject.Inject

const val CHANNEL_ID = "CHANNEL_DOCS"

class NotificationHandler @Inject constructor(
    private val context: Context
){

    init {
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Expired docs"
            val descriptionText = "Going to notify users when docs has been expired"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun createPendingIntent(): PendingIntent {
        val intent = Intent(context, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        return PendingIntent.getActivity(context, 0, intent, 0)
    }


    fun buildNotification(title: String, message: String): Notification {
        var builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle(title)
            .setContentText(message)
            .setContentIntent(createPendingIntent())
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        return builder.build()
    }

}