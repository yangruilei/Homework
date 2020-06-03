package com.example.homework.base;

public class BasePre<V extends BaseView>  {
   public V view;
    public void bindView(V v){
        this.view= v;
    }
}
