package com.lazyan.antechou.service;


import com.lazyan.antechou.mapper.TlistDao;
import com.lazyan.antechou.mapper.TtypeDao;
import com.lazyan.antechou.pojo.Tlist;
import com.lazyan.antechou.pojo.Ttype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService {
    @Autowired TlistDao tlistDao;
    @Autowired TtypeDao ttypeDao;

    //查询用户的账单信息
    public Object findAllByUid(int uid){
        return tlistDao.findAllByUid(uid);
    }

    //查询用户的分类信息
    public Object findAllTypeByUid(int uid){
        return ttypeDao.findAllTypeByUid(uid);
    }

    //新增一条账单记录
    public void insertNewTlist(Tlist tlist){
        tlistDao.insertNewTlist(tlist);
    }

    //新增一个分类信息
    public void insertNewTtype(Ttype ttype){
        ttypeDao.insertNewTtype(ttype);
    }

    //修改一条账单信息
    public void updateTlistById(Tlist tlist){
        tlistDao.updateTlistById(tlist);
    }

    //修改一个分类信息
    public void updateTtypeByid(Ttype ttype){
        ttypeDao.updateTtypeByid(ttype);
    }

    //删除一条账单信息
    public void deleteTlistByid(int id){
        tlistDao.deleteTlistByid(id);
    }

    //删除一个分类信息
    public void deleteTtypeByid(int id){
        ttypeDao.deleteTtypeByid(id);
    }

    //查询该用户分类的总数
    public int countTypeByUid(int uid){
        return ttypeDao.countTypeByUid(uid);
    }
}
