
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

    @Table(name="profile")
    @Entity
class Profile extends BaseEntity<Integer>{


            @Column(name="id", nullable = false )
        private Integer id;
                        @ManyToOne
        @JoinColumn(name="gender", referencedColumnName="id"),
        private Gender GenderGender;
                        @Column(name="givenname" , length = 2147483647 )
        private String givenname;
                @Column(name="surname" , length = 2147483647 )
        private String surname;
                @Column(name="email" , length = 2147483647 )
        private String email;
                
        @OneToOne
        @JoinColumn(name="user_id", referencedColumnName="id"),
        private User UserIdUser;
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
