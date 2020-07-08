package com.anastazijazivkovic.mome;

public class Task {
    private String text;
    private boolean checked;

    public Task(String text, boolean checked){
        this.text = text;
        this.checked = checked;
    }

    public void setText(String text){
        this.text = text;
    }

    public void setChecked(boolean state){
        checked = state;
    }

    public String getText(){
        return text;
    }

    public boolean getChecked(){
        return checked;
    }
}
