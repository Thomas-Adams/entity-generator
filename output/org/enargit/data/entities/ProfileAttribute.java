
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

    @Table(name="profile_attribute")
    @Entity
class ProfileAttribute extends BaseEntity<Integer>{


            @Column(name="id", nullable = false )
        private Integer id;
                        @ManyToOne
        @JoinColumn(name="profile_id", referencedColumnName="id"),
        private Profile ProfileIdProfile;
                                @ManyToOne
        @JoinColumn(name="attr_def_id", referencedColumnName="id"),
        private AttributeDefinition AttrDefIdAttributeDefinition;
                        @Column(name="string_value" , length = 2147483647 )
        private String stringValue;
                @Column(name="text_value" )
        private String textValue;
                @Column(name="int_value" )
        private Integer intValue;
                @Column(name="double_value" )
        private Double doubleValue;
                @Column(name="decimnal_value" )
        private numeric decimnalValue;
                @Column(name="date_value" )
        private java.sql.Timestamp dateValue;
                @Column(name="timestamp_value" )
        private java.sql.Timestamp timestampValue;
                @Column(name="boolean_value" )
        private Boolean booleanValue;
                        @ManyToOne
        @JoinColumn(name="selection_value", referencedColumnName="id"),
        private AttributeSelectionValue SelectionValueAttributeSelectionValue;
                                @ManyToOne
        @JoinColumn(name="multi_value", referencedColumnName="id"),
        private AttributeSelectionValue MultiValueAttributeSelectionValue;
                                @ManyToOne
        @JoinColumn(name="status", referencedColumnName="id"),
        private AttributeStatus StatusAttributeStatus;
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
