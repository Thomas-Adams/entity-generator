
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.NoArgsConstructor;
    import lombok.experimental.SuperBuilder;
    import org.hibernate.envers.Audited;
    import javax.persistence.*;
    import javax.validation.constraints.NotNull;
    import javax.validation.constraints.Size;
    import java.util.ArrayList;
    import java.util.List;
    import java.io.Serializable;
    import java.time.Instant;
    import java.time.LocalDateTime;
    import java.util.Optional;
    import java.util.TimeZone;

    @Table(name="document")
    @Entity
class Document extends BaseEntity<Integer>{


            @Column(name="id", nullable = false )
        private Integer id;
                @Column(name="name", nullable = false , length = 2147483647 )
        private String name;
                @Column(name="description" )
        private String description;
                        @ManyToOne
        @JoinColumn(name="type", referencedColumnName="id"),
        private DocumentType TypeDocumentType;
                                @ManyToOne
        @JoinColumn(name="resource_id", referencedColumnName="id"),
        private Resource ResourceIdResource;
                        @Column(name="mime_type" , length = 2147483647 )
        private String mimeType;
                        @ManyToOne
        @JoinColumn(name="owner", referencedColumnName="username"),
        private User OwnerUser;
                        @Column(name="content" )
        private Byte[] content;
                @Column(name="version", nullable = false )
        private Integer version;
                @Column(name="created", nullable = false )
        private java.sql.Timestamp created;
                        @ManyToOne
        @JoinColumn(name="created_by", referencedColumnName="username"),
        private User CreatedByUser;
                        @Column(name="modified" )
        private java.sql.Timestamp modified;
                        @ManyToOne
        @JoinColumn(name="modified_by", referencedColumnName="username"),
        private User ModifiedByUser;
            

}
