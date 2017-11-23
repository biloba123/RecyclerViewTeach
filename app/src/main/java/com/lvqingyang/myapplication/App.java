package com.lvqingyang.myapplication;

/**
 * 一句话功能描述
 * 功能详细描述
 *
 * @author Lv Qingyang
 * @date 2017/11/23
 * @email biloba12345@gamil.com
 * @github https://github.com/biloba123
 * @blog https://biloba123.github.io/
 */
public class App {
    private int iconId;
    private String name;
    private String intro;

    public App(int iconId, String name, String intro) {
        this.iconId = iconId;
        this.name = name;
        this.intro = intro;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    @Override
    public String toString() {
        return "App{" +
                "iconId=" + iconId +
                ", name='" + name + '\'' +
                ", intro='" + intro + '\'' +
                '}';
    }
}
