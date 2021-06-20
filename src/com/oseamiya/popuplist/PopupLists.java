package com.oseamiya.popuplist;

import com.google.appinventor.components.runtime.*;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.runtime.util.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.errors.*;


import android.content.Context;
import android.content.Intent;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.graphics.Color;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;

import com.oseamiya.popuplist.PopupList;




@DesignerComponent(
    iconName = "",
    description = "This will help you to create popup list",
    version = 1,
    category = ComponentCategory.EXTENSION,
    nonVisible = true
)
@UsesLibraries(libraries= "")

@SimpleObject(external = true)

public class PopupLists extends AndroidNonvisibleComponent{
    private ComponentContainer container;
    private Context context;
    private Activity activity;
    private int indicatorHeight;
    private int indicatorWidth;
    private int normalBackgroundColor;
    private int pressedBackgroundColor;
    private int normalTextColor;
    private int backgroundTextColor;
    private int dividerColor;
    private int backgroundColorRadius;
    private int dividerHeight;
    private int dividerWidth;
    private float textSize;
    private int textpdleft;
    private int textpdright;
    private int textpaddingbutoom;
    private int textpaddingtop;

    
    public HashMap <String , List> hasId = new HashMap<>();
    

    public PopupLists(ComponentContainer container){
        super(container.$form());
        this.container = container;
        this.activity = (Activity)container.$context();
        this.context = container.$context();
        this.indicatorHeight = -123;
        this.indicatorWidth = -123;
        this.normalBackgroundColor = -123;
        this.pressedBackgroundColor = -123;
        this.normalTextColor = -123;
        this.backgroundTextColor = -123;
        this.dividerColor = -123;
        this.dividerHeight = -123;
        this.dividerWidth = -123;
        this.backgroundColorRadius = -123;
        this.textpdleft = -123;
        this.textpdright = -123;
        this.textpaddingbutoom = -123;
        this.textpaddingtop = -123;
        this.textSize = 1.23f;

    }

    @SimpleFunction(description = "")
    //android.widget.FrameLayout;
    //android.widget.LinearLayout
    public void Create(AndroidViewComponent view , YailList listitem , final String id ){
        if(hasId.containsKey(id)){
            throw new YailRuntimeError("Id already exists", "PopupLists");

        }else{
            String[] stringArray = listitem.toStringArray();
            final List a = Arrays.asList(stringArray);
            hasId.put(id, a);
            PopupList mpopUpList = new PopupList(this.context);
            
            if(this.indicatorHeight != -123 && this.indicatorWidth != -123){
                mpopUpList.setIndicatorSize(this.indicatorWidth , this.indicatorHeight);

            }
            if(this.normalBackgroundColor != -123){
                mpopUpList.setNormalBackgroundColor(this.normalBackgroundColor);
            }
            if(this.pressedBackgroundColor != -123){
                mpopUpList.setPressedBackgroundColor(this.pressedBackgroundColor);
            }
            if(this.normalTextColor != -123){
                mpopUpList.setNormalTextColor(this.normalTextColor);
            }
            if(this.backgroundTextColor != -123){
                mpopUpList.setPressedTextColor(this.backgroundTextColor);
            }
            if(this.dividerColor != -123){
                mpopUpList.setDividerColor(this.dividerColor);
            }
            if(this.dividerHeight != -123){
                mpopUpList.setDividerHeight(this.dividerHeight);

            }
            if(this.dividerWidth != -123){
                mpopUpList.setDividerWidth(this.dividerWidth);
            }
            if(this.backgroundColorRadius != -123){
                mpopUpList.setBackgroundCornerRadius(this.backgroundColorRadius);
            }
            if(this.textpdleft != -123){
                mpopUpList.setTextPaddingLeft(this.textpdleft);
            }
            if(this.textpdright != -123){
                mpopUpList.setTextPaddingRight(this.textpdright);
            }
            if(this.textpaddingtop != -123){
                mpopUpList.setTextPaddingTop(this.textpaddingtop);
            }
            if(this.textpaddingbutoom != -123){
                mpopUpList.setTextPaddingBottom(this.textpaddingbutoom);
            }
            if(this.textSize != 1.23f){
                mpopUpList.setTextSize(this.textSize);
            }

            mpopUpList.bind(view.getView() , a , new PopupList.PopupListListener(){
            @Override
            
            public boolean showPopupList(View adapterView, View contextView, int contextPosition) {
                return true;
            }
            @Override
           
            public void onPopupListClick(View contextView, int contextPosition, int position) {
                onPopupClick(id, a.get(position), position);
               
            }
        });

        }

        
    }
    @SimpleEvent(description = "This event is triggered when onPopupList is clicked")
    public void onPopupClick(String id , Object item, int position ){
        int realPosition = position +1;
        EventDispatcher.dispatchEvent(this , "onPopupClick" , new Object[] {id ,item , realPosition });
    }

    @SimpleFunction(description = "To get all the items associated with the id. It will return lists")
    public YailList GetAllItems(String id){
        
        return YailList.makeList(hasId.get(id));
    }

    @SimpleFunction
    public void IndicatorSize(int width , int height){
        this.indicatorWidth = width;
        this.indicatorHeight = height;

    }
    @SimpleProperty
    public void NormalBackgroundColor(int color){
        this.normalBackgroundColor = color;

    }
    @SimpleProperty
    public void PressedBackgroundColor(int color){
        this.pressedBackgroundColor = color;
    }
    @SimpleProperty
    public void NormalTextColor(int color){
        this.normalTextColor = color;
    }
    @SimpleProperty
    public void PressedTextColor(int color){
        this.backgroundTextColor = color;
    }
    @SimpleProperty
    public void DividerColor(int color){
        this.dividerColor = color;
    }
    @SimpleProperty
    public void DividerHeight(int height){
        this.dividerHeight = height;
    }
    @SimpleProperty
    public void DividerWidth(int width){
        this.dividerWidth = width;
    }
    @SimpleProperty
    public void TextSize(float textsize){
        this.textSize = textsize;
    }
    @SimpleProperty
    public void TextPaddingLeft(int value){
        this.textpdleft = value;
    }
    @SimpleProperty
    public void TextPaddingRight(int v){
        this.textpdright = v;
    }
    @SimpleProperty
    public void TextPaddingTop(int v){
        this.textpaddingtop = v;
    }
    @SimpleProperty
    public void TextPaddingButtom(int value){
        this.textpaddingbutoom = value;
    }
    @SimpleProperty
    public void BackgroundCornerRadius(int value){
        this.backgroundColorRadius = value;
    }





}
