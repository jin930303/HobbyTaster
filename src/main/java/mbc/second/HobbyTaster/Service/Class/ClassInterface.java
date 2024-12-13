package mbc.second.HobbyTaster.Service.Class;

import java.time.LocalDate;

public interface ClassInterface {
    long getCnum();          // cclass
    String getCat1();        // cclass
    String getCat2();        // cclass
    String getCname();       // cclass
    int getCround();         // cclass
    String getCteach();      // cclass
    LocalDate getCdate();    // cclass
    String getCtime();       // cclass
    String getCminute();     // cclass
    String getCadd();        // cclass
    int getCpl();            // cclass
    String getCstate();      // cclass
    int getCcnt();           // cclass
    String getCmimage();     // cclass
    String getCdimage();     // cclass
    String getCdtext();      // cclass
    long getCprice();        // cclass

    String getMemberName();  // member.name
    String getMemberEmail(); // member.email
    String getMemberPhone(); // member.phone

    long getResnum();        // reserve
    String getResstate();    // reserve
}
