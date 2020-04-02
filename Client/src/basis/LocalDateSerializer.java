package com.company.basis;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.io.Serializable;
import java.time.LocalDate;

public class LocalDateSerializer extends XmlAdapter<String, LocalDate> implements Serializable {
    @Override
public java.time.LocalDate unmarshal(String v) throws Exception {
    return java.time.LocalDate.parse(v);
}

    @Override
    public String marshal(java.time.LocalDate v) throws Exception {
        return v.toString();
    }
}
