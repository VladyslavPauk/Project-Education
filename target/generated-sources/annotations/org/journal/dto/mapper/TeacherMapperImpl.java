package org.journal.dto.mapper;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Generated;
import org.journal.dto.GroupDTO;
import org.journal.dto.LessonDTO;
import org.journal.dto.TeacherDTO;
import org.journal.model.Group;
import org.journal.model.Lesson;
import org.journal.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-09T16:47:10+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.2 (Oracle Corporation)"
)
@Component
public class TeacherMapperImpl implements TeacherMapper {

    @Autowired
    private GroupMapper groupMapper;
    @Autowired
    private LessonMapper lessonMapper;

    @Override
    public TeacherDTO toTeacherDTO(Teacher teacher) {
        if ( teacher == null ) {
            return null;
        }

        TeacherDTO teacherDTO = new TeacherDTO();

        teacherDTO.setId( teacher.getId() );
        teacherDTO.setName( teacher.getName() );
        teacherDTO.setSurname( teacher.getSurname() );
        teacherDTO.setEmail( teacher.getEmail() );
        teacherDTO.setPassword( teacher.getPassword() );

        return teacherDTO;
    }

    @Override
    public Map<GroupDTO, Set<LessonDTO>> toLessonsPerGroupDTO(Map<Group, Set<Lesson>> map) {
        if ( map == null ) {
            return null;
        }

        Map<GroupDTO, Set<LessonDTO>> map1 = new HashMap<GroupDTO, Set<LessonDTO>>( Math.max( (int) ( map.size() / .75f ) + 1, 16 ) );

        for ( java.util.Map.Entry<Group, Set<Lesson>> entry : map.entrySet() ) {
            GroupDTO key = groupMapper.toGroupDTOWithoutEntity( entry.getKey() );
            Set<LessonDTO> value = lessonMapper.toLessonDTOSet( entry.getValue() );
            map1.put( key, value );
        }

        return map1;
    }

    @Override
    public Teacher teacherDTotoTeacher(TeacherDTO teacherDTO) {
        if ( teacherDTO == null ) {
            return null;
        }

        Teacher teacher = new Teacher();

        teacher.setId( teacherDTO.getId() );
        teacher.setName( teacherDTO.getName() );
        teacher.setSurname( teacherDTO.getSurname() );
        teacher.setEmail( teacherDTO.getEmail() );
        teacher.setPassword( teacherDTO.getPassword() );

        return teacher;
    }
}
