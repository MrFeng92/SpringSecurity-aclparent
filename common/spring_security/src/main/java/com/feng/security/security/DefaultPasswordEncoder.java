package com.feng.security.security;

import com.feng.utils.utils.MD5;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DefaultPasswordEncoder implements PasswordEncoder
{
    public DefaultPasswordEncoder()
    {
        this(-1);
    }

    public DefaultPasswordEncoder(int strength)
    {
    }

    /**
     * 对字符串进行加密
     * @param charSequence
     * @return
     */
    @Override
    public String encode(CharSequence charSequence)
    {
        return MD5.encrypt(charSequence.toString());
    }

    /**
     * 密码比对
     * @param charSequence 原始密码
     * @param encodedPassword 加密密码
     * @return
     */
    @Override
    public boolean matches(CharSequence charSequence, String encodedPassword)
    {
        return encodedPassword.equals(MD5.encrypt(charSequence.toString()));
    }
}
