package com.lvqingyang.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<App> mAppList;
    private android.support.v7.widget.RecyclerView rvapp;
    private AppAdapter mAppAdapter;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.rvapp = (RecyclerView) findViewById(R.id.rv_app);

        initData();

        mAppAdapter=new AppAdapter(mAppList);
        rvapp.setAdapter(mAppAdapter);
        //添加分隔线
//        rvapp.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rvapp.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
    }

    private void initData() {
        mAppList=new ArrayList<>();
        mAppList.add(new App(R.mipmap.ic_app_neteasy_music, "网易云音乐",
                "网易云音乐相比于其他强运营的音乐产品，更多的引入了社交的元素，这东东做好了会非常好，特别是小编这种不知道听啥歌，也没有固定喜欢那个歌星的人尤其有用 @酷安小编"));
        mAppList.add(new App(R.mipmap.ic_app_qq, "QQ",
                "【本次更新】\n" +
                        "- 两人视频通话时可选择换脸挂件，聊天时脸部互换，喜感十足；\n" +
                        "- 聊天界面等核心场景的响应更快速，体验更流畅；\n" +
                        "- 修复部分场景下的兼容问题，提升用户体验；\n" +
                        "- 全面适配iOS11新特性。"));
        mAppList.add(new App(R.mipmap.ic_app_wechat, "微信",
                "微信已经变成一种生活方式，很多人都离不开吧，国内第一APP这个称号不为过。"));
        mAppList.add(new App(R.mipmap.ic_app_coolapk, "酷市场",
                "是不是感觉新版酷安更好玩了，没错，就是更好玩，我们其实是一个挂着应用市场的交友社区 @酷安小编"));
        mAppList.add(new App(R.mipmap.ic_app_neteasy_music, "网易云音乐",
                "网易云音乐相比于其他强运营的音乐产品，更多的引入了社交的元素，这东东做好了会非常好，特别是小编这种不知道听啥歌，也没有固定喜欢那个歌星的人尤其有用 @酷安小编"));
        mAppList.add(new App(R.mipmap.ic_app_qq, "QQ",
                "【本次更新】\n" +
                        "- 两人视频通话时可选择换脸挂件，聊天时脸部互换，喜感十足；\n" +
                        "- 聊天界面等核心场景的响应更快速，体验更流畅；\n" +
                        "- 修复部分场景下的兼容问题，提升用户体验；\n" +
                        "- 全面适配iOS11新特性。"));
        mAppList.add(new App(R.mipmap.ic_app_wechat, "微信",
                "微信已经变成一种生活方式，很多人都离不开吧，国内第一APP这个称号不为过。"));
        mAppList.add(new App(R.mipmap.ic_app_coolapk, "酷市场",
                "是不是感觉新版酷安更好玩了，没错，就是更好玩，我们其实是一个挂着应用市场的交友社区 @酷安小编"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()== R.id.item_add) {
            App app=(new App(R.mipmap.ic_app_coolapk, "酷市场",
                    "是不是感觉新版酷安更好玩了，没错，就是更好玩，我们其实是一个挂着应用市场的交友社区 @酷安小编"));
            addItem(app);
        }
        return super.onOptionsItemSelected(item);
    }


    //adapter
    public class AppAdapter extends RecyclerView.Adapter<AppAdapter.AppViewHolder>{
        private List<App> mApps;

        public AppAdapter(List<App> apps) {
            mApps = apps;
        }

        @Override
        public AppViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view=getLayoutInflater()
                    .inflate(R.layout.item_app_grid, null);
            return new AppViewHolder(view);
        }

        @Override
        public void onBindViewHolder(AppViewHolder holder, int position) {
            holder.bindApp(mApps.get(position));
        }

        @Override
        public int getItemCount() {
            return mApps.size();
        }



        public class AppViewHolder extends RecyclerView.ViewHolder{

            private android.widget.ImageView ivicon;
            private android.widget.TextView tvname;
//            private android.widget.TextView tvintro;
            private App mApp;

            public AppViewHolder(View itemView) {
                super(itemView);
//                this.tvintro = (TextView) itemView.findViewById(R.id.tv_intro);
                this.tvname = (TextView) itemView.findViewById(R.id.tv_name);
                this.ivicon = (ImageView) itemView.findViewById(R.id.iv_icon);

                itemView.findViewById(R.id.ll).setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("确认删除？")
                                .setMessage(mApp.getName())
                                .setNegativeButton(android.R.string.cancel, null)
                                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        //remove one item
                                        removeItem(mApp);
                                    }
                                })
                                .create()
                                .show();
                        return true;
                    }

                });

                itemView.findViewById(R.id.ll).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        itemChange(mApp);
                    }
                });
            }

            public void bindApp(App app){
                mApp=app;
                ivicon.setImageResource(app.getIconId());
                tvname.setText(app.getIntro());
//                tvintro.setText(app.getIntro());
            }
        }
    }

    private void itemChange(App app) {
        int pos=mAppList.indexOf(app);
        app.setIconId(R.mipmap.ic_launcher);

        mAppAdapter.notifyItemChanged(pos);
//        mAppAdapter.notifyDataSetChanged();
    }

    private void removeItem(App app) {
        //1. change data list
        int pos=mAppList.indexOf(app);
        mAppList.remove(pos);
        //2. notify adapter
        mAppAdapter.notifyItemRemoved(pos);
    }

    private void addItem(App app) {
        mAppList.add(0, app);
        mAppAdapter.notifyItemInserted(0);
    }

}
