/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import dao.AdminDao;
import dao.AsuransiDao;
import dao.NasabahDao;

import entities.Admin;
import java.util.List;

/**
 *
 * @author Medina
 */
public class cek {
    public static void main(String[] args) {
////                List<Object> datas = new AdminDao().getAll();
//            for (Object data : datas) {
//                Admin a = (Admin) datas;
//                System.out.println(datas.size());
//            }
            System.out.println(new AsuransiDao().getAutoID());
            System.out.println(new NasabahDao().getAutoID());
    }
}
