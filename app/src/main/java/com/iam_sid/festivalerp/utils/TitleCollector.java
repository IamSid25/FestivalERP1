package com.iam_sid.festivalerp.utils;

import android.content.Context;

import com.iam_sid.festivalerp.activity.Dashboard;

public class TitleCollector {
        String titleName;
        public int titleImgId;

    public TitleCollector(Dashboard dashboard, String titleName, int titleImgId) {
        this.titleName = titleName;
        this.titleImgId = titleImgId;
    }


    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public Integer getTitleImgId() {
        return titleImgId;
    }

/*    String [] name={"History","Expenditure","Notice","Photos","Videos","Feedback"};
    String [] imgid={"R.drawable.ic_menu_feedback",
            "R.drawable.ic_menu_feedback",
            "R.drawable.ic_menu_feedback",
            "R.drawable.ic_menu_feedback",
            "R.drawable.ic_menu_feedback",
            "R.drawable.ic_menu_feedback",};*/

/*
    public TitleCollector(Context context) {
        this.context = context;
    }
*/

/*
    public ArrayList<TitleCollector> getTitleInfo(){
////     final ArrayList<TitleCollector> titleInfos=new ArrayList<>();
//
//     for(int index=0;index<name.length;index++)
//     {
//         setTitleName(name[index]);
//         setTitleImgId(imgid[index]);
//     }
//        return titleInfos;
//    }
*/
}
