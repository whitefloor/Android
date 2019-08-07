package com.ehappy.game_2048;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class gameView extends GridLayout {
    public gameView(Context context){
        super(context);
        initGame();
        startGame();
    }
    public gameView(Context context, AttributeSet attributeSet) {
        super(context,attributeSet);
        initGame();
        startGame();
    }
    public gameView(Context context,AttributeSet attributeSet, int defStyle) {
        super(context,attributeSet,defStyle);
        initGame();
        startGame();
    }

    public void initGame(){
        addCard(getCardWidth(),getCardWidth() );

        setColumnCount(4);
        setBackgroundColor(0xffbbada0);

        setOnTouchListener(new OnTouchListener() {
            private float startX,startY,setoffX,setoffY;
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch(motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        startX=motionEvent.getX();
                        startY=motionEvent.getY();
                        break;
                    case MotionEvent.ACTION_UP:
                        setoffX=motionEvent.getX()-startX;
                        setoffY=motionEvent.getY()-startY;

                        if(Math.abs(setoffX)>Math.abs(setoffY)){
                            if(setoffX<-5){
                                swipeLeft();
                            }else if(setoffX>5){
                                swipeRight();
                            }
                        }else if(Math.abs(setoffX)<Math.abs(setoffY)){
                            if(setoffY<-5){
                                swipeUp();
                            }else if(setoffY>5){
                                swipeDown();
                            }
                        }
                        break;
                }
                return true;
            }
        });

    }

    private void swipeLeft(){
        boolean judge = false;

        for (int y=0;y<4;y++){
            for(int x=0;x<4;x++){
                for(int x1=x+1;x1<4;x1++) {
                    if(cardMap[x1][y].getNum()>0){
                       if (cardMap[x][y].getNum() <= 0) {
                           cardMap[x][y].setNum(cardMap[x1][y].getNum());
                           cardMap[x1][y].setNum(0);
                           x--;
                           judge=true;
                       } else if (cardMap[x][y].getNum()==cardMap[x1][y].getNum()) {
                           cardMap[x][y].setNum(cardMap[x][y].getNum()*2);
                           cardMap[x1][y].setNum(0);
                           MainActivity.getMainActivity().addScore(cardMap[x][y].getNum());
                           judge=true;
                       }
                        break;
                    }
                }
            }
        }
        if(judge){
            addRandomNum();
        }
        checkOverGame();
    }
    private void swipeRight(){
        boolean judge = false;

        for (int y=0;y<4;y++){
            for(int x=3;x>0;x--){
                for(int x1=x-1;x1>=0;x1--){
                    if(cardMap[x1][y].getNum()>0){
                        if(cardMap[x][y].getNum()<=0){
                        cardMap[x][y].setNum(cardMap[x1][y].getNum());
                        cardMap[x1][y].setNum(0);
                        x++;
                        judge=true;
                    }else if(cardMap[x][y].getNum()==cardMap[x1][y].getNum()){
                        cardMap[x][y].setNum(cardMap[x][y].getNum()*2);
                        cardMap[x1][y].setNum(0);
                        MainActivity.getMainActivity().addScore(cardMap[x][y].getNum());
                        judge=true;
                        }
                        break;
                    }
                }
            }
        }
        if(judge){
            addRandomNum();
        }
        checkOverGame();
    }
    private void swipeUp(){
        boolean judge = false;

        for (int x=0;x<4;x++){
            for(int y=0;y<4;y++){
                for(int y1=y+1;y1<4;y1++){
                    if(cardMap[x][y1].getNum()>0){
                        if(cardMap[x][y].getNum()<=0){
                        cardMap[x][y].setNum(cardMap[x][y1].getNum());
                        cardMap[x][y1].setNum(0);
                        y--;
                        judge=true;
                    }else if(cardMap[x][y].getNum()==cardMap[x][y1].getNum()) {
                            cardMap[x][y].setNum(cardMap[x][y].getNum() * 2);
                            cardMap[x][y1].setNum(0);
                            MainActivity.getMainActivity().addScore(cardMap[x][y].getNum());
                            judge=true;
                        }
                        break;
                    }
                }
            }
        }
        if(judge){
            addRandomNum();
        }
        checkOverGame();
    }
    private void swipeDown(){
        boolean judge = false;

        for (int x=0;x<4;x++){
            for(int y=3;y>=0;y--){
                for(int y1=y-1;y1>=0;y1--){
                    if(cardMap[x][y1].getNum()>0){
                        if(cardMap[x][y].getNum()<=0){
                        cardMap[x][y].setNum(cardMap[x][y1].getNum());
                        cardMap[x][y1].setNum(0);
                        y++;
                        judge=true;
                    }else if(cardMap[x][y].getNum()==cardMap[x][y1].getNum()){
                        cardMap[x][y].setNum(cardMap[x][y].getNum()*2);
                        cardMap[x][y1].setNum(0);
                        MainActivity.getMainActivity().addScore(cardMap[x][y].getNum());
                        judge=true;
                       }
                        break;
                    }
                }
            }
        }
        if(judge){
            addRandomNum();
        }
        checkOverGame();
    }

    private void startGame(){
        for(int y=0;y<4;y++){
            for(int x=0;x<4;x++){
                cardMap[x][y].setNum(0);
            }
        }
        addRandomNum();
        addRandomNum();
    }
    /*private void cleanGame(){
        for(int y=0;y<4;y++){
            for(int x=0;x<4;x++){
                cardMap[x][y].setNum(0);
            }
        }
    }*/
    private void checkOverGame(){
        boolean overGame=true;
        ALL:
                for(int y=0;y<4;y++){
                    for(int x=0;x<4;x++){
                        if (cardMap[x][y].getNum()==0||
                                (x>0&&cardMap[x][y].aequals(cardMap[x-1][y]))||
                                (x<3&&cardMap[x][y].aequals(cardMap[x+1][y]))||
                                (y>0&&cardMap[x][y].aequals(cardMap[x][y-1]))||
                                (y<3&&cardMap[x][y].aequals(cardMap[x][y+1]))) {
                            overGame = false;
                            break ALL ;
                }
            }
        }
        if(overGame){
            new AlertDialog.Builder(getContext()).setTitle("Hello").setMessage("Game Over").setPositiveButton("ReStart", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    startGame();
                }
            }).show();
            MainActivity.getMainActivity().clearScore();
        }
    }

    private int getCardWidth(){
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int cardWidth =displayMetrics.widthPixels;
        return (cardWidth-10)/4;
    }

    private Card[][] cardMap = new Card[4][4];
    private List<Point> emptyPoint = new ArrayList<Point>();

    private void addCard(int cardWidth,int cardHeight){
        Card c ;
        for(int y=0;y<4;y++){
            for(int x=0;x<4;x++){
                c=new Card(getContext());
                c.setNum(0);
                addView(c,cardWidth,cardHeight);
                cardMap[x][y] = c;
            }
        }
    }
    private void addRandomNum(){
        emptyPoint.clear();
        for(int y=0;y<4;y++){
            for(int x=0;x<4;x++){
                if(cardMap[x][y].getNum()<=0){
                    emptyPoint.add(new Point(x,y));
                }
            }
        }
            Point p = emptyPoint.remove((int)(Math.random()*emptyPoint.size()));
            cardMap[p.x][p.y].setNum(Math.random()>0.1?2:4);
    }


}
