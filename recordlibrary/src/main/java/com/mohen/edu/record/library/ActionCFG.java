package com.mohen.edu.record.library;

/**
 * Created by Kenneth on 2017/10/10.
 */

public class ActionCFG {

    public static final int type_action = 30; //行为数据
    public static final int type_action_other = 300; // 未定义的行为，由前端自己设置字符串描述。
    public static final int type_action_hit = 301; //行为 点击屏幕 次数，力量
    public static final int type_action_app = 302; //行为 使用了app
    public static final int type_action_broad = 303; //行为 主动广播
    public static final int type_action_qiang = 304; //行为 进行了抢答行为（点击了就算）
    public static final int type_action_note = 305; //创建了笔记
    public static final int type_action_doc = 306; //打开了一个文档， 知识点，次数，阅读时间
    public static final int type_action_video = 307; //开始观看视频，知识点，次数，浏览时间
    public static final int type_action_photo = 308; //拍摄了一张照片
    public static final int type_action_photo_self = 309; //用前置镜头拍摄了一张照片
    public static final int type_action_everyday_test = 310;//行为 天天练
    public static final int type_action_write = 320; //进行了手写， 笔画，长度
    public static final int type_action_setting= 341; //进行了系统设置

    public static class Name{
        public static final String DOC = "文档";
        public static final String APP = "应用";
        public static final String VIDEO = "视频";
    }

    public static class Type{
        public static final int type_action_app = 302; //行为 使用了app
        public static final int type_action_doc = 306; //打开了一个文档， 知识点，次数，阅读时间
        public static final int type_action_video = 307; //开始观看视频，知识点，次数，浏览时间
    }

}
