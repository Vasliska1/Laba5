package com.company.basis;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;

public class WeDontKnowHowCallIt_Puzirek_V_Nashem_Serdce_Navsegda extends XmlAdapter<String, LocalDate> {
    @Override
public java.time.LocalDate unmarshal(String v) throws Exception {
    return java.time.LocalDate.parse(v);
}

    @Override
    public String marshal(java.time.LocalDate v) throws Exception {
        return v.toString();
    }
}