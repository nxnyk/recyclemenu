package com.example.yinyu.recyclemenu;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<String> data=new ArrayList<String>();
    private Button addmenu;
    private Button deletemenu;
    recycleadapter recycleadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i=0;i<10;i++)
        {
            data.add("meun"+i);
        }
        recyclerView=findViewById(R.id.recyclemenu);
        addmenu=findViewById(R.id.addmenu);
        deletemenu=findViewById(R.id.deletemenu);
        recycleadapter=new recycleadapter(this,data);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setAdapter(recycleadapter);
        addmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i=data.size();
                Message message=handler.obtainMessage();
                Bundle bundle=new Bundle();
                bundle.putInt("addmenu",i);
                message.setData(bundle);
                message.what=0;
                handler.sendMessage(message);
            }
        });
        deletemenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i=data.size();
                Message message=handler.obtainMessage();
                Bundle bundle=new Bundle();
                bundle.putInt("deletemenu",i);
                message.setData(bundle);
                message.what=1;
                handler.sendMessage(message);
            }
        });
    }
    @SuppressLint("HandlerLeak")
    Handler handler=new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle bundle=msg.getData();
            switch (msg.what)
            {
                case 0:
                    int size=bundle.getInt("addmenu");
                    data.add("menu"+size);
                    recycleadapter.setdata(data);
                    break;
                case 1:
                    int getsize=bundle.getInt("deletemenu");
                    if(getsize>0)
                    {
                        int size2=getsize-1;
                        data.remove(size2);
                        recycleadapter.setdata(data);
                    }
                    else
                        {
                            Toast.makeText(getApplicationContext(),"菜单项已减少的最小",Toast.LENGTH_LONG).show();
                        }
                    break;

            }
        }
    };
}
