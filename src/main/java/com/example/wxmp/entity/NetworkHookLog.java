package com.example.wxmp.entity;

import javax.persistence.*;
import java.util.Date;

@Entity()
@Table(name = "WX_NETWORK_HOOK_LOG")
public class NetworkHookLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "N_PK_ID")
    private Long id;
    @Column(name = "T_CRT_TM")
    private Date tCrtTm;
    @Column(name = "C_DOC_CHAR")
    private String cDocChar;

    // Getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date gettCrtTm() {
        return tCrtTm;
    }

    public void settCrtTm(Date tCrtTm) {
        this.tCrtTm = tCrtTm;
    }

    public String getcDocChar() {
        return cDocChar;
    }

    public void setcDocChar(String cDocChar) {
        this.cDocChar = cDocChar;
    }
}
