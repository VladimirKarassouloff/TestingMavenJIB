package jib.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "AUTHOR")
public class AuthorEntity extends AbstractEntity {

    private static final String COLUMN_NAME_NAME = "NAME";


    @Column(name = COLUMN_NAME_NAME)
    private String name;

    @OneToMany(mappedBy = "author")
    private List<VideoEntity> videos;

}
