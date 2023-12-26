package com.photo.photogram.Config.auth;

import com.photo.photogram.DTO.UserDTO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Data
public class PrincipalDetails implements UserDetails {

    private static final long serialVersionUID = 1L;

    @Autowired
    private UserDTO userDTO;

    public PrincipalDetails(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public int getId(){
        return userDTO.getUsrId();
    }

    @Override
    public String getUsername() {
        return userDTO.getName();
    }

    @Override
    public String getPassword() {
        return userDTO.getPw();
    }

    // 권한 가지고 있는가
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(()->{return String.valueOf(userDTO.getMenuAuthorAt());});
        return collection;
    }

    public char getUseAt(){return userDTO.getUseAt();}
    public String getEmail(){return userDTO.getEmail();}

    public String getTel(){return userDTO.getTel();}

    public Date getRgsDate(){return userDTO.getRgsDate();}

    public String getRgsUsr(){return userDTO.getRgsUsr();}

    public Date getModDate(){return userDTO.getModDate();}

    public String getModUsr(){return userDTO.getModUsr();}



    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
