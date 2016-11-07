package com.example.edgar.achadoseperdidosunb;

/**
 * Created by edgar on 07/11/2016.
 */

public class ObjetoInfo {

    protected String mNome;
    protected String mDesc;
    protected String mDept;
    protected String mLocal;

    public ObjetoInfo(String nome, String desc, String dept, String local){
        this.mNome = nome;
        this.mDesc = desc;
        this.mDept = dept;
        this.mLocal = local;
    }

    public ObjetoInfo(String nome, String local){
        this.mNome = nome;
        this.mLocal = local;
    }

    public String getmNome() {
        return mNome;
    }

    public void setmNome(String mNome) {
        this.mNome = mNome;
    }

    public String getmDesc() {
        return mDesc;
    }

    public void setmDesc(String mDesc) {
        this.mDesc = mDesc;
    }

    public String getmDept() {
        return mDept;
    }

    public void setmDept(String mDept) {
        this.mDept = mDept;
    }

    public String getmLocal() {
        return mLocal;
    }

    public void setmLocal(String mLocal) {
        this.mLocal = mLocal;
    }
}