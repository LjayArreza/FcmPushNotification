# FcmPushNotification for Android
Firebase Cloud Messaging Push Notification with Php Api

## Push Notification for Android Library Features

- [x] Create Firebase Cloud Messaging for handle notification.
- [x] Display notification with title and message from Php API.
- [x] Check message data if it contains data. Then display the notification by getting title and message key from data.
- [x] Get the title and message from data and show the notification.
- [x] Custom design for notification.
- [x] Fitch the notification title and notification body then display the notification.
- [x] Create a intent which open the page when clicking the notification.
- [x] Create intent for clearing the previous page activity.
- [x] Create a channel id for android version greater than or equal to oreo then the android 8 notification will be handled by the channel.
- [x] Accessing device notification sound path.
- [x] Create an statement if android version is smaller than JellyBean it will show default notification else it will show the custom notification.
- [x] Create notification manages for displaying notification.
- [x] Create statement that if android version is greater than or equal to oreo the notification will be handled by the channel.
- [x] Sending notification via php file or sending notification to single device or topics.

## Push Notification PHP API Feature

- [x] Send notification to all devices.
- [x] Send notication to single device.

## PHP API Implementation

Step 1: Download [Xampp](https://www.apachefriends.org/download.html)

Step 2: Open Xampp and create "fcm" folder under htdocs folder.

Step 3: Copy and paste sendnotif.php under "fcm" folder.

Step 4: Run Xampp.

Step 5: Run on your browser to send a notification 
   - localhost/fcm/sendnotif.php?title=Your Notification Title&message=Your Notification Message

## Requirements

- [x] At least android studio version 3.0
- [x] Kotlin or Java

 ## Manual Implementation
 
 Step 1: Download the PushNotification.kt or PushNotification.java file
 
 Step 2: Download send.php file
 
 Step 3: Setup firebase cloud messaging on your android studio ( Open android studio > Tools > Firebase > Cloud Messaging )
  
 Step 4: Create android package and name it "FirebaseMessaging"
 
 Step 5: Drag or import the PushNotification.kt or PushNotification.java to FirebaseMessaging package.
 
 ## Important
 
 - [x] You need to setup firebase cloud messaging in your firebase app project.
 - [x] You need to setup firebase in your app first.

