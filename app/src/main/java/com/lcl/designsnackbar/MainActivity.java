package com.lcl.designsnackbar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.lcl.designsnackbar.tsnackbar.TSnackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView myRecyclerView;
    private FloatingActionButton btnFloatingAction;
    private CoordinatorLayout layoutRoot;

    private List<String> contentList;
    private MyRecyclerViewAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myRecyclerView = (RecyclerView) findViewById(R.id.myRecyclerView);
        btnFloatingAction = (FloatingActionButton) findViewById(R.id.btnFloatingAction);
        layoutRoot = (CoordinatorLayout) findViewById(R.id.layoutRoot);
        initData();
        initEvent();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        contentList = new ArrayList<>();
        setListData();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        myRecyclerView.setLayoutManager(linearLayoutManager);
        myRecyclerView.setItemAnimator(new DefaultItemAnimator());
        myAdapter = new MyRecyclerViewAdapter(MainActivity.this, contentList);
        myRecyclerView.setAdapter(myAdapter);
    }

    /**
     * 初始化事件
     */
    private void initEvent() {
        myAdapter.setMyItemListener(new MyItemListener() {
            @Override
            public void onItemListener(View v, int position) {
                switch (position) {
                    case 0:
                        Snackbar.make(v, "这是一个简单的SnackBar-LENGTH_SHORT", Snackbar.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Snackbar.make(v, "这是一个简单的SnackBar-LENGTH_LONG", Snackbar.LENGTH_LONG).show();
                        break;
                    case 2:
                        Snackbar.make(v, "这是一个简单的SnackBar-LENGTH_INDEFINITE", Snackbar.LENGTH_INDEFINITE).show();
                        break;
                    case 3:
                        Snackbar.make(v, "带Action事件的SnackBar", Snackbar.LENGTH_INDEFINITE)
                                .setAction("点我", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //点击了按钮当前Snackbar自动消失
                                Snackbar.make(v, "点击了SnackBar按钮", Snackbar.LENGTH_SHORT).show();
                            }
                        }).show();
                        break;
                    case 4:
                        //默认字体颜色是<color name="colorAccent">#FF4081</color>
                        Snackbar.make(v, "更改SnackBar Action字体", Snackbar.LENGTH_INDEFINITE).setAction("点我", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //点击了按钮当前Snackbar自动消失
                                Snackbar.make(v, "点击了SnackBar按钮", Snackbar.LENGTH_SHORT).show();
                            }
                        }).setActionTextColor(Color.YELLOW).show();
                        break;
                    case 5:
                        //默认字体颜色是<color name="colorAccent">#FF4081</color>
                        Snackbar.make(v, "设置Duration的SnackBar", Snackbar.LENGTH_SHORT).setAction("点我", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //点击了按钮当前Snackbar自动消失
                                Snackbar.make(v, "点击了SnackBar按钮", Snackbar.LENGTH_SHORT).show();
                            }
                        }).setActionTextColor(Color.YELLOW).setDuration(4000).show();
                        break;
                    case 6:
                        Snackbar snackBar = Snackbar.make(v, "更改SnackBar的背景颜色", Snackbar.LENGTH_INDEFINITE).setAction("点我", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //点击了按钮当前Snackbar自动消失
                                Snackbar.make(v, "点击了SnackBar按钮", Snackbar.LENGTH_SHORT).show();
                            }
                        });
                        snackBar.getView().setBackgroundColor(Color.RED);
                        snackBar.show();
                        break;
                    case 7:
                        // mMessageView = (TextView) findViewById(R.id.snackbar_text);
                        // mActionView = (Button) findViewById(R.id.snackbar_action);
                        Snackbar snackBar7 = Snackbar.make(v, "更改SnackBar的背景颜色", Snackbar.LENGTH_INDEFINITE).setAction("点我", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //点击了按钮当前Snackbar自动消失
                                Snackbar.make(v, "点击了SnackBar按钮", Snackbar.LENGTH_SHORT).show();
                            }
                        });
                        snackBar7.getView().setBackgroundColor(Color.BLUE);
                        ((TextView) snackBar7.getView().findViewById(R.id.snackbar_text)).setTextColor(Color.YELLOW);
                        snackBar7.show();
                        break;
                    case 8:
                        Snackbar snackBar8 = Snackbar.make(layoutRoot, "触发SnackBar的View使用CoordinatorLayout", Snackbar.LENGTH_INDEFINITE).setAction("点我", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //点击了按钮当前Snackbar自动消失
                                Snackbar.make(v, "点击了SnackBar按钮", Snackbar.LENGTH_SHORT).show();
                            }
                        });
                        snackBar8.getView().setBackgroundColor(Color.BLUE);
                        ((TextView) snackBar8.getView().findViewById(R.id.snackbar_text)).setTextColor(Color.YELLOW);
                        snackBar8.show();
                        break;
                    case 9:
                        TSnackbar.make(v, "这是一个简单的TSnackBar-LENGTH_SHORT", TSnackbar.LENGTH_SHORT).show();
                        break;
                    case 10:
                        TSnackbar.make(v, "这是一个简单的TSnackBar-LENGTH_LONG", TSnackbar.LENGTH_LONG).show();
                        break;
                    case 11:
                        TSnackbar.make(v, "这是一个简单的TSnackBar-LENGTH_INDEFINITE", TSnackbar.LENGTH_INDEFINITE).show();
                        break;
                    case 12:
                        TSnackbar.make(v, "带Action事件的TSnackBar", TSnackbar.LENGTH_INDEFINITE).setAction("点我", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //点击了按钮当前Snackbar自动消失
                                TSnackbar.make(v, "点击了TSnackBar按钮", TSnackbar.LENGTH_SHORT).show();
                            }
                        }).show();
                        break;
                    case 13:
                        //默认字体颜色是<color name="colorAccent">#FF4081</color>
                        TSnackbar.make(v, "更改TSnackBar Action字体", TSnackbar.LENGTH_INDEFINITE).setAction("点我", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //点击了按钮当前Snackbar自动消失
                                TSnackbar.make(v, "点击了TSnackBar按钮", TSnackbar.LENGTH_SHORT).show();
                            }
                        }).setActionTextColor(Color.YELLOW).show();
                        break;
                    case 14:
                        //默认字体颜色是<color name="colorAccent">#FF4081</color>
                        TSnackbar.make(v, "设置Duration的TSnackBar", TSnackbar.LENGTH_INDEFINITE).setAction("点我", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //点击了按钮当前Snackbar自动消失
                                TSnackbar.make(v, "点击了TSnackBar按钮", TSnackbar.LENGTH_SHORT).show();
                            }
                        }).setActionTextColor(Color.YELLOW).setDuration(4000).show();
                        break;
                    case 15:
                        TSnackbar snackBar15 = TSnackbar.make(v, "更改TSnackBar的背景颜色", TSnackbar.LENGTH_INDEFINITE).setAction("点我", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //点击了按钮当前Snackbar自动消失
                                TSnackbar.make(v, "点击了TSnackBar按钮", TSnackbar.LENGTH_SHORT).show();
                            }
                        });
                        snackBar15.getView().setBackgroundColor(Color.RED);
                        snackBar15.show();
                        break;
                    case 16:
                        // mMessageView = (TextView) findViewById(R.id.snackbar_text);
                        // mActionView = (Button) findViewById(R.id.snackbar_action);
                        TSnackbar snackBar16 = TSnackbar.make(v, "更改TSnackBar的背景颜色", TSnackbar.LENGTH_INDEFINITE).setAction("点我", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //点击了按钮当前Snackbar自动消失
                                TSnackbar.make(v, "点击了TSnackBar按钮", TSnackbar.LENGTH_SHORT).show();
                            }
                        });
                        snackBar16.getView().setBackgroundColor(Color.BLUE);
                        ((TextView) snackBar16.getView().findViewById(R.id.snackbar_text)).setTextColor(Color.YELLOW);
                        snackBar16.show();
                        break;
                    case 17:
                        TSnackbar snackBar17 = TSnackbar.make(layoutRoot, "触发TSnackBar的View使用CoordinatorLayout", TSnackbar.LENGTH_INDEFINITE).setAction("点我", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //点击了按钮当前Snackbar自动消失
                                TSnackbar.make(v, "点击了TSnackBar按钮", TSnackbar.LENGTH_SHORT).show();
                            }
                        });
                        snackBar17.getView().setBackgroundColor(Color.BLUE);
                        ((TextView) snackBar17.getView().findViewById(R.id.snackbar_text)).setTextColor(Color.YELLOW);
                        snackBar17.show();
                        break;
                    default:
                        break;
                }
            }
        });

        btnFloatingAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackBar7 = Snackbar.make(v, "更改SnackBar的背景颜色", Snackbar.LENGTH_INDEFINITE).setAction("点我", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //点击了按钮当前Snackbar自动消失
                        Snackbar.make(v, "点击了SnackBar按钮", Snackbar.LENGTH_SHORT).show();
                    }
                });
                snackBar7.getView().setBackgroundColor(Color.BLUE);
                ((TextView) snackBar7.getView().findViewById(R.id.snackbar_text)).setTextColor(Color.YELLOW);
                snackBar7.show();
            }
        });
    }

    /**
     * 设置集合数据
     */
    private void setListData() {
        contentList.add("简单的SnackBar展示,显示时间短");
        contentList.add("简单的SnackBar展示,显示时间长");
        contentList.add("简单的SnackBar展示,显示时间不定时长");
        contentList.add("带Action事件的SnackBar");
        contentList.add("更改SnackBar Action字体");
        contentList.add("设置Duration的SnackBar");
        contentList.add("更改SnackBar的背景颜色");
        contentList.add("更改SnackBar的提示字体颜色");
        contentList.add("触发SnackBar的View使用CoordinatorLayout");

        contentList.add("简单的TSnackBar展示,显示时间短");
        contentList.add("简单的TSnackBar展示,显示时间长");
        contentList.add("简单的TSnackBar展示,显示时间不定时长");
        contentList.add("带Action事件的TSnackBar");
        contentList.add("更改TSnackBar Action字体");
        contentList.add("设置Duration的TSnackBar");
        contentList.add("更改TSnackBar的背景颜色");
        contentList.add("更改TSnackBar的提示字体颜色");
        contentList.add("触发TSnackBar的View使用CoordinatorLayout");
    }

    /**
     * 打印日志
     *
     * @param logStr
     */
    private void print(String logStr) {
        Log.d(TAG, logStr);
    }
}
