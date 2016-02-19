package com.example.zylo.chat_try;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.zylo.chat_try.ChatMessage;
import com.example.zylo.chat_try.R;

import java.util.ArrayList;
import java.util.List;

public class ChatArrayAdapter extends ArrayAdapter<ChatMessage> {
    public ImageView chatPicL;
    public ImageView chatPicR;
    private TextView chatText;
    private List<ChatMessage> MessageList = new ArrayList<ChatMessage>();
    private LinearLayout layout;
    public ChatArrayAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

        public void add(ChatMessage object) {
            // TODO Auto-generated method stub

            MessageList.add(object);
            super.add(object);
        }

    public int getCount()
    {
        return this.MessageList.size();
    }

    public ChatMessage getItem(int index){

        return this.MessageList.get(index);
    }

    public View getView(int position,View ConvertView, ViewGroup parent){

        View v = ConvertView;
        if(v==null){

            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v =inflater.inflate(R.layout.chat, parent,false);

        }

        // This section deals with setting up how the message objects in the list are displayed.
        layout = (LinearLayout)v.findViewById(R.id.Message1);
        ChatMessage messageobj = getItem(position);
        // Set Chat Text to chat.xml's message view
        chatText =(TextView)v.findViewById(R.id.SingleMessage);
        // This is the current fix for text spacing to work on the phone. We force the padding here to be correct. Still had problems though when doing transitions.
        chatText.setPadding(20,10,10,10);
        // set chatPicL and R to chat.xml's two image views.
        chatPicL =(ImageView)v.findViewById(R.id.SingleImage);
        chatPicR =(ImageView)v.findViewById(R.id.SingleImage2);
        chatText.setText(messageobj.message);
        // do a check of the side boolean if its left or right...
        // change text bubble to the correct bubble.
        chatText.setBackgroundResource(messageobj.left ? R.drawable.bubble1 : R.drawable.bubble2);

        //Turn on the appropriate images
        chatPicL.setImageResource(messageobj.left ? R.drawable.demopic : 0);
        chatPicR.setImageResource(messageobj.left ? 0 : R.drawable.demopic);

        // move the text to the correct side
        layout.setGravity(messageobj.left? Gravity.LEFT:Gravity.RIGHT);
        return v;
    }

    public Bitmap decodeToBitmap(byte[] decodedByte) {
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }


}
