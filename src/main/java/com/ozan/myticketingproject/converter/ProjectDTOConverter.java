package com.ozan.myticketingproject.converter;

import com.ozan.myticketingproject.dto.ProjectDTO;
import com.ozan.myticketingproject.service.ProjectService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class ProjectDTOConverter implements Converter<String, ProjectDTO> {
    ProjectService projectService;

        //injection
        public ProjectDTOConverter(ProjectService projectService) {
            this.projectService = projectService;
        }

        @Override
        public ProjectDTO convert(String source) {
            return projectService.findById(source);
        }

    }


