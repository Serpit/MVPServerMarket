package com.itaem.serpit.baselibrary.widgets;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.itaem.serpit.baselibrary.R;



/*添加减少的控件*/

public class IncreaseAndReduceView extends FrameLayout implements View.OnClickListener {
    int position;
    ImageView add,sub;
    TextView tv_number;
    ModifyNumberListener modifyNumberListener;

    public IncreaseAndReduceView(Context context) {
        this(context,null);
    }

    public IncreaseAndReduceView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public IncreaseAndReduceView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }



    public void setModifyNumberListener(ModifyNumberListener modifyNumberListener){
        this.modifyNumberListener = modifyNumberListener;
    }
    public void init(){
        View rootView = LayoutInflater.from(getContext()).inflate(R.layout.add_sub_view_ayout,this,false);
        add = (ImageView) rootView.findViewById(R.id.add);
        sub = (ImageView) rootView.findViewById(R.id.sub);
        tv_number = (TextView) rootView.findViewById(R.id.number);
        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        addView(rootView);
    }


    int num;
    UpdateNumListener updateNumListener;
    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.add){
            addNum();
        }else if (v.getId()==R.id.sub){
            subNum();
        }

    }

    public void setPosition(int position){
        this.position = position;
    }
    private void addNum() {
        ++num;
        if (modifyNumberListener!=null){
            modifyNumberListener.doAdd(num,position);
        }
        tv_number.setText(num+"");
    }

    private void subNum() {
       num = (num -1 < 0) ? 0 : num-1;
       if (modifyNumberListener!=null){
           modifyNumberListener.doSub(num,position);
       }

       tv_number.setText(num+"");
    }

    public int getNum(){
        return num;
    }

    public void setUpdateNumListener(UpdateNumListener listener){
        updateNumListener = listener;
    }
    public static interface UpdateNumListener{
        public void updateNumber(int num);
    }

    public interface ModifyNumberListener{
        void doAdd(int num, int position);
        void doSub(int num, int position);
    }
}
