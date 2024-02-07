/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.tecdmx.tablerofirmas.utils;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;


public class VOUsuario extends User {

	private Integer idUsuario;
	private String email;
	private String idSession;
    
    public VOUsuario(Integer idUsuario, String username, String email, String idSession){
        super(username, "", new ArrayList<GrantedAuthority>());
        this.idUsuario = idUsuario;
        this.email = email;
        this.idSession = idSession;
    }

    public VOUsuario(String username, String password, Collection<? extends GrantedAuthority> authorities, Integer idUsuario, String email, String idSession) {
        super(username, password, authorities);
        this.idUsuario = idUsuario;
        this.email = email;
        this.idSession = idSession;

    }

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdSession() {
		return idSession;
	}

	public void setIdSession(String idSession) {
		this.idSession = idSession;
	}
    
}
