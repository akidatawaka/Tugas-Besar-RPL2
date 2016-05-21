package com.rpl.tugas.tugas_rpl2;

/**
 * Created by Akida on 21/05/2016.
 */
public class soal {
    private Integer no;
    private String soal;

    public soal() {
        super();
    }

    public soal(Integer no, String soal) {
        super();
        this.no = no;
        this.soal = soal;
    }

    public Integer getNo(){
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getSoal(){
        return soal;
    }

    public void setSoal(String soal){
        this.soal = soal;
    }

}
