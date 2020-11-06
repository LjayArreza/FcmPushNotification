<?php
$ch=curl_init("https://fcm.googleapis.com/fcm/sendnotif");
$header=array("Your content type here", "Authorization: key=YOUR_SERVER_KEY");

// send to all devices/topics
$data=json_encode(array("to"=>"/topics/allDevices","notification"=>array("title"=>$_REQUEST['title'], "message"=>$_REQUEST['message'])));


// for specific topic
// $data=json_encode(array("to"=>"YOUR_DEVICE_TOKEN","notification"=>array("title"=>$_REQUEST['title'], "message"=>$_REQUEST['message'])));


curl_setopt($ch, CURLOPT_HTTPHEADER, $header);
curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
curl_setopt($ch, CURLOPT_POST, 1);
curl_setopt($ch, CURLOPT_POSTFIELDS, $data);
curl_exec($ch);
