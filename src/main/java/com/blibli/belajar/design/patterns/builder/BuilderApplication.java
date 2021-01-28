package com.blibli.belajar.design.patterns.builder;

import lombok.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class BuilderApplication {

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Mahasiswa {

        private String nim;
        private String nama;
        private String alamat;
        private Date tanggalLahir;
        @Singular("hobi")
        private List<String> hobi;
    }

    public static void main(String[] args) {

        Mahasiswa mahasiswa1 = new Mahasiswa();
        mahasiswa1.setNim("1234");
        mahasiswa1.setNama("Bryan");
        mahasiswa1.setAlamat("Indonesia");
        mahasiswa1.setTanggalLahir(new Date());
        mahasiswa1.setHobi(Arrays.asList("Game", "Coding"));


        Mahasiswa mahasiswa2 = Mahasiswa.builder()
                .nim("1234")
                .nama("Bryan")
                .alamat("Indonesia")
                .tanggalLahir(new Date())
//                .hobi(Arrays.asList("Game","Coding"))
                .hobi("Game")
                .hobi("Coding")
                .build();

        System.out.println(mahasiswa1);
        System.out.println(mahasiswa2);
    }
}
