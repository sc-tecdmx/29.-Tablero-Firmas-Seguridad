/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.tecdmx.tablerofirmas.api.usuarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import mx.gob.tecdmx.tablerofirmas.api.menu.ResponseBodyMenu;
import mx.gob.tecdmx.tablerofirmas.api.menu.ServiceMenu;
import mx.gob.tecdmx.tablerofirmas.entity.inst.InstEmpleado;
import mx.gob.tecdmx.tablerofirmas.entity.seg.SegOrgUsuarios;
import mx.gob.tecdmx.tablerofirmas.repository.inst.InstEmpleadoRepository;
import mx.gob.tecdmx.tablerofirmas.repository.seg.SegOrgUsuariosRepository;
import mx.gob.tecdmx.tablerofirmas.utils.DTOResponse;



@Service
public class UserService implements UserDetailsService {

	@Autowired
	private SegOrgUsuariosRepository segOrgUsuariosRepository;
	
	@Autowired
	private InstEmpleadoRepository instEmpleadoRepository;
	
	@Autowired
	private ServiceMenu serviceMenu;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    	
    	Optional<SegOrgUsuarios> credentials = segOrgUsuariosRepository.findBysEmail(email);
    	if(!credentials.isPresent()) {
    		throw new UsernameNotFoundException(email);
    		
    	}

        SegOrgUsuarios user = credentials.get();

        List<GrantedAuthority> roles = new ArrayList();
        //Agregar aqui el rol o roles para esta aplicación.
        //roles.add(new SimpleGrantedAuthority("ADMIN"));
        UserDetails userDetail = new VOUsuario(user.getsUsuario(), user.getsContrasenia(), roles, user.getnIdUsuario(), user.getsEmail());
        
        return userDetail;
    }
    
    public DTOResponse userInfo(Authentication auth, DTOResponse response) {
    	VOUsuario usuarioVO = (VOUsuario) auth.getDetails();
    	Optional<SegOrgUsuarios> usuario = segOrgUsuariosRepository.findBysEmail(usuarioVO.getEmail());
    	if(usuario.isPresent()) {
    		DTOUserInfo userInfo = new DTOUserInfo();
    		userInfo.setUsuario(usuario.get().getsUsuario());
    		userInfo.setEmail(usuario.get().getsEmail());
    		userInfo.setIdUsuario(usuario.get().getnIdUsuario());
    		
    		Optional<InstEmpleado>  empleado = instEmpleadoRepository.findByIdUsuario(usuario.get());
            if(empleado.isPresent()) {
            	userInfo.setIdEmpleado(empleado.get().getId());
            	userInfo.setNombre(empleado.get().getNombre());
            	userInfo.setApellido1(empleado.get().getApellido1());
            	userInfo.setApellido2(empleado.get().getApellido2());
            }
            
            ResponseBodyMenu menu = serviceMenu.getMenu(auth);
            userInfo.setMenu(menu);
            
            response.setData(userInfo);
            response.setMessage("EL token es válido");
            response.setStatus("Success");
            return response;  
    	}
        response.setMessage("EL token es inválido");
        response.setStatus("Fail");
        return response;
    }
    
    
    
    

}
