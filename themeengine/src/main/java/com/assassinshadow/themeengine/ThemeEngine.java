package com.assassinshadow.themeengine;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.ImageViewCompat;



public class ThemeEngine {

    private static ThemeEngine mInstance;


    private String accent = "#00BCD4";
    private boolean dayMode = true;

    public void ThemeEngineInit (Context context)
    {
        mInstance =this;

        dayMode = SharedPreferencesAPI.getBoolean(context,Constants.dayMode);
        accent = SharedPreferencesAPI.getString(context,Constants.accentColor);
        if (accent.equals("")|| accent.isEmpty())
        {
            accent = "#00BCD4";
        }
    }

    public ThemeEngine(Context context)
    {
        dayMode = SharedPreferencesAPI.getBoolean(context,Constants.dayMode);
        accent = SharedPreferencesAPI.getString(context,Constants.accentColor);
        if (accent.equals("")|| accent.isEmpty())
        {
            accent = "#00BCD4";
        }

    }


    public void SetDarkMode(Context context)
    {
        SharedPreferencesAPI.setBoolean(context,Constants.dayMode, false);
    }

    public void SetDayMode(Context context)
    {
        SharedPreferencesAPI.setBoolean(context,Constants.dayMode, true);
    }
    public void SetAccentColor(Context context, String color)
    {
        if (!color.contains("#"))
        {
            Log.e("ThemeEngine", "Library only supports hex color");
            throw new RuntimeException("Library only supports hex color");
        }
        else {
            SharedPreferencesAPI.SetString(context, Constants.accentColor, color);
        }
    }


    public static synchronized ThemeEngine getInstance() {

        return mInstance;

    }


    public ThemeEngine TextViewTheme(TextView textView)
    {

        if (!dayMode)
        {
            textView.setTextColor(Color.parseColor("#eeeeee"));
        }

        return this;
    }

    public ThemeEngine TextViewTheme(EditText textView)
    {

        if (!dayMode)
        {
            textView.setTextColor(Color.parseColor("#eeeeee"));
        }
        return this;
    }

    public ThemeEngine TextViewLightTheme(TextView textView)
    {


        if (!dayMode)
        {
            textView.setTextColor(Color.parseColor("#9e9e9e"));
        }
        return this;
    }


    public ThemeEngine AccentViewTheme(AppCompatImageView imgView)
    {

        ImageViewCompat.setImageTintList(imgView, ColorStateList.valueOf(Color.parseColor(accent)));
        return this;
    }


    public ThemeEngine AccentViewTheme(View imgView)
    {

        imgView.setBackgroundColor(Color.parseColor(accent));
        return this;
    }


    public ThemeEngine AccentViewTheme(AppCompatButton imgView)
    {

        imgView.setSupportBackgroundTintList( ColorStateList.valueOf(Color.parseColor(accent)));
        return this;
    }



    public ThemeEngine AccentViewThemeDarken(AppCompatImageView imgView)
    {

        int color  = Color.parseColor(accent);

        float[] hsv = new float[3];


        Color.colorToHSV(color, hsv);
        hsv[2] *= 0.6f;

        color = Color.HSVToColor(hsv);

        ImageViewCompat.setImageTintList(imgView, ColorStateList.valueOf(color));

        return this;
    }


    public String GetDarkerAccent()
    {

        String secondaryTheme = accent;

        int color  = Color.parseColor(secondaryTheme);

        float[] hsv = new float[3];


        Color.colorToHSV(color, hsv);
        hsv[2] *= 0.6f;

        color = Color.HSVToColor(hsv);

        return String.format("#%06X", (0xFFFFFF & color));
    }

    public String GetSlightlyDarkerAccent()
    {

        int color  = Color.parseColor(accent);

        float[] hsv = new float[3];


        Color.colorToHSV(color, hsv);
        hsv[2] *= 0.8f;

        color = Color.HSVToColor(hsv);

        return String.format("#%06X", (0xFFFFFF & color));
    }
    public String GetALittleLighterAccent()
    {


        int color  = Color.parseColor(accent);

        float[] hsv = new float[3];


        Color.colorToHSV(color, hsv);
        hsv[2] *= 0.5f;

        color = Color.HSVToColor(hsv);



        return String.format("#%06X", (0xFFFFFF & color));
    }

    public String GetAccentButlilDark()
    {


        int color  = Color.parseColor(accent);

        float[] hsv = new float[3];


        Color.colorToHSV(color, hsv);
        hsv[2] *= 0.95f;

        color = Color.HSVToColor(hsv);



        return String.format("#%06X", (0xFFFFFF & color));

    }


    @SuppressLint("RestrictedApi")
    public ThemeEngine AccentViewThemeDarken(AppCompatButton imgView)
    {

        int color  = Color.parseColor(accent);

        float[] hsv = new float[3];


        Color.colorToHSV(color, hsv);
        hsv[2] *= 0.6f;

        color = Color.HSVToColor(hsv);

        imgView.setSupportBackgroundTintList( ColorStateList.valueOf(color));
        return this;
    }

    @SuppressLint("RestrictedApi")
    public ThemeEngine AccentViewThemeBg(AppCompatTextView imgView)
    {

        imgView.setSupportBackgroundTintList( ColorStateList.valueOf(Color.parseColor(accent)));
        return this;
    }
    @SuppressLint("RestrictedApi")
    public ThemeEngine GreyViewThemeBg(AppCompatTextView imgView)
    {

        imgView.setSupportBackgroundTintList( ColorStateList.valueOf(Color.parseColor("#9e9e9e")));
        return this;
    }

    public ThemeEngine AccentViewTheme(TextView imgView)
    {

        imgView.setTextColor(Color.parseColor(accent));
        return this;
    }
    public ThemeEngine AccentViewTheme(AppCompatTextView imgView)
    {

        imgView.setTextColor(Color.parseColor(accent));
        return this;
    }
    public ThemeEngine AccentViewTheme(ProgressBar imgView)
    {


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            imgView.setProgressTintList(ColorStateList.valueOf(Color.parseColor(accent)));
        }
        return this;
    }


    /**
     * Sets card theme to a linear/relative/frame/constraint etc layout or view.
     *
     * @param view The View.
     * @return builder
     */
    public ThemeEngine CardView(View view)
    {

        if (!dayMode)
        {
            view.setBackgroundResource(R.drawable.card_dark);
        }
        else
        {
            view.setBackgroundResource(R.drawable.card);
        }
        return this;
    }

    /**
     * Sets card theme to a linear/relative/frame/constraint etc layout or view.
     * This Card Theme should be used width as match_parent
     *
     * @param view The View.
     * @return ThemeEngine
     */
    public ThemeEngine CardViewFull(View view)
    {

        if (!dayMode)
        {
            view.setBackgroundResource(R.drawable.card_spread_dark);
        }
        else
        {
            view.setBackgroundResource(R.drawable.card_spread);
        }
        return this;
    }


    /**
     * Sets card theme to a linear/relative/frame/constraint etc layout or view.
     * This Card Theme is a variation of the regular card with a different coloring
     *
     * @param view The View.
     * @return ThemeEngine
     */
    public ThemeEngine CardViewT2(View view)
    {

        if (!dayMode)
        {
            view.setBackgroundResource(R.drawable.card_drk_t2);
        }
        else
        {
            view.setBackgroundResource(R.drawable.card_ash);
        }
        return this;
    }

    /**
     * Sets card theme to a linear/relative/frame/constraint etc layout or view.
     * This Card Theme is a variation of the regular card with a different coloring
     *
     * @param view The View.
     * @return ThemeEngine
     */
    public ThemeEngine CardViewT3(View view)
    {

        if (dayMode) {
            view.setBackgroundResource(R.drawable.card_litewhite);
        }
        else
        {
            view.setBackgroundResource(R.drawable.card_drk_t3);
        }

        return this;
    }


    /**
     * Sets card theme to a linear/relative/frame/constraint etc layout or view.
     * This Card Theme should be used width as match_parent (Light version only)
     *
     * @param view The View.
     * @return ThemeEngine
     */
    public ThemeEngine CardAshFull(View view)
    {

        if (dayMode) {
            view.setBackgroundResource(R.drawable.card_ash_spread);
        }


        return this;
    }


    /**
     * Sets card theme to a linear/relative/frame/constraint etc layout or view.
     * This Card Theme should be used width as match_parent (Light version only)
     *
     * @param view The View.
     * @return ThemeEngine
     */
    public ThemeEngine CardViewT2Full(View view)
    {

        if (dayMode) {
            view.setBackgroundResource(R.drawable.card_litewhite_spread);
        }


        return this;
    }


    public ThemeEngine AnimatedBg(View view)
    {

        TransitionDrawable transition = (TransitionDrawable) view.getBackground();
        transition.startTransition(2500);


        return this;
    }




    /**
     * Sets day/night mode background color to a view.
     *
     *
     * @param view The View.
     * @return ThemeEngine
     */
    public ThemeEngine BackgroundTheme(View view)
    {

        if (dayMode)
        {
            view.setBackgroundColor(Color.parseColor("#dedede"));
        }
        else
        {
            view.setBackgroundColor(Color.parseColor("#424242"));
        }
        return this;
    }

    /**
     * Sets day/night mode background color to a view.
     *  The instead of the regular theme, its #000000 and #ffffff
     *
     * @param view The View.
     * @return ThemeEngine
     */
    public ThemeEngine BackgroundThemeSharp(View view)
    {

        if (dayMode)
        {
            view.setBackgroundColor(Color.parseColor("#ffffff"));
        }
        else
        {
            view.setBackgroundColor(Color.parseColor("#000000"));
        }
        return this;
    }


    public static void ErrorTextView (TextView textView)
    {
        textView.setTextColor(Color.parseColor("#ff0000"));

    }

}
