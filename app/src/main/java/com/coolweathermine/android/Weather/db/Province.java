package com.coolweathermine.android.Weather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by Tony on 2017/4/29.
 */

public class Province extends DataSupport {

    /**
     * id : 1
     * name : 北京
     */

    private int id;
    private String provinceName;
    private int provinceCode;

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public int getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(int provinceCode) {
        this.provinceCode = provinceCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
