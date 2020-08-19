package com.lazyan.antechou.mapper;

import com.lazyan.antechou.pojo.Account;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AccountDao {
    //插入帐户
    @Insert("INSERT INTO account(mailbox,password) VALUES (#{mailbox},#{password})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertAccount(Account account);

    //根据邮箱查询账号
    @Select("SELECT * FROM account WHERE mailbox = #{mailbox}")
    Account findAccountMailboxByMailbox(@Param("mailbox") String mailbox);

    //根据邮箱查询账号
    @Select("SELECT * FROM account WHERE mailbox = #{mailbox} And password = #{password}")
    Account findAccountByMailboxAndPassword(@Param("mailbox") String mailbox,@Param("password") String password);

    //根据邮箱查询信息id
    @Select("SELECT id FROM account WHERE mailbox = #{mailbox}")
    int findAidByMailbox(@Param("mailbox") String mailbox);

    //根据邮箱修改最后登陆了ip
    @Update("UPDATE account SET lost_ip = #{lost_ip} WHERE mailbox = #{mailbox}")
    void updateAccountLost_ip(@Param("mailbox") String mailbox,@Param("lost_ip") String lost_ip);
}
