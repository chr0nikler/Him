package com.him;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

public class TextMessageReceiver extends BroadcastReceiver{
	
	public void onReceive(Context context, Intent intent)
	{
		Bundle bundle=intent.getExtras();
		
		Object[] messages=(Object[])bundle.get("pdus");
		SmsMessage[] sms=new SmsMessage[messages.length];
		
		for(int n=0;n<messages.length;n++){
			sms[n]=SmsMessage.createFromPdu((byte[]) messages[n]);
		}
			
		for(SmsMessage msg:sms){
			MainActivity.updateMessageBox("\nFrom: "+msg.getOriginatingAddress()+"\n"+
					"Message: "+msg.getMessageBody()+"\n");
			if(msg.getMessageBody().equals("Hey man"))
			{
				System.out.println("Yo sup!");
			} else {
				System.out.println("SHIt");
			}
		}
	}
}