package com.ozan.myticketingproject.converter;

import com.ozan.myticketingproject.dto.UserDTO;
import com.ozan.myticketingproject.service.UserService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class UserDTOConverter implements Converter<String,UserDTO>{
    UserService userService;

    public UserDTOConverter(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDTO convert(String source) {
        return userService.findById(source);
        //no need to make parsing since it is String
    }
}


