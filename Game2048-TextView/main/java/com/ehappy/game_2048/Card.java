package com.ehappy.game_2048;

import android.content.Context;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

public class Card extends FrameLayout {
    private TextView label;
    int num = 0;

    public Card(Context context) {
        super(context);
        label= new TextView(getContext());
        label.setTextSize(32);
        label.setGravity(Gravity.CENTER);
        label.setBackgroundColor(0X30FFFFFF);

        LayoutParams lp = new LayoutParams(-1,-1);
        lp.setMargins(20, 20 , 0, 0);
        setNum(0);
        addView(label,lp);
    }

    public int getNum(){
        return num;
    }
    public void setNum(int num){
        this.num = num;
        if(num<=0){
            label.setText("");
        }else{
            label.setText(num+"");
        }
    }

    public boolean aequals(Card o) {
        return getNum()==o.getNum();
    }
}
