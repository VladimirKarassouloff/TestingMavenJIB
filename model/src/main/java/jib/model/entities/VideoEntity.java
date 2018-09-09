package jib.model.entities;

import jib.model.entities.AbstractEntity;
import jib.model.entities.AuthorEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder()
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "VIDEO")
public class VideoEntity extends AbstractEntity {

    private static final String COLUMN_NAME_NAME = "NAME";
    private static final String COLUMN_NAME_S3_KEY = "S3_KEY";
    public static final String COLUMN_NAME_AUTHOR_ID = "AUTHOR_ID";


    @Column(name = COLUMN_NAME_NAME)
    private String name;

    @Column(name = COLUMN_NAME_S3_KEY)
    private String s3Key;

    @ManyToOne
    @JoinColumn(name = COLUMN_NAME_AUTHOR_ID)
    private AuthorEntity author;

}
