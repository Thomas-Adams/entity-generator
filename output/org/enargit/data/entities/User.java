
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

    @Table(name="user")
    @Entity
class User extends BaseEntity<Integer>{


            @Column(name="id", nullable = false )
        private Integer id;
                @Column(name="username", nullable = false , length = 2147483647 )
        private String username;
                @Column(name="password", nullable = false , length = 2147483647 )
        private String password;
                @Column(name="email", nullable = false , length = 2147483647 )
        private String email;
                @Column(name="enabled" )
        private Boolean enabled;
                @Column(name="locked" )
        private Boolean locked;
                @Column(name="expired" )
        private Boolean expired;
                @Column(name="last_login" )
        private java.sql.Timestamp lastLogin;
                        @ManyToOne
        @JoinColumn(name="profile", referencedColumnName="id"),
        private Profile ProfileProfile;
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
            
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<AttributeCategory>  created_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<AttributeCategory>  modified_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<AttributeDefinition>  created_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<AttributeDefinition>  modified_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<AttributeSelectionList>  created_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<AttributeSelectionList>  modified_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<AttributeSelectionValue>  created_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<AttributeSelectionValue>  modified_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<AttributeStatus>  created_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<AttributeStatus>  modified_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<DataType>  created_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<DataType>  modified_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<Document>  owner username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<Document>  created_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<Document>  modified_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<DocumentAttribute>  created_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<DocumentAttribute>  modified_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<DocumentTags>  created_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<DocumentTags>  modified_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<DocumentType>  created_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<DocumentType>  modified_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<Gender>  created_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<Gender>  modified_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<Group>  created_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<Group>  modified_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<GroupRole>  created_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<GroupRole>  modified_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<ObjectType>  created_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<ObjectType>  modified_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<Permission>  created_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<Permission>  modified_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<PermissionResource>  created_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<PermissionResource>  modified_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<Profile>  user_id id;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<Profile>  created_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<Profile>  modified_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<ProfileAttribute>  created_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<ProfileAttribute>  modified_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<Resource>  created_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<Resource>  modified_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<Role>  created_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<Role>  modified_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<RolePermission>  created_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<RolePermission>  modified_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<Tag>  created_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<Tag>  modified_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<User>  created_by username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<User>  modified_by username;

}
