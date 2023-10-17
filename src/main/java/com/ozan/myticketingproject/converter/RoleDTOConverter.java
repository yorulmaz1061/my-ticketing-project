package com.ozan.myticketingproject.converter;

import com.ozan.myticketingproject.dto.RoleDTO;
import com.ozan.myticketingproject.service.RoleService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;

@Component
@ConfigurationPropertiesBinding
//Where this method will run?, spring is automatically will do it by this configuration above
//HTML is returning String, but Table is looking for RoleDTO object.That’s why we need converter interface.
//Source is String; Target is RoleDTO
public class RoleDTOConverter implements Converter<String, RoleDTO>{
    RoleService roleService;
    //injection
    public RoleDTOConverter(RoleService roleService) {
        this.roleService = roleService;
    }
    @Override
    public RoleDTO convert(String source) {
        //Unique description is Long overthere
        return roleService.findById(Long.parseLong(source));
    }
}




